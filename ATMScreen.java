/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2;

import java.awt.*;
/**
 *
 * @author Jarno
 */
public class ATMScreen extends java.awt.Container {
        
    
    ATMScreen(){
        super.setLayout(null);
        
    }
    public void add(ScreenElement s){
     s.setContainer(this);   
    }
}
