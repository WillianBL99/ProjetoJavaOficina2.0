package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * @author Paulo Uilian
 */


public class ModuloConexao {
	
	// Criação de objetos da classe
	private static Connection connection;
	private  PreparedStatement preparedStatement;
	private  ResultSet resultSet;
	
	// Construtor
	public ModuloConexao() {
		// "Chama" método para iniciar a conexão com o banco de dados
		conector();
	}
	
	/**
	 * Método conector() responsável por estabelecer uma conexão com o banco de dados
	 * @return Connection
	 */
	public static Connection conector() {
		/*
		 *  Armazenando informações referente ao banco de dados
		 */
		String dataBase = "controle_estoque_02"; // nome do banco de dados
		String url = "jdbc:mysql://localhost:3306/" + dataBase; // caminho do conecector jdbc
		String user = "root"; // usuário
		String password = "root"; // senha
		
		try {
			// Seta Connection com os dados de conexão com o banco de dados
			setConnection(DriverManager.getConnection(url, user, password));
			return connection;
			
		} catch (Exception e) {
			System.out.println("Erro-Class:ModuloConexao.conector: " + e.getMessage());
			return null;
		}
	}
	
	
	/**
	 * Método executeQuery(sql) uitilizada para execução de uma query
	 * @param sql
	 */
	public void executeQuery(String sql) {
		this.executeQuery(sql, null);
	}
		
		
	/**
	 * Método executeQuery(sql, campos...) uitilizada para execução de uma query
	 * passando capos para serem inseridos na query sql
	 * @param sql
	 * @param campos
	 */
	public void executeQuery(String sql, String... campos) {
		int countConnection = 5; // define a quantidade de tentativas de conexão
		
		/* laço de repetição que tenta realizar uma conexão
		 * depois de countConnection tentivas sem obter 
		 * conexão o laço é fechado
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
		 * Caso a conexão com o banco de dados tenha ocorrida com sucesso
		 * os comandos dentro da condicional serão executados.
		 */
		if(connection != null) {

			/*
			 * Inteiro sizeCampos recebe o tamanho do vetor campos
			 * caso o vetor seja null, a variavel sizeCampos receberá
			 * o valor de 0.
			 */
			int sizeCampos = (campos == null ? 0 : campos.length);
			/*
			 * Verifica se a quantidade de "?" na string sql é
			 * compatível com a quantidade de strings no vetor campos
			 */
			if (contarCarceter(sql) == sizeCampos) {
				try {
					// Seta o preparedStatmente com o camando sql
					setPreparedStatement(getConnection().prepareStatement(sql,
	                        ResultSet.TYPE_SCROLL_INSENSITIVE, 
	                    ResultSet.CONCUR_UPDATABLE));
					
					/*
					 * O for() abaixo é executado se sizeCampos for maior que 0
					 * Se for, é executados os camandos que realizam as subistiuição
					 * dos "?" contidos na String sql pelos valores do vetor campos
					 */
					for(int i = 0; i < sizeCampos; i++) {
						System.out.printf("setString(%d, %s)%n", i + 1, campos[i]);
						getPreparedStatement().setString(i + 1, campos[i]); // Substitui o (i + 1)º "?" pelo valor de campos[i]
					}
					
					// Executa a query
					setResultSet(getPreparedStatement().executeQuery());
					
				} catch (Exception e) {
					System.out.println("Erro-Class:ModuloConexao-executeQuery: " + e.getMessage());
				}				
				
			} else {
				System.out.println("Erro-Class:ModuloConexao-executeQuery: " + "A quantidade de \"?\" não é compativel com a quantidade de comandos inseridos");
			}
			
		}
	}
	
	/**
	 * Método contarCarceter(sql) para verificar a quantidade de "?" em uma string
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
			System.out.println("resultset está vazio");
		}
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	

	// Métodos getters e setters
	
	
}
