package com.nestorcicardini.yourbmicalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class CalculatorActivity : AppCompatActivity() {

    private var currentWeight = 60
    private var currentAge = 18

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeightValue: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnAddWeight: FloatingActionButton
    private lateinit var tvWeightValue: TextView
    private lateinit var tvAgeValue: TextView
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnAddAge: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeightValue = findViewById(R.id.tvHeightValue)
        rsHeight = findViewById(R.id.rsHeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnAddWeight = findViewById(R.id.btnAddWeight)
        tvWeightValue = findViewById(R.id.tvWeightValue)
        tvAgeValue = findViewById(R.id.tvAgeValue)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnAddAge = findViewById(R.id.btnAddAge)
    }

    @SuppressLint("SetTextI18n")
    private fun initListeners() {
        viewMale.setOnClickListener {
            toggleGender(true)
        }
        viewFemale.setOnClickListener {
            toggleGender(false)
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            val result = df.format(value)
            tvHeightValue.text = "$result cm"
        }
        btnAddWeight.setOnClickListener {
            currentWeight++
            setWeight()
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight--
            setWeight()
        }
        tvWeightValue.doOnTextChanged { text, _, _, _ ->
            if (!text.isNullOrEmpty()) {
                currentWeight = text.toString().toInt()
            }
        }
        btnAddAge.setOnClickListener {
            currentAge++
            setAge()
        }
        btnSubtractAge.setOnClickListener {
            currentAge--
            setAge()
        }
        tvAgeValue.doOnTextChanged { text, _, _, _ ->
            if (!text.isNullOrEmpty()) {
                currentAge = text.toString().toInt()
            }
        }

    }


    private fun setWeight() {
        tvWeightValue.text = currentWeight.toString()
    }

    private fun setAge() {
        tvAgeValue.text = currentAge.toString()
    }

    private fun toggleGender(isMale: Boolean) {
        setCardColor(viewMale, isMale)
        setCardColor(viewFemale, !isMale)
    }


    private fun setCardColor(view: CardView, isSelected: Boolean) {
        val bgColorRef =
            if (isSelected) R.color.background_component_selected
            else R.color.background_component

        view.setCardBackgroundColor(ContextCompat.getColor(this, bgColorRef))
    }

    @SuppressLint("SetTextI18n")
    private fun initUI() {
        toggleGender(true)
        tvHeightValue.text = "120 cm"
        setWeight()
        setAge()

    }
}


