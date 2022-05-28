package com.isilsubasi.isilfirebase

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.preference.PreferenceManager
import android.util.Log
import android.widget.RemoteViews
import androidx.annotation.Nullable
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.google.firebase.firestore.util.Util
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.isilsubasi.isilfirebase.activity.MainActivity
import com.isilsubasi.isilfirebase.util.Constants

class MyFirebaseMessagingService : FirebaseMessagingService() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(message: RemoteMessage) {

        Log.d(Constants.TAG, "From: ${message?.from}")

        // Check if message contains a notification payload.
        message?.data?.let {
            Log.d(Constants.TAG, "Message Notification Body: ${it}")
            //Message Services handle notification
            val mNotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val id = "my_channel_01"
            val importance = NotificationManager.IMPORTANCE_LOW
            val mChannel = NotificationChannel(id, "name", importance)
            mChannel.enableLights(true)
            mNotificationManager.createNotificationChannel(mChannel)


           // val notificationLayout = RemoteViews(packageName, R.layout.bildirim_collapsed)
            val notification = NotificationCompat.Builder(this)
                .setContentTitle(it["title"])
                .setContentText(it["body"])
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setChannelId(id)
                //.setCustomContentView(notificationLayout)
                .build()
            val manager = NotificationManagerCompat.from(applicationContext)
            manager.notify(/*notification id*/0, notification)
        }


    }







}