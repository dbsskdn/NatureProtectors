package e_icon.teamw.natureprotectors

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import e_icon.teamw.natureprotectors.data.Datasource
import e_icon.teamw.natureprotectors.adapter.ItemAdapter
import e_icon.teamw.natureprotectors.databinding.ActivityGardenBlueprintBinding

private lateinit var binding: ActivityGardenBlueprintBinding
var guidelinePlant = ""
private var numOfItems = 36
private var numRows = 6
private var numCols = 6
private var spanCount = 6

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

        updateTable()

        binding.gardenBlueprintGridDeclineRow.setOnClickListener {
            if(numRows > 1){
                numRows--
                numOfItems -= numCols
                updateTable()
            }
            else {
                Toast.makeText(applicationContext, "The row can deleted up to 1!", Toast.LENGTH_LONG).show()
            }
        }

        binding.gardenBlueprintGridIncreaseRow.setOnClickListener {
            if(numRows < 6) {
                numRows++
                numOfItems += numCols
                updateTable()
            }
            else {
                Toast.makeText(applicationContext, "The row can added up to 6!", Toast.LENGTH_LONG).show()
            }
        }

        binding.gardenBlueprintGridIncreaseColumn.setOnClickListener {
            if(numCols < 6 && spanCount < 6){
                numCols++
                numOfItems += numRows
                spanCount++
                updateTable()
            }
            else {
                Toast.makeText(applicationContext, "The column can added up to 6!", Toast.LENGTH_LONG).show()
            }
        }

        binding.gardenBlueprintGridDeclineColumn.setOnClickListener {
            if(numCols > 1 && spanCount > 1){
                numCols--
                numOfItems -= numRows
                spanCount--
                updateTable()
            }
            else {
                Toast.makeText(applicationContext, "The column can deleted up to 1!", Toast.LENGTH_LONG).show()
            }
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

        binding.gardenBlueprintProgressNext.setOnClickListener {
            val gardenInfoIntent = Intent(this, GardenInfo::class.java)
            startActivity(gardenInfoIntent)
        }
    }

    private fun goToGuideline(): Boolean {
        val growguidelineIntent = Intent(this, GrowGuideline::class.java)
        startActivity(growguidelineIntent)
        return false
    }

    private fun updateTable() {
        val myDataset = Datasource().loadAffirmations(numOfItems) // Initialize data

        val recyclerView = binding.recyclerView
        recyclerView.isNestedScrollingEnabled = false
        recyclerView.overScrollMode = View.OVER_SCROLL_NEVER
        recyclerView.adapter = ItemAdapter(this, myDataset)
        (recyclerView.layoutManager as GridLayoutManager).spanCount = spanCount
        recyclerView.adapter = ItemAdapter(this, myDataset)
    }
}