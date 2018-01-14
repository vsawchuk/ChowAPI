package chow.ChowAPI.wishlists;


import chow.ChowAPI.restaurants.Restaurant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="wishlist")
@EntityListeners(AuditingEntityListener.class)
public class Wishlist implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="user_id")
    private int userId;

    @ManyToMany(
            fetch=FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name="wishlist_restaurant",
            joinColumns = { @JoinColumn(name="wishlist_id") },
            inverseJoinColumns = { @JoinColumn(name="restaurant_id") }
    )
    @JsonManagedReference
    private Set<Restaurant> restaurants = new HashSet<>();

    protected Wishlist() { }

    public Wishlist(Long id, String name, int userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getUserId() {
        return this.userId;
    }

    public Set<Restaurant> getRestaurants() {
        return this.restaurants;
    }

    protected void setName(String name) {
        this.name = name;
    }
}
