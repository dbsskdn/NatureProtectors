package e_icon.teamw.natureprotectors

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import e_icon.teamw.natureprotectors.adapter.ItemAdapter
import e_icon.teamw.natureprotectors.adapter.position
import e_icon.teamw.natureprotectors.data.Datasource
import java.time.LocalDate
import e_icon.teamw.natureprotectors.databinding.ActivityGardenBlueprintBinding

private lateinit var binding: ActivityGardenBlueprintBinding
var guidelinePlant = ""
private var numRows = 6
private var numCols = 6
private var spanCount = 6
var blueprintPlants = mutableListOf(
    "none", "none", "none", "none", "none", "none",
    "none", "none", "none", "none", "none", "none",
    "none", "none", "none", "none", "none", "none",
    "none", "none", "none", "none", "none", "none",
    "none", "none", "none", "none", "none", "none",
    "none", "none", "none", "none", "none", "none")
@RequiresApi(Build.VERSION_CODES.O)
var gardenDate: LocalDate = LocalDate.now()

class GardenBlueprint : AppCompatActivity() {
    private lateinit var tableItemClickAdapter: ItemAdapter

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGardenBlueprintBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        binding.gardenBlueprintGridIncreaseRow.setOnClickListener {
            if (numRows < 6) {
                numRows ++
                val addList: MutableList<String> = mutableListOf()
                for (i: Int in 1..numCols){
                    addList += "none"
                }
                blueprintPlants.addAll(addList)
                updateTable()
                blueprintEdit()
            }
            else {
                Toast.makeText(applicationContext, "The row can be added up to 6!", Toast.LENGTH_LONG).show()
                blueprintEdit()
            }
        }

        binding.gardenBlueprintGridDeclineRow.setOnClickListener {
            if (numRows > 1) {
                numRows --
                for (i: Int in 1..numCols){
                    blueprintPlants.removeAt(numRows * numCols)
                }
                updateTable()
                blueprintEdit()
            }
            else {
                Toast.makeText(applicationContext, "The row can be removed up to 1!", Toast.LENGTH_LONG).show()
                blueprintEdit()
            }
        }

        binding.gardenBlueprintGridIncreaseColumn.setOnClickListener {
            if (numCols < 6 && spanCount < 6) {
                numCols ++
                spanCount ++
                for (i: Int in 1..numRows) {
                    blueprintPlants.add((numCols * i) - i, "none")
                }
                updateTable()
                blueprintEdit()
            }
            else {
                Toast.makeText(applicationContext, "The column can be added up to 6!", Toast.LENGTH_LONG).show()
                blueprintEdit()
            }
        }

        binding.gardenBlueprintGridDeclineColumn.setOnClickListener {
            if (numCols > 1 && spanCount > 1) {
                numCols --
                spanCount --
                for (i: Int in 1..numRows){
                    blueprintPlants.removeAt(i * numCols)
                }
                updateTable()
                blueprintEdit()
            }
            else {
                Toast.makeText(applicationContext, "The column can be removed up to 1!", Toast.LENGTH_LONG).show()
                blueprintEdit()
            }
        }

        updateTable()

        tableItemClickAdapter.onItemClickListener = {
            binding.gardenBlueprintAddItems.visibility = View.VISIBLE
            binding.gardenBlueprintAddItemBg.visibility = View.VISIBLE
        }

        binding.gardenBlueprintAddTomato.setOnClickListener {
            blueprintPlants[position] = "tomato"
            updateTable()
        }

        binding.gardenBlueprintAddPotato.setOnClickListener {
            blueprintPlants[position] = "potato"
            updateTable()
        }

        binding.gardenBlueprintAddLettuce.setOnClickListener {
            blueprintPlants[position] = "lettuce"
            updateTable()
        }

        binding.gardenBlueprintAddCherry.setOnClickListener {
            blueprintPlants[position] = "cherry"
            updateTable()
        }

        binding.gardenBlueprintAddSunflower.setOnClickListener {
            blueprintPlants[position] = "sunflower"
            updateTable()
        }

        binding.gardenBlueprintRemove.setOnClickListener {
            blueprintPlants[position] = "none"
            updateTable()
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

        if (Prefs.infos.gardenRegisterGetBool("isGardenRegistered", false)) {
            binding.gardenBlueprintProgressText.text = Prefs.infos.gardenInfoGetString("gardenName", gardenName)
            binding.gardenBlueprintProgressNext.visibility = View.GONE
            blueprintPlants = mutableListOf()
            for (i: Int in 0 until Prefs.infos.gardenBlueprintNumGet("blueprintNum", 36)){
                Prefs.infos.gardenBlueprintGetPlants("gardenBlueprint$i", "none")?.let {
                    blueprintPlants.add(
                        it
                    )
                }
            }
        }

        saveBlueprint()

        binding.gardenBlueprintProgressNext.setOnClickListener {
            saveBlueprint()
            gardenDate = LocalDate.now()
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
        val myDataset = Datasource().loadTable(blueprintPlants)
        val recyclerView = binding.recyclerView
        recyclerView.isNestedScrollingEnabled = false
        recyclerView.overScrollMode = View.OVER_SCROLL_NEVER
        recyclerView.adapter = ItemAdapter(myDataset)
        (recyclerView.layoutManager as GridLayoutManager).spanCount = spanCount
        tableItemClickAdapter = ItemAdapter(myDataset)
        recyclerView.adapter = tableItemClickAdapter
    }

    private fun blueprintEdit() {
        tableItemClickAdapter.onItemClickListener = {
            binding.gardenBlueprintAddItems.visibility = View.VISIBLE
            binding.gardenBlueprintAddItemBg.visibility = View.VISIBLE
        }
    }

    private fun saveBlueprint() {
        Prefs.infos.gardenRegisterSetBool("isGardenRegistered", true)
        Prefs.infos.gardenBlueprintSetPlants("gardenBlueprint", blueprintPlants)
        Prefs.infos.gardenBlueprintNumSet("blueprintNum", blueprintPlants.size)
    }
}