package ms.org.dao;



import ms.org.model.Restaurant;
import java.util.List;

public interface RestaurantDAO {
    void save(Restaurant restaurant);
    Restaurant findById(Integer id);
    List<Restaurant> findAll();
}

