package Toy;

/*
 * Interface: ToyFactory
 * @CHOY Ming San
 *
 */

import java.util.LinkedList;
import java.util.Scanner;

public interface ToyFactory {
    ToyProduct createToy(Scanner sc, LinkedList toys);
} // factory interface for creating new toy
