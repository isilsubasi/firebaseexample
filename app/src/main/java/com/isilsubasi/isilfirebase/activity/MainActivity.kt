package com.isilsubasi.isilfirebase.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.isilsubasi.isilfirebase.service.ApiClient
import com.isilsubasi.isilfirebase.databinding.ActivityMainBinding
import com.isilsubasi.isilfirebase.util.Constants

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private val apiClient by lazy { ApiClient() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        init()
    }


    private fun init() {
        onClickListener()
    }

    private fun onClickListener() {

        binding.apply {
            btnCrash.setOnClickListener {
                //  val sayi1 = 0
                // val sayi2= 10
                //val sonuc = sayi2 / sayi1
                // println(sonuc)

                throw RuntimeException("Test Crash")

            }
            btnAnalitik.setOnClickListener {
                val bundle = Bundle()
                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "my_item_id")
                firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)

            }
            btnNotification.setOnClickListener {

            }
            btnFireStore.setOnClickListener {

                apiClient.getUserFromApi { isSuccess, response, message ->
                    if (isSuccess) {
                        val name = response?.documents?.first()?.fields?.adi!!.stringValue
                        val no = response?.documents?.first()?.fields?.no!!.integerValue
                        val intent = Intent(applicationContext, DetailActivity::class.java)
                        intent.putExtra(Constants.OGRENCI_ADI, name)
                        intent.putExtra(Constants.OGRENCI_NO, no)
                        startActivity(intent)

                    }


                }

            }


        }


    }
}