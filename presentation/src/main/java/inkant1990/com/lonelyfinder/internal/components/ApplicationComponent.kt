package inkant1990.com.lonelyfinder.internal.components

import dagger.Component
import inkant1990.com.lonelyfinder.internal.modules.ApplicationModule
import inkant1990.com.lonelyfinder.internal.modules.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {

}

