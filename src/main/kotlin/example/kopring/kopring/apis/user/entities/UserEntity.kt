package example.kopring.kopring.apis.user.entities

import com.fasterxml.jackson.annotation.JsonManagedReference
import example.kopring.kopring.apis.todo.entity.TodoEntity
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*
import java.time.LocalDateTime

@Builder(builderMethodName = "builder")
@Data
@NoArgsConstructor
@JvmSuppressWildcards
@Entity
@Table(name = "TB_USERS")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long? = null,

    @Column(nullable = false)
    var userName: String,

    var address: String? = null,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now(),

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    var todos: MutableList<TodoEntity> = mutableListOf()

) {
    // 이걸 하는 이유가 뭐지 안하면 에러난다.
    constructor() : this(null, "", null, LocalDateTime.now(), LocalDateTime.now(), mutableListOf())

}