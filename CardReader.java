/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jarno
 */
public class CardReader extends HardwareElement implements InputDevice {

    BufferedReader BR;

    public CardReader(String name) {
        super(name);
        InputStreamReader CardReader = new InputStreamReader(System.in);
        BR = new BufferedReader(CardReader);
    }

    public String getInput() {
        System.out.println("Insert Card");
       
        // MAGIC NUMBERS COMMENTEN
        try{
              
            String x = BR.readLine();
            
            return x;
         
            } 
        catch(Exception e){
//            return null;    
            return null;
        }
       
    }    
}

