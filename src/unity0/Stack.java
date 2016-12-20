/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unity0;

class Item {
    public String toString() {
        return "";
    }
}

/**
 *
 * @author chalo
 */
public class Stack {
    
    private Item info[];
    private int top;
    
    public Stack() {
        info    = new Item[100];
        top     = 0;
    }
    
    public void add(Item item) {
        if (top==100) {
            System.out.println("The Stack is full");
            return;
        }
        info[top] = item;
        top++;
    }
    
    public void print() {
        for (int i=0; i<top; i++) {
            System.out.print(info[i]);
        }
        System.out.println();
    }
    
    public void remove() {
        if (top > 0) {
            top--;
        }
    }
}
