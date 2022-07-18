package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.database.object.Cart;
import pl.britenet.campus.database.object.Product;
import pl.britenet.campus.database.object.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AmountUserProductService {

    private final DatabaseService databaseService;

    public AmountUserProductService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public HashMap<Integer, Integer> getAmountCartProduct() {

        return this.databaseService.performSQL(" SELECT COUNT(cartproducts.productId)*cartProducts.amount AS liczba, cart.userId AS userId " +

                "FROM cartproducts, cart " +
                "GROUP BY cart.userId ", resultSet -> {
            HashMap<Integer, Integer> newHashMap = new HashMap<Integer, Integer>();
            try {
                while (resultSet.next()) {
                    int userId = resultSet.getInt("userId");
                    int amount = resultSet.getInt("liczba");
                    newHashMap.put(userId, amount);
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return newHashMap;
        });
    }


}
