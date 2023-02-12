package com.simba.addatimes.di.component

import com.simba.addatimes.AddaTimes
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@EntryPoint
interface AppComponent {
    fun inject(app: AddaTimes?)
}