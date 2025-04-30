package com.example.taskmanager.mvp.view

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.taskmanager.databinding.ActivityMainBinding

class ViewMainActivity(
    contextInstance: Context
) : FrameLayout(contextInstance){

    val binding = ActivityMainBinding.inflate(LayoutInflater.from(context))
}