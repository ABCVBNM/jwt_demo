package com.example.demo_jwt.service;

import com.example.demo_jwt.model.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * TokenUtilService
 *
 * @author LINMINGLE
 * @version 1.0
 * 2021/4/21 10:32
 **/

@Service("tokenUtilService")
public class TokenUtilService {

    public static String userName;
    public static String admin;
    public static String warehouseName;

    // We need a signing key, so we'll create one just for this example.
    // Usually the key would be read from your application configuration instead.
    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String getToken(User user) {

        // String jws = Jwts.builder().setSubject(user.getUserName()).setExpiration(new Date(System.currentTimeMillis() + 3600 * 24 * 1000)).signWith(key).compact();
        user.setPassWord("");
//        user.setUserName("");
        Claims claims = Jwts.claims();
        claims.put("user", user);
        userName = user.getUserName();
        admin = user.getAdmin();
        warehouseName = user.getWarehouseName();
        String jws = Jwts.builder().setClaims(claims).setExpiration(new Date(System.currentTimeMillis() + 3600 * 24 * 1000)).signWith(key).compact();
        return jws;
    }

    public HashMap parseToken(String token) {
        try {
            LinkedHashMap userMap = (LinkedHashMap) Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().get("user");
            return userMap;
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
        } catch (MalformedJwtException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

//    拦截器用
    public boolean verifyToken(String token) {
        HashMap map = parseToken(token);
        if (map == null) return false;
        if (map.get("userName").equals(userName) || map.get("admin").equals(admin) || map.get("warehouseName").equals(warehouseName))
            return true;
        return false;
    }
}
