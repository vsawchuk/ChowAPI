package chow.ChowAPI.wishlists;

public class Wishlist {
    private int id;
    private String name;
    private int userId;

    public Wishlist(int id, String name, int userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
