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

import icons.Icones;
import model.Cores;
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
	private enum FormaPagamento{DINHEIRO, CARTAO};
	
	private JFramePrincipal jFramePricipal;
	private JPanelVendasProsseguir jPanelVendasProsseguir;
	private JPanelPrincipal jPanelPrincipal;
	private JPanelVendasNovo jPanelVendasNovo;
	private JPanelVendas jPanelVendas;
	private ControlJPanelVendasNovo controlJPanelVendasNovo;
	
	private FormaPagamento formaPagamento;
	private Float valorTotal;
	private Float desconto;
	private Float valorPagar;
	private Float valorPago;
	private Float valorTroco;
	private Integer idEmpresa;
	private Integer idUsuario;
	private Integer idCliente;
	
	
	//** Fim declaração de variáveis **	
	
	
	/**
	 * @param jFramePricipal
	 * @param jPanelVendasProsseguir
	 * @param jPanelPrincipal
	 */
	public ControlJPanelVendasProsseguir(JFramePrincipal jFramePricipal, JPanelVendasProsseguir jPanelVendasProsseguir,
			JPanelPrincipal jPanelPrincipal, JPanelVendasNovo jPanelVendasNovo, JPanelVendas jPanelVendas) {
		this.jFramePricipal = jFramePricipal;
		this.jPanelVendasProsseguir = jPanelVendasProsseguir;
		this.jPanelPrincipal = jPanelPrincipal;
		this.jPanelVendasNovo = jPanelVendasNovo;
		this.jPanelVendas = jPanelVendas;
		setValorTotal(getjPanelVendasNovo().getjTFieldProdutoValTot().getText());		
		iniciarTela();
		
		this.AddEvent();
	}
	



	private void AddEvent() {
		getjPanelVendasProsseguir().getjButtonVoltar().addMouseListener(this);
		getjPanelVendasProsseguir().getjButtonCartao().addMouseListener(this);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource() == getjPanelVendasProsseguir().getjButtonVoltar()) {
			// quando o botão voltar for clicado
			getjFramePricipal().alterarJPanel(getjPanelVendasNovo());
			
		} else if(e.getSource() == getjPanelVendasProsseguir().getjButtonCartao()) {
			// quando a opção pagar com cartão for clicada
			
			
		}  else if(e.getSource() == getjPanelVendasProsseguir().getjButtonDinheiro()) {
			// quando a opção pagar com dinheiro for clicada
			
		} else if(e.getSource() == getjPanelVendasProsseguir().getjButtonFinalizarCompra()) {
			// quando o botão finalizar compra for clicado
			this.getjFramePricipal().alterarJPanel(this.getjPanelPrincipal());
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
		// 
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		// 
		
	}


	@Override
	public void focusLost(FocusEvent e) {
		// Quando o JTxF desconto perder o focu
		if(e.getSource() == getjPanelVendasProsseguir().getjTFieldDesconto()) {
			// Verifica se digitou algo
			if(!getjPanelVendasProsseguir().getjTFieldDesconto().getText().replace(" ", "").isEmpty()) {
				// atualizar valores da tela e variável
				setDesconto(getjPanelVendasProsseguir().getjTFieldDesconto().getText());
				setValorPagar(getValorTotal() - getDesconto());
				getjPanelVendasProsseguir().getjTFieldValorPagar().setText(String.format(" R$ %.2f", getValorPagar()));
			}
			// se não digitou nada
			else {
				setDesconto(0f);
				getjPanelVendasProsseguir().getjTFieldDesconto().setText(String.format(" R$ %.2f", getDesconto()));
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
	

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	public void setValorTotal(String valorTotal) {
		String valor = valorTotal.replace(" ", "").replace(",", ".").replace("R$", "");
		this.valorTotal = (valor.isEmpty() ? -1352 : Float.parseFloat(valor));
	}
	

	public Float getDesconto() {
		return desconto;
	}


	public void setDesconto(Float desconto) {
		this.desconto = desconto;
	}
	
	
	public void setDesconto(String desconto) {
		String valor = desconto.replace(" ", "").replace(",", ".").replace("R$", "");
		this.desconto = (valor.isEmpty() ? -1352 : Float.parseFloat(valor));
	}
	

	public Float getValorPagar() {
		return valorPagar;
	}
	

	public void setValorPagar(Float valorPagar) {
		this.valorPagar = valorPagar;
	}
	
	
	public void setValorPagar(String valorPagar) {
		String valor = valorPagar.replace(" ", "").replace(",", ".").replace("R$", "");
		this.valorPagar = (valor.isEmpty() ? -1352 : Float.parseFloat(valor));
	}
	

	public Float getValorPago() {
		return valorPago;
	}
	

	public void setValorPago(Float valorPago) {
		this.valorPago = valorPago;
	}
	
	
	public void setValorPago(String valorPago) {
		String valor = valorPago.replace(" ", "").replace(",", ".").replace("R$", "");
		this.valorPago = (valor.isEmpty() ? -1352 : Float.parseFloat(valor));
	}


	public Float getValorTroco() {
		return valorTroco;
	}


	public void setValorTroco(Float valorTroco) {
		this.valorTroco = valorTroco;
	}


	public Integer getIdEmpresa() {
		return idEmpresa;
	}


	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
	
	public void setIdEmpresa(String idEmpresa) {
		String valor = idEmpresa.replace(" ", "");
		this.idEmpresa = Integer.parseInt(valor.isEmpty() ? "-1354" : valor);
	}


	public Integer getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	public void setIdUsuario(String idUsuario) {
		String valor = idUsuario.replace(" ", "");
		this.idUsuario = Integer.parseInt(valor.isEmpty() ? "-1354" : valor);
	}


	public Integer getIdCliente() {
		if(idCliente == null) idCliente = 0;
		return idCliente;
	}
	

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	
	public void setIdCliente(String idCliente) {
		String valor = idCliente.replace(" ", "");
		this.idCliente = Integer.parseInt(valor.isEmpty() ? "-1354" : valor);
	}
	
	
	public FormaPagamento getForamPagamento() {
		if(formaPagamento == null) {
			formaPagamento = FormaPagamento.DINHEIRO;
		}
		return formaPagamento;
	}
	
	/**
	 * Seta a forma de pagamento de acordo com o botão clicado, assim como, configura a interface
	 * da tela.
	 * @param formaPagamento
	 */
	private void setFormaPagamento(FormaPagamento formaPagamento) {
		
		if(getForamPagamento() != formaPagamento) {
			// Seta a forma de pagamento
			this.formaPagamento = formaPagamento;
			// Seta a interface para cartão clicado
			if(formaPagamento == FormaPagamento.CARTAO) {
				getjPanelVendasProsseguir().getjButtonCartao().setForeground(Cores.preto);
				getjPanelVendasProsseguir().getSetSizeIcon().setIconJButton(
						getjPanelVendasProsseguir().getjButtonCartao(), Icones.getCartaoAzul(), 50, 50);
				
				getjPanelVendasProsseguir().getjButtonDinheiro().setForeground(Cores.cinza1);
				getjPanelVendasProsseguir().getSetSizeIcon().setIconJButton(
						getjPanelVendasProsseguir().getjButtonDinheiro(), Icones.getDinheiroCinza(), 50, 50);
				
				getjPanelVendasProsseguir().getjPanelDadosVendedorCliente().setVisible(false);
				getjPanelVendasProsseguir().getjButtonFinalizarCompra().setLocation(777 ,469);
			}
			// seta a interface para dinheiro clicado
			else {
				getjPanelVendasProsseguir().getjButtonCartao().setForeground(Cores.cinza1);
				getjPanelVendasProsseguir().getSetSizeIcon().setIconJButton(
						getjPanelVendasProsseguir().getjButtonCartao(), Icones.getCartaoCinza(), 50, 50);
				
				getjPanelVendasProsseguir().getjButtonDinheiro().setForeground(Cores.preto);
				getjPanelVendasProsseguir().getSetSizeIcon().setIconJButton(
						getjPanelVendasProsseguir().getjButtonDinheiro(), Icones.getDinheiroAzul(), 50, 50);
				
				getjPanelVendasProsseguir().getjPanelDadosVendedorCliente().setVisible(true);
				getjPanelVendasProsseguir().getjButtonFinalizarCompra().setLocation(777 ,615);
			}
		}		
	}
	
	
	/**
	 * Seta os campos ao iniciar a tela.
	 */
	private void iniciarTela() {
		setValorPagar(getValorTotal());
		getjPanelVendasProsseguir().getjTFieldValorTotCompra().setText(String.format(" R$ %.2f", getValorTotal()));
		getjPanelVendasProsseguir().getjTFieldValorPagar().setText(String.format(" R$ %.2f", getValorPagar()));
		getjPanelVendasProsseguir().getjTFieldDesconto().requestFocus();
	}
	//** Fim métodos da classe **



}
