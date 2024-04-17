package in.abiramiit.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

	@Autowired
	private Engine eng;			
	
	/*  
	    // setter injection
	//@Autowired
	public void setEng(Engine eng) {
		System.out.println("setEng() method called...");
		this.eng=eng;
	}
	*/
	
	@Autowired    
	public Car(Engine eng) 
	{
		this.eng=eng;  
		System.out.println("Car :: Param - Constructor");
	}	
	
	public void drive() {
		//Engine eng = new Engine();   
		int status = eng.start();   
		if(status >= 1) {
			System.out.println("Journey Started...!!");
		}
	}
}
