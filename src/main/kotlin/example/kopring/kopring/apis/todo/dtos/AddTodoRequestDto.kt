package example.kopring.kopring.apis.todo.dtos

data class AddTodoRequestDto(
    val todoName: String,
    val description: String?
)