package Movieflix.repository;

import java.util.List;

import Movieflix.entity.User;

public interface UserRepository {

	public List<User> findAll();

	public User findOne(String userId);

	public User findByEmail(String userEmail);

	public User create(User user);

	public User update(User user);

	public void delete(User existing);

}
