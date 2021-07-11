/**
 * 
 */
package dao;
import view.JDialogCadastrarCliente;
import view.JFramePrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class DaoJDialogCadastrarCliente {
	
	// Classe de consulta de dados no banco de dados
	private JDialogCadastrarCliente jDialogCadastrarCliente;
	private JFramePrincipal jFramePrincipal;
	private Cadastrar cadastrar;
	
	public DaoJDialogCadastrarCliente(JFramePrincipal jFramePrincipal, JDialogCadastrarCliente jDialogCadastrarCliente) {
		this.jFramePrincipal = jFramePrincipal;
		this.jDialogCadastrarCliente = jDialogCadastrarCliente;
	}
	
	
	
	/**
	 * Método cadastrarCliente() Realiza o cadastro dos clientes
	 * @return boolean inseert // se a inserção for bem sussedida será retornado true.
	 * caso contrário, 0.
	 */
	@SuppressWarnings("static-access")
	public boolean cadastrarCliente() {
		boolean insert = false;
		try {
			/*
			 * Se o cadatro for realizda com cliente físico(utilizando cpf) 
			 * será executado a query de inserção de cliente utilizando cpf.
			 * Caso contrario, será executada a query de inserção de cliente
			 * utilizando o cnpj.
			 */
			if (getjDialogCadastrarCliente().getjRadioButtonCpf().isSelected()) {
				// Método executeUpdate retorna verdadeiro caso a inserção seja bem sucedida
				if(getModuloConexao().executeUpdate(
						ComandosSQL.getcadastrarClientesCpf(),
						getjDialogCadastrarCliente().getjTFieldCpf().getText().replace(".", "").replace("-", ""), // retira os "." e "-" da string
						getjDialogCadastrarCliente().getjTFieldNome().getText(),
						getjDialogCadastrarCliente().getjTFieldEmail().getText(),
						getjDialogCadastrarCliente().getjTFieldTelefone().getText().replace("(", "").replace(")", "").replace(".", "").replace(" ", "").replace("-", ""), // retira os "(", ")", " " e "-" da string
						getjDialogCadastrarCliente().getjTFieldCidade().getText(),
						getjDialogCadastrarCliente().getjTFieldBairro().getText(),
						getjDialogCadastrarCliente().getjTFieldRua().getText(),
						getjDialogCadastrarCliente().getjTFieldNumeroCasa().getText()
				))
				// define insert como true caso inserção tenha sido bem executada.
				insert = true;
				
			} else {
				// Método executeUpdate retorna verdadeiro caso a inserção seja bem sucedida
				if(getModuloConexao().executeUpdate(
						ComandosSQL.getcadastrarClientesCnpj(),
						getjDialogCadastrarCliente().getjTFieldCpf().getText().replace(".", "").replace("-", ""), // retira os "." e "-" da string
						getjDialogCadastrarCliente().getjLabelNome().getText(),
						getjDialogCadastrarCliente().getjTFieldEmail().getText(),
						getjDialogCadastrarCliente().getjTFieldTelefone().getText().replace("(", "").replace(")", "").replace(".", "").replace(" ", "").replace("-", ""), // retira os "(", ")", " " e "-" da string
						getjDialogCadastrarCliente().getjTFieldCidade().getText(),
						getjDialogCadastrarCliente().getjTFieldBairro().getText(),
						getjDialogCadastrarCliente().getjTFieldRua().getText(),
						getjDialogCadastrarCliente().getjTFieldNumeroCasa().getText()
				))
				// define insert como true caso inserção tenha sido bem executada.
				insert = true;
			}
			return insert;
		} catch (Exception e) {
			System.err.println("Erro-Class:DaoJDialogCadastrarCliente: " + e.getMessage());
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
	
	private JDialogCadastrarCliente getjDialogCadastrarCliente() {
		if(jDialogCadastrarCliente == null) {
			jDialogCadastrarCliente = new JDialogCadastrarCliente(getjFramePrincipal(), false);
		}
		return jDialogCadastrarCliente;
	}
	
	
	private Cadastrar getModuloConexao() {
		if(cadastrar == null) {
			cadastrar = new Cadastrar();
		}
		return cadastrar;
	}
}
