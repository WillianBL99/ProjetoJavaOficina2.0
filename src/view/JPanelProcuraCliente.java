/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import icons.Icones;
import model.Cores;
import model.Fontes;
import model.SetSizeIcon;

/**
 * @author josim
 *
 */
public class JPanelProcuraCliente extends JDialog{

	public JPanelProcuraCliente(Frame frame, boolean modal) {
		super(frame, "Procura Cliente");
		this.setModal(modal);
		getJPanelProcuraCliente();
		addCompJPanelProcuraCliente();
	
	}

	//** Início declaração de variáveis **
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	
	private JLabel jLabelPesquisarPor;
	
	private JPanel jPanelCentro;
	
	private JButton jButtonCancelar;
	private JButton jButtonSeleciona;
	
	
	private JComboBox jComboBoxPesquisa;
	//** Fim declaração de variáveis **


	//** Início getters JPanels **
	public JPanelProcuraCliente getJPanelProcuraCliente() {
		
		this.setLayout(null);
		this.setSize(new Dimension(937, 308));
		this.setBackground(Cores.cinza4);
		this.setVisible(true);
		
		return this;
	}
	
	
	//** Fim getters JPanel **


	//** Início getters JButon **


	public JButton getjButtonSeleciona() {
		if(jButtonSeleciona == null){
			
			jButtonSeleciona = new JButton();			
			jButtonSeleciona.setFont(Fontes.fontJButtonPlain3);
			jButtonSeleciona.setBackground(Cores.azul1);
			jButtonSeleciona.setForeground(Color.white);
			jButtonSeleciona.setText("Procurar O.S.");
			jButtonSeleciona.setSize(155, 35);
			jButtonSeleciona.setFocusable(false);
			jButtonSeleciona.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
			setSizeIcon.setIconJButton(jButtonSeleciona, Icones.
					getBuscar(), 30, 30);
		}	
		return jButtonSeleciona;

	}
	
	public JButton getjButtonCancelar() { // OK 
		if(jButtonCancelar == null) {
			jButtonCancelar = new JButton();			
			jButtonCancelar.setFont(Fontes.fontJButtonPlain3);
			jButtonCancelar.setBackground(Cores.azul1);
			jButtonCancelar.setForeground(Color.white);
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setSize(110, 35);
			jButtonCancelar.setFocusable(false);
			jButtonCancelar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
	        
		}
		return jButtonCancelar;
	}
	//** Fim getters JButon **


	//** Início getters JLabel **	
	
	public JLabel getjLabelPesquisarPor() {
		if(jLabelPesquisarPor == null){
		
			jLabelPesquisarPor = new JLabel("Pesquisar por:");
			jLabelPesquisarPor.setFont(Fontes.fontJLabelPlain1);
			jLabelPesquisarPor.setSize(99, 21);
			jLabelPesquisarPor.setForeground(Cores.preto);
			jLabelPesquisarPor.setOpaque(false);
				
		}
		return jLabelPesquisarPor;
	}
	
	//** Fim getters JLabel **
	
	
	//** Início getters JTextField **
	//** Fim getters JTextField **
	
	
	//** Início getters JComboBox **
		public JComboBox getjComboBoxPesquisa() {
			if(jComboBoxPesquisa == null){
				
				jComboBoxPesquisa = new JComboBox<String>();
				jComboBoxPesquisa.setSize(144, 21);
				jComboBoxPesquisa.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
				jComboBoxPesquisa.setForeground(Cores.preto);
				jComboBoxPesquisa.setFont(Fontes.fontJTFieldPlain1);
				jComboBoxPesquisa.setOpaque(true);
				jComboBoxPesquisa.addItem("Nome");
			}
			return jComboBoxPesquisa;
		}

	//** Fim getters JComboBox **
	
	
	//** Início métodos adição de componentes **
	void addCompJPanelProcuraCliente() {
		this.getJPanelProcuraCliente().add(getjLabelPesquisarPor());
		this.getjLabelPesquisarPor().setLocation(51, 64);
		
		this.getJPanelProcuraCliente().add(getjComboBoxPesquisa());
		this.getjComboBoxPesquisa().setLocation(155, 64);
		
	}


	
	
	
		
}
