/**
 * 
 */
package model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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

	public static MaskFormatter mascaraCPF() {//mascara para cpf
	
		
		try {
			MaskFormatter mask = new MaskFormatter("###.###.###-##");//serve para limitar o tamanho do cpf e tambem deixa ja no formato
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
		
	
	public static MaskFormatter mascaraCelular() {//mascara para usar quando o numero for de celular
		
	
		try {
			MaskFormatter mask = new MaskFormatter("(##) #####-####");//limitando o tamanho e o formato do celular
		
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
			MaskFormatter mask = new MaskFormatter("##/##/####");//serve para colocar no formato da data os acaracter e ja deixa com as barras
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
			MaskFormatter mask = new MaskFormatter("A AA AAAAAA A AAAAAAA");//deixa no formato do chassi
			mask.setValidCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");//serve para limitar os valores que podem ser adicionados

			return mask;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static MaskFormatter mascaraQuilometragem() {
		

		try {
			MaskFormatter mask = new MaskFormatter("##########");//limitador de tamanho e tambem para receber apenas numeros
			mask.setPlaceholderCharacter(' ');//serve para se não usar o tamanho todo da mascara o que fica vazio ele colocar espaço vazio no lugar
		
			return mask;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}
	
	public static MaskFormatter mascaraAno() {
		

		try {
			MaskFormatter mask = new MaskFormatter("####");//para colocar apenas anos de veiculos 
		
			return mask;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static MaskFormatter mascaraCode() {//mascara para codigo de barra no formato EAN que o tamanho maximo é 13 digitos, so não aceita os formato Databar, ITF-14, Código 128,

		
		try {
			MaskFormatter mask = new MaskFormatter("############");
		
			return mask;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static MaskFormatter mascaraTelefone() {//mascara para telefone fixo
		
		try {
			MaskFormatter mask = new MaskFormatter("(##) ####-####");
		
			return mask;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	final static Locale BRAZIL = new Locale("pt","BR"); //define o local que ele vai usar como parametro a moeda
	
	final static DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
	
	static final DecimalFormat DINHEIRO_REAL = new DecimalFormat("¤ ###,###,##0.00",REAL);
	
	
	/**{@code}
	 * 
	 * O método mascaraDinheiro(@{code: })
	 * @param valor deve ser passado o numero double que sera convertido 
	 * @param moeda é a que o pais usa você pode definir ela com uso do locale e do decimalformatsimbolo e o decimal format
	 * @return ele devolve a string formatada que devera ser setada novamente no campo que a mascara sera adicionada
	 */
	
	public static String mascaraDinheiro(double valor, DecimalFormat moeda) {//essa mascara deve ser aplicada quando o campo perde o foco e setar o retorno dela novamente no campo para o usuario visualizar
		
		try {//MASCARA NÃO TESTADA
					
			return moeda.format(valor);
			
		} catch (Exception e) {
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
	

	
	public static boolean dataFormatoValido(String data) {
		
		try {
			
			SimpleDateFormat formateData = new SimpleDateFormat("dd/MM/yyyy");
			
			formateData.setLenient(false);
			
			formateData.parse(data);
			
			return true;
			
		}catch (Exception e) {
			
			
			
			return false;
		}
		
		
	}
	
	
	
	public static boolean dataValida(String data) {
		
		try {
			
			DateTimeFormatter dataAtual = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			LocalDate dataVerificada = LocalDate.parse(data, dataAtual);
			
			LocalDate hoje = LocalDate.now();
			
			return dataVerificada.compareTo(hoje) <= 0;
			
			
		}catch (Exception e) {
			
			
			return false;
			
		}
		
		
		
	}
	
	
	public static boolean validandoData(String data) {
		
		if( dataFormatoValido(data) == true) {
			
			
			if(dataValida(data) == true) {
				
				return true;
			}
			
			
		}
		
		return false;
		

		
	}
	
}
