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
	 * M�todo cadastrarCliente() Realiza o cadastro dos clientes
	 * @return boolean inseert // se a inser��o for bem sussedida ser� retornado true.
	 * caso contr�rio, 0.
	 */
	@SuppressWarnings("static-access")
	public boolean cadastrarCliente() {
		String cpf = null;
		String cnpj = null;
		
		boolean insert = false;
		try {
			/*
			 * Se o cadatro for realizda com cliente f�sico(utilizando cpf) 
			 * ser� executado a query de inser��o de cliente utilizando cpf.
			 * Caso contrario, ser� executada a query de inser��o de cliente
			 * utilizando o cnpj.
			 */
			if (getjDialogCadastrarCliente().getjRadioButtonCpf().isSelected())
				// Seta o cpf com seu respectivo valor
				cpf = getjDialogCadastrarCliente().getjTFieldCpf().getText().replaceAll("\\D", ""); // Permite apenas n�meros
	
			else
				cnpj = getjDialogCadastrarCliente().getjTFieldCpf().getText().replaceAll("\\D", ""); // Permite apenas n�meros
			
			if(getModuloConexao().executeUpdate(
					ComandosSQL.cadastrarClientesCnpjCpf(),
					cnpj,
					cpf,
					getjDialogCadastrarCliente().getjTFieldNome().getText(),
					getjDialogCadastrarCliente().getjTFieldEmail().getText(),
					getjDialogCadastrarCliente().getjTFieldTelefone().getText().replaceAll("\\D", ""), // retira os "(", ")", " " e "-" da string
					getjDialogCadastrarCliente().getjTFieldCidade().getText(),
					getjDialogCadastrarCliente().getjTFieldBairro().getText(),
					getjDialogCadastrarCliente().getjTFieldRua().getText(),
					getjDialogCadastrarCliente().getjTFieldNumeroCasa().getText()
			))
			// define insert como true caso inser��o tenha sido bem executada.
			insert = true;
			
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
