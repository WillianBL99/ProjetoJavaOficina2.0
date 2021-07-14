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

import dao.DaoJDialogIserirProduto;
import model.Cores;
import view.JDialogInserirProduto;
import view.JFramePrincipal;
import view.JPanelPreOrcamentoNovo;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJDialogInserirProduto   implements MouseListener, KeyListener, WindowListener, FocusListener{
	
	//** Início declaração de variáveis **
	private JFramePrincipal jFramePrincipal;
	private JDialogInserirProduto jDialogInserirProduto;
	private DaoJDialogIserirProduto daoJDialogIserirProduto;
	private JPanelPreOrcamentoNovo jdiJPanelPreOrcamentoNovo;
	private boolean modalTela;
	
	private String codigoProcurado;
	private String descricaoProcurado;
	private String marcaProcurardo;
	private String quantidadeProcurado;
	private String precoProcurado;
	
	


	//** Fim declaração de variáveis **	
	public ControlJDialogInserirProduto(JFramePrincipal jFramePricipal, JDialogInserirProduto jDialogInserirProduto, JPanelPreOrcamentoNovo jdiJPanelPreOrcamentoNovo) {	
		this.jFramePrincipal = jFramePricipal;
		this.jDialogInserirProduto = jDialogInserirProduto;
		this.jdiJPanelPreOrcamentoNovo = jdiJPanelPreOrcamentoNovo;
		AddEvent();
		setmodal(getjDialogInserirProduto().ismodalTela());
	}


	private void AddEvent() {
		getjDialogInserirProduto().addWindowListener(this);
		getjDialogInserirProduto().getjTFieldProcurar().addKeyListener(this);
		getjDialogInserirProduto().getjTFieldQuantidadeInserir().addFocusListener(this);
		getjDialogInserirProduto().getjTFieldDesconto().addFocusListener(this);
		getjDialogInserirProduto().getjButtonInserirPeca().addMouseListener(this);
		getjDialogInserirProduto().getjButtonCancelar().addMouseListener(this);
		getjDialogInserirProduto().getjTablePecas().addMouseListener(this);
	}
		
		
	//** Início métodos sobrescritos **
	@Override
	public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
			
	}


	@Override
	public void keyPressed(KeyEvent e) {
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// Quando for digitado algo em jtxf procurar
		if(e.getSource() == getjDialogInserirProduto().getjTFieldProcurar()) {
			// Verificar se está persquisando por código ou descriçao
			switch(getjDialogInserirProduto().getChoicePesquisarPor().getSelectedItem().toString().replace(" ", "")) {
			case "Descrição":
				// Verificar se houve algum erro na pesquisa
				if(!getdaoJDialogEditarProduto().pesquisarPorDescricao()) {
					getjDialogInserirProduto().getjTablePecas().setVisible(false);
				}
				
				// Caso não seja encontrado
				else {
					getjDialogInserirProduto().getjTablePecas().setVisible(true);
				}			
				break;
				
			case "Código":
				// Verificar se foi encontrado algum produto
				if(!getdaoJDialogEditarProduto().pesquisarPorCodigo()) {
					getjDialogInserirProduto().getjTablePecas().setVisible(false);
				}
				
				// Caso não seja encontrado
				else {
					getjDialogInserirProduto().getjTablePecas().setVisible(true);
				}				
				break;
				
			case "Marca":
				// Verificar se houve algum erro na pesquisa
				if(!getdaoJDialogEditarProduto().pesquisarPorMarca()) {
					getjDialogInserirProduto().getjTablePecas().setVisible(false);
				}
				
				// Caso não seja encontrado
				else {
					getjDialogInserirProduto().getjTablePecas().setVisible(true);
				}				
				break;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		// Quando o botão inserir produto for clicado
		if(e.getSource() == getjDialogInserirProduto().getjButtonInserirPeca()) {
			// verificar se foi setada a quantidade de produto
			// Vetor de String com os nomes das opções que apareceram no joptionpane.
			String[] options = {"Sim", "Não"}; 
			
			/*
			 * int option
			 * recebe 0 ou 1 de acordo com a mensagem selecionada
			 * - 0: Foi secionada a opção Sim
			 * - 1: Foi selecionada a opção Cancelar
			 */
			int option = JOptionPane.showOptionDialog(
					getjDialogInserirProduto(), // tela pai
					"Produto inserido. Deseja adicionar outro?", // mensagem
					"Produto inserido", // título
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.PLAIN_MESSAGE,
					null,
					options,
					options[1]); // opção selecionada inicialmente
			
			if(option == 0) {
				limpaCampos();
				getjDialogInserirProduto().getjTFieldQuantidadeInserir().setEnabled(false);
				getjDialogInserirProduto().getjTFieldQuantidadeInserir().setBackground(Cores.cinza4);
				getjDialogInserirProduto().getjTFieldDesconto().setEnabled(false);
				getjDialogInserirProduto().getjTFieldDesconto().setBackground(Cores.cinza4);
				getjDialogInserirProduto().getjTFieldProcurar().requestFocus();
			}
			
			// Sair da tela
			else {
				getjFramePricipal().setEnabled(true);
				getjDialogInserirProduto().dispose();
			
			}
			
		}
		
		// Quando o botão cancelar for clicado
		else if(e.getSource() == getjDialogInserirProduto().getjButtonCancelar()) {
			// Vetor de String com os nomes das opções que apareceram no joptionpane.
			String[] options = {"Sim", "Cancelar"}; 
			
			/*
			 * int option
			 * recebe 0 ou 1 de acordo com a mensagem selecionada
			 * - 0: Foi secionada a opção Sim
			 * - 1: Foi selecionada a opção Cancelar
			 */
			int option = JOptionPane.showOptionDialog(
					getjDialogInserirProduto(), // tela pai
					"Produto não foi inserido, deseja sair?", // mensagem
					"Alerta", // título
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.INFORMATION_MESSAGE,
					null,
					options,
					options[1]); // opção selecionada inicialmente
			
			if(option == 0) {
				getjFramePricipal().setEnabled(true);
				getjDialogInserirProduto().dispose();
			}			
		}
		
		// Quando algum item da tabela for selecionado
		else if(e.getSource() == getjDialogInserirProduto().getjTablePecas()) {
			// Verifica se tem algum item selecionado
			if(getjDialogInserirProduto().getjTablePecas().getSelectedRow() > -1) {
				limpaCampos();
				atualizarCamposDados();
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
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void focusLost(FocusEvent e) {
		// Quando o jtxf QuantidadeInserir perder o foco
		if(e.getSource() == getjDialogInserirProduto().getjTFieldQuantidadeInserir()) {
			// Verificar se foi digitado algum valor
			if(!getjDialogInserirProduto().getjTFieldQuantidadeInserir().getText().isEmpty()) {
				// Recebe o valor da quantidade a ser inserida
				
				Integer val_inserir = Integer.parseInt(getjDialogInserirProduto().getjTFieldQuantidadeInserir().getText().isEmpty()?
						"0" : getjDialogInserirProduto().getjTFieldQuantidadeInserir().getText());
				// Verificar se não foi inserido um valor menor ou igual à 0 
				if(val_inserir > 0) {
					atualizaCamposInsercao();
					getjDialogInserirProduto().getjTFieldDesconto().requestFocus();
				}
			}
			
			// Senão foi digitado nada
			else {
				
			}
		}
		
		// Quando o jtxf Desconto perder o foco
		else if(e.getSource() == getjDialogInserirProduto().getjTFieldDesconto()) {
			if(getjDialogInserirProduto().getjTFieldDesconto().getText().isEmpty()) {
				getjDialogInserirProduto().getjTFieldAtendidos().setText("0");
			} else {
				Integer val_inserir = Integer.parseInt(getjDialogInserirProduto().getjTFieldQuantidadeInserir().getText().isEmpty()?
						"0" : getjDialogInserirProduto().getjTFieldQuantidadeInserir().getText());
				// Verificar se não foi inserido um valor menor ou igual à 0 em quantidade inserir
				if(val_inserir > 0) {
					atualizaCamposInsercao();
					getjDialogInserirProduto().getjButtonInserirPeca().requestFocus();
				}
			}
		}
	}
	
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		this.getjFramePricipal().setEnabled(!ismodal());
	}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		getjFramePricipal().setEnabled(true);	
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
	

	public JDialogInserirProduto getjDialogInserirProduto() {
		if(jDialogInserirProduto == null){
			jDialogInserirProduto = new JDialogInserirProduto(getjFramePricipal(), true);
		}
		return jDialogInserirProduto;
	}
	

	public JPanelPreOrcamentoNovo getjPanelPreOrcamentoNovo() {
		if(jdiJPanelPreOrcamentoNovo == null){
			jdiJPanelPreOrcamentoNovo = new JPanelPreOrcamentoNovo();
		}
		return jdiJPanelPreOrcamentoNovo;
	}
	

	public DaoJDialogIserirProduto getdaoJDialogEditarProduto() {
		if(daoJDialogIserirProduto == null){
			daoJDialogIserirProduto = new DaoJDialogIserirProduto(getjFramePricipal(), getjDialogInserirProduto());
		}
		return daoJDialogIserirProduto;
	}
	
	
	public boolean ismodal() {
		return modalTela;
	}
	
	
	public void setmodal(boolean modalTela) {
		this.modalTela = modalTela;
	}
	
	
	public String getCodigoProcurado() {
		if(codigoProcurado == null){	
			codigoProcurado = new String();	
		}
		return codigoProcurado;
	}


	public void setCodigoProcurado(String codigoProcurado) {
		this.codigoProcurado = codigoProcurado;
	}


	public String getDescricaoProcurado() {
		if(descricaoProcurado == null){	
			descricaoProcurado = new String();	
		}
		return descricaoProcurado;
	}


	public void setDescricaoProcurado(String descricaoProcurado) {
		this.descricaoProcurado = descricaoProcurado;
	}


	public String getMarcaProcurardo() {
		if(marcaProcurardo == null){	
			marcaProcurardo = new String();	
		}
		return marcaProcurardo;
	}


	public void setMarcaProcurardo(String marcaProcurardo) {
		this.marcaProcurardo = marcaProcurardo;
	}


	public String getQuantidadeProcurado() {
		if(quantidadeProcurado == null){	
			quantidadeProcurado = new String();	
		}
		return quantidadeProcurado;
	}


	public void setQuantidadeProcurado(String quantidadeProcurado) {
		this.quantidadeProcurado = quantidadeProcurado;
	}


	public String getPrecoProcurado() {
		if(precoProcurado == null){	
			precoProcurado = new String();	
		}
		return precoProcurado;
	}


	public void setPrecoProcurado(String precoProcurado) {
		this.precoProcurado = precoProcurado;
	}
	
	
	private void limpaCampos() {
		getjDialogInserirProduto().getjTFieldDescricao().setText("");
		getjDialogInserirProduto().getjTFieldPreco().setText("");
		getjDialogInserirProduto().getjTFieldQuantidadeEstoque().setText("");
		getjDialogInserirProduto().getjTFieldQuantidadeInserir().setText("");
		getjDialogInserirProduto().getjTFieldAtendidos().setText("");
		getjDialogInserirProduto().getjTFieldComprar().setText("");
		getjDialogInserirProduto().getjTFieldDesconto().setText("");
		getjDialogInserirProduto().getjTFieldValorDesconto().setText("0");
		getjDialogInserirProduto().getjTFieldValorTotal().setText("");
	}
	
	
	/**
	 * Método isNovaQuantidadeValida() verifica se a nova quantidade de produtos
	 * é válida.
	 * @return boolean Se a nova quantidade for válida retorna true, caso não, retorna false.
	 */
	private boolean isNovaQuantidadeValida() {
		return false;
	}
	
	
	private void atualizarCamposDados() {
		// Linha clicada na tabela
		int row = getjDialogInserirProduto().getjTablePecas().getSelectedRow();
		String preco = getjDialogInserirProduto().getjTablePecas().getValueAt(row, 4).toString();
		String descricao = getjDialogInserirProduto().getjTablePecas().getValueAt(row, 1).toString();
		String qtd_estoque = getjDialogInserirProduto().getjTablePecas().getValueAt(row, 3).toString();
		// Setar os campos de dados do produto
		getjDialogInserirProduto().getjTFieldPreco().setText(preco);
		getjDialogInserirProduto().getjTFieldDescricao().setText(descricao);
		getjDialogInserirProduto().getjTFieldQuantidadeEstoque().setText(qtd_estoque);
		getjDialogInserirProduto().getjTFieldQuantidadeInserir().setEnabled(true);
		getjDialogInserirProduto().getjTFieldQuantidadeInserir().setBackground(Cores.branco);
		getjDialogInserirProduto().getjTFieldDesconto().setEnabled(true);
		getjDialogInserirProduto().getjTFieldDesconto().setBackground(Cores.branco);
		getjDialogInserirProduto().getjTFieldQuantidadeInserir().requestFocus();
	}
	
	
	private void atualizaCamposInsercao() {
		// rebe o valor do desconto
		Integer val_inserir = Integer.parseInt(getjDialogInserirProduto().getjTFieldQuantidadeInserir().getText());
		int estoque = Integer.parseInt(getjDialogInserirProduto().getjTFieldQuantidadeEstoque().getText().isEmpty()? "0" : getjDialogInserirProduto().getjTFieldQuantidadeEstoque().getText());
		float desconto = Float.parseFloat(getjDialogInserirProduto().getjTFieldDesconto().getText().isEmpty()? "0" : getjDialogInserirProduto().getjTFieldDesconto().getText());
		float preco = Float.parseFloat(getjDialogInserirProduto().getjTFieldPreco().getText().isEmpty()? "0" : getjDialogInserirProduto().getjTFieldPreco().getText());
		float total = val_inserir * preco;
		float descRS = (desconto/100) * total;
		getjDialogInserirProduto().getjTFieldAtendidos().setText(estoque >= val_inserir ? val_inserir.toString() : "0");
		getjDialogInserirProduto().getjTFieldComprar().setText(estoque < val_inserir ? String.format("%d", (val_inserir - estoque)) : "");
		getjDialogInserirProduto().getjTFieldValorDesconto().setText(String.format("%.2f", descRS));
		getjDialogInserirProduto().getjTFieldValorTotal().setText(String.format("%.2f", total - descRS));
	
	}
	
	
	//** Fim métodos da classe **
	
}


















