package com.example.kotlin_project_theater.data

import android.app.Application

class CinemaApplication : Application() {
  override fun onCreate() {
    super.onCreate()
    Graph.initialize(this)
  }
}