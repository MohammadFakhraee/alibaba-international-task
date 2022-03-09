package ir.mohammadhf.alibabainternationaltask.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "users")
data class User(

    @field:Json(name = "id")
    @PrimaryKey(autoGenerate = false)
    var id: Int,

    @field:Json(name = "first_name")
    var firstName: String,

    @field:Json(name = "last_name")
    var lastName: String,

    @field:Json(name = "avatar")
    var avatar: String,

    @field:Json(name = "email")
    var email: String
)