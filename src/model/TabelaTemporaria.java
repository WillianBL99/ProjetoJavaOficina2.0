/**
 * 
 */
package model;

import java.util.ArrayList;
import javax.swing.JTable;

/**
 * @author Paulo Uilian
 * @version 1.3
 * Date 07/19/2021
 *
 */
public class TabelaTemporaria {
	
	private ArrayList<String[]> tabela;

	// Construtor para iniciar a classe
	public TabelaTemporaria() {
		getTabela();
	}
	
	
	/**
	 * M�todo inserir(JTable jTable, String... campos) Recebe a tabela onde os @campos passados como parametros 
	 * ser�o exibidos em forma de linha.
	 * As linhas ser�o organizadas de acordo com o n�mero da primeira coluna.
	 * Se Tentar inserir um conjunto de informa��es que tenha o primeiro campo igual ao primeiro campos de inser��es
	 * anteriores vai ser retornado false.
	 * @param jTable Recebe a tabela onde ser�o inseridos os valores
	 * @param campos Recebe os campos que ser�o inseridos na tabela, e a quantidade de parametros passados n�o pode ser menor
	 * que a quantidade de colunas da tabela onde sera�o exibido os valores. Caso insira uma quantidade de campos menor que a quantidade
	 * de colunas da jTable ser� gerada um IllegalArgumentException().
	 * @return boolean
	 */
	public boolean inserir(JTable jTable, String... campos) {// Se inserida uma quantidade de campos menor que a quantidade de colunas de jTable
		if(campos.length < jTable.getColumnCount())
			throw new IllegalArgumentException(String.format("Erro ao setar os par�metros de campos. Quantidade de campos menor que a de colunas. campos.length: %d colunas: ",
					campos.length, jTable.getColumnCount()));
		
		boolean insert = insereLinhaTabela(campos);
		organizar();
		preencherTabela(jTable);
		return insert;
	}
	
	
	/**
	 * M�todo inserir(JTable jTable, int initArgument, int finalArgument, String... campos) Recebe a tabela onde os @campos passados como parametros 
	 * ser�o exibidos em forma de linha.
	 * As linhas ser�o organizadas de acordo com o n�mero da primeira coluna e em seguida enseridas na tabela de acordo com o intervalo
	 * selecionado entre initArgument e a quantidade de colunas da jTable.
	 * Se Tentar inserir um conjunto de informa��es que tenha o primeiro campo igual ao primeiro campos de inser��es
	 * anteriores vai ser retornado false.
	 * @param jTable Recebe a tabela onde ser�o inseridos os valores
	 * @param initArgument Recebe o valor m�nimo de 0 e m�ximo de (campos.lenght() - jTable.getColumnCount()). Caso insira um valor fora desse intevarlo
	 * ser� gerada um IllegalArgumentException().
	 * @param campos Recebe os campos que ser�o inseridos na tabela, e a quantidade de parametros passados n�o pode ser menor
	 * que a quantidade de colunas da tabela onde sera�o exibido os valores. Caso insira uma quantidade de campos menor que a quantidade
	 * de colunas da jTable ser� gerada um IllegalArgumentException().
	 * @return boolean
	 */
	public boolean inserir(JTable jTable, int initArgument, String... campos) {
		// Se initArment for setado incorretamente
		if(initArgument < 0 || initArgument > (campos.length - jTable.getColumnCount()))
			throw new IllegalArgumentException(String.format("Erro ao setar o par�metro initArgument. Valores aceitos de 0 a %d", campos.length - jTable.getColumnCount()));
		
		// Se inserida uma quantidade de campos menor que a quantidade de colunas de jTable
		if(campos.length < jTable.getColumnCount())
			throw new IllegalArgumentException(String.format("Erro ao setar os par�metros de campos. Quantidade de campos menor que a de colunas. campos.length: %d colunas: ",
					campos.length, jTable.getColumnCount()));
		
		// Recebe falso caso o id do produto seja igual ao de algum produto inserido anteriormente
		boolean insert = insereLinhaTabela(campos);
		organizar();
		preencherTabela(jTable, initArgument);
		return insert;
	}
	
	
	/**
	 * M�todo insereLinhaTabela(String... campos) Recebe os valores a serem inseridos em outra tabela
	 * e os passam para um Vetor de String depois de verifica se o numero do primeiro campos j� existe
	 * no ArrayList. Caso tenha retorna false.
	 * @param campos Recebe um n�mero vari�vel de argumentos do tipo String.
	 * @return boolean
	 */	
	private boolean insereLinhaTabela(String... campos) {
		return insereLinhaTabela(0, campos);
	}
	
	
	/**
	 * M�todo insereLinhaTabela(int idex, String... campos) Recebe o vetor de campos que iniciente ser� feita uma verifica��o
	 * se o seu primeiro campo n�o � igual ao campo[idex] de cada linha do ArrayList<String[]> tabela.
	 * @param idex Caso receba 0, ir� inserir o vetor de campos comparando o campo[0] como o campo[0] de cada linha 
	 * do ArrayList<String[]> tabela. Caso receba um n�mero maior que 0, ir� inserir o vetor de campos comparando o campo[0] como o campo[0] de cada linha 
	 * do ArrayList<String[]> tabela, e inserir um campo novo no in�cio do vetor.
	 * @param campos Recebe um n�mero vari�vel de argumentos do tipo String.
	 * @return boolean
	 */	
	private boolean insereLinhaTabela(int idex, String... campos) {
		// recebe false caso tenha alguma linha com o mesmo id inserido
		boolean insert = true;
		// Itera toda o ArrayList getTabela()
		for(int i = 0; i < getTabela().size(); i++) {
			// Recebe a linha atual
			String[] linha = getTabela().get(i);
			// Copara o primeiro campo da linha com o primerio parametro
			System.out.println(linha[idex + 1].replace(" ", "") + " = " + campos[idex].replace(" ", ""));
			if(linha[idex + 1].replace(" ", "").equals(campos[idex].replace(" ", "")))
				insert = false;
		}
		
		// Insere os campos no ArrayList
		if(insert) {
			// Se idex for maior que 0 insere um novo campo no in�cio do array e, em seguida, para o ArrayList<String[]>
			if(idex > 0) {
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
	 * M�todo inserirLinhaIndexAI(JTable jTable, String... campos) Recebe a tabela onde os {@code campo} passados como parametros 
	 * ser�o exibidos em forma de linha e, � essas linhas, ser� inserido o id auto icremento no primeiro campo.
	 * As linhas ser�o organizadas de acordo com a ordem de inser��o.
	 * Se Tentar inserir um conjunto de informa��es que tenha o primeiro {@code campo} igual ao primeiro campo de inser��es
	 * anteriores vai ser retornado false.
	 * @param {@code jTable}  Recebe a tabela onde ser�o inseridos os valores
	 * @param {@code campos} Recebe os campos que ser�o inseridos na tabela, e a quantidade de parametros passados n�o pode ser menor
	 * que a quantidade de colunas da tabela onde ser�o exibidos os valores. Caso insira uma quantidade de campos menor que a quantidade
	 * de colunas da jTable ser� gerada um IllegalArgumentException().
	 * @return boolean retorna false caso j� tenha o mesmo produto cadastrado.
	 */
	public boolean inserirLinhaIndexAI(JTable jTable, int idex, String... campos) {
		
		boolean retorno;
		retorno = insereLinhaTabela(idex, campos);
		
		if(retorno) {
			for(int i = 0; i < getTabela().size(); i++) {
				String[] linha = getTabela().get(i);
				linha[0] = String.format(" %02d", i + 1);
				getTabela().set(i, linha);
			}
		}
		
		return retorno;
	}
	
	/**
	 * O m�todo organizar() Ordena os �tens do ArrayList<String[]> da TabelaTemporaria
	 *  de acordo com o campo[0] (campo que contenha numeros) do vetor de String (String[]).
	 */
	public void organizar() {

		int iNum;
		int jNum;
		
		/*
		 * Faz a verifica��o se o item[i] � maior que o �tem[j].
		 * Se for, remove o �tem[j] e coloca antes do �tem[i].
		 * Dessa forma a tabela � organizada do maior para o menor
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
	 * M�todo isEmpty() retorna verdadeiro caso n�o tenha nenhum produto
	 * no ArrayList.
	 * @return boolean.
	 */
	public boolean isEmpty() {
		return getTabela().isEmpty();
	}
	
	/**
	 * M�todo remove(row) Remove um �tem de acordo com a linha passada.
	 * @param row Recebe a linha a ser removida. Inicia com 0.
	 * @return retorna false caso n�o tenha deletado o �tem.
	 */
	public boolean remove(int row) {
		try {
			getTabela().remove(row);
			return true;
		} catch (IndexOutOfBoundsException e) {
			System.err.printf("TabelaTemporaria-Erro ao remover �tem: %s%n", e.getMessage());
			return false;
		}
	}
	
	/**
	 * M�todo alterarLinha(int row) Retorna um vetor de string contendo os campos da linha
	 * row da TabelaTemporaria.
	 * @param row Recebe o index da linha da TabelaTemporaria a ser retornada. Caso row esteja fora do intervalor de 0 a
	 * TabelaTemporaria.size(), ser� gerarda um IllegalAgumentException.
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
		// Verifica se algum dos n�meros dos campos tem um numero de index iv�lido
		for(int num : campos)
			if(num < 0 || num >= getTabela().get(0).length)
				throw new IllegalArgumentException(String.format("campos[] de valor %d est� fora do intervalo permitido que � de 0 a %d", num, (getTabela().get(0).length - 1)));
		// Verifica se a linha � v�lida
		if(row < 0 || row > getTabela().size())
			throw new IllegalArgumentException(String.format("row fora do intervalo. Intervalo permitido de 0 a %d", getTabela().size()));
		// Verifica se foi passado um campo para cada valor a ser inserido
		if(campos.length != valor.length)
			throw new IllegalArgumentException("Quantide de campos diferente da quantidade de valores inseridos");
		// Verifica se n�o tem mais campo dq a quantidade de campos do ArrayList<String[]>
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
	 * M�todo preencher(JTable jTable) Preenche uma jTable como os valores inseridos em TabelaTemporaria.
	 * @param jTable
	 */
	public void preencherTabela(JTable jTable2) {
		this.preencherTabela(jTable2, 0);	
	}
	
	/**
	 * M�todo preencher(JTable jTable, int initArguemn) Preenche uma jTable como os valores inseridos em TabelaTemporaria.
	 * come�a preencher o campo da primeira coluna como o valor da coluna[initArgument] de TabelaTemporaria e vai at� 
	 * coluna[jTable.getcolumncount()] de Tabela temporaria.
	 * @param jTable
	 * @param initArgument
	 */
	private void preencherTabela(JTable jTable, int initArgument) {
		// Conta a quantidade de colunas da jTable
		int countColumn = jTable.getColumnCount();
		// Cria um vetor de Strings que conter� o nome de cada coluna da jTable
		String[] colunas = new String[countColumn];
		// Cria a matriz Object que conter� os campos para ser inserido na jTable
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
