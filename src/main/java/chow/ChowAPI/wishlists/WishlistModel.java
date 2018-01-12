package chow.ChowAPI.wishlists;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistModel extends JpaRepository<Wishlist, Long> {
    List<Wishlist> findByUserId(int userId);
}
