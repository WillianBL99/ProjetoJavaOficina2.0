package dao;

import javax.swing.JOptionPane;

public class DaoJPanelLogin {
	
	// Classe de consulta de dados no banco de dados
	private ModuloConexao moduloConexao;
	
	
	// recebe o usuario e a senha e realiza a valida��o.
	public boolean loginSenha(String usuario, String senha) {
		// Vari�vel que receber� o comando sql
		String sql;
		// Comando sql. Os "?" ser�o substituidos por valores espec�ficos
		sql = "select * from tbusuarios where usuario =? and senha =?";
		// Tratamento de exce��es no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(sql, new String[]{usuario, senha});
			
			// Se os valores forem encontrados
			if(getModuloConexao().getResultSet().next()) {
				// O usu�rio e senha foram encontrados no banco de dados
				return true;
			} else {
				return false;
			}
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar banco de dados.\n" + e);
			return false;
		}
	}
	

	// Metodos getters e setters
	private ModuloConexao getModuloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}
		
		return moduloConexao;
	}
	
	


}
