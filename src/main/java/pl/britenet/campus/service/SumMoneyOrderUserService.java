package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;

import java.sql.SQLException;
import java.util.HashMap;

public class SumMoneyOrderUserService {

    private final DatabaseService databaseService;

    public SumMoneyOrderUserService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public HashMap<Integer, Double> getSumMoneyOrderUser() {

        return this.databaseService.performSQL("SELECT us.userId, us.name, us.lastname, (SELECT SUM(p.price) AS 'suma' " +
                "FROM orders AS o RIGHT JOIN " +
                "orderproducts AS op ON o.orderId = op.orderId " +
                "RIGHT JOIN product AS p ON op.productId = p.productId " +
                "WHERE o.userId = us.userId) AS SUMA_ZAMÓWIEŃ " +
                "FROM users AS us; ", resultSet -> {
            HashMap<Integer, Double> newHashMap = new HashMap<Integer, Double>();
            try {
                while (resultSet.next()) {

                    double sumMoney = resultSet.getDouble("suma");
                    int idUser = resultSet.getInt("us.userId");
                    newHashMap.put(idUser, sumMoney);
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return newHashMap;
        });

}}
