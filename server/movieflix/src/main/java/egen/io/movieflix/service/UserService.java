package egen.io.movieflix.service;

import java.util.List;

import egen.io.movieflix.entity.User;

public interface UserService {

	public List<User> findAll();

	public User findOne(String userId);

	public User create(User user);

	public User update(String userId, User user);

	public void remove(String userId);

}
