package exam.persistence

import exam.model.Advertisement
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.CrudRepository
import java.rmi.server.ObjID

interface AdvertisementRepository : MongoRepository<Advertisement, Int> {
	fun findById(id: Long): Advertisement?
}
