package com.nestorcicardini.yourbmicalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class CalculatorActivity : AppCompatActivity() {
    
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
            toggleGender(true)
        }
        viewFemale.setOnClickListener {
            toggleGender(false)
        }
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

    private fun initUI() {
        toggleGender(true)
    }
}


