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
		
		
		UserService userService = context.getBean(UserService.class);
		//userService.saveUser();
		//userService.saveUsers();
		//userService.getUser();
		userService.getUsers();
		
		//System.out.println(userMaterRepo.getClass().getName());
		
	}

}
