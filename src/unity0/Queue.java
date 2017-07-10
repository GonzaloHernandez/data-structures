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
public class Queue {

    public int MAX = 100;
    
    //----------------------------------------------------

    private int values[];
    private int top;
    
    //----------------------------------------------------

    public Queue() {
        values  = new int[MAX];
        top     = 0;
    }
    
    //----------------------------------------------------

    public void add(int v) throws StaticListsException {
        if (top==MAX) {
            throw new StaticListsException("Stack is full [trying to add " + v +"]");
        }
        values[top] = v;
        top++;
    }
    
    //----------------------------------------------------

    public void print() {
        for (int i=0; i<top; i++) {
            System.out.print(" "+values[i]);
        }
        System.out.println();
    }
    
    //----------------------------------------------------

    public int remove() throws StaticListsException {
        if (top == 0) {
            throw new StaticListsException("There isn't elements [trying to remove first element]");
        } else {
            int v = values[0];
            for (int i=0; i<top-1; i++) {
                values[i] = values[i+1];
            }
            top --;
            return v;
        }
    }
}
