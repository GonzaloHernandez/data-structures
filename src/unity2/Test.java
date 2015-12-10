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
        Scanner scan = new Scanner(System.in);

        Tree t = new Tree();
        for (int i=0; i<20; i++) {
//            t.add(r.nextInt(100));
            t.add(i+5);
        }
//        System.out.print("Initial values:");   
//        t.print();
//        t.draw("Initial Values");

//        System.out.print("The tree leafs:");
//        t.printLeafs();
//
//        System.out.print("Which level do you want to see? ");
//        int level = scan.nextInt();
//        System.out.print("The elements of leve " + level + ":");
//        t.printLevel(level);
//
//        System.out.print("Which value do you want to looking path for? ");
        int value;
//        value = scan.nextInt();
//        System.out.print("Path to " + value +":");
//        t.printPath(value);
//
//        System.out.println("The nearest leaf is: "+t.nearestLeaf());
//
//        if (t.isComplete()) {
//            System.out.println("This tree is Complete");
//        }
//        else {
//            System.out.println("This tree isn't Complete");
//        }
//
//        t.prune();
//        t.draw("After prunning");

        t.balance();
        t.balance();
        t.draw("After balancing");

//        System.out.print("Which element do you want to remove? ");
//        value = scan.nextInt();
//        t.remove(value);
//        t.draw("After removing the "+value+" element");
        
//        System.out.print("Which element do you want to know its brother? ");
//        value = scan.nextInt();
//        t.printBrotherOf(value);

//        t.printFirstLeaf();

        t.invert();
        t.draw("Inverted");

        System.out.println(""+t.isConsecutive());

    }
    
    public static void main(String args[]) {
        treeTest();
    }
}
