package example.kopring.kopring.apis.todo

import example.kopring.kopring.apis.todo.dtos.AddTodoRequestDto
import example.kopring.kopring.common.response.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/users/")
class TodoController(private val todoService: TodoService) {

    @PostMapping("/{userId}/todo")
    fun addTodoToUser(
        @PathVariable("userId") userId: Long,
        @RequestBody addTodoRequestDto: AddTodoRequestDto
    ): ResponseEntity<ApiResponse<Any>> {

        val savedTodo = todoService.addTodo(userId, addTodoRequestDto)
        return ApiResponse.success("data", savedTodo)
    }

}


