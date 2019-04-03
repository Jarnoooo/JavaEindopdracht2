    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2;

import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Jarno
 */
public class MyWindowAdapter extends WindowAdapter {
    Frame f;
    public  MyWindowAdapter(Frame f){
        this.f = f;
    }
    public void windowClosing (WindowEvent e){
        f.dispose();
        
        System.exit(0);
    }
}
