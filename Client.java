package java2;

import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Jarno
 */
public class Client
{

    private String name;
    private String pin;
    
    private int balance;
    private int teller;
    
    private boolean nummer = false;
    private boolean transactie = false;
    
    public Client (String n, String p, int b)
    {
        name = n;
        pin = p;
        balance = b;
               
    }
    
    public String getName()
    {   
        return name;
    }
    
    public boolean checkPin(String p)
    {
        
            if ( pin.equals(p) ){
                nummer = true;
                System.out.println("Pin geaccepteerd");
                teller = 0;
                return true;
                }
                
              nummer = false;
              System.out.println("vekeerde pin");
              return false;
            } 
          
        
        
    
    public String getBalance(String b)
    {
        checkPin(b);
        String result ;
        if (nummer == true)
        {
            System.out.println("Uw balans op de bank = "+balance);
            result = Integer.toString(balance);
            return result;
        }
        else
        {
            System.out.println(Integer.MIN_VALUE);
            result =  Integer.toString(Integer.MIN_VALUE);

            return result;
        }
    }
    
    public void deposit(int gestort)
    {
        balance = balance + gestort;
              
    }
    public boolean withdraw(int opnemen, String pin)
    {
        checkPin(pin);
            if (nummer == true){
        
            int temp = balance - opnemen; // CHECKS if the transaction is possible
            // haalt geld van account af
            if ((temp > 0)&& nummer == true){
                balance = temp;
                transactie = true;
//                return true;
            }
            else{
               balance = temp + opnemen; 
               transactie = false;
//               return false;
            }
        }
            return transactie;
    }
}
