package chow.ChowAPI.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    @GetMapping(path = "/users")
    public String allUsers() {
        return "all users";
    }
}
