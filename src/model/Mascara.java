/**
 * 
 */
package model;

import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 * @author Perseu
 *
 */
public class  Mascara {

	public static MaskFormatter mascaraCPF() {
	
		
		try {
			MaskFormatter mask = new MaskFormatter("###.###.###-##");
			return mask;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static MaskFormatter mascaraPlaca() {
		
		
		try {
			MaskFormatter mask = new MaskFormatter("UUU-#A##/UU");
			//mask.setValidCharacters("ABCDEFGHIJ0123456789"); // serve para permitir apenas esses caracteres
			//mask.setValidCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"); // inserido para testes, apagar depois
		
			return mask;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		
	
	public static MaskFormatter mascaraTelefone() {
		
	
		try {
			MaskFormatter mask = new MaskFormatter("(##) #####-####");
		
			return mask;
				
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static MaskFormatter mascaraData() {
		
		//JFormattedTextField data;
		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			//data = new JFormattedTextField(mask);
			return mask;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static MaskFormatter mascaraChassi() {
		
		try {
			MaskFormatter mask = new MaskFormatter("A AA AAAAAA A AAAAAAA");
			mask.setValidCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");

			return mask;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static MaskFormatter mascaraQuilometragem() {
		

		try {
			MaskFormatter mask = new MaskFormatter("##########");
		
			return mask;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static void setMascara(JFormattedTextField campo, MaskFormatter mask) {
		
		campo.setFormatterFactory( new DefaultFormatterFactory(mask));
		
	}
	
	
}
