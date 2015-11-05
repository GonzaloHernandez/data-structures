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
public class SimpleNode {
    protected int value;
    protected SimpleNode next;

    public SimpleNode(int v) {
        value = v;
        next = null;
    }
}
