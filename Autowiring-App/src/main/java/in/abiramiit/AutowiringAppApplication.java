package in.abiramiit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.abiramiit.beans.Car;

@SpringBootApplication
public class AutowiringAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(AutowiringAppApplication.class, args);

  
		Car car = context.getBean(Car.class);
		car.drive();     // it is calling eng.start method
	}
}
