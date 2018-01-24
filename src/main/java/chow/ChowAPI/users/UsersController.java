package chow.ChowAPI.users;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import chow.ChowAPI.wishlists.Wishlist;
import chow.ChowAPI.wishlists.WishlistModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UsersController {
    @Autowired
    private UserModel model;

    @Autowired
    private WishlistModel wishlistModel;

    @GetMapping(path = "/users")
    public List<User> all() {
        return model.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<User> findUser(@PathVariable(value = "id") Long id) {
        Optional<User> user = model.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    // TODO: require auth token from google
    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser;
        try {
            List<User> matchingUsers = model.findByEmailAndGoogleId(user.getEmail(), user.getGoogleId());
            if (matchingUsers.size() == 1) {
                User existingUser = matchingUsers.get(0);
                URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest().path("/{id}")
                        .buildAndExpand(existingUser.getId()).toUri();
                return ResponseEntity.created(location).body(existingUser);
            } else {
                savedUser = model.save(user);
                Wishlist defaultWishlist = new Wishlist(null, "My Wishlist", savedUser.getId());
                wishlistModel.save(defaultWishlist);
                URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest().path("/{id}")
                        .buildAndExpand(savedUser.getId()).toUri();
                return ResponseEntity.created(location).body(savedUser);
            }
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
