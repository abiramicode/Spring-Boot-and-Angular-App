package in.abiramiit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	@GetMapping("/hi")
	public String sayHello() {
		return "Hello, Welcome Abirami...!!!";
	}
}
