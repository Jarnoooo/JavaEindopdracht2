/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2;

import java.awt.*;
import java.awt.Container;
/**
 *
 * @author Jarno
 */
public abstract class ScreenElement extends ATMElement
{  
//    public Point()
//    public Component ();
    
    
  public ScreenElement(String element, Point p)
   {
       Point point = new Point(p);
       super.ATMElement (element) ;    
   }
   public abstract void setContainer(Container c);
  
    }
