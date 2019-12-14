package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCal.setOnClickListener() {
            val totalPremium: Double = getPremium()

            total_premium.text = totalPremium.toString()
        }

        btnReset.setOnClickListener() {
            Clear()
        }
    }

    fun getPremium(): Double {
        return when (spinnerAge.selectedItemPosition) {
            0 -> 60.00
            1 -> 70.00 +
                    (if (radMale.isChecked) 50.00 else 0.00) +
                    (if (chkSmoker.isChecked) 100.00 else 0.00)
            2 -> 90.00 +
                    (if (radMale.isChecked) 100.00 else 0.00) +
                    (if (chkSmoker.isChecked) 150.00 else 0.00)
            3 -> 120.00 +
                    (if (radMale.isChecked) 150.00 else 0.00) +
                    (if (chkSmoker.isChecked) 200.00 else 0.00)
            4 -> 150.00 +
                    (if (radMale.isChecked) 200.00 else 0.00) +
                    (if (chkSmoker.isChecked) 250.00 else 0.00)
            else -> 150.00 +
                    (if (radMale.isChecked) 200.00 else 0.00) +
                    (if (chkSmoker.isChecked) 300.00 else 0.00)
        }
    }

    fun Clear() {
        spinnerAge.setSelection(0)
        radGroup.clearCheck()
        total_premium.setText("")
        chkSmoker.setChecked(false)
    }
    

/*
    fun onCheckBocClicked(view: View) {
        if (view is CheckBox){
            val checked: Boolean = view.isChecked
            when (view.id){
                R.id.chkSmoker ->{
                    if(checked){
                       return true
                    }
                }
            }
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton){
            val checked = view.isChecked
            when (view.getId()){
                R.id.radMale -> {
                    if (checked) {
                        return true
                    }else{

                    }
                }
            }
        }
    }
*/

}
