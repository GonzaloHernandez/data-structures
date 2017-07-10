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
public class List {

    public int MAX = 100;
    
    //----------------------------------------------------

    private int values[];
    private int top;
    
    //----------------------------------------------------

    public List() {
        values  = new int[MAX];
        top     = 0;
    }
    
    //----------------------------------------------------

    public void add(int v) throws StaticListsException {
        if (top==MAX) {
            throw new StaticListsException("Stack is full");
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

    public void insert(int v, int p) throws StaticListsException {
        if (p<0 || p>top) {
            throw new StaticListsException("Wrong position [trying to insert " 
                    + v + " in position " + p + "]");
        } else {
            for (int i=top; i>p; i--) {
                values[i] = values[i-1];
            }
            values[p] = v;
            top ++;
        }
    }
    
    //----------------------------------------------------

    public int remove(int p) throws StaticListsException {
        if (p<0 || p>top) {
            throw new StaticListsException("Wrong position [trying to remove position " + p + "]");
        } else {
            int v = values[p];
            for (int i=p; i<top-1; i++) {
                values[i] = values[i+1];
            }
            top --;
            return v;
        }
    }
}
