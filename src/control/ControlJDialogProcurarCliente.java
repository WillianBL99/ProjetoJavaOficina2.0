/**
 * 
 */
package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.ComandosSQL;
import dao.DaoJDialogProcurarCliente;
import view.JDialogCadastrarCliente;
import view.JDialogProcurarCliente;
import view.JFramePrincipal;
import view.JPanelPreOrcamentoNovo;

/**
 * @author Perseu
 *
 */
public class ControlJDialogProcurarCliente implements MouseListener, KeyListener, WindowListener{
	
	//** In�cio declara��o de vari�veis **
	private JFramePrincipal jFramePrincipal;
	private JDialogProcurarCliente jDialogProcurarCliente;
	private JPanelPreOrcamentoNovo jPanelPreOrcamentoNovo;
	private DaoJDialogProcurarCliente daoJDialogProcurarCliente;
	private JDialogCadastrarCliente jDialogCadastrarCliente;
	private ControlJDialogCadastrarCliente controlJDialogCadastrarCliente;
	private ControlJpanelPreOrcamentoNovo controlJpanelPreOrcamentoNovo;
	private boolean modal;
	private int coutWindowAtivated; // Verifica se a tela ja foi ativada antes
	
	//** Fim declara��o de vari�veis **	
	
	public ControlJDialogProcurarCliente(JFramePrincipal jFramePricipal, JDialogProcurarCliente jDialogProcurarCliente,
			JPanelPreOrcamentoNovo jPanelPreOrcamentoNovo, ControlJpanelPreOrcamentoNovo controlJpanelPreOrcamentoNovo) {	
		this.jFramePrincipal = jFramePricipal;	
		this.jPanelPreOrcamentoNovo = jPanelPreOrcamentoNovo;
		this.jDialogProcurarCliente = jDialogProcurarCliente;
		this.controlJpanelPreOrcamentoNovo = controlJpanelPreOrcamentoNovo;
		AddEvent();
		setmodal(getjDialogProcurarCliente().ismodalTela());
	}


	private void AddEvent() {
		getjDialogProcurarCliente().addWindowListener(this);
		getjDialogProcurarCliente().getjButtonPesquisar().addMouseListener(this);
		getjDialogProcurarCliente().getjButtonNovoCliente().addMouseListener(this);
		getjDialogProcurarCliente().getjButtonCancelar().addMouseListener(this);
		getjDialogProcurarCliente().getjButtonSelecionar().addMouseListener(this);
		getjDialogProcurarCliente().getjTextFieldCampoPesquisa().addKeyListener(this);
		
	}
		
		
	//** In�cio m�todos sobrescritos **
	@Override
	public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
			
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
			
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
			
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// quando o bot�o de pesquisar for clicado na tela de proucar clientes
		if(e.getSource() == getjDialogProcurarCliente().getjButtonPesquisar()) {
			// ser a caixa de texto estiver vazia exibe uma mensagem de alerta
			if(!getjDialogProcurarCliente().getjTextFieldCampoPesquisa().getText().isEmpty()) {
				/*
				 * Cliente pode ser procurado de tr�s formas diferentes
				 * - Nome - Realiza uma query retornando todos os clientes com o nome inserido
				 * - CPF - Executa uma query que retorna os dados do cliente com o numero do cpf inserido
				 * - CNPj - Executa uma query que retorna os dados do cliente com o numero do cnpj inserido
				 */

				switch (getjDialogProcurarCliente().getjComboBoxPesquisa().getSelectedItem().toString()) {
				
				
				// procurando cliente pelo nome
				case "Nome": 
					/*
					 * O m�todo getdaoJDialogProcurarCliente().getClienteNome(nome) retorna falso caso a consulta no banco de
					 * dados n�o retorne nenhuma linha
					 */
					if(!getdaoJDialogProcurarCliente().getClienteNome(getjDialogProcurarCliente().getjTextFieldCampoPesquisa().getText())) {
						JOptionPane.showConfirmDialog(
								jDialogProcurarCliente, // componente
								"N�o foi encontrado nenhum cliente com o nome procurardo.", // texto
								"Alerta", // titulo
								JOptionPane.DEFAULT_OPTION, // bot�es
								JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
						);
					}					
					break;
					
					
				// procurando cliente pelo CPF
				case "CPF":
					/*
					 * O m�todo getdaoJDialogProcurarCliente().getClienteCpf(cpf) retorna falso caso a consulta no banco de
					 * dados n�o retorne nenhuma linha
					 */
					if(!getdaoJDialogProcurarCliente().getClienteCpf(getjDialogProcurarCliente().getjTextFieldCampoPesquisa().getText())) {
						JOptionPane.showConfirmDialog(
								jDialogProcurarCliente, // componente
								"N�o foi encontrado nenhum cliente com o CPF procurardo.", // texto
								"Alerta", // titulo
								JOptionPane.DEFAULT_OPTION, // bot�es
								JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
						);
					}
					break;
					
					
				// procurando cliente pelo CNPj
				case "CNPj":
					/*
					 * O m�todo getdaoJDialogProcurarCliente().getClienteCnpj(cnpj) retorna falso caso a consulta no banco de
					 * dados n�o retorne nenhuma linha
					 */
					if(!getdaoJDialogProcurarCliente().getClienteCnpj(getjDialogProcurarCliente().getjTextFieldCampoPesquisa().getText())) {
						JOptionPane.showConfirmDialog(
								jDialogProcurarCliente, // componente
								"N�o foi encontrado nenhum cliente com o CNPj procurardo.", // texto
								"Alerta", // titulo
								JOptionPane.DEFAULT_OPTION, // bot�es
								JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
						);
					}
					break;
				}
				
			} else {
				// exibe uma mensage avisando que a caixa de texto est� vasia
				JOptionPane.showMessageDialog(getjDialogProcurarCliente(),
					    "A caixa de texto esta vazia. Preencha e pesquise novamente.",
					    "Erro na consulta",
					    JOptionPane.WARNING_MESSAGE);
			}
		}

		
		// Quando o bot�o novo cliente na tela procurar clientes for clicado
		else if(e.getSource() == getjDialogProcurarCliente().getjButtonNovoCliente()) {
			/*
			 * Exibe uma mensagem de pergunta se a pessoa quer adicionar um novo cliente.
			 * Caso seja confirmada a escolha sera aberta uma novo jdialog para cadastrar
			 * um novo cliente.
			 */
			
			// Vetor de String contendo os nomes das op��es do JOptionpane abaixo.
			String options[] = {"Sim", "Cancelar"};
			
			/*
			 * int option
			 * recebe 0 ou 1 de acordo com a mensage selecionada
			 * - 0: Foi secionada a op��o ok
			 * - 1: Foi selecionada a op��o cancelar
			 */
			int option = JOptionPane.showOptionDialog(
					jDialogProcurarCliente,
					"Voc� deseja adiconar um novo cliente � lista de clientes?", // texto
					"Alerta", // t�tulo
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null,
					options,
					options[1]);
			
			/*
			 * Caso a condicional seja verdadeira, ser� aberta a tela de 
			 * cadastro de clientes.
			 * Caso contraio a o joptionpane ser� fechado.
			 */
			if (option == 0) {
				jDialogCadastrarCliente = null;
				controlJDialogCadastrarCliente = null;
				getjDialogCadastrarCliente();
				getcontrolJDialogCadastrarCliente();
			}
			
		}
		
