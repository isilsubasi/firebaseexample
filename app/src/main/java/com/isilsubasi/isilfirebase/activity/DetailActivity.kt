package com.isilsubasi.isilfirebase.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
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
        readDataFromFireStore()
    }

    private fun readDataFromFireStore(){
        val db = FirebaseFirestore.getInstance()
        val docRef = db.collection("user").document("userID")
        docRef.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val document = task.result
                if (document != null) {
                    Log.d(Constants.TAG, "DocumentSnapshot data: " + task.result.data)
                    Log.d(Constants.TAG, "yaş: " + task.result.data!!["yaş"])
                    Log.d(Constants.TAG, "isim: " + task.result.data!!["isim"])

                    binding.txtUserName.setText(task.result.data!!["isim"].toString())
                    binding.txtUserAge.setText(task.result.data!!["yaş"].toString())

                } else {
                    Log.d(Constants.TAG, "No such document")
                }
            } else {
                Log.d(Constants.TAG, "get failed with ", task.exception)
            }
        }


    }

}