package view;


import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class JFramePrincipal extends JFrame {


	private JPanel jPanelAnterior;
	
	public JFramePrincipal() {
		this.setTitle("Contole Estoque");
		this.getContentPane().setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(1280,720));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	
	public void alterarJPanel(JPanel jPanel) {
		if(getjPanelAnterior() != null) { // Condição para retirar jPanel do JFrame, caso haja algum.
			this.remove(getjPanelAnterior());
		}
		
		this.getContentPane().add(BorderLayout.CENTER,jPanel);
		//System.out.println("adicionou nova tela");
		this.repaint();
		this.validate();
		setjPanelAnterior(jPanel); // Guarda o jPanel que esta setado no jFrame.
	}


	public JPanel getjPanelAnterior() {
		return jPanelAnterior;
	}


	public void setjPanelAnterior(JPanel jPanelAnterior) {
		this.jPanelAnterior = jPanelAnterior;
	}

}
