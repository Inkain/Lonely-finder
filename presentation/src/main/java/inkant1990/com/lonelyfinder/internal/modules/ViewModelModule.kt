package inkant1990.com.lonelyfinder.internal.modules

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import inkant1990.com.lonelyfinder.viewModelFactory.ViewModelFactory

@Module
abstract class ViewModelModule {


    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory):
            ViewModelProvider.Factory


}