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
		// Quando for digitado algo em jtxf procurar
		if(e.getSource() == getjDialogInserirProduto().getjTFieldProcurar()) {
			// Verificar se está persquisando por código ou descriçao
			switch(getjDialogInserirProduto().getChoicePesquisarPor().getSelectedItem().toString().replace(" ", "")) {
			case "Descrição":
				// Verificar se houve algum erro na pesquisa
				if(!getdaoJDialogEditarProduto().pesquisarPorDescricao()) {
				}				
				break;
				
			case "Código":
				// Verificar se houve algum erro na pesquisa
				if(!getdaoJDialogEditarProduto().pesquisarPorCodigo()) {
				}
				
				break;
				
			case "Marca":
				// Verificar se houve algum erro na pesquisa
				if(!getdaoJDialogEditarProduto().pesquisarPorMarca()) {
				}
				
				break;
			}
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
			
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		// Quando o botão inserir produto for clicado
		if(e.getSource() == getjDialogInserirProduto().getjButtonInserirPeca()) {
			
		}
		
		// Quando o botão cancelar for clicado
		else if(e.getSource() == getjDialogInserirProduto().getjButtonCancelar()) {
			getjFramePricipal().setEnabled(true);
			getjDialogInserirProduto().dispose();
		}
		
		// Quando algum item da tabela for selecionado
		else if(e.getSource() == getjDialogInserirProduto().getjTablePecas()) {
			// Verifica se tem algum item selecionado
			if(getjDialogInserirProduto().getjTablePecas().getSelectedRow() > -1) {
				// Linha clicada na tabela
				int row = getjDialogInserirProduto().getjTablePecas().getSelectedRow();
				String preco = getjDialogInserirProduto().getjTablePecas().getValueAt(row, 4).toString();
				String descricao = getjDialogInserirProduto().getjTablePecas().getValueAt(row, 1).toString();
				String qtd_estoque = getjDialogInserirProduto().getjTablePecas().getValueAt(row, 3).toString();
				// Setar os campos de dados do produto
				getjDialogInserirProduto().getjTFieldPreco().setText(preco);
				getjDialogInserirProduto().getjTFieldDescricao().setText(descricao);
				getjDialogInserirProduto().getjTFieldQuantidadeEstoque().setText(qtd_estoque);
				getjDialogInserirProduto().getjTFieldQuantidadeInserir().setBackground(Cores.branco);
				getjDialogInserirProduto().getjTFieldDesconto().setBackground(Cores.branco);
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
				Integer val_inserir = Integer.parseInt(getjDialogInserirProduto().getjTFieldQuantidadeInserir().getText());
				// Verificar se não foi inserido um valor menor ou igual à 0 
				if(val_inserir > 0) {
					// rebe o valor do desconto
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
			}
			
			// Senão foi digitado nada
			else {
				
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
	
	
	/**
	 * Método camposIsEmpty() verifica se todos os 
	 * campos da tela cadastrar cliente estão vazios.
	 * @return boolean // Se todos os capos de cadastrar clientes estiverem
	 * vazios será retornado o valor true
	 */
	private boolean camposIsEmpty() {
		boolean retorno;
		return retorno;
	}
	
	private void limpaCampos() {
		getjDialogInserirProduto().getjTFieldCodigo().setText("");
		getjDialogInserirProduto().getjTFieldDescricao().setText("");
		getjDialogInserirProduto().getjTFieldMarca().setText("");
		getjDialogInserirProduto().getjTFieldQuantidadeEstoque().setText("");
		getjDialogInserirProduto().getjTFieldPreco().setText("");
		getjDialogInserirProduto().getjTFieldCodigo().requestFocus();
	}
	
	/**
	 * Método isCamposAterados() verifica se todos os 
	 * campos editaveis da tela editar produto estão inalterados.
	 * @param input Pode ser setado como 0, 1 ou 2:
	 * 0 - Para retornar se o campo descricao ou marca foram alterados.
	 * 1 - Para retornar se o campo novaQuantidade ou preço foram alterados.
	 * 2 - Para retornar se algum campo foi alterado
	 * @return boolean Se existir algum campo alterado na tela de editar produto
	 * será retornado true, caso contrário, false.
	 */
	private boolean isCamposAterados(int input) {
		boolean retorno = false;
		// campos de ediçao
		boolean camposEditar = (!getjDialogInserirProduto().getjTFieldNovoValor().getText().isEmpty()||
				!getjDialogInserirProduto().getjTFieldNovaQuantidade().getText().isEmpty());
		// campos de dados de produto
		boolean camposDados = (!getjDialogInserirProduto().getjTFieldDescricao().getText().equals(getDescricaoProcurado()) ||
				!getjDialogInserirProduto().getjTFieldMarca().getText().equals(getMarcaProcurardo()));
		
		
		switch(input){
		// Para retornar se o campo descricao ou marca foram alterados.
		case 0:
			if(camposDados) {
				retorno = true;
			}
			break;

		// Para retornar se o campo novaQuantidade ou preço foram alterados.
		case 1:
			if(camposEditar) {
				retorno = true;
			}
			break;

		// Para retornar se algum campo foi alterado
		case 2:
			if(camposDados || camposEditar) {
				retorno = true;
			}
			break;
		}
		return retorno;
	}
	
	
	/**
	 * Método isNovaQuantidadeValida() verifica se a nova quantidade de produtos
	 * é válida.
	 * @return boolean Se a nova quantidade for válida retorna true, caso não, retorna false.
	 */
	private boolean isNovaQuantidadeValida() {	
		// a nova quantidade de produtos
		int newQtd = Integer.parseInt(getjDialogInserirProduto().getjTFieldNovaQuantidade().getText().isEmpty() ? "-1": getjDialogInserirProduto().getjTFieldNovaQuantidade().getText());
		// a quantidade de produtos anterior
		int oldQtd = Integer.parseInt(getQuantidadeProcurado());
		// Verificação se o novo código é valido
		if(newQtd >= 0 && newQtd != oldQtd) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Método isNovoValorValido() verifica se o novo valor do produto é válido
	 * @return boolean Se a nova quantidade for válida retorna true, caso não, retorna false.
	 */
	private boolean isNovoValorValido() {	
		// O novo valor do produto
		float newVal = Float.parseFloat(getjDialogInserirProduto().getjTFieldNovoValor().getText().isEmpty() ?
				"-1": getjDialogInserirProduto().getjTFieldNovoValor().getText().replace(" ", ""));
		// a quantidade de produtos anterior
		float oldVal = Integer.parseInt(getQuantidadeProcurado());
		// Verificação se o novo código é valido
		if(newVal >= 0 && newVal != oldVal) {
			return true;
		} else {
			return false;
		}
	}
	
	
	private void atualizarVariaveis() {
		setCodigoProcurado(getjDialogInserirProduto().getjTFieldCodigo().getText());
		setDescricaoProcurado(getjDialogInserirProduto().getjTFieldDescricao().getText());
		setMarcaProcurardo(getjDialogInserirProduto().getjTFieldMarca().getText());
		setQuantidadeProcurado(getjDialogInserirProduto().getjTFieldQuantidadeEstoque().getText());
		setPrecoProcurado(getjDialogInserirProduto().getjTFieldPreco().getText());
	}
	
	
	//** Fim métodos da classe **
	
}


















