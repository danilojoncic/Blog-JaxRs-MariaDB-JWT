package com.example.hw.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.hw.domain.User;
import com.example.hw.repository.user.UserRepository;

import javax.inject.Inject;
import java.util.Date;

public class UserService {
    @Inject
    UserRepository userRepository;


    //ovo pravi token
    public String login(String username, String password){
        User user = this.userRepository.findUser(username);
        if(user == null || !user.getPassword().equals(password))return null;

        Date issuedAt = new Date();
        //od vremena izdavanja dodaj jedan dan ekvivalentan milisekundama
        Date expiresAt = new Date(issuedAt.getTime() + 24 * 60 * 60 * 1000);
        Algorithm algorithm = Algorithm.HMAC256("ultra tajna sifra");
        return JWT.create().withIssuedAt(issuedAt).withExpiresAt(expiresAt).withSubject(username).sign(algorithm);
    }


    //ovo cita token i provjerava da li je validan
    public boolean isAuthorized(String token){
        Algorithm algorithm = Algorithm.HMAC256("ultra tajna sifra");
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);

        String username = jwt.getSubject();
        User user = this.userRepository.findUser(username);
        return user != null;
    }
}
