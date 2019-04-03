/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Jarno
 */
public class ATM {

    private ATMScreen as;
    private Bank bank;
    private CardReader card;

    public ATM(Bank b) {

        bank = b;
        as = new ATMScreen();
        card = new CardReader("Cardreader");
        Frame f = new Frame("My ATM");
        f.setBounds(200, 200, 400, 300);
        f.setBackground(Color.RED);
        f.addWindowListener(new MyWindowAdapter(f));
        f.add(as);
        f.setVisible(true);
       
        while(true){
            doTransaction();
        }
    }
    

    private void doTransaction() {
        DisplayText dt = new DisplayText("yes", new Point(0,0));
        as.add(dt);
        
        String cardNumber = new String();
        
        while(!bank.bestaat(cardNumber)){
            dt.giveOutput("Voer karat in");
            cardNumber = card.getInput();
            if(bank.bestaat(cardNumber)){
                break;
            }
            dt.giveOutput("Kan m niet vinden");
            try{
                Thread.sleep(2500);
            }
            catch(Exception e){
                
            }
        }

        dt.giveOutput("done");
    }
}
