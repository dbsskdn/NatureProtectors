package e_icon.teamw.natureprotectors

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

        if (Prefs.infos.gardenRegisterGetBool("isGardenRegistered", false)) {
            binding.gardenBlueprintProgressText.text = Prefs.infos.gardenInfoGetString("gardenName", gardenName)
            binding.gardenBlueprintProgressNext.visibility = View.GONE
        }

        if (Prefs.infos.gardenPlantsGetStringSet("gardenPlants", setOf())?.contains("tomato") == true){
            binding.gardenBlueprintDragPlantsTomato.visibility = View.VISIBLE
        }
        if (Prefs.infos.gardenPlantsGetStringSet("gardenPlants", setOf())?.contains("potato") == true){
            binding.gardenBlueprintDragPlantsPotato.visibility = View.VISIBLE
        }
        if (Prefs.infos.gardenPlantsGetStringSet("gardenPlants", setOf())?.contains("lettuce") == true){
            binding.gardenBlueprintDragPlantsLettuce.visibility = View.VISIBLE
        }
        if (Prefs.infos.gardenPlantsGetStringSet("gardenPlants", setOf())?.contains("cherry") == true){
            binding.gardenBlueprintDragPlantsCherry.visibility = View.VISIBLE
        }
        if (Prefs.infos.gardenPlantsGetStringSet("gardenPlants", setOf())?.contains("sunflower") == true){
            binding.gardenBlueprintDragPlantsSunflower.visibility = View.VISIBLE
        }

        binding.gardenBlueprintProgressPrev.setOnClickListener {
            if (Prefs.infos.gardenRegisterGetBool("isGardenRegistered", false)) {
                val gardenInfoIntent = Intent(this, GardenInfo::class.java)
                startActivity(gardenInfoIntent)
            }
            else {
                val plantsSelectionIntent = Intent(this, PlantsSelection::class.java)
                startActivity(plantsSelectionIntent)
            }
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
            Prefs.infos.gardenRegisterSetBool("isGardenRegistered", true)
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