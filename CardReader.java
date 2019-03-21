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
public class CardReader extends HardwareElement implements InputDevice 
{
    BufferedReader BR;
    
    public CardReader(String name)
    {
        super.HardwareElement(name);
        InputStreamReader CardReader = new InputStreamReader(System.in);
        BufferedReader BR = new BufferedReader(CardReader);
    }
    public String getInput()
    {
        System.out.println("to simulate inserting card, enter card number");
        try 
        {
            String userInput = BR.readLine();
            return userInput;
        } catch (IOException ex) 
        {
            Logger.getLogger(CardReader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
