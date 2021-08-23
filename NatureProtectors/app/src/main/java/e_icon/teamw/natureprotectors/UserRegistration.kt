package e_icon.teamw.natureprotectors

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import e_icon.teamw.natureprotectors.databinding.ActivityUserRegistrationBinding
import e_icon.teamw.natureprotectors.databinding.CountryDropdownItemsBinding

private lateinit var binding: ActivityUserRegistrationBinding
private lateinit var countryDropdownBinding: CountryDropdownItemsBinding
var isRegistered= false
var userCountry = ""
var userName = ""

class UserRegistration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserRegistrationBinding.inflate(layoutInflater)
        countryDropdownBinding = CountryDropdownItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countryDropdownItems = resources.getStringArray(R.array.countryDropdown)
        val countryDropdownAdapter = object : ArrayAdapter<String>(this, R.layout.country_dropdown_items){
            override fun getView(position : Int, convertView: View?, parent: ViewGroup): View {
                val v = super.getView(position, convertView, parent)
                if(position == count){
                    countryDropdownBinding.tvItemSpinner.text = ""
                    countryDropdownBinding.tvItemSpinner.hint = getItem(count)
                }
                return v
            }

            override fun getCount(): Int {
                return super.getCount() - 1
            }
        }

        countryDropdownAdapter.addAll(countryDropdownItems.toMutableList())
        countryDropdownAdapter.add("Country")
        binding.userRegistrationCountryDropdown.adapter = countryDropdownAdapter
        binding.userRegistrationCountryDropdown.setSelection(countryDropdownAdapter.count)
        binding.userRegistrationCountryDropdown.dropDownVerticalOffset = dipToPixels().toInt()
        var userCountrySelected = false


        binding.userRegistrationCountryDropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when(position) {
                    0   ->  {
                        userCountry = countryDropdownItems[0]
                        userCountrySelected = true
                    }
                    1   ->  {
                        userCountry = countryDropdownItems[1]
                        userCountrySelected = true
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                userCountrySelected = false
            }
        }

        binding.userRegistrationRegistrationButton.setOnClickListener{
            userName = binding.userRegistrationUsernameInput.text.toString()
            val userNameFilled = userName != "Username"

            if(userNameFilled && userCountrySelected){
                isRegistered = true
                val gardenRegistrationIntent = Intent(this, GardenRegistration::class.java)
                startActivity(gardenRegistrationIntent)
            }
            else if (!userNameFilled && !userCountrySelected) {
                Toast.makeText(applicationContext, "You did not choose your username and country!", Toast.LENGTH_LONG).show()
            }
            else if (!userNameFilled) {
                Toast.makeText(applicationContext, "You did not choose your username!", Toast.LENGTH_LONG).show()
            }
            else if (!userCountrySelected) {
                Toast.makeText(applicationContext, "You did not choose your country!", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun dipToPixels(): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            50f,
            resources.displayMetrics
        )
    }
}