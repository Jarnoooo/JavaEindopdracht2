/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
/**
 *
 * @author Jarno
 */
public class DisplayText extends ScreenElement implements OutputDevice
{
    Label label;
    
    public DisplayText (String element,Point p)
    {       
        super(element,p);
        //
        label = new Label();
        label.setForeground(Color.white);
        label.setFont(new Font("SansSerif", Font.BOLD,30));
        label.setBounds(p.x, p.y, 400,35);
    }
   public void giveOutput(String out)
   {
       label.setText(out);
   }
   public void setContainer(Container c)
    {
        c.add(label);
    }
}
