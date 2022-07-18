package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;

import java.sql.SQLException;
import java.util.HashMap;

public class AmountOrderUserService {

    private final DatabaseService databaseService;

    public AmountOrderUserService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public HashMap<Integer, Integer> getAmountOrderUserService() {

        return this.databaseService.performSQL("SELECT COUNT(orders.orderId) AS 'liczba', users.userId " +
                "FROM orders RIGHT JOIN users ON orders.userId = users.userId " +
                "GROUP BY users.userId ", resultSet -> {
            HashMap<Integer, Integer> newHashMap = new HashMap<Integer, Integer>();
            try {
                while (resultSet.next()) {

                    int amount = resultSet.getInt("liczba");
                    int idUser = resultSet.getInt("users.userId");
                    newHashMap.put(idUser, amount);
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return newHashMap;
        });


}}
