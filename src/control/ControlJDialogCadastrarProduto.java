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

import dao.DaoJDialogCadastrarProduto;
import view.JDialogCadastrarProduto;
import view.JFramePrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJDialogCadastrarProduto  implements MouseListener, KeyListener, WindowListener{
	
	//** In�cio declara��o de vari�veis **
	private JFramePrincipal jFramePrincipal;
	private JDialogCadastrarProduto jDialogCadastrarVeiculo;
	private DaoJDialogCadastrarProduto daoJDialogCadastrarProduto;
	private ControlJPanelEstoque controlJPanelEstoque;
	private boolean modalTela;
	
	//** Fim declara��o de vari�veis **	
	public ControlJDialogCadastrarProduto(JFramePrincipal jFramePricipal, JDialogCadastrarProduto jDialogCadastrarVeiculo, ControlJPanelEstoque controlJPanelEstoque) {	
		this.jFramePrincipal = jFramePricipal;
		this.jDialogCadastrarVeiculo = jDialogCadastrarVeiculo;
		this.controlJPanelEstoque = controlJPanelEstoque;
		AddEvent();
		setmodal(getjDialogCadastrarProduto().ismodalTela());
	}


	private void AddEvent() {
		getjDialogCadastrarProduto().addWindowListener(this);
		getjDialogCadastrarProduto().getjButtonCadastrarCliente().addMouseListener(this);
		getjDialogCadastrarProduto().getjButtonCancelar().addMouseListener(this);
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
		// Quando o bot�o cadastrar produto for clicado
		if(e.getSource() == getjDialogCadastrarProduto().getjButtonCadastrarCliente()) {
			/*
			 *  Se todos os campos estiverem preenchidos && 
			 *  n�o existir um codigo igual no estoque
			 */
			if(isCamposPreenchidos()) {
				if(getdaoJDialogCadastrarProduto().idUnico(getjDialogCadastrarProduto().getjTFieldCodigo().getText())) {// Caso a inser��o seja realizada com sucesso ser� retornado o valor verdadeiro.
					if(getdaoJDialogCadastrarProduto().cadastrarProduto()) {						

						// Vetor de String com os nomes das op��es que apareceram no joptionpane.
						String[] options = {"Sim", "N�o"}; 
						
						/*
						 * int option
						 * recebe 0 ou 1 de acordo com a mensagem selecionada
						 * - 0: Foi secionada a op��o Sim
						 * - 1: Foi selecionada a op��o N�o
						 */
						int option = JOptionPane.showOptionDialog(
								getjDialogCadastrarProduto(), // tela pai
								"Cadastro realizado com sucesso!.\r\n"
								+ "Deseja cadastrar outro produto?", // mensagem
								"Cadastro realizado.", // t�tulo
								JOptionPane.DEFAULT_OPTION, 
								JOptionPane.INFORMATION_MESSAGE,
								null,
								options,
								options[1]); // op��o selecionada inicialmente
						
						// Se for escolhido Sim
						if(option == 0) {
							limpaCampos();
							
						// Se for escolhido N�o
						} else {
							getcontrolJPanelEstoque().atualizarTabela();
							getjFramePricipal().setEnabled(true);
							getjDialogCadastrarProduto().dispose();
						}
					}
				}
				
				// Caso o id j� exista no banco de dados
				else {
					// Exibe uma mensagem de confirma��o do cadastro.
					JOptionPane.showConfirmDialog(
							getjDialogCadastrarProduto(), // componente
							"O cadastro n�o foi realizado pois o c�digo inserido\r\n"
							+ "j� pertence a outro produto.", // texto
							"Falha ao cadastrar produto", // titulo
							JOptionPane.DEFAULT_OPTION, // bot�es
							JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
					);
					getjDialogCadastrarProduto().getjTFieldCodigo().setText("");
					getjDialogCadastrarProduto().getjTFieldCodigo().requestFocus();
				}				
			}
			
			// Caso tenha algum campo sem preencher
			else {
				// Exibe uma mensagem de confirma��o do cadastro.
				JOptionPane.showConfirmDialog(
						getjDialogCadastrarProduto(), // componente
						"Preencha todos os campos para efetuar o cadastro do produto.", // texto
						"Preencha todos os campos", // titulo
						JOptionPane.DEFAULT_OPTION, // bot�es
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}
		}
		
		// Quando o bot�o cancelar for clicado
		else if(e.getSource() == getjDialogCadastrarProduto().getjButtonCancelar()) {
			getcontrolJPanelEstoque().atualizarTabela();
			getjFramePricipal().setEnabled(true);
			getjDialogCadastrarProduto().dispose();
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
		this.getjFramePricipal().setEnabled(!ismodal());
	}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		getcontrolJPanelEstoque().atualizarTabela();
		getjFramePricipal().setEnabled(true);		
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
	

	public JDialogCadastrarProduto getjDialogCadastrarProduto() {
		if(jDialogCadastrarVeiculo == null){
			jDialogCadastrarVeiculo = new JDialogCadastrarProduto(getjFramePricipal(), true);
		}
		return jDialogCadastrarVeiculo;
	}
	

	public DaoJDialogCadastrarProduto getdaoJDialogCadastrarProduto() {
		if(daoJDialogCadastrarProduto == null){
			daoJDialogCadastrarProduto = new DaoJDialogCadastrarProduto(getjFramePricipal(), getjDialogCadastrarProduto());
		}
		return daoJDialogCadastrarProduto;
	}
	

	public ControlJPanelEstoque getcontrolJPanelEstoque() {
		if(controlJPanelEstoque == null){
			controlJPanelEstoque = new ControlJPanelEstoque(getjFramePricipal(), null);
		}
		return controlJPanelEstoque;
	}
	
	
	public boolean ismodal() {
		return modalTela;
	}
	
	
	public void setmodal(boolean modalTela) {
		this.modalTela = modalTela;
	}	
	
	
	private boolean isCamposPreenchidos() {
		if(!getjDialogCadastrarProduto().getjTFieldCodigo().getText().isEmpty() &&
				!getjDialogCadastrarProduto().getjTFieldDescricao().getText().isEmpty() &&
				!getjDialogCadastrarProduto().getjTFieldMarca().getText().isEmpty() &&
				!getjDialogCadastrarProduto().getjTFieldQuantidade().getText().isEmpty() &&
				!getjDialogCadastrarProduto().getjTFieldPreco().getText().replace(",", "").replace(".", "").replace(" ", "").isEmpty()) 
		{
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * M�todo camposIsEmpty() verifica se todos os 
	 * campos da tela cadastrar cliente est�o vazios.
	 * @return boolean // Se todos os capos de cadastrar clientes estiverem
	 * vazios ser� retornado o valor true
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
	}*/
	
	private void limpaCampos() {
		getjDialogCadastrarProduto().getjTFieldCodigo().setText("");
		getjDialogCadastrarProduto().getjTFieldDescricao().setText("");
		getjDialogCadastrarProduto().getjTFieldMarca().setText("");
		getjDialogCadastrarProduto().getjTFieldQuantidade().setText("");
		getjDialogCadastrarProduto().getjTFieldPreco().setText("");
		getjDialogCadastrarProduto().getjTFieldCodigo().requestFocus();
	}
	//** Fim m�todos da classe **
	
}