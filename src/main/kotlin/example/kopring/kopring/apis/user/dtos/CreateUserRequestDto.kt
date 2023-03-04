package example.kopring.kopring.apis.user.dtos

data class CreateUserRequestDto(
    val userName: String,
    val address: String?
)