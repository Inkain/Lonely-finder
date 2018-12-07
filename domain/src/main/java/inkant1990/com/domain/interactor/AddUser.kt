package inkant1990.com.domain.interactor

import inkant1990.com.domain.entity.User
import inkant1990.com.domain.executor.PostExecutorThread
import inkant1990.com.domain.repository.UserRepositoryImpl
import io.reactivex.Flowable
import javax.inject.Inject

class AddUser @Inject constructor(
    val userRepositoryImpl: UserRepositoryImpl,
    postExecutorThread: PostExecutorThread
) : UseCase<User, User>(postExecutorThread) {
    override fun buildUseCaseObservable(params: User): Flowable<User> {
        return userRepositoryImpl.addUser(params)
    }
}