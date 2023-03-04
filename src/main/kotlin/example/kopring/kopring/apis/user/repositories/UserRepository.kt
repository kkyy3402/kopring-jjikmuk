package example.kopring.kopring.apis.user.repositories

import example.kopring.kopring.apis.user.entities.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<UserEntity, Long> {
    fun findByUserName(userName: String): UserEntity?
}