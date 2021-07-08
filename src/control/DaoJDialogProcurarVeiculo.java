/**
 * 
 */
package control;

import dao.ModuloConexao;
import view.JDialogProcurarVeiculo;

/**
 * @author Paulo Uilian
 *
 */
public class DaoJDialogProcurarVeiculo {
	
	// Classe de consulta de dados no banco de dados
	private JDialogProcurarVeiculo jDialogProcurarVeiculo;
	private ModuloConexao moduloConexao;
	
	public DaoJDialogProcurarVeiculo(JDialogProcurarVeiculo jDialogProcurarVeiculo) {
		this.jDialogProcurarVeiculo = jDialogProcurarVeiculo;
	}
	
	
	
	
	
	// Metodos getters e setters
	
	
	private JDialogProcurarVeiculo getjDialogProcurarCliente() {
		if(jDialogProcurarVeiculo == null) {
			jDialogProcurarVeiculo = new JDialogProcurarVeiculo(null, false);
		}
		
		return jDialogProcurarVeiculo;
	}
	
	
	public ModuloConexao getModuloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}
		
		return moduloConexao;
	}


}
