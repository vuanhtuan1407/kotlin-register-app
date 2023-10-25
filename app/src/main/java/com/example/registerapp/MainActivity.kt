package com.example.registerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.DatePickerDialog
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private val calendar = Calendar.getInstance()
    lateinit var birthdayTE:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNameET:EditText = findViewById(R.id.firstNameET)
        val lastNameET:EditText = findViewById(R.id.lastNameET)

        val genderChoice:RadioGroup = findViewById(R.id.genderGroup)

        val addressET:EditText = findViewById(R.id.addressET)
        val emailET:EditText =  findViewById(R.id.emailTE)

        val agreeCB: CheckBox = findViewById(R.id.agreeCB)

        birthdayTE = findViewById(R.id.birthdayTD)


        val selectBD : Button = findViewById(R.id.selectBD)

        selectBD.setOnClickListener {
            showDatePickerDialog()
        }


        val registerBtn: Button = findViewById(R.id.register)
        registerBtn.setOnClickListener{
            if (firstNameET.text.toString().isBlank() ||
                lastNameET.text.toString().isBlank() ||
                addressET.text.toString().isBlank() ||
                emailET.text.toString().isBlank() ||
                genderChoice.checkedRadioButtonId != -1 ||
                !agreeCB.isChecked) {
                Toast.makeText(this@MainActivity, "Chưa nhập đủ thông tin", Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this@MainActivity, "Register done", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun showDatePickerDialog() {

        val dateListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            birthdayTE.setText(dateFormat.format(calendar.time))
        }

        val datePickerDialog = DatePickerDialog(
            this@MainActivity,
            dateListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePickerDialog.show()
    }

}


