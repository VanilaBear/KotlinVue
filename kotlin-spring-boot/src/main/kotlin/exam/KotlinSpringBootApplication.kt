package exam


import exam.model.Advertisement
import exam.persistence.AdvertisementRepository
import exam.security.Credentials
import org.litote.kmongo.KMongo
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.litote.kmongo.*

@SpringBootApplication
open class KotlinSpringBootApplication {

	@Bean
	open fun init() = CommandLineRunner {
//		repository.save(Advertisement("Jack", "Bauer", "hi"))
//		repository.save(Advertisement("Chloe", "O'Brian", "hi"))
//		repository.save(Advertisement("Kim", "Bauer", "hi"))
//		repository.save(Advertisement("David", "Palmer", "hi"))
//     	repository.save(Advertisement("Michelle", "Dessler"))

//		data class Counters(val _id: String, val sequence_value: Int)
//
//		val client = KMongo.createClient("localhost:27007")
//		val database = client.getDatabase("ads")
//		val counters = database.getCollection<Counters>()
//
//		counters.insertOne(Counters("productid", 1))

	}


}

fun main(args: Array<String>) {

	SpringApplication.run(KotlinSpringBootApplication::class.java, *args)
}
