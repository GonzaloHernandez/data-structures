/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unity3;

import java.awt.Graphics;
import java.util.Vector;
import javax.swing.JFrame;

/**
 *
 * @author chalo
 */
public class Tree {

    //----------------------------------------------------

    class Node {

        protected int value;
        protected Node left, right;

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
        } else {
            Node aux = root, p = null;
            while (aux != null) {
                p = aux;
                if (v < aux.value) {
                    aux = aux.left;
                } else if (v > aux.value) {
                    aux = aux.right;
                } else {
                    return;
                }
            }
            if (v < p.value) {
                p.left = n;
            } else {
                p.right = n;
            }
        }
    }

    //----------------------------------------------------

    public boolean exists(int v) {
        Node aux = root;
        while (aux != null) {
            if (v < aux.value) {
                aux = aux.left;
            } else if (v > aux.value) {
                aux = aux.right;
            } else {
                return true;
            }
        }
        return false;
    }

    //----------------------------------------------------

    public void printPath(int v) {
        Vector path = new Vector();
        Node aux = root;
        while (aux != null) {
            path.add(aux.value);
            if (v < aux.value) {
                aux = aux.left;
            } else if (v > aux.value) {
                aux = aux.right;
            } else {
                System.out.println(path);
                return;
            }
        }
        System.out.println("Do not exist.");
    }

    //----------------------------------------------------

    public void print() {
        print(root);
        System.out.println();
    }

    //----------------------------------------------------

    private void print(Node r) {
        if (r == null) {
            return;
        }
        print(r.left);
        System.out.print(" " + r.value);
        print(r.right);
    }

    //----------------------------------------------------

    public void printLeafs() {
        printLeafs(root);
        System.out.println();
    }

    //----------------------------------------------------

    private void printLeafs(Node r) {
        if (r == null) {
            return;
        }
        if (r.left == null && r.right == null) {
            System.out.print(" " + r.value);
        } else {
            printLeafs(r.left);
            printLeafs(r.right);
        }
    }

    //----------------------------------------------------

    public int count() {
        return count(root);
    }

    //----------------------------------------------------

    private int count(Node r) {
        if (r == null) {
            return 0;
        }
        return count(r.left) + count(r.right) + 1;
    }

    //----------------------------------------------------

    public int sum() {
        return sum(root);
    }

    //----------------------------------------------------

    private int sum(Node r) {
        if (r == null) {
            return 0;
        }
        return sum(r.left) + sum(r.right) + r.value;
    }

    //----------------------------------------------------

    private Node copy() {
        return copy(root);
    }

    //----------------------------------------------------

    private Node copy(Node r) {
        if (r == null) {
            return null;
        }
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
                draw(r, 20, 50, g);
            }
        };
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    //----------------------------------------------------

    class Info {

        int xRoot, xFinal;
    }

    //----------------------------------------------------

    private Info draw(Node r, int x, int y, Graphics g) {
        Info rootInfo = new Info();
        rootInfo.xFinal = x;
        if (r == null) {
            return rootInfo;
        }

        Info leftInfo, rightInfo;

        leftInfo = draw(r.left, x, y + 50, g);
        x = leftInfo.xFinal;

        g.drawOval(x, y, 30, 30);
        g.drawString("" + r.value, x + 10, y + 20);
        rootInfo.xRoot = x;

        rightInfo = draw(r.right, x + 30, y + 50, g);
        rootInfo.xFinal = rightInfo.xFinal;

        if (r.left != null) {
            g.drawLine(rootInfo.xRoot + 5, y + 25, leftInfo.xRoot + 15, y + 50);
        }
        if (r.right != null) {
            g.drawLine(rootInfo.xRoot + 25, y + 25, rightInfo.xRoot + 15, y + 50);
        }

        return rootInfo;
    }

    //----------------------------------------------------

    public void printLevel(int l) {
        printLevel(l, root, 0);
        System.out.println();
    }

    //----------------------------------------------------

    private void printLevel(int l, Node r, int c) {
        if (r == null) {
            return;
        }
        if (l == c) {
            System.out.print(" " + r.value);
        } else {
            printLevel(l, r.left, c + 1);
            printLevel(l, r.right, c + 1);
        }
    }

    //----------------------------------------------------

    public int height() {
        return height(root);
    }

    //----------------------------------------------------

    private int height(Node r) {
        if (r == null) {
            return 0;
        }
        int leftHeight = height(r.left);
        int rightHeight = height(r.right);
        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }

    //----------------------------------------------------

    public int nearestLeaf() {
        return nearestLeaf(root, 0).value;
    }

    //----------------------------------------------------

    class NearestLeafInfo {

        int level, value;
    }

    //----------------------------------------------------

    private NearestLeafInfo nearestLeaf(Node r, int c) {
        NearestLeafInfo rootInfo = new NearestLeafInfo();
        rootInfo.level = c;
        rootInfo.value = -1;
        if (r == null) {
            return rootInfo;
        }
        if (r.left == null && r.right == null) {
            rootInfo.level = c;
            rootInfo.value = r.value;
            return rootInfo;
        }
        NearestLeafInfo leftInfo = nearestLeaf(r.left, c + 1);
        NearestLeafInfo rightInfo = nearestLeaf(r.right, c + 1);
        if (r.left == null) {
            return rightInfo;
        } else if (r.right == null) {
            return leftInfo;
        } else if (leftInfo.level < rightInfo.level) {
            return leftInfo;
        } else {
            return rightInfo;
        }
    }

    //----------------------------------------------------

    public boolean isComplete() {
        return isComplete(root);
    }

    //----------------------------------------------------

    private boolean isComplete(Node r) {
        if (r == null) {
            return true;
        }
        if (r.left == null ^ r.right == null) {
            return false;
        }
        return isComplete(r.left) && isComplete(r.right);
    }

    //----------------------------------------------------

    public void printOddValues() {
        printOddValues(root);
        System.out.println();
    }

    //----------------------------------------------------

    private void printOddValues(Node r) {
        if (r == null) {
            return;
        }
        printOddValues(r.left);
        if (r.value % 2 == 0) {
            System.out.print(" " + r.value);
        }
        printOddValues(r.right);
    }

    //----------------------------------------------------

    public void prune() {
        prune(root);
    }

    //----------------------------------------------------

    private void prune(Node r) {
        if (r == null) {
            return;
        }
        if (r.left == null && r.right != null) {
            r.right = null;
        } else if (r.left != null && r.right == null) {
            r.left = null;
        } else {
            prune(r.left);
            prune(r.right);
        }
    }

    //----------------------------------------------------

    public void remove(int v) {
        Node aux = root, p = null;
        while (aux != null) {
            
            if (v < aux.value) {
                p = aux;
                aux = aux.left;
            }
            else if (v > aux.value) {
                p = aux;
                aux = aux.right;
            }
            else {
                if (aux == root) {
                    if (root.left == null) {
                        root = aux.right;
                    }
                    else {
                        root = aux.left;
                        Node q = root;
                        while (q.right != null) {
                            q = q.right;
                        }
                        q.right = aux.right;
                    }
                }
                else {
                    if (aux.left == null) {
                        if (aux.value < p.value) {
                            p.left = aux.right;
                        }
                        else {
                            p.right = aux.right;
                        }
                    }
                    else {
                        if (aux.value < p.value) {
                            p.left = aux.left;
                        }
                        else {
                            p.right = aux.left;
                        }                            
                        Node q = aux.left;
                        while (q.right != null) {
                            q = q.right;
                        }
                        q.right = aux.right;
                    }
                }
                return;
            }
        }
    }
            
    //----------------------------------------------------

    private void leftRotation(Node r, Node handle) {
        if (handle == null) {
            root = r.right;
            r.right = root.left;
            root.left = r;
        } else {
            if (r == handle.left) {
                handle.left = r.right;
                r.right = handle.left.left;
                handle.left.left = r;
            } else {
                handle.right = r.right;
                r.right = handle.right.left;
                handle.right.left = r;
            }
        }
    }

    //----------------------------------------------------

    private void rightRotation(Node r, Node handle) {
        if (handle == null) { 
            root = r.left;
            r.left = root.right;
            root.right = r;
        } else {
            if (r == handle.left) {
                handle.left = r.left;
                r.left = handle.left.right;
                handle.left.right = r;
            } else {
                handle.right = r.left;
                r.left = handle.right.right;
                handle.right.right = r;
            }
        }
    }

    //----------------------------------------------------

    public void balance() {
        balance(root, null);
    }
    
    //----------------------------------------------------

    private void balance(Node r, Node handle) {
        if (r == null) {
            return;
        }
        balance(r.left, r);
        balance(r.right, r);
        int ef = equilibriumFactor(r);
        if (ef < -1 || ef > 1) {
            if (ef > 0) {
                if (equilibriumFactor(r.left) < 0) {
                    leftRotation(r.left, r);
                }
                rightRotation(r, handle);
            } else {
                if (equilibriumFactor(r.right) > 0) {
                    rightRotation(r.right, r);
                }
                leftRotation(r, handle);
            }
        }
    }

    //----------------------------------------------------

    private int equilibriumFactor(Node r) {
        if (r == null) {
            return 0;
        }
        return height(r.left) - height(r.right);
    }
}
