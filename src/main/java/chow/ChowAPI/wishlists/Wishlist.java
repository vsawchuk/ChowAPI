package chow.ChowAPI.wishlists;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

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

    protected void setName(String name) {
        this.name = name;
    }
}
