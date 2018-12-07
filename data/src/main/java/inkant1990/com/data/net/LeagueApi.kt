package inkant1990.com.data.net

import inkant1990.com.data.entity.UserRequest
import inkant1990.com.data.entity.UserResponse
import io.reactivex.Flowable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PUT

interface LeagueApi {

    @GET("lonely")
    fun getUsers(): Flowable<List<UserResponse>>

    @Headers("Content-Type:application/json")
    @PUT("lonely")
    fun addUser(@Body userRequest: UserRequest): Flowable<UserResponse>

}