/**
 * 
 */
package dao;
import view.JDialogCadastrarCliente;

/**
 * @author Paulo Uilian
 *
 */
public class DaoJDialogCadastrarCliente {
	
	// Classe de consulta de dados no banco de dados
	private JDialogCadastrarCliente jDialogCadastrarCliente;
	private Cadastrar cadastrar;
	
	public DaoJDialogCadastrarCliente(JDialogCadastrarCliente jDialogCadastrarCliente) {
		this.jDialogCadastrarCliente = jDialogCadastrarCliente;
	}
	
	
	/**
	 * M�todo cadastrarCliente() Realiza o cadastro dos clientes
	 * @return boolean inseert // se a inser��o for bem sussedida ser� retornado true.
	 * caso contr�rio, 0.
	 */
	@SuppressWarnings("static-access")
	public boolean cadastrarCliente() {
		boolean insert = false;
		try {
			/*
			 * Se o cadatro for realizda com cliente f�sico(utilizando cpf) 
			 * ser� executado a query de inser��o de cliente utilizando cpf.
			 * Caso contrario, ser� executada a query de inser��o de cliente
			 * utilizando o cnpj.
			 */
			if (getjDialogProcurarCliente().getjRadioButtonCpf().isSelected()) {
				// M�todo executeUpdate retorna verdadeiro caso a inser��o seja bem sucedida
				if(getModuloConexao().executeUpdate(
						ComandosSQL.getcadastrarClientesCpf(),
						getjDialogProcurarCliente().getjTFieldCpf().getText().replace(".", "").replace("-", ""), // retira os "." e "-" da string
						getjDialogProcurarCliente().getjTFieldNome().getText(),
						getjDialogProcurarCliente().getjTFieldEmail().getText(),
						getjDialogProcurarCliente().getjTFieldTelefone().getText().replace("(", "").replace(")", "").replace(".", "").replace(" ", ""), // retira os "(", ")", " " e "-" da string
						getjDialogProcurarCliente().getjTFieldCidade().getText(),
						getjDialogProcurarCliente().getjTFieldBairro().getText(),
						getjDialogProcurarCliente().getjTFieldRua().getText(),
						getjDialogProcurarCliente().getjTFieldNumeroCasa().getText()
				))
				// define insert como true caso inser��o tenha sido bem executada.
				insert = true;
				
			} else {
				// M�todo executeUpdate retorna verdadeiro caso a inser��o seja bem sucedida
				if(getModuloConexao().executeUpdate(
						ComandosSQL.getcadastrarClientesCnpj(),
						getjDialogProcurarCliente().getjTFieldCpf().getText().replace(".", "").replace("-", ""), // retira os "." e "-" da string
						getjDialogProcurarCliente().getjLabelNome().getText(),
						getjDialogProcurarCliente().getjTFieldEmail().getText(),
						getjDialogProcurarCliente().getjTFieldTelefone().getText().replace("(", "").replace(")", "").replace(".", "").replace(" ", ""), // retira os "(", ")", " " e "-" da string
						getjDialogProcurarCliente().getjTFieldCidade().getText(),
						getjDialogProcurarCliente().getjTFieldBairro().getText(),
						getjDialogProcurarCliente().getjTFieldRua().getText(),
						getjDialogProcurarCliente().getjTFieldNumeroCasa().getText()
				))
				// define insert como true caso inser��o tenha sido bem executada.
				insert = true;
			}
			return insert;
		} catch (Exception e) {
			System.err.println("Erro-Class:DaoJDialogCadastrarCliente: " + e.getMessage());
			return insert;
		}
	}
	
	
	// Metodos getters e setters
	
	private JDialogCadastrarCliente getjDialogProcurarCliente() {
		if(jDialogCadastrarCliente == null) {
			jDialogCadastrarCliente = new JDialogCadastrarCliente(null, false);
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
