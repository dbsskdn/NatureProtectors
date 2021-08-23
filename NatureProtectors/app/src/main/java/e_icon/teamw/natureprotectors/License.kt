package e_icon.teamw.natureprotectors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import e_icon.teamw.natureprotectors.databinding.ActivityLicenseBinding

private lateinit var binding: ActivityLicenseBinding

class License : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_license)

        binding = ActivityLicenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.licenseBackButton.setOnClickListener {
            val startIntent = Intent(this, Start::class.java)
            startActivity(startIntent)
        }
    }
}