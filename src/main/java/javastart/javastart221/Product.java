package javastart.javastart221;

public class Product {

    private String name;
    private Double price;


    Product(String name,  Double price) {
        this.name = name;

        this.price = price;
    }

    Double getPrice() {
        return price;
    }



    @Override
    public String toString() {
        return "<br><h3>Name :'" + name +  ", price=" + price + "</h3>";
    }
}
