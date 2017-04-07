package ua.horbatiuk88.service;

import ua.horbatiuk88.entity.User;

import java.util.List;

public interface UserService {

    User getById(Long id);

    void delete(Long id);

    Long update(User user);

    List<User> getAll();
}
