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
	

	//** Início declaração de variáveis **
	
	private boolean cartaoClicado = false; // caso seja verdadeiro haverá alterações dos componentes de "vendasProsseguir"
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
	
	//** Fim declaração de variáveis **	
	
	
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
		getjPanelVendasProsseguir().getjButtonCartão().addMouseListener(this);
		getjPanelVendasProsseguir().getjButtonDinheiro().addMouseListener(this);
		getjPanelVendasProsseguir().getjButtonFinalizarCompra().addMouseListener(this);
		
		getjPanelVendasProsseguir().getjTFieldDesconto().addFocusListener(this);
		getjPanelVendasProsseguir().getjTFieldValorPago().addFocusListener(this);
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
		// Quando for digitado algo em desconto
		if(e.getSource() == getjPanelVendasProsseguir().getjTFieldDesconto()) {
			
		}
		
		// Quando for digitado algo em valor pago
		else if(e.getSource() == getjPanelVendasProsseguir().getjTFieldValorPago()) {
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Quando o botão voltar for clicado
		if(e.getSource() == getjPanelVendasProsseguir().getjButtonVoltar()) {
			getjFramePricipal().alterarJPanel(getjPanelVendasNovo());
			
		}
		
		// Quando o botão cartão for clicado
		else if(e.getSource() == getjPanelVendasProsseguir().getjButtonCartão()) {
			this.isCartaoClicado(true);
			getjPanelVendasProsseguir().getjTFieldValorPago().setText("");
			getjPanelVendasProsseguir().getjTFieldTroco().setText("");
			setValorPago(-135f);
			
		}
		
		// Quando o botão dinheiro for clicado
		else if(e.getSource() == getjPanelVendasProsseguir().getjButtonDinheiro()) {
			this.isCartaoClicado(false);
			
		} 
		
		// Quando o botão finalizar compra for clicado
		else if(e.getSource() == getjPanelVendasProsseguir().getjButtonFinalizarCompra()) {
			// Verificar forma de pagamento
			if(cartaoClicado) {
				// Avisar sobre venda com cartão
				JOptionPane.showConfirmDialog(
						getjPanelVendasProsseguir(), // componente
						"O pagamento via cartão já foi efetuado?\n"
						+ "Caso tenha efetuado o pagamento clique \"Finalizar\" no próximo aviso.", // texto
						"O pagamento efetuado?", // titulo
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
				// Se cofimar a finalizaçao da venda
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
				// Não foi pago ainda
				else {
					JOptionPane.showConfirmDialog(
							getjPanelVendasProsseguir(), // componente
							"Insira o valor pago pelo cliente no campo \"Valor Pago\"\n"
							+ "antes de clicar em \"Finalizar compra\".", // texto
							"Pagamento não efetuado", // titulo
							JOptionPane.DEFAULT_OPTION, // botões
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
			// Verificar se o campo está vazio
			if(!getjPanelVendasProsseguir().getjTFieldDesconto().getText().replace(" ", "").isEmpty()) {
				setDesconto(getjPanelVendasProsseguir().getjTFieldDesconto().getText());
				// Verificar se o desconto é válido
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
				// Desconto não é válido
				else {
					JOptionPane.showConfirmDialog(
							getjPanelVendasProsseguir(), // componente
							"Insira um desconto válido.\n"
							+ "Desconto válido de 0 ao valor total da compra.", // texto
							"Desconto inválido", // titulo
							JOptionPane.DEFAULT_OPTION, // botões
							JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
					);
					getjPanelVendasProsseguir().getjTFieldDesconto().setText("");
				}
			}
			// O campo desconto está vazio
			else {
				JOptionPane.showConfirmDialog(
						getjPanelVendasProsseguir(), // componente
						"O campo \"Desconto\" não pode está vazio.", // texto
						"Campo vazio", // titulo
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}
		}
		
		
		// Quando o campo valor pago perder foco
		else if(e.getSource() == getjPanelVendasProsseguir().getjTFieldValorPago()) {
			// Verificar se o campo está vazio
			if(!getjPanelVendasProsseguir().getjTFieldValorPago().getText().replace(" ", "").isEmpty()) {
				setValorPago(getjPanelVendasProsseguir().getjTFieldValorPago().getText());
				// Verificar se é válido
				if(getValorPago() >= getValorPagar()) {
					// Formata o campo valor pago e altera o valor a ser pago
					getjPanelVendasProsseguir().getjTFieldValorPago().setText(String.format(" R$ %2.2f", getValorPago()));
					setTroco(getValorPago() - getValorPagar());
					getjPanelVendasProsseguir().getjTFieldTroco().setText(String.format(" R$ %2.2f", getTroco()));
					
				} 
				// Valor pago inválido
				else {
					JOptionPane.showConfirmDialog(
							getjPanelVendasProsseguir(), // componente
							"Insira um valor válido.\n"
							+ "O valor tem que ser maior ou igual  ao campo \"Valor a pagar\".", // texto
							"Valor inválido", // titulo
							JOptionPane.DEFAULT_OPTION, // botões
							JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
					);
					getjPanelVendasProsseguir().getjTFieldValorPago().setText("");
				}
			}
			// O campo está vazio
			else {
				JOptionPane.showConfirmDialog(
						getjPanelVendasProsseguir(), // componente
						"O campo \"Valor pago\" não pode está vazio.", // texto
						"Campo vazio", // titulo
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}
		}
	}
		
	//** Fim métodos sobrescritos **
	
	//** Início métodos da classe **

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
						.getjButtonCartão(), Icones.getCartãoAzul(), 50, 50);				
				
				
			} else { // quando o jButtonDinheiro for clicado
				setSizeIcon.setIconJButton(this.getjPanelVendasProsseguir()
						.getjButtonDinheiro(), Icones.getDinheiroAzul(), 50, 50);
				
				this.getjPanelVendasProsseguir().getjPanelDadosPagamento().setVisible(true);				

				setSizeIcon.setIconJButton(this.getjPanelVendasProsseguir()
						.getjButtonCartão(), Icones.getCartãoCinza(), 50, 50);	
				
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
		// Exibe as informações para uma compra feita com dinheiro
		if(total) {
			texto = String.format("Dados da venda a ser finalizada.%n"
					+ "%12s: %d%n"
					+ "%11s: R$%8.2f%n"
					+ "%15s: R$%8.2f%n"
					+ "%14s: R$%8.2f%n"
					+ "%14s: R$%8.2f%n"
					+ "%nDseja finalizar a compra?",
					"Venda nº", 123452,
					"Desconto", getDesconto(),
					"Total", getValorTotal(),
					"Pago", getValorPago(),
					"Troco", getTroco()
					);
		}
		// Exibe as informações para uma compra feita com cartão
		else {

			texto = String.format("Dados da venda a ser finalizada.%n"
					+ "%12s: %d%n"
					+ "%11s: R$%8.2f%n"
					+ "%15s: R$%8.2f%n"
					+ "%nDseja finalizar a compra?",
					"Venda nº", 123452,
					"Desconto", getDesconto(),
					"Total", getValorTotal()
					);
		}
		// Vetor de String com os nomes das opções que apareceram no joptionpane.
		String[] options = {"Finalizar", "Cancelar"}; 
		
		/*
		 * int option
		 * recebe 0 ou 1 de acordo com a mensagem selecionada
		 * - 0: Foi secionada a opção Sim
		 * - 1: Foi selecionada a opção Cancelar
		 */
		int option = JOptionPane.showOptionDialog(
				getjPanelVendasNovo(), // tela pai
				texto, // texto
				"Detalhes da venda", // titulo
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.PLAIN_MESSAGE,
				null,
				options,
				options[1]); // opção selecionada inicialmente
		
		if(option == 0) {
			return true;
		}
		return false;
	}
	//** Fim métodos da classe **
}



















