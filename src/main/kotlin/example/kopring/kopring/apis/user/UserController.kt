package example.kopring.kopring.apis.user

import example.kopring.kopring.apis.user.dtos.CreateUserRequestDto
import example.kopring.kopring.apis.user.entities.UserEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/users")
class UserController(private val userService: UserService) {

    @GetMapping("/{userId}")
    fun fetchUser(@PathVariable userId: Long): ResponseEntity<Any> {
        val user = userService.getUserById(userId)
        return ResponseEntity.ok(user)
    }

    @GetMapping("")
    fun fetchAllUsers(): ResponseEntity<Any> {
        val users = userService.fetchAllUser()
        return ResponseEntity.ok(users)
    }

    @PostMapping("")
    fun createUser(@RequestBody createUserRequestDto: CreateUserRequestDto): ResponseEntity<Any> {
        val createdUser = userService.createUser(createUserRequestDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser)
    }
}