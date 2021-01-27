package control;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.JFramePrincipal;
import view.JPanelHome;
import view.JPanelPrincipal;
import view.JPanelVendas;

public class ControlJPanelPrincipal  implements MouseListener, KeyListener {
	

	//** Início declaração de variáveis **
	private JFramePrincipal jFramePrincipal;
	private JPanelPrincipal jPanelPrincipal;
	private JPanelHome jPanelHome;
	private JPanelVendas jPanelVendas;
	
	private Point point = new Point(250, 47); // posição que a tela e setada na jpanelprincipal
	
	
	//** Fim declaração de variáveis **	
	
	public ControlJPanelPrincipal(JFramePrincipal jFramePricipal, JPanelPrincipal jPanelPrincipal) {		
		this.jPanelPrincipal = jPanelPrincipal;
		this.jFramePrincipal = jFramePricipal;		
		
		AddEvent();
		
	}


	private void AddEvent() {
		getjPanelPrincipal().getJButtonInicio().addMouseListener(this);
		getjPanelPrincipal().getjButtonOS().addMouseListener(this);
		getjPanelPrincipal().getjButtonOSConsulta().addMouseListener(this);
		getjPanelPrincipal().getjButtonOSCriar().addMouseListener(this);
		getjPanelPrincipal().getjButtonVendas().addMouseListener(this);
		getjPanelPrincipal().getjButtonOrcamento().addMouseListener(this);
		getjPanelPrincipal().getjButtonPreOrcamento().addMouseListener(this);
		getjPanelPrincipal().getjButtonOrcamentoFinal().addMouseListener(this);
		getjPanelPrincipal().getjButtonVeiculos().addMouseListener(this);
		getjPanelPrincipal().getjButtonClientes().addMouseListener(this);
		getjPanelPrincipal().getjButtonUsuarios().addMouseListener(this);
		getjPanelPrincipal().getjButtonEstoque().addMouseListener(this);
		getjPanelPrincipal().getjButtonConfiguracao().addMouseListener(this);
		
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
	public void mouseClicked(MouseEvent e) { // Quando algum botão for clicado
		
		if(e.getSource() == getjPanelPrincipal().getJButtonInicio()) {		
			getjPanelPrincipal().alterarJPanel(this.getjPanelHome(), point);			
		}
		
		if(e.getSource() == getjPanelPrincipal().getjButtonVendas()) {
			getjFramePricipal().alterarJPanel(this.getjPanelVendas());			
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
		
	//** Fim métodos sobrescritos **
	
	//** Início métodos da classe **

		public JPanelPrincipal getjPanelPrincipal() {
			if(jPanelPrincipal == null){
				jPanelPrincipal = new JPanelPrincipal();
			}
			return jPanelPrincipal;
		}


		public JFramePrincipal getjFramePricipal() {
			if(jFramePrincipal == null){
				jFramePrincipal = new JFramePrincipal();
			}
			return jFramePrincipal;
		}
	
	
		public JPanelHome getjPanelHome() {
			if(jPanelHome == null){
				jPanelHome = new JPanelHome();
			}
			return jPanelHome;
		}
		
		
		public JPanelVendas getjPanelVendas() {
			if(jPanelVendas == null){
				jPanelVendas = new JPanelVendas();
			}
			return jPanelVendas;
		}
		
		
		
		
		
		
	//** Fim métodos da classe **
}