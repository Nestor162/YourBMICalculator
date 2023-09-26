package com.nestorcicardini.yourbmicalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class CalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView

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
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            setGenderColor()
            changeGender()
        }
        viewFemale.setOnClickListener {
            setGenderColor()
            changeGender()
        }
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getCardBgColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getCardBgColor(isFemaleSelected))
    }

    private fun getCardBgColor(isComponentSelected: Boolean): Int {
        val bgColorRef =
            if (isComponentSelected) R.color.background_component_selected
            else R.color.background_component

        return ContextCompat.getColor(this, bgColorRef)
    }

    private fun initUI() {
        setGenderColor()
    }
}