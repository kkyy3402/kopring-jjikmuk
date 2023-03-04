package example.kopring.kopring.apis.user

import example.kopring.kopring.apis.user.dtos.CreateUserRequestDto
import example.kopring.kopring.apis.user.dtos.UserDto
import example.kopring.kopring.apis.user.entities.UserEntity
import example.kopring.kopring.apis.user.repositories.UserRepository
import example.kopring.kopring.common.exception.custom_exceptions.UserNotFoundException
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class UserService(private val userRepository: UserRepository) {

    fun getUserById(userId: Long): UserDto {

        val findUser = userRepository.findById(userId)

        if (findUser.isEmpty) {
            throw UserNotFoundException()
        }

        return UserDto.fromEntity(findUser.get())
    }

    fun fetchAllUser(): List<UserDto> {

        val findUser = userRepository.findAll()
        return findUser.map {
            UserDto.fromEntity(it)
        }
    }

    fun createUser(createUserRequestDto: CreateUserRequestDto): UserDto {

        //lombok builder왜 안되는거지..
        //https://d2.naver.com/helloworld/6685007
        //kotlin이랑 lombok 같이 못쓰는거 같다. ,...,.,.,.,.,.,??

        val newUser = UserEntity()
        newUser.userName = createUserRequestDto.userName
        newUser.address = createUserRequestDto.address

        val createdUserEntity = userRepository.save(newUser)
        return UserDto.fromEntity(createdUserEntity)
    }
}