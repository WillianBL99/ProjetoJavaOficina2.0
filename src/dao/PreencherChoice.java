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

	
	// -----------------------*** CRIA��O DE OBJETOS
	
	private ResultSet resultSet;
	private ResultSetMetaData resultSetMetaData;		
	private Choice choice;
	
	// -----------------------*** CONSTRUTORES
	
	/**
	 * M�todo PreencherChoice(ResultSet resultSet, Choice choice) Seta os itens do Choice com os valores da
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
	 * M�todo int receberColuna(), recebe uma coluna de uma tabela no banco de dados
	 * e seta os itens de um choice.
	 * @return
	 */
	 private int receberColuna() {
		int status;
		try {
			// Posiciona o resultSet na primera linha da consulta
			getResultSet().first();			
			
			// Realiza a itere��o de todas as linhas da consulta
			do {
				/*
				 * O M�todo getString(String) recebe o nome(na forma que est� no DB) da coluna da tabela do banco de dados,
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
	

	// -----------------------*** M�TODOS GETTERS E SETTERS DA CLASSE
	 
	/*
	 *  M�todo ResultSetMetaData getResultSetMetaData()
	 *  Auxilia na obten��o dos nomes das colunas das tabelas do baco de dados.	 *  
	 */
	private ResultSetMetaData getResultSetMetaData() throws SQLException {
		if(resultSetMetaData == null) {
			resultSetMetaData = (ResultSetMetaData) getResultSet().getMetaData();
		}
		return resultSetMetaData;
	}
	
	
	/**
	 * M�todo getResultSet() Contem o result set com os valores da consulta.
	 * @return Retorna o ResultSet
	 */
	private ResultSet getResultSet() {
		if(this.resultSet == null) {
			System.err.println("Class:PreencherChoice:getResultSet() - Erro: O getResultSet est� null");
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
