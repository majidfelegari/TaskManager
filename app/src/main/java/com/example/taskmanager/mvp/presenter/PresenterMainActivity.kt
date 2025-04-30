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
        setDataInitRecycler()
        dataHandler()
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

    private fun setDataInitRecycler() {
        view.initRecycler(
            arrayListOf(),
            object : OnBindData {
                override fun editData(taskEntity: TaskEntity) {
                    model.editData(taskEntity)
                }

                override fun deleteData(taskEntity: TaskEntity) {
                    model.deleteData(taskEntity)
                }
            }
        )
    }

    private fun dataHandler(){
        view.setData(
            object : OnBindData{
                override fun requestData(state: Boolean) {
                    model.getData(
                        state,
                        object : OnBindData{
                            override fun getData(taskEntity: List<TaskEntity>) {
                                view.showTask(taskEntity)
                            }
                        }
                    )
                }
            }
        )
    }


    override fun onDestroy() {
        model.closeDataBase()
    }
}