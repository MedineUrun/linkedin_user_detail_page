package com.example.recommendation_homework

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import coil.load
import java.util.Calendar

class RecommendationDetail : AppCompatActivity() {

    lateinit var ivTwoProfile : ImageView
    lateinit var tvTwoUserName : TextView
    lateinit var tvTwoUserInfo : TextView
    lateinit var tvTwoUserUni : TextView
    lateinit var bannerImageView : ImageView
    lateinit var btnCallNumber : TextView
    lateinit var btnViewMap : TextView
    lateinit var btnSendEmail : Button
    lateinit var btnCreateCalenderEvent : Button
    lateinit var btnOpenAndAppWithChooser :Button
    lateinit var btnOpenOtherApp : Button
    lateinit var btnSetAlarm : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendation_detail)

        ivTwoProfile = findViewById(R.id.ivTwoProfile)
        tvTwoUserName = findViewById(R.id.tvTwoUserName)
        tvTwoUserInfo = findViewById(R.id.tvTwoUserInfo)
        tvTwoUserUni = findViewById(R.id.tvTwoUserUni)
        bannerImageView = findViewById(R.id.bannerImageView)
        btnCallNumber = findViewById(R.id.btnCallNumber)
        btnViewMap = findViewById(R.id.btnViewMap)
        btnSendEmail = findViewById(R.id.btnSendEmail)
        btnCreateCalenderEvent = findViewById(R.id.btnCreateCalenderEvent)
        btnOpenAndAppWithChooser = findViewById(R.id.btnOpenAndAppWithChooser)
        btnOpenOtherApp = findViewById(R.id.btnOpenOtherApp)
        btnSetAlarm = findViewById(R.id.btnSetAlarm)


        val recommendation = intent.getParcelableExtra<Recommendation>("recommendation")
        recommendation?.let {
            tvTwoUserName.text = it.name
            tvTwoUserInfo.text= it.career
            tvTwoUserUni.text = it.university
            ivTwoProfile.load(recommendation.profile)
            bannerImageView.load(recommendation.banner)
        }

        //telefon numarası açmak
        btnCallNumber.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:555 555 55 55"))
            startActivity(callIntent)
        }
        //harita açma
        btnViewMap.setOnClickListener{
            val mapIntent: Intent = Uri.parse(
                "geo:37.422219,-122.08364?z=14"
            ).let{location ->
                Intent(Intent.ACTION_VIEW, location)
            }
            startActivity(mapIntent)
        }

        //tarayıcıda resim açmak resme tıklayınca
        ivTwoProfile.setOnClickListener{
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://images.unsplash.com/photo-1639149888905-fb39731f2e6c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=464&q=80"))
            startActivity(webIntent)
        }

        //e-mail adresi açmak
        btnSendEmail.setOnClickListener {
            Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("jan@example.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Email subject")
                putExtra(Intent.EXTRA_TEXT, "Email message text")
                putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"))
                startActivity(this)
            }
        }

        //takvim açıyor
        btnCreateCalenderEvent.setOnClickListener {
            Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI).apply {
                val beginTime: Calendar = Calendar.getInstance().apply {
                    set(2021, 0, 23, 7, 30)
                }
                val endTime = Calendar.getInstance().apply {
                    set(2021, 0, 23, 10,30)
                }
                putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.timeInMillis)
                putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.timeInMillis)
                putExtra(CalendarContract.Events.TITLE, "Ninja class")
                putExtra(CalendarContract.Events.EVENT_LOCATION, "Secret dolo")
                startActivity(this)
            }
        }

        //Uygulama Seçtirme
        btnOpenAndAppWithChooser.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel: 55545645"))
            val chooser = Intent.createChooser(intent, "İlgili uygulamayı seçiniz", null)
            try {
                startActivity(chooser)
            }catch (e:ActivityNotFoundException){
                //uyarı
            }
        }

        //mesaj uygulaması
        btnOpenOtherApp.setOnClickListener {
            try {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                val message = "message to send"
                shareIntent.putExtra(Intent.EXTRA_TEXT, message)
                startActivity(shareIntent)
            }catch (e:ActivityNotFoundException){
                Toast.makeText(this, "application was not found in this device", Toast.LENGTH_SHORT)
                    .show()
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/datails?id=com.findwordgame.app")
                    )
                )
            }
        }

        //Alarm oluşturma

        /*btnSetAlarm.setOnClickListener {

        }*/



    }


}