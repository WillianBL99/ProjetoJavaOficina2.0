/**
 * 
 */
package model;

import java.util.ArrayList;
import javax.swing.JTable;

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
		getTabela();
	}
	
	
	/**
	 * Método inserir(JTable jTable, String... campos) Recebe a tabela onde os @campos passados como parametros 
	 * serão exibidos em forma de linha.
	 * As linhas serão organizadas de acordo com o número da primeira coluna.
	 * Se Tentar inserir um conjunto de informações que tenha o primeiro campo igual ao primeiro campos de inserções
	 * anteriores vai ser retornado false.
	 * @param jTable Recebe a tabela onde serão inseridos os valores
	 * @param campos Recebe os campos que serão inseridos na tabela, e a quantidade de parametros passados não pode ser menor
	 * que a quantidade de colunas da tabela onde seraão exibido os valores. Caso insira uma quantidade de campos menor que a quantidade
	 * de colunas da jTable será gerada um IllegalArgumentException().
	 * @return boolean
	 */
	public boolean inserir(JTable jTable, String... campos) {// Se inserida uma quantidade de campos menor que a quantidade de colunas de jTable
		if(campos.length < jTable.getColumnCount())
			throw new IllegalArgumentException(String.format("Erro ao setar os parâmetros de campos. Quantidade de campos menor que a de colunas. campos.length: %d colunas: ",
					campos.length, jTable.getColumnCount()));
		
		boolean insert = insereLinhaTabela(campos);
		organizar();
		preencher(jTable);
		return insert;
	}
	
	
	/**
	 * Método inserir(JTable jTable, int initArgument, int finalArgument, String... campos) Recebe a tabela onde os @campos passados como parametros 
	 * serão exibidos em forma de linha.
	 * As linhas serão organizadas de acordo com o número da primeira coluna e em seguida enseridas na tabela de acordo com o intervalo
	 * selecionado entre initArgument e a quantidade de colunas da jTable.
	 * Se Tentar inserir um conjunto de informações que tenha o primeiro campo igual ao primeiro campos de inserções
	 * anteriores vai ser retornado false.
	 * @param jTable Recebe a tabela onde serão inseridos os valores
	 * @param initArgument Recebe o valor mínimo de 0 e máximo de (campos.lenght() - jTable.getColumnCount()). Caso insira um valor fora desse intevarlo
	 * será gerada um IllegalArgumentException().
	 * @param campos Recebe os campos que serão inseridos na tabela, e a quantidade de parametros passados não pode ser menor
	 * que a quantidade de colunas da tabela onde seraão exibido os valores. Caso insira uma quantidade de campos menor que a quantidade
	 * de colunas da jTable será gerada um IllegalArgumentException().
	 * @return boolean
	 */
	public boolean inserir(JTable jTable, int initArgument, String... campos) {
		// Se initArment for setado incorretamente
		if(initArgument < 0 || initArgument > (campos.length - jTable.getColumnCount()))
			throw new IllegalArgumentException(String.format("Erro ao setar o parâmetro initArgument. Valores aceitos de 0 a %d", campos.length - jTable.getColumnCount()));
		
		// Se inserida uma quantidade de campos menor que a quantidade de colunas de jTable
		if(campos.length < jTable.getColumnCount())
			throw new IllegalArgumentException(String.format("Erro ao setar os parâmetros de campos. Quantidade de campos menor que a de colunas. campos.length: %d colunas: ",
					campos.length, jTable.getColumnCount()));
		
		// Recebe falso caso o id do produto seja igual ao de algum produto inserido anteriormente
		boolean insert = insereLinhaTabela(campos);
		organizar();
		preencher(jTable, initArgument);
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
			if(linha[0].replace(" ", "") == campos[0].replace(" ", ""))
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
	 * O método organizar() Ordena os ítens do ArrayList<String[]> da TabelaTemporaria
	 *  de acordo com o campo[0] (campo que contenha numeros) do vetor de String (String[]).
	 */
	public void organizar() {

		int iNum;
		int jNum;
		
		/*
		 * Faz a verificação se o item[i] é maior que o ítem[j].
		 * Se for, remove o ítem[j] e coloca antes do ítem[i].
		 * Dessa forma a tabela é organizada do maior para o menor
		 * levando em conta o id do produto.
		 */
		for(int i = 0; i < getTabela().size() - 1; i++) {
			for(int j = i + 1; j < getTabela().size(); j++) {
				String[] linhaI = getTabela().get(i);
				String[] linhaJ = getTabela().get(j);
				iNum = Integer.parseInt(linhaI[0]);
				jNum = Integer.parseInt(linhaJ[0]);
				if(iNum > jNum) {
					getTabela().add(i, getTabela().remove(j));
				}
			}
		}
	
	}	
	
	/**
	 * Método isEmpty() retorna verdadeiro caso não tenha nenhum produto
	 * no ArrayList.
	 * @return boolean.
	 */
	public boolean isEmpty() {
		return getTabela().isEmpty();
	}
	
	/**
	 * Método remove(row) Remove um ítem de acordo com a linha passada.
	 * @param row Recebe a linha a ser removida. Inicia com 0.
	 * @return retorna false caso não tenha deletado o ítem.
	 */
	public boolean remove(int row) {
		try {
			getTabela().remove(row);
			return true;
		} catch (IndexOutOfBoundsException e) {
			System.err.printf("TabelaTemporaria-Erro ao remover ítem: %s%n", e.getMessage());
			return false;
		}
	}
	
	/**
	 * Método alterarLinha(int row) Retorna um vetor de string contendo os campos da linha
	 * row da TabelaTemporaria.
	 * @param row Recebe o index da linha da TabelaTemporaria a ser retornada. Caso row esteja fora do intervalor de 0 a
	 * TabelaTemporaria.size(), será gerarda um IllegalAgumentException.
	 * @return String[] contendo os campos da linha selecionada.
	 */
	public String[] getLinha(int row) {
		if(row < 0 || row > getTabela().size())
			throw new IllegalArgumentException(String.format("index row fora do tamanho do array. Valor aceito de 0 a %d", getTabela().size()));
		
		return getTabela().get(row);
	}
	
	/**
	 * 
	 * @param row
	 * @param campos
	 * @param valor
	 */
	public void alterarLinha(int row, int[] campos, String... valor) {
		// Verifica se algum dos números dos campos tem um numero de index iválido
		for(int num : campos)
			if(num < 0 || num >= getTabela().get(0).length)
				throw new IllegalArgumentException(String.format("campos[] de valor %d está fora do intervalo permitido que é de 0 a %d", num, (getTabela().get(0).length - 1)));
		// Verifica se a linha é válida
		if(row < 0 || row > getTabela().size())
			throw new IllegalArgumentException(String.format("row fora do intervalo. Intervalo permitido de 0 a %d", getTabela().size()));
		// Verifica se foi passado um campo para cada valor a ser inserido
		if(campos.length != valor.length)
			throw new IllegalArgumentException("Quantide de campos diferente da quantidade de valores inseridos");
		// Verifica se não tem mais campo dq a quantidade de campos do ArrayList<String[]>
		if(valor.length > getTabela().get(0).length)
			throw new IllegalArgumentException(String.format("Quantidade de valores maior que a quantidade de campos de TabelaTemporaria. quantide de campos = ", 
					getTabela().get(0).length));
		
		// Recebe a linha a ser modificada
		String[] linha = getTabela().get(row);
		// Percorre os valores inseridos e modifica os existen no ArrayList<Strig[]>
		for(int i = 0; i < valor.length; i++) {
			linha[campos[i]] = valor[i];
		}
		// Substitui a linha pela nova
		getTabela().remove(row);
		getTabela().add(row, linha);
	}
	
	
	/**
	 * Método preencher(JTable jTable) Preenche uma jTable como os valores inseridos em TabelaTemporaria.
	 * @param jTable
	 */
	public void preencher(JTable jTable2) {
		this.preencher(jTable2, 0);	
	}
	
	/**
	 * Método preencher(JTable jTable, int initArguemn) Preenche uma jTable como os valores inseridos em TabelaTemporaria.
	 * começa preencher o campo da primeira coluna como o valor da coluna[initArgument] de TabelaTemporaria e vai até 
	 * coluna[jTable.getcolumncount()] de Tabela temporaria.
	 * @param jTable
	 * @param initArgument
	 */
	private void preencher(JTable jTable, int initArgument) {
		// Conta a quantidade de colunas da jTable
		int countColumn = jTable.getColumnCount();
		// Cria um vetor de Strings que conterá o nome de cada coluna da jTable
		String[] colunas = new String[countColumn];
		// Cria a matriz Object que conterá os campos para ser inserido na jTable
		Object [][] linhaColunas  = new Object[getTabela().size()][countColumn];
		// preenche o Vetor colunas e a matriz linhasColunas
		for(int i = initArgument; i < (countColumn + initArgument); i++) {
			// Pega o nome das colunas
			colunas[i - initArgument] = jTable.getColumnName(i - initArgument).toString();
			// Pega o valor das linhas de cada coluna
			for(int j = 0; j < getTabela().size(); j++) {
				// pega uma linha do arrayList
				String[] row = getTabela().get(j);
				linhaColunas[j][i - initArgument] = row[i - initArgument];
			}
		}
		jTable.setModel(new javax.swing.table.DefaultTableModel(
	            linhaColunas, colunas));	
	}
	
	
	private ArrayList<String[]> getTabela() {
		if(tabela == null){	
			tabela = new ArrayList<>();	
		}
		return tabela;
	}
}
