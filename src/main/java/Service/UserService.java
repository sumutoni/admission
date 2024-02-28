package Service;
import java.util.List;
import Model.User;
import Repository.UserRepository;

public class UserService implements UserServiceInterface{
    private final UserRepository userRepo= new UserRepository();

    @Override
    public List<User> getUsers() {
        List<User> users = userRepo.getAllUsers();
        return users;
    }

    @Override
    public void createUser(User user) {
        userRepo.createUser(user);
    }

    @Override
    public User getUser(String email, String password) {
        User user = userRepo.getUser(email, password);
        return user;
    }




}
