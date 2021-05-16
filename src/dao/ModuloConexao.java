package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

/**
 * 
 * @author Paulo Uilian
 */


public class ModuloConexao {
	
	// Cria��o de objetos da classe
	private static Connection connection;
	private  PreparedStatement preparedStatement;
	private  ResultSet resultSet;
	private static boolean conectado;
	
	// Construtor
	public ModuloConexao() {
		// "Chama" m�todo para iniciar a conex�o com o banco de dados
		conector();
	}
	
	// M�todo respons�vel por estabelecer uma conex�o com o banco de dados
	public static Connection conector() {
		// A linha abaixo recebe o caminho do driver de conex�o com o banco de dados
		String driver = "com.mysql.cj.jdbc.Driver";
		
		// Armazenando informa��es referente ao banco de dados
		String url = "jdbc:mysql://localhost:3306/controle_estoque_01";
		String user = "root";
		String password = "root";
		
		// Estabelecendo conex�o com o banco de dados
		try {
			if(!isConectado()) {
				Class.forName(driver);
				// Inicia a conex�o com o banco de dados
				setConnection(DriverManager.getConnection(url, user, password));
				System.out.printf("moduloConexao Conex�o bem sucedida:%n%s",connection); // Uso para testes
				setConectado(true);
			}
			
			return connection;
			
		} catch (Exception e) {
			System.out.printf("Erro ao tentar se conectar com o DB: %s", e); // Uso para testes
			setConectado(false);
			return null;
		}
	}
	
	
	// M�todo uitilizada para execu��o de uma query
	public void executeQuery(String sql) {
		this.executeQuery(sql, null);
	}
		
		
	// M�todo uitilizada para execu��o de uma query
	public void executeQuery(String sql, String[] campos) {
		do {
			System.out.println(".");
			getConnection();
		} while(!isConectado()); 
		
		// Verifica se a quantidade de "?" na string sql �
		// compat�vel com a quantidade de strings no vetor campos
		int sizeCampos = (campos == null ? 0 :campos.length);
		System.out.println(campos.length + " = " + contarCarceter(sql));
		if (contarCarceter(sql) == sizeCampos) {
			
			try {
				// As linhas abaixo realizam a consulta de dados do banco de dados
				setPreparedStatement(getConnection().prepareStatement(sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE));
				
				for(int i = 0; i < sizeCampos; i++) {
					System.out.printf("setString(%d, %s)%n", i + 1, campos[i]);
					getPreparedStatement().setString(i + 1, campos[i]); // Substitui o (i + 1)� "?" pelo valor de campos[i]
				}
				
				// A linha abaixo executa a query
				setResultSet(getPreparedStatement().executeQuery());
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "erro no m�todo executeQuery da classe ModuloConexao\n" + e);
			}
		} else {
			System.out.println("a quantidade de \"?\" n�o � compativel com \na quantidade de comandos inseridos");
		}
		
	}
	
	
	// M�todo para verificar a quantidade de "?" em uma string
	private  int contarCarceter(String sql) {
		// Receber� a quantidade de "?" contido na string sql
		int countCaracter = 0;
		// Itera a string sql
		for(int i = 0; i < sql.length(); i++) {
			// Se a verifica��o for verdadeira adiciona 1 �
			// vari�vel countCaracter
			if(sql.charAt(i) == '?') {
				countCaracter++;
			}
		}
		return countCaracter;	
	}

	
	public static Connection getConnection() {
		if(!isConectado()) {
			System.out.println("Conectando..");
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
		System.out.println("Chamou resultSet\n"+resultSet);
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public static boolean isConectado() {
		return conectado;
	}

	public static void setConectado(boolean conectado) {
		ModuloConexao.conectado = conectado;
	}
	

	// M�todos getters e setters
	
	
}
