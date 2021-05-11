package edu.eci.ieti.triddy.controller;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.triddy.exceptions.UserNotFoundException;
import edu.eci.ieti.triddy.model.User;
import edu.eci.ieti.triddy.services.LoginService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?>  login( @RequestBody User login )
    {   
        try{
            return new ResponseEntity<>( new Token( loginService.login(login)), HttpStatus.ACCEPTED);
        }catch(ServletException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    
    public class Token
    {

        String access_token;

        Token( String access_token )
        {
            this.access_token = access_token;
        }

        public String getAccessToken()
        {
            return access_token;
        }

        public void setAccessToken( String access_token )
        {
            this.access_token = access_token;
        }
    }

}
