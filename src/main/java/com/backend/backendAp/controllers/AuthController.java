package com.backend.backendAp.controllers;


import com.backend.backendAp.config.TokenUtils;
import com.backend.backendAp.config.UserDetailsServiceImpl;
import com.backend.backendAp.models.JwtRequest;
import com.backend.backendAp.models.JwtResponse;
import com.backend.backendAp.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfolio-219c8.web.app")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private TokenUtils tokenUtils;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));


        UserModel userModel = (UserModel) this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());



        String token = String.valueOf(TokenUtils.createToken(userModel));
        return ResponseEntity.ok(new JwtResponse(token));
    }



    private void autenticar(String username, String password) throws Exception{

        System.out.println(username + ", " + password);
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (DisabledException disabledException){
            throw new Exception("USUARIO DESHABILITADO " + disabledException);
        }catch (BadCredentialsException badCredentialsException){
            throw new Exception("Credenciales invalidas " + badCredentialsException);
        }
    }


}
