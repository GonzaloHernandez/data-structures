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
public class StaticListsException extends Exception {

    private String msg;

    //----------------------------------------------------

    public StaticListsException(String msg) {
        this.msg = msg;
    }
    
    //----------------------------------------------------

    public String getMessage() {
        return msg;
    }
}
