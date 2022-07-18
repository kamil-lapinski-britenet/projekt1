package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;

import java.sql.SQLException;
import java.util.HashMap;

public class AmountSellProductInMonthService {

    private final DatabaseService databaseService;

    public AmountSellProductInMonthService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public HashMap<String, Integer> getAmountSellProductInMonth() {

        return this.databaseService.performSQL("SELECT COUNT(orderproducts.productId) AS 'liczba', orders.orderDate AS 'dataZamowienia' " +
                "FROM orderproducts RIGHT JOIN orders ON orderproducts.orderId = orders.orderId " +
                "GROUP BY MONTH(orders.orderDate) ", resultSet -> {
            HashMap<String, Integer> newHashMap = new HashMap<String, Integer>();
            try {
                while (resultSet.next()) {
                    int amount = resultSet.getInt("liczba");
                    String dateProduct = resultSet.getString("dataZamowienia");
                    newHashMap.put(dateProduct, amount);
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return newHashMap;
        });
    }


}
