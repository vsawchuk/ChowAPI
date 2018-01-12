package chow.ChowAPI.wishlists;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public interface WishlistModel extends JpaRepository<Wishlist, Long> {
    List<Wishlist> findByUserId(int userId);
//    private static List<Wishlist> wishlists = new ArrayList<>();
//    private static int wishlistCount = 2;
//
//    static {
//        wishlists.add(new Wishlist(1, "Chowder's Seattle Favorites", 1));
//        wishlists.add(new Wishlist(2, "Chowder's Seafood Wishlist", 1));
//    }
//
//    public List<Wishlist> allWishlistsByUserId(int userId) {
//        List<Wishlist> userWishlists = new ArrayList<>();
//        Iterator<Wishlist> iterator = wishlists.iterator();
//        while(iterator.hasNext()) {
//            Wishlist wishlist = iterator.next();
//            if (wishlist.getUserId() == userId) {
//                userWishlists.add(wishlist);
//            }
//        }
//        return userWishlists;
//    }
//
//    public Wishlist findWishlist(int id, int userId) {
//        Iterator<Wishlist> iterator = wishlists.iterator();
//        while(iterator.hasNext()) {
//            Wishlist wishlist = iterator.next();
//            if ((wishlist.getUserId() == userId) && (wishlist.getId() == id)) {
//                return wishlist;
//            }
//        }
//        return null;
//    }
//
//    public Wishlist save(Wishlist wishlist) {
//        wishlistCount++;
//        wishlist.setId(wishlistCount);
//        wishlists.add(wishlist);
//        return wishlist;
//    }
}
