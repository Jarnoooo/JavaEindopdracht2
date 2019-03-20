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
public class ScreenButton extends ScreenElement implements InputDevice, ActionListener {
    private boolean inputAvailable = false;
    private String buttonName;
    
    Button button ;
    Container d = new Container();
    
    public ScreenButton(String name, int x, int y){
        super.ScreenElement(name, x, y);
        
        buttonName = name;
        button = new Button(name);
        button.setBounds(pos.x, pos.y,10 + 15 *name.length(), 25);
        button.addActionListener(this);
        
    }
    public String getInput(){
        
        if (inputAvailable = true){
            inputAvailable = false;
            return name;
        }else{
            return null;
        }
    }
    public void setContainer(Container c){
        d.add(button);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        inputAvailable = true;
        getInput();
    }
}