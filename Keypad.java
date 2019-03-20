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
public class Keypad extends HardwareElement implements InputDevice {
    private String Keypad;
    BufferedReader BR ;
    public void Keyad(String name){
        
        super.HardwareElement(name);
        InputStreamReader Keypad = new InputStreamReader(System.in);
        BufferedReader BR = new BufferedReader(Keypad);
    }
    public String getInput(){
    
        try {
            if(BR.ready()){
                String userInput = BR.readLine();   
                Keypad = userInput;
            }
        } catch (IOException ex) {
            Logger.getLogger(Keypad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Keypad;
        }   
}

