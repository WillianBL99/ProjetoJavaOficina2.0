/**
 * 
 */
package dao;

import view.JDialogCadastrarVeiculo;
import view.JFramePrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class DaoJDialogCadastrarVeiculo {
	
	// Classe de consulta de dados no banco de dados
	private JDialogCadastrarVeiculo jDialogCadastrarVeiculo;
	private JFramePrincipal jFramePrincipal;
	private Cadastrar cadastrar;
	
	private String idCliente;
	
	public DaoJDialogCadastrarVeiculo(JFramePrincipal jFramePrincipal, JDialogCadastrarVeiculo jDialogCadastrarVeiculo,
			String idCliente) {
		setidCliente(idCliente);
		this.jFramePrincipal = jFramePrincipal;
		this.jDialogCadastrarVeiculo = jDialogCadastrarVeiculo;
	}
	
	
	/**
	 * Método cadastrarVeiculo() Realiza o cadastro dos veículos
	 * @return boolean insert // se a inserção for bem sussedida será retornado true.
	 * caso contrário, false.
	 */
	public boolean cadastrarVeiculo() {
		boolean insert = false;
		try {
			// Método executeUpdate(query, campos...) retorna verdadeiro caso a inserção seja bem sucedida
			if(
				getModuloConexao().executeUpdate(
					ComandosSQL.getcadastrarVeiculo(),
					getjDialogProcurarVeiculo().getjTFieldChassi().getText().replace(" ", ""), // retira os "." e "-" da string
					getjDialogProcurarVeiculo().getjTFieldPlaca().getText().replace("-", "").replace("/", "").replace(" ", ""),
					getjDialogProcurarVeiculo().getjTFieldKMAtual().getText().replace(" ", ""),
					getjDialogProcurarVeiculo().getjTFieldMarca().getText(),
					getjDialogProcurarVeiculo().getjTFieldModelo().getText(),
					getjDialogProcurarVeiculo().getjTFieldMotor().getText(),
					getjDialogProcurarVeiculo().getChoiceCombustivel().getSelectedItem(),
					getjDialogProcurarVeiculo().getjTFieldCor().getText(),
					getjDialogProcurarVeiculo().getjTFieldAno().getText().replace(" ", ""),
					this.getidCliente()
				)
			)
			// define insert como true caso inserção tenha sido bem executada.
			insert = true;
			
		
			return insert;
		} catch (Exception e) {
			System.err.println("Erro-Class:DaoJDialogCadastrarVeiculo: " + e.getMessage());
			return insert;
		}
	}
	
	
	// Metodos getters e setters
	
	private JFramePrincipal getjFramePrincipal() {
		if(jFramePrincipal == null) {
			jFramePrincipal = new JFramePrincipal();
		}
		return jFramePrincipal;
	}
	
	
	private JDialogCadastrarVeiculo getjDialogProcurarVeiculo() {
		if(jDialogCadastrarVeiculo == null) {
			jDialogCadastrarVeiculo = new JDialogCadastrarVeiculo(getjFramePrincipal(), true);
		}
		return jDialogCadastrarVeiculo;
	}
	
	
	private Cadastrar getModuloConexao() {
		if(cadastrar == null) {
			cadastrar = new Cadastrar();
		}
		return cadastrar;
	}	
	
	
	public String getidCliente() {
		return idCliente;
	}
	
	
	public void setidCliente(String idCliente) {
		this.idCliente = idCliente;
	}
}
