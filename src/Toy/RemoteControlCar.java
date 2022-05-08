package Toy;

/*
 * Class: RemoteControlCar
 * @CHOY Ming San
 *
 */

public class RemoteControlCar extends ToyProduct {
    private double maxSpeed;

    public RemoteControlCar(int productID, String name, double maxSpeed) {
        super(productID, name);
        this.maxSpeed = maxSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return String.format("%-8s %-32s %-12s %-12s %-8s %-8s",
                super.getProductID(),
                super.getName(),
                super.getQty(),
                maxSpeed + "km/hr",
                "$" + String.format("%.2f", super.getCost()),
                "$" + String.format("%.2f", super.getPrice()));
    }

    public String showDetails() {
        return "";
    }
}
