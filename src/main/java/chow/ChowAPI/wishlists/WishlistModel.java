package chow.ChowAPI.wishlists;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class WishlistModel {
    private static List<Wishlist> wishlists = new ArrayList<>();
    private static int wishlistCount = 2;

    static {
        wishlists.add(new Wishlist(1, "Chowder's Seattle Favorites", 1));
        wishlists.add(new Wishlist(2, "Chowder's Seafood Wishlist", 1));
    }

    public List<Wishlist> allWishlistsByUserId(int userId) {
        List<Wishlist> userWishlists = new ArrayList<>();
        Iterator<Wishlist> iterator = wishlists.iterator();
        while(iterator.hasNext()) {
            Wishlist wishlist = iterator.next();
            if (wishlist.getUserId() == userId) {
                userWishlists.add(wishlist);
            }
        }
        return userWishlists;
    }

//    public User findUser(int id) {
//        Iterator<User> iterator = users.iterator();
//        while (iterator.hasNext()) {
//            User user = iterator.next();
//            if (user.getId() == id) {
//                iterator.remove();
//                return user;
//            }
//        }
//        return null;
//    }
//
//    public User save(User user) {
//        usersCount++;
//        user.setId(usersCount);
//        users.add(user);
//        return user;
//    }
}
