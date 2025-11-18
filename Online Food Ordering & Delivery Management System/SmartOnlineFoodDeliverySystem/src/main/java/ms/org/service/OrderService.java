package ms.org.service;

import ms.org.dao.OrderDAO;
import ms.org.daoimplement.OrderDAOImpl;
import ms.org.model.MenuItem;
import ms.org.model.Order;
import ms.org.model.OrderItem;
import ms.org.model.Restaurant;
import ms.org.model.User;
import ms.org.dao.RestaurantDAO;
import ms.org.daoimplement.RestaurantDAOImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private final OrderDAO orderDAO = new OrderDAOImpl();
    private final RestaurantDAO restaurantDAO = new RestaurantDAOImpl();

    public void placeSimpleOrder(User user, Integer restaurantId, MenuItem menuItem, int quantity) {

        Restaurant restaurant = restaurantDAO.findById(restaurantId);
        if (restaurant == null) {
            System.out.println("Restaurant not found.");
            return;
        }

        Order order = new Order();
        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PLACED");

        double total = menuItem.getPrice() * quantity;
        order.setTotalAmount(total);

        OrderItem orderItem = new OrderItem(order, menuItem, quantity, menuItem.getPrice());
        List<OrderItem> items = new ArrayList<>();
        items.add(orderItem);
        order.setOrderItems(items);

        orderDAO.save(order);
        System.out.println("Order placed successfully. Total: " + total);
    }

    public List<Order> getOrdersForUser(User user) {
        return orderDAO.findByUser(user);
    }
}

