package pl.britenet.campus.database.object;

import pl.britenet.campus.Constants;

public class User {
    private final int userId;
    private String name;
    private String lastName;
    private String mail;
    private String address;
    private String password;
    private String telephone;
    private int imageId;
    private Images images;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public User (int userId){
        this.userId = userId;
    }
    public User() {
        this.userId = Constants.INVALID_ID;
    }

    public User(int userId, String name, String lastName, String mail, String address, String password, String telephone) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.address = address;
        this.password = password;
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "id: " +userId +  " imie: " +name + " nazwisko: " +lastName+ " mail: " +mail+ " adres: " +address+ " haslo: " +password+ " telefon: " + telephone;
    }

}
