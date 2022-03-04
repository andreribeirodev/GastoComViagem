package com.example.gastoviagem

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //TODO:Binding > 2.Passo - Declaração da variavel binding;
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO:Binding > 3.Passo - Instância o binding - Infla o layout - Passa o root no SetContentView
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()


    }

    override fun onClick(view: View) {
        if (view.id == R.id.buttonCalculate)
            calculate()
    }


    private fun setListeners() {
        binding.buttonCalculate.setOnClickListener(this)
    }


    private fun isValid(): Boolean {
        return (binding.editTextDistance.text.toString() != ""
                && binding.editTextPrice.text.toString() != ""
                && binding.editTextAutonomy.text.toString() != ""
                && binding.editTextAutonomy.text.toString().toFloat() != 0f)
    }


    private fun calculate() {
        if (isValid()) {
            val distance = binding.editTextDistance.text.toString().toFloat()
            val price = binding.editTextPrice.text.toString().toFloat()
            val autonomy = binding.editTextAutonomy.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy
            binding.textViewCurrencyBrl.text = "R$ ${"%.2f".format(totalValue)}"
        } else {
            Toast.makeText(this, R.string.validation_fill_all_fields, Toast.LENGTH_SHORT).show()
        }
    }
}