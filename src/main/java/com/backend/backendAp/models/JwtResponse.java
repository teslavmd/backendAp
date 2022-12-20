package com.backend.backendAp.models;

public class JwtResponse {

    private String JwtToken;

    public JwtResponse(String jwtToken) {
        this.JwtToken = jwtToken;
    }

    public JwtResponse(){

    }

    public String getJwtToken() {
        return JwtToken;
    }

    public void setJwtToken(String jwtToken) {
        JwtToken = jwtToken;
    }
}
