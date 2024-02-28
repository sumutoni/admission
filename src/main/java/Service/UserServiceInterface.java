package Service;
import Model.User;
import java.util.List;

public interface UserServiceInterface {
    public List<User>getUsers();
    public void createUser(User user);
    public User getUser(String email, String password);
}
