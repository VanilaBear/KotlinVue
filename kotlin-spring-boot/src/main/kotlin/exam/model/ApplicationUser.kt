package exam.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id


@Entity
data class ApplicationUser(
	@Id
	var id: Long = Random().nextLong(),

	var username: String = "",

	var password: String = ""
)
