package exam.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

	@GetMapping("/")
	fun helloKotlin(): String {
		return "hello world"
	}
}
