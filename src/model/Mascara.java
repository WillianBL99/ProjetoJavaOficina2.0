/**
 * 
 */
package model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 * @author Perseu
 *
 */
public class  Mascara {

	public static final Locale BRAZIL = new Locale("pt","BR"); //define o local que ele vai usar como parametro a moeda	
	public static final DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);	
	public static final DecimalFormat DINHEIRO_REAL = new DecimalFormat("¤ ###,###,##0.00",REAL);
	private static JFormattedTextField jFormatted;
	
	/**
	 * O método setMascara(JFormattedTextField {@code jFormattedTextField}, MaskFormatter {@code mask}),
	 * seta a máscara '{@code mask}' no {@code jFormattedTextField}.
	 * @param jFormattedTextField recebe o jTextField para setar a mascara.
	 * @param mask void
	 */
	public static void setMascara(JFormattedTextField jFormattedTextField, MaskFormatter mask) {	
		jFormatted = jFormattedTextField;
		jFormattedTextField.setFormatterFactory(new DefaultFormatterFactory(mask));
		
	}
	
	
	/**
	 * O método mascaraCPF() formata o campo para CPF.
	 * @return MaskFormatter
	 */
	public static MaskFormatter mascaraCPF() {
		
		try {
			MaskFormatter mask = new MaskFormatter("###.###.###-##");//serve para limitar o tamanho do cpf e tambem deixa ja no formato
			return mask;
			
		} catch (ParseException e) {
			// Erro ao passar a mascara
			System.err.println("Erro - mascaraCPF" + e.getMessage());
			return null;
		}
	}
	
	
	/**
	 * O método mascaraPlaca() formata o campo para placa.
	 * @return MaskFormatter
	 */
	public static MaskFormatter mascaraPlaca() {		
		
		try {
			MaskFormatter mask = new MaskFormatter("UUU-#A##/UU");
			mask.setValidCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"); // inserido para testes, apagar depois
		
			return mask;
			
		} catch (ParseException e) {
			// Erro ao passar a mascara
			System.err.println("Erro - mascaraCPF" + e.getMessage());
			return null;
		}
	}
		
	
	/**
	 * O método mascaraCelular() formata o campo para celular.
	 * @return MaskFormatter
	 */
	public static MaskFormatter mascaraCelular() {	
	
		try {
			MaskFormatter mask = new MaskFormatter("(##) #####-####");		
			return mask;
				
		} catch (ParseException e) {
			// Erro ao passar a mascara
			System.err.println("Erro - mascaraCPF" + e.getMessage());
			return null;
		}
	}
	
	
	/**
	 * O método mascaraData() formata o campo para data.
	 * @return MaskFormatter
	 */
	public static MaskFormatter mascaraData() {
		
		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			return mask;
			
		} catch (ParseException e) {
			// Erro ao passar a mascara
			System.err.println("Erro - mascaraCPF" + e.getMessage());
			return null;
		}
	}
	
	
	/**
	 * O método mascaraChassi() formata o campo para receber chassi.
	 * @return MaskFormatter
	 */
	public static MaskFormatter mascaraChassi() {
		
		try {
			//deixa no formato do chassi
			MaskFormatter mask = new MaskFormatter("A AA AAAAAA A AAAAAAA");
			//serve para limitar os valores que podem ser adicionados
			mask.setValidCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");

			return mask;
			
		} catch (ParseException e) {
			// Erro ao passar a mascara
			System.err.println("Erro - mascaraCPF" + e.getMessage());
			return null;
		}
	}
	
	
	/**
	 * O método mascaraQuilometragem() formata o campo para quilometros.
	 * @return MaskFormatter
	 */
	public static MaskFormatter mascaraQuilometragem() {		

		try {
			// Limitador de tamanho e tambem para receber apenas numeros
			MaskFormatter mask = new MaskFormatter("##########");
			// Serve para se não usar o tamanho todo da mascara o que fica vazio ele colocar espaço vazio no lugar
			mask.setPlaceholderCharacter(' ');
		
			return mask;
			
		} catch (ParseException e) {
			// Erro ao passar a mascara
			System.err.println("Erro - mascaraCPF" + e.getMessage());
			return null;
		}
	}
	
	
	/**
	 * O método mascaraAno() formata o campo para receber ano.
	 * @return MaskFormatter
	 */
	public static MaskFormatter mascaraAno() {	

		try {
			MaskFormatter mask = new MaskFormatter("####");//para colocar apenas anos de veiculos 		
			return mask;
			
		} catch (ParseException e) {
			// Erro ao passar a mascara
			System.err.println("Erro - mascaraCPF" + e.getMessage());
			return null;
		}
	}
	
	
	/**
	 * O método mascaraCode() formata o campo para código.
	 * <p>Mascara para codigo de barra no formato EAN que o tamanho maximo é
	 * 13 digitos, so não aceita os formato Databar, ITF-14, Código 128.
	 * @return MaskFormatter
	 */
	public static MaskFormatter mascaraCode() {
		
		try {
			MaskFormatter mask = new MaskFormatter("############");		
			return mask;
			
		} catch (ParseException e) {
			// Erro ao passar a mascara
			System.err.println("Erro - mascaraCPF" + e.getMessage());
			return null;
		}
	}
	
	
	/**
	 * O método mascaraTelefone() formata o campo para telefone.
	 * @return MaskFormatter
	 */
	public static MaskFormatter mascaraTelefone() {
		
		try {
			MaskFormatter mask = new MaskFormatter("(##) ####-####");
		
			return mask;
			
		} catch (ParseException e) {
			// Erro ao passar a mascara
			System.err.println("Erro - mascaraCPF" + e.getMessage());
			return null;
		}
	}
	
	
	
	/**
	 * O método mascaraDinheiro(double @{code valor}, DecimalFormat {@code moeda}
	 * @param valor deve ser passado o numero double que sera convertido 
	 * @param moeda é a que o pais usa você pode definir ela com uso do locale e do decimalformatsimbolo e o decimal format
	 * @return ele devolve a string formatada que devera ser setada novamente no campo que a mascara sera adicionada
	 */	
	public static String mascaraDinheiro(double valor, DecimalFormat moeda) {
		
		try {					
			return moeda.format(valor);
			
		} catch (Exception e) {
			// Erro ao passar a mascara
			System.err.println("Erro - mascaraCPF" + e.getMessage());
			return null;
		}
	}
	
	
	/**
	 * O método mascaraNula() retirar a mascara do campo.
	 * @return MaskFormatter
	 */
	public static MaskFormatter mascaraNula() {
		
		try {
			MaskFormatter mask = new MaskFormatter("");		
			jFormatted.setFormatterFactory(null);
			return mask;
			
		} catch (ParseException e) {
			// Erro ao passar a mascara
			System.err.println("Erro - mascaraCPF" + e.getMessage());
			return null;
		}
	}	
}
