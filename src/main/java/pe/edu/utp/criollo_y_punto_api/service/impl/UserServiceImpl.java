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
    public User get(Integer userid) {
        return userRepository.findById(userid).orElse(null);

    }

    @Override
    public User save(User user) {
        return userRepository.save(user);

    }

    @Override
    public User update(User user) {
        return userRepository.save(user);

    }

    @Override
    public void delete(Integer userid) {
        userRepository.deleteById(userid);

    }

}
