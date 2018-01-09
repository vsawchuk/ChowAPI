package chow.ChowAPI.users;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.ws.Response;

@RestController
public class UsersController {
    @Autowired
    private UserModel model;

//    @GetMapping(path = "/users")
//    public List<User> all() {
//        return model.allUsers();
//    }

    // TODO: require auth token from google
    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        System.out.println(user.getEmail());
        User savedUser = model.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        ResponseEntity response = ResponseEntity.created(location).body(savedUser);
        return response;
    }
}
