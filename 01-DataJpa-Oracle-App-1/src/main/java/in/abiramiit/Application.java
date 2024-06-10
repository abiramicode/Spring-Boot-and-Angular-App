package in.abiramiit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.abiramiit.entities.UserMasterEntity;
import in.abiramiit.repos.UserMasterRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(Application.class, args);
		
		
		UserMasterRepo userMaterRepo = context.getBean(UserMasterRepo.class);
		
		UserMasterEntity entity = new UserMasterEntity(); 
		
		entity.setId(104);
		entity.setName("Rani");
		entity.setEmail("Rani@gmail.com");
		entity.setGender("Female");	
		entity.setCity("INDIA");
		entity.setAge(26);
		
		//insert record
		userMaterRepo.save(entity); 
		
		System.out.println("Done........");
		
		
	}

}

