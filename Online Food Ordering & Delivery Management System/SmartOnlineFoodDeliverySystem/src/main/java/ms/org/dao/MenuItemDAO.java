package ms.org.dao;

import ms.org.model.MenuItem;
import ms.org.model.Restaurant;

import java.util.List;

public interface MenuItemDAO {
    void save(MenuItem item);
    List<MenuItem> findByRestaurant(Restaurant restaurant);
    MenuItem findById(Integer id);
}

