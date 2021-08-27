package e_icon.teamw.natureprotectors

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import e_icon.teamw.natureprotectors.databinding.ActivityGardenInfoBinding

class GardenInfo : AppCompatActivity() {
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

        binding.gardenInfoCameraBtn.setOnClickListener {
            val pictureIntent = Intent(this, Picture::class.java)
            startActivity(pictureIntent)
        }

        binding.gardenInfoBlueprintBtn.setOnClickListener {
            val gardenBlueprintIntent = Intent(this, GardenBlueprint::class.java)
            startActivity(gardenBlueprintIntent)
        }

        binding.gardenInfoSmartySaysTxt.text = "This is your garden information screen. You can picture your garden, goto gallery or blueprint of your garden."
        binding.gardenInfoGardeningTime.text = "Garden started : $gardenDate"

        isInGardenInfo = true
        supportFragmentManager.beginTransaction()
            .replace(R.id.garden_info_location, GoogleMapView())
            .commit()
    }
}