package chow.ChowAPI.wishlistRestaurants;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRestaurantModel extends JpaRepository<WishlistRestaurant, Long> {
}
