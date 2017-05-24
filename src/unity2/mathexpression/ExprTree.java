/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unity2.mathexpression;

import java.awt.Graphics;
import javax.swing.JFrame;


class ExprNode {

    public static String ops = "+-*/^";

    protected int       value;
    protected boolean   operator;
    protected ExprNode  left,right;

    public ExprNode(int value, boolean operator) {
        this.value      = value;
        this.operator   = operator;
        left = right    = null;
    }

    public boolean isOperator() {
        return operator;
    }

    public boolean isNumber() {
        return !operator;
    }

    public void draw(int x,int y,Graphics g) {
        g.drawOval(x, y, 30, 30);
        if (isOperator()) {
            g.drawString(""+ops.charAt(value), x+10, y+20);
        } else {
            g.drawString(""+value, x+10, y+20);
        }
    }
}

/**
 *
 * @author chalo
 */
public class ExprTree {
    
    //----------------------------------------------------

    ExprNode root = null;

    //----------------------------------------------------

    public void add(ExprNode n) {
        if (root == null) {
            root = n;
        } else {
            if (n.isOperator() && root.isNumber()) {
                n.left = root;
                root = n;
            } else if (n.isNumber()) {
                ExprNode aux = root;
                while (aux.right != null) {
                    aux = aux.right;
                }
                aux.right = n;
            } else if (n.isOperator()) {
                if (n.value < root.value) {
                    n.left = root;
                    root = n;
                } else {
                    ExprNode aux = root;
                    while (aux.right != null && aux.right.isOperator() && aux.right.value < n.value) {
                        aux = aux.right;
                    }
                    n.left = aux.right;
                    aux.right = n;
                }
            }
        }
    }

    //----------------------------------------------------

    public void draw() {
        JFrame frame = new JFrame() {
            public void paint(Graphics g) {
                draw(root,20,40,g);
            }
        };
        frame.setSize(600,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    //----------------------------------------------------

    class Info {
        int xRoot, xFinal;
        public Info(int xRoot, int xFinal) {
            this.xRoot  = xRoot;
            this.xFinal = xFinal;
        }
    }
    
    //----------------------------------------------------

    private Info draw(ExprNode r, int x,int y, Graphics g) {
        if (r == null) return new Info(x,x);
        
        Info leftInfo = draw(r.left, x, y+40, g);
        x = leftInfo.xFinal;
        
        r.draw(x, y, g);
        
        Info rightInfo = draw(r.right, x+30, y+40, g);
        
        if (r.left != null) {
            g.drawLine(x+5, y+25, leftInfo.xRoot+25, y+45);
        }
        if (r.right != null) {
            g.drawLine(x+25, y+25, rightInfo.xRoot+5, y+45);
        }
        
        return new Info(x,rightInfo.xFinal);
    }
    
    //----------------------------------------------------

    public double evaluate() {
        return evaluate(root);
    }
    
    //----------------------------------------------------

    private double evaluate(ExprNode r) {
        if (r.isNumber()) {
            return r.value;
        }
        switch(r.value) {
            case 0: return evaluate(r.left) + evaluate(r.right);
            case 1: return evaluate(r.left) - evaluate(r.right);
            case 2: return evaluate(r.left) * evaluate(r.right);
            case 3: return evaluate(r.left) / evaluate(r.right);
            case 4: return Math.pow(evaluate(r.left),evaluate(r.right));
        }
        return 0;
    }

    //----------------------------------------------------

    public static void main(String[] args) {
        ExprTree t = new ExprTree();
        
        String expr = "4^2*8+5-3/5^2";
        
        for (int i=0; i<expr.length(); i++) {
            char sub = expr.charAt(i);
            if (sub >= '0' && sub <= '9') {
                t.add(new ExprNode( sub-48  , false));
            } else {
                t.add(new ExprNode( ExprNode.ops.indexOf(expr.charAt(i)) , true));
            }
        }
        
        t.draw();
        
        System.out.println(""+t.evaluate());
    }
}
