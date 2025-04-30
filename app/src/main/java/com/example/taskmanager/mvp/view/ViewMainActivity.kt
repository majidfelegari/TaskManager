package com.example.taskmanager.mvp.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.Toast
import com.example.taskmanager.databinding.ActivityMainBinding
import com.example.taskmanager.databinding.CustomDialogBinding

class ViewMainActivity(
    contextInstance: Context
) : FrameLayout(contextInstance){

    val binding = ActivityMainBinding.inflate(LayoutInflater.from(context))

    fun showDialog(){
        binding.fab.setOnClickListener{
            val view = CustomDialogBinding.inflate(LayoutInflater.from(context))

            val dialog = Dialog(context)
            dialog.setContentView(view.root)
            dialog.setCancelable(false)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()

            view.btnCancel.setOnClickListener{ dialog.dismiss() }

            view.btnSave.setOnClickListener{
                val text = view.edtTask.text.toString()
                if (text.isNotEmpty()){
                    //save to database
                } else
                    Toast.makeText(context, "لطفا وظیفه را وارد کنید", Toast.LENGTH_SHORT).show()
            }
        }
    }
}