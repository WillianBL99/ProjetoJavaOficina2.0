/**
 * 
 */
package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.JFramePrincipal;
import view.JPanelPrincipal;
import view.JPanelVendas;
import view.JPanelVendasNovo;

/**
 * @author pWili
 *
 */
public class ControlJPanelVendas implements MouseListener, KeyListener {
	

	//** In�cio declara��o de vari�veis **
	private JFramePrincipal jFramePricipal;
	private JPanelVendas jPanelVendas;
	private JPanelPrincipal jPanelPrincipal;
	private JPanelVendasNovo jPanelVendasNovo;
	private ControlJPanelVendasNovo controlJPanelVendasNovo;
	
	//** Fim declara��o de vari�veis **	
	
	
	/**
	 * @param jFramePricipal
	 * @param jPanelVendas
	 * @param jPanelPrincipal
	 */
	public ControlJPanelVendas(JFramePrincipal jFramePricipal, JPanelVendas jPanelVendas,
			JPanelPrincipal jPanelPrincipal) {
		super();
		this.jFramePricipal = jFramePricipal;
		this.jPanelVendas = jPanelVendas;
		this.jPanelPrincipal = jPanelPrincipal;
		this.jPanelVendasNovo = jPanelVendasNovo;
		this.AddEvent();
	}
	



	private void AddEvent() {
		getjPanelVendas().getjButtonNovaVenda().addMouseListener(this);
		getjPanelVendas().getjButtonApagar().addMouseListener(this);
		getjPanelVendas().getjButtonImprimir().addMouseListener(this);
		getjPanelVendas().getjButtonFiltrar().addMouseListener(this);
		getjPanelVendas().getjButtonPesquisarTodos().addMouseListener(this);
		
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
		
		if(e.getSource() == getjPanelVendas().getjButtonNovaVenda()) {
			System.out.println("clicou em nova venda");
			getjFramePricipal().alterarJPanel(getjPanelVendasNovo());
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



	public JPanelVendas getjPanelVendas() {
		if(jPanelVendas == null) {
			jPanelVendas = new JPanelVendas();
		}
		return jPanelVendas;
	}



	public JPanelPrincipal getjPanelPrincipal() {
		if(jPanelPrincipal == null) {
			jPanelPrincipal = new JPanelPrincipal();
		}
		return jPanelPrincipal;
	}		
		
		
	public JPanelVendasNovo getjPanelVendasNovo() {
		if(jPanelVendasNovo == null){
			jPanelVendasNovo = new JPanelVendasNovo();
	
		}
		return jPanelVendasNovo;
	}



	public ControlJPanelVendasNovo getControlJPanelVendasNovo() {
		if(controlJPanelVendasNovo == null){
			controlJPanelVendasNovo = new ControlJPanelVendasNovo();
	
		}
		return controlJPanelVendasNovo;
	}
	//** Fim m�todos da classe **
}
