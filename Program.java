package java2;
import java.awt.*;
/**
 *
 * @author Jarno
 */
public class Program 
{
    public static void main(String[] args) 
    {
        Bank b = new Bank();
        try{
        ATM a = new ATM(b);     
    }catch(Exception o){
        System.out.println("interrupted exception");
    }
}
}
