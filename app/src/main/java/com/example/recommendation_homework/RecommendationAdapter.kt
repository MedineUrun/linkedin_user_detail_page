package com.example.recommendation_homework

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.load

class RecommendationAdapter constructor(
    val context: Context,
    val recommendations:MutableList<Recommendation>,
    val onClick:(recommendation:Recommendation, position:Int ) -> Unit
):
    RecyclerView.Adapter<RecommendationAdapter.RecommendationViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecommendationAdapter.RecommendationViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recommendation_list_item, parent, false)
        return RecommendationViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: RecommendationAdapter.RecommendationViewHolder,
        position: Int
    ) {
        val recommendation = recommendations[position]

        holder.ivProfile.load(recommendation.profile)
        holder.bannerView.load(recommendation.banner)
        holder.tvUserName.text = "${recommendation.name}"
        holder.tvUserInfo.text = "${recommendation.career}"
        holder.tvUserUni.text = "${recommendation.university}"

        holder.btnConnect.setOnClickListener{
            holder.btnConnect.text = "Pending"
        }

        holder.myItemView.setOnClickListener {
            onClick(recommendation,position)
        }


        holder.btnDelete.setOnClickListener{
            if (position != -1) {
                val removedRecommendationIndex = recommendations.indexOf(recommendation)
                recommendations.remove(recommendation)
                notifyItemRemoved(removedRecommendationIndex)
            }
        }
    }

    override fun getItemCount(): Int {
        return recommendations.size
    }

    class RecommendationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val myItemView = itemView
        val ivProfile: ImageView = itemView.findViewById(R.id.ivProfile)
        val tvUserName: TextView = itemView.findViewById(R.id.tvUserName)
        val tvUserInfo: TextView = itemView.findViewById(R.id.tvUserInfo)
        val tvUserUni: TextView = itemView.findViewById(R.id.tvUserUni)
        val btnConnect : Button = itemView.findViewById(R.id.btnConnect)
        val bannerView : ImageView = itemView.findViewById(R.id.bannerView)
        val btnDelete : ImageView = itemView.findViewById(R.id.btnDelete)

    }

    }
