package chow.ChowAPI.wishlists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class WishlistsController {
    @Autowired
    private WishlistModel model;

    @GetMapping(path = "/users/{userId}/wishlists")
    public ResponseEntity<Object> findUserWishlists(@PathVariable int userId) {
        List<Wishlist> wishlists = model.allWishlistsByUserId(userId);
        ResponseEntity response = ResponseEntity.ok(wishlists);
        return response;
    }

    @GetMapping(path = "/users/{userId}/wishlists/{id}")
    public ResponseEntity<Object> findWishlist(@PathVariable int userId, @PathVariable int id) {
        Wishlist wishlist = model.findWishlist(id, userId);
        ResponseEntity response = ResponseEntity.ok(wishlist);
        return response;
    }

    @PostMapping(path = "users/{userId}/wishlists")
    public ResponseEntity<Object> createUser(@RequestBody Wishlist wishlist) {
        Wishlist savedWishlist = model.save(wishlist);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedWishlist.getId()).toUri();
        ResponseEntity response = ResponseEntity.created(location).body(savedWishlist);
        return response;
    }
}
