package example.kopring.kopring.apis.todo

import example.kopring.kopring.apis.todo.dtos.AddTodoRequestDto
import example.kopring.kopring.apis.todo.dtos.TodoDto
import example.kopring.kopring.apis.todo.entity.TodoEntity
import example.kopring.kopring.apis.todo.entity.toDto
import example.kopring.kopring.apis.todo.repositories.TodoRepository
import example.kopring.kopring.apis.user.repositories.UserRepository
import example.kopring.kopring.common.exception.custom_exceptions.UserNotFoundException
import org.springframework.stereotype.Service

@Service
class TodoService(
    private val userRepository: UserRepository,
    private val todoRepository: TodoRepository
) {
    fun addTodo(userId: Long, addTodoRequestDto: AddTodoRequestDto): TodoDto {
        val user = userRepository.findById(userId)

        if (user.isEmpty) {
            throw UserNotFoundException()
        }

        val newTodo = TodoEntity()
        newTodo.todoName = addTodoRequestDto.todoName
        newTodo.description = addTodoRequestDto.description
        newTodo.user = user.get()
        
        return todoRepository.save(newTodo).toDto(user.get().userId)
    }
}

