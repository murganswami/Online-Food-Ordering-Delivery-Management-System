package ms.org.dao;

import ms.org.model.Order;
import ms.org.model.User;

import java.util.List;

public interface OrderDAO {
    void save(Order order);
    List<Order> findByUser(User user);
}
