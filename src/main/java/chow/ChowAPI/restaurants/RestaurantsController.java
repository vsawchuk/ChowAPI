package chow.ChowAPI.restaurants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantsController {
    @Autowired
    private RestaurantModel model;

    public void addRestaurant(Restaurant restaurant) {
        model.save(restaurant);
    }

    public List<Restaurant> findByYelpId(String yelpId) {
        return model.findByYelpId(yelpId);
    }
}
