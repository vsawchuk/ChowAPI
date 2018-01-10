package chow.ChowAPI.wishlists;

public class Wishlist {
    private int id;
    private String name;
    private int userId;

    protected Wishlist() { }

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

    protected void setName(String name) {
        this.name = name;
    }

    protected void setId(int id) {
        this.id = id;
    }
}
