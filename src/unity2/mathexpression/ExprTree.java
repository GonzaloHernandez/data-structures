/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unity2.mathexpression;


// operatorvalues: + - * / ^ q

/**
 *
 * @author chalo
 */
public class ExprTree {
    
    //----------------------------------------------------

    class ExprNode {

        protected int       value;
        protected boolean   isOperator;
        protected ExprNode  left,right;
        
        public ExprNode(int value, boolean isOperator) {
            this.value      = value;
            this.isOperator = isOperator;
            left = right    = null;
        }
    }
    
    //----------------------------------------------------

    ExprNode root = null;

    //----------------------------------------------------

    public void add(ExprNode n) {
        if (root == null) {
            root = n;
        } else {
            if (n.isOperator && !root.isOperator) {
                n.left = root;
                root = n;
            } else if (n.isOperator && root.isOperator) {
                
            }
        }
    }
    
}
