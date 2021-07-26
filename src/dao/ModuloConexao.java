package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

/**
 * 
 * @author Paulo Uilian
 */


public class ModuloConexao {
	
	// Cria��o de objetos da classe
	private static Connection connection;
	private  PreparedStatement preparedStatement;
	private  ResultSet resultSet;
	private ResultSetMetaData resultSetMetaData;
	
	// Construtor
	public ModuloConexao() {
		// "Chama" m�todo para iniciar a conex�o com o banco de dados
		conector();
	}
	
	/**
	 * M�todo conector() respons�vel por estabelecer uma conex�o com o banco de dados
	 * @return Connection
	 */
	public static Connection conector() {
		/*
		 *  Armazenando informa��es referente ao banco de dados
		 */
		String dataBase = "controle_estoque_02"; // nome do banco de dados
		String url = "jdbc:mysql://localhost:3306/" + dataBase; // caminho do conecector jdbc
		String user = "root"; // usu�rio
		String password = "root"; // senha
		
		try {
			// Seta Connection com os dados de conex�o com o banco de dados
			setConnection(DriverManager.getConnection(url, user, password));
			return connection;
			
		} catch (Exception e) {
			System.out.println("Erro-Class:ModuloConexao.conector: " + e.getMessage());
			return null;
		}
	}
	
	
	/**
	 * M�todo executeQuery(sql) uitilizada para execu��o de uma query
	 * @param sql
	 */
	public boolean executeQuery(String sql) {
		return this.executeQuery(sql, null);
	}
		
		
	/**
	 * M�todo executeQuery(sql, campos...) uitilizada para execu��o de uma query
	 * passando capos para serem inseridos na query sql
	 * @param sql
	 * @param campos
	 */
	public boolean executeQuery(String sql, String... campos) {
		int countConnection = 5; // define a quantidade de tentativas de conex�o
		
		/* la�o de repeti��o que tenta realizar uma conex�o
		 * depois de countConnection tentivas sem obter 
		 * conex�o o la�o � fechado
		 */
		do {
			getConnection();
			countConnection--;
			if(countConnection == 0) {
				countConnection = 5;
				break;
			}
		} while(connection == null); 
		
		/*
		 * Caso a conex�o com o banco de dados tenha ocorrida com sucesso
		 * os comandos dentro da condicional ser�o executados.
		 */
		if(connection != null) {

			/*
			 * Inteiro sizeCampos recebe o tamanho do vetor campos
			 * caso o vetor seja null, a variavel sizeCampos receber�
			 * o valor de 0.
			 */
			int sizeCampos = (campos == null ? 0 : campos.length);
			/*
			 * Verifica se a quantidade de "?" na string sql �
			 * compat�vel com a quantidade de strings no vetor campos
			 */
			if (contarCarceter(sql) == sizeCampos) {
				try {
					// Seta o preparedStatmente com o camando sql
					setPreparedStatement(getConnection().prepareStatement(sql,
	                        ResultSet.TYPE_SCROLL_INSENSITIVE, 
	                    ResultSet.CONCUR_UPDATABLE));
					
					/*
					 * O for() abaixo � executado se sizeCampos for maior que 0
					 * Se for, � executados os camandos que realizam as subistiui��o
					 * dos "?" contidos na String sql pelos valores do vetor campos
					 */
					for(int i = 0; i < sizeCampos; i++) {
						System.out.printf("setString(%d, %s)%n", i + 1, campos[i]);
						getPreparedStatement().setString(i + 1, campos[i]); // Substitui o (i + 1)� "?" pelo valor de campos[i]
					}
					
					// Executa a query
					setResultSet(getPreparedStatement().executeQuery());
					
				} catch (Exception e) {
					System.out.println("Erro-Class:ModuloConexao-executeQuery: " + e.getMessage());
					return false;
				}				
				
			} else {
				System.err.println("Erro-Class:ModuloConexao-executeQuery: " + "A quantidade de \"?\" n�o � compativel com a quantidade de comandos inseridos");
			}
			
		}
		return true;
	}
	
