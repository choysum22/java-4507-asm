package Command;

/*
 * Class: SellCommand
 * @CHOY Ming San
 *
 */

import Toy.ToyProduct;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class SellCommand implements Command {
    private Scanner sc;
    private LinkedList toys;
    private CareTaker careTaker;
    private Stack<String> undoCommand;

    // constructor
    public SellCommand(Scanner sc, LinkedList toys, CareTaker careTaker, Stack undoCommand) {
        this.sc = sc;
        this.toys = toys;
        this.careTaker = careTaker;
        this.undoCommand = undoCommand;
    }

    // execute selling command
    @Override
    public void execute() {
        boolean notFound = true; // determine if the product is found or not

        while (true) {
            try {
                // prompt user input product id
                System.out.println("Enter Code:");
                int productID = Integer.parseInt(sc.nextLine());

                // search for toy in linked list by id
                for (Object t : toys) {
                    // product found
                    if (((ToyProduct) t).getProductID() == productID) {
                        // prompt user input selling details
                        System.out.println("Quantity to be sold:");
                        int quantity = Integer.parseInt(sc.nextLine());
                        if (quantity == 0) {
                            System.out.println("Quantity cannot be 0. Returning to main page...");
                            notFound = false;
                            break;
                        }
                        int currentQty = ((ToyProduct) t).getQty();
                        String name = ((ToyProduct) t).getName();

                        // check for sufficient quantity before performing selling
                        if (currentQty < quantity) {
                            System.out.println("Insufficient quantity. " +
                                    "There are  " + currentQty +
                                    " boxes of " + name + " remaining.");
                            notFound = false; // reset found state
                            break;
                        }

                        // prompt user input selling price
                        System.out.println("Selling Price:");
                        double price = Double.parseDouble(sc.nextLine());

                        // remember state
                        careTaker.remember((ToyProduct) t, true);

                        // add command to undo list
                        undoCommand.push("Sell " + quantity + " " +
                                ((ToyProduct) t).getProductID() + " " +
                                ((ToyProduct) t).getName() + " " + price);

                        // update new quantity and new selling price
                        ((ToyProduct) t).setQty(currentQty - quantity);
                        ((ToyProduct) t).setPrice(price);

                        // print result
                        System.out.printf("Sold %d boxes of %s. Current quantity is %d. " +
                                        "Selling Price is $%s .\n",
                                quantity,
                                ((ToyProduct) t).getName(),
                                ((ToyProduct) t).getQty(),
                                ((ToyProduct) t).getPrice());

                        notFound = false;
                        break;
                    }
                }

                // display error message when product is not found and continue loop
                if (notFound) {
                    System.out.println("Product not found.");
                }
                break;

            } catch (Exception e) { // catch invalid input while asking for selling detail
                System.out.println("\nInvalid Input. Please try again.\n");
            }
        }
    }
}
