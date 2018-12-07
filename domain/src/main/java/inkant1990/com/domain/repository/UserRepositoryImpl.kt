package inkant1990.com.domain.repository

import inkant1990.com.domain.entity.User
import io.reactivex.Flowable

interface UserRepositoryImpl {

    fun getUsers(): Flowable<List<User>>
    fun addUser(user: User): Flowable<User>
}