	/**
	 * M�todo contarCarceter(sql) para verificar a quantidade de "?" em uma string
	 * @param sql
	 * @return countCaracter
	 */
	private  int contarCarceter(String sql) {
		int countCaracter = 0;
		// Itera a string sql
		for(int i = 0; i < sql.length(); i++) {
			/*
			 * Se encontrar algum '?' na string sql
			 * incrementa 1 no inteiro countCaracter
			 */
			if(sql.charAt(i) == '?') {
				countCaracter++;
			}
		}
		return countCaracter;	
	}

	
	public static Connection getConnection() {
		if(connection == null) {
			connection = ModuloConexao.conector();
		}
		return connection;
	}

	
	public static void setConnection(Connection connection) {
		ModuloConexao.connection = connection;
	}
	

	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}
	

	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}

	
	public ResultSet getResultSet() {
		if(resultSet == null) {
			System.out.println("resultset est� vazio");
		}
		return resultSet;
	}
	

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	
	
	public ResultSetMetaData getResultSetMetaData() throws SQLException {
		if(resultSetMetaData == null) {
			resultSetMetaData = (ResultSetMetaData) getResultSet().getMetaData();
		}
		return resultSetMetaData;
	}
	
	
	public boolean resultSetIsEmpty(){
		// Verificar se a consulta retornou algum valor
		try {
			if(getResultSet().first()) {
				return false;
			} else {
				System.out.println("" + getResultSet().first());
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
	}
	
	
	/**
	 * M�todo String valueAtLine(int index)
	 * @return retorna um campo de uma linha consultada.
	 * @throws SQLException 
	 */
	public String valueAt(int row, int column) throws SQLException {
		// Caso tenha inserido um row incorreto
		if(row > getResultSetMetaData().getColumnCount() - 1)
			throw new ArrayIndexOutOfBoundsException();
		
		// Recebe a quantidade de colunas da tabela
		int qtdColunas = getResultSetMetaData().getColumnCount();
		
		ArrayList<String[]> tabela = new ArrayList<>();	
		
		
		try {
			getResultSet().first();
			do {			
				String[] linha = new String[qtdColunas];
				// Itera pelos campos da linha consultada
				for(int i = 0; i < qtdColunas; i++) {
					// Preenche o object[i] com a linha atual de uma coluna
					linha[i] = getResultSet().getString(getResultSetMetaData().getColumnName(i + 1));
				}	
				tabela.add(linha);
			} while(getResultSet().next());			
			
		} catch (SQLException e) {
			System.err.println("Class-ModuloConexao: valueAt() - erro: " + e.getMessage());
		}
				
		return tabela.get(row)[column];
	}
	
	
	/**
	 * M�todo String valueAtLine(int index)
	 * @return retorna um campo de uma linha consultada.
	 * @throws SQLException 
	 */
	public String valueAtLine(int index) throws SQLException {
		// Caso tenha inserido um index incorreto
		if(index > getResultSetMetaData().getColumnCount() - 1)
			throw new ArrayIndexOutOfBoundsException();
		
		// Recebe a quantidade de colunas da tabela
		int qtdColunas = getResultSetMetaData().getColumnCount();
		// A linha abaixo cria um new Object[quantidade de colunas da tabela]
		String linha[] = new String[qtdColunas];	
		
		try {
			// Posiciona o resultSet na primera linha da consulta
			getResultSet().first();				
			// Itera pelos campos da linha consultada
			for(int i = 0; i < qtdColunas; i++) {
				// Preenche o object[i] com a linha atual de uma coluna
				linha[i] = getResultSet().getString(getResultSetMetaData().getColumnName(i + 1));
			}
			
			
		} catch (SQLException e) {
			System.err.println("Class-ModuloConexao: valueAtLine() - erro: " + e.getMessage());
		}	
		
		// retorna o index desejado da String linha
		return linha[index];
	}

	// M�todos getters e setters
	
	
}
