package example.kopring.kopring.apis.todo.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import example.kopring.kopring.apis.todo.dtos.TodoDto
import example.kopring.kopring.apis.user.entities.UserEntity
import lombok.Builder
import lombok.Data
import java.time.LocalDateTime
import javax.persistence.*

@Builder(builderMethodName = "builder")
@Data
@Entity
@Table(name = "TB_TODOS")
data class TodoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val todoId: Long? = null,

    @Column(nullable = false)
    var todoName: String,

    var description: String? = null,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now(),
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: UserEntity? = null

) {
    constructor() : this(null, "", null, LocalDateTime.now(), LocalDateTime.now(), null)


}

fun TodoEntity.toDto(userId: Long?): TodoDto {
    return TodoDto(
        todoId = this.todoId,
        todoName = this.todoName,
        description = this.description,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
        userId = userId
    )
}