package Toy;

/*
 * Class: Robot
 * @CHOY Ming San
 *
 */

public class Robot extends ToyProduct {
    private double height;

    public Robot(int productID, String name, double height) {
        super(productID, name);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("%-8s %-32s %-12s %-12s %-8s %-8s",
                super.getProductID(),
                super.getName(),
                super.getQty(),
                height + "cm",
                "$" + String.format("%.2f", super.getCost()),
                "$" + String.format("%.2f", super.getPrice()));
    }

    public String showDetails() {
        return "";
    }
}
