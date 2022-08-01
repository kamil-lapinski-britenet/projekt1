package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.database.object.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderProductsService {

    private final DatabaseService databaseService;

    public OrderProductsService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<OrderProducts> getOrderProducts() {
        return this.databaseService.performSQL("SELECT orderproducts.orderProductId, product.productId AS productId, product.name, product.price, orders.orderId, orders.orderDate, orders.status FROM orderproducts LEFT JOIN product ON orderproducts.productId = product.productId LEFT JOIN orders ON orderproducts.orderId = orders.orderId;", resultSet -> {
            List<OrderProducts> orderProductsList = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    Product product = new Product(resultSet.getInt("productId"));
                    product.setName(resultSet.getString("product.name"));
                    product.setPrice(resultSet.getDouble("product.price"));
                    Order order = new Order(resultSet.getInt("orderId"));
                    order.setStatus(resultSet.getString("status"));
                    order.setOrderDate(resultSet.getDate("orderDate"));
                    OrderProducts orderProducts = new OrderProducts(resultSet.getInt("orderProductId"));
                    orderProducts.setOrderId(resultSet.getInt("orderId"));
                    orderProducts.setProduct(product);
                    orderProducts.setOrder(order);
                    orderProductsList.add(orderProducts);
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return orderProductsList;
        });
    }
//"SELECT * FROM orderProducts"
    public Optional<OrderProducts> getOrderProduct(int orderProductId) {
        OrderProducts retrievedOrderProducts = this.databaseService.performSQL(String.format("SELECT * FROM orderProducts WHERE orderProductId = %d", orderProductId), resultSet -> {
            try {
                if (resultSet.next()) {
                    OrderProducts orderProducts = new OrderProducts(resultSet.getInt("orderProductId"));

                    return orderProducts;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(retrievedOrderProducts);
    }

    public void insertOrderProduct(OrderProducts orderProducts) {
        this.databaseService.performDML(String.format("SET foreign_key_checks=0"));
        this.databaseService.performDML(String.format("INSERT INTO orderProducts (productId, orderId) VALUES ('"+orderProducts.getProductId()+"', '"+orderProducts.getOrderId()+"')"));
        this.databaseService.performDML(String.format("SET foreign_key_checks=1"));
    }

    public void deleteOrderProduct (int orderProductId) {
        this.databaseService.performDML(String.format("SET foreign_key_checks=0"));
        this.databaseService.performDML(String.format("DELETE FROM orderProducts WHERE orderProductId = %d", orderProductId));
        this.databaseService.performDML(String.format("SET foreign_key_checks=1"));
    }

    public void updateOrderProduct(OrderProducts orderProducts) {

        this.databaseService.performDML(String.format("UPDATE orderProducts SET productId = "+orderProducts.getProductId() + ", orderId = "+orderProducts.getOrderId()+" WHERE orderProductsId = %d", orderProducts.getOrderProductId()));

    }


}
