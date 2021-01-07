package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Dimension;
import java.awt.Frame;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author willian Lago
 */
public class SetSizeIcon {
  
    
    public void setIconJButton(JButton jButton, String img, int x, int y){  
      
        
         try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(img));    
            Image image = imageIcon.getImage().getScaledInstance(x, y, 
                    Image.SCALE_DEFAULT);
            jButton.setIcon(new ImageIcon(image));
            
         } catch (Exception e) {
             System.out.println("setIconJBUTTON.Erro ao executar");
         }        
    }
    
    
    public void setIconJLabel(JLabel jLabel, String img, int x, int y){  
                
        try {
           ImageIcon imageIcon = new ImageIcon(getClass().getResource(img));    
           Image image = imageIcon.getImage().getScaledInstance(x, y, 
                   Image.SCALE_DEFAULT);
           jLabel.setIcon(new ImageIcon(image));
           
        } catch (Exception e) {
            System.out.println("setIconJLabel.Erro ao executar");
        }        
   }
    
    
}
