package Movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Movieflix.entity.User;
import Movieflix.exception.MovieAlreadyExistException;
import Movieflix.exception.MovieNotFoundException;
import Movieflix.exception.UserAlreadyExistException;
import Movieflix.exception.UserNotFoundException;
import Movieflix.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findOne(String userId) {
		User user = userRepository.findOne(userId);
		if (user == null) {
			throw new UserNotFoundException("User not found");
		}
		return user; 
	}

	@Transactional
	@Override
	public User create(User user) {
		User existing = userRepository.findByEmail(user.getUserEmail());
		if (existing != null) {
			throw new UserAlreadyExistException("User already exists");
		}
		return userRepository.create(user);
	}

	@Transactional
	@Override
	public User update(String userId, User user) {
		User existing = userRepository.findOne(userId);
		if (existing == null) {
			throw new UserNotFoundException("User not found");
		}
		return userRepository.update(user);
	}

	@Transactional
	@Override
	public void remove(String userId) {
		User existing = userRepository.findOne(userId);
		if (existing == null) {
			throw new UserNotFoundException("User not found");
		}
		userRepository.delete(existing);
	}
}