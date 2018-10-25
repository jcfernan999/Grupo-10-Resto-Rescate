/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Component;
import java.awt.Container;

/**
 *
 * @author Juan
 */
public class SwingUtils {
    public static void setEnableContainer(Container c, boolean band) {
         
 Component[] components = c.getComponents();
 c.setEnabled(band);
 for(int i = 0; i < components.length; i++){            
  components[i].setEnabled(band);
   
  if(components[i] instanceof Container){
   setEnableContainer((Container)components[i], band);
  }
   
 }        
} 
}
