package Command;

/*
 * Class: Memento
 * @CHOY Ming San
 *
 */

import Toy.RemoteControlCar;
import Toy.Robot;
import Toy.ToyProduct;

public class Memento {
    private ToyProduct toyProduct;
    private int qty;
    private String name;
    private double cost, price, maxSpeed, height;

    // constructor
    public Memento(ToyProduct toyProduct) {
        this.toyProduct = toyProduct;
        this.qty = toyProduct.getQty();
        this.name = toyProduct.getName();
        this.cost = toyProduct.getCost();
        this.price = toyProduct.getPrice();
        // determine the toy type
        if (toyProduct instanceof Robot) {
            this.height = ((Robot) toyProduct).getHeight();
        } else if (toyProduct instanceof RemoteControlCar) {
            this.maxSpeed = ((RemoteControlCar) toyProduct).getMaxSpeed();
        }
    }

    // restore saved state
    public void restore() {
        this.toyProduct.setName(this.name);
        this.toyProduct.setQty(this.qty);
        this.toyProduct.setCost(this.cost);
        this.toyProduct.setPrice(this.price);
        // determine toy type
        if (toyProduct instanceof Robot) {
            ((Robot) toyProduct).setHeight(this.height);
        } else if (toyProduct instanceof RemoteControlCar) {
            ((RemoteControlCar) toyProduct).setMaxSpeed(this.maxSpeed);
        }
    }

    // return saved toy object
    public ToyProduct getToyProduct() {
        return this.toyProduct;
    }
}
