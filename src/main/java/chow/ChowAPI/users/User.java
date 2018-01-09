package chow.ChowAPI.users;

public class User {
    private Integer id;
    private String username;
    private String email;
    private String googleId;
    private String photoUrl;

    protected User() { }

    public User(Integer id, String username, String email, String googleId, String photoUrl) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.googleId = googleId;
        this.photoUrl = photoUrl;
    }

    public Integer getId() {
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

    public void setId(Integer id) {
        this.id = id;
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
