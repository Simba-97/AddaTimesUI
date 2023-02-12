package com.simba.addatimes

import android.app.Application
import com.simba.addatimes.di.component.AppComponent
import dagger.hilt.EntryPoints
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AddaTimes : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        component().inject(this)
    }

    fun component(): AppComponent {
        return EntryPoints.get(this, AppComponent::class.java)
    }

    companion object {
        @get:Synchronized
        lateinit var instance: AddaTimes
    }
}