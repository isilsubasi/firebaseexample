package com.isilsubasi.isilfirebase.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.isilsubasi.isilfirebase.databinding.ActivityDetailBinding
import com.isilsubasi.isilfirebase.util.Constants

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }

    private fun init(){
        val name = intent.getStringExtra(Constants.OGRENCI_ADI)
        val no = intent.getStringExtra(Constants.OGRENCI_NO)

        binding.apply {

            txtOgrenciAdi.text=name
            txtOgrenciNo.text=no
        }

        Log.e("isil",name + no)
    }

}