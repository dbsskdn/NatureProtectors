package e_icon.teamw.natureprotectors

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import e_icon.teamw.natureprotectors.databinding.ActivityGardenBlueprintBinding

private lateinit var binding: ActivityGardenBlueprintBinding
var guidelinePlant = ""
var blueprintTableRow = 6
var blueprintTableColumn = 6

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

        binding.gardenBlueprintGridIncreaseRow.setOnClickListener {
            if (blueprintTableRow == 6){
                Toast.makeText(applicationContext, "The row can be added up to 6!", Toast.LENGTH_LONG).show()
            }
            else {
                blueprintTableRow += 1
                controlTableRow()
            }
        }

        binding.gardenBlueprintGridDeclineRow.setOnClickListener {
            if (blueprintTableRow == 1){
                Toast.makeText(applicationContext, "The row can be removed up to 1!", Toast.LENGTH_LONG).show()
            }
            else {
                blueprintTableRow -= 1
                controlTableRow()
            }
        }

        binding.gardenBlueprintGridIncreaseColumn.setOnClickListener {
            if (blueprintTableColumn == 6){
                Toast.makeText(applicationContext, "The column can be added up to 6!", Toast.LENGTH_LONG).show()
            }
            else {
                blueprintTableColumn += 1
                controlTableColumn()
            }
        }

        binding.gardenBlueprintGridDeclineColumn.setOnClickListener {
            if (blueprintTableColumn == 1){
                Toast.makeText(applicationContext, "The column can be removed up to 1!", Toast.LENGTH_LONG).show()
            }
            else {
                blueprintTableColumn -= 1
                controlTableColumn()
            }
        }

        binding.gardenBlueprintDragPlantsTomato.setOnLongClickListener {
            guidelinePlant = "tomato"
            goToGuideline()
        }

        binding.gardenBlueprintDragPlantsPotato.setOnLongClickListener {
            guidelinePlant = "potato"
            goToGuideline()
        }

        binding.gardenBlueprintDragPlantsLettuce.setOnLongClickListener {
            guidelinePlant = "lettuce"
            goToGuideline()
        }

        binding.gardenBlueprintDragPlantsCherry.setOnLongClickListener {
            guidelinePlant = "cherry"
            goToGuideline()
        }

        binding.gardenBlueprintDragPlantsSunflower.setOnLongClickListener {
            guidelinePlant = "sunflower"
            goToGuideline()
        }
    }

    private fun goToGuideline(): Boolean {
        val growguidelineIntent = Intent(this, GrowGuideline::class.java)
        startActivity(growguidelineIntent)
        return false
    }

    private fun controlTableRow() {
        binding.gardenBlueprintBlueprintTableRow1.visibility = View.GONE
        binding.gardenBlueprintBlueprintTableRow2.visibility = View.GONE
        binding.gardenBlueprintBlueprintTableRow3.visibility = View.GONE
        binding.gardenBlueprintBlueprintTableRow4.visibility = View.GONE
        binding.gardenBlueprintBlueprintTableRow5.visibility = View.GONE
        binding.gardenBlueprintBlueprintTableRow6.visibility = View.GONE

        when (blueprintTableRow){
            1 -> binding.gardenBlueprintBlueprintTableRow6.visibility = View.VISIBLE
            2 -> {
                binding.gardenBlueprintBlueprintTableRow1.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow2.visibility = View.VISIBLE
            }
            3 -> {
                binding.gardenBlueprintBlueprintTableRow1.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow2.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow3.visibility = View.VISIBLE
            }
            4 -> {
                binding.gardenBlueprintBlueprintTableRow1.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow2.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow3.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow4.visibility = View.VISIBLE
            }
            5 -> {
                binding.gardenBlueprintBlueprintTableRow1.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow2.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow3.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow4.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow5.visibility = View.VISIBLE
            }
            6 -> {
                binding.gardenBlueprintBlueprintTableRow1.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow2.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow3.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow4.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow5.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow6.visibility = View.VISIBLE
            }
        }
    }

    private fun controlTableColumn() {
        binding.gardenBlueprintBlueprintTableRow1.visibility = View.GONE
        binding.gardenBlueprintBlueprintTableRow2.visibility = View.GONE
        binding.gardenBlueprintBlueprintTableRow3.visibility = View.GONE
        binding.gardenBlueprintBlueprintTableRow4.visibility = View.GONE
        binding.gardenBlueprintBlueprintTableRow5.visibility = View.GONE
        binding.gardenBlueprintBlueprintTableRow6.visibility = View.GONE

        when (blueprintTableColumn) {
            6 -> {
                binding.gardenBlueprintBlueprintTableRow1.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow2.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow3.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow4.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow5.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow6.visibility = View.VISIBLE
            }
            5 -> {
                binding.gardenBlueprintBlueprintTableRow1.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow2.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow3.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow4.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTableRow5.visibility = View.VISIBLE
                binding.gardenBlueprintBlueprintTable.setColumnShrinkable(5, true)
            }
        }
    }
}