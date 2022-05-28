package com.isilsubasi.isilfirebase.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.RemoteMessage
import com.isilsubasi.isilfirebase.databinding.ActivityMainBinding
import com.isilsubasi.isilfirebase.util.Constants

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        init()



    }


    private fun init() {
        getFcmToken()
        onClickListener()
    }

    private fun getFcmToken(){
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.v(Constants.TAG, "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result
            Log.v(Constants.TAG, token)
        })

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

                startActivity(Intent(applicationContext,DetailActivity::class.java))


            }


        }


    }
}