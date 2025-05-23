package org.example.springsecuritylearning2.project.service;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;



import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    private String secretKey="ewfegregrfghdfbh";
    private final Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
    private static final long EXPIRATION_TIME = 1000 * 60 * 60;

    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ EXPIRATION_TIME) )
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

    }
public String extractUsername(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key).build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();




}
public boolean validateToken(String token){
        try{
            Jwts.parserBuilder()
                    .setSigningKey(key).build()
                    .parseClaimsJws(token)
                    .getBody().getSubject();
            return true;



        }
        catch (JwtException |  IllegalArgumentException e){
            return false;


    }

}


}
