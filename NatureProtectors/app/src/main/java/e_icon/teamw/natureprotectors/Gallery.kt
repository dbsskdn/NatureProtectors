package e_icon.teamw.natureprotectors

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import e_icon.teamw.natureprotectors.adapter.GalleryAdapter
import e_icon.teamw.natureprotectors.adapter.position
import e_icon.teamw.natureprotectors.databinding.ActivityGalleryBinding

val galleryImgs = mutableListOf<GalleryImgData>()

lateinit var selectedImg: Bitmap
var selectedDate: String = ""

class Gallery : AppCompatActivity() {
    private lateinit var binding: ActivityGalleryBinding
    private lateinit var galleryImgClickAdapter: GalleryAdapter

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        updateGallery()
        isGalleryMade = true

        binding.button.setOnClickListener {
            val gardenInfoActivity = Intent(this, GardenInfo::class.java)
            startActivity(gardenInfoActivity)
        }

        binding.galleryTitle.text = "Gallery"

        galleryImgClickAdapter.onItemClickListener = {
            selectedImg = galleryImgs[position].imageResource
            selectedDate = galleryImgs[position].imageDate
            val gallerySpecificIntent = Intent(this, GallerySpecific::class.java)
            startActivity(gallerySpecificIntent)
        }
    }

    private fun updateGallery() {
        val recyclerView = binding.galleryGrid
        recyclerView.isNestedScrollingEnabled = false
        recyclerView.overScrollMode = View.OVER_SCROLL_NEVER
        (recyclerView.layoutManager as GridLayoutManager).spanCount = 3
        recyclerView.adapter = GalleryAdapter(galleryImgs)
        galleryImgClickAdapter = GalleryAdapter(galleryImgs)
        recyclerView.adapter = galleryImgClickAdapter
    }
}