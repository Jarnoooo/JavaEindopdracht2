/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
/**
 *
 * @author Jarno
 */
public class ScreenButton extends ScreenElement implements InputDevice, ActionListener 
{
    private boolean inputAvailable = false;
    
    Button button;
    Container d = new Container();
    
    public ScreenButton(String name, Point p)
    {
        super(name, p);
        
    
        button = new Button(name);
        button.setBounds(p.x, p.y,10 + 15 *name.length(), 25);
        button.addActionListener(this);
        
    }
    public String getInput()
    {
        if (inputAvailable == true)
        {
            inputAvailable = false;
//            System.out.println("era");
            return button.getLabel();
        }
        else
        {
            return null;
        }
    }
    public void setContainer(Container c)
    {
        c.add(button);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        inputAvailable = true;
    }
}