package Toy;

/*
 * Class: ToyProduct
 * @CHOY Ming San
 *
 */

public class ToyProduct {
    private int productID;
    private int qty;
    private String name;
    private double cost, price;

    public ToyProduct(int productID, String name) {
        this.productID = productID;
        this.name = name;
        this.qty = 0;
        this.cost = 0;
        this.price = 0;
    }

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-8s %-32s %-12s %-12s %-8s %-8s",
                productID,
                name,
                qty,
                "N/A",
                "$" + cost,
                "$" + price);
    }

    public String showDetails() {
        return "";
    }
}
