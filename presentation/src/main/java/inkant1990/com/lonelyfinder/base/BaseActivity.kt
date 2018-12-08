package inkant1990.com.lonelyfinder.base

import android.support.v4.app.FragmentActivity
import inkant1990.com.lonelyfinder.AndroidApplication
import inkant1990.com.lonelyfinder.internal.components.ApplicationComponent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseActivity : FragmentActivity() {

//    val appComponent:ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE){
//        (this.application as AndroidApplication).component
//    }

    protected val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    protected fun addToDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}



