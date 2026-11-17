package com.example.androidwithkotlin.AndroidWithKotlin.firebase

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.androidwithkotlin.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FirebaseMessageService : FirebaseMessagingService() {

    private val TAG: String = "FirebaseMessageService"

    private val CHANNEL_ID: String = "push_notification"

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TAG, "Refreshed token: $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        val title = message.getNotification()!!.title
        val body = message.getNotification()!!.body

        pushNotification(title, body)
    }

    private fun pushNotification(title: String?, message: String?) {
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager?
        val notification: Notification?

        val intent = Intent(this, FirebaseMessageServiceActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val flags = PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        val pendingIntent = PendingIntent.getActivity(this, 100, intent, flags)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Push Notification Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.setDescription("Channel for push notifications")

            if (notificationManager != null) notificationManager.createNotificationChannel(channel)

            notification = Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_alarm)
                .setContentIntent(pendingIntent)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .build()
        } else {
            notification = NotificationCompat.Builder(this)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_alarm)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build()
        }
        if (notificationManager != null) {
            notificationManager.notify(1, notification)
        }
    }
}