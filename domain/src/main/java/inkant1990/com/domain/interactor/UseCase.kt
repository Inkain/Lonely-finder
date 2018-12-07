package inkant1990.com.domain.interactor

import inkant1990.com.domain.executor.PostExecutorThread
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers


abstract class UseCase<T, Params> constructor(
    val postExecutorThread: Scheduler,
    val workExecutorThread: Scheduler = Schedulers.io()
) {
    constructor(postExecutorThread: PostExecutorThread) : this(postExecutorThread.getScheduler())

    abstract fun buildUseCaseObservable(params: Params): Flowable<T>
    fun execute(params: Params): Flowable<T> {
        return this.buildUseCaseObservable(params).take(1).retry(8).subscribeOn(workExecutorThread)
            .observeOn(postExecutorThread)
    }

}