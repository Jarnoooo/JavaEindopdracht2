/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2;
 
/**
 *
 * @author Jarno
 */
public abstract class HardwareElement extends ATMElement {
    boolean power = false;
    
    public void HardwareElement(String name){
        super.ATMElement(name);
    }
   public void powerOn(){
        power = true;
    }
   public void powerOff(){
       power = false;
   }
}
