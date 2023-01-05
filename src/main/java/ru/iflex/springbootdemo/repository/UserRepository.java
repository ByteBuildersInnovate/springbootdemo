package ru.iflex.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iflex.springbootdemo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
