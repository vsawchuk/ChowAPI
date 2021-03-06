package chow.ChowAPI.restaurants;

import chow.ChowAPI.wishlists.Wishlist;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="restaurant")
@EntityListeners(AuditingEntityListener.class)
public class Restaurant implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="url")
    private String url;

    @Column(name="rating")
    private int rating;

    @Column(name="review_count")
    private int reviewCount;

    @Column(name="price")
    private String price;

    @Column(name="yelp_id")
    private String yelpId;

    @Column(name="display_address")
    private ArrayList<String> displayAddress;

    @Column(name="latitude")
    private double latitude;

    @Column(name="longitude")
    private double longitude;

    @ManyToMany(
            fetch=FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "restaurants"
    )
    @JsonBackReference
    private Set<Wishlist> wishlists = new HashSet<>();

    protected Restaurant() { }

    public Restaurant(String name, String imageUrl, String url, int rating, int reviewCount, String price, String yelpId, ArrayList<String> displayAddress, double latitude, double longitude) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.url = url;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.price = price;
        this.yelpId = yelpId;
        this.displayAddress = displayAddress;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", url='" + url + '\'' +
                ", rating=" + rating +
                ", reviewCount=" + reviewCount +
                ", price='" + price + '\'' +
                ", yelpId='" + yelpId + '\'' +
                ", displayAddress=" + displayAddress +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", wishlists=" + wishlists +
                '}';
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getUrl() {
        return this.url;
    }

    public int getRating() {
        return this.rating;
    }

    public int getReviewCount() {
        return this.reviewCount;
    }

    public String getPrice() {
        return this.price;
    }

    public String getYelpId() {
        return this.yelpId;
    }

    public ArrayList<String> getDisplayAddress() {
        return this.displayAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDisplayAddress(ArrayList<String> displayAddress) {
        this.displayAddress = displayAddress;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Set<Wishlist> getWishlists() {
        return this.wishlists;
    }
}
