package in.abiramiit.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//To represent this java class as Entity class
@Entity 

//I want to map this java class with table name. the name of the table (user_master)
@Table(name="user_master")	// class name will be mapped with table name for (that we are using user_master)
public class UserMasterEntity {

	//In that we need to write the variables -columns available in the table.
	
	@Id     // This is mapped with pK column->This variable(Integer id) is mapped with PK column (or) we need to
			//represent this (user_id column)is mapped with primary key
	
	@Column(name="user_id") // i need to map this variables with columns available in the DB table (or) it is
	private Integer id;		// used to map our variable with DB column
	
	@Column(name="user_name")
	private String name;
	
	@Column(name="user_email")
	private String email;
	
	@Column(name="user_gender")
	private String gender;

	@Column(name="user_city")
	private String city;
	
	@Column(name="user_age")
	private Integer age;
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserMasterEntity [id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender + ", city="
				+ city + ", age=" + age + "]";
	}
	
	
	
}
