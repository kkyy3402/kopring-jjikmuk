package example.kopring.kopring.apis.todo.dtos

import java.time.LocalDateTime

data class TodoDto(
    val todoId: Long?,
    val todoName: String,
    val description: String?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val userId: Long?
)