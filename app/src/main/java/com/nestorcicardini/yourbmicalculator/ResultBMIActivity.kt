package com.nestorcicardini.yourbmicalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.nestorcicardini.yourbmicalculator.CalculatorActivity.Companion.BMI_RESULT

class ResultBMIActivity : AppCompatActivity() {

    private lateinit var tvResultStatus: AppCompatTextView
    private lateinit var tvResultIndex: AppCompatTextView
    private lateinit var tvResultInfo: AppCompatTextView
    private lateinit var btnReCalculate: AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_bmiactivity)

        val result = intent.extras?.getDouble(BMI_RESULT) ?: -1.0
        initComponent()
        initListeners()
        initUI(result)
    }

    private fun initComponent() {
        tvResultIndex = findViewById(R.id.tvResultIndex)
        tvResultInfo = findViewById(R.id.tvResultInfo)
        tvResultStatus = findViewById(R.id.tvResultStatus)
        btnReCalculate = findViewById(R.id.btnReCalculate)
    }

    private fun initListeners() {
        btnReCalculate.setOnClickListener { onBackPressed() }
    }

    private fun initUI(result: Double) {
        tvResultIndex.text = result.toString()

        when (result) {
            in 0.00..18.50 -> { //Underweight
                tvResultStatus.text = getString(R.string.underweight)
                tvResultInfo.text = getString(R.string.underweight_description)
                tvResultStatus.setTextColor(ContextCompat.getColor(this, R.color.underweight))
            }

            in 18.51..24.99 -> { //Normal
                tvResultStatus.text = getString(R.string.normal)
                tvResultInfo.text = getString(R.string.normal_description)
                tvResultStatus.setTextColor(ContextCompat.getColor(this, R.color.normal))
            }

            in 25.00..29.99 -> { //Overweight
                tvResultStatus.text = getString(R.string.overweight)
                tvResultInfo.text = getString(R.string.overweight_description)
                tvResultStatus.setTextColor(ContextCompat.getColor(this, R.color.overweight))
            }

            in 30.00..40.00 -> { //Obese
                tvResultStatus.text = getString(R.string.obese)
                tvResultInfo.text = getString(R.string.obese_description)
                tvResultStatus.setTextColor(ContextCompat.getColor(this, R.color.obese))
            }

            in 41.00..90.00 -> { //Morbidly Obese
                tvResultStatus.text = getString(R.string.morbidly_obese)
                tvResultInfo.text = getString(R.string.morbidly_obese_description)
                tvResultStatus.setTextColor(ContextCompat.getColor(this, R.color.morbidly_obese))
            }

            else -> {
                tvResultStatus.text = getString(R.string.error)
                tvResultIndex.text = getString(R.string.error)
                tvResultInfo.text = getString(R.string.error)
            }
        }
    }


}
