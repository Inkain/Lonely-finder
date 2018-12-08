package inkant1990.com.lonelyfinder

import android.app.Application
//import inkant1990.com.lonelyfinder.internal.components.DaggerApplicationComponent
import inkant1990.com.lonelyfinder.internal.modules.ApplicationModule


class AndroidApplication : Application() {
    companion object {
        lateinit var instance :AndroidApplication
    }
    init {
        instance=this
    }

    val component by lazy(mode = LazyThreadSafetyMode.NONE) {
//        DaggerApplicationComponent.builder()
//            .applicationModule(ApplicationModule(this))
//            .build()
    }

    override fun onCreate() {
        super.onCreate()
//        injectMembers()
    }

//    private fun injectMembers() = component.inject(this)
}