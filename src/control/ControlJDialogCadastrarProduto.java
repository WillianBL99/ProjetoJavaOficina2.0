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
import view.JDialogCadastrarProduto;
import view.JFramePrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJDialogCadastrarProduto  implements MouseListener, KeyListener, WindowListener{
	
	//** Início declaração de variáveis **
	private JFramePrincipal jFramePrincipal;
	private JDialogCadastrarProduto jDialogCadastrarVeiculo;
	private boolean modalTela;
	
	private String idCliente;
	
	//** Fim declaração de variáveis **	
	public ControlJDialogCadastrarProduto(JFramePrincipal jFramePricipal, JDialogCadastrarProduto jDialogCadastrarVeiculo) {	
		this.jFramePrincipal = jFramePricipal;
		this.jDialogCadastrarVeiculo = jDialogCadastrarVeiculo;
		AddEvent();
		setmodal(getjDialogCadastrarProduto().ismodalTela());
	}


	private void AddEvent() {
		getjDialogCadastrarProduto().addWindowListener(this);
		getjDialogCadastrarProduto().getjButtonCadastrarCliente().addMouseListener(this);
		getjDialogCadastrarProduto().getjButtonCancelar().addMouseListener(this);
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
		// Quando o botão cadastrar produto for clicado
		if(e.getSource() == getjDialogCadastrarProduto().getjButtonCadastrarCliente()) {
			
		}
		
		// Quando o botão cancelar for clicado
		else if(e.getSource() == getjDialogCadastrarProduto().getjButtonCancelar()) {
			
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
	}



	@Override
	public void windowClosing(WindowEvent e) {
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
	

	public JDialogCadastrarProduto getjDialogCadastrarProduto() {
		if(jDialogCadastrarVeiculo == null){
			jDialogCadastrarVeiculo = new JDialogCadastrarProduto(getjFramePricipal(), true);
		}
		return jDialogCadastrarVeiculo;
	}
	
	
	public boolean ismodal() {
		return modalTela;
	}
	
	
	public void setmodal(boolean modalTela) {
		this.modalTela = modalTela;
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
	/*
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
	//** Fim métodos da classe **
	
*/
}