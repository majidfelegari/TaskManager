package com.example.taskmanager.mvp.presenter

import com.example.taskmanager.db.model.TaskEntity
import com.example.taskmanager.mvp.ext.BaseLifeCycle
import com.example.taskmanager.mvp.ext.OnBindData
import com.example.taskmanager.mvp.model.ModelMainActivity
import com.example.taskmanager.mvp.view.ViewMainActivity

class PresenterMainActivity(
    private val view: ViewMainActivity,
    private val model: ModelMainActivity
) : BaseLifeCycle {
    override fun onCreate() {
        setNewTask()
    }

    private fun setNewTask(){
        view.showDialog(
            object : OnBindData {
                override fun saveData(taskEntity: TaskEntity) {
                    model.setData(taskEntity)
                }
            }
        )
    }
}