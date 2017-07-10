/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unity0;

/**
 *
 * @author chalo
 */
public class Test {
    
    public static void main(String args[]) {
        System.out.println("\n============= TESTING STACK CLASS ===============");
        Stack s = new Stack();
        try {
            s.add(48);
            s.add(75);
            s.add(17);

            System.out.print("Current elements: "); s.print();

            System.out.println("Removing..." + s.remove() );  
            System.out.println("Removing..." + s.remove() );  
            System.out.println("Removing..." + s.remove() );  
            System.out.println("Removing..." + s.remove() );  

        } catch (StaticListsException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("\n============= TESTING QUEUE CLASS ===============");
        Queue q = new Queue();
        try {
            q.add(48);
            q.add(75);
            q.add(17);

            System.out.print("Current elements: "); q.print();

            System.out.println("Removing..." + q.remove() );  
            System.out.println("Removing..." + q.remove() );  
            System.out.println("Removing..." + q.remove() );  
            System.out.println("Removing..." + q.remove() );  

        } catch (StaticListsException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\n============= TESTING LIST CLASS ===============");
        List l = new List();
        try {
            l.add(48);
            l.add(75);
            l.add(17);
            
            l.insert(39, 1);
            l.insert(55, 6);
        } catch (StaticListsException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.print("Current elements: "); l.print();
        
        try {
            
            System.out.println("Removing..." + l.remove(1) );  
            System.out.println("Removing..." + l.remove(5) ); 

        } catch (StaticListsException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
