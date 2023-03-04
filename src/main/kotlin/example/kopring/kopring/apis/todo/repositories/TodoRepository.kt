package example.kopring.kopring.apis.todo.repositories

import example.kopring.kopring.apis.todo.entity.TodoEntity
import example.kopring.kopring.apis.user.entities.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : CrudRepository<TodoEntity, Long>