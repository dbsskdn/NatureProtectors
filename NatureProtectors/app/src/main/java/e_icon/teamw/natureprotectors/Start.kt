package e_icon.teamw.natureprotectors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import e_icon.teamw.natureprotectors.databinding.ActivityStartBinding

private lateinit var binding: ActivityStartBinding

class Start : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startStartButton.setOnClickListener {
            val userRegistrationIntent = Intent(this, UserRegistration::class.java)
            startActivity(userRegistrationIntent)
        }

        binding.startLicenseButton.setOnClickListener {
            val licenseIntent = Intent(this, License::class.java)
            startActivity(licenseIntent)
        }
    }
}