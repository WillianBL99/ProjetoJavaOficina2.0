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
import javax.swing.JOptionPane;
import dao.DaoJDialogCadastrarVeiculo;
import view.JDialogCadastrarVeiculo;
import view.JDialogProcurarVeiculo;
import view.JFramePrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJDialogCadastrarVeiculo implements MouseListener, KeyListener, WindowListener{
	
	//** In�cio declara��o de vari�veis **
	private JFramePrincipal jFramePrincipal;
	private JDialogCadastrarVeiculo jDialogCadastrarVeiculo;
	private DaoJDialogCadastrarVeiculo daoJDialogCadastrarVeiculo;
	private JDialogProcurarVeiculo jDialogProcurarVeiculo;
	private boolean modal;
	
	private String idCliente;
	
	//** Fim declara��o de vari�veis **	
	public ControlJDialogCadastrarVeiculo(JFramePrincipal jFramePricipal, JDialogCadastrarVeiculo jDialogCadastrarVeiculo,
			JDialogProcurarVeiculo jDialogProcurarVeiculo, String idCliente) {	
		this.jFramePrincipal = jFramePricipal;
		this.jDialogCadastrarVeiculo = jDialogCadastrarVeiculo;
		this.jDialogProcurarVeiculo = jDialogProcurarVeiculo;
		
		setidCliente(idCliente);
		
		setmodal(this.jDialogCadastrarVeiculo.ismodalTela());
		AddEvent();
		setmodal(getjDialogCadastrarVeiculo().ismodalTela());
	}


	private void AddEvent() {
		getjDialogCadastrarVeiculo().addWindowListener(this);
		getjDialogCadastrarVeiculo().getjButtonCancelar().addMouseListener(this);
		getjDialogCadastrarVeiculo().getjButtonCadastrarVeiculo().addMouseListener(this);
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
		// Quando o bot�o cadastrar veiculo for clicado
		if(e.getSource() == getjDialogCadastrarVeiculo().getjButtonCadastrarVeiculo()) {
			// Se o cadastro for bem sucedido o m�todo cadastrarVeiculo() retorna true
			if(getdaoJDialogCadastrarVeiculo().cadastrarVeiculo()) {
				// Exibe uma mensagem de confirma��o do cadastro.
				JOptionPane.showConfirmDialog(
						getjDialogCadastrarVeiculo(), // componente
						"Cadastro realizado com sucesso!.", // texto
						"Cadastro realizo.", // titulo
						JOptionPane.DEFAULT_OPTION, // bot�es
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
				// limpa os campos da tela de cadastro de clientes.
				limpaCampos();
				getjDialogProcurarVeiculo().setEnabled(true);
				getjDialogCadastrarVeiculo().dispose();
			}
		}
		
		// Quando o bot�o cancelar for clicado
		else if(e.getSource() == getjDialogCadastrarVeiculo().getjButtonCancelar()) {
			// se todos os campos estiverem vazios a tela ser� fechada sem exibir alerta
			if(camposIsEmpty()) {	
				getjDialogProcurarVeiculo().setEnabled(true);
				getjDialogCadastrarVeiculo().dispose();
			} 
			
			// se algum campo ter algum caracter ser� exibida uma menssagem de alerta
			else {

				/*
				 * Quando o bot�o cancelar da tela cadastrar cliente for clicado ele ir� 
				 * exibir uma caixa de dialogo perguntando se realmente deseja sair
				 */
				// Vetor de String com os nomes das op��es que apareceram no joptionpane.
				String[] options = {"Sim", "Cancelar"}; 
				
				/*
				 * int option
				 * recebe 0 ou 1 de acordo com a mensagem selecionada
				 * - 0: Foi secionada a op��o Sim
				 * - 1: Foi selecionada a op��o Cancelar
				 */
				int option = JOptionPane.showOptionDialog(
						getjDialogProcurarVeiculo(), // tela pai
						"Todas as informa�oes digitadas ser�o perdidas.Tem certesa que deseja sair sem cadastrar o ve�culo?", // mensagem
						"Alerta", // t�tulo
						JOptionPane.DEFAULT_OPTION, 
						JOptionPane.INFORMATION_MESSAGE,
						null,
						options,
						options[1]); // op��o selecionada inicialmente
				
				// Se foi confirmado o cancelamento (option == 0) a tela procurar cliente ser� fechada
				if(option == 0) {
					getjDialogProcurarVeiculo().setEnabled(true);
					getjDialogCadastrarVeiculo().dispose();
					
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
		this.getjDialogProcurarVeiculo().setEnabled(!ismodal());
	}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.getjDialogProcurarVeiculo().setEnabled(true);
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
		
	//** Fim m�todos sobrescritos **
	
	//** In�cio m�todos da classe **
	

	public JFramePrincipal getjFramePricipal() {
		if(jFramePrincipal == null){
			jFramePrincipal = new JFramePrincipal();
		}
		return jFramePrincipal;
	}
	
	
	public JDialogCadastrarVeiculo getjDialogCadastrarVeiculo() {
		if(jDialogCadastrarVeiculo == null){
			jDialogCadastrarVeiculo = new JDialogCadastrarVeiculo(getjFramePricipal(), true);
		}
		return jDialogCadastrarVeiculo;
	}
	
	
	public JDialogProcurarVeiculo getjDialogProcurarVeiculo() {
		if(jDialogProcurarVeiculo == null){
			jDialogProcurarVeiculo = new JDialogProcurarVeiculo(getjFramePricipal(), true);
		}
		return jDialogProcurarVeiculo;
	}
	
	
	public DaoJDialogCadastrarVeiculo getdaoJDialogCadastrarVeiculo() {
		if(daoJDialogCadastrarVeiculo == null){
			daoJDialogCadastrarVeiculo = new DaoJDialogCadastrarVeiculo(getjFramePricipal(), getjDialogCadastrarVeiculo(), this.getidCliente());
		}
		return daoJDialogCadastrarVeiculo;
	}
	
	
	public boolean ismodal() {
		return modal;
	}
	
	
	public void setmodal(boolean modal) {
		this.modal = modal;
	}	
	
	
	public String getidCliente() {
		return idCliente;
	}
	
	
	public void setidCliente(String idCliente) {
		this.idCliente = idCliente;
	}	
	
	/**
	 * M�todo camposIsEmpty() verifica se todos os 
	 * campos da tela cadastrar cliente est�o vazios.
	 * @return boolean // Se todos os capos de cadastrar clientes estiverem
	 * vazios ser� retornado o valor true
	 */
	private boolean camposIsEmpty() {
				
		if(
				getjDialogCadastrarVeiculo().getjTFieldChassi().getText().replace(" ", "").isEmpty() &&
				getjDialogCadastrarVeiculo().getjTFieldPlaca().getText().replace("-", "").replace("/", "").replace(" ", "").isEmpty() &&
				getjDialogCadastrarVeiculo().getjTFieldKMAtual().getText().replace(" ", "").isEmpty() &&
				getjDialogCadastrarVeiculo().getjTFieldMarca().getText().isEmpty() &&
				getjDialogCadastrarVeiculo().getjTFieldModelo().getText().isEmpty() &&
				getjDialogCadastrarVeiculo().getjTFieldMotor().getText().isEmpty() &&
				getjDialogCadastrarVeiculo().getjTFieldCor().getText().isEmpty() &&
				getjDialogCadastrarVeiculo().getjTFieldAno().getText().isEmpty()
		) {
			return true;
		} else {
			return false;
		}
	}
	
	private void limpaCampos() {
		getjDialogCadastrarVeiculo().getjTFieldChassi().setText("");
		getjDialogCadastrarVeiculo().getjTFieldPlaca().setText("");
		getjDialogCadastrarVeiculo().getjTFieldKMAtual().setText("");
		getjDialogCadastrarVeiculo().getjTFieldMarca().setText("");
		getjDialogCadastrarVeiculo().getjTFieldModelo().setText("");
		getjDialogCadastrarVeiculo().getjTFieldMotor().setText("");
		getjDialogCadastrarVeiculo().getChoiceCombustivel().select(0);
		getjDialogCadastrarVeiculo().getjTFieldCor().setText("");
		getjDialogCadastrarVeiculo().getjTFieldAno().setText("");
	}
	//** Fim m�todos da classe **
	

}