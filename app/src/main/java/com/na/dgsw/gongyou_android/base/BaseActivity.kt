package com.na.dgsw.gongyou_android.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider

/**
 * Created by NA on 2020-04-16
 * skehdgur8591@naver.com
 */

abstract class BaseActivity<T: ViewDataBinding, V: BaseViewModel<*>> : AppCompatActivity(), BaseFragment.CallBack {

    private lateinit var mViewDataBinding: T
    private lateinit var viewModel : V

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract val viewModelClass: Class<V>

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
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        this.viewModel = if (::viewModel.isInitialized) viewModel else ViewModelProvider(this).get(viewModelClass)
        mViewDataBinding.lifecycleOwner = this
        mViewDataBinding.setVariable(getBindingVariable(), viewModel)
        mViewDataBinding.executePendingBindings()
    }

    fun getViewDataBinding() : T {
        return mViewDataBinding
    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }
}