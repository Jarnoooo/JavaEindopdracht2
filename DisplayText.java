/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2;

import java.awt.Container;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
/**
 *
 * @author Jarno
 */
public class DisplayText extends ScreenElement implements OutputDevice {
    
    private Label label;
    
    public DisplayText (String element, int x, int y){
        
        super.ScreenElement(element, x, y);
        
        Label label = new Label();
        label.setForeground(Color.white);
        label.setFont(new Font("SansSerif", Font.BOLD,30));
        label.setBounds(pos.x, pos.y, 400,35);
  
    
    }
   public void giveOutput(String out){
       label.setText(out);
//       return null ;    
   }
   public void setContainer(Container c){
              
        c.add(label);
       
        }
}
