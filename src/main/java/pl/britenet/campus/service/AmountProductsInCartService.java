package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;

import java.sql.SQLException;
import java.util.HashMap;

public class AmountProductsInCartService {


    private final DatabaseService databaseService;

    public AmountProductsInCartService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public HashMap<Integer, Integer> getAmountProductsInCartService() {

        return this.databaseService.performSQL("SELECT COUNT(cartproducts.productId)*cartproducts.amount AS 'liczba', cart.cartId " +
                "FROM cartproducts RIGHT JOIN cart ON cartproducts.cartId = cart.cartId " +
                "GROUP BY cart.cartId ", resultSet -> {
            HashMap<Integer, Integer> newHashMap = new HashMap<Integer, Integer>();
            try {
                while (resultSet.next()) {
                    int amount = resultSet.getInt("liczba");
                    int cartId = resultSet.getInt("cart.cartId");
                    newHashMap.put(cartId, amount);
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return newHashMap;
        });

    }

}
