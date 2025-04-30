package com.example.taskmanager.mvp.ext

import com.example.taskmanager.db.model.TaskEntity

interface OnBindData {

    fun saveData(taskEntity: TaskEntity) {}

    fun editData(taskEntity: TaskEntity) {}

    fun getData(taskEntity: List<TaskEntity>) {}

    fun requestData(state: Boolean) {}

    fun deleteData(taskEntity: TaskEntity) {}
}