/**
 * 
 */
package model;

import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
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
			MaskFormatter mask = new MaskFormatter("UUU-#A##");
			//mask.setValidCharacters("ABCDEFGHIJ0123456789"); // serve para permitir apenas esses caracteres
			mask.setValidCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"); // inserido para testes, apagar depois
		
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
			mask.setPlaceholderCharacter(' ');
		
			return mask;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}
	
	public static MaskFormatter mascaraAno() {
		

		try {
			MaskFormatter mask = new MaskFormatter("####");
		
			return mask;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static MaskFormatter mascaraNula() {
		
		try {
			MaskFormatter mask = new MaskFormatter("");
		
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
	
	public static boolean vaidandoPlaca(String placa) {//se esse metodo retorna falso, a placa é invalida
		
		/*if(Mascara.vaidandoPlaca(getjPanelVendas().getjTFieldDTInicial().getText()) == true){
			
		}else {
			JOptionPane.showMessageDialog(null, "Placa Invalida, digite novamente");
			Mascara.setMascara(getjPanelVendas().getjTFieldDTInicial(), Mascara.mascaraNula());
			getjPanelVendas().getjTFieldDTInicial().requestFocus();
		}*/ // colocar no evento deois que sair do campo e fazeras alterações cabiveis, campos de placas
		
		String placaValid = new String(); // string para receber a placa removendo os expaços em branco caso aja, para verificar o tambanho da placa recebida
		
		for(int i =0; i< placa.length(); i++) {
			
			if(placa.charAt(i) != ' ') {
				placaValid = placaValid + placa.charAt(i); // concatendando calda pletra removendo espaços em branco
			}
		}
		
		if(placaValid.length() == 8 ) {// verifica o tamanho da string recebida, se for menor que 8 a placa esta invalida
			
			
			if( (placaValid.charAt(5) >= 'A' && placaValid.charAt(5) <= 'J') || placaValid.charAt(5) >= '0' ) {//verifica se a parte da placa que contem letras e nuero é uma letra valida entre "A" e "J" e maior que 0 como so pode ter um caracter ele nao vai aceitar numero maior que 9
				
				return true;
				
			}else {
				
				return false;
			}
			
			
			
		}else {
			return false;
		}
		
		
	}
	
	
}
