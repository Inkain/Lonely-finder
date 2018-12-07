package inkant1990.com.domain.interactor

import inkant1990.com.domain.entity.User
import inkant1990.com.domain.executor.PostExecutorThread
import inkant1990.com.domain.repository.UserRepositoryImpl
import io.reactivex.Flowable
import javax.inject.Inject

class GetUsers @Inject constructor(val userRepositoryImpl: UserRepositoryImpl,
                                   postExecutorThread: PostExecutorThread
) :UseCase<List<User>,Unit>(postExecutorThread){
    override fun buildUseCaseObservable(params: Unit): Flowable<List<User>> {
        return userRepositoryImpl.getUsers()
    }
}