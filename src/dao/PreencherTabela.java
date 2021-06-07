package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

/**
 * 
 * @author Paulo Uilian
 *
 */

@SuppressWarnings("serial")
public class PreencherTabela extends AbstractTableModel{

	
	// -----------------------------------------------*** CRIAÇÃO DE OBJETOS
	
	
	private ModuloConexao moduloConexao;
	private ResultSetMetaData resultSetMetaData;
	
	private String[] colunas;
	private String[] colunasPreDef; // quando houver colunas predefinidas
	private ArrayList<Object> linhas;
	
	private boolean renomeandoTitulo; // renomeia o título da tabela do banco de dados com nomes predeterminados
		
	
	// -----------------------------------------------*** CONSTRUTORES
	
	
	/*
	 *  Construtor PreencherTabela()
	 *  - inicia uma conexão assim que criado um objeto da classe.
	 */
	public PreencherTabela() {
		// inicia conexão com o banco de dados
		getModuloConexao();
	}

	
	/*
	 *  Método sobrescrito preencher(@resultSet, @colunas)
	 *  - @resultSet - recebe o resultSet da consulta de um banco de dados.
	 *  - @colunas - recebe os nomes das colunas da tabela.
	 *  
	 *  - recebe o resultSet da query (@resultSet) e o vetor como o nome 
	 *  	de cada coluna da tabela predefinido pelo usuário (@colunas[]).
	 */
	public AbstractTableModel preencher(ResultSet resultSet, String... colunas) {
		setColunasPreDef(colunas);
		// define que será usado os titulos passado pelo parâmetro @colunas[]
		setrenomeandoTitulo(true);
		// chama o cosntrutor principal
		this.preencher(resultSet);
		// retorna o TabelModel
		return this;
	}
	
		
	/*
	 *  Método sobrescrito preencher(@resultSet)
	 *  - @resultSet - recebe o resultSet da consulta de um banco de dados.
	 *  
	 *  - realiza o preencimento da tabela de acordo com os 
	 *  	valores contidos em resultSet.
	 *  
	 */
	public AbstractTableModel preencher(ResultSet resultSet) {
		// seta o resultSet da classe com o resultSet passado por parametro.
		getModuloConexao().setResultSet(resultSet);
		receberTabelaDB();
		return this;
	}
	
	
	/*
	 *  Método receberTabelaDB()
	 *  - realiza obtenão dos dados para insersão na tabela.
	 *  
	 */
	private void receberTabelaDB() {
		try {
			// Posiciona o resultSet na primera linha da consulta
			getModuloConexao().getResultSet().first();
			
			// Recebe a quantidade de colunas da tabela
			int qtdColunas = getResultSetMetaData().getColumnCount();
			
			// Cria e seta o tamanho do vetor de Strings
			String[] nomeColunas = new String[qtdColunas];
			
			// Realiza a itereção de todas as linhas da consulta
			do {
				// A linha abaixo cria um new Object[quantidade de colunas da tabela]
				Object object[] = new Object[qtdColunas];
				
				// Preenche os "espaços" do vetor object
				for(int i = 0; i < qtdColunas; i++) {					
					// Baseado nos estudo da pagina "https://www.guj.com.br/t/resultset-obter-o-nome-da-coluna/216872/2"
					object[i] = getModuloConexao().getResultSet().getString(getResultSetMetaData().getColumnName(i + 1));
					
					// A variável nomeColunas recebe o nome de cada uma das colunas da tabela
					nomeColunas[i] = getResultSetMetaData().getColumnName(i + 1);
				}
				
				// Passa o nome das colunas para uma variável local atraves do metodo set
				if(getColunas() == null) {
					setColunas(nomeColunas);
				}
				
				// Adiciona o object no ArrayListe<Object> linhas
				getLinhas().add(object);
						
			}while(getModuloConexao().getResultSet().next());
			
		} catch (Exception e) {
			JOptionPane.showInternalMessageDialog(null, "Erro ao preencher a tabela\n" + e);
		}		
	}
	
	
	@Override
	/*
	 *  Método getRowCount()
	 *  - Retorna a quantidade de linhas da tabela.
	 *  
	 */
	public int getRowCount() {		
		return getLinhas().size();
	}

	
	@Override
	/*
	 *  Método getRowCount()
	 *  - Retorna a quantidade de colunas da tabela.
	 *  
	 */
	public int getColumnCount() {	
		System.out.println("quantidade de colunas :" + getColunas().length);
		return getColunas().length;
	}

	
	@Override
	/*
	 *  Método getRowCount(@rowIndex, @columnIndex)
	 *  - @rowIndex - Recebe o numero da linha que será consultada.
	 *  
	 *  - @columnIndex - Recebe o numero da coluna que será consultada.
	 *  
	 *  - Retorna o valor encontrado na linha x coluna, solicitado.
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Retorna os valores de uma linha expecífica
		Object[] linha = (Object[])getLinhas().get(rowIndex); 
		// Retorna o valor de uma célula expecífica da linha a cima.
		return linha[columnIndex]; 
	}
	

	/*
	 *  Método String getRowCount(@numColumn)
	 *  - @numColumn - Recebe um numero inteiro que define qual título será retornada.
	 *  
	 *  - Retorna o nome do titulo de uma coluna específica.
	 *  
	 */
	public String getColumnName(int numColumn) {
		/*
		 * se @isrenomeandoTitulo for verdadeiro 
		 * retorna os titulos predefinidos pelo usuário da classe.
		 */
		if(isrenomeandoTitulo()) {
			String[] columnName = getColunasPreDef();
			return columnName[numColumn];
		
		/*
		 * se @isrenomeandoTitulo for falso 
		 * retorna os titulos definidos no banco de dados.
		 */
		} else {
			String[] columnName = getColunas();
			return columnName[numColumn];
		}
	}
	
	
	// -----------------------------------------------*** MÉTODOS GETTERS E SETTERS DA CLASSE
		
	
	/*
	 *  Método String[] getColunas()
	 *  - Retorna um vetor com o nome do titulo de cada coluna da 
	 *  	tabela do banco de dados.
	 *  
	 */
	public String[] getColunas(){
		
		if(colunas == null) {
			try {
				// Recebe a quantidade de colunas da tabela.
				int qtdColunas = getResultSetMetaData().getColumnCount();						
				// Cria e seta o tamanho do vetor de Strings.
				String[] nomeColunas = new String[qtdColunas];
				// Preenche os "espaços" do vetor object.
				for(int i = 0; i < qtdColunas; i++) {					
					// A variável nomeColunas recebe o nome de cada uma das colunas da tabela.
					nomeColunas[i] = getResultSetMetaData().getColumnName(i + 1);
				}				
				// Passa o nome das colunas para uma variável local atraves do metodo set.
				setColunas(nomeColunas);
			} catch (Exception e) {
				System.out.printf("quantidade de colunas no método getColunas: %s %n", e);
				JOptionPane.showMessageDialog(null, "erro em getColunas da classe PreencherTabela ");
			}			
		}		
		return colunas;
	}


