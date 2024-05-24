package in.abiramiit.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration       
@EnableWebSecurity   
public class AppSecurityConfig {

	
	@Autowired 
	private DataSource datasource;

	@Autowired  
	public void authManager(AuthenticationManagerBuilder auth) throws Exception {  //who is responsible to verify user data(authManger) 
																	//take para as authenticationmanagerbuilder-perform authentication
		auth.jdbcAuthentication()		// we want perform jdbc authentication
		.dataSource(datasource)         //for jdbc authentication require data source
		.passwordEncoder(new BCryptPasswordEncoder())    // my db pw stored in encrypted format

		// now we need to specify 2 methods here -to load the user record based on username
		.usersByUsernameQuery("select username,password,enabled from users where username=?")		 // get user data/information from db
		.authoritiesByUsernameQuery("select username,authority from authorities where username=?");  // get user roles from db
	}	
	
	// ii) we need to configure security configuration - which method & what type of security is required
	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception { // pass httpsecurity(object) as a parameter

		http.authorizeHttpRequests( (req) ->  //i am taking my request
		 /*req.requestMatchers("/admin").hasRole("ROLE_ADMIN") //admin method can be accessed by adminuser only(rest controller methods)
	     	.requestMatchers("/user").hasAnyRole("ROLE_ADMIN","ROLE_USER") // user method can be accessed by adminuser & normaluser also*/
	    	
		req.requestMatchers("/admin").hasRole("ADMIN") 
     	.requestMatchers("/user").hasAnyRole("ADMIN","USER")
		.requestMatchers("/").permitAll()
		    .anyRequest() // if any other request come for the app then you authenticate with formLogin
		    .authenticated())
		    .formLogin();

		return http.build();   // method - i want to call create the obj for that using @Bean object

	}
}