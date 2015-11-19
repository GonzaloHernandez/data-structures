/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unity1;



/**
 *
 * @author chalo
 */
public class DoubleList {
    //----------------------------------------------------
    class Node {
        protected int value;
        protected Node next,back;
        
        public Node(int v) {
            value = v;
            next = null;
            back = null;
        }
    }    
    //----------------------------------------------------
    private Node head;
    //----------------------------------------------------
    public DoubleList() {
        head = null;
    }
    //----------------------------------------------------
    public void add(int v) {
        Node n = new Node(v);
        if (head == null) {
            head = n;
        }
        else {
            Node aux = head;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = n;
            n.back = aux;
        }
    }
    //----------------------------------------------------
    public void print() {
        Node aux = head;
        while (aux != null) {
            System.out.print(" "+aux.value);
            aux = aux.next;
        }
        System.out.println();
    }
}
