package com.example.kotlin11

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import com.example.kotlin11.Constans.KEY_1
import com.example.kotlin11.Constans.KEY_2
import com.example.kotlin11.databinding.ActivityMainBinding
import com.example.kotlin11.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        initReturn()
    }

    private fun initReturn() {
        binding.btn.setOnClickListener {
            if (binding.edit.text.isNullOrEmpty()) {
                Toast.makeText(this, "Ваш едит пустой", Toast.LENGTH_LONG).show()
            } else {
                push(binding.edit.text.toString())
            }
        }
    }

    private fun push(str: String) {
        val data = Intent()
        data.putExtra(KEY_2, str)
        setResult(RESULT_OK, data)
        finish()
    }

    private fun initView() {
        val ext: Bundle? = intent.extras
        if (ext != null) {
            binding.edit.setText(ext.getString(KEY_1))
        }
    }

    override fun onBackPressed() {
        push(binding.edit.text.toString())
        super.onBackPressed()
    }

}