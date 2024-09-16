package com.example.todo.data.repository

import com.example.todo.data.local.TodoDao
import com.example.todo.model.Todo
import kotlinx.coroutines.flow.Flow

class TodoRepository(
    private val dao: TodoDao
) {
    suspend fun insertTodo(todo: Todo) = dao.insertTodo(todo = todo)

    suspend fun updateTodo(todo: Todo) = dao.updateTodo(todo = todo)

    suspend fun deleteTodo(todo: Todo) = dao.deleteTodo(todo = todo)

    suspend fun getTodoById(id: Int) = dao.getTodoById(id = id)

    fun getAllTodos() : Flow<List<Todo>> = dao.getAllTodos()
}