	/*
	 *  Método String[] getColunasPreDef()
	 *  - Retorna um vetor com o nome do titulo de cada coluna 
	 *  	predefinido pelo usuário.
	 *  
	 */
	public String[] getColunasPreDef() {
		return colunasPreDef;
	}


	/*
	 *  Método setColunasPreDef(@colunasPreDef[])
	 *  - @colunasPreDef[] - recebe um vetor de String com o nome predefinido pelo usuário
	 *  	de cada coluna da tabela.
	 *  - Seta o valor da variável local @this.colunasPreDef[] com o valor do 
	 *  	parâmetro @colunasPreDef[].
	 *  
	 */
	public void setColunasPreDef(String[] colunasPreDef) {
		this.colunasPreDef = colunasPreDef;
	}


	/*
	 *  Método setColunas(@colunas[])
	 *  - @colunasPreDef[] - recebe um vetor de String com o nome de cada
	 *  	 coluna da tabela do banco de dados.
	 *  
	 *  - Seta o valor da variável local @this.colunas[] com o valor do 
	 *  	parâmetro @colunas[].
	 *  
	 */
	public void setColunas(String[] colunas) {
		this.colunas = colunas;
	}

	
	/*
	 *  Método ArrayList<Object> getLinhas()
	 *  - Retorna um arrayList que é referente ao valor contido em 
	 *  	cada linha da tabela do banco de dados.
	 *  
	 */
	public ArrayList<Object> getLinhas(){
		if(linhas == null) {
			linhas = new ArrayList<>();
		}
		return linhas;
	}
	
	
	/*
	 *  Método setLinhas(@linhas<Object>)
	 *  - @linhas<Object> - recebe um arrayList contendo todas 
	 *  	as linhas da consulta realizada no banco de dados.
	 *  
	 *  - Seta o valor da variável local @this.linhas<Object> com o valor do 
	 *  	parâmetro @linhas<Object>.
	 *  
	 */
	public void setLinhas(ArrayList<Object> linhas) {
		this.linhas = linhas;
	}
	
	
	/*
	 *  Método ModuloConexao getModuloConexao()
	 *  - Retorna retorna uma conexão estabelecida com o banco de dados.
	 *  
	 */
	public ModuloConexao getModuloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}		
		return moduloConexao;
	}
	
	
	/*
	 *  Método ResultSetMetaData getResultSetMetaData()
	 *  - Auxilia na obtenção dos nomes das colunas das tabelas do baco de dados.
	 *  
	 */
	public ResultSetMetaData getResultSetMetaData() throws SQLException {
		if(resultSetMetaData == null) {
			resultSetMetaData = (ResultSetMetaData) getModuloConexao().getResultSet().getMetaData();
		}
		return resultSetMetaData;
	}

	
	/*
	 *  Método isrenomeandoTitulo()
	 *  
	 *  - Retorna um valor booleano.
	 *  
	 *  - true: A classe deixa de usar os nomes originais dos
	 *  	títulos das tabelas para usar nomes predefinidos pelo usuário.  
	 *   
	 *  - false: A classe usa os nomes originais dos
	 *  	títulos das tabelas para usar nomes predefinidos pelo usuário.  
	 */
	public boolean isrenomeandoTitulo() {
		return renomeandoTitulo;
	}
	
	
	/*
	 *  Método setrenomeandoTitulo(@renomeandoTitulo)
	 *  - @renomeandoTitulo - recebe um valor booleano que define se os 
	 *  	nomes das tabelas vão ser personalizados pelo usuário da classe ou não.
	 *  
	 *  - Seta o valor da variável local @this.renomeandoTitulo com o valor do 
	 *  	parâmetro @renomeandoTitulo.
	 */
	public void setrenomeandoTitulo(boolean renomeandoTitulo) {
		this.renomeandoTitulo = renomeandoTitulo;
	}
}
