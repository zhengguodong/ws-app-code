package com.zgd.utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

public class jwtUtil {
    private static long time=1000*60*60*24;
    private static String signature="admin";
    public static String createJwt(){
        JwtBuilder jwtBuilder= Jwts.builder();
        String jwtToken=jwtBuilder
//                header
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
//                payload
                .claim("username","admin")
                .claim("role","admin")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis()+time))
                .setId(UUID.randomUUID().toString())
//                sigunature
                .signWith(SignatureAlgorithm.HS256,signature)
                .compact();
        return jwtToken;
    }
    public static boolean checkToken(String token){
        if(token == null){
            return false;
        }
        try{
            Jws<Claims> claimsJws=Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}

