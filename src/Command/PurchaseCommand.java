package Command;

/*
 * Class: PurchaseCommand
 * @CHOY Ming San
 *
 */

import Toy.ToyProduct;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class PurchaseCommand implements Command {
    private Scanner sc;
    private LinkedList toys;
    private CareTaker careTaker;
    private Stack<String> undoCommand;

    // constructor
    public PurchaseCommand(Scanner sc, LinkedList toys, CareTaker careTaker, Stack undoCommand) {
        this.sc = sc;
        this.toys = toys;
        this.careTaker = careTaker;
        this.undoCommand = undoCommand;
    }

    // execute purchase command
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
                        // prompt user input purchase details
                        System.out.println("Quantity to be purchased:");
                        int quantity = Integer.parseInt(sc.nextLine());
                        if (quantity == 0) {
                            System.out.println("Quantity cannot be 0. Returning to main page...");
                            notFound = false;
                            break;
                        }
                        System.out.println("Purchasing Cost:");
                        double cost = Double.parseDouble(sc.nextLine());

                        // remember state
                        careTaker.remember((ToyProduct) t, true);

                        // add command to undo list
                        undoCommand.push("Purchase " + quantity + " " +
                                ((ToyProduct) t).getProductID() + " " +
                                ((ToyProduct) t).getName() + " " + cost);

                        // calculate quantity and cost for the toy
                        int currentQty = ((ToyProduct) t).getQty();
                        double currentCost = ((ToyProduct) t).getCost();
                        double currentTotalCost = currentCost * currentQty;
                        cost = (cost * quantity + currentTotalCost) / (currentQty + quantity);

                        // update new quantity and new cost
                        ((ToyProduct) t).setQty(currentQty + quantity);
                        ((ToyProduct) t).setCost(cost);

                        // print result
                        System.out.printf("Purchased %d boxes of %s. Current quantity is %d. " +
                                        "Current cost is $%s . Price is $%s .\n",
                                quantity,
                                ((ToyProduct) t).getName(),
                                ((ToyProduct) t).getQty(),
                                ((ToyProduct) t).getCost(),
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
            } catch (Exception e) { // catch invalid input while asking for purchase detail
                System.out.println("\nInvalid Input. Please try again.\n");
            }
        }

    }
}
