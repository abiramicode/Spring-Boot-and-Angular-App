package in.abiramiit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller   
public class MsgController {

	public MsgController() {
		System.out.println("MsgController:: Costructor Called.....");
	}
	
	@GetMapping("/greet")
	public ModelAndView getGreetMsg() {
		
		ModelAndView mav = new ModelAndView(); 
		mav.addObject("msg", "All the best..!!"); 
		mav.setViewName("index");
		return mav;
	}
	
	
	@GetMapping("/welcome")		
	public ModelAndView getWelcomeMsg() {
		
		ModelAndView mav = new ModelAndView(); 
		mav.addObject("msg", "Welcome to Abirami....!!");
		mav.setViewName("index"); 
		return mav;
		
	}
}
