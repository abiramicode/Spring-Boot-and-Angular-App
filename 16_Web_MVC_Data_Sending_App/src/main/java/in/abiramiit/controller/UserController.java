package in.abiramiit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import in.abiramiit.binding.User;

@Controller    
public class UserController {
	
	@GetMapping("/user")
	public String getUserData(Model model) { 
		User userObj = new User(101, "Abirami","abirami@gmail.com");
		model.addAttribute("user", userObj);
		return "user-data";
	}
	
	@GetMapping("/email")
	public String getUserEmail(Model model) { 
		model.addAttribute("data", "abirami@gmail.com");
		return "index";  
	}

	@GetMapping("/name")  
	public ModelAndView getUserName() {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", "Abirami");
		mav.setViewName("index");
		return mav;
	}
}
