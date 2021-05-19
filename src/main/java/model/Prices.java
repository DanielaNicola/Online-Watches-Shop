package model;


public class Prices {
    int no;
    String prices;
    String products;

    public Prices(int no, String prices, String products)  {
        this.no = no;
        this.prices = prices;
        this.products = products;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }
}


