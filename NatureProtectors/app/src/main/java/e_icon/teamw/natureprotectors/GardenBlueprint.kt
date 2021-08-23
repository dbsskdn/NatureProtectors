package e_icon.teamw.natureprotectors

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import e_icon.teamw.natureprotectors.databinding.ActivityGardenBlueprintBinding

private lateinit var binding: ActivityGardenBlueprintBinding

class GardenBlueprint : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGardenBlueprintBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var gardenBlueprintGridColumn = 6
        var gardenBlueprintGridRow = 6

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


    }
}