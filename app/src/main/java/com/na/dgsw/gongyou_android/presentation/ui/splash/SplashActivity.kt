package com.na.dgsw.gongyou_android.presentation.ui.splash

import android.animation.Animator
import android.content.Intent
import android.util.Log
import com.na.dgsw.gongyou_android.BR
import com.na.dgsw.gongyou_android.R
import com.na.dgsw.gongyou_android.presentation.ui.base.BaseActivity
import com.na.dgsw.gongyou_android.databinding.ActivitySplashBinding
import com.na.dgsw.gongyou_android.presentation.ui.main.activity.MainActivity

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(SplashViewModel::class) {
    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override val viewModelClass: Class<SplashViewModel>
        get() = SplashViewModel::class.java

    override fun getBindingVariable(): Int {
         return BR.viewModel
    }

    override fun setUp() {
        binding.animationView.playAnimation()

        binding.animationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
                Log.e("Animation:","onAnimationRepeat");
            }

            override fun onAnimationEnd(animation: Animator?) {
                Log.e("Animation:","onAnimationEnd");

                Thread.sleep(1000)
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }

            override fun onAnimationCancel(animation: Animator?) {
                Log.e("Animation:","onAnimationCancel");
            }

            override fun onAnimationStart(animation: Animator?) {
                Log.e("Animation:","onAnimationStart");
            }

        })
    }

    override fun observerViewModel() {

    }


}
