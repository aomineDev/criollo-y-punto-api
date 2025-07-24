package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.User;
import pe.edu.utp.criollo_y_punto_api.repository.UserRepository;
import pe.edu.utp.criollo_y_punto_api.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> get(Integer userid) {
		return userRepository.findById(userid);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public Optional<User> update(Integer id, User user) {
		return userRepository.findById(id).map(existingUser -> {
			user.setUserId(id);

			return userRepository.save(user);
		});
	}

	@Override
	public void delete(Integer userid) {
		userRepository.deleteById(userid);
	}

}
