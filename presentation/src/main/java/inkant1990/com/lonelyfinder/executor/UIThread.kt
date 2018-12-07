package inkant1990.com.lonelyfinder.executor

import inkant1990.com.domain.executor.PostExecutorThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class UIThread @Inject constructor() : PostExecutorThread {

    override fun getScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}