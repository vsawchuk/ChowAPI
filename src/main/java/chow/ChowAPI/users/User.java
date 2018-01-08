package chow.ChowAPI.users;

public class User {
    private Integer id;
    private String username;
    private String email;
    private String googleId;
    private String photoUrl;

    public User(Integer id, String username, String email, String googleId, String photoUrl) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.googleId = googleId;
        this.photoUrl = photoUrl;
    }
}
