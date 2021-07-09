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
	
	//** Início declaração de variáveis **
	private JFramePrincipal jFramePrincipal;
	private JDialogCadastrarVeiculo jDialogCadastrarVeiculo;
	private DaoJDialogCadastrarVeiculo daoJDialogCadastrarVeiculo;
	private JDialogProcurarVeiculo jDialogProcurarVeiculo;
	private boolean modal;
	
	private String idCliente;
	
	//** Fim declaração de variáveis **	
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
		if(e.getSource() == getjDialogCadastrarVeiculo().getjButtonCadastrarVeiculo()) {
			// Se o cadastro for bem sucedido o método cadastrarCliente() retorna o valor 1
			if(getdaoJDialogCadastrarVeiculo().cadastrarVeiculo()) {
				// Exibe uma mensagem de confirmação do cadastro.
				JOptionPane.showConfirmDialog(
						getjDialogCadastrarVeiculo(), // componente
						"Cadastro realizado com sucesso!.", // texto
						"Cadastro realizo.", // titulo
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
				// limpa os campos da tela de cadastro de clientes.
				limpaCampos();
			}
		}
		
		// Quando o botão cancelar for clicado
		else if(e.getSource() == getjDialogCadastrarVeiculo().getjButtonCancelar()) {
			// se todos os campos estiverem vazios a tela será fechada sem exibir alerta
			if(camposIsEmpty()) {	
				getjDialogProcurarCliente().setEnabled(true);
				getjDialogCadastrarVeiculo().dispose();
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
		this.getjDialogProcurarCliente().setEnabled(!ismodal());
	}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.getjDialogProcurarCliente().setEnabled(true);
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
	
	
	public JDialogCadastrarVeiculo getjDialogCadastrarVeiculo() {
		if(jDialogCadastrarVeiculo == null){
			jDialogCadastrarVeiculo = new JDialogCadastrarVeiculo(getjFramePricipal(), true);
		}
		return jDialogCadastrarVeiculo;
	}
	
	
	public JDialogProcurarVeiculo getjDialogProcurarCliente() {
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
	 * Método camposIsEmpty() verifica se todos os 
	 * campos da tela cadastrar cliente estão vazios.
	 * @return boolean // Se todos os capos de cadastrar clientes estiverem
	 * vazios será retornado o valor true
	 */
	private boolean camposIsEmpty() {
				
		if(true
		) {
			return true;
		} else {
			return false;
		}
	}
	
	private void limpaCampos() {
		
	}
	//** Fim métodos da classe **
	

}