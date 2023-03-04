package example.kopring.kopring.apis.user.dtos

import example.kopring.kopring.apis.user.entities.UserEntity
import java.time.LocalDateTime

data class UserDto(
    val userId: Long? = null,
    val userName: String,
    val address: String? = null,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
) {
    companion object {
        fun fromEntity(entity: UserEntity): UserDto {
            return UserDto(
                userId = entity.userId,
                userName = entity.userName,
                address = entity.address,
                createdAt = entity.createdAt,
                updatedAt = entity.updatedAt
            )
        }
    }

    fun toEntity(): UserEntity {
        return UserEntity(
            userId = this.userId,
            userName = this.userName,
            address = this.address,
            createdAt = this.createdAt ?: LocalDateTime.now(),
            updatedAt = this.updatedAt ?: LocalDateTime.now()
        )
    }
}