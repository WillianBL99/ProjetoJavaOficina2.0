package control;

import javax.swing.UIManager;

import view.JFramePrincipal;
import view.JPanelGeraOS;
import view.JPanelLogin;
import view.JPanelVeiculos;
import view.JPanelVendas;
import view.JPanelVendasProsseguir;

public class ControlMain {
	
	private static JPanelLogin jPanelLogin;
	private static ControlJPanelLogin controlJPanelLogin;
	private static JFramePrincipal jFramePrincipal;
	
	
	public static void main(String[] ags) {
		
		try {
	      	for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	        	if ("Windows Classic".equals(info.getName())) { // Define designer dos componentes ("Windows","Windows Classic","Nimbus","Metal","CDE/Motif")
	            	UIManager.setLookAndFeel(info.getClassName());
	                break;
	            }
	        }
	     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
	           
	     }
	     

		 getjFramePrincipal().alterarJPanel(getjPanelLogin());
		 getcontrolJPanelLogin();
		
	}
	
	
	public static JPanelLogin getjPanelLogin() {
		if(jPanelLogin == null) {
			jPanelLogin = new JPanelLogin();
		}
		return jPanelLogin;
	}
	
	
	public static ControlJPanelLogin getcontrolJPanelLogin() {
		if(controlJPanelLogin == null) {
			controlJPanelLogin = new ControlJPanelLogin(getjFramePrincipal(), getjPanelLogin());
		}
		return controlJPanelLogin;
	}


	public static JFramePrincipal getjFramePrincipal() {
		if(jFramePrincipal == null) {
			jFramePrincipal = new JFramePrincipal();
		}
		return jFramePrincipal;
	}

	
}

