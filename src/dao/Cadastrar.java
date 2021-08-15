/**
 * 
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;
import java.sql.Types;

import com.mysql.cj.MysqlType;

/**
 * @author Paulo Uilian
 *
 */
public class Cadastrar {
	
	/* Cria��o de objetos da classe */
	private ModuloConexao moduloConexao;
	
	/**
	 * M�todo executeUpdate(sql, campos...) Realiza execu��o de uma query de inser��o
	 * @param sql // recebe uma query sql.
	 * @param campos // recebe os valores que ser�o inseridos na query
	 * @return boolean // caso a a inser��o tenha sido bem sucedida retorna verdadeiro
	 */
	@SuppressWarnings("static-access")
	public boolean executeUpdate(String sql, String... campos) {
		String a = null;
		// Vari�vel booleana recebe 'true' caso a inser��o seja bem sucedida
		boolean insert = false;
		/*
		 * Inteiro sizeCampos recebe o tamanho do vetor campos
		 * caso o vetor seja null, a variavel sizeCampos receber�
		 * o valor de 0.
		 */
		int sizeCampos = (campos == null ? 0 : campos.length);
				
		try (PreparedStatement pstmt = getModuloConexao().getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
			// Seta o prepardtatement com o valor de pstmt
			getModuloConexao().setPreparedStatement(pstmt);
			/*
			 * O for() abaixo � executado se sizeCampos for maior que 0
			 * Se for, � executados os camandos que realizam as subistiui��o
			 * dos "?" contidos na String sql pelos valores do vetor campos
			 */
			for(int i = 0; i < sizeCampos; i++) {
				System.out.printf("SetString(%d, %s)%n", i + 1, campos[i]);
				getModuloConexao().getPreparedStatement().setString(i + 1, (campos[i])); // Substitui o (i + 1)enezimo "?" pelo valor de campos[i]
			}
			
			// Inteiro rowAffected recebe a quantidade de linhas afetadas pelo comando
			int rowAffected = getModuloConexao().getPreparedStatement().executeUpdate();
			
			// Caso tenha sido afetada uma linha
			if(rowAffected >= 1){
				System.out.println("Class:Cadastrar-executeUpdate: Inser��o realizada com sucesso");
				insert = true;
			}
			return insert;
		} catch (SQLException ex) {
			System.err.println("Erro-Class:Cadastrar-executeUpdate: " + ex.getMessage());
			return insert;
		} finally {
			// Tenta fechar o resultset
			try {
				if(getModuloConexao().getResultSet() != null) {
					getModuloConexao().getConnection().close();
				}
			} catch (SQLException e) {
				System.err.println("Erro-Class:Cadastrar-executeUpdate: Erro ao fechar o resultSet: " + e.getMessage());
			}
		}
	}
	
	
	public ModuloConexao getModuloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}
		return moduloConexao;
	}
}
