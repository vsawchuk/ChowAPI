package chow.ChowAPI.users;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class UserModel {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 2;

    static {
        users.add(new User(1, "Chowder", "chowder@email.com",  "123456", "https://vignette.wikia.nocookie.net/goanimate-v2/images/8/83/Axsaracutc_net.jpg/revision/latest?cb=20150110014326"));
        users.add(new User(2, "Baloo", "baloo@email.com",  "78910", "https://vignette.wikia.nocookie.net/disney/images/e/e1/Jungle-book-disneyscreencaps.com-2510.jpg/revision/latest/scale-to-width-down/250?cb=20140323064148"));
    }

    public List<User> allUsers() {
        return users;
    }

    public User save(User user) {
        usersCount++;
        user.setId(usersCount);
        users.add(user);
        return user;
    }

    public User findUser(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
