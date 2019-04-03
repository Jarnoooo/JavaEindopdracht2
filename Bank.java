    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jarno
 */
public class Bank
{
    Map<String,Client> accounts = new HashMap<String, Client>();
    
    public Bank()
    {
    
    Client a = new Client("NL5555", "0989", 70);
    Client b = new Client("NL673267", "6787", 0);
    Client c = new Client("NL453234", "4523", 7678);
   
    accounts.put("ja", a);
    accounts.put("joe", b);
    accounts.put("Neee", c);
    
    }
    public Client get(String rknmr)
    {
        
        if (accounts.containsKey(rknmr))
        {       
            System.out.println(accounts.get(rknmr));
            return accounts.get(rknmr);
        }
        else
        {
            System.out.println("kan account niet vinden");
            return null;
        }
        
    }
    // method t
            public boolean bestaat(String o){
               boolean x = false;
               x=  accounts.containsKey(o);
               return x;
            }
}

   

