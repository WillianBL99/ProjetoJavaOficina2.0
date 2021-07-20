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
	
	//** Início declaração de variáveis **
	private JFramePrincipal jFramePrincipal;
	private JDialogCadastrarProduto jDialogCadastrarVeiculo;
	private DaoJDialogCadastrarProduto daoJDialogCadastrarProduto;
	private ControlJPanelEstoque controlJPanelEstoque;
	private boolean modalTela;
	
	//** Fim declaração de variáveis **	
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
			/*
			 *  Se todos os campos estiverem preenchidos && 
			 *  não existir um codigo igual no estoque &&
			 *  o preço do produto for maior que 0
			 */
			if(isCamposPreenchidos()) {
				float preco = Float.parseFloat(getjDialogCadastrarProduto().getjTFieldPreco().getText().isEmpty() ? "0" : getjDialogCadastrarProduto().getjTFieldPreco().getText().replace(",", "."));
				// Se o preço não for menor ou igual a zero
				if(preco > 0) {
					
					// Verifica se é o único id no banco de dados
					if(getdaoJDialogCadastrarProduto().idUnico(getjDialogCadastrarProduto().getjTFieldCodigo().getText())) {
						// Caso a inserção seja realizada com sucesso será retornado o valor verdadeiro.
						if(getdaoJDialogCadastrarProduto().cadastrarProduto()) {						

							// Vetor de String com os nomes das opções que apareceram no joptionpane.
							String[] options = {"Sim", "Não"}; 
							
							/*
							 * int option
							 * recebe 0 ou 1 de acordo com a mensagem selecionada
							 * - 0: Foi secionada a opção Sim
							 * - 1: Foi selecionada a opção Não
							 */
							int option = JOptionPane.showOptionDialog(
									getjDialogCadastrarProduto(), // tela pai
									"Cadastro realizado com sucesso.\r\n"
									+ "Deseja cadastrar outro produto?", // mensagem
									"Cadastro realizado.", // título
									JOptionPane.DEFAULT_OPTION, 
									JOptionPane.PLAIN_MESSAGE,
									null,
									options,
									options[1]); // opção selecionada inicialmente
							
							// Se for escolhido Sim
							if(option == 0) {
								limpaCampos();
								
							// Se for escolhido Não
							} else {
								getcontrolJPanelEstoque().atualizarTabela();
								getjFramePricipal().setEnabled(true);
								getjDialogCadastrarProduto().dispose();
							}
						}
					}
					
					// Caso o id já exista no banco de dados
					else {
						// Exibe uma mensagem de confirmação do cadastro.
						JOptionPane.showConfirmDialog(
								getjDialogCadastrarProduto(), // componente
								"O cadastro não foi realizado, pois o código inserido\r\n"
								+ "já pertence a outro produto.", // texto
								"Falha ao cadastrar produto", // titulo
								JOptionPane.DEFAULT_OPTION, // botões
								JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
						);
						getjDialogCadastrarProduto().getjTFieldCodigo().setText("");
						getjDialogCadastrarProduto().getjTFieldCodigo().requestFocus();
					}				
				
				}
				
				// Caso o valor do preço seja menor ou igual a zero
				else {
					JOptionPane.showConfirmDialog(
						getjDialogCadastrarProduto(), // componente
						"O cadastro não foi realizado, pois o preço inserido\r\n"
						+ "é menor ou igual a 0.", // texto
						"Falha ao cadastrar produto", // titulo
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.ERROR_MESSAGE // tipo de mensagem
					);
				}
			}
			
			// Caso tenha algum campo sem preencher
			else {
				// Exibe uma mensagem de confirmação do cadastro.
				JOptionPane.showConfirmDialog(
						getjDialogCadastrarProduto(), // componente
						"Preencha todos os campos para efetuar o cadastro do produto.", // texto
						"Preencha todos os campos", // titulo
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}
		}
		
		// Quando o botão cancelar for clicado
		else if(e.getSource() == getjDialogCadastrarProduto().getjButtonCancelar()) {
			// Caso todos os campos estejam vazios a tele é fechada imediatamente
			if(camposIsEmpty()) {
				getcontrolJPanelEstoque().atualizarTabela();
				getjFramePricipal().setEnabled(true);
				getjDialogCadastrarProduto().dispose();
				
			// Caso tenha algo digitado em algum campo
			} else {
				// Vetor de String com os nomes das opções que apareceram no joptionpane.
				String[] options = {"Sim", "Não"}; 
				
				/*
				 * int option
				 * recebe 0 ou 1 de acordo com a mensagem selecionada
				 * - 0: Foi secionada a opção Sim
				 * - 1: Foi selecionada a opção Não
				 */
				int option = JOptionPane.showOptionDialog(
						getjDialogCadastrarProduto(), // tela pai
						"Todos os campos preenchidos serão perdidos.\n"
						+ "Tem certeza que deseja cancelar?", // mensagem
						"Alerta!", // título
						JOptionPane.DEFAULT_OPTION, 
						JOptionPane.INFORMATION_MESSAGE,
						null,
						options,
						options[1]); // opção selecionada inicialmente
				
				// Se for escolhido Sim
				if(option == 0) {
					getcontrolJPanelEstoque().atualizarTabela();
					getjFramePricipal().setEnabled(true);
					getjDialogCadastrarProduto().dispose();
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
	 * Método camposIsEmpty() verifica se todos os 
	 * campos da tela cadastrar cliente estão vazios.
	 * @return boolean // Se todos os capos de cadastrar clientes estiverem
	 * vazios será retornado o valor true
	 */
	private boolean camposIsEmpty() {
				
		if(
				getjDialogCadastrarProduto().getjTFieldCodigo().getText().isEmpty() &&
				getjDialogCadastrarProduto().getjTFieldDescricao().getText().isEmpty() &&
				getjDialogCadastrarProduto().getjTFieldMarca().getText().isEmpty() &&
				getjDialogCadastrarProduto().getjTFieldQuantidade().getText().isEmpty() &&
				getjDialogCadastrarProduto().getjTFieldPreco().getText().isEmpty() &&
				getjDialogCadastrarProduto().getjTFieldCodigo().getText().isEmpty()
		) {
			return true;
		} else {
			return false;
		}
	}
	
	private void limpaCampos() {
		getjDialogCadastrarProduto().getjTFieldCodigo().setText("");
		getjDialogCadastrarProduto().getjTFieldDescricao().setText("");
		getjDialogCadastrarProduto().getjTFieldMarca().setText("");
		getjDialogCadastrarProduto().getjTFieldQuantidade().setText("");
		getjDialogCadastrarProduto().getjTFieldPreco().setText("");
		getjDialogCadastrarProduto().getjTFieldCodigo().requestFocus();
	}
	//** Fim métodos da classe **
	
}