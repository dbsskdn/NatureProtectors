package e_icon.teamw.natureprotectors.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import e_icon.teamw.natureprotectors.model.GardenBlueprintTable
import e_icon.teamw.natureprotectors.R
import e_icon.teamw.natureprotectors.blueprintPlants

var position: Int = 0
class ItemAdapter(private val dataset: List<GardenBlueprintTable>
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    var onItemClickListener : ((Int)->Unit)? = null
    lateinit var context: Context

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val itemImg: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        context = parent.context
        val item = LayoutInflater.from(parent.context).inflate(R.layout.garden_blueprint_table_item, parent, false)
        val itemViewHolder = ItemViewHolder(item)

        item.setOnClickListener {
            position = itemViewHolder.adapterPosition
            onItemClickListener?.invoke(position)
        }

        return itemViewHolder
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.itemImg.setImageResource(item.imageResourceId)
    }
}