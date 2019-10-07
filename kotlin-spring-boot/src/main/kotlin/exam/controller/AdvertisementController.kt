package exam.controller

import exam.model.Advertisement
import exam.persistence.AdvertisementRepository
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ads")
class AdvertisementController(val repository: AdvertisementRepository) {

	@GetMapping
	fun findAll() = repository.findAll()

	@PostMapping
	fun addAd(@RequestBody ad: Advertisement)
			= repository.save(ad)

	@PutMapping("/{id}")
	fun updateAd(@PathVariable id: Int, @RequestBody ad: Advertisement) {
		assert(ad.id == id)
		repository.save(ad)
		repository.delete(id)
	}

	@DeleteMapping("/{id}")
	fun removeAd(@PathVariable id: Int)
			= repository.delete(id)

	@GetMapping("/{id}")
	fun getById(@PathVariable id: Int)
			= repository.findOne(id)
}

