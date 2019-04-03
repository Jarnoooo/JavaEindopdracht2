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
        ATM a = new ATM(b);     
    }
}
