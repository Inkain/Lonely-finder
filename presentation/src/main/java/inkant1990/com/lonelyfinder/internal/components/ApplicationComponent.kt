package inkant1990.com.lonelyfinder.internal.components

import dagger.Component
import inkant1990.com.lonelyfinder.AndroidApplication
import inkant1990.com.lonelyfinder.internal.modules.ApplicationModule
import inkant1990.com.lonelyfinder.internal.modules.ViewModelModule
import inkant1990.com.lonelyfinder.screen.map.MapActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(androidApplication: AndroidApplication)
    fun inject(mapActivity: MapActivity)
}

