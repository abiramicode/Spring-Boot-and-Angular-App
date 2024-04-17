package in.abiramiit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.abiramiit.utils.PwdUtils;

@Configuration
public class AppConfig {

	public AppConfig() {
		System.out.println("AppConfig :: Constructor");
	}


	@Bean
	public PwdUtils createPwdUtil() {
		System.out.println("createPwdUtil() method called...");
		PwdUtils pw = new PwdUtils();		// here i/programmer want to create the bean object (or) object / ioc want to create the bean
											// because i want to inject/search some values into that (or) i want customization only
		//logic;

		return pw;
	}
}

