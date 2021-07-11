/**
 * 
 */
package dao;
import java.awt.Choice;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

/**
 * @author Paulo Uilian
 *
 */
public class PreencherChoice {

	
	// -----------------------*** CRIAÇÃO DE OBJETOS
	
	private ResultSet resultSet;
	private ResultSetMetaData resultSetMetaData;		
	private Choice choice;
	
	// -----------------------*** CONSTRUTORES
	
	/**
	 * Método PreencherChoice(ResultSet resultSet, Choice choice) Seta os itens do Choice com os valores da
	 * coluna da consulta sql.
	 * @param resultSet
	 * @param choice
	 */
	public PreencherChoice(ResultSet resultSet, Choice choice) {
		setResultSet(resultSet);
		setChoice(choice);
		receberColuna();
	}
	
	
	/**
	 * Método int receberColuna(), recebe uma coluna de uma tabela no banco de dados
	 * e seta os itens de um choice.
	 * @return
	 */
	 private int receberColuna() {
		int status;
		try {
			// Posiciona o resultSet na primera linha da consulta
			getResultSet().first();			
			
			// Realiza a itereção de todas as linhas da consulta
			do {
				/*
				 * O Método getString(String) recebe o nome(na forma que está no DB) da coluna da tabela do banco de dados,
				 * e retorna o valor da coluna na linha atual.
				 */
				String itens = getResultSet().getString(getResultSetMetaData().getColumnName(1));
				getChoice().add(itens + "                       ");
				
			}while(getResultSet().next());
			status = 1;
					
		} catch (SQLException e) {
			status = 0;
			System.err.println("Class-PreencherChoice: receberColuna() - erro: " + e.getMessage());
		}		
		return status;
	}
	

	// -----------------------*** MÉTODOS GETTERS E SETTERS DA CLASSE
	 
	/*
	 *  Método ResultSetMetaData getResultSetMetaData()
	 *  Auxilia na obtenção dos nomes das colunas das tabelas do baco de dados.	 *  
	 */
	private ResultSetMetaData getResultSetMetaData() throws SQLException {
		if(resultSetMetaData == null) {
			resultSetMetaData = (ResultSetMetaData) getResultSet().getMetaData();
		}
		return resultSetMetaData;
	}
	
	
	/**
	 * Método getResultSet() Contem o result set com os valores da consulta.
	 * @return Retorna o ResultSet
	 */
	private ResultSet getResultSet() {
		if(this.resultSet == null) {
			System.err.println("Class:PreencherChoice:getResultSet() - Erro: O getResultSet está null");
		}		
		return resultSet;
	}
	
	
	private void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	
	
	private Choice getChoice() {
		if(this.choice == null) {
			this.choice = new Choice();
		}
		return choice;
	}
	
	
	private void setChoice(Choice choice) {
		this.choice = choice;
	}
}
