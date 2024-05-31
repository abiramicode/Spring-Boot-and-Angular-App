package in.abiramiit.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.abiramiit.entities.UserMasterEntity;
import in.abiramiit.repos.UserMasterRepo;

@Service
public class UserService {

	
	@Autowired
	private UserMasterRepo userMasterRepo;
	public  void getUser() {
		Optional<UserMasterEntity> findById = userMasterRepo.findById(209);
		if(findById.isPresent()) {
			System.out.println(findById.get()); 
		}else {
			System.out.println("No record Present");
		}
	}

	public  void getUsers() {
		List<Integer> ids = Arrays.asList(101,102,201,202); 
		Iterable<UserMasterEntity> findAllById = userMasterRepo.findAllById(ids);
		
		findAllById.forEach(e -> {
			System.out.println(e);
		});
		
		
		List<Integer> ids = Arrays.asList(101,102,201,202,301,302); 
		//Iterable<UserMasterEntity> findAllById = userMasterRepo.findAllById(ids);
	
		Iterable<UserMasterEntity> entities = userMasterRepo.findAll(); 
		
		entities.forEach(e -> {
			System.out.println(e);
		});
	}



	public void saveUser() {

		UserMasterEntity entity = new UserMasterEntity(); 

		entity.setId(104);
		entity.setName("Rani");
		entity.setEmail("rani@gmail.com");
		entity.setGender("Fe-Male");	
		entity.setCity("INDIA");
		entity.setAge(16);

		userMasterRepo.save(entity); 

		System.out.println("Done........");

	
	public void saveUsers() {

		UserMasterEntity entity1 = new UserMasterEntity(); 
		entity1.setId(201);
		entity1.setName("Abirami");
		entity1.setEmail("abirami@gmail.com");
		entity1.setGender("Fe-Male");	
		entity1.setCity("INDIA");
		entity1.setAge(28);

		UserMasterEntity entity2 = new UserMasterEntity();
		entity2.setId(202);
		entity2.setName("Mahesh");
		entity2.setEmail("mahesh@gmail.com");
		entity2.setGender("Male");	
		entity2.setCity("INDIA");
		entity2.setAge(38);

		userMasterRepo.save(entity1); 
		 
		List<UserMasterEntity> entitiesList = Arrays.asList(entity1, entity2);

		userMasterRepo.saveAll(entitiesList);

		System.out.println("Done........");

	}

}
