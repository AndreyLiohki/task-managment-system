package org.example.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.example.utils.Role;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtService {

    private final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();

    public String generateJwtsToken(String username, Role role){
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        return Jwts
                .builder()
                .claims(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SECRET_KEY)
                .compact();

    }

    private Claims extractClaims(String token){
        return Jwts
                .parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractUsername(String token){
        return extractClaims(token).getSubject();
    }

    public String extractRole(String token){
        Claims claim = extractClaims(token);
        return claim.get("role", String.class);
    }

    public boolean isValidToken(String token, String username, String role){
        final String extractedUsername = extractUsername(token);
        final String extractedRole = extractRole(token);
        return(extractedUsername.equals(username) && isTokenExpires(token) && extractedRole.equals(role));
    }

    private boolean isTokenExpires(String token){
        return extractClaims(token).getExpiration().before(new Date());
    }
}
