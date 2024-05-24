package in.abiramiit;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		// we have servlet req and res obj
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // why this req is denied / not access
		PrintWriter writer = response.getWriter();
		writer.write("Access Denied/Invalid ::" + authException.getMessage()); // why denied - authex
		
		/*
		 * this is JWT authentication entry point
		 * what is the purpose of JwtAuthenticationEntryPoint - This method is executed when
		 * user is unauthorized to access is Denied/Invalid
		 */
	}

}
