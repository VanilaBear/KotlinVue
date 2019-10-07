package exam.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.Entity
import javax.persistence.Id
import java.util.Random



@Entity
class Advertisement(

	var author: String = "",

	var msg: String = "",

	var aproved: Boolean = false,

	var date: LocalDateTime = LocalDateTime.now(),

	@Id
	var id: Int =  Random().nextInt()
)
