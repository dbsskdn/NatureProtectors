package e_icon.teamw.natureprotectors

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import e_icon.teamw.natureprotectors.databinding.ActivityGardenInfoBinding

class GardenInfo : AppCompatActivity() {
    private lateinit var binding: ActivityGardenInfoBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGardenInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gardenInfoGardenName.text = gardenName

        gardenPlants.forEach {
            when (it) {
                "tomato" -> binding.gardenInfoGardenPlantsTomato.isVisible = true
                "potato" -> binding.gardenInfoGardenPlantsPotato.isVisible = true
                "lettuce" -> binding.gardenInfoGardenPlantsLettuce.isVisible = true
                "cherry" -> binding.gardenInfoGardenPlantsCherry.isVisible = true
                "sunflower" -> binding.gardenInfoGardenPlantsSunflower.isVisible = true
            }
        }

        binding.gardenInfoBlueprintBtn.setOnClickListener {
            val gardenBlueprintIntent = Intent(this, GardenBlueprint::class.java)
            startActivity(gardenBlueprintIntent)
        }


        binding.gardenInfoSmartySaysTxt.text = "This is your garden information screen. You can view location of your garden, plants in your garden, gallery pictures of your garden. You can also go to you garden blueprint."
    }
}