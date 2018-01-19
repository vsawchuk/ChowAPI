package chow.ChowAPI.wishlists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import javax.xml.ws.Response;
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
            return ResponseEntity.ok(wishlist.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/users/{userId}/wishlists/{id}")
    public ResponseEntity<Object> updateWishlist(@PathVariable int userId, @PathVariable Long id, @RequestParam String name) {
        Optional<Wishlist> wishlist = model.findById(id);
        if (wishlist.isPresent()) {
            Wishlist updatedWishlist = wishlist.get();
            if (updatedWishlist.getName().equals(name)) {
                return ResponseEntity.badRequest().build();
            }
            updatedWishlist.setName(name);
            model.save(updatedWishlist);
            return ResponseEntity.ok(wishlist.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path = "users/{userId}/wishlists")
    public ResponseEntity<Object> createUser(@RequestBody Wishlist wishlist) {
        Wishlist savedWishlist = model.save(wishlist);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedWishlist.getId()).toUri();
        return ResponseEntity.created(location).body(savedWishlist);
    }

    @DeleteMapping("/users/{userId}/wishlists/{id}")
    public ResponseEntity<Object> deleteWishlist(@PathVariable int userId, @PathVariable Long id) {
        if (model.existsById(id)) {
            model.deleteById(id);
            if (model.existsById(id)) {
                return ResponseEntity.status(500).build();
            }
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
