package chow.ChowAPI.wishlists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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
}