		// Quando o bot�o selecionar cliente na tela procurar clientes for clicado
		else if(e.getSource() == getjDialogProcurarCliente().getjButtonSelecionar()) {
			/*
			 *  Verifica se foi selecionado algum cliente
			 *  se getSelectedRow() retornar um numero menor que 0 
			 *  siguinifica que nenhuma linha foi selecionada
			 */
			if(getjDialogProcurarCliente().getjTableCliente().getSelectedRow() < 0) {
				JOptionPane.showConfirmDialog(
						jDialogProcurarCliente, // componente
						"Selecione um cliente primeiro.", // texto
						"Alerta", // titulo
						JOptionPane.DEFAULT_OPTION, // bot�es
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);

			} else {
				preencherPreOrcamentoNovoCliente(getjDialogProcurarCliente().getjTableCliente().getValueAt(
						getjDialogProcurarCliente().getjTableCliente().getSelectedRow(),
						0).toString());
				limparCamposVeiculo(); // limpar dados do veiculo selecionado anteriormente.
				getcontrolControlJpanelPreOrcamentoNovo().setClienteInserido(true);
				getjFramePricipal().setEnabled(true);
				getjDialogProcurarCliente().dispose();
			}
			
		// Quando o bot�o cancelar na tela procurar clientes for clicado
		} else if(e.getSource() == getjDialogProcurarCliente().getjButtonCancelar()) {
			/*
			 * Quando o bot�o cancelar da tela procurar cliente for clicado ele ira fechar a tela
			 * e perguntar se quer realmente que feche sem selecionar um cliente.
			 */
			// Vetro de String com os nomes das op��es que apareceram no joptionpane.
			String[] options = {"OK", "Cancelar"}; 
			
			/*
			 * int option
			 * recebe 0 ou 1 de acordo com a mensage selecionada
			 * - 0: Foi secionada a op��o ok
			 * - 1: Foi selecionada a op��o cancelar
			 */
			int option = JOptionPane.showOptionDialog(
					getjDialogProcurarCliente(), // tela pai
					"Nenhum cliente foi selecionado. Deseja sair?", // mensagem
					"Alerta", // t�tulo
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.INFORMATION_MESSAGE,
					null,
					options,
					options[1]); // op��o selecionada inicialmente
			
			// Se foi confirmado o cancelamento (option == 0) a tela procurar cliente ser� fechada
			if(option == 0) {
				getjFramePricipal().setEnabled(true);
				getjDialogProcurarCliente().dispose();
				
			}
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
			
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
			
	}
	

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
			
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
			
	}	
	
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		this.getjFramePricipal().setEnabled(!isModal());
	}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.getjFramePricipal().setEnabled(true);
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowClosed");
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowIconified");
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeiconified");
		
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		// verifica se a caixa foi ou n�o exibida anteriormente
		if(getcountWindowAtivated() == 3) {
			setcouWindowAtivated(0);
		}
		if(getcountWindowAtivated() < 1) {
			/*
			 * adiciona um � countwindowativated para evitar que a caixa de texto seja exibida
			 * novamente assim que essa for fechada
			 */
			setcouWindowAtivated(1); 
			/*
			 * O m�todo getdaoJDialogProcurarCliente() retorna falso caso a consulta no banco de
			 * dados n�o retorne nenhuma linha
			 */
			if(!getdaoJDialogProcurarCliente().getClienteTodos()) {
				/*
				 * Quando a tela procurar cliente for chamada e nao ter nenhum cliente cadastrado
				 * ser� exibida uma caxa de di�logo perguntando se quer cadastrar um cliente.
				 */
				// Vetor de String com os nomes das op��es que apareceram no joptionpane.
				String[] options = {"Sim", "Cancelar"}; 
				
				/*
				 * int option
				 * recebe 0 ou 1 de acordo com a mensage selecionada
				 * - 0: Foi secionada a op��o Sim
				 * - 1: Foi selecionada a op��o Cancelar
				 */
				int option = JOptionPane.showOptionDialog(
						getjDialogProcurarCliente(), // tela pai
						"N�o foi encontrado nenhum cliente cadastrado.\n"
						+ "Deseja cadastrar um cliente?", // mensagem
						"Sem Clientes Cadastrados", // t�tulo
						JOptionPane.DEFAULT_OPTION, 
						JOptionPane.INFORMATION_MESSAGE,
						null,
						options,
						options[1]); // op��o selecionada inicialmente
				
				// Se foi confirmado o cancelamento (option == 0) a tela procurar cliente ser� fechada
				if(option == 0) {
					jDialogCadastrarCliente = null;
					controlJDialogCadastrarCliente = null;
					getjDialogCadastrarCliente();
					getcontrolJDialogCadastrarCliente();
					
				}
			}
		} else {
			setcouWindowAtivated(1);
		}
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
		
	//** Fim m�todos sobrescritos **
	
	//** In�cio m�todos da classe **
	
	
	private void preencherPreOrcamentoNovoCliente(String id_cli) {
		getdaoJDialogProcurarCliente().getModuloConexao().
			executeQuery(ComandosSQL.getconsultarClientesTodosCampos(), id_cli);
		try {
			getdaoJDialogProcurarCliente().getModuloConexao().getResultSet().next();
			System.out.println("nome = " + getdaoJDialogProcurarCliente().getModuloConexao().getResultSet().getString(4));
			boolean fisica = (getdaoJDialogProcurarCliente().getModuloConexao().getResultSet().getString(4) == "f�sica"? true : false);
			String id = getdaoJDialogProcurarCliente().getModuloConexao().getResultSet().getString(1);
			String cpf = getdaoJDialogProcurarCliente().getModuloConexao().getResultSet().getString(2);
			String nome = getdaoJDialogProcurarCliente().getModuloConexao().getResultSet().getString(5);
			String tipo = getdaoJDialogProcurarCliente().getModuloConexao().getResultSet().getString(4);
			String telefone = getdaoJDialogProcurarCliente().getModuloConexao().getResultSet().getString(7);
			String email = getdaoJDialogProcurarCliente().getModuloConexao().getResultSet().getString(6);
			String cidade = getdaoJDialogProcurarCliente().getModuloConexao().getResultSet().getString(8);
			String bairro = getdaoJDialogProcurarCliente().getModuloConexao().getResultSet().getString(9);
			String rua = getdaoJDialogProcurarCliente().getModuloConexao().getResultSet().getString(10);
			String numeroCasa = getdaoJDialogProcurarCliente().getModuloConexao().getResultSet().getString(11);
			
			if(fisica) {
				getjPanelPreOrcamentoNovo().getjRadioButtonCnpj().setSelected(true);
				getjPanelPreOrcamentoNovo().getjRadioButtonCpf().setSelected(false);
				
			} else {
				getjPanelPreOrcamentoNovo().getjRadioButtonCnpj().setSelected(false);
				getjPanelPreOrcamentoNovo().getjRadioButtonCpf().setSelected(true);
			}
			
			getjPanelPreOrcamentoNovo().setidCliente(id);
			getjPanelPreOrcamentoNovo().getjTFieldCpf().setText(cpf);
			getjPanelPreOrcamentoNovo().getjTFieldNome().setText(nome);
			getjPanelPreOrcamentoNovo().getjTFieldTipo().setText(tipo);
			getjPanelPreOrcamentoNovo().getjTFieldTelefone().setText(telefone);
			getjPanelPreOrcamentoNovo().getjTFieldEmail().setText(email);
			getjPanelPreOrcamentoNovo().getjTFieldCidade().setText(cidade);
			getjPanelPreOrcamentoNovo().getjTFieldBairro().setText(bairro);
			getjPanelPreOrcamentoNovo().getjTFieldRua().setText(rua);
			getjPanelPreOrcamentoNovo().getjTFieldNumeroCasa().setText(numeroCasa);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getErrorCode());
		}
	}
	
	
	private void limparCamposVeiculo() {
		getjPanelPreOrcamentoNovo().getjTFieldNumeroVeiculo().setText("");
		getjPanelPreOrcamentoNovo().getjTFieldPlaca().setText("");
		getjPanelPreOrcamentoNovo().getjTFieldChassi().setText("");
		getjPanelPreOrcamentoNovo().getjTFieldKMAtual().setText("");
		getjPanelPreOrcamentoNovo().getjTFieldMarca().setText("");
		getjPanelPreOrcamentoNovo().getjTFieldModelo().setText("");
		getjPanelPreOrcamentoNovo().getjTFieldMotor().setText("");
		getjPanelPreOrcamentoNovo().getjTFieldCombustivel().setText("");
		getjPanelPreOrcamentoNovo().getjTFieldCor().setText("");
		getjPanelPreOrcamentoNovo().getjTFieldAno().setText("");
	}
	

	public JFramePrincipal getjFramePricipal() {
		if(jFramePrincipal == null){
			jFramePrincipal = new JFramePrincipal();
		}
		return jFramePrincipal;
	}
	
	
	public JDialogProcurarCliente getjDialogProcurarCliente() {
		if(jDialogProcurarCliente == null){
			jDialogProcurarCliente = new JDialogProcurarCliente(getjFramePricipal(), true);
		}
		return jDialogProcurarCliente;
	}
	
	
	public JPanelPreOrcamentoNovo getjPanelPreOrcamentoNovo() {
		if(jPanelPreOrcamentoNovo == null){
			jPanelPreOrcamentoNovo = new JPanelPreOrcamentoNovo();
		}
		return jPanelPreOrcamentoNovo;
	}
	
	
	public DaoJDialogProcurarCliente getdaoJDialogProcurarCliente() {
		if(daoJDialogProcurarCliente == null){
			daoJDialogProcurarCliente = new DaoJDialogProcurarCliente(getjDialogProcurarCliente());
		}
		return daoJDialogProcurarCliente;
	}
	
	
	public JDialogCadastrarCliente getjDialogCadastrarCliente() {
		if(jDialogCadastrarCliente == null){
			jDialogCadastrarCliente = new JDialogCadastrarCliente(getjDialogProcurarCliente(), true);
			// quando a tela cadastrar cliente for chamada a mensagem de nenhum cliente cadastrado pode ser exibida novamente
			setcouWindowAtivated(1);
		}
		return jDialogCadastrarCliente;
	}
	
	
	public ControlJDialogCadastrarCliente getcontrolJDialogCadastrarCliente() {
		if(controlJDialogCadastrarCliente == null){
			controlJDialogCadastrarCliente = new ControlJDialogCadastrarCliente(getjFramePricipal(), getjDialogProcurarCliente(), getjDialogCadastrarCliente());
		}
		return controlJDialogCadastrarCliente;
	}
	
	
	public ControlJpanelPreOrcamentoNovo getcontrolControlJpanelPreOrcamentoNovo() {
		if(controlJpanelPreOrcamentoNovo == null){
			controlJpanelPreOrcamentoNovo = new ControlJpanelPreOrcamentoNovo(getjFramePricipal(), null, null, getjPanelPreOrcamentoNovo());
		}
		return controlJpanelPreOrcamentoNovo;
	}


	public boolean isModal() {
		return modal;
	}
	
	
	public void setmodal(boolean modal) {
		this.modal = modal;
	}	


	public int getcountWindowAtivated() {
		return coutWindowAtivated;
	}
	
	
	public void setcouWindowAtivated(int coutWindowAtivated) {
		if(coutWindowAtivated == 0) {
			this.coutWindowAtivated = 0;
		} else {
			this.coutWindowAtivated++;
		}
	}	
	//** Fim m�todos da classe **
	

}