package ua.horbatiuk88.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.horbatiuk88.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
