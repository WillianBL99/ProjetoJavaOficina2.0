package control;

import javax.swing.UIManager;

import view.JFramePrincipal;
import view.JPanelLogin;
import view.JPanelPrincipal;

public class ControlMain {
	
	private static JPanelLogin jPanelLogin;
	private static JPanelPrincipal jPanelPrincipal;
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
	      
		 getjFramePrincipal().alterarJPanel(getjPanelPrincipal());
	}
	
	
	public static JPanelLogin getjPanelLogin() {
		if(jPanelLogin == null) {
			jPanelLogin = new JPanelLogin();
		}
		return jPanelLogin;
	}
	
	

	public static JPanelPrincipal getjPanelPrincipal() {
		if(jPanelPrincipal == null) {
			jPanelPrincipal = new JPanelPrincipal();
		}
		return jPanelPrincipal;
	}


	public static JFramePrincipal getjFramePrincipal() {
		if(jFramePrincipal == null) {
			jFramePrincipal = new JFramePrincipal();
		}
		return jFramePrincipal;
	}

	
}

