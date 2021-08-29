package e_icon.teamw.natureprotectors

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import e_icon.teamw.natureprotectors.databinding.ActivityGardenInfoBinding
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

var isGalleryMade = false

class GardenInfo : AppCompatActivity() {
    private val TAG = "DIP2K"
    private var m_imageFile: File? = null
    private val REQUEST_TAKE_PHOTO = 100
    private lateinit var binding: ActivityGardenInfoBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGardenInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gardenInfoGardenName.text = Prefs.infos.gardenInfoGetString("gardenName", "Nothing")

        if (Prefs.infos.gardenPlantsGetStringSet("gardenPlants", setOf())?.contains("tomato") == true){
            binding.gardenInfoGardenTomato.visibility = View.VISIBLE
        }
        if (Prefs.infos.gardenPlantsGetStringSet("gardenPlants", setOf())?.contains("potato") == true){
            binding.gardenInfoGardenPotato.visibility = View.VISIBLE
        }
        if (Prefs.infos.gardenPlantsGetStringSet("gardenPlants", setOf())?.contains("lettuce") == true){
            binding.gardenInfoGardenLettuce.visibility = View.VISIBLE
        }
        if (Prefs.infos.gardenPlantsGetStringSet("gardenPlants", setOf())?.contains("cherry") == true){
            binding.gardenInfoGardenCherry.visibility = View.VISIBLE
        }
        if (Prefs.infos.gardenPlantsGetStringSet("gardenPlants", setOf())?.contains("sunflower") == true){
            binding.gardenInfoGardenSunflower.visibility = View.VISIBLE
        }

        binding.gardenInfoBlueprintBtn.setOnClickListener {
            val gardenBlueprintIntent = Intent(this, GardenBlueprint::class.java)
            startActivity(gardenBlueprintIntent)
        }

        binding.gardenInfoGalleryBtn.setOnClickListener {
            if(isGalleryMade) {
                val galleryIntent = Intent(this, Gallery::class.java)
                startActivity(galleryIntent)
            }
            else {
                Toast.makeText(applicationContext, "You didn't made your gallery!", Toast.LENGTH_LONG).show()
            }
        }

        binding.gardenInfoSmartySaysTxt.text = "This is your garden information screen. You can picture your garden, goto gallery or blueprint of your garden."
        binding.gardenInfoGardeningTime.text = "Garden started : $gardenDate"

        isInGardenInfo = true
        supportFragmentManager.beginTransaction()
            .replace(R.id.garden_info_location, GoogleMapView())
            .commit()
        if(checkSelfPermission(Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_GRANTED
            && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_GRANTED) {
        } else {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
        }
        binding.gardenInfoCameraBtn.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if(takePictureIntent.resolveActivity(packageManager) != null) {
                createImageFile().let {
                    val photoURI = FileProvider.getUriForFile(this,
                        "e_icon.teamw.natureprotectors", it)
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
                    m_imageFile = it
                }
            }
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED
            && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "Permisson: " + permissions[0] + " was " + grantResults[0])
        }
    }
    @SuppressLint("SimpleDateFormat")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_TAKE_PHOTO) {
            if(resultCode == RESULT_OK) {
                m_imageFile?.let { it ->
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        val source = ImageDecoder.createSource(contentResolver, Uri.fromFile(it))
                        ImageDecoder.decodeBitmap(source).let {
                            galleryImgs.add(GalleryImgData(it, SimpleDateFormat("yyyyMMdd").format(
                                Date()
                            )))
                            Log.d("TAG", galleryImgs.toString())
                            goGallery()
                        }
                    } else {
                        MediaStore.Images.Media.getBitmap(contentResolver, Uri.fromFile(it))?.let {
                            galleryImgs.add(GalleryImgData(it, SimpleDateFormat("yyyyMMdd").format(
                                Date()
                            )))
                            Log.d("TAG", galleryImgs.toString())
                            goGallery()
                        }
                    }
                }
            }
        }
    }
    @SuppressLint("SimpleDateFormat")
    private fun createImageFile(): File {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "PHOTO_${timeStamp}.jpg"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File(storageDir, imageFileName)
    }

    fun goGallery() {
        val galleryIntent = Intent(this, Gallery::class.java)
        startActivity(galleryIntent)
    }
}