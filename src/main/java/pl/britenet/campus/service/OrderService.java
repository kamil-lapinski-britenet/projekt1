package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.database.object.Order;
import pl.britenet.campus.database.object.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderService {
    private final DatabaseService databaseService;

    public OrderService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<Order> getOrders() {
        return this.databaseService.performSQL("SELECT * FROM orders", resultSet -> {
            List<Order> orderList = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    Order order = new Order(resultSet.getInt("orderId"));
                    order.setStatus(resultSet.getString("status"));
                    order.setOrderDate(resultSet.getDate("orderDate"));
                    orderList.add(order);
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return orderList;
        });
    }

    public Optional<Order> getOrder(int orderId) {
        Order retrievedOrder = this.databaseService.performSQL(String.format("SELECT * FROM orders WHERE orderId = %d", orderId), resultSet -> {
            try {
                if (resultSet.next()) {
                    Order order = new Order(resultSet.getInt("orderId"));
                    order.setStatus(resultSet.getString("status"));
                    order.setOrderDate(resultSet.getDate("orderDate"));
                    return order;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(retrievedOrder);
    }

    public void insertOrder(Order order) {
        this.databaseService.performDML(String.format("INSERT INTO orders (status) VALUES ('%s')", order.getStatus()));
    }

    public void deleteOrder (int orderId) {
        this.databaseService.performDML(String.format("SET foreign_key_checks=0"));
        this.databaseService.performDML(String.format("DELETE FROM orders WHERE orderId = %d", orderId));
        this.databaseService.performDML(String.format("SET foreign_key_checks=1"));
    }

    public void updateOrder (Order order) {

        this.databaseService.performDML(String.format("UPDATE orders SET status= '" +order.getStatus()+"' WHERE orderId = %d",order.getOrderId()));
    }


}
