package e_icon.teamw.natureprotectors.data

import e_icon.teamw.natureprotectors.R
import e_icon.teamw.natureprotectors.model.GardenBlueprintTable

class Datasource {
    fun loadAffirmations(number: Int): List<GardenBlueprintTable> {
        val element = GardenBlueprintTable(R.drawable.garden_blueprint_plan_rect)
        return MutableList(number) { element }
    }
}