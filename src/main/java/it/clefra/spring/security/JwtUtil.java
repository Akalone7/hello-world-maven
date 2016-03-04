package it.clefra.spring.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import it.clefra.spring.security.model.JwtUser;

@Service
public class JwtUtil {

//    @Value("${jwt.secret}")
    private String secret;

    /**
     * Tries to parse specified String as a JWT token. If successful, returns User object with username, id and role prefilled (extracted from token).
     * If unsuccessful (token is invalid or not containing all required user properties), simply returns null.
     * 
     * @param token the JWT token to parse
     * @return the User object extracted from specified token or null if a token is invalid.
     */
    public JwtUser parseToken(String token) {
        try {
        	
        	
//        	String createdJWT = JwtTokenGenerator.createJWT("1", "test", "", "{\"user\": \"clefra\", \"password\" : \"admin\", \"userId\" : \"1\", \"role\": \"USER\"}", 1000000);
        	
        	
            Claims body = Jwts.parser()
                    .setSigningKey("secret")
                    .parseClaimsJws(token)
                    .getBody();
            
    		List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(body.get("role").toString());

            JwtUser u = new JwtUser((String) body.get("user"), (String) body.get("password"), authorityList);
//            u.setId(Long.parseLong((String) body.get("userId")));
            u.setId(1L);
            u.setRole((String) body.get("role"));

            return u;

        } catch (JwtException | ClassCastException e) {
            return null;
        }
    }

    /**
     * Generates a JWT token containing username as subject, and userId and role as additional claims. These properties are taken from the specified
     * User object. Tokens validity is infinite.
     * 
     * @param u the user for which the token will be generated
     * @return the JWT token
     */
    public String generateToken(JwtUser u) {
        Claims claims = Jwts.claims().setSubject(u.getUsername());
        claims.put("userId", u.getId() + "");
        claims.put("role", u.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}