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
    Point pos ;  
//    public Point()
//    public Component ();
    
    
   void ScreenElement (String element, int xw, int yw )
   {
       Point point = new Point(xw,yw);
       pos = point;
       super.ATMElement (element) ;    
   }
   public abstract void setContainer(Container c);
  
    }
