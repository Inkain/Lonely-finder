package inkant1990.com.lonelyfinder.internal.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import inkant1990.com.data.repository.UserRepository
import inkant1990.com.domain.executor.PostExecutorThread
import inkant1990.com.domain.repository.UserRepositoryImpl
import inkant1990.com.lonelyfinder.AndroidApplication
import inkant1990.com.lonelyfinder.executor.UIThread
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton


@Module(
)
class ApplicationModule(private val app: AndroidApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = app

    @Provides
    @NotNull
    @Singleton
    fun userRepository(userRepository: UserRepository): UserRepositoryImpl {

        return userRepository
    }

    @Provides
    @NotNull
    @Singleton
    fun uiThread(thread: UIThread): PostExecutorThread {

        return thread
    }


}