package edu.eci.ieti.triddy.config;

import static org.junit.jupiter.api.Assertions.fail;
import java.io.IOException;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.ServletException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

@SpringBootTest
class JwtFilterTest {

    JwtFilter jwtFilter = new JwtFilter();

    @Test
    void requesWithoutToken() throws IOException, ServletException{
        try {
            MockHttpServletRequest request = new MockHttpServletRequest();
            request.addHeader("authorization", "");
            MockHttpServletResponse resp = new MockHttpServletResponse();
            MockFilterChain filterChain = new MockFilterChain();
            jwtFilter.doFilter(request, resp, filterChain);
            fail();
        } catch (Exception e){}
    }

    @Test
    void requestWithToken() throws IOException, ServletException{
        try {
            String jwtToken = Jwts.builder().setSubject( "prueba" ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(
            SignatureAlgorithm.HS256, "secretkey" ).compact();
            MockHttpServletRequest request = new MockHttpServletRequest();
            request.addHeader("authorization", "Bearer " + jwtToken);
            MockHttpServletResponse resp = new MockHttpServletResponse();
            MockFilterChain filterChain = new MockFilterChain();
            jwtFilter.doFilter(request, resp, filterChain);
        } catch (Exception e){
            fail();
        }
    }

    @Test
    void requestWithTokenInvalid() throws IOException, ServletException{
        try {
            MockHttpServletRequest request = new MockHttpServletRequest();
            request.addHeader("authorization", "Bearer " + "token invalido");
            MockHttpServletResponse resp = new MockHttpServletResponse();
            MockFilterChain filterChain = new MockFilterChain();
            jwtFilter.doFilter(request, resp, filterChain);
            fail();
        } catch (Exception e){ }
    }

    @Test
    void requestOption(){
        try {
            MockHttpServletRequest request = new MockHttpServletRequest();
            request.setMethod("OPTIONS");
            MockHttpServletResponse resp = new MockHttpServletResponse();
            MockFilterChain filterChain = new MockFilterChain();
            jwtFilter.doFilter(request, resp, filterChain);
        } catch (Exception e){
            fail();
        }

    }


    
}
