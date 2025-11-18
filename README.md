# Online-Food-Ordering-Delivery-Management-System
Developed a layered architecture based Online Food Ordering System using Java, Hibernate, JDBC and MySQL. The system supports user registration, login authentication, restaurant &amp; menu browsing, order placement, and admin sales reports. Built using real-world backend development standards such as DAO, Service Layer, ORM mapping,


# 🍔 Online Food Ordering & Delivery Management System

A full-stack console-based food ordering application developed using **Java, Hibernate ORM, JDBC & MySQL**.  
This system allows users to register, login, view restaurants, browse menu items, place food orders, and view order history.  
Additionally, the admin can view restaurant-wise sales reports using SQL aggregations.

---

## 📌 Features

### 👤 User Module
- Register & Login authentication  
- View available restaurants  
- Browse restaurant-wise menu items  
- Place food orders easily  
- View order history  

### 🍽 Restaurant Module
- Restaurant listing with ratings & location  
- Menu items filtered by restaurant  

### 📊 Admin / Reporting Module
- View restaurant-wise sales revenue reports

---

## 🏗 Project Architecture (Layered Pattern)

UI Layer → Console (MainApp)
Service Layer → OrderService, UserService, RestaurantService
DAO Layer → Hibernate + JDBC
DB Layer → MySQL


---

## 🛠️ Technologies Used

| Category | Technology |
|----------|------------|
| Language | Java 11+ |
| Database | MySQL |
| ORM | Hibernate |
| JDBC | Native Connectivity |
| Build Tool | Maven |
| IDE | Eclipse / IntelliJ IDEA |

---

## 📂 Folder Structure

<img width="375" height="1034" alt="image" src="https://github.com/user-attachments/assets/2efad11c-185d-4542-b7d7-0d4eb6f3bde3" />
<img width="348" height="191" alt="image" src="https://github.com/user-attachments/assets/b0dc8ffc-8325-4544-aedf-a1557c2108c0" />


---

## 🏦 Database Schema

### `users`
| Column | Type | Description |
|--------|------|-------------|
| userId | INT (PK) | Auto Increment |
| name | VARCHAR | User Full Name |
| email | VARCHAR (unique) | Login Email |
| password | VARCHAR | User Password |
| phone | VARCHAR | Mobile Number |
| address | VARCHAR | Delivery Address |

### `restaurants`
| Column | Type |
|--------|------|
| restaurantId | INT (PK) |
| name | VARCHAR |
| location | VARCHAR |
| rating | DOUBLE |

### `menu_items`
| Column | Type |
|--------|------|
| itemId | INT (PK) |
| restaurant_id | FK → restaurants |
| itemName | VARCHAR |
| price | DOUBLE |
| category | VARCHAR |

### `orders`
| Column | Type |
|--------|------|
| orderId | INT (PK) |
| user_id | FK → users |
| restaurant_id | FK |
| orderDate | DATETIME |
| status | VARCHAR |
| totalAmount | DOUBLE |

---

## ▶️ How to Run

1. Clone repository  

2. Import in **Eclipse/IntelliJ**
3. Create MySQL DB named: `food_delivery_db1`
4. Run the project from `MainApp.java`

---

## 🚀 Future Improvements

- Online payment gateway integration  
- Admin dashboard with GUI  
- Email/SMS notification  
- Mobile app version  

---

## 📞 Developer Info

| Name | Role |
|------|------|
| **Murgan Swami M** | Backend Developer |
| **Lokesh V** | Support & Testing |

**Guided By:** *Mrs. Vijaya*  
**Institution:** *Anudip Foundation*  
**Course:** *Advanced Java Programming*

---

## 📄 License
This project is developed for educational & academic purposes only.




