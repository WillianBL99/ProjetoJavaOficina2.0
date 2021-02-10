/**
 * 
 */
package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Cores;
import model.Fontes;

/**
 * @author Paulo Uilian
 *
 */
public class JFrameTelasPopUps {
	
	private static JFrame jFrame;
	
	private static JPanel jPanelBarraMenu;
	private static JLabel jLabelBarraMenu;
	
	private static JPanel jPanelNovoOrcamentoFinal;
	
	
	private static void getJFrame(JPanel jPanel, Dimension dimensao) {
		jFrame = new JFrame();
		jFrame.getContentPane().setLayout(null);
		jFrame.setUndecorated(true);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jFrame.setSize(dimensao);
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
		jFrame.getContentPane().add(jPanel);		
	}
	
	
	public static void getjPanelNovoOrcamentoFinal() {
		jPanelNovoOrcamentoFinal = new JPanel();
		jPanelNovoOrcamentoFinal.setSize(830, 155);
		jPanelNovoOrcamentoFinal.add(getjPanelBarraMenu(830, 30, "Novo orçamento final"));
		jPanelNovoOrcamentoFinal.setVisible(true);
		getJFrame(jPanelNovoOrcamentoFinal, new Dimension(830, 155));
	}


	
	
	//** Início getters JPanel que pode ser utilizados em varias telas **
	
	
	private static JPanel getjPanelBarraMenu(int width, int height, String titulo) {
		jPanelBarraMenu = new JPanel();
		jPanelBarraMenu.setLayout(null);
		jPanelBarraMenu.setBackground(Cores.azul1);
		jPanelBarraMenu.setVisible(true);
		jPanelBarraMenu.setBounds(0, 0, width, height);	
		jPanelBarraMenu.add(getjLabelBarraMenu(titulo));		
		return jPanelBarraMenu;
	}


	private static JLabel getjLabelBarraMenu(String titulo) {
		if(jLabelBarraMenu == null){
			jLabelBarraMenu = new JLabel();
			jLabelBarraMenu.setBackground(Cores.azul1);
			jLabelBarraMenu.setFont(Fontes.fontJLabelPlain2);
			jLabelBarraMenu.setText(titulo);
			jLabelBarraMenu.setForeground(Cores.branco);
			jLabelBarraMenu.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelBarraMenu.setVisible(true);
			jLabelBarraMenu.setBorder(null);
			jLabelBarraMenu.setBounds(4,1,320,30);
		}	
		return jLabelBarraMenu;		
	}
	
	
	
	//** Fim getters JPanel que pode ser utilizados em varias telas **
}
