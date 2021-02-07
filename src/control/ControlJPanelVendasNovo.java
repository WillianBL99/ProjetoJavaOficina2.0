package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.JFramePrincipal;
import view.JPanelPrincipal;
import view.JPanelVendas;
import view.JPanelVendasNovo;
import view.JPanelVendasProsseguir;

public class ControlJPanelVendasNovo implements MouseListener, KeyListener {
	

	//** In�cio declara��o de vari�veis **
	private JFramePrincipal jFramePricipal;
	private JPanelVendasProsseguir jPanelVendasProsseguir;
	private JPanelVendasNovo jPanelVendasNovo;
	private JPanelVendas jPanelVendas;
	private JPanelPrincipal jPanelPrincipal;


	//** Fim declara��o de vari�veis **	
	
	
	/**
	 * @param jFramePricipal
	 * @param jPanelVendasNovo
	 * @param jPanelVendas
	 * @param jPanelPrincipal
	 */
	public ControlJPanelVendasNovo(JFramePrincipal jFramePricipal, JPanelVendasNovo jPanelVendasNovo,
			JPanelVendas jPanelVendas, JPanelPrincipal jPanelPrincipal) {
		super();
		this.jFramePricipal = jFramePricipal;
		this.jPanelVendasNovo = jPanelVendasNovo;
		this.jPanelVendas = jPanelVendas;
		this.jPanelPrincipal = jPanelPrincipal;
		AddEvent();
	}


	private void AddEvent() {
		getjPanelVendasNovo().getjButtonCancelar().addMouseListener(this);
		getjPanelVendasNovo().getjButtonInserir().addMouseListener(this);
		getjPanelVendasNovo().getjButtonProsseguir().addMouseListener(this);
		
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
		
		if(e.getSource() == getjPanelVendasNovo().getjButtonCancelar()) {
			// Cancelar a nova venda
			getjFramePricipal().alterarJPanel(getjPanelPrincipal());
			
		} else if(e.getSource() == getjPanelVendasNovo().getjButtonInserir()) {
			// fun��es para adicionar produtos a lista de produtos da nova venda
			
		} else if(e.getSource() == getjPanelVendasNovo().getjButtonProsseguir()) {
			// Prosseguir com a compra. Ir para formas de pagamento
			getjFramePricipal().alterarJPanel(getjPanelVendasProsseguir());
			
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



	public JPanelVendasNovo getjPanelVendasNovo() {
		if(jPanelVendasNovo == null) {
			jPanelVendasNovo = new JPanelVendasNovo();
		}
		return jPanelVendasNovo;
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
		
		
	//** Fim m�todos da classe **
}
