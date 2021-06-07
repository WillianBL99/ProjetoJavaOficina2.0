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

	
	// -----------------------------------------------*** CRIA��O DE OBJETOS
	
	
	private ModuloConexao moduloConexao;
	private ResultSetMetaData resultSetMetaData;
	
	private String[] colunas;
	private String[] colunasPreDef; // quando houver colunas predefinidas
	private ArrayList<Object> linhas;
	
	private boolean renomeandoTitulo; // renomeia o t�tulo da tabela do banco de dados com nomes predeterminados
		
	
	// -----------------------------------------------*** CONSTRUTORES
	
	
	/*
	 *  Construtor PreencherTabela()
	 *  - inicia uma conex�o assim que criado um objeto da classe.
	 */
	public PreencherTabela() {
		// inicia conex�o com o banco de dados
		getModuloConexao();
	}

	
	/*
	 *  M�todo sobrescrito preencher(@resultSet, @colunas)
	 *  - @resultSet - recebe o resultSet da consulta de um banco de dados.
	 *  - @colunas - recebe os nomes das colunas da tabela.
	 *  
	 *  - recebe o resultSet da query (@resultSet) e o vetor como o nome 
	 *  	de cada coluna da tabela predefinido pelo usu�rio (@colunas[]).
	 */
	public AbstractTableModel preencher(ResultSet resultSet, String... colunas) {
		setColunasPreDef(colunas);
		// define que ser� usado os titulos passado pelo par�metro @colunas[]
		setrenomeandoTitulo(true);
		// chama o cosntrutor principal
		this.preencher(resultSet);
		// retorna o TabelModel
		return this;
	}
	
		
	/*
	 *  M�todo sobrescrito preencher(@resultSet)
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
	 *  M�todo receberTabelaDB()
	 *  - realiza obten�o dos dados para insers�o na tabela.
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
			
			// Realiza a itere��o de todas as linhas da consulta
			do {
				// A linha abaixo cria um new Object[quantidade de colunas da tabela]
				Object object[] = new Object[qtdColunas];
				
				// Preenche os "espa�os" do vetor object
				for(int i = 0; i < qtdColunas; i++) {					
					// Baseado nos estudo da pagina "https://www.guj.com.br/t/resultset-obter-o-nome-da-coluna/216872/2"
					object[i] = getModuloConexao().getResultSet().getString(getResultSetMetaData().getColumnName(i + 1));
					
					// A vari�vel nomeColunas recebe o nome de cada uma das colunas da tabela
					nomeColunas[i] = getResultSetMetaData().getColumnName(i + 1);
				}
				
				// Passa o nome das colunas para uma vari�vel local atraves do metodo set
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
	 *  M�todo getRowCount()
	 *  - Retorna a quantidade de linhas da tabela.
	 *  
	 */
	public int getRowCount() {		
		return getLinhas().size();
	}

	
	@Override
	/*
	 *  M�todo getRowCount()
	 *  - Retorna a quantidade de colunas da tabela.
	 *  
	 */
	public int getColumnCount() {	
		System.out.println("quantidade de colunas :" + getColunas().length);
		return getColunas().length;
	}

	
	@Override
	/*
	 *  M�todo getRowCount(@rowIndex, @columnIndex)
	 *  - @rowIndex - Recebe o numero da linha que ser� consultada.
	 *  
	 *  - @columnIndex - Recebe o numero da coluna que ser� consultada.
	 *  
	 *  - Retorna o valor encontrado na linha x coluna, solicitado.
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Retorna os valores de uma linha expec�fica
		Object[] linha = (Object[])getLinhas().get(rowIndex); 
		// Retorna o valor de uma c�lula expec�fica da linha a cima.
		return linha[columnIndex]; 
	}
	

	/*
	 *  M�todo String getRowCount(@numColumn)
	 *  - @numColumn - Recebe um numero inteiro que define qual t�tulo ser� retornada.
	 *  
	 *  - Retorna o nome do titulo de uma coluna espec�fica.
	 *  
	 */
	public String getColumnName(int numColumn) {
		/*
		 * se @isrenomeandoTitulo for verdadeiro 
		 * retorna os titulos predefinidos pelo usu�rio da classe.
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
	
	
	// -----------------------------------------------*** M�TODOS GETTERS E SETTERS DA CLASSE
		
	
	/*
	 *  M�todo String[] getColunas()
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
				// Preenche os "espa�os" do vetor object.
				for(int i = 0; i < qtdColunas; i++) {					
					// A vari�vel nomeColunas recebe o nome de cada uma das colunas da tabela.
					nomeColunas[i] = getResultSetMetaData().getColumnName(i + 1);
				}				
				// Passa o nome das colunas para uma vari�vel local atraves do metodo set.
				setColunas(nomeColunas);
			} catch (Exception e) {
				System.out.printf("quantidade de colunas no m�todo getColunas: %s %n", e);
				JOptionPane.showMessageDialog(null, "erro em getColunas da classe PreencherTabela ");
			}			
		}		
		return colunas;
	}


	/*
	 *  M�todo String[] getColunasPreDef()
	 *  - Retorna um vetor com o nome do titulo de cada coluna 
	 *  	predefinido pelo usu�rio.
	 *  
	 */
	public String[] getColunasPreDef() {
		return colunasPreDef;
	}


	/*
	 *  M�todo setColunasPreDef(@colunasPreDef[])
	 *  - @colunasPreDef[] - recebe um vetor de String com o nome predefinido pelo usu�rio
	 *  	de cada coluna da tabela.
	 *  - Seta o valor da vari�vel local @this.colunasPreDef[] com o valor do 
	 *  	par�metro @colunasPreDef[].
	 *  
	 */
	public void setColunasPreDef(String[] colunasPreDef) {
		this.colunasPreDef = colunasPreDef;
	}


	/*
	 *  M�todo setColunas(@colunas[])
	 *  - @colunasPreDef[] - recebe um vetor de String com o nome de cada
	 *  	 coluna da tabela do banco de dados.
	 *  
	 *  - Seta o valor da vari�vel local @this.colunas[] com o valor do 
	 *  	par�metro @colunas[].
	 *  
	 */
	public void setColunas(String[] colunas) {
		this.colunas = colunas;
	}

	
	/*
	 *  M�todo ArrayList<Object> getLinhas()
	 *  - Retorna um arrayList que � referente ao valor contido em 
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
	 *  M�todo setLinhas(@linhas<Object>)
	 *  - @linhas<Object> - recebe um arrayList contendo todas 
	 *  	as linhas da consulta realizada no banco de dados.
	 *  
	 *  - Seta o valor da vari�vel local @this.linhas<Object> com o valor do 
	 *  	par�metro @linhas<Object>.
	 *  
	 */
	public void setLinhas(ArrayList<Object> linhas) {
		this.linhas = linhas;
	}
	
	
	/*
	 *  M�todo ModuloConexao getModuloConexao()
	 *  - Retorna retorna uma conex�o estabelecida com o banco de dados.
	 *  
	 */
	public ModuloConexao getModuloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}		
		return moduloConexao;
	}
	
	
	/*
	 *  M�todo ResultSetMetaData getResultSetMetaData()
	 *  - Auxilia na obten��o dos nomes das colunas das tabelas do baco de dados.
	 *  
	 */
	public ResultSetMetaData getResultSetMetaData() throws SQLException {
		if(resultSetMetaData == null) {
			resultSetMetaData = (ResultSetMetaData) getModuloConexao().getResultSet().getMetaData();
		}
		return resultSetMetaData;
	}

	
	/*
	 *  M�todo isrenomeandoTitulo()
	 *  
	 *  - Retorna um valor booleano.
	 *  
	 *  - true: A classe deixa de usar os nomes originais dos
	 *  	t�tulos das tabelas para usar nomes predefinidos pelo usu�rio.  
	 *   
	 *  - false: A classe usa os nomes originais dos
	 *  	t�tulos das tabelas para usar nomes predefinidos pelo usu�rio.  
	 */
	public boolean isrenomeandoTitulo() {
		return renomeandoTitulo;
	}
	
	
	/*
	 *  M�todo setrenomeandoTitulo(@renomeandoTitulo)
	 *  - @renomeandoTitulo - recebe um valor booleano que define se os 
	 *  	nomes das tabelas v�o ser personalizados pelo usu�rio da classe ou n�o.
	 *  
	 *  - Seta o valor da vari�vel local @this.renomeandoTitulo com o valor do 
	 *  	par�metro @renomeandoTitulo.
	 */
	public void setrenomeandoTitulo(boolean renomeandoTitulo) {
		this.renomeandoTitulo = renomeandoTitulo;
	}
}
