/**
 * 
 */
package model;

/**
 * Contem o tamanho de cada registro de um determinardo arquivo binário e o seu URI.
 * @author Paulo Uilian
 *
 */
public class ListArqBin {
	/*
	 * Usuário 20bytes
	 * senha 8bytes
	 */
	public static String[] prohibited() {
		String uri = "C:\\projetos\\Softwares\\Projeto Programa java\\ProjetoJavaOficina2.0\\.conf\\.prohibited\\prohibited.jpo";
		String reg = "56";
		return new String[] {uri, reg};
	}
	
	
	/*
	 * id 4byte
	 */
	public static String[] company() {
		String uri = "C:\\projetos\\Softwares\\Projeto Programa java\\ProjetoJavaOficina2.0\\.conf\\.info\\company\\company.jpo";
		String reg = "4";
		return new String[] {uri, reg};
	}
}
