package inkant1990.com.data.entity

import inkant1990.com.domain.entity.User

fun UserResponse.transform():User{
    return User(name,status, id,latitude,longitude,rating,votes)
}

fun User.transform():UserRequest{
    return UserRequest(name,latitude,longitude,rating,votes )
}
