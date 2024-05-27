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
		
		//getting repo bean obj
		UserMasterRepo userMaterRepo = context.getBean(UserMasterRepo.class);
		
		// let us set the data to the entity object - 1 entity object represents 1 record in the table
		UserMasterEntity entity = new UserMasterEntity(); // 1. creating object for entity
		
		//2. entity class object setting the data by calling setter methods
		entity.setId(104);
		entity.setName("Rani");
		entity.setEmail("Rani@gmail.com");
		entity.setGender("Female");	
		entity.setCity("INDIA");
		entity.setAge(26);
		
		//insert record
		userMaterRepo.save(entity); //passing entity object as a parameter
		
		System.out.println("Done........");
		
		
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

