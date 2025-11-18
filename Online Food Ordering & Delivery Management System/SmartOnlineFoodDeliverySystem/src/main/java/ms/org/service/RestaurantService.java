package ms.org.service;

import ms.org.dao.MenuItemDAO;
import ms.org.dao.RestaurantDAO;
import ms.org.daoimplement.MenuItemDAOImpl;
import ms.org.daoimplement.RestaurantDAOImpl;
import ms.org.model.MenuItem;
import ms.org.model.Restaurant;

import java.util.List;

public class RestaurantService {

    private final RestaurantDAO restaurantDAO = new RestaurantDAOImpl();
    private final MenuItemDAO menuItemDAO = new MenuItemDAOImpl();

    public List<Restaurant> getAllRestaurants() {
        return restaurantDAO.findAll();
    }

    public List<MenuItem> getMenuForRestaurant(Integer restaurantId) {
        Restaurant restaurant = restaurantDAO.findById(restaurantId);
        if (restaurant == null) {
            System.out.println("Restaurant not found.");
            return null;
        }
        return menuItemDAO.findByRestaurant(restaurant);
    }

    public MenuItem getMenuItemById(Integer id) {
        return menuItemDAO.findById(id);
    }
}

