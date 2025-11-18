package ms.org.dao;


import ms.org.model.User;

public interface UserDAO {
    void save(User user);
    User findByEmail(String email);
}
