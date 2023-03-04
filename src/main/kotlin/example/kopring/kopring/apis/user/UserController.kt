package example.kopring.kopring.apis.user

import example.kopring.kopring.apis.user.dtos.CreateUserRequestDto
import example.kopring.kopring.apis.user.entities.UserEntity
import example.kopring.kopring.common.response.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/users")
class UserController(private val userService: UserService) {

    @GetMapping("/{userId}")
    fun fetchUser(@PathVariable userId: Long): ResponseEntity<ApiResponse<Any>> {
        val user = userService.getUserById(userId)
        return ApiResponse.success("data", user)
    }

    @GetMapping("")
    fun fetchAllUsers(): ResponseEntity<ApiResponse<Any>> {
        val users = userService.fetchAllUser()
        return ApiResponse.success("data", users)
    }

    @PostMapping("")
    fun createUser(@RequestBody createUserRequestDto: CreateUserRequestDto): ResponseEntity<ApiResponse<Any>> {
        val createdUser = userService.createUser(createUserRequestDto)
        return ApiResponse.success("data", createdUser)
    }
}