package com.feng.loancalculatorpromaxsuperb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextCarPrice : EditText = findViewById(R.id.editTextCarPrice)
        val editTextDownPayment : EditText = findViewById(R.id.editTextDownPayment)
        val editTextLoadPeriod : EditText = findViewById(R.id.editTextNumberLoadPeriod)
        val editTextInterestRate : EditText = findViewById(R.id.editTextInterestRate)

        val textViewInterest : TextView = findViewById(R.id.textViewInterest)
        val textViewCarLoan : TextView = findViewById(R.id.textViewCarLoan)
        val textViewMonthlyRepayment : TextView = findViewById(R.id.textViewMonthlyRepayment)

        val buttonCalculate : Button = findViewById(R.id.buttonCalculate)
        val buttonReset : Button = findViewById(R.id.buttonReset)

        buttonCalculate.setOnClickListener {

            if(editTextCarPrice.text.isEmpty() || editTextInterestRate.text.isEmpty() ||
                editTextLoadPeriod.text.isEmpty() || editTextDownPayment.text.isEmpty())
            {
                editTextLoadPeriod.setError("Value in all field is required")
            }

            val interestRateLocal = editTextInterestRate.text.toString().toFloat()
            val downPayment = editTextDownPayment.text.toString().toFloat()
            val loanPeriod = editTextLoadPeriod.text.toString().toInt()
            val carPrice = editTextCarPrice.text.toString().toFloat()

            val loanAmount = carPrice - downPayment
            val interest = loanAmount*interestRateLocal*loanPeriod
            val repayment = (loanAmount + interest)/loanPeriod/12

            textViewCarLoan.text = String.format("%s %.2f", getString(R.string.car_loan), loanAmount)
            textViewInterest.text = String.format("%s %.2f", getString(R.string.interest), interest)
            textViewMonthlyRepayment.text = String.format("%s %.2f", getString(R.string.monthly_repayment), repayment)

        }

        buttonReset.setOnClickListener {
            editTextCarPrice.text.clear()
            editTextDownPayment.text.clear()
            editTextLoadPeriod.text.clear()
            editTextInterestRate.text.clear()
            textViewCarLoan.text = String.format("%s", getString(R.string.car_loan))
            textViewMonthlyRepayment.text = String.format("%s", getString(R.string.monthly_repayment))
            textViewInterest.text = String.format("%s", getString(R.string.interest))
        }

    }
}