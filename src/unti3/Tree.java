/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unti3;

import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author chalo
 */
public class Tree {
    //----------------------------------------------------
    class Node {
        protected int value;
        protected Node left,right;
        
        public Node(int v) {
            value = v;
            left = null;
            right = null;
        }
    }    
    //----------------------------------------------------
    private Node root;
    //----------------------------------------------------
    public Tree() {
        root = null;
    }
    //----------------------------------------------------
    public void add(int v) {
        Node n = new Node(v);
        if (root == null) {
            root = n;
        }
        else {
            Node aux=root,p=null;
            while (aux != null) {
                p = aux;
                if (v < aux.value) {
                    aux = aux.left;
                }
                else if (v > aux.value) {
                    aux = aux.right;
                }
                else {
                    return;
                }
            }
            if (v < p.value) {
                p.left = n;
            }
            else {
                p.right = n;
            }
        }
    }
    //----------------------------------------------------
    public void print() {
        print(root);
        System.out.println();
    }
    //----------------------------------------------------
    private void print(Node r) {
        if (r == null) return;
        print(r.left);
        System.out.print(" "+r.value);
        print(r.right);
    }
    //----------------------------------------------------
    public int count() {
        return count(root);
    }
    //----------------------------------------------------
    private int count(Node r) {
        if (r == null) return 0;
        return count(r.left) + count(r.right) + 1;
    }
    //----------------------------------------------------
    private Node copy() {
        return copy(root);
    }
    //----------------------------------------------------
    private Node copy(Node r) {
        if (r == null) return null;
        Node n = new Node(r.value);
        n.left = copy(r.left);
        n.right = copy(r.right);
        return n;
    }
    //----------------------------------------------------
    public void draw(String title) {
        JFrame frame = new JFrame(title) {
            Node r = copy(root);
            public void paint(Graphics g) {
                draw(r,20,50,g);
            }
        };
        frame.setSize(500,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    //----------------------------------------------------
    class Info { int xr,xf; }
    //----------------------------------------------------
    private Info draw(Node r,int x,int y,Graphics g) {
        Info rootInfo = new Info();
        rootInfo.xf = x;
        if (r == null) return rootInfo;

        Info leftInfo,rightInfo;
        
        leftInfo = draw(r.left, x, y+50, g);
        x = leftInfo.xf;
        
        g.drawOval(x, y, 30, 30);
        g.drawString(""+r.value, x+10, y+20);
        rootInfo.xr = x;

        rightInfo = draw(r.right, x+30, y+50, g);
        rootInfo.xf = rightInfo.xf;
        
        if (r.left  != null) g.drawLine(rootInfo.xr+ 5,y+25,leftInfo.xr+15,y+50);
	if (r.right != null) g.drawLine(rootInfo.xr+25,y+25,rightInfo.xr+15,y+50);

        return rootInfo;
    }
}
