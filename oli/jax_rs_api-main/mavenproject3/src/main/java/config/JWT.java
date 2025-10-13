/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import com.mycompany.mavenproject3.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 *
 * @author szabi
 */
public class JWT {
    private static final String JWT_SECRET = "v9X!pR3kq#2tLz7Wf@1gN$8hS5uC^dM0yE&bTjZrA4oVxK%";
    
    public static String createJwtToken(User u){
        
        Instant now = Instant.now();
        
        String token = Jwts.builder()
                .setIssuer("IAKK")
                .setSubject("backend_alapok")
                .claim("id", u.getId())
                .claim("last_login", u.getLastLogin().toString())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(1, ChronoUnit.DAYS)))
                .signWith(
                        SignatureAlgorithm.HS256, 
                     TextCodec.BASE64.decode(JWT_SECRET))
                .compact();
        return token;
                
    }
}
