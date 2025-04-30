package com.example.taskmanager.mvp.model

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.taskmanager.db.DBHandler
import com.example.taskmanager.db.model.TaskEntity
import com.example.taskmanager.mvp.ext.OnBindData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ModelMainActivity(private val activity: AppCompatActivity) {
    private val db = DBHandler.getDatabase(activity)

    fun setData(taskEntity: TaskEntity) {
        activity.lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                db.taskDao().insertTask(taskEntity)
            }
        }
    }

    fun getData(state: Boolean, onBindData: OnBindData){
        activity.lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val tasks = db.taskDao().getTasksByColumn(state)
                withContext(Dispatchers.Main){
                    tasks.collect{
                        onBindData.getData(it)
                    }
                }
            }
        }
    }

    fun editData(taskEntity: TaskEntity) {
        activity.lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                db.taskDao().updateTasks(taskEntity)
            }
        }
    }

    fun deleteData(taskEntity: TaskEntity) {
        activity.lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                db.taskDao().deleteTasks(taskEntity)
            }
        }
    }


    fun closeDataBase() {
        db.close()
    }
}