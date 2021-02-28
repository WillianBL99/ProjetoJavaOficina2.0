/**
 * 
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

/**
 * @author pWili
 *
 */
public class Relogio extends Thread{
    

    private JLabel jLabelHoras;
    private Date date;
    
    public Relogio( JLabel jLabelHoras ){//aceita um TextField como parametro para mostrar no Frame
        
    	this.jLabelHoras = jLabelHoras;
    }
    
    public void run(){
        
        while(true){
            date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("HH:mm");
            String horas = dateFormat.format(date);
            
            jLabelHoras.setText(horas);//joga para o TextField
            System.out.println(horas);

    		System.out.println("treads = " + Thread.activeCount());
    		
            try{
                
                sleep(1000);
                
            }catch( InterruptedException e ){}
            
        }
        
    }
    
 
}