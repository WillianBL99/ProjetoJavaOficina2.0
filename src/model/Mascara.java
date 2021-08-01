/**
 * 
 */
package model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 * @author Perseu
 *
 */
public class  Mascara {

	public static final Locale BRAZIL = new Locale("pt","BR"); //define o local que ele vai usar como parametro a moeda	
	public static final DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);	
	public static final DecimalFormat DINHEIRO_REAL = new DecimalFormat("� ###,###,##0.00",REAL);
	private static JFormattedTextField jFormatted;
	
	/**
	 * O m�todo setMascara(JFormattedTextField {@code jFormattedTextField}, MaskFormatter {@code mask}),
	 * seta a m�scara '{@code mask}' no {@code jFormattedTextField}.
	 * @param jFormattedTextField recebe o jTextField para setar a mascara.
	 * @param mask void
	 */
	public static void setMascara(JFormattedTextField jFormattedTextField, MaskFormatter mask) {	
		jFormatted = jFormattedTextField;
		jFormattedTextField.setFormatterFactory(new DefaultFormatterFactory(mask));
		
	}
	
	
	/**
	 * O m�todo verificarCarcter(String[] @{code regEx}, String {@code entrada}) recebe um array de express�es regulares
	 * e verifica se cada caracter de {@code entrada} corresponde ao respectivo �ndice de {@code regEx[]}.
	 * @param regEx recebe um array de express�o regular
	 * @param entrada recebe o texto que ser� verificado e selecionado
	 * @return String retorna uma String com os caracteres v�lidos de {@code entrada}.
	 */
	private static String verificarCarcter(String[] regEx, String entrada) {		
		// Ser� a saida de texto formatada
		String saida = "";				
		// Transformar a entrada em um array de String contendo cada caracter individualmente
		String[] conteudo = entrada.split("");		
		// Compara cada �ndice de placa[] com o �ndice equivalente de regEx[]
		for(int i = 0; (i < conteudo.length) && (i < regEx.length); i++) {
			// Verifica se o caracter � v�lido, caso n�o seja o for � enterrompido e retorna s� os caracteres validados at� o momento
			if(!conteudo[i].matches(regEx[i])) {
				break;
			}
			// Adiciona o caracter validado ao texto de sa�da
			saida += conteudo[i];
		}		
		// Retorna a sa�da formatada
		return saida;
	}
	
	
	
	/**
	 * O m�todo mascaraCPF() formata o campo para CPF.
	 * @return MaskFormatter
	 */
	public static void mascaraCPF(JTextField cpf) {
		// Coloca em em caixa alta e retira tudo que n�o for n�mero
		String saida = cpf.getText().toUpperCase().replaceAll("\\D", "");
		
		String n = "\\d"; // RegEx para n�meros
		
		// RegEx de um cpf
		String[] regEx = {n, n, n, n, n, n, n, n, n, n, n};
		
		// Retorna a s�mente a parte v�lida da vari�vel 'saida'
		saida = verificarCarcter(regEx, saida);
		
		if(saida.length() >= 4 && saida.length() <= 6)
			saida = saida.replaceAll("(\\d{3})(\\d{1,3})", "$1.$2");
		
		else if(saida.length() >= 7 && saida.length() <= 9)
			saida = saida.replaceAll("(\\d{3})(\\d{3})(\\d{1,3})", "$1.$2.$3");
		
		else if(saida.length() >= 10 && saida.length() <= 11)
			saida = saida.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{1,2})", "$1.$2.$3-$4");
		
		// Seta o texto no jTextField
		cpf.setText(saida);
	}
	
	
	/**
	 * O m�todo mascaraPlaca(TextField placa) recebe uma string e retorna somente a sequencia valida.
	 * Inicia no primeiro caracter e para no caracter que n�o for v�lido ou quando atingir o tamanho m�ximo permitido
	 * para o campo.
	 * @param placa recebe o campo que ser� formatado para placa ex.: ABC-1234/DE... ABC-1D23...
	 */
	public static void mascaraPlaca(JTextField placa) {	
		// Coloca tudo em mai�sculo e retira qualquer caracter que n�o seja n�meros ou letras
		String saida = placa.getText().toUpperCase().replaceAll("\\W", "");
		
		String laz = "[A-Z]"; // Regex para letras mai�sculas
		String laj = "[A-J]"; // RegEx para letras mai�sculas de A a J
		String n = "\\d"; // ReGex para n�meros
			
		// Regex de uma placa;
		String[] regEx = {laz, laz, laz, n, String.format("(%s|%s)", n, laj), n, n, laz, laz};
		
		// Retorna a s�mente a parte v�lida da vari�vel 'saida'
		saida = verificarCarcter(regEx, saida);
		
		//Verificar se a sa�da de placa tem UF
		if(saida.matches(String.format(".{7}(%s{1,2})$", laz))){
			// Formata a placa com uf
			saida = saida.replaceAll("([A-Z]{3})(\\d)(\\d|[A-J])(\\d{2})([A-Z]{1,2})", "$1-$2$3$4/$5");
		}
		else {		
			// Formata a placa sem uf
			saida = saida.replaceAll("([A-Z]{3})(\\d?)(\\d?|[A-J]?)(\\d{0,2})", "$1-$2$3$4");
		}
		// Seta o texto no jtextfield
		placa.setText(saida);
	}
		
	
	/**
	 * O m�todo mascaraCelular() formata o campo para celular.
	 * @return MaskFormatter
	 */
	public static void mascaraTelefone(JTextField fone) {	
		// Coloca tudo em mai�sculo e retira qualquer caracter que n�o seja n�meros
		String saida = fone.getText().toUpperCase().replaceAll("\\D", "");
	
		String n = "\\d"; // ReGex para n�meros
			
		// Regex de uma placa;
		String[] regEx = {n, n, n, n, n, n, n, n, n, n, n};
		
		// Retorna a s�mente a parte v�lida da vari�vel 'saida'
		saida = verificarCarcter(regEx, saida);
		
		if(saida.length() >= 5 && saida.length() <= 8)
			saida = saida.replaceAll("(\\d{4})(\\d{1,4})", "$1-$2");
		
		else if(saida.length() >= 9 && saida.length() <= 10)
			saida = saida.replaceAll("(\\d{2})(\\d{4})(\\d{2,4})", "($1) $2-$3");
		
		else if(saida.length() >= 10 && saida.length() <= 11)
			saida = saida.replaceAll("(\\d{2})(\\d{5})(\\d{2,4})", "($1) $2-$3");
		
		// Seta o texto no jtextfield
		fone.setText(saida);
	}
	
	
	/**
	 * O m�todo mascaraData() formata o campo para data.
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
	 * O m�todo mascaraChassi() formata o campo para receber chassi.
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
	 * O m�todo mascaraQuilometragem() formata o campo para quilometros.
	 * @return MaskFormatter
	 */
	public static MaskFormatter mascaraQuilometragem() {		

		try {
			// Limitador de tamanho e tambem para receber apenas numeros
			MaskFormatter mask = new MaskFormatter("##########");
			// Serve para se n�o usar o tamanho todo da mascara o que fica vazio ele colocar espa�o vazio no lugar
			mask.setPlaceholderCharacter(' ');
		
			return mask;
			
		} catch (ParseException e) {
			// Erro ao passar a mascara
			System.err.println("Erro - mascaraCPF" + e.getMessage());
			return null;
		}
	}
	
	
	/**
	 * O m�todo mascaraAno() formata o campo para receber ano.
	 * @return MaskFormatter
	 */
	public static void mascaraAno(JTextField ano) {	
		// Coloca tudo em mai�sculo e retira qualquer caracter que n�o seja n�meros
		String saida = ano.getText().toUpperCase().replaceAll("\\D", "");
	
		String n = "\\d"; // ReGex para n�meros
			
		// Regex ano;
		String[] regEx = {n, n, n, n};
		
		// Retorna a s�mente a parte v�lida da vari�vel 'saida'
		saida = verificarCarcter(regEx, saida);
				
		// Seta o texto no jtextfield
		ano.setText(saida);
	}
	
	
	/**
	 * O m�todo mascaraCode() formata o campo para c�digo.
	 * <p>Mascara para codigo de barra no formato EAN que o tamanho maximo �
	 * 13 digitos, so n�o aceita os formato Databar, ITF-14, C�digo 128.
	 * @return MaskFormatter
	 */
	public static void mascaraCode(JTextField code) {	
		// Coloca tudo em mai�sculo e retira qualquer caracter que n�o seja n�meros
		String saida = code.getText().toUpperCase().replaceAll("\\D", "");
	
		String n = "\\d"; // ReGex para n�meros
			
		// Regex codigo;
		String[] regEx = {n, n, n, n, n, n, n, n, n, n, n, n, n};
		
		// Retorna a s�mente a parte v�lida da vari�vel 'saida'
		saida = verificarCarcter(regEx, saida);
				
		// Seta o texto no jtextfield
		code.setText(saida);
	}
		
	
	/**
	 * O m�todo mascaraDinheiro(double @{code valor}, DecimalFormat {@code moeda}
	 * @param valor deve ser passado o numero double que sera convertido 
	 * @param moeda � a que o pais usa voc� pode definir ela com uso do locale e do decimalformatsimbolo e o decimal format
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
	 * O m�todo mascaraNula() retirar a mascara do campo.
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
