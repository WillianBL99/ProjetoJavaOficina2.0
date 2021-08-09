/**
 * 
 */
package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Paulo Uilian, Josimar
 * @date 2021/07/27
 * @version 1.0
 */
public class Validar {
	
	// Configura o formato da data
	private static final SimpleDateFormat SIMPLE_FORMATEDATE = new SimpleDateFormat("dd/MM/yyyy");
	private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	/**
	 * O m�todo vaidandoPlaca(String @{code: placa}), verifica se uma placa tem o formato v�lido
	 * @param placa
	 * @return boolean
	 */
	public static boolean vaidandoPlaca(String placa) {		
		// Passa a String do par�metro sem os espa�os, caso haja, para a vari�vel
		String placaRegEx = placa.replace(" ", "");	
		// Retorna verdadeiro caso a a express�o regular confirme que a placa � v�lida
		return placaRegEx.matches("[A-Z]{3}\\-?\\d([A-J]|\\d)\\d{2}\\/?([A-Z]{2})?");		
	}
	
	

	/** 
	 * O m�todo validarData(String @{code: data}), Verifica se uma data � v�lida
	 * @param data
	 * @return boolean
	 */
	public static boolean validarData(String data) {
		// Verifica se o formato � v�lido
		if(dataFormatoValido(data)) {
			// Verifica se a data n�o � maior que a data atual
			if(compareDateTo(data))
				return true;
		}
			
		return false;
	}

	
	/** 
	 * O m�todo dataFormatoValido(String @{code: data}), verifica se o formato da data � v�lido
	 * @param data
	 * @return boolean
	 */
	private static boolean dataFormatoValido(String data) {
		
		try {
			// Formato desejado de data
			SimpleDateFormat formateData = SIMPLE_FORMATEDATE;
			// Impede excu��o de euristica interna
			formateData.setLenient(false);
			// Verifica se a data passada � v�lida
			formateData.parse(data.replace(" ", ""));
			
			return true;
			
		}catch (Exception e) {
			// Erro ao validar
			System.err.println("Erro - dataFormatoValido" + e.getMessage());
			return false;
		}		
	}
	
	
	/** 
	 * O m�todo compareDateTo(@{code: })
	 * @param data
	 * @return boolean
	 */
	private static boolean compareDateTo(String data) {
		// Pega a data atual
		LocalDate today = LocalDate.now();
		// copara as datas
		return compareDateTo(data, today.format(DATETIME_FORMATTER));
	}
	
	
	/**
	 * O m�todo compareDateTo(@{code: })
	 * @param data1
	 * @param data2
	 * @return boolean
	 */
	public static boolean compareDateTo(String data1, String data2) {
		try {
			// Recebe a data1 formatada
			LocalDate dateReceived1 = LocalDate.parse(data1, DATETIME_FORMATTER);
			// Recebe a data2 formatada
			LocalDate dateReceived2 = LocalDate.parse(data2, DATETIME_FORMATTER);
			// Se a data for menor ou igual � data(dateReceived2) retorna true
			return dateReceived1.compareTo(dateReceived2) <= 0;	
			
		} catch (Exception e) {
			// Erro ao validar
			System.err.println("Erro - dataValida" + e.getMessage());
			return false;
		}
	}
	
	
	/**
	 * O m�todo cpfValido(String @{code cpf}), Verifica se o cpf inserido � v�lido
	 * @param cnpj
	 * @return boolean Retorna verdadeiro caso o cpf seja v�lido
	 */
	public static boolean cpfValido(String cpf) {
		boolean retorno = false;
		// Verifica se o tamanho do cnpj � v�lido
		if(cpf.length() == 11) {
			// verifica se o cnpj inserido � v�lido
			retorno = cpf.equals(verificarCPF(cpf.substring(0, 9)));
		}
		// Retorna o resultado da verifica��o
		return retorno; 
	}
	
	
	/**
	 * O m�todo verificarCPF(String @{code cpf}), recebe os 9 primeiros n�meros do cpf e retorna o cpf completo.
	 * @param cpf
	 * @return String
	 */
	private static String verificarCPF(String cpf) {
		if(cpf.length() == 11)
			return cpf;
		// Base para multiplica��o de cada n�mero do cnpj
		int[] base = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		// vari�vel auxiliar para a verifica��o do 10� dv
		int j = 0;
		// Caso seja a cria��o do 10� DV
		if(cpf.length() < 10) j = 1;
		
		// Utilizada para c�lcular o dv
		Integer number = 0;
		
		// itera o cpf
		for(int i = 0; i < cpf.length(); i++) {
			// recebe a soma de todas as multiplica��es
			number += Integer.parseInt(String.valueOf(cpf.charAt(i))) * base[i+j];
		}
		// gera o c�digo DV
		number = number%11;
		
		return verificarCPF(cpf + number.toString());
	}
	
	
	/**
	 * O m�todo cnpjValido(String @{code cnpj}), Verifica se o cnpj inserido � v�lido
	 * @param cnpj
	 * @return boolean Retorna verdadeiro caso o cnpj seja v�lido
	 */
	public static boolean cnpjValido(String cnpj) {
		boolean retorno = false;
		// Verifica se o tamanho do cnpj � v�lido
		if(cnpj.length() == 14) {
			// verifica se o cnpj inserido � v�lido
			retorno = cnpj.equals(verificaCNPj(cnpj.substring(0, 12)));
		}
		// Retorna o resultado da verifica��o
		return retorno;
	}
	
	
	/**
	 * O m�todo verificaCNPj(String @{code cnpj}), recebe os 12 primeiros n�meros do cnpj e retorna o cnpj completo.
	 * @param cnpj
	 * @return String
	 */
	private static String verificaCNPj(String cnpj) {
		if(cnpj.length() == 14)
			return cnpj;
		// Base para multiplica��o de cada n�mero do cnpj
		int[] base = {5, 6, 7, 8, 9, 2, 3, 4, 5, 6, 7, 8, 9};
		// vari�vel auxiliar para a verifica��o do 10� dv
		int j = 0;
		// Caso seja a cria��o do 13� DV
		if(cnpj.length() < 13) j = 1;
		
		// Utilizada para c�lcular o dv
		Integer number = 0;
		
		// itera o cnpj
		for(int i = 0; i < cnpj.length(); i++) {
			// recebe a soma de todas as multiplica��es
			number += Integer.parseInt(String.valueOf(cnpj.charAt(i))) * base[i+j];
		}
		// gera o c�digo DV
		number = number%11;
		
		return verificaCNPj(cnpj + number.toString());
	}
}
