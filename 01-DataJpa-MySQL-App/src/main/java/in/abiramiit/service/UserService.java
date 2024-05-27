package in.abiramiit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.abiramiit.entities.UserMasterEntity;
import in.abiramiit.repos.UserMasterRepo;

@Service
public class UserService {
	
	// to perform Dependency Injection
	@Autowired
	private UserMasterRepo userMasterRepo;
	
	public void saveUser() {
		
		// let us set the data to the entity object - 1 entity object represents 1 record in the table
		UserMasterEntity entity = new UserMasterEntity(); // 1. creating object for entity
		
		//2. entity class object setting the data by calling setter methods
		entity.setId(104);
		entity.setName("Rani");
		entity.setEmail("rani@gmail.com");
		entity.setGender("Fe-Male");	
		entity.setCity("INDIA");
		entity.setAge(26);
		
		//insert record
		userMasterRepo.save(entity); //passing entity object as a parameter
		
		System.out.println("Done........");
		
	}

}
