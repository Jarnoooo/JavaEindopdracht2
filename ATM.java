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
public class ATM {
    
    private ATMScreen as;
    private Bank bank;
    
    public ATM(Bank b){
        bank = b;
        as = new ATMScreen();
        Frame f = new Frame("My ATM");
        f.setBounds(200, 200, 400, 300);
        f.setBackground(Color.BLUE);
        f.addWindowListener(new MyWindowAdapter(f));
        f.add(as);
        f.setVisible(true);
    }
   
   
}
