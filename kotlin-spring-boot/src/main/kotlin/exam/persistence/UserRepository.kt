package exam.persistence

import exam.model.ApplicationUser
import org.springframework.data.mongodb.repository.MongoRepository


interface UserRepository : MongoRepository<ApplicationUser, String> {
	fun findByUsername(username: String): ApplicationUser?
}
