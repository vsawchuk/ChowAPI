package chow.ChowAPI.wishlistRestaurants;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="wishlist_restaurant")
@EntityListeners(AuditingEntityListener.class)
public class WishlistRestaurant implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="wishlist_id")
    private Long wishlistId;

    @Column(name="restaurant_id")
    private Long restaurantId;

    protected WishlistRestaurant() { }

    public WishlistRestaurant(Long wishlistId, Long restaurantId) {
        this.wishlistId = wishlistId;
        this.restaurantId = restaurantId;
    }

    public Long getId() {
        return this.id;
    }

    public Long getWishlistId() {
        return this.wishlistId;
    }

    public void setWishlistId(Long wishlistId) {
        this.wishlistId = wishlistId;
    }

    public Long getRestaurantId() {
        return this.restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}
