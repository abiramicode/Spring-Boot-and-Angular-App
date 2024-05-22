package in.abiramiit.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MsgRestController {

	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		System.out.println("welcome () method executed...");
		return "Weclome Abirami";
	}

	@GetMapping("/greet")
	public String getGreetMsg() {
		System.out.println("greet () method executed...");
		return "Good Morning";
	}
}
