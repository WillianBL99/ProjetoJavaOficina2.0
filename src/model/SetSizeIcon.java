package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

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
             System.out.println("setIcon-setIconJButton. Erro ao executar");
         }        
    }
    
    
    public void setIconJLabel(JLabel jLabel, String img, int x, int y){  
                
        try {
           ImageIcon imageIcon = new ImageIcon(getClass().getResource(img));    
           Image image = imageIcon.getImage().getScaledInstance(x, y, 
                   Image.SCALE_DEFAULT);
           jLabel.setIcon(new ImageIcon(image));
           
        } catch (Exception e) {
            System.out.println("setIcon-setIconJLabel. Erro ao executar");
        }        
   }
    
    
    public void redimencionaImagem(JLabel jLabel, String img){  
        int x = jLabel.getWidth();
        int y = jLabel.getHeight();
        try {
           ImageIcon imageIcon = new ImageIcon(getClass().getResource(img));    
           Image image = imageIcon.getImage().getScaledInstance(x, y, 
                   Image.SCALE_DEFAULT);
           jLabel.setIcon(new ImageIcon(image));
           
        } catch (Exception e) {
            System.out.println("setIcon-redimencionaImagem. Erro ao executar");
        }        
   }
    
}
