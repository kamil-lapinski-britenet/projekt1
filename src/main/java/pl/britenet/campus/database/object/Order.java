package pl.britenet.campus.database.object;

import pl.britenet.campus.Constants;

import java.util.Date;

public class Order {
    private final int orderId;

    public int getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    private String status;


    public Order() {
        this.orderId = Constants.INVALID_ID;
    }
    public Order(int orderId){
        this.orderId = orderId;
    }

    public Order(int orderId, String status, Date orderDate) {
        this.orderId = orderId;
        this.status = status;
        this.orderDate = orderDate;
    }

    private Date orderDate;
    private int userId;
    private int orderProductId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(int orderProductId) {
        this.orderProductId = orderProductId;
    }

    @Override
    public String toString() {
        return "id: " + orderId + " status: " + status + " data: " + orderDate;
    }

}
