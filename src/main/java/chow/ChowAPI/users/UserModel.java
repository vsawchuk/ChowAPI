package chow.ChowAPI.users;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;

@Repository
public interface UserModel extends JpaRepository<User, Long> {
}
