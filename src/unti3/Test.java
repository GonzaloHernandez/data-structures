/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unti3;

import java.util.Random;

/**
 *
 * @author chalo
 */
public class Test {
    public static void simpleListTest() {
        System.out.println("-------------- Testing SimpleList ---------------");
        Random r = new Random();
        Tree t = new Tree();
        for (int i=0; i<10; i++) {
            t.add(r.nextInt(100));
        }
        System.out.print("Initial values: ");
        t.print();
        t.draw("Initial Values");
        t.add(20);
        t.draw("After add a 20 value");
    }
    
    public static void main(String args[]) {
        simpleListTest();
    }
}
