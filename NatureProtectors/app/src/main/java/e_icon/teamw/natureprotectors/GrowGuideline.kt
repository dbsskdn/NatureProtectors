package e_icon.teamw.natureprotectors

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import e_icon.teamw.natureprotectors.databinding.ActivityGrowGuidelineBinding

private lateinit var binding: ActivityGrowGuidelineBinding
var guidelineIndex = 0

class GrowGuideline : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGrowGuidelineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        when (guidelinePlant) {
            "tomato" -> {
                binding.growGuidelineTitleImg.setImageResource(R.drawable.grow_guideline_tomato_img)
                binding.growGuidelineTitleText.text = "Grow Guideline for $guidelinePlant"
                viewGuideline()
            }
            "potato" -> {
                binding.growGuidelineTitleImg.setImageResource(R.drawable.grow_guideline_potato_img)
                binding.growGuidelineTitleText.text = "Grow Guideline for $guidelinePlant"
            }
            "lettuce" -> {
                binding.growGuidelineTitleImg.setImageResource(R.drawable.grow_guideline_lettuce_img)
                binding.growGuidelineTitleText.text = "Grow Guideline for $guidelinePlant"
            }
            "cherry" -> {
                binding.growGuidelineTitleImg.setImageResource(R.drawable.grow_guideline_cherry_img)
                binding.growGuidelineTitleText.text = "Grow Guideline for $guidelinePlant"
            }
            "sunflower" -> {
                binding.growGuidelineTitleImg.setImageResource(R.drawable.grow_guideline_sunflower_img)
                binding.growGuidelineTitleText.text = "Grow Guideline for $guidelinePlant"
            }
        }

        binding.growGuidelineBack.setOnClickListener {
            val gardenBlueprintIntent = Intent(this, GardenBlueprint::class.java)
            startActivity(gardenBlueprintIntent)
        }
    }

    private fun viewGuideline() {
        binding.growGuidelineNext.setOnClickListener {
            guidelineIndex += 1
        }
        binding.growGuidelinePrev.setOnClickListener {
            guidelineIndex -= 1
        }

        if (guidelineIndex >= 1) {
            binding.growGuidelinePrev.visibility = View.VISIBLE
        }
        else if (guidelineIndex < 1) {
            binding.growGuidelinePrev.visibility = View.GONE
        }

        if (guidelineIndex == 10) {
            binding.growGuidelineNext.visibility = View.GONE
        }
        else if (guidelineIndex < 9) {
            binding.growGuidelineNext.visibility = View.VISIBLE
        }

        when (guidelineIndex) {
            0 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_1)
            1 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_2)
            2 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_3)
            3 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_4)
            4 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_5)
            5 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_5)
            6 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_6)
            7 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_7)
            8 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_8)
            9 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_9)
            10 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_10)
        }
    }
}