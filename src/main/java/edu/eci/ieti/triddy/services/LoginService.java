package edu.eci.ieti.triddy.services;

import java.util.Date;

import javax.servlet.ServletException;

import org.apache.shiro.crypto.hash.Sha512Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.ieti.triddy.exceptions.UserNotFoundException;
import edu.eci.ieti.triddy.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class LoginService {
    
    @Autowired
    private UserService userService;

    public String login(User login) throws ServletException, UserNotFoundException{
        String jwtToken = "";

        if ( login.getEmail() == null || login.getPassword() == null )
        {
            throw new ServletException( "Please fill in username and password" );
        }

        String username = login.getEmail();
        String password = new Sha512Hash(login.getPassword()).toHex();

        User user = userService.getUser( username );
        String pwd = user.getPassword();

        if ( !password.equals( pwd ) )
        {
            throw new ServletException( "Invalid login. Please check your name and password." );
        }

        jwtToken = Jwts.builder().setSubject( username ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(
                SignatureAlgorithm.HS256, "secretkey" ).compact();

        return jwtToken;
    }
    
}
