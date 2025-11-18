package ms.org.daoimplement;

import ms.org.dao.ReportDAO;
import ms.org.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReportDAOImpl implements ReportDAO {

    @Override
    public void printTotalSalesPerRestaurant() {
        String sql = "SELECT r.name, SUM(o.totalAmount) AS total_sales " +
                     "FROM restaurants r JOIN orders o ON r.restaurantId = o.restaurant_id " +
                     "GROUP BY r.restaurantId";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("=== Total Sales Per Restaurant ===");
            while (rs.next()) {
                String name = rs.getString("name");
                double sales = rs.getDouble("total_sales");
                System.out.println(name + " -> " + sales);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


