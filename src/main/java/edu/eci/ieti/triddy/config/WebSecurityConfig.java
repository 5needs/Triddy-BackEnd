
package edu.eci.ieti.triddy.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebSecurityConfig {

    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilter()
    {
        FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter( new JwtFilter() );
        registrationBean.addUrlPatterns( "/api/*" );

        return registrationBean;
    }
}
