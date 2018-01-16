package chow.ChowAPI.wishlistRestaurants;

import chow.ChowAPI.restaurants.Restaurant;
import chow.ChowAPI.restaurants.RestaurantModel;
import chow.ChowAPI.wishlists.Wishlist;
import chow.ChowAPI.wishlists.WishlistModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class WishlistRestaurantsController {

    @Autowired
    private WishlistModel wishlistModel;

    @Autowired
    private RestaurantModel restaurantModel;

    @PostMapping(path = "users/{userId}/wishlists/{wishlistId}/add")
    public ResponseEntity<Object> addRestaurantToWishlist(@RequestBody Restaurant restaurant, @PathVariable Long wishlistId) {
        if (!wishlistModel.existsById(wishlistId)) {
            return ResponseEntity.notFound().build();
        }
        Wishlist wishlist = wishlistModel.getOne(wishlistId);
        List<Restaurant> dbRestaurants = restaurantModel.findByYelpId(restaurant.getYelpId());
        if (dbRestaurants.size() > 0) {
            restaurant = dbRestaurants.get(0);
        } else {
            Restaurant savedRestaurant = restaurantModel.save(restaurant);
            restaurant = savedRestaurant;
        };

        wishlist.getRestaurants().add(restaurant);
        restaurant.getWishlists().add(wishlist);

        wishlistModel.save(wishlist);

        return ResponseEntity.ok(wishlist);
    }

}
