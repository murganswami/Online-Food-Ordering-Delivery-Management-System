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


---

## 📸 Screenshots

### 1️⃣ Project Start Page  
<img width="671" height="190" alt="image" src="https://github.com/user-attachments/assets/31212334-a58b-48bd-9fff-f211393adb43" />


### 2️⃣ User Registration  
<img width="582" height="201" alt="image" src="https://github.com/user-attachments/assets/1034e078-3dcb-40c5-b51d-d38e824f9e36" />


### 3️⃣ Restaurant List  
<img width="460" height="114" alt="image" src="https://github.com/user-attachments/assets/99c5e9e2-5fc1-4b95-865d-5e9925697aa0" />


### 4️⃣ Order Placed
<img width="473" height="179" alt="image" src="https://github.com/user-attachments/assets/d13407b3-18c0-4491-ae52-7965fbe8f4dc" />
<img width="215" height="26" alt="image" src="https://github.com/user-attachments/assets/b14d7bc8-5fa7-4d5d-b75d-197e8e8559f4" />
<img width="476" height="26" alt="image" src="https://github.com/user-attachments/assets/99d46474-fd35-4146-b92f-23a68172b839" />


### 5️⃣ Sales Report  
<img width="415" height="91" alt="image" src="https://github.com/user-attachments/assets/06cc22f1-97ad-4288-b9db-2e81a55ebf85" />


---



