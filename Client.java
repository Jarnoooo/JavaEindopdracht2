/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Jarno
 */
public class Client {

    private String name;
    private String pin;
    private int balance;
    private boolean nummer = false;
    
    public Client (String n, String p, int b){
        name = n;
        pin = p;
        balance = b;
        
    }
    
    public String getName(){
        
        return name;
    }
    
    void checkPin(String p){
        
        if ( name.equals(p) ){
            nummer = true;
            System.out.println("Pin geaccepteerd");
        }
        else
        {
          nummer = false;
          System.out.println("vekeerde pin");
          return ;
        }
    }
    public void getBalance(String b){
        checkPin(b);
        if (nummer == true){
            System.out.println("Uw balans op de bank = "+balance);
            
        }
        else{
            System.out.println(Interger.MIN_VALUE);
        }
        
    }
    
    private void deposit(int gestort){
        
        balance = balance + gestort;
              
    }
    private void withdraw(int opnemen, String pin){
        checkPin(pin);
        
        int temp = balance - opnemen;
        
        if ((temp > 0)&& nummer == true){
            balance = temp;
            
        }
        else{
           balance = temp + opnemen; 
        }
        
    }

    
}
