package com.example.taskmanager.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taskmanager.mvp.model.ModelMainActivity
import com.example.taskmanager.mvp.presenter.PresenterMainActivity
import com.example.taskmanager.mvp.view.ViewMainActivity

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: PresenterMainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = ViewMainActivity(this)
        setContentView(view.binding.root)

        presenter = PresenterMainActivity(view, ModelMainActivity(this))
        presenter.onCreate()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}