/**
 * 
 */
package dao;

import javax.swing.JOptionPane;

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
	 *  Método void getveiculoPlaca().
	 *  Tem a função de preencher a table depois de executar uma query
	 *  de busca de veiculos através da placa.
	 */
	public void getveiculoPlaca(String placa) {
		
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			String idCliente = getjPanelPreOrcamentoNovo().getidCliente();
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarVeiculoPlacaByCliente(), idCliente, placa);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
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
			
			// Se não retornou nenhum valor exibe um caixa de alerta	
			} else {
				JOptionPane.showConfirmDialog(
						getjDialogProcurarVeiculo(), // componente
						"Não foi encontrado nenhum veículo com a placa procurarda.", // texto
						"Alerta", // titulo
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}
			
			
		} catch(Exception e) {
			System.out.println("Erro ao setar o jtable de jdialogprocurarveiculo\n" + e);
		}
	}
	
	
	/*
	 *  Método void getveiculoChassi().
	 *  Tem a função de preencher a table depois de executar uma query
	 *  de busca de veiculos através da chassi.
	 */
	public void getveiculoChassi(String chassi) {
		String idCliente = getjPanelPreOrcamentoNovo().getidCliente();
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarVeiculoChassiByCliente(),idCliente, chassi);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
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
			
			// Se não retornou nenhum valor exibe um caixa de alerta	
			} else {
				JOptionPane.showConfirmDialog(
						getjDialogProcurarVeiculo(), // componente
						"Não foi encontrado nenhum veículo com a chassi procurarda.", // texto
						"Alerta", // titulo
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}
			
			
		} catch(Exception e) {
			System.out.println("Erro ao setar o jtable de jdialogprocurarveiculo\n" + e);
		}
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
