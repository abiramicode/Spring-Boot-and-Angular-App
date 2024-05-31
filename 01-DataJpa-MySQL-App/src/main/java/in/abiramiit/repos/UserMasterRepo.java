package in.abiramiit.repos;

import org.springframework.data.repository.CrudRepository;

import in.abiramiit.entities.UserMasterEntity;


//@Repository
public interface UserMasterRepo extends CrudRepository<UserMasterEntity, Integer> {

}
