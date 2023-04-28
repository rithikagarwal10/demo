package ca.cmpt6.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByAge(int age);
    List<User> findByNameAndAge(String name, int age);
}
