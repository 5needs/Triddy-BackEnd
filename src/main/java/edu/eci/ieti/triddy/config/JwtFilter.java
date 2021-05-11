package edu.eci.ieti.triddy.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean{

    public void doFilter( final ServletRequest servletRequest, final ServletResponse servletResponse,final FilterChain filterChain ) throws IOException{

        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final String authHeader = request.getHeader( "authorization" );
        try{
            if ( "OPTIONS".equals( request.getMethod() ) ){
                response.setStatus( HttpServletResponse.SC_OK );
                filterChain.doFilter( servletRequest, response );
            }
            else{

                if ( authHeader == null || !authHeader.startsWith( "Bearer " ) ){
                    throw new ServletException( "Missing or invalid Authorization header" );
                }

                final String token = authHeader.substring( 7 );

                try{
                    final Claims claims = Jwts.parser().setSigningKey( "secretkey" ).parseClaimsJws( token ).getBody();
                    request.setAttribute( "claims", claims );
                }
                catch ( final SignatureException e ){
                    throw new ServletException( "Invalid token" );
                }

                filterChain.doFilter( servletRequest, response );
            }
        }catch (ServletException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(e.getMessage());
            response.getWriter().flush();
        }
    }
}