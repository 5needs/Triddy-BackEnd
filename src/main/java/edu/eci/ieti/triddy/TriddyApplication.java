package edu.eci.ieti.triddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import edu.eci.ieti.triddy.config.JwtFilter;

@SpringBootApplication
public class TriddyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TriddyApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter( new JwtFilter() );
		registrationBean.addUrlPatterns( "/api/*" );
		return registrationBean;
	}

}
