package ru.zatsoft.gridlayout

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder
import ru.zatsoft.gridlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageView.setOnClickListener{
            finish()
        }
    }

    fun OnButtonClick(view: View) {
        val btn = findViewById<Button>(view.id)
        when (view.id) {
            R.id.btnReset -> {
                binding.edInput.text.clear()
                binding.tvResult.text = ""}
            R.id.btnCalc -> {
                binding.tvResult.text = calc(binding.edInput.text.toString())}
            else -> {
                binding.edInput.text.append(btn.text)}
        }
    }

    private fun calc(text: String): String {
         if(text.trim() != "" ) {
             try{
                 val expr = ExpressionBuilder(text).build()
                 val res = expr.evaluate()
                 return res.toString()
             } catch(e: Exception){
                 return "Error"
             }
         } else return ""
    }
}