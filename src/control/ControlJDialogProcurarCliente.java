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
import view.JDialogProcurarCliente;
import view.JFramePrincipal;
import view.JPanelPreOrcamentoNovo;

/**
 * @author Perseu
 *
 */
public class ControlJDialogProcurarCliente implements MouseListener, KeyListener, WindowListener{
	
	//** Início declaração de variáveis **
	private JFramePrincipal jFramePrincipal;
	private JDialogProcurarCliente jDialogProcurarCliente;
	private JPanelPreOrcamentoNovo jPanelPreOrcamentoNovo;
	private DaoJDialogProcurarCliente daoJDialogProcurarCliente;
	private boolean modal;
	
	//** Fim declaração de variáveis **	
	
	public ControlJDialogProcurarCliente(JFramePrincipal jFramePricipal, JDialogProcurarCliente jDialogProcurarCliente, JPanelPreOrcamentoNovo jPanelPreOrcamentoNovo) {	
		this.jFramePrincipal = jFramePricipal;	
		this.jPanelPreOrcamentoNovo = jPanelPreOrcamentoNovo;
		this.jDialogProcurarCliente = jDialogProcurarCliente;
		AddEvent();
		setmodal(getjDialogProcurarCliente().ismodalTela());
	}


	private void AddEvent() {
		getjDialogProcurarCliente().addWindowListener(this);
		getjDialogProcurarCliente().getjButtonCancelar().addMouseListener(this);
		getjDialogProcurarCliente().getjButtonPesquisar().addMouseListener(this);
		getjDialogProcurarCliente().getjButtonSelecionar().addMouseListener(this);
		getjDialogProcurarCliente().getjTextFieldCampoPesquisa().addKeyListener(this);
		
	}
		
		
	//** Início métodos sobrescritos **
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
		// quando o botão de pesquisar for clicado na tela de proucar clientes
		if(e.getSource() == getjDialogProcurarCliente().getjButtonPesquisar()) {
			// ser for a caixa de texto estiver vazia exibe uma mensagem de alerta
			if(!getjDialogProcurarCliente().getjTextFieldCampoPesquisa().getText().isEmpty()) {
				/*
				 * Cliente pode ser procurado de três formas diferentes
				 * - Nome - Realiza uma query retornando todos os clientes com o nome inserido
				 * - CPF - Executa uma query que retorna os dados do cliente com o numero do cpf inserido
				 * - CNPj - Executa uma query que retorna os dados do cliente com o numero do cnpj inserido
				 */

				switch (getjDialogProcurarCliente().getjComboBoxPesquisa().getSelectedItem().toString()) {
				
				// procurando cliente pelo nome
				case "Nome":
					getdaoJDialogProcurarCliente().getClienteNome(getjDialogProcurarCliente().getjTextFieldCampoPesquisa().getText());
					break;
					
				// procurando cliente pelo CPF
				case "CPF":
					getdaoJDialogProcurarCliente().getClienteCpf(getjDialogProcurarCliente().getjTextFieldCampoPesquisa().getText());
					break;
					
				// procurando cliente pelo CNPj
				case "CNPj":
					getdaoJDialogProcurarCliente().getClienteCnpj(getjDialogProcurarCliente().getjTextFieldCampoPesquisa().getText());
					break;
				}
				
			} else {
				// exibe uma mensage avisando que a caixa de texto está vasia
				JOptionPane.showMessageDialog(getjDialogProcurarCliente(),
					    "A caixa de texto esta vazia. Preencha e pesquise novamente.",
					    "Erro na consulta",
					    JOptionPane.WARNING_MESSAGE);
			}
			
		
		// Quando o botão selecionar cliente na tela procurar clientes for clicado
		} else if(e.getSource() == getjDialogProcurarCliente().getjButtonSelecionar()) {
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
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);

			} else {
				preencherPreOrcamentoNovoCliente(getjDialogProcurarCliente().getjTableCliente().getValueAt(
						getjDialogProcurarCliente().getjTableCliente().getSelectedRow(),
						0).toString());
				getjFramePricipal().setEnabled(true);
				getjDialogProcurarCliente().dispose();
			}
			
		// Quando o botão cancelar na tela procurar clientes for clicado
		} else if(e.getSource() == getjDialogProcurarCliente().getjButtonCancelar()) {
			/*
			 * Quando o botão cancelar da tela procurar cliente for clicado ele ira fechar a tela
			 * e perguntar se quer realmente que feche sem selecionar um cliente.
			 */
			// Vetro de String com os nomes das opções que apareceram no joptionpane.
			String[] options = {"OK", "Cancelar"}; 
			
			/*
			 * int option
			 * recebe 0 ou 1 de acordo com a mensage selecionada
			 * - 0: Foi secionada a opção ok
			 * - 1: Foi selecionada a opção cancelar
			 */
			int option = JOptionPane.showOptionDialog(getjDialogProcurarCliente(),
					"Nenhum cliente foi selecionado. Deseja sair?", // mensagem
					"Alerta", // título
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null,
					options,
					options[1]); // opção selecionada inicialmente
			
			// Se foi confirmado o cancelamento (option == 0) a tela procurar cliente será fechada
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
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
		
	//** Fim métodos sobrescritos **
	
	//** Início métodos da classe **
	
	
	private void preencherPreOrcamentoNovoCliente(String row) {
		getdaoJDialogProcurarCliente().getModuloConexao().
			executeQuery(ComandosSQL.getconsultarClientesTodosCampos(), row);
		try {
			getdaoJDialogProcurarCliente().getModuloConexao().getResultSet().next();
			System.out.println("nome = " + getdaoJDialogProcurarCliente().getModuloConexao().getResultSet().getString(4));
			
			boolean fisica = (getdaoJDialogProcurarCliente().getModuloConexao().getResultSet().getString(4) == "física"? true : false);
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
			
			getjPanelPreOrcamentoNovo().getjTFieldCpf().setText(cpf);
			getjPanelPreOrcamentoNovo().getjTFieldNome().setText(nome);
			getjPanelPreOrcamentoNovo().getjTFieldTipo().setText(tipo);
			getjPanelPreOrcamentoNovo().getjTFieldTelefone().setText(telefone);
			getjPanelPreOrcamentoNovo().getjTFieldEmail().setText(email);
			getjPanelPreOrcamentoNovo().getjTFieldCidade().setText(cidade);
			getjPanelPreOrcamentoNovo().getjTFieldBairro().setText(bairro);
			getjPanelPreOrcamentoNovo().getjTFieldRua().setText(rua);
			getjPanelPreOrcamentoNovo().getjTFieldNumeroCasa().setText(numeroCasa);
			
			// Fecha a conexão com o banco de dados
			getdaoJDialogProcurarCliente().getModuloConexao().closeConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getErrorCode());
		}
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


	public boolean isModal() {
		return modal;
	}
	
	
	public void setmodal(boolean modal) {
		this.modal = modal;
	}		
	//** Fim métodos da classe **
	

}