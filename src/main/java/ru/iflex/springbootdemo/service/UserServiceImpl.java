package ru.iflex.springbootdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.iflex.springbootdemo.model.User;
import ru.iflex.springbootdemo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService{


    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> getById(Long id) {
        log.info("IN UserServiceImpl getById {}", id);
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        log.info("IN UserServiceImpl save {}", user);
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        log.info("IN UserServiceImpl delete {}", id);
        userRepository.deleteById(id);

    }

    @Override
    public List<User> getAll() {
        log.info("IN UserServiceImpl getAll");
        return userRepository.findAll();
    }
}
