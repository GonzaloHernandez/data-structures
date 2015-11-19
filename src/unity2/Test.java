/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unity2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author chalo
 */
public class Test {
    public static void treeTest() {
        System.out.println("-------------- Testing ABC Trees -----------------");
        Random r = new Random();
        Tree t = new Tree();
        for (int i=0; i<10; i++) {
            t.add(r.nextInt(100));
        }
        System.out.print("Initial values: ");
        t.print();
        t.draw("Initial Values");
        System.out.print("The tree leafs are: ");
        t.printLeafs();
        System.out.print("The elements of leve 2 are : ");
        t.printLevel(2);
        System.out.print("The path to element 2 is: ");
        t.printPath(2);
        System.out.println("The nearest leaf is: "+t.nearestLeaf());
//        if (t.isComplete()) {
//            System.out.println("This tree is Complete");
//        }
//        else {
//            System.out.println("This tree isn't Complete");
//        }
//        t.prune();
//        t.draw("After prunning");
        t.balance();
        t.balance();
        t.draw("After balancing");
        Scanner scan = new Scanner(System.in);
        System.out.print("Which element do you want to remove? ");
        int value = scan.nextInt();
        t.remove(value);
        t.draw("After removing the "+value+" element");
    }
    
    public static void main(String args[]) {
        treeTest();
    }
}
