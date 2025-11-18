package ms.org.service;

import ms.org.dao.UserDAO;
import ms.org.daoimplement.UserDAOImpl;
import ms.org.model.User;

public class UserService {

    private final UserDAO userDAO = new UserDAOImpl();

    public boolean register(String name, String email, String password, String phone, String address) {
        if (userDAO.findByEmail(email) != null) {
            System.out.println("Email already exists!");
            return false;
        }
        User user = new User(name, email, password, phone, address);
        userDAO.save(user);
        System.out.println("User registered successfully.");
        return true;
    }

    public User login(String email, String password) {
        User user = userDAO.findByEmail(email);
        if (user == null) {
            System.out.println("User not found.");
            return null;
        }
        if (!user.getPassword().equals(password)) {
            System.out.println("Invalid password.");
            return null;
        }
        System.out.println("Login successful. Welcome, " + user.getName());
        return user;
    }
}


