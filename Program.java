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
        Container container = new Container();
        Bank a = new Bank();
        
        ScreenButton d = new ScreenButton("insert your card", 50,50);
        DisplayText e = new DisplayText("insert you", 42,43);
        
        d.setContainer(container);
        ATM c = new ATM(a);        
    }
}
