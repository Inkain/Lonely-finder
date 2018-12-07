package inkant1990.com.data.net

import inkant1990.com.data.entity.UserRequest
import inkant1990.com.data.entity.UserResponse
import io.reactivex.Flowable
import javax.inject.Inject

class ApiGet @Inject constructor() {

    private var api: LeagueApi = ApiModule.api()
    fun getUsers(): Flowable<List<UserResponse>> {
        return api.getUsers()
    }
    fun addUser(userRequest: UserRequest):Flowable<UserResponse>{
        return api.addUser(userRequest)
    }


}