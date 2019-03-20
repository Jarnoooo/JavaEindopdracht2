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
    private int teller;
    
    private boolean nummer = false;
    private boolean transactie = false;
    
    

    
    public Client (String n, String p, int b){
        name = n;
        pin = p;
        balance = b;
               
    }
    
    public String getName(){
        
        return name;
    }
    
    void checkPin(String p){
        
        while (teller < 4){
            if ( name.equals(p) ){
                nummer = true;
                System.out.println("Pin geaccepteerd");
                teller = 0;
            }
            else
            {
              nummer = false;
              System.out.println("vekeerde pin");
              
            }
        }
        System.out.println("Te vaak verkeerde pin");
        return ;
    }
    public void getBalance(String b){
        checkPin(b);
        if (nummer == true){
            System.out.println("Uw balans op de bank = "+balance);
            
        }
        else{
            System.out.println(Integer.MIN_VALUE);
        }
        
    }
    
    private void deposit(int gestort){
        
        balance = balance + gestort;
              
    }
    private void withdraw(int opnemen, String pin){
        checkPin(pin);
            if (nummer == true){
        
            int temp = balance - opnemen; // CHECKS if the transaction is possible

            if ((temp > 0)&& nummer == true){
                balance = temp;
                transactie = true;
            }
            else{
               balance = temp + opnemen; 
               transactie = false;
            }
        }    
    }
}
