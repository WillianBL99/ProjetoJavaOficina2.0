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
	 * O método verificarCarcter(String[] @{code regEx}, String {@code entrada}) recebe um array de expressões regulares
	 * e verifica se cada caracter de {@code entrada} corresponde ao respectivo índice de {@code regEx[]}.
	 * @param regEx recebe um array de expressão regular
	 * @param entrada recebe o texto que será verificado e selecionado
	 * @return String retorna uma String com os caracteres válidos de {@code entrada}.
	 */
	private static String verificarCarcter(String[] regEx, String entrada) {		
		// Será a saida de texto formatada
		String saida = "";				
		// Transformar a entrada em um array de String contendo cada caracter individualmente
		String[] conteudo = entrada.split("");		
		// Compara cada índice de placa[] com o índice equivalente de regEx[]
		for(int i = 0; (i < conteudo.length) && (i < regEx.length); i++) {
			// Verifica se o caracter é válido, caso não seja o for é enterrompido e retorna só os caracteres validados até o momento
			if(!conteudo[i].matches(regEx[i])) {
				break;
			}
			// Adiciona o caracter validado ao texto de saída
			saida += conteudo[i];
		}		
		// Retorna a saída formatada
		return saida;
	}
	
	
	
	/**
	 * O método mascaraCPF() formata o campo para CPF.
	 * @return MaskFormatter
	 */
	public static void mascaraCPF(JTextField cpf) {
		// Coloca em em caixa alta e retira tudo que não for número
		String saida = cpf.getText().toUpperCase().replaceAll("\\D", "");
		
		String n = "\\d"; // RegEx para números
		
		// RegEx de um cpf
		String[] regEx = {n, n, n, n, n, n, n, n, n, n, n};
		
		// Retorna a sómente a parte válida da variável 'saida'
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
	 * O método mascaraPlaca(TextField placa) recebe uma string e retorna somente a sequencia valida.
	 * Inicia no primeiro caracter e para no caracter que não for válido ou quando atingir o tamanho máximo permitido
	 * para o campo.
	 * @param placa recebe o campo que será formatado para placa ex.: ABC-1234/DE... ABC-1D23...
	 */
	public static void mascaraPlaca(JTextField placa) {	
		// Coloca tudo em maiúsculo e retira qualquer caracter que não seja números ou letras
		String saida = placa.getText().toUpperCase().replaceAll("\\W", "");
		
		String laz = "[A-Z]"; // Regex para letras maiúsculas
		String laj = "[A-J]"; // RegEx para letras maiúsculas de A a J
		String n = "\\d"; // ReGex para números
			
		// Regex de uma placa;
		String[] regEx = {laz, laz, laz, n, String.format("(%s|%s)", n, laj), n, n, laz, laz};
		
		// Retorna a sómente a parte válida da variável 'saida'
		saida = verificarCarcter(regEx, saida);
		
		//Verificar se a saída de placa tem UF
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
	 * O método mascaraCelular() formata o campo para celular.
	 * @return MaskFormatter
	 */
	public static void mascaraTelefone(JTextField fone) {	
		// Coloca tudo em maiúsculo e retira qualquer caracter que não seja números
		String saida = fone.getText().toUpperCase().replaceAll("\\D", "");
	
		String n = "\\d"; // ReGex para números
			
		// Regex de uma placa;
		String[] regEx = {n, n, n, n, n, n, n, n, n, n, n};
		
		// Retorna a sómente a parte válida da variável 'saida'
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
	public static void mascaraAno(JTextField ano) {	
		// Coloca tudo em maiúsculo e retira qualquer caracter que não seja números
		String saida = ano.getText().toUpperCase().replaceAll("\\D", "");
	
		String n = "\\d"; // ReGex para números
			
		// Regex ano;
		String[] regEx = {n, n, n, n};
		
		// Retorna a sómente a parte válida da variável 'saida'
		saida = verificarCarcter(regEx, saida);
				
		// Seta o texto no jtextfield
		ano.setText(saida);
	}
	
	
	/**
	 * O método mascaraCode() formata o campo para código.
	 * <p>Mascara para codigo de barra no formato EAN que o tamanho maximo é
	 * 13 digitos, so não aceita os formato Databar, ITF-14, Código 128.
	 * @return MaskFormatter
	 */
	public static void mascaraCode(JTextField code) {	
		// Coloca tudo em maiúsculo e retira qualquer caracter que não seja números
		String saida = code.getText().toUpperCase().replaceAll("\\D", "");
	
		String n = "\\d"; // ReGex para números
			
		// Regex codigo;
		String[] regEx = {n, n, n, n, n, n, n, n, n, n, n, n, n};
		
		// Retorna a sómente a parte válida da variável 'saida'
		saida = verificarCarcter(regEx, saida);
				
		// Seta o texto no jtextfield
		code.setText(saida);
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
