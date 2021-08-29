package e_icon.teamw.natureprotectors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import e_icon.teamw.natureprotectors.databinding.ActivityGallerySpecificBinding

class GallerySpecific : AppCompatActivity() {
    private lateinit var binding: ActivityGallerySpecificBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityGallerySpecificBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.gallerySpecificImg.setImageBitmap(selectedImg)
        binding.textView.text = selectedDate

        binding.gallerySpecificImgDel.setOnClickListener {
            val delImage = GalleryImgData(selectedImg, selectedDate)
            galleryImgs.remove(delImage)
            val galleryIntent = Intent(this, Gallery::class.java)
            startActivity(galleryIntent)
        }

        binding.gallerySpecificBack.setOnClickListener {
            val galleryIntent = Intent(this, Gallery::class.java)
            startActivity(galleryIntent)
        }
    }
}