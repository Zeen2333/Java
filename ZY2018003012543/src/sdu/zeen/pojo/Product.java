package sdu.zeen.pojo;

import java.util.Objects;

public class Product {
    private int ID;
    private String name;
    private float price;
    private String pic;

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                '}';
    }

    public Product(){
        super();
    }

    public Product(int ID, String name, float price, String pic) {
        super();
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.pic = pic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getID() == product.getID() &&
                Float.compare(product.getPrice(), getPrice()) == 0 &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getPic(), product.getPic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getName(), getPrice(), getPic());
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getPic() {
        return pic;
    }
}
