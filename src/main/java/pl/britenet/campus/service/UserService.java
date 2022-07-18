package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.database.object.Images;
import pl.britenet.campus.database.object.User;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserService {

    private final DatabaseService databaseService;

    public UserService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<User> getUsers() {




            return this.databaseService.performSQL("SELECT users.userId, users.name, users.lastname, users.mail, users.address, users.password, users.telephone, images.imageId, images.paths FROM users LEFT JOIN images ON users.userId = images.userId"
                   , resultSet -> {
                List<User> userList = new ArrayList<>();
                try {
                    while (resultSet.next()) {
                        Images images = new Images(resultSet.getInt("imageId"));
                        images.setPaths(resultSet.getString("paths"));
                        User user = new User(resultSet.getInt("userId"));
                        user.setName(resultSet.getString("name"));
                        user.setLastName(resultSet.getString("lastName"));
                        user.setMail(resultSet.getString("mail"));
                        user.setAddress(resultSet.getString("address"));
                        user.setPassword(resultSet.getString("password"));
                        user.setTelephone(resultSet.getString("telephone"));
                        user.setImages(images);
                        userList.add(user);
                    }
                } catch (SQLException exception) {
                    throw new IllegalStateException(exception);
                }
                return userList;
            });




    }
//"SELECT * FROM users"
    public Optional<User> getUser(int userId) {
        User retrievedUser = this.databaseService.performSQL(String.format("SELECT * FROM users WHERE userId = %d", userId), resultSet -> {
            try {
                if (resultSet.next()) {
                    User user = new User(resultSet.getInt("userId"));
                    user.setName(resultSet.getString("name"));
                    user.setLastName(resultSet.getString("lastName"));
                    user.setMail(resultSet.getString("mail"));
                    user.setAddress(resultSet.getString("address"));
                    user.setPassword(resultSet.getString("password"));
                    user.setTelephone(resultSet.getString("telephone"));
                    return user;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(retrievedUser);
    }

    public void insertUser(User user) {
        this.databaseService.performDML(String.format("" +
                "INSERT INTO users (name, lastname, mail, address, password, telephone) VALUES ('%s', '%s', '%s', '%s','%s', '%s')"
                , user.getName(), user.getLastName(), user.getMail(), user.getAddress(), user.getPassword(), user.getTelephone()));

    }

    public void deleteUser (int userId) {

            this.databaseService.performDML(String.format("SET foreign_key_checks=0"));
            this.databaseService.performDML(String.format("DELETE FROM users WHERE userId = %d", userId));
            this.databaseService.performDML(String.format("SET foreign_key_checks=1"));

    }

    public void updateUser (User user) {
        this.databaseService.performDML(String.format("UPDATE users SET name = '%s', lastname = '%s', mail = '%s', address = '%s', password = '%s', telephone = '%s' WHERE userId = %d",
                user.getName(), user.getLastName(), user.getMail(), user.getAddress(), user.getPassword(), user.getTelephone(), user.getUserId()));
    }


}
