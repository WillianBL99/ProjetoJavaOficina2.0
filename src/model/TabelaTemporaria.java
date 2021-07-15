/**
 * 
 */
package model;

import java.util.ArrayList;

import javax.swing.JTable;

import error.TBExceptionItem;

/**
 * @author Paulo Uilian
 * @version 1.0
 * Date 07/15/2021
 *
 */
public class TabelaTemporaria {
	
	private ArrayList<String[]> tabela;

	// Construtor para iniciar a classe
	public TabelaTemporaria() {
		tabela = new ArrayList<>();
	}
	
	
	/**
	 * Método inserir(JTable jTable, String... campos) Recebe a tabela onde os @campos passados como parametros 
	 * serão exibidos em forma de linha.
	 * As linhas serão organizadas de acordo com o número da primeira coluna.
	 * Se Tentar inserir um conjunto de informações que tenha o primeiro campo igual ao primeiro campos de inserções
	 * anteriores vai ser retornado false.
	 * @param jTable Recebe a tabela onde serão inseridos os valores
	 * @param campos Recebe os campos que serão inseridos na tabela
	 * @return boolean
	 */
	public boolean inserir(JTable jTable, String... campos) {
		boolean insert;
		insert = insereLinhaTabela(campos);
		organizar(getTabela());
		preencher(jTable);
		return insert;
	}
	
	
	/**
	 * Método insereLinhaTabela(String... campos) Recebe os valores a serem inseridos em outra tabela
	 * e os passam para um Vetor de String depois de verifica se o numero do primeiro campos já existe
	 * no ArrayList. Caso tenha retorna false.
	 * @param campos Recebe um número variável de argumentos do tipo String.
	 * @return boolean
	 */	
	private boolean insereLinhaTabela(String... campos) {
		// recebe false caso tenha alguma linha com o mesmo id inserido
		boolean insert = true;
		// Itera toda o ArrayList getTabela()
		for(int i = 0; i < getTabela().size(); i++) {
			// Recebe a linha atual
			String[] linha = getTabela().get(i);
			// Copara o primeiro campo da linha com o primerio parametro
			if(linha[0] == campos[0])
				// gera uma exeption !! Verificar forma de gerar uma exception
				// new TBExceptionItem(String.format("First argument (\"%s\") iquals to the first field of line %d of ArrayList<String[]>", campos[0], i));
				insert = false;
		}
		
		// Insere os campos no ArrayList
		if(insert) {
			String[] linha= campos;
			getTabela().add(linha);
		}
		return insert;
	}
	
	
	/**
	 * Ordena os ítens de um arraylist de acordo com uma tabela númerica
	 * @param tabela
	 */
	private static  void organizar(ArrayList<String[]> tabela) {
		int iNum;
		int jNum;
		
		/*
		 * Faz a verificação se o item[i] é maior que o ítem[j].
		 * Se for, remove o ítem[j] e coloca antes do ítem[i].
		 * Dessa forma a tabela é organizada do maior para o menor
		 * levando em conta o id do produto.
		 */
		for(int i = 0; i < tabela.size() - 1; i++) {
			for(int j = i + 1; j < tabela.size(); j++) {
				String[] linhaI = tabela.get(i);
				String[] linhaJ = tabela.get(j);
				iNum = Integer.parseInt(linhaI[0]);
				jNum = Integer.parseInt(linhaJ[0]);
				if(iNum > jNum) {
					tabela.add(i, tabela.remove(j));
				}
			}
		}
	}
	
	
	private void preencher(JTable jTable2) {
		int countColumn = jTable2.getColumnCount();
		String[] colunas = new String[countColumn];
		Object [][] linhaColunas  = new Object[getTabela().size()][countColumn];
		
		for(int i = 0; i < countColumn; i++) {
			// Pega o nome das colunas
			colunas[i] = jTable2.getColumnName(i).toString();
			// Pega o valor das linhas de cada coluna
			for(int j = 0; j < getTabela().size(); j++) {
				// pega uma linha do arrayList
				String[] row = getTabela().get(j);
				linhaColunas[j][i] = row[i];
			}
		}
		jTable2.setModel(new javax.swing.table.DefaultTableModel(
	            linhaColunas, colunas));	
	}
	
	
	public ArrayList<String[]> getTabela() {
		if(tabela == null){	
			tabela = new ArrayList<>();	
		}
		return tabela;
	}

	public void setTabela(ArrayList<String[]> tabela) {
		this.tabela = tabela;
	}
}
