package in.abiramiit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
@EnableWebSecurity 
public class AppSecurityConfig{

	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception { 


		http.authorizeRequests( (req) ->  
				//req.requestMatchers("/welcome")
				req.requestMatchers("/welcome","/login","/swagger-ui.html") 
			 	.permitAll()
			 	.anyRequest() 
			 	.authenticated())
			 	.formLogin();

		return http.build();  
	}
}
