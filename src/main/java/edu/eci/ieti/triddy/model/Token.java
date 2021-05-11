package edu.eci.ieti.triddy.model;

public class Token
    {

        String accessToken;


        public Token() {
        }

        public Token( String access_token )
        {
            this.accessToken = access_token;
        }

        public String getAccessToken()
        {
            return accessToken;
        }

        public void setAccessToken( String access_token )
        {
            this.accessToken = access_token;
        }
    }
