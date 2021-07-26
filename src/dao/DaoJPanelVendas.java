/**
 * 
 */
package dao;

import view.JPanelVendas;

/**
 * @author Paulo Uilian
 *
 */
public class DaoJPanelVendas {
	
	// Classe de consulta de dados no banco de dados
	private JPanelVendas jPanelVendas;
	private ModuloConexao moduloConexao;
	
	public DaoJPanelVendas(JPanelVendas jPanelVendas) {
		this.jPanelVendas = jPanelVendas;
	}
	
	
	/*
	 *  M�todo void consultarVendas().
	 *  Tem a fun��o de preencher a table depois de executar uma query
	 *  de busca de veiculos atrav�s de um cliente.
	 */
	public boolean consultarVendas() {
		boolean next;
		// Tratamento de exce��es no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.consultarVendasTodasTodas());
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjpJPanelVendas().getjTableVendas().
					setModel(new PreencherTabela().
						preencher(getModuloConexao().getResultSet(),
							"N� Veiculo",
							"Placa",
							"Chassi",
							"Marca",
							"Modelo",
							"Motor",
							"Combust�vel",
							"Cor",
							"Ano"));
				next = true;
			
			// Se n�o retornou nenhum valor exibe um caixa de alerta	
			} else {
				next = false;
			}			
			
		} catch(Exception e) {
			System.out.println("Erro ao setar o jtable de jdialogprocurarveiculo\n" + e);
			next = true; // tenta preencher a tabela mesmo gerando o erro
		}
		return next;
	}
	
	// Metodos getters e setters
	
	
	private JPanelVendas getjpJPanelVendas() {
		if(jPanelVendas == null) {
			jPanelVendas = new JPanelVendas();
		}
		return jPanelVendas;
	}
	
	
	public ModuloConexao getModuloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}
		
		return moduloConexao;
	}


}
