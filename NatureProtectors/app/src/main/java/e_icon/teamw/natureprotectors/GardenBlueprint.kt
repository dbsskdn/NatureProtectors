package e_icon.teamw.natureprotectors

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import e_icon.teamw.natureprotectors.databinding.ActivityGardenBlueprintBinding

private lateinit var binding: ActivityGardenBlueprintBinding
var guidelinePlant = ""

class GardenBlueprint : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGardenBlueprintBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gardenPlants.forEach {
            when (it) {
                "tomato" -> binding.gardenBlueprintDragPlantsTomato.isVisible = true
                "potato" -> binding.gardenBlueprintDragPlantsPotato.isVisible = true
                "lettuce" -> binding.gardenBlueprintDragPlantsLettuce.isVisible = true
                "cherry" -> binding.gardenBlueprintDragPlantsCherry.isVisible = true
                "sunflower" -> binding.gardenBlueprintDragPlantsSunflower.isVisible = true
            }
        }

        binding.gardenBlueprintProgressPrev.setOnClickListener {
            val plantsSelectionIntent = Intent(this, PlantsSelection::class.java)
            startActivity(plantsSelectionIntent)
        }

        binding.gardenBlueprintDragPlantsTomato.setOnClickListener {
            guidelinePlant = "tomato"
            goToGuideline()
        }

        binding.gardenBlueprintDragPlantsPotato.setOnClickListener {
            guidelinePlant = "potato"
            goToGuideline()
        }

        binding.gardenBlueprintDragPlantsLettuce.setOnClickListener {
            guidelinePlant = "lettuce"
            goToGuideline()
        }

        binding.gardenBlueprintDragPlantsCherry.setOnClickListener {
            guidelinePlant = "cherry"
            goToGuideline()
        }

        binding.gardenBlueprintDragPlantsSunflower.setOnClickListener {
            guidelinePlant = "sunflower"
            goToGuideline()
        }
    }

    private fun goToGuideline() {
        val growguidelineIntent = Intent(this, GrowGuideline::class.java)
        startActivity(growguidelineIntent)
    }
}