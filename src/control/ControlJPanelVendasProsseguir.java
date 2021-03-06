/**
 * 
 */
package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
public class ControlJPanelVendasProsseguir implements MouseListener, KeyListener {
	

	//** In�cio declara��o de vari�veis **
	
	private boolean cartaoClicado = false; // caso seja verdadeiro haver� altera��es dos componentes de "vendasProsseguir"
	private SetSizeIcon setSizeIcon = new SetSizeIcon(); // iniciando objeto para rendimensionamento de imagens
	
	
	private JFramePrincipal jFramePricipal;
	private JPanelVendasProsseguir jPanelVendasProsseguir;
	private JPanelPrincipal jPanelPrincipal;
	private JPanelVendasNovo jPanelVendasNovo;
	private JPanelVendas jPanelVendas;
	private ControlJPanelVendasNovo controlJPanelVendasNovo;
	
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
		this.AddEvent();
	}
	



	private void AddEvent() {
		getjPanelVendasProsseguir().getjButtonVoltar().addMouseListener(this);
		getjPanelVendasProsseguir().getjButtonCart�o().addMouseListener(this);
		getjPanelVendasProsseguir().getjButtonDinheiro().addMouseListener(this);
		getjPanelVendasProsseguir().getjButtonFinalizarCompra().addMouseListener(this);
		
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
		
		if(e.getSource() == getjPanelVendasProsseguir().getjButtonVoltar()) {
			// quando o bot�o voltar for clicado
			getjFramePricipal().alterarJPanel(getjPanelVendasNovo());
			
		} else if(e.getSource() == getjPanelVendasProsseguir().getjButtonCart�o()) {
			// quando a op��o pagar com cart�o for clicada
			this.isCartaoClicado(true);
			
		}  else if(e.getSource() == getjPanelVendasProsseguir().getjButtonDinheiro()) {
			// quando a op��o pagar com dinheiro for clicada
			this.isCartaoClicado(false);
			
		} else if(e.getSource() == getjPanelVendasProsseguir().getjButtonFinalizarCompra()) {
			// quando o bot�o finalizar compra for clicado
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
		// TODO Auto-generated method stub
		
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
	//** Fim m�todos da classe **
}
