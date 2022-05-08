package Toy;

/*
 * Class: RobotFactory
 * @CHOY Ming San
 *
 */

import java.util.LinkedList;
import java.util.Scanner;

public class RobotFactory implements ToyFactory {
    // create new robot
    @Override
    public ToyProduct createToy(Scanner sc, LinkedList toys) {
        boolean continueLoop = false; //determine if the loop should continue
        int productID;
        String name;
        double height;
        while (true) {
            try {
                // prompt user input
                System.out.println("Enter id:");
                productID = Integer.parseInt(sc.nextLine());

                //check if the id is 0
                if (productID == 0) {
                    System.out.println("Product ID cannot be 0. Please try again. \n");
                    continueLoop = false;
                    continue;
                }

                // check if the id already exist in toys list
                for (Object t : toys) { // search through linked list
                    if (((ToyProduct) t).getProductID() == productID) {
                        System.out.println("\nA Toy with id: " + productID + " already exist.");
                        System.out.println("Please try again.\n");
                        continueLoop = true; // set continue loop to true
                    }
                }
                if (continueLoop) { // breaks out of this iteration
                    continueLoop = false;
                    continue;
                }

                // enter name of the toy
                System.out.println("Enter name:");
                name = sc.nextLine();

                // enter height of the toy
                System.out.println("Enter height(cm):");
                height = Double.parseDouble(sc.nextLine());
                break;
            } catch (Exception e) { // catch invalid input and prompt user to retry again
                System.out.println("Invalid Input. Please try again.");
            }
        }

        System.out.println("\nNew toy product record created.\n");

        return new Robot(productID, name, height);

    }
}
