/**
 * 
 */
package control;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import dao.DaoJDialogCadastrarCliente;
import model.Mascara;
import view.JDialogCadastrarCliente;
import view.JDialogProcurarCliente;
import view.JFramePrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJDialogCadastrarCliente implements MouseListener, KeyListener, WindowListener, FocusListener{
	
	//** Início declaração de variáveis **
	private JFramePrincipal jFramePrincipal;
	private DaoJDialogCadastrarCliente daoJDialogCadastrarCliente;
	private JDialogProcurarCliente jDialogProcurarCliente;
	private JDialogCadastrarCliente jDialogCadastrarCliente;	
	private boolean modal;
	
	//** Fim declaração de variáveis **	
	public ControlJDialogCadastrarCliente(JFramePrincipal jFramePricipal, JDialogProcurarCliente jDialogProcurarCliente, JDialogCadastrarCliente jDialogCadastrarCliente) {	
		this.jFramePrincipal = jFramePricipal;
		this.jDialogProcurarCliente = jDialogProcurarCliente;
		this.jDialogCadastrarCliente = jDialogCadastrarCliente;
		setmodal(this.jDialogProcurarCliente.ismodalTela());
		AddEvent();
	}


	private void AddEvent() {
		getjDialogCadastrarCliente().addWindowListener(this);
		getjDialogCadastrarCliente().getjButtonCadastrarCliente().addMouseListener(this);
		getjDialogCadastrarCliente().getjButtonCancelar().addMouseListener(this);
		
		getjDialogCadastrarCliente().getjTFieldCpf().addFocusListener(this);
		getjDialogCadastrarCliente().getjTFieldTelefone().addFocusListener(this);
		
		
		
		
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
		// Quando o botão cadastrar cliente for clicado
		if(e.getSource() == getjDialogCadastrarCliente().getjButtonCadastrarCliente()) {
		
			// Se o cadastro for bem sucedido o método cadastrarCliente() retorna o valor 1
			if(getdaoCadastrarCliente().cadastrarCliente()) {
				// Exibe uma mensagem de confirmação do cadastro.
				JOptionPane.showConfirmDialog(
						getjDialogProcurarCliente(), // componente
						"Cadastro realizado com sucesso!.", // texto
						"Cadastro realizado.", // titulo
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
				// limpa os campos da tela de cadastro de clientes.
				limpaCampos();
				getjDialogCadastrarCliente().dispose();
				getjDialogProcurarCliente().setEnabled(true);;
			}
		}
		
		// Quando o botão cancelar for clicado
		else if(e.getSource() == getjDialogCadastrarCliente().getjButtonCancelar()) {
			// se todos os campos estiverem vazios a tela será fechada sem exibir alerta
			if(camposIsEmpty()) {	
				getjDialogProcurarCliente().setEnabled(true);
				getjDialogCadastrarCliente().dispose();
			} 
			
			// se algum campo ter algum caracter será exibida uma menssagem de alerta
			else {

				/*
				 * Quando o botão cancelar da tela cadastrar cliente for clicado ele irá 
				 * exibir uma caixa de dialogo perguntando se realmente deseja sair
				 */
				// Vetor de String com os nomes das opções que apareceram no joptionpane.
				String[] options = {"Sim", "Cancelar"}; 
				
				/*
				 * int option
				 * recebe 0 ou 1 de acordo com a mensagem selecionada
				 * - 0: Foi secionada a opção Sim
				 * - 1: Foi selecionada a opção Cancelar
				 */
				int option = JOptionPane.showOptionDialog(
						getjDialogProcurarCliente(), // tela pai
						"Todas as informaçoes digitadas serão perdidas.Tem certesa que deseja sair sem cadastrar o cliente?", // mensagem
						"Alerta", // título
						JOptionPane.DEFAULT_OPTION, 
						JOptionPane.INFORMATION_MESSAGE,
						null,
						options,
						options[1]); // opção selecionada inicialmente
				
				// Se foi confirmado o cancelamento (option == 0) a tela procurar cliente será fechada
				if(option == 0) {
					getjDialogProcurarCliente().setEnabled(true);
					getjDialogProcurarCliente().dispose();
					
				}
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
		this.getjDialogProcurarCliente().setEnabled(!ismodal());
	}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.getjDialogProcurarCliente().setEnabled(true);
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jDialogCadastrarCliente.getjTFieldCpf() ) {
			
			Mascara.setMascara(jDialogCadastrarCliente.getjTFieldCpf(), Mascara.mascaraCPF());
		
		}
		
		if(e.getSource() == jDialogCadastrarCliente.getjTFieldTelefone() ) {
			
			Mascara.setMascara(jDialogCadastrarCliente.getjTFieldTelefone(), Mascara.mascaraTelefone());
		
		}
		
	}


	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
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
	

	public JFramePrincipal getjFramePricipal() {
		if(jFramePrincipal == null){
			jFramePrincipal = new JFramePrincipal();
		}
		return jFramePrincipal;
	}
	
	
	public JDialogCadastrarCliente getjDialogCadastrarCliente() {
		if(jDialogCadastrarCliente == null){
			jDialogCadastrarCliente = new JDialogCadastrarCliente(getjFramePricipal(), true);
		}
		return jDialogCadastrarCliente;
	}
	
	
	public JDialogProcurarCliente getjDialogProcurarCliente() {
		if(jDialogProcurarCliente == null){
			jDialogProcurarCliente = new JDialogProcurarCliente(getjFramePricipal(), true);
		}
		return jDialogProcurarCliente;
	}
	
	
	public DaoJDialogCadastrarCliente getdaoCadastrarCliente() {
		if(daoJDialogCadastrarCliente == null){
			daoJDialogCadastrarCliente = new DaoJDialogCadastrarCliente(getjFramePricipal(), getjDialogCadastrarCliente());
		}
		return daoJDialogCadastrarCliente;
	}
	
	
	public boolean ismodal() {
		return modal;
	}
	
	
	public void setmodal(boolean modal) {
		this.modal = modal;
	}		
	
	/**
	 * Método camposIsEmpty() verifica se todos os 
	 * campos da tela cadastrar cliente estão vazios.
	 * @return boolean // Se todos os capos de cadastrar clientes estiverem
	 * vazios será retornado o valor true
	 */
	private boolean camposIsEmpty() {
				
		if(
			getjDialogCadastrarCliente().getjTFieldCpf().getText().replace(".", "").replace("-", "").replace(" ", "").isEmpty() &&
			getjDialogCadastrarCliente().getjTFieldNome().getText().isEmpty() &&
			getjDialogCadastrarCliente().getjTFieldTelefone().getText().replace("(", "").replace(")", "").replace(".", "").replace(" ", "").replace("-", "").isEmpty() &&
			getjDialogCadastrarCliente().getjTFieldEmail().getText().isEmpty() &&
			getjDialogCadastrarCliente().getjTFieldCidade().getText().isEmpty() &&
			getjDialogCadastrarCliente().getjTFieldBairro().getText().isEmpty() &&
			getjDialogCadastrarCliente().getjTFieldRua().getText().isEmpty() &&
			getjDialogCadastrarCliente().getjTFieldNumeroCasa().getText().isEmpty()
		) {
			return true;
		} else {
			return false;
		}
	}
	
	private void limpaCampos() {
		getjDialogCadastrarCliente().getjTFieldCpf().setText("");
		getjDialogCadastrarCliente().getjTFieldNome().setText("");
		getjDialogCadastrarCliente().getjTFieldTelefone().setText("");
		getjDialogCadastrarCliente().getjTFieldEmail().setText("");
		getjDialogCadastrarCliente().getjTFieldCidade().setText("");
		getjDialogCadastrarCliente().getjTFieldBairro().setText("");
		getjDialogCadastrarCliente().getjTFieldRua().setText("");
		getjDialogCadastrarCliente().getjTFieldNumeroCasa().setText("");
	}
	//** Fim métodos da classe **



	

}