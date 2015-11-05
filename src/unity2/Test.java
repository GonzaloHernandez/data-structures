/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unity2;

import java.util.Random;

/**
 *
 * @author chalo
 */
public class Test {
    
    public static void simpleListTest() {
        System.out.println("-------------- Testing SimpleList ---------------");
        Random r = new Random();
        SimpleList sl = new SimpleList();
        for (int i=0; i<10; i++) {
            sl.add(r.nextInt(100));
        }
        System.out.print("Initial values: ");
        sl.print();
    }
    
    public static void main(String args[]) {
        simpleListTest();
    }
}
