package inkant1990.com.lonelyfinder.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import inkant1990.com.lonelyfinder.BR

abstract class BaseMvvmActivity<VM : BaseViewModel<R>,
        B : ViewDataBinding, R : BaseRouter<*>> : BaseActivity() {

    protected lateinit var viewModel: VM
    protected lateinit var binding: B
    lateinit var router: R


    abstract fun prodiveViewModel(): VM

    abstract fun provideLayoutId(): Int
    abstract fun provideRouter(): R
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = prodiveViewModel()
        binding = DataBindingUtil.setContentView(this, provideLayoutId())
        binding.setVariable(BR._all, viewModel)
        router = provideRouter()
    }

    override fun onResume() {
        super.onResume()
        viewModel.addRouter(router)

    }

    override fun onPause() {
        super.onPause()
        viewModel.removeRouter()
        compositeDisposable.clear()
    }

}