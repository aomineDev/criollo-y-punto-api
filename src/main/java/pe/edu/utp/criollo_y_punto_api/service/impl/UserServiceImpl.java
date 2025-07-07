package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import pe.edu.utp.criollo_y_punto_api.repository.UserRepository;
import pe.edu.utp.criollo_y_punto_api.service.UserService;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User get(Integer id) {
    }

    @Override
    public User save(User entity) {
    }

    @Override
    public User update(User entity) {
    }

    @Override
    public void delete(Integer id) {
    }

}
