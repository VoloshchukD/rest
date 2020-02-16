package by.tms.rest6;

import org.apache.tomcat.util.json.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private List<User> users = new ArrayList<>();
    @Autowired
    private List<Integer> tokens;


    @PostMapping(path = "/reg")
    public ResponseEntity<User> reg(@RequestBody User user){
        if(users.contains(user)){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        users.add(user);
        return new ResponseEntity(user,HttpStatus.CREATED);
    }

    @PostMapping(path = "/auth")
    public ResponseEntity<Integer> auth(@RequestBody User user){
        if(users.contains(user)){
            int i = new Random().nextInt();
            tokens.add(i);
            return new ResponseEntity(
                    i,HttpStatus.CREATED);

        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    public static List<Token> getTokens() {
        return getTokens();
    }

}

