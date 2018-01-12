package chow.ChowAPI.restaurants;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

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

    protected Restaurant() { }

    public Restaurant(String name, String imageUrl, String url, int rating, int reviewCount, String price, String yelpId, ArrayList<String> displayAddress) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.url = url;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.price = price;
        this.yelpId = yelpId;
        this.displayAddress = displayAddress;
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
}
