package chow.ChowAPI;

import chow.ChowAPI.restaurants.Restaurant;
import chow.ChowAPI.restaurants.RestaurantModel;
import chow.ChowAPI.wishlists.Wishlist;
import chow.ChowAPI.wishlists.WishlistModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class ManyToManyTest implements CommandLineRunner {

    @Autowired
    private WishlistModel wishlistModel;

    @Autowired
    private RestaurantModel restaurantModel;

    public static void main(String[] args) {
        SpringApplication.run(ManyToManyTest.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Cleanup the tables
        restaurantModel.deleteAllInBatch();
        wishlistModel.deleteAllInBatch();

        // =======================================

        // Create two Restaurants
        ArrayList<String> displayAddress = new ArrayList<String>();
        displayAddress.add("Address pt 1");
        displayAddress.add("Address pt 2");
        Restaurant restaurant1 = new Restaurant("Chow's", "someImage", "someWebsite", 4, 100, "$$$", "chow-id", displayAddress);
        Restaurant restaurant2 = new Restaurant("Baloo's", "someImage", "someWebsite", 4, 100, "$$$", "baloo-id", displayAddress);

        // Create a Wishlist
        Long longId = new Long(1);
        Wishlist wishlist = new Wishlist(longId, "First test wishlist", 1);


        // Add tag references in the post
        wishlist.getRestaurants().add(restaurant1);
        wishlist.getRestaurants().add(restaurant2);

        // Add post reference in the tags
        restaurant1.getWishlists().add(wishlist);
        restaurant2.getWishlists().add(wishlist);

        wishlistModel.save(wishlist);

        // =======================================

    }
}
