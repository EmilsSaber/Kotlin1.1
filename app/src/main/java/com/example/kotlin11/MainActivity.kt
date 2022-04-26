package com.example.kotlin11

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlin11.Constans.KEY_1
import com.example.kotlin11.Constans.KEY_2
import com.example.kotlin11.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        sendDAta()
    }

    private fun sendDAta() {

        binding.btn.setOnClickListener {
            if (binding.edit.text.isNullOrEmpty()){
                Toast.makeText(this, "Ваш едит пустой", Toast.LENGTH_LONG).show()
            }else{
                nextAct()


            }
        }
    }

    private fun nextAct() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(KEY_1, binding.edit.text.toString())
        start.launch(intent)
    }

    var start = registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
        fun  (result: ActivityResult) {
        if (result.resultCode == Activity.RESULT_OK){
         val intent: Intent? = result.data
         val oks = intent?.getStringExtra(KEY_2)
            println("------------------" + oks)
         binding.edit.setText(oks.toString())
        }else{
            Toast.makeText(this, "Ошибка", Toast.LENGTH_LONG).show()
        }
    })
}