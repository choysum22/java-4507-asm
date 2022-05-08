package Command;

/*
 * Class: DisplayAllCommand
 * @CHOY Ming San
 *
 */

import Toy.RemoteControlCar;
import Toy.Robot;
import Toy.ToyProduct;

import java.util.LinkedList;
import java.util.Scanner;

public class DisplayToyCommand implements Command {
    private Scanner sc;
    private LinkedList toys;

    // constructor
    public DisplayToyCommand(Scanner sc, LinkedList toys) {
        this.sc = sc;
        this.toys = toys;
    }

    // execute display toy command
    @Override
    public void execute() {
        if (toys.isEmpty()) { // check if toys is empty
            System.out.println("There is nothing to display.");
        } else { // toys is not empty
            // prompt user input
            System.out.println("Enter ID (* to display all):");
            String input = sc.nextLine();
            if (input.equals("*")) { // "*" = display all
                //display all
                System.out.println("\nToy product information");
                System.out.printf("%-8s %-32s %-12s %-12s %-8s %-8s\n", "ID", "Name", "Quantity", "Other Info", "Cost", "Price");
                toys.forEach(System.out::println);
            } else { //display specific toy with given id
                String otherInfo = "";
                for (Object t : toys) { // search through linked list
                    if (((ToyProduct) t).getProductID() == Integer.parseInt(input)) {
                        System.out.println("\nToy product information");
                        if (t instanceof Robot) {
                            otherInfo = "Height";
                        } else if (t instanceof RemoteControlCar) {
                            otherInfo = "Max Speed";
                        }

                        // print results
                        System.out.printf("%-8s %-32s %-12s %-12s %-8s %-8s\n", "ID", "Name", "Quantity", otherInfo, "Cost", "Price");
                        System.out.println(t);
                        break;
                    }
                }
            }
        }

    }
}
