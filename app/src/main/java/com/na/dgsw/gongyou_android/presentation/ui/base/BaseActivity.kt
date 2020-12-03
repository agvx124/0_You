package com.na.dgsw.gongyou_android.presentation.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.na.dgsw.gongyou_android.utils.SingleLiveEvent
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

/**
 * Created by NA on 2020-04-16
 * skehdgur8591@naver.com
 */

abstract class BaseActivity<T: ViewDataBinding, VM: BaseViewModel<*>>(clazz: KClass<VM>) : AppCompatActivity(),
    BaseFragment.CallBack {

    protected lateinit var binding: T
    protected val viewModel : VM by viewModel(clazz)

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract val viewModelClass: Class<VM>

    val onErrorEvent = SingleLiveEvent<Throwable>()

    /**
     * Binding 을 위한 함수
     */
    abstract fun getBindingVariable(): Int

    abstract fun setUp()

    abstract fun observerViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
        setUp()
        observerViewModel()
    }

    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId())
//        this.viewModel = if (::viewModel.isInitialized) viewModel else ViewModelProvider(this).get(viewModelClass)
        binding.lifecycleOwner = this
        binding.setVariable(getBindingVariable(), viewModel)
        binding.executePendingBindings()
    }

    fun getViewDataBinding() : T {
        return binding
    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }
}