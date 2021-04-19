package edu.eci.ieti.triddy.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.eci.ieti.triddy.model.User;
import edu.eci.ieti.triddy.repository.UserRepository;
import edu.eci.ieti.triddy.services.UserService;

import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class JwtFilterTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;
    
    @AfterEach
    void deleteUsers(){
        userRepository.deleteAll();
    }

	@Test
	public void loginTest() throws Exception {

        User u = new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, null);
        userService.createUser(u);

		String url = "http://localhost:" +port;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");   
        
        User loginUser = new User("test@mail.com","abc123", null, null, null, null, null);

        HttpEntity<User> request = new HttpEntity<>(loginUser, headers);
         
        ResponseEntity<String> response = this.restTemplate.postForEntity(url+"/login", request, String.class);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());;

        String token = response.getBody();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+token);

        HttpEntity<String> request2  = new HttpEntity<>(headers);
        ResponseEntity<String> response2 = this.restTemplate.exchange(url+"/api/users", HttpMethod.GET, request2, String.class);
        
        assertEquals(HttpStatus.OK, response2.getStatusCode());;
        
	}

    @Test
	public void loginFailTest() throws Exception {

		String url = "http://localhost:" +port;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");   
        

        String token = "eyJhbGciOiJIUzI1NiJ9.1lJzdWIiOiJ1c2VyMSIssnJvbGVzIjoidXNlciIsImlhdCI6MTYxNzg0NTQwOX0.RB9-IFr0B2XXygIk7YzWrwjDCblYP9MH3uyWaFoy1wE";

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+token);

        HttpEntity<String> request2  = new HttpEntity<>(headers);
        ResponseEntity<String> response2 = this.restTemplate.exchange(url+"/api/users", HttpMethod.GET, request2, String.class);
        
        assertEquals(HttpStatus.UNAUTHORIZED, response2.getStatusCode());;
        
	}

    @Test
	public void loginFailHeaderTest() throws Exception {

		String url = "http://localhost:" +port;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");   
        

        String token = "eyJhbGciOiJIUzI1NiJ9.1lJzdWIiOiJ1c2VyMSIssnJvbGVzIjoidXNlciIsImlhdCI6MTYxNzg0NTQwOX0.RB9-IFr0B2XXygIk7YzWrwjDCblYP9MH3uyWaFoy1wE";

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", token);

        HttpEntity<String> request2  = new HttpEntity<>(headers);
        ResponseEntity<String> response2 = this.restTemplate.exchange(url+"/api/users", HttpMethod.GET, request2, String.class);
        
        assertEquals(HttpStatus.UNAUTHORIZED, response2.getStatusCode());;
        
	}
    @Test
    public void loginFailHeaderTest2() throws Exception {

		String url = "http://localhost:" +port;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<String> request2  = new HttpEntity<>(headers);
        ResponseEntity<String> response2 = this.restTemplate.exchange(url+"/api/users", HttpMethod.GET, request2, String.class);
        
        assertEquals(HttpStatus.UNAUTHORIZED, response2.getStatusCode());;
        
	}

    @Test
    public void loginOptionsTest() throws Exception {

		String url = "http://localhost:" +port;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<String> request2  = new HttpEntity<>(headers);
        ResponseEntity<String> response2 = this.restTemplate.exchange(url+"/api/users", HttpMethod.OPTIONS, request2, String.class);
        
        assertEquals(HttpStatus.OK, response2.getStatusCode());;
        
	}
}
