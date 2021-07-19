package com.dicoding.todoapp.ui.list

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.dicoding.todoapp.R
import org.junit.Before
import org.junit.Test

//TODO 16 : Write UI test to validate when user tap Add Task (+), the AddTaskActivity displayed
class TaskActivityTest {
    @Before
    fun setup(){
        ActivityScenario.launch(TaskActivity::class.java)
    }

    @Test
    fun testUI(){
        onView(withId(R.id.fab))
            .perform(ViewActions.click())
    }
}