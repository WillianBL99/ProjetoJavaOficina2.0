/**
 * 
 */
package model;

import java.util.ArrayList;
import javax.swing.JTable;

/**
 * Essa classe é responsável por criar uma tabela para manipular dados temporariamente.
 * Sendo possível: inserir varios campos em uma linha; selecionar quais dos campos inseridos serão exibidos;
 * retirar produtos expecíficos; organizar os produtos; enumerar um campo expecífico e preencher uma tabela.
 * @author Paulo Uilian
 * @version 1.4
 * Date 07/20/2021
 *
 */
public class TabelaTemporaria {
	
	private ArrayList<String[]> tabela;

	// Construtor para iniciar a classe
	public TabelaTemporaria() {
		getTabela();
	}
	
	
	/**
	 * Método inserir(JTable jTable, String... campos) Recebe a tabela onde os {@code campos} passados como um array de String no ArrayList<String[]>.
	 * As linhas serão organizadas como o valor contido em {@code campos[0]}.
	 * Se Tentar inserir um conjunto de informações que tenha o primeiro campo igual ao primeiro campos de inserções
	 * anteriores vai ser retornado false.
	 * @param jTable Recebe a tabela onde serão inseridos os valores
	 * @param campos Recebe os campos que serão inseridos na tabela, e a quantidade de parametros passados não pode ser menor
	 * que a quantidade de colunas da tabela onde seraão exibido os valores. Caso insira uma quantidade de campos menor que a quantidade
	 * de colunas da jTable será gerada um IllegalArgumentException().
	 * @return boolean
	 */
	public boolean inserir(JTable jTable, String... campos) {
		// Se inserida uma quantidade de campos menor que a quantidade de colunas de jTable
		if(campos.length < jTable.getColumnCount())
			throw new IllegalArgumentException(String.format("Erro ao setar os parâmetros de campos. Quantidade de campos menor que a de colunas. campos.length: %d colunas: ",
					campos.length, jTable.getColumnCount()));
		// Retorna falso caso o produto já exista no ArrayList
		boolean insert = insereLinhaTabela(campos);
		organizar();
		preencherTabela(jTable);
		return insert;
	}
	
	
	/**
	 * Método inserir(JTable jTable, int initArgument, int finalArgument, String... campos) Recebe a tabela onde os valores contidos em {@code campos[]} serão para um ArrayList<String[]>.
	 * As linhas serão organizadas na ordem decrescente de acordo com o {@code campos[finalArgument]}.
	 * Ao tentar inserir {@code campos[]} que tenha o {@code campos[initArgument]} igual ao valor de inserções anteriores será retornado falso.
	 * @param {@code jTable} Recebe a tabela onde serão inseridos os valores.
	 * @param {@code initArgument} Recebe o index da coluna de ArrayList<String[]> que será a primeira coluna da {@code jTable}
	 * @param {@code campos[]} Recebe as informações que serão inseridos na tabela, e a quantidade de parametros passados não pode ser menor
	 * que a quantidade de colunas da tabela onde seraão exibido os valores. Caso insira uma quantidade de campos menor que a quantidade
	 * de colunas da jTable será gerada um IllegalArgumentException().
	 * @return boolean
	 */
	/*
	private boolean inserir(JTable jTable, int initArgument, String... campos) {
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
		preencherTabela(jTable, initArgument);
		return insert;
	}
	*/
	
	
	/**
	 * Método insereLinhaTabela(String... campos) Recebe os valores a serem inseridos em outra tabela
	 * e os passam para um Vetor de String depois de verifica se o numero do primeiro campos já existe
	 * no ArrayList. Caso tenha retorna false.
	 * @param campos Recebe um número variável de argumentos do tipo String.
	 * @return boolean
	 */	
	private boolean insereLinhaTabela(String... campos) {
		return insereLinhaTabela(0, campos);
	}
	
	
	/**
	 * Método insereLinhaTabela(int idex, String... campos) Recebe o vetor de campos que iniciente será feita uma verificação
	 * se o seu primeiro campo não é igual ao campo[idex] de cada linha do ArrayList<String[]> tabela.
	 * @param idex Caso receba 0, irá inserir o vetor de campos comparando o campo[0] como o campo[0] de cada linha 
	 * do ArrayList<String[]> tabela. Caso receba um número maior que 0, irá inserir o vetor de campos comparando o campo[0] como o campo[0] de cada linha 
	 * do ArrayList<String[]> tabela, e inserir um campo novo no início do vetor.
	 * @param campos Recebe um número variável de argumentos do tipo String.
	 * @return boolean
	 */	
	private boolean insereLinhaTabela(int index, String... campos) {
		/*
		 * Variável que auxilia na na comparação entre dois arrays. Caso index seja 0
		 * será comparado os primeiros campos dos arrays (linha[0] == campos[0].
		 * Caso seja diferente de 0, será comparado da seguinte forma (linha[index + 1] == campos[index])
		 */
		int k = (index == 0 ? 0 : 1); 
		// recebe false caso tenha alguma linha com o mesmo id inserido
		boolean insert = true;
		// Itera toda o ArrayList getTabela()
		for(int i = 0; i < getTabela().size(); i++) {
			// Recebe a linha atual
			String[] linha = getTabela().get(i);
			// Copara o primeiro campo da linha com o primerio parametro
			System.out.println(linha[index + k].replace(" ", "") + " = " + campos[index].replace(" ", ""));
			if(linha[index + k].replace(" ", "").equals(campos[index].replace(" ", "")))
				insert = false;
		}
		
		// Insere os campos no ArrayList
		if(insert) {
			// Se idex for maior que 0 insere um novo campo no início do array e, em seguida, para o ArrayList<String[]>
			if(index > 0) {
				String[] linha = new String[campos.length + 1];
				for(int i = 1; i <= campos.length; i++) {
					linha[i] = campos[i - 1];
				}
				getTabela().add(linha);
					
			// Passa os campos para o array linha e, em seguida, para o ArrayList<String[]>
			} else {
				String[] linha = campos;
				getTabela().add(linha);
			}
			
		}
		return insert;
	}
	
	
	/**
	 * Método inserirLinhaIndexAI(JTable jTable, String... campos) Recebe a tabela onde os {@code campo} passados como parametros 
	 * serão exibidos em forma de linha e, à essas linhas, será inserido o id auto icremento no primeiro campo.
	 * As linhas serão organizadas de acordo com a ordem de inserção.
	 * Se Tentar inserir um conjunto de informações que tenha o primeiro {@code campo} igual ao primeiro campo de inserções
	 * anteriores vai ser retornado false.
	 * @param {@code jTable}  Recebe a tabela onde serão inseridos os valores
	 * @param {@code campos} Recebe os campos que serão inseridos na tabela, e a quantidade de parametros passados não pode ser menor
	 * que a quantidade de colunas da tabela onde serão exibidos os valores. Caso insira uma quantidade de campos menor que a quantidade
	 * de colunas da jTable será gerada um IllegalArgumentException().
	 * @return boolean retorna false caso já tenha o mesmo produto cadastrado.
	 */
	public boolean inserirLinhaIndexAI(JTable jTable, int idex, String... campos) {
		
		boolean retorno;
		retorno = insereLinhaTabela(idex, campos);
		
		if(retorno) {
			for(int i = 0; i < getTabela().size(); i++) {
				String[] linha = getTabela().get(i);
				// insere o campo que enumera cada linha do ArrayList.
				linha[0] = String.format(" %02d", i + 1);
				getTabela().set(i, linha);
			}
		}
		
		return retorno;
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
	public void preencherTabela(JTable jTable2) {
		this.preencherTabela(jTable2, 0);	
	}
	
	
	/**
	 * Método preencher(JTable jTable, int initArguemn) Preenche uma jTable como os valores inseridos em TabelaTemporaria.
	 * começa preencher o campo da primeira coluna como o valor da coluna[initArgument] de TabelaTemporaria e vai até 
	 * coluna[jTable.getcolumncount()] de Tabela temporaria.
	 * @param jTable
	 * @param initArgument
	 */
	private void preencherTabela(JTable jTable, int initArgument) {
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
				// a primeira coluna de linhaColunas será preenchida com a coluna {@code initArgument} de row[] 
				linhaColunas[j][i - initArgument] = row[i];
			}
		}
		jTable.setModel(new javax.swing.table.DefaultTableModel(
	            linhaColunas, colunas));	
	}
	
	
	public final ArrayList<String[]> getTabela() {
		if(tabela == null){	
			tabela = new ArrayList<>();	
		}
		return tabela;
	}
}
