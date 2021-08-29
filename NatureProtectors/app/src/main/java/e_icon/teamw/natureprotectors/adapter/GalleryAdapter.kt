package e_icon.teamw.natureprotectors.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import e_icon.teamw.natureprotectors.GalleryImgData
import e_icon.teamw.natureprotectors.R

class GalleryAdapter(private val dataset: List<GalleryImgData>
): RecyclerView.Adapter<GalleryAdapter.ItemViewHolder>() {
    var onItemClickListener : ((Int)->Unit)? = null
    lateinit var context: Context

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val galleryImg: ImageView = view.findViewById(R.id.gallery_img)
        val galleryDate: TextView = view.findViewById(R.id.gallery_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        context = parent.context
        val item = LayoutInflater.from(parent.context).inflate(R.layout.gallery_img, parent, false)
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
        holder.galleryImg.setImageBitmap(item.imageResource)
        holder.galleryDate.text = item.imageDate
    }
}