package com.example.taskmanager.mvp.presenter

import com.example.taskmanager.mvp.ext.BaseLifeCycle
import com.example.taskmanager.mvp.model.ModelMainActivity
import com.example.taskmanager.mvp.view.ViewMainActivity

class PresenterMainActivity(
    private val view: ViewMainActivity,
    private val model: ModelMainActivity
) : BaseLifeCycle {
    override fun onCreate() {

    }

}