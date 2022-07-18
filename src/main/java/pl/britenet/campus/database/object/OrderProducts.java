package pl.britenet.campus.database.object;

public class OrderProducts {
    private int orderProductId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    private int productId;
    private int orderId;

    private Product product;
    private Order order;

    public OrderProducts(){}
    public OrderProducts(int orderProductId) {
        this.orderProductId = orderProductId;
    }

    public int getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(int orderProductId) {
        this.orderProductId = orderProductId;
    }

    @Override
    public String toString(){
        return "id zamowienia: "+ orderId+ "| data zamowienia: " + order.getOrderDate() +
                " | status zamowienia: "+ order.getStatus()+" | nazwa produktu: " + product.getName()+
                " | cena produktu: " + product.getPrice() + "zl";
    }
}
