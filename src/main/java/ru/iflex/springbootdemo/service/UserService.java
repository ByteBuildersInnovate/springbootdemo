package ru.iflex.springbootdemo.service;
import ru.iflex.springbootdemo.model.User;
import java.util.List;

public interface UserService {
    User saveUser(String firstName, String lastName);
    User updateUser(Long id, String firstName, String lastName);
    User getUserById(Long id);
    User deleteUserById(Long id);
    List<User> getAllUsers();

}
