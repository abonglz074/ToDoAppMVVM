package com.mytestprogram.todoappmvvm.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity is basically a class or a table that contains a data you want to save.
@Entity
data class Todo(
    val title: String,
    val description: String?,
    val isDone: Boolean,
    @PrimaryKey val id: Int? = null
)
