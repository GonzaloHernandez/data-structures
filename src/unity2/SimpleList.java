/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unity2;

/**
 *
 * @author chalo
 */
public class SimpleList {
    private SimpleNode head;
    
    public SimpleList() {
        head = null;
    }
    
    public void add(int v) {
        SimpleNode n = new SimpleNode(v);
        if (head == null) {
            head = n;
        }
        else {
            SimpleNode aux = head;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = n;
        }
    }
    
    public void print() {
        SimpleNode aux = head;
        while (aux != null) {
            System.out.print(" "+aux.value);
            aux = aux.next;
        }
        System.out.println();
    }
}
