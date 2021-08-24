package e_icon.teamw.natureprotectors

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import e_icon.teamw.natureprotectors.databinding.ActivityGrowGuidelineBinding

private lateinit var binding: ActivityGrowGuidelineBinding
var guidelineIndex = 0
val guidelinePlantsIndex = listOf(10, 8, 4, 5, 10)

class GrowGuideline : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGrowGuidelineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateGuideline()

        binding.growGuidelineBack.setOnClickListener {
            val gardenBlueprintIntent = Intent(this, GardenBlueprint::class.java)
            startActivity(gardenBlueprintIntent)
        }

        binding.growGuidelineNext.setOnClickListener {
            guidelineIndex += 1
            speechBubbleChange()
        }
        binding.growGuidelinePrev.setOnClickListener {
            guidelineIndex -= 1
            speechBubbleChange()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateGuideline() {
        when (guidelinePlant) {
            "tomato" -> {
                binding.growGuidelineTitleImg.setImageResource(R.drawable.grow_guideline_tomato_img)
                binding.growGuidelineTitleText.text = "Grow Guideline for $guidelinePlant"
                binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_1)
                guidelineIndex = 0
            }
            "potato" -> {
                binding.growGuidelineTitleImg.setImageResource(R.drawable.grow_guideline_potato_img)
                binding.growGuidelineTitleText.text = "Grow Guideline for $guidelinePlant"
                binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_potato_speech_bubble_1)
                guidelineIndex = 0
            }
            "lettuce" -> {
                binding.growGuidelineTitleImg.setImageResource(R.drawable.grow_guideline_lettuce_img)
                binding.growGuidelineTitleText.text = "Grow Guideline for $guidelinePlant"
                binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_lettuce_speech_bubble_1)
                guidelineIndex = 0
            }
            "cherry" -> {
                binding.growGuidelineTitleImg.setImageResource(R.drawable.grow_guideline_cherry_img)
                binding.growGuidelineTitleText.text = "Grow Guideline for $guidelinePlant"
                binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_cherry_speech_bubble_1)
                guidelineIndex = 0
            }
            "sunflower" -> {
                binding.growGuidelineTitleImg.setImageResource(R.drawable.grow_guideline_sunflower_img)
                binding.growGuidelineTitleText.text = "Grow Guideline for $guidelinePlant"
                binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_sunflower_speech_bubble_1)
                guidelineIndex = 0
            }
        }
    }

    private fun speechBubbleChange() {
        if (guidelineIndex >= 1) {
            binding.growGuidelinePrev.visibility = View.VISIBLE
        }
        else if (guidelineIndex < 1) {
            binding.growGuidelinePrev.visibility = View.GONE
        }
        when (guidelinePlant) {
            "tomato" -> {
                if (guidelineIndex > guidelinePlantsIndex[0] - 2) {
                    binding.growGuidelineNext.visibility = View.GONE
                }
                else if (guidelineIndex < guidelinePlantsIndex[0] - 2) {
                    binding.growGuidelineNext.visibility = View.VISIBLE
                }

                when (guidelineIndex) {
                    0 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_1)
                    1 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_2)
                    2 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_3)
                    3 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_4)
                    4 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_5)
                    5 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_6)
                    6 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_7)
                    7 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_8)
                    8 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_9)
                    9 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_tomato_speech_bubble_10)
                }
            }
            "potato" -> {
                if (guidelineIndex > guidelinePlantsIndex[1] - 2) {
                    binding.growGuidelineNext.visibility = View.GONE
                }
                else if (guidelineIndex < guidelinePlantsIndex[1] - 2) {
                    binding.growGuidelineNext.visibility = View.VISIBLE
                }

                when (guidelineIndex) {
                    0 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_potato_speech_bubble_1)
                    1 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_potato_speech_bubble_2)
                    2 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_potato_speech_bubble_3)
                    3 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_potato_speech_bubble_4)
                    4 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_potato_speech_bubble_5)
                    5 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_potato_speech_bubble_6)
                    6 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_potato_speech_bubble_7)
                    7 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_potato_speech_bubble_8)
                }
            }
            "lettuce" -> {
                if (guidelineIndex > guidelinePlantsIndex[2] - 2) {
                    binding.growGuidelineNext.visibility = View.GONE
                }
                else if (guidelineIndex < guidelinePlantsIndex[2] - 2) {
                    binding.growGuidelineNext.visibility = View.VISIBLE
                }

                when (guidelineIndex) {
                    0 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_lettuce_speech_bubble_1)
                    1 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_lettuce_speech_bubble_2)
                    2 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_lettuce_speech_bubble_3)
                    3 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_lettuce_speech_bubble_4)
                }
            }
            "cherry" -> {
                if (guidelineIndex > guidelinePlantsIndex[3] - 2) {
                    binding.growGuidelineNext.visibility = View.GONE
                }
                else if (guidelineIndex < guidelinePlantsIndex[3] - 2) {
                    binding.growGuidelineNext.visibility = View.VISIBLE
                }

                when (guidelineIndex) {
                    0 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_cherry_speech_bubble_1)
                    1 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_cherry_speech_bubble_2)
                    2 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_cherry_speech_bubble_3)
                    3 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_cherry_speech_bubble_4)
                    4 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_cherry_speech_bubble_5)
                }
            }
            "sunflower" -> {
                if (guidelineIndex > guidelinePlantsIndex[4] - 2) {
                    binding.growGuidelineNext.visibility = View.GONE
                }
                else if (guidelineIndex < guidelinePlantsIndex[4] - 2) {
                    binding.growGuidelineNext.visibility = View.VISIBLE
                }

                when (guidelineIndex) {
                    0 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_sunflower_speech_bubble_1)
                    1 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_sunflower_speech_bubble_2)
                    2 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_sunflower_speech_bubble_3)
                    3 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_sunflower_speech_bubble_4)
                    4 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_sunflower_speech_bubble_5)
                    5 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_sunflower_speech_bubble_6)
                    6 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_sunflower_speech_bubble_7)
                    7 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_sunflower_speech_bubble_8)
                    8 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_sunflower_speech_bubble_9)
                    9 -> binding.growGuidelineSpeechBubble.setImageResource(R.drawable.grow_guideline_sunflower_speech_bubble_10)
                }
            }
        }
    }
}