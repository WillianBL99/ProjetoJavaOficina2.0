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
	 *  M�todo void getveiculoPlaca().
	 *  Tem a fun��o de preencher a table depois de executar uma query
	 *  de busca de veiculos atrav�s da placa.
	 */
	public void getveiculoPlaca(String placa) {
		
		// Tratamento de exce��es no momento de consulta do banco de dados
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
										"N� Veiculo",
										"Placa",
										"Chassi",
										"Marca",
										"Modelo",
										"Motor",
										"Combust�vel",
										"Cor",
										"Ano"));
			
			// Se n�o retornou nenhum valor exibe um caixa de alerta	
			} else {
				JOptionPane.showConfirmDialog(
						getjDialogProcurarVeiculo(), // componente
						"N�o foi encontrado nenhum ve�culo com a placa procurarda.", // texto
						"Alerta", // titulo
						JOptionPane.DEFAULT_OPTION, // bot�es
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}
			
			
		} catch(Exception e) {
			System.out.println("Erro ao setar o jtable de jdialogprocurarveiculo\n" + e);
		}
	}
	
	
	/*
	 *  M�todo void getveiculoChassi().
	 *  Tem a fun��o de preencher a table depois de executar uma query
	 *  de busca de veiculos atrav�s da chassi.
	 */
	public void getveiculoChassi(String chassi) {
		String idCliente = getjPanelPreOrcamentoNovo().getidCliente();
		// Tratamento de exce��es no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarVeiculoChassiByCliente(),idCliente, chassi);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjDialogProcurarVeiculo().getjTableVeiculos().
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
			
			// Se n�o retornou nenhum valor exibe um caixa de alerta	
			} else {
				JOptionPane.showConfirmDialog(
						getjDialogProcurarVeiculo(), // componente
						"N�o foi encontrado nenhum ve�culo com a chassi procurarda.", // texto
						"Alerta", // titulo
						JOptionPane.DEFAULT_OPTION, // bot�es
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
