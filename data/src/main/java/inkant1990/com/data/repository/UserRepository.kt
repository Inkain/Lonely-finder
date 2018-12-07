package inkant1990.com.data.repository

import inkant1990.com.data.Utils
import inkant1990.com.data.entity.transform
import inkant1990.com.data.net.ApiGet
import inkant1990.com.domain.entity.User
import inkant1990.com.domain.repository.UserRepositoryImpl
import io.reactivex.Flowable
import javax.inject.Inject

class UserRepository @Inject constructor(val utils: Utils, val api: ApiGet) : UserRepositoryImpl {

    override fun getUsers(): Flowable<List<User>> {
        return api.getUsers().map {
            it.map { it.transform() }
        }
    }

    override fun addUser(user: User): Flowable<User> {
        return api.addUser(user.transform()).map {
            it.transform()
        }
    }
}