package control;

import javax.swing.UIManager;

import view.JFramePrincipal;
import view.JPanelLogin;

public class ControlMain {
	
	private static JPanelLogin jPanelLogin;
	private static ControlJPanelLogin controlJPanelLogin;
	private static JFramePrincipal jFramePrincipal;
	
	
	public static void main(String[] ags) {
		
		try {
			
			//UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
			
			
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

