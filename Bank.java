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
    
    Client a = new Client("ja", "0123", 70);
    Client b = new Client("nee", "0000", 0);
    Client c = new Client("joee", "1111", 7678);
   
    accounts.put("NL555", a);
    accounts.put("NL1234", b);
    accounts.put("NL453", c);
    
    }
    public Client get(String rknmr)
    {
        return accounts.get(rknmr);
    }
    
    public void foo(){
        this.get("NL555").checkPin("1234");
    }
      
    public boolean bestaat(String o){
               boolean x = false;
               x=  accounts.containsKey(o);
               return x;
            }
}

   

