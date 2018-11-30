package com.example.vlad.testproject.di.screen.main

import com.example.vlad.testproject.di.screen.ScreenScope
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(MainScreenModule::class))
@ScreenScope
interface MainScreenComponent {
}