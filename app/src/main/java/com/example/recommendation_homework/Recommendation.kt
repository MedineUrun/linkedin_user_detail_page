package com.example.recommendation_homework

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recommendation(val id:Int, val name:String, val career:String, val university:String, val profile:String, val banner:String):
    Parcelable {

}
