package in.abiramiit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.abiramiit.entities.UserMasterEntity;
import in.abiramiit.repos.UserMasterRepo;
import in.abiramiit.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(Application.class, args);
		
		/*
		//getting repo bean obj
		UserMasterRepo userMasterRepo = context.getBean(UserMasterRepo.class);
		*/
		
		UserService userService = context.getBean(UserService.class);
		userService.saveUser();
		
		
		/*
		//userMasterRep - is a interface not a class can we create the object
		// for the interface in java -> (no) we cannot create the interfaces objects
		*/
		
		/*
		//Now see what object we are getting:
		System.out.println(userMaterRepo.getClass().getName());
		*/
	}

}
