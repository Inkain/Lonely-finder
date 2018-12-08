package inkant1990.com.data.entity

import com.google.gson.annotations.SerializedName

data class UserResponse(val name:String,
                @SerializedName("objectid")
                val id:String,
                val status:String?,val latitude:Double,val longitude:Double?,val rating:String?,val votes:String?)