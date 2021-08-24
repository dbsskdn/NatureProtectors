package e_icon.teamw.natureprotectors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import e_icon.teamw.natureprotectors.databinding.ActivityGardenRegistrationBinding

private lateinit var binding: ActivityGardenRegistrationBinding
var gardenName = ""

class GardenRegistration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGardenRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gardenRegistrationProgressNext.setOnClickListener {
            gardenName = binding.gardenRegistrationGardenNameEdittext.text.toString()
            val gardenNameFilled = gardenName != ""

            if (gardenNameFilled) {
                gardenName = binding.gardenRegistrationGardenNameEdittext.text.toString()
                val plantsSelectionIntent = Intent(this, PlantsSelection::class.java)
                startActivity(plantsSelectionIntent)
            }
            else {
                Toast.makeText(applicationContext, "You did not write your garden name!", Toast.LENGTH_LONG).show()
            }
        }
    }
}