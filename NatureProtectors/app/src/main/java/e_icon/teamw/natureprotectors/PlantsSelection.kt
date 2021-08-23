package e_icon.teamw.natureprotectors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import e_icon.teamw.natureprotectors.databinding.ActivityPlantsSelectionBinding

private lateinit var binding: ActivityPlantsSelectionBinding
var gardenPlants = mutableListOf<String>()

class PlantsSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlantsSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        gardenPlants = mutableListOf()

        binding.plantsSelectionProgressPrev.setOnClickListener {
            val gardenRegistrationIntent = Intent(this, GardenRegistration::class.java)
            startActivity(gardenRegistrationIntent)
        }

        binding.plantsSelectionProgressNext.setOnClickListener {
            plantsSelection()
            if(gardenPlants.size == 0) {
                Toast.makeText(applicationContext, "You have to select at least one plant!", Toast.LENGTH_LONG).show()
            }
            else {
                val gardenBlueprintIntent = Intent(this, GardenBlueprint::class.java)
                startActivity(gardenBlueprintIntent)
            }
        }
    }

    private fun plantsSelection() {
        if (binding.plantsSelectionTomatoSelect.isChecked) {
            gardenPlants.add("tomato")
        }

        if (binding.plantsSelectionPotatoSelect.isChecked) {
            gardenPlants.add("potato")
        }

        if (binding.plantsSelectionLettuceSelect.isChecked) {
            gardenPlants.add("lettuce")
        }

        if (binding.plantsSelectionCherrySelect.isChecked) {
            gardenPlants.add("cherry")
        }

        if (binding.plantsSelectionSunflowerSelect.isChecked) {
            gardenPlants.add("sunflower")
        }
    }
}