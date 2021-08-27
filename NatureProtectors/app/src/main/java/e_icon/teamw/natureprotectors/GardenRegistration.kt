package e_icon.teamw.natureprotectors

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import e_icon.teamw.natureprotectors.databinding.ActivityGardenRegistrationBinding

private lateinit var binding: ActivityGardenRegistrationBinding
var gardenName = ""

class GardenRegistration : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGardenRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gardenRegistrationSmartySaysText.text = "Write your garden name and long-click to choose garden location"

        binding.gardenRegistrationProgressNext.setOnClickListener {
            gardenName = binding.gardenRegistrationGardenNameEdittext.text.toString()
            val gardenNameFilled = gardenName != ""

            if (gardenNameFilled) {
                gardenName = binding.gardenRegistrationGardenNameEdittext.text.toString()
                Prefs.infos.gardenInfoSetString("gardenName", gardenName)
                val plantsSelectionIntent = Intent(this, PlantsSelection::class.java)
                startActivity(plantsSelectionIntent)
            }
            else {
                Toast.makeText(applicationContext, "You did not write your garden name!", Toast.LENGTH_LONG).show()
            }
        }


        supportFragmentManager.beginTransaction()
            .replace(R.id.google_map_fragment, GoogleMapView())
            .commit()
    }
}