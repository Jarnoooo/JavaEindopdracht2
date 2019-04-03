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
public class ReceiptPrinter extends HardwareElement implements OutputDevice
{
    public  ReceiptPrinter(String name)
    {  
        super(name);
    }
    public void giveOutput(String out)
    {
       System.out.println(out);
    }
}
