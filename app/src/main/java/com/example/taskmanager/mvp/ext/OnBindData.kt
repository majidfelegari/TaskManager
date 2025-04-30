package com.example.taskmanager.mvp.ext

import com.example.taskmanager.db.model.TaskEntity

interface OnBindData {

    fun saveData(taskEntity: TaskEntity) {}

    fun editData(taskEntity: TaskEntity) {}
}