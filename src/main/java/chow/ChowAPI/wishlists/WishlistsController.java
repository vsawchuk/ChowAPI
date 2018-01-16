package chow.ChowAPI.wishlists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class WishlistsController {
    @Autowired
    private WishlistModel model;

    @GetMapping(path = "/users/{userId}/wishlists")
    public ResponseEntity<Object> findUserWishlists(@PathVariable int userId) {
        List<Wishlist> wishlists = model.findByUserId(userId);
        return ResponseEntity.ok(wishlists);
    }

    @GetMapping(path = "/users/{userId}/wishlists/{id}")
    public ResponseEntity<Object> findWishlist(@PathVariable int userId, @PathVariable Long id) {
        Optional<Wishlist> wishlist = model.findById(id);
        if (wishlist.isPresent()) {
            System.out.println(wishlist.get());
            return ResponseEntity.ok(wishlist.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path = "users/{userId}/wishlists")
    public ResponseEntity<Object> createUser(@RequestBody Wishlist wishlist) {
        System.out.println("IN THE POST PATH");
        Wishlist savedWishlist = model.save(wishlist);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedWishlist.getId()).toUri();
        return ResponseEntity.created(location).body(savedWishlist);
    }
}
