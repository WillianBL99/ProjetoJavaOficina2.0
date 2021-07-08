/**
 * 
 */
package control;

import javax.swing.JOptionPane;

import dao.ComandosSQL;
import dao.ModuloConexao;
import dao.PreencherTabela;
import view.JDialogProcurarCliente;

/**
 * @author Paulo Uilian
 *
 */
public class DaoJDialogProcurarVeiculo {
	
	// Classe de consulta de dados no banco de dados
	private JDialogProcurarCliente jDialogProcurarCliente;
	private ModuloConexao moduloConexao;
	
	public DaoJDialogProcurarVeiculo(JDialogProcurarCliente jDialogProcurarCliente) {
		this.jDialogProcurarCliente = jDialogProcurarCliente;
	}
	
	
	
	
	
	// Metodos getters e setters
	
	
	private JDialogProcurarCliente getjDialogProcurarCliente() {
		if(jDialogProcurarCliente == null) {
			jDialogProcurarCliente = new JDialogProcurarCliente(null, false);
		}
		
		return jDialogProcurarCliente;
	}
	
	
	public ModuloConexao getModuloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}
		
		return moduloConexao;
	}


}
