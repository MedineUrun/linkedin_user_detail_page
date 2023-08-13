package com.example.recommendation_homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecommendationActivity : AppCompatActivity() {

    val recommendation = mutableListOf(
        Recommendation(
            1,
            "Merve Alp",
            "T.C. Ulaştırma ve Altyapı Bakanlığı Şirketinde Meneger",
            "Süleyman Demirel Üniversitesi",
            "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80",
            "https://images.unsplash.com/photo-1614851099175-e5b30eb6f696?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80"
            ),
        Recommendation(
            2,
            "Burak Ceylan",
            "Product Manager / Lead Developer at Nara Edtech",
            "Hacettepe Üniversitesi",
            "https://images.unsplash.com/photo-1568602471122-7832951cc4c5?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
            "https://images.unsplash.com/photo-1625662171891-9a3348f961f4?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80"
        ),
        Recommendation(
            3,
            "İsmail Karaman",
            "Koçak Jewelry Şirketinde Diamond Sales Specialist",
            "Süleyman Demirel Üniversitesi",
            "https://images.unsplash.com/photo-1557862921-37829c790f19?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1171&q=80",
            "https://images.unsplash.com/photo-1614850715661-902fd7e93c78?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80"
        ),
        Recommendation(
            4,
            "Berrak Karlıca",
            "Süleyman Demirel Üniversitesi Öğrenci",
            "Süleyman Demirel Üniversitesi",
            "https://images.unsplash.com/photo-1508214751196-bcfd4ca60f91?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
            "https://images.unsplash.com/photo-1636955792912-de44a3ba46cd?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80"
            ),
        Recommendation(
            5,
            "Yıldız Hızlı",
            "Süleyman Demirel Üniversitesi Öğrenci",
            "Süleyman Demirel Üniversitesi",
            "https://images.unsplash.com/photo-1534180477871-5d6cc81f3920?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
            "https://images.unsplash.com/photo-1579547621869-0ddb5f237392?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80"
            ),
        Recommendation(
            6,
            "Burak Çamlı",
            "Gaziantep Üniversitesi Diş Hekimi",
            "Gaziantep Üniversitesi",
            "https://images.unsplash.com/photo-1639149888905-fb39731f2e6c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=464&q=80",
            "https://images.unsplash.com/photo-1455849318743-b2233052fcff?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1169&q=80"
            ),
    )

    lateinit var rvRecommendation: RecyclerView
    lateinit var adapter:RecommendationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendation)

        rvRecommendation = findViewById(R.id.rvRecommendation)

      //  rvRecommendation.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            adapter = RecommendationAdapter(this, recommendation){ recommendation, position ->

            val intent = Intent(this, RecommendationDetail::class.java)
            intent.putExtra("recommendation", recommendation)
            startActivity(intent)
        }
        rvRecommendation.adapter = adapter
    }
}

