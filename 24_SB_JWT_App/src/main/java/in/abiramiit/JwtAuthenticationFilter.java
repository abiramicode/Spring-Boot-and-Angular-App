package in.abiramiit;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtHelper jwtHelper;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {


		String requestHeader = request.getHeader("Authorization");

		String username = null;
		String token = null;
		if (requestHeader != null && requestHeader.startsWith("Bearer")) {

			token = requestHeader.substring(7);
			username = this.jwtHelper.getUsernameFromToken(token);

			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

				// fetch user detail from username
				UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
				Boolean validateToken = this.jwtHelper.validateToken(token, userDetails);
				if (validateToken) {

					// set the authentication
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}

			}

			filterChain.doFilter(request, response);

		}
	}
}