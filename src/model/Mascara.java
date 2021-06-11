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
		
			JFormattedTextField f ;
		try {
		
			f = new JFormattedTextField(new MaskFormatter("###.###.###-##"));

			return f;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	
	public static JFormattedTextField mascaraPlaca() {
		
		JFormattedTextField placa ;
	try {
		MaskFormatter mask = new MaskFormatter("UUU #A##");
		mask.setValidCharacters("ABCDEFGHIJ0123456789abcdefghij");
		placa = new JFormattedTextField(mask);
		

		return placa;
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
	
	
}
}
