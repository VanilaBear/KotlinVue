package exam.controller


import exam.model.ApplicationUser
import exam.service.UserDetailsServiceImpl
//import org.hibernate.validator.internal.util.Contracts.assertNull
import org.litote.kmongo.KMongo
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*
import java.util.*


@CrossOrigin
@RestController
@RequestMapping("/sign-up")
class SignUpController(val userDetailsService: UserDetailsServiceImpl, val bCryptPasswordEncoder: BCryptPasswordEncoder) {

	class UserAlreadyExistsException(override val message: String?) : Exception(message)

	data class ErrorsDetails(val time: Date, val message: String, val details: String)

	@PostMapping
	fun signUp(@RequestBody applicationUser: ApplicationUser) {
		val client = KMongo.createClient("localhost:27007")
		val database = client.getDatabase("ads")
		val counters = database.getCollection<ApplicationUser>()

		val username : ApplicationUser? = counters.findOne(ApplicationUser::username eq "${applicationUser.username}")
		if (username != null){
			throw UserAlreadyExistsException("User with username ${applicationUser.username} already exists")
		}

		applicationUser.password = bCryptPasswordEncoder.encode(applicationUser.password)
		userDetailsService.save(applicationUser)
	}
}
