package com.dicoding.todoapp.ui.detail

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dicoding.todoapp.R
import com.dicoding.todoapp.ui.ViewModelFactory
import com.dicoding.todoapp.utils.TASK_ID

class DetailTaskActivity : AppCompatActivity() {

    private lateinit var detailTaskViewModel: DetailTaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        val titleTask = findViewById<TextView>(R.id.detail_ed_title)
        val descriptionTask = findViewById<TextView>(R.id.detail_ed_description)
        val dateTask = findViewById<TextView>(R.id.detail_ed_due_date)
        val btnDeleteTask = findViewById<Button>(R.id.btn_delete_task)

        //TODO 11 : Show detail task and implement delete action
        val i = intent.getIntExtra(TASK_ID, 0)
        val factory = ViewModelFactory.getInstance(this)
        detailTaskViewModel = ViewModelProvider(this, factory)[DetailTaskViewModel::class.java]
        detailTaskViewModel.setTaskId(i)

        detailTaskViewModel.task.observe(this, {
            titleTask.text = it?.title
            descriptionTask.text = it?.description
            dateTask.text = it?.dueDateMillis.toString()
        })

        btnDeleteTask.setOnClickListener {
            detailTaskViewModel.deleteTask()

            super.onBackPressed()
        }
    }
}