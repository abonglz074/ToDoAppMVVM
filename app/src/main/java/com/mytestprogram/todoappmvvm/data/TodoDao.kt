package com.mytestprogram.todoappmvvm.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //That means when ew insert the same todo it will replace the old one
    suspend fun insertTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)

    @Query("SELECT * FROM todo WHERE id = :id")
    //Custom sql query, that says "SELECT all the properties FROM our to-do table
    // WHERE the id is equals the :id we passed"
    suspend fun getTodoById(id: Int): Todo?
    //If the id doesn't exist we want to be sure that app doesn't crush


    @Query("SELECT * FROM todo")
    fun getTodos(): Flow<List<Todo>>
    //We basically get real-time updates as soon as something in our database changes
    //When something happens (insert, delete, etc.) this Flow will trigger again and
    //give us the new and updated list of todo's
}