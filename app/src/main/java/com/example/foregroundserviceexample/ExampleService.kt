package com.example.foregroundserviceexample

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.foregroundserviceexample.App.Companion.CHANNEL_ID

class ExampleService : Service(){

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val data = intent?.getStringExtra("data") ?: ""

        val openThisIntentOnClickOfNotification = Intent(this, MainActivity::class.java)

        val pendingIntent = PendingIntent.getActivity(this, 0, openThisIntentOnClickOfNotification, 0)
        val notification : Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Example Service")
            .setContentText(data)
            .setSmallIcon(R.drawable.ic_android)
            .setContentIntent(pendingIntent).build()
        startForeground(1, notification)

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}