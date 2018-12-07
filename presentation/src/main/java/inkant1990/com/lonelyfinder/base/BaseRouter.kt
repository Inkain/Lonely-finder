package inkant1990.com.lonelyfinder.base

import android.app.Activity
import android.support.v4.app.FragmentManager

abstract class BaseRouter<T : Activity>(val activity: T) {

    fun replaceFragment(manager:FragmentManager, fragment: BaseFragment, id:Int, backStack:Boolean=false){
            val fragmentTransition = manager.beginTransaction()
            fragmentTransition.replace(
                id, fragment,
                fragment::class.java.canonicalName
            )
            if (backStack) {
                fragmentTransition.addToBackStack(null)
            }

            fragmentTransition.commit()
        }
    }


