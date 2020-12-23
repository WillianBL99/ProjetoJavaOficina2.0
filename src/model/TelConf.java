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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author willian Lago
 */
public class TelConf {
    // pega a resolu��o do sistema
    /*Toolkit resolucao = Toolkit.getDefaultToolkit(); 
    Dimension setResolucao = resolucao.getScreenSize();
    int width = (int)setResolucao.getWidth();
    int height = (int)setResolucao.getHeight();
    */
    
    
    // rendiriza a imagem do tamanho da label
    public void redimencionaImagem(JLabel jLabel, String img){  
        int wdh = jLabel.getWidth();
        int hgt = jLabel.getHeight();
        
         try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(img));    
            Image image = imageIcon.getImage().getScaledInstance(110, 110, 
                    Image.SCALE_DEFAULT);
            jLabel.setIcon(new ImageIcon(image));
            
         } catch (Exception e) {
             System.out.println("redimencionaImagem.Erro ao executar");
         }        
    }
    
    
    
    
    
    
    
    
    
    
    
    
  /*  // Renderiza a jlabel e o icon na resolu��o da tela do sistema.
    public void imageLabelRend(JLabel funTel, String img){  
        //seta a label de fundo na dimensão da tela
        funTel.setSize(width, height);
        //seta a imagem do tamanho da label de fundo de tela 
         try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(img));    
            Image image = imageIcon.getImage().getScaledInstance(width, height, 
                    Image.SCALE_DEFAULT);
            funTel.setIcon(new ImageIcon(image));
            
         } catch (Exception e) {
             System.out.println("ImageLabelRend Erro");
         }        
    }
    
    // Renderiza a jlabel e o icon na resolução da JFrame.
    public void imageLabelRend(JFrame frame, JLabel funTel, String img){  
        int wdt = frame.getWidth();
        int hgt = frame.getHeight();
        //seta a label de fundo na dimensão da tela
        funTel.setSize(wdt, hgt);
        //seta a imagem do tamanho da label de fundo de tela 
         try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(img));    
            Image image = imageIcon.getImage().getScaledInstance(wdt, hgt, 
                    Image.SCALE_DEFAULT);
            funTel.setIcon(new ImageIcon(image));
            
         } catch (Exception e) {
             System.out.println("ImageLabelRend Erro");
         }        
    }
    
    // Renderiza a jlabel e o icon na resolução da JPanel.
    public void imageLabelRend(JPanel panel, JLabel funTel, String img){  
        int wdt = panel.getWidth();
        int hgt = panel.getHeight();
        //seta a label de fundo na dimensão da tela
        funTel.setSize(wdt, hgt);
        //seta a imagem do tamanho da label de fundo de tela 
         try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(img));
            
            Image image = imageIcon.getImage().getScaledInstance(wdt, hgt, 
                    Image.SCALE_DEFAULT);
            System.out.println("ImageLabelRend"+wdt+ hgt);
            funTel.setIcon(new ImageIcon(image));
            
            
         } catch (Exception e) {
            // System.out.println(jPanel.getWidth());
         }        
    }
    
    
    
    
    
    
    
    
    // Deixa jFrame em tela cheia
    public void fullScree(Frame tela){
    	
        tela.setExtendedState(MAXIMIZED_BOTH);
        
    }    
    
    
    public void iconRender(JFrame jFrame, JLabel jLabel,String imagem) {
    	
    	ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagem));// seta imagem
    	 Image img = imageIcon.getImage().getScaledInstance(jFrame.getWidth(), jFrame.getHeight(), //pega a largura do frame para poder seta a imagem com o mesmo tamanho
                 Image.SCALE_DEFAULT);
    	jLabel.setIcon(new ImageIcon(img)); // set da imagem no label
    	 //System.out.println(jFrame.getWidth()+" , "+jFrame.getHeight());
    	
    }
    
    
    public void iconRender(JLabel jLabel,String imagem) {
    	
    	ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagem)); // adicniona o caminho da imagem 
    	
    	Thread thread = new Thread() {
    		@Override
    		public void run() {
    			try {					
    				
    		    	Image img = imageIcon.getImage().getScaledInstance(jLabel.getWidth(), jLabel.getHeight(), // pega a largura do incone que vai ser a mesma da label
    		                 Image.SCALE_DEFAULT);
    		    	jLabel.setIcon(new ImageIcon(img)); 
    		    	//System.out.println(jLabel.getWidth()+" , "+jLabel.getHeight());
    				
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("erro iconRend");
				}
    		}
    		
    	};thread.start();    	
    	
    }
  
    
    // Seta e renderiza o icon  de uma jlabel na resolução inserida.
    public void iconRender(JLabel label, String image, int width, int height){
    	ImageIcon imageIcon1 = new ImageIcon(getClass().getResource(image));
    	Thread thread = new Thread() {
    		@Override
    		public void run() {
    			try {					
    				
    				Image image1 = imageIcon1.getImage().getScaledInstance(width, height,
    	                    Image.SCALE_DEFAULT);    	            
    				label.setIcon(new ImageIcon(image1)); // Seta o icon na JLabel.
    				
				} catch (Exception e) {
					
					System.out.println("erro iconRend");
				}
    		}
    		
    	};thread.start();     	
                      
    }  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Centraliza uma JPanel no centro da tela, de acordo com a resolução do 
    // sistema e o tamanho do JPanel. (verificar forma de centralizar no JFrame).  
    public void centralizeJPanel(JPanel pane, int wdt, int hgt){
        int x = 0;
        int y = 0;
        // Cálculo para determinar a posição "x" e "y" do JPanel.
        x = (width/2) - (wdt/2);
        y = (height/2) - (hgt/2);
        // Setando a posição do JPanel.
        pane.setBounds(x, y, wdt, hgt);
        // A linha de código abaixo serve de apoio para depuração.
        System.out.println(x+" "+y+" "+wdt+" "+hgt);
    }
    
    // Adápta o JPanel no centro da tela e diminui o tamanho de com o tamanho do
    // JFrame
    // obs: o campo "float prc" é para ser usado quando nescecitar variar a 
    // porcentagem.
    public void centralizeJPanel(JFrame frame, JPanel panel, int width,
            int height/*, float prc){
        float prc = 0.75f;
        int wdt = frame.getWidth();
        int hgt = frame.getHeight();
        int wdt_pct = (int)(width * prc);
        int hgt_pct = (int)(height * prc);
        int x;
        int y;
        //se a resolução da tela for maior que 1920 x 1080
        if(wdt > 1900 || hgt > 1080){
            x = (wdt/2) - (width/2);
            y = (hgt/2) - (height/2);
            // Centraliza o JPanel
            panel.setBounds(x, y, width, height);
            //a linha a baixo serve de auxilio para erros na renderizaçaõ
            System.out.println("width = "+width+" height = "+height);
        // Se a resolução da tela for menor que 1900 x 1080
        }else{
            x = (wdt/2) - (wdt_pct/2);
            y = (hgt/2) - (hgt_pct/2);
            // Centraliza e diminui o painel proporcionalmente a porcentagem
            // inserida no "prc"
            panel.setBounds(x, y, wdt_pct, hgt_pct);
            //a linha a baixo serve de auxilio para erros na renderizaçaõ
            System.out.println("width else = "+(width * prc)+" height = "+(height * prc));
        }
    }
    
    // Centraliza um JPanel no centro de um JFrame
    public void adaptar(JFrame frame, JPanel panel, int width, int height){
        int wdt = frame.getWidth();
        int hgt = frame.getHeight();
        // Cálculo para determinar a posição "x" e "y" do JPanel.
        int x = (wdt/2) - (width/2);
        int y = (hgt/2) - (height/2);
        // Setando a posição do JPanel.
        panel.setBounds(x, y, width, height);
        // A linha de código abaixo serve de apoio para depuração.
        System.out.format("Resolução %s X %s\n",wdt,hgt);
    }
    
    // O método a baixo faz com que a o componete "JPanel" se adapte a resolução
    // do sistema. (em faze de criação).
    public void renderizaJPanel(JPanel pane){
         pane.setBounds(0, 0, width, height);
         //a linha a baixo serve de auxilio para erros na renderizaçaõ
         System.out.println("width = "+width+" height = "+height);
    }
    */
}
