package chow.ChowAPI.users;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String username;

    @Column(name="email")
    private String email;

    @Column(name="google_id")
    private String googleId;

    @Column(name="photo_url")
    private String photoUrl;

    protected User() { }

    public User(Long id, String username, String email, String googleId, String photoUrl) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.googleId = googleId;
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", googleId='" + googleId + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getGoogleId() {
        return this.googleId;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
