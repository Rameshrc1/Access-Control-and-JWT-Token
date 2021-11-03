package lk.earth.accesscontrol.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lk.earth.accesscontrol.dao.TokenDao;
import lk.earth.accesscontrol.dao.UserDao;
import lk.earth.accesscontrol.entity.Token;
import lk.earth.accesscontrol.entity.Tokenstatus;
import lk.earth.accesscontrol.entity.User;
import lk.earth.accesscontrol.util.dto.AccessToken;
import lk.earth.accesscontrol.util.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestController
@RequestMapping("/tokens")
public class TokenController {

    @Autowired private UserDao userDao;
    @Autowired private TokenDao tokenDao;

    @PostMapping
    public Object generate(@RequestBody LoginRequest loginRequest){

        User user = userDao.findByUsername(loginRequest.getUsername());
        if (user == null){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Incorrect username");
        }


        String plainTextPassword = loginRequest.getPassword();
        String hashedPassword = user.getPassword();

        boolean isMatched = BCrypt.checkpw(plainTextPassword, hashedPassword);

        if (isMatched){

            Token token = new Token();
            token.setDoissued(LocalDateTime.now());
            token.setDoexpired(LocalDateTime.now().plusHours(3));
            token.setTokenstatus(new Tokenstatus(1));
            token.setUser(user);

            tokenDao.save(token);

            Claims claims = Jwts.claims().setSubject(user.getUsername());
            claims.put("user_id", user.getId());
            String tokenText = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, "123456").compact();

            AccessToken accessToken = new AccessToken();
            accessToken.setToken(tokenText);
            accessToken.setTokenpirs(token.getDoexpired());
            accessToken.setUser(user);

            return accessToken;


            //HashMap<String, Object> hashMap = new HashMap<>();
            //hashMap.put("token", tokenText);
            //hashMap.put("toexpire", token.getDoexpired());
            //hashMap.put("user", user);

            //return hashMap;

        }else {
            System.out.println("Incorrect Password+");
        }

         // String samplePassword = "12345";
        // String hashText = BCrypt.hashpw(samplePassword, BCrypt.gensalt());
       // System.out.println(hashText);

        return null;

    }

}
