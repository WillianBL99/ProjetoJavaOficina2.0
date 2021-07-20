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

import javax.swing.JOptionPane;

import icons.Icones;
import model.SetSizeIcon;
import view.JFramePrincipal;
import view.JPanelPrincipal;
import view.JPanelVendas;
import view.JPanelVendasNovo;
import view.JPanelVendasProsseguir;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJPanelVendasProsseguir implements MouseListener, KeyListener, FocusListener {
	

	//** In�cio declara��o de vari�veis **
	
	private boolean cartaoClicado = false; // caso seja verdadeiro haver� altera��es dos componentes de "vendasProsseguir"
	private SetSizeIcon setSizeIcon = new SetSizeIcon(); // iniciando objeto para rendimensionamento de imagens
	
	
	private JFramePrincipal jFramePricipal;
	private JPanelVendasProsseguir jPanelVendasProsseguir;
	private JPanelPrincipal jPanelPrincipal;
	private JPanelVendasNovo jPanelVendasNovo;
	private JPanelVendas jPanelVendas;
	private ControlJPanelVendasNovo controlJPanelVendasNovo;
	
	private Float valorTotal;
	private Float desconto;
	private Float valorPagar;
	private Float valorPago;
	private Float troco;
	//private 
	
	//** Fim declara��o de vari�veis **	
	
	
	/**
	 * @param jFramePricipal
	 * @param jPanelVendasProsseguir
	 * @param jPanelPrincipal
	 */
	public ControlJPanelVendasProsseguir(JFramePrincipal jFramePricipal, JPanelVendasProsseguir jPanelVendasProsseguir,
			JPanelPrincipal jPanelPrincipal, JPanelVendasNovo jPanelVendasNovo, JPanelVendas jPanelVendas) {
		super();
		this.jFramePricipal = jFramePricipal;
		this.jPanelVendasProsseguir = jPanelVendasProsseguir;
		this.jPanelPrincipal = jPanelPrincipal;
		this.jPanelVendasNovo = jPanelVendasNovo;
		this.jPanelVendas = jPanelVendas;
		
		iniciarTela();
		this.AddEvent();
	}
	
	
	private void AddEvent() {
		getjPanelVendasProsseguir().getjButtonVoltar().addMouseListener(this);
		getjPanelVendasProsseguir().getjButtonCart�o().addMouseListener(this);
		getjPanelVendasProsseguir().getjButtonDinheiro().addMouseListener(this);
		getjPanelVendasProsseguir().getjButtonFinalizarCompra().addMouseListener(this);
		
		getjPanelVendasProsseguir().getjTFieldDesconto().addFocusListener(this);
		getjPanelVendasProsseguir().getjTFieldValorPago().addFocusListener(this);
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
		// Quando for digitado algo em desconto
		if(e.getSource() == getjPanelVendasProsseguir().getjTFieldDesconto()) {
			
		}
		
		// Quando for digitado algo em valor pago
		else if(e.getSource() == getjPanelVendasProsseguir().getjTFieldValorPago()) {
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Quando o bot�o voltar for clicado
		if(e.getSource() == getjPanelVendasProsseguir().getjButtonVoltar()) {
			getjFramePricipal().alterarJPanel(getjPanelVendasNovo());
			
		}
		
		// Quando o bot�o cart�o for clicado
		else if(e.getSource() == getjPanelVendasProsseguir().getjButtonCart�o()) {
			this.isCartaoClicado(true);
			getjPanelVendasProsseguir().getjTFieldValorPago().setText("");
			getjPanelVendasProsseguir().getjTFieldTroco().setText("");
			setValorPago(-135f);
			
		}
		
		// Quando o bot�o dinheiro for clicado
		else if(e.getSource() == getjPanelVendasProsseguir().getjButtonDinheiro()) {
			this.isCartaoClicado(false);
			
		} 
		
		// Quando o bot�o finalizar compra for clicado
		else if(e.getSource() == getjPanelVendasProsseguir().getjButtonFinalizarCompra()) {
			// Verificar forma de pagamento
			if(cartaoClicado) {
				// Avisar sobre venda com cart�o
				JOptionPane.showConfirmDialog(
						getjPanelVendasProsseguir(), // componente
						"O pagamento via cart�o j� foi efetuado?\n"
						+ "Caso tenha efetuado o pagamento clique \"Finalizar\" no pr�ximo aviso.", // texto
						"O pagamento efetuado?", // titulo
						JOptionPane.DEFAULT_OPTION, // bot�es
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
				// Se cofimar a finaliza�ao da venda
				if(informacaoCompra(false)) {
					this.getjFramePricipal().alterarJPanel(this.getjPanelPrincipal());
				}
			}
			// Forma de pagamento dinheiro
			else {
				// Verificar ser foi pago
				if(getTroco() != -135) {
					if(informacaoCompra(true)) {
						this.getjFramePricipal().alterarJPanel(this.getjPanelPrincipal());
					}
				}
				// N�o foi pago ainda
				else {
					JOptionPane.showConfirmDialog(
							getjPanelVendasProsseguir(), // componente
							"Insira o valor pago pelo cliente no campo \"Valor Pago\"\n"
							+ "antes de clicar em \"Finalizar compra\".", // texto
							"Pagamento n�o efetuado", // titulo
							JOptionPane.DEFAULT_OPTION, // bot�es
							JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
					);
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
	public void focusGained(FocusEvent e) {
		// Quando o campo desconto ganhar foco
		if(e.getSource() == getjPanelVendasProsseguir().getjTFieldDesconto()) {
			getjPanelVendasProsseguir().getjTFieldDesconto().setText("");
		}
		
		
		// Quando o campo valor pago receber foco
		if(e.getSource() == getjPanelVendasProsseguir().getjTFieldValorPago()) {
			// verificar se ja foi inserido algo em valor a pagar
			if(getValorPago() != -135) {
				getjPanelVendasProsseguir().getjTFieldValorPago().setText(String.format("%.2f", getValorPago()));
			}
		}
	}


	@Override
	public void focusLost(FocusEvent e) {
		// Quando o campo desconto perder foco
		if(e.getSource() == getjPanelVendasProsseguir().getjTFieldDesconto()) {
			// Verificar se o campo est� vazio
			if(!getjPanelVendasProsseguir().getjTFieldDesconto().getText().replace(" ", "").isEmpty()) {
				setDesconto(getjPanelVendasProsseguir().getjTFieldDesconto().getText());
				// Verificar se o desconto � v�lido
				if(getDesconto() <= getValorTotal() && getDesconto() >= 0) {
					// Formata o campo desconto e altera o valor a ser pago
					getjPanelVendasProsseguir().getjTFieldDesconto().setText(String.format(" R$ %2.2f", getDesconto()));
					setValorPagar(getValorTotal() - getDesconto());
					getjPanelVendasProsseguir().getjTFieldValorPagar().setText(String.format(" R$ %2.2f", getValorPagar()));
					// Se a forma de pagamento for dinheiro o campo valor pago recebe foco
					if(!cartaoClicado) {
						getjPanelVendasProsseguir().getjTFieldValorPago().requestFocus();
					}
				}
				// Desconto n�o � v�lido
				else {
					JOptionPane.showConfirmDialog(
							getjPanelVendasProsseguir(), // componente
							"Insira um desconto v�lido.\n"
							+ "Desconto v�lido de 0 ao valor total da compra.", // texto
							"Desconto inv�lido", // titulo
							JOptionPane.DEFAULT_OPTION, // bot�es
							JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
					);
					getjPanelVendasProsseguir().getjTFieldDesconto().setText("");
				}
			}
			// O campo desconto est� vazio
			else {
				JOptionPane.showConfirmDialog(
						getjPanelVendasProsseguir(), // componente
						"O campo \"Desconto\" n�o pode est� vazio.", // texto
						"Campo vazio", // titulo
						JOptionPane.DEFAULT_OPTION, // bot�es
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}
		}
		
		
		// Quando o campo valor pago perder foco
		else if(e.getSource() == getjPanelVendasProsseguir().getjTFieldValorPago()) {
			// Verificar se o campo est� vazio
			if(!getjPanelVendasProsseguir().getjTFieldValorPago().getText().replace(" ", "").isEmpty()) {
				setValorPago(getjPanelVendasProsseguir().getjTFieldValorPago().getText());
				// Verificar se � v�lido
				if(getValorPago() >= getValorPagar()) {
					// Formata o campo valor pago e altera o valor a ser pago
					getjPanelVendasProsseguir().getjTFieldValorPago().setText(String.format(" R$ %2.2f", getValorPago()));
					setTroco(getValorPago() - getValorPagar());
					getjPanelVendasProsseguir().getjTFieldTroco().setText(String.format(" R$ %2.2f", getTroco()));
					
				} 
				// Valor pago inv�lido
				else {
					JOptionPane.showConfirmDialog(
							getjPanelVendasProsseguir(), // componente
							"Insira um valor v�lido.\n"
							+ "O valor tem que ser maior ou igual  ao campo \"Valor a pagar\".", // texto
							"Valor inv�lido", // titulo
							JOptionPane.DEFAULT_OPTION, // bot�es
							JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
					);
					getjPanelVendasProsseguir().getjTFieldValorPago().setText("");
				}
			}
			// O campo est� vazio
			else {
				JOptionPane.showConfirmDialog(
						getjPanelVendasProsseguir(), // componente
						"O campo \"Valor pago\" n�o pode est� vazio.", // texto
						"Campo vazio", // titulo
						JOptionPane.DEFAULT_OPTION, // bot�es
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}
		}
	}
		
	//** Fim m�todos sobrescritos **
	
	//** In�cio m�todos da classe **

	public JFramePrincipal getjFramePricipal() {
		if(jFramePricipal == null) {
			jFramePricipal = new JFramePrincipal();
		}
		return jFramePricipal;
	}



	public JPanelVendasProsseguir getjPanelVendasProsseguir() {
		if(jPanelVendasProsseguir == null) {
			jPanelVendasProsseguir = new JPanelVendasProsseguir();
		}
		return jPanelVendasProsseguir;
	}



	public JPanelPrincipal getjPanelPrincipal() {
		if(jPanelPrincipal == null) {
			jPanelPrincipal = new JPanelPrincipal();
		}
		return jPanelPrincipal;
	}		
	
	
	public JPanelVendas getjPanelVendas() {
		if(jPanelVendas == null){
			jPanelVendas = new JPanelVendas();

		}
		return jPanelVendas;
	}		
		
		
	public JPanelVendasNovo getjPanelVendasNovo() {
		if(jPanelVendasNovo == null){
			jPanelVendasNovo = new JPanelVendasNovo();
	
		}
		return jPanelVendasNovo;
	}



	public ControlJPanelVendasNovo getControlJPanelVendasNovo() {
		if(controlJPanelVendasNovo == null){
			controlJPanelVendasNovo = new ControlJPanelVendasNovo(getjFramePricipal(), getjPanelVendasNovo(),
					getjPanelVendas(), getjPanelPrincipal());
	
		}
		return controlJPanelVendasNovo;
	}

	
	public Float getValorTotal() {	
			return valorTotal;
	}


	public void setValorTotal(String valorTotal) {
		this.valorTotal = (valorTotal.replace(" ", "").isEmpty() ? -135 : Float.parseFloat(valorTotal.replace("R$", "").replace(",", ".").replace(" ", "")));
	}


	public Float getDesconto() {
		return desconto;
	}


	public void setDesconto(String desconto) {
		this.desconto = (desconto.replace(" ", "").isEmpty() ? -135 : Float.parseFloat(desconto.replace("R$", "").replace(",", ".").replace(" ", "")));
	}


	public Float getValorPagar() {
		return valorPagar;
	}


	public void setValorPagar(String valorPagar) {
		this.valorPagar = (valorPagar.replace(" ", "").isEmpty() ? -135 : Float.parseFloat(valorPagar.replace("R$", "").replace(",", ".").replace(" ", "")));
	}


	public void setValorPagar(Float valorPagar) {
		this.valorPagar = valorPagar;
	}


	public Float getValorPago() {
		if(this.valorPago == null) {
			valorPago = -135f	;
		}
		return valorPago;
	}


	public void setValorPago(String valorPago) {
		this.valorPago = (valorPago.replace(" ", "").isEmpty() ? -135 : Float.parseFloat(valorPago.replace("R$", "").replace(",", ".").replace(" ", "")));
	}
	
	
	public void setValorPago(Float valorPago) {
		this.valorPago = valorPago;
	}


	public Float getTroco() {
		return troco;
	}


	public void setTroco(String troco) {
		this.troco = (troco.replace(" ", "").isEmpty() ? -135 : Float.parseFloat(troco.replace("R$", "").replace(",", ".").replace(" ", "")));
	}
	
	
	public void setTroco(Float troco) {
		this.troco = troco;
	}
	
	
	private void isCartaoClicado(boolean cartaoClicado) {
		if(this.cartaoClicado != cartaoClicado) {
			this.cartaoClicado = cartaoClicado;
			
			
			if(cartaoClicado) { // quando o jButtonCartao for clicado
				setSizeIcon.setIconJButton(this.getjPanelVendasProsseguir()
						.getjButtonDinheiro(), Icones.getDinheiroCinza(), 50, 50);
				
				this.getjPanelVendasProsseguir().getjPanelDadosPagamento().setVisible(false);				

				setSizeIcon.setIconJButton(this.getjPanelVendasProsseguir()
						.getjButtonCart�o(), Icones.getCart�oAzul(), 50, 50);				
				
				
			} else { // quando o jButtonDinheiro for clicado
				setSizeIcon.setIconJButton(this.getjPanelVendasProsseguir()
						.getjButtonDinheiro(), Icones.getDinheiroAzul(), 50, 50);
				
				this.getjPanelVendasProsseguir().getjPanelDadosPagamento().setVisible(true);				

				setSizeIcon.setIconJButton(this.getjPanelVendasProsseguir()
						.getjButtonCart�o(), Icones.getCart�oCinza(), 50, 50);	
				
			}
		}
		
	}
	
	
	/**
	 * 
	 */
	private void iniciarTela() {
		setValorTotal(getjPanelVendasNovo().getJTFieldTotal().getText().replace(",", ".").replace("R$", ""));
		setValorPagar(getjPanelVendasNovo().getJTFieldTotal().getText().replace(",", ".").replace("R$", ""));
		getjPanelVendasProsseguir().getjTFieldValorTotCompra().setText(String.format(" R$ %2.2f", getValorTotal()));
		getjPanelVendasProsseguir().getjTFieldValorPagar().setText(String.format(" R$ %2.2f", getValorPagar()));
		getjPanelVendasProsseguir().getjTFieldDesconto().requestFocus();
		
	}

	
	/**
	 * 
	 */
	private boolean informacaoCompra(boolean total) {
		String texto;
		// Exibe as informa��es para uma compra feita com dinheiro
		if(total) {
			texto = String.format("Dados da venda a ser finalizada.%n"
					+ "%12s: %d%n"
					+ "%11s: R$%8.2f%n"
					+ "%15s: R$%8.2f%n"
					+ "%14s: R$%8.2f%n"
					+ "%14s: R$%8.2f%n"
					+ "%nDseja finalizar a compra?",
					"Venda n�", 123452,
					"Desconto", getDesconto(),
					"Total", getValorTotal(),
					"Pago", getValorPago(),
					"Troco", getTroco()
					);
		}
		// Exibe as informa��es para uma compra feita com cart�o
		else {

			texto = String.format("Dados da venda a ser finalizada.%n"
					+ "%12s: %d%n"
					+ "%11s: R$%8.2f%n"
					+ "%15s: R$%8.2f%n"
					+ "%nDseja finalizar a compra?",
					"Venda n�", 123452,
					"Desconto", getDesconto(),
					"Total", getValorTotal()
					);
		}
		// Vetor de String com os nomes das op��es que apareceram no joptionpane.
		String[] options = {"Finalizar", "Cancelar"}; 
		
		/*
		 * int option
		 * recebe 0 ou 1 de acordo com a mensagem selecionada
		 * - 0: Foi secionada a op��o Sim
		 * - 1: Foi selecionada a op��o Cancelar
		 */
		int option = JOptionPane.showOptionDialog(
				getjPanelVendasNovo(), // tela pai
				texto, // texto
				"Detalhes da venda", // titulo
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.PLAIN_MESSAGE,
				null,
				options,
				options[1]); // op��o selecionada inicialmente
		
		if(option == 0) {
			return true;
		}
		return false;
	}
	//** Fim m�todos da classe **
}



















