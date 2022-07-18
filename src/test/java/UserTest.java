import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.database.object.User;
import pl.britenet.campus.service.UserService;
import org.junit.jupiter.api.*;

import java.util.List;

public class UserTest {

    private UserService userService;
    private DatabaseService databaseService;

    @BeforeEach
    public void setup() {
        this.databaseService = new DatabaseService();
        this.userService = new UserService(databaseService);
    }

    @Test
    public void getUsersTest() {
            assert !this.userService.getUsers().isEmpty();
    }

    @Test
    public void getUserTest() {
        User user = new User(1,"Jan","Kowalski","jankowal@mail.pl","adres","pass","500000000"   );
        userService.insertUser(user);
        List<User> newlist  = userService.getUsers();
        assert this.userService.getUser(newlist.get(newlist.size()-1).getUserId()).isPresent();
        userService.deleteUser(newlist.get(newlist.size()-1).getUserId());
    }

    @Test
    public void deleteUserTest() {
        User user = new User(1,"Jan","Kowalski","jankowal@mail.pl","adres","pass","500000000"   );
        userService.insertUser(user);
        List<User> newlist  = userService.getUsers();
       userService.deleteUser(newlist.get(newlist.size()-1).getUserId());
        assert this.userService.getUsers().size() < newlist.size();
    }

    @Test
    public void insertUserTest() {
        List<User> newlist  = userService.getUsers();
        User user = new User(1,"Jan","Kowalski","jankowal@mail.pl","adres","pass","500000000"   );
        userService.insertUser(user);
        List<User> newlistTwo  = userService.getUsers();
        assert newlistTwo.size() > newlist.size();
        userService.deleteUser(newlistTwo.get(newlistTwo.size()-1).getUserId());
    }



}
