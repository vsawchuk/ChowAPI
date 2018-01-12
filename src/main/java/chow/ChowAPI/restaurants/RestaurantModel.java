package chow.ChowAPI.restaurants;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantModel extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByYelpId(String yelpId);
}
