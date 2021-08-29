package e_icon.teamw.natureprotectors.data

import e_icon.teamw.natureprotectors.R
import e_icon.teamw.natureprotectors.model.GardenBlueprintTable

class Datasource {
    fun loadTable(tableList: List<String>): List<GardenBlueprintTable> {
        val none = GardenBlueprintTable(R.drawable.garden_blueprint_plan_rect)
        val tomato = GardenBlueprintTable(R.drawable.garden_blueprint_drag_plants_tomato)
        val potato = GardenBlueprintTable(R.drawable.garden_blueprint_drag_plants_potato)
        val lettuce = GardenBlueprintTable(R.drawable.garden_blueprint_drag_plants_lettuce)
        val cherry = GardenBlueprintTable(R.drawable.garden_blueprint_drag_plants_cherry)
        val sunflower = GardenBlueprintTable(R.drawable.garden_blueprint_drag_plants_sunflower)
        val blueprintTableList = mutableListOf<GardenBlueprintTable>()
        tableList.forEach {
            when (it) {
                "none" -> blueprintTableList.add(none)
                "tomato" -> blueprintTableList.add(tomato)
                "potato" -> blueprintTableList.add(potato)
                "lettuce" -> blueprintTableList.add(lettuce)
                "cherry" -> blueprintTableList.add(cherry)
                "sunflower" -> blueprintTableList.add(sunflower)
            }
        }
        return blueprintTableList
    }
}