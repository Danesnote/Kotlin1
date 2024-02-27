package com.app.myapp1.config

import android.app.Application
import com.app.myapp1.repository.TodoRepository

class ApplicationClass: Application() {

    override fun onCreate() {
        super.onCreate()

        TodoRepository.initialize(this)
    }
}
