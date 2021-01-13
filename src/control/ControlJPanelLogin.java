package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import dao.DaoJPanelLogin;
import view.JFramePrincipal;
import view.JPanelLogin;
import view.JPanelPrincipal;

public class ControlJPanelLogin implements MouseListener, KeyListener {
	
	//** Início declaração de variáveis **
	private JPanelLogin jPanelLogin;
	private JFramePrincipal jFramePrincipal;
	private JPanelPrincipal jPanelPrincipal;
	private ControlJPanelPrincipal controlJPanelPrincipal;
	private DaoJPanelLogin daoJPanelLogin = new DaoJPanelLogin();
	
	
	//** Fim declaração de variáveis **	
	
	public ControlJPanelLogin(JFramePrincipal jFramePricipal, JPanelLogin jPanelLogin) {		
		this.jPanelLogin = jPanelLogin;
		this.jFramePrincipal = jFramePricipal;		
		
		AddEvent();
		
	}


	private void AddEvent() {
		getjPanelLogin().getjButtonEntrar().addMouseListener(this);
		getjPanelLogin().getjTFieldUsuario().requestFocus();
		getjPanelLogin().getjTFieldUsuario().addKeyListener(this);	

		getjPanelLogin().getjPFieldSenha().addKeyListener(this);
		getjPanelLogin().getjPFieldSenha().addKeyListener( new KeyAdapter() {} );
		
	}
		
		
	//** Início métodos sobrescritos **
	@Override
	public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
			
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == getjPanelLogin().getjTFieldUsuario()) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				getjPanelLogin().getjPFieldSenha().requestFocus();
			}
		}
		
		if(e.getSource() == getjPanelLogin().getjPFieldSenha()) { // caso a senha e usuário esteja correto muda a tela
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				validaLogin(); // metodo da classe
			}
		}
			
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
			
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == getjPanelLogin().getjButtonEntrar()) {			
			validaLogin(); // método da classe
			
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


		public JPanelLogin getjPanelLogin() {
			if(jPanelLogin == null){
				jPanelLogin = new JPanelLogin();
			}
			return jPanelLogin;
		}


		public JFramePrincipal getjFramePricipal() {
			if(jFramePrincipal == null){
				jFramePrincipal = new JFramePrincipal();
			}
			return jFramePrincipal;
		}
		
		
		public ControlJPanelPrincipal getcControlJPanelPrincipal() {
			if(controlJPanelPrincipal == null){
				controlJPanelPrincipal = new ControlJPanelPrincipal(getjFramePricipal(), getjPanelPrincipal());
			}
			return controlJPanelPrincipal;
		}
		
		
		private void validaLogin() {
			String usuario = getjPanelLogin().getjTFieldUsuario().getText();
			String senha = new String(getjPanelLogin().getjPFieldSenha().getPassword()) ;
			
			if(daoJPanelLogin.confLoginSenha(usuario, senha)) { // altera a tela
				
				getjFramePricipal().alterarJPanel(getjPanelPrincipal());
				getcControlJPanelPrincipal();
				getjPanelLogin().getjLabelErro().setVisible(false);
				
			} else { // apresenta mensagem de erro
				getjPanelLogin().getjLabelErro().setVisible(true);
				getjPanelLogin().getjTFieldUsuario().setText("");
				getjPanelLogin().getjTFieldUsuario().requestFocus();
				
			}
		}
	
	
	//** Fim métodos da classe **
	

}


