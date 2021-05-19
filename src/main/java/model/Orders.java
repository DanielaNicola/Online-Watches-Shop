package model;



public class Orders {
    int ID;
    String orders;
    public Orders (String orders, int ID){
        this.orders = orders;
        this.ID=ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }
}