package ms.org.ui;

import ms.org.dao.ReportDAO;
import ms.org.daoimplement.ReportDAOImpl;
import ms.org.model.MenuItem;
import ms.org.model.Order;
import ms.org.model.Restaurant;
import ms.org.model.User;
import ms.org.service.OrderService;
import ms.org.service.RestaurantService;
import ms.org.service.UserService;
import ms.org.util.HibernateUtil;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    private static final Scanner scanner = new Scanner(System.in);

    private static final UserService userService = new UserService();
    private static final RestaurantService restaurantService = new RestaurantService();
    private static final OrderService orderService = new OrderService();
    private static final ReportDAO reportDAO = new ReportDAOImpl();

    public static void main(String[] args) {
        boolean exit = false;
        User loggedInUser = null;

        while (!exit) {
            if (loggedInUser == null) {
                System.out.println("\n=== Online Food Ordering & Delivery Management System ===");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                int choice = readInt();

                switch (choice) {
                    case 1 -> register();
                    case 2 -> loggedInUser = login();
                    case 0 -> exit = true;
                    default -> System.out.println("Invalid choice.");
                }
            } else {
                System.out.println("\n=== Welcome " + loggedInUser.getName() + " ===");
                System.out.println("1. View Restaurants");
                System.out.println("2. View My Orders");
                System.out.println("3. Place Simple Order");
                System.out.println("4. View Sales Report (Admin demo - JDBC)");
                System.out.println("5. Logout");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                int choice = readInt();

                switch (choice) {
                    case 1 -> viewRestaurants();
                    case 2 -> viewMyOrders(loggedInUser);
                    case 3 -> placeSimpleOrder(loggedInUser);
                    case 4 -> reportDAO.printTotalSalesPerRestaurant();
                    case 5 -> loggedInUser = null;
                    case 0 -> {
                        exit = true;
                        HibernateUtil.shutdown();
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
        }

        System.out.println("Thank you for using the system.");
    }

    private static void register() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        userService.register(name, email, password, phone, address);
    }

    private static User login() {
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        return userService.login(email, password);
    }

    private static void viewRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        if (restaurants == null || restaurants.isEmpty()) {
            System.out.println("No restaurants found.");
            return;
        }
        System.out.println("=== Restaurants ===");
        for (Restaurant r : restaurants) {
            System.out.println(r.getRestaurantId() + ". " + r.getName() +
                    " (" + r.getLocation() + ") Rating: " + r.getRating());
        }
    }

    private static void viewMyOrders(User user) {
        List<Order> orders = orderService.getOrdersForUser(user);
        if (orders == null || orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }
        System.out.println("=== My Orders ===");
        for (Order o : orders) {
            System.out.println("Order ID: " + o.getOrderId() +
                    ", Restaurant: " + o.getRestaurant().getName() +
                    ", Total: " + o.getTotalAmount() +
                    ", Status: " + o.getStatus() +
                    ", Date: " + o.getOrderDate());
        }
    }

    // Simple order: user selects restaurant, selects one item, quantity
    private static void placeSimpleOrder(User user) {
        viewRestaurants();
        System.out.print("Enter Restaurant ID: ");
        int restId = readInt();

        var menu = restaurantService.getMenuForRestaurant(restId);
        if (menu == null || menu.isEmpty()) {
            System.out.println("No menu items for this restaurant.");
            return;
        }

        System.out.println("=== Menu ===");
        for (MenuItem item : menu) {
            System.out.println(item.getItemId() + ". " + item.getItemName() +
                    " - " + item.getPrice());
        }

        System.out.print("Enter Item ID: ");
        int itemId = readInt();

        MenuItem selectedItem = restaurantService.getMenuItemById(itemId);
        if (selectedItem == null) {
            System.out.println("Invalid item.");
            return;
        }

        System.out.print("Enter quantity: ");
        int qty = readInt();

        orderService.placeSimpleOrder(user, restId, selectedItem, qty);
    }

    private static int readInt() {
        while (true) {
            try {
                String line = scanner.nextLine();
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException ex) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}

