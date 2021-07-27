/**
 * 
 */
package dao;
import view.JDialogProcurarVeiculo;
import view.JPanelPreOrcamentoNovo;

/**
 * @author Paulo Uilian
 *
 */
public class DaoJDialogProcurarVeiculo {
	
	// Classe de consulta de dados no banco de dados
	private JDialogProcurarVeiculo jDialogProcurarVeiculo;
	private JPanelPreOrcamentoNovo jPanelPreOrcamentoNovo;
	private ModuloConexao moduloConexao;
	
	public DaoJDialogProcurarVeiculo(JDialogProcurarVeiculo jDialogProcurarVeiculo, JPanelPreOrcamentoNovo jPanelPreOrcamentoNovo) {
		this.jDialogProcurarVeiculo = jDialogProcurarVeiculo;
		this.jPanelPreOrcamentoNovo = jPanelPreOrcamentoNovo;
	}
	
	
	/*
	 *  Método void getveiculoTodos().
	 *  Tem a função de preencher a table depois de executar uma query
	 *  de busca de veiculos através de um cliente.
	 */
	public boolean getveiculoTodos() {
		boolean next;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			String idCliente = getjPanelPreOrcamentoNovo().getidCliente();
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.consultarVeiculoTodosByCliente(), idCliente);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				getjDialogProcurarVeiculo().getjTableVeiculos().setVisible(true);
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjDialogProcurarVeiculo().getjTableVeiculos().
						setModel(new PreencherTabela().
								preencher(getModuloConexao().getResultSet(),
										"Nº Veiculo",
										"Placa",
										"Chassi",
										"Marca",
										"Modelo",
										"Motor",
										"Combustível",
										"Cor",
										"Ano"));
				next = true;
			
			// Se não retornou nenhum valor exibe um caixa de alerta	
			} else {
				next = false;
			}
			
			
		} catch(Exception e) {
			System.out.println("Erro ao setar o jtable de jdialogprocurarveiculo\n" + e);
			next = true; // tenta preencher a tabela mesmo gerando o erro
		}
		return next;
	}
	
	
	/*
	 *  Método void getveiculoPlaca().
	 *  Tem a função de preencher a table depois de executar uma query
	 *  de busca de veiculos através da placa.
	 */
	public boolean getveiculoPlaca(String placa) {
		boolean next;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			String idCliente = getjPanelPreOrcamentoNovo().getidCliente();
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.consultarVeiculoPlacaByCliente(), idCliente, placa);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				getjDialogProcurarVeiculo().getjTableVeiculos().setVisible(true);
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjDialogProcurarVeiculo().getjTableVeiculos().
						setModel(new PreencherTabela().
								preencher(getModuloConexao().getResultSet(),
										"Nº Veiculo",
										"Placa",
										"Chassi",
										"Marca",
										"Modelo",
										"Motor",
										"Combustível",
										"Cor",
										"Ano"));
				next = true;
			
			// Se não retornou nenhum valor exibe um caixa de alerta	
			} else {
				next = false;
			}
			
			
		} catch(Exception e) {
			System.out.println("Erro ao setar o jtable de jdialogprocurarveiculo\n" + e);
			next = true; // tenta preencher a tabela mesmo gerando o erro
		}
		return next;
	}
	
	
	/*
	 *  Método void getveiculoChassi().
	 *  Tem a função de preencher a table depois de executar uma query
	 *  de busca de veiculos através da chassi.
	 */
	public boolean getveiculoChassi(String chassi) {
		boolean next;
		String idCliente = getjPanelPreOrcamentoNovo().getidCliente();
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.consultarVeiculoChassiByCliente(),idCliente, chassi);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				getjDialogProcurarVeiculo().getjTableVeiculos().setVisible(true);
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjDialogProcurarVeiculo().getjTableVeiculos().
						setModel(new PreencherTabela().
								preencher(getModuloConexao().getResultSet(),
										"Nº Veiculo",
										"Placa",
										"Chassi",
										"Marca",
										"Modelo",
										"Motor",
										"Combustível",
										"Cor",
										"Ano"));
				next = true;
			
			// Se não retornou nenhum valor exibe um caixa de alerta	
			} else {
				next = false;
			}
			
			
		} catch(Exception e) {
			System.out.println("Erro ao setar o jtable de jdialogprocurarveiculo\n" + e);
			next = true; // tenta preencher a tabela mesmo gerando o erro
		}
		return next;
	}
	
	
	public void bucarVeiculo(String id) {
		getModuloConexao().executeQuery(
				ComandosSQL.consultarVeiculoID(), id);
	}
	
	// Metodos getters e setters
	
	
	private JDialogProcurarVeiculo getjDialogProcurarVeiculo() {
		if(jDialogProcurarVeiculo == null) {
			jDialogProcurarVeiculo = new JDialogProcurarVeiculo(null, false);
		}
		return jDialogProcurarVeiculo;
	}
	
	private JPanelPreOrcamentoNovo getjPanelPreOrcamentoNovo() {
		if(jPanelPreOrcamentoNovo == null) {
			jPanelPreOrcamentoNovo = new JPanelPreOrcamentoNovo();
		}
		return jPanelPreOrcamentoNovo;
	}
	
	
	public ModuloConexao getModuloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}
		
		return moduloConexao;
	}


}
