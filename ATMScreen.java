    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2;

import java.awt.*;
/**
 *
 * @author Jarno
 */
public class ATMScreen extends java.awt.Container
{
        
    
    ATMScreen()
    {
        super.setLayout(null);
        
    }
    public void add(ScreenElement s)
    {
     s.setContainer(this);   
    }
    public void clear()
    {
        removeAll();
    }
    public void paint(Graphics g) 
    {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillRoundRect(347, 230, 35, 35, 10, 10);
        g.fillRect(377, 260, 5, 5);
        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif", Font.BOLD, 20));
        g.drawString("HR", 350, 250);
        g.setFont(new Font("SansSerif", Font.PLAIN, 12));
        g.drawString("bank", 351, 260);
    }   
}
