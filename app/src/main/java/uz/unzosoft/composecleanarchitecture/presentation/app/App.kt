package uz.unzosoft.composecleanarchitecture.presentation.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/**
 * Created by Abdurashidov Shahzod on 31/12/21 20:41.
 * company QQBank
 * shahzod9933@gmail.com
 */
@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}