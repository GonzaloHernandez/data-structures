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
public class Test {
    
    static class Student extends Item {
        String  name;
        long    code;
        
        public Student(String n,long c) {
            name = n;
            code = c;
        }
        
        public String toString() {
            return name+" "+code+"\n";
        }
    }
    
    public static void main(String args[]) {
        Stack s = new Stack();
        s.add(new Student("Gonzalo",2021192));
        s.add(new Student("Jose",2026192));
        s.print();
    }
}
