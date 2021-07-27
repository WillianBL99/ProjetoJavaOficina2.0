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
	 * O método vaidandoPlaca(String @{code: placa}), verifica se uma placa tem o formato válido
	 * @param placa
	 * @return boolean
	 */
	public static boolean vaidandoPlaca(String placa) {		
		// Passa a String do parâmetro sem os espaços, caso haja, para a variável
		String placaRegEx = placa.replace(" ", "");	
		// Retorna verdadeiro caso a a expressão regular confirme que a placa é válida
		return placaRegEx.matches("[A-Z]{3}\\-?\\d([A-J]|\\d)\\d{2}\\/?([A-Z]{2})?");		
	}
	
	

	/** 
	 * O método validarData(String @{code: data}), Verifica se uma data é válida
	 * @param data
	 * @return boolean
	 */
	public static boolean validarData(String data) {
		// Verifica se o formato é válido
		if(dataFormatoValido(data)) {
			// Verifica se a data não é maior que a data atual
			if(compareDateTo(data))
				return true;
		}
			
		return false;
	}

	
	/** 
	 * O método dataFormatoValido(String @{code: data}), verifica se o formato da data é válido
	 * @param data
	 * @return boolean
	 */
	private static boolean dataFormatoValido(String data) {
		
		try {
			// Formato desejado de data
			SimpleDateFormat formateData = SIMPLE_FORMATEDATE;
			// Impede excução de euristica interna
			formateData.setLenient(false);
			// Verifica se a data passada é válida
			formateData.parse(data.replace(" ", ""));
			
			return true;
			
		}catch (Exception e) {
			// Erro ao validar
			System.err.println("Erro - dataFormatoValido" + e.getMessage());
			return false;
		}		
	}
	
	
	/** 
	 * O método compareDateTo(@{code: })
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
	 * O método compareDateTo(@{code: })
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
			// Se a data for menor ou igual à data(dateReceived2) retorna true
			return dateReceived1.compareTo(dateReceived2) <= 0;	
			
		} catch (Exception e) {
			// Erro ao validar
			System.err.println("Erro - dataValida" + e.getMessage());
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
}
