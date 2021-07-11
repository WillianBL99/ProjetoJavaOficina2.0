/**
 * 
 */
package model;

import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 * @author Perseu
 *
 */
public class  Mascara {

	public static JFormattedTextField mascaraCPF() {
	
		JFormattedTextField cpf ;
		try {
			cpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			return cpf;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static JFormattedTextField mascaraPlaca() {
		
		JFormattedTextField placa ;
		try {
			MaskFormatter mask = new MaskFormatter("UUU #A## UU");
			//mask.setValidCharacters("ABCDEFGHIJ0123456789"); // serve para permitir apenas esses caracteres
			mask.setValidCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"); // inserido para testes, apagar depois
			placa = new JFormattedTextField(mask);
			return placa;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		
	public static JFormattedTextField mascaraTelefone() {
		
		JFormattedTextField telefone;
		try {
			MaskFormatter mask = new MaskFormatter("(##) #####-####");
			telefone = new JFormattedTextField(mask);
			return telefone;
				
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static JFormattedTextField mascaraData() {
		
		JFormattedTextField data;
		try {
			MaskFormatter mask = new MaskFormatter("  ##/##/####");
			data = new JFormattedTextField(mask);
			return data;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static JFormattedTextField mascaraChassi() {
		
		JFormattedTextField chassi;
		try {
			MaskFormatter mask = new MaskFormatter("A AA AAAAAA A AAAAAAA");
			mask.setValidCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
			chassi = new JFormattedTextField(mask);
			return chassi;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static JFormattedTextField mascaraQuilometragem() {
		
		JFormattedTextField km;
		try {
			MaskFormatter mask = new MaskFormatter("##########");
			km = new JFormattedTextField(mask);
			return km;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static void setMascara(JFormattedTextField mask, JTextField campo) {
		
		campo = mask;
		
	}
	
	
}
