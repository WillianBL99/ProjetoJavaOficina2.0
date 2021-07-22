package view;


import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JFramePrincipal extends JFrame {

	//** In�cio declara��o de vari�veis **
	private JPanel jPanelAnterior;
	private Point local;
	
	//** Fim declara��o de vari�veis **
	
	public JFramePrincipal() {
		this.setTitle("Contole Estoque");
		this.getContentPane().setLayout(null);
		this.setUndecorated(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(1293,740));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	
	
	// Isere um jPanel e sua respectiva localiza��o na Frame
	public void alterarJPanel(JPanel jPanel, Point point) {
		
		setLocal(point); // armazena a localiza��o da tela a ser adicionada		
		
		this.insereJPanel(jPanel); // Chama o m�todo que insere jPanel.
	}
	
	
	
	// insere um jPanel em uma posi��o predefinida
	public void alterarJPanel(JPanel jPanel) {		
		setLocal(new Point(0,0)); //insere na posi��o 0, 0.
		this.insereJPanel(jPanel); // Chama o m�todo que insere jPanel.
	}
	
	
	private void insereJPanel(JPanel jPanel) {
		if(getjPanelAnterior() != null) { // Condi��o para retirar jPanel do JFrame, caso haja algum.
			this.remove(getjPanelAnterior());
		}
		
		this.getContentPane().add(jPanel);
		jPanel.setLocation(getLocal());
		
		this.setjPanelAnterior(jPanel);
		
		
		this.repaint();
		this.validate();
		
	}


	public JPanel getjPanelAnterior() {
		return jPanelAnterior;
	}


	public void setjPanelAnterior(JPanel jPanelAnterior) {
		this.jPanelAnterior = jPanelAnterior;
	}



	public Point getLocal() {
		return local;
	}



	public void setLocal(Point local) {
		this.local = local;
	}

}
