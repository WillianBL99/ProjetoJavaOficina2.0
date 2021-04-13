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
import javax.swing.JTextField;

import icons.Icones;
import model.Cores;
import model.Fontes;
import model.SetSizeIcon;

/**
 * @author josim
 *
 */

@SuppressWarnings("serial")
public class JDialogProcurarCliente extends JDialog{


public JDialogProcurarCliente(Frame frame, boolean modal) {
		super(frame, "Procura Cliente");
		this.modal = modal;
		addCompJDialogProcurarCliente();
	
	}

	//** In�cio declara��o de vari�veis **
	private boolean modal;
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	
	private JLabel jLabelPesquisarPor;
	
	private JTextField jTextFieldCampoPesquisa;
	
	private JButton jButtonPesquisar;
	private JButton jButtonCancelar;
	private JButton jButtonSelecionar;
	
	private JComboBox<String> jComboBoxPesquisa;
	//** Fim declara��o de vari�veis **


	//** In�cio getters JPanels **
	public JDialogProcurarCliente getJDialogProcurarCliente() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Cores.cinza5);
		this.setSize(937, 308);
		this.setVisible(true);
		this.setModal(modal);
		
		return this;
	}
	
	
	//** Fim getters JPanel **


	//** In�cio getters JButon **
	public JButton getjButtonPesquisar() {
		if(jButtonPesquisar == null){
			
			jButtonPesquisar = new JButton();			
			jButtonPesquisar.setFont(Fontes.fontJButtonPlain3);
			jButtonPesquisar.setBackground(Cores.azul1);
			jButtonPesquisar.setForeground(Color.white);
			jButtonPesquisar.setSize(48, 22);
			jButtonPesquisar.setFocusable(false);
			jButtonPesquisar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
			setSizeIcon.setIconJButton(jButtonPesquisar, Icones.
					getBuscar(), 30, 30);
		}	
		return jButtonPesquisar;

	}

	public JButton getjButtonCancelar() {
		if(jButtonCancelar == null){
			
			jButtonCancelar = new JButton();			
			jButtonCancelar.setFont(Fontes.fontJButtonPlain3);
			jButtonCancelar.setBackground(Cores.azul1);
			jButtonCancelar.setForeground(Color.white);
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setSize(86, 23);
			jButtonCancelar.setFocusable(false);
			jButtonCancelar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}	
		return jButtonCancelar;

	}

	public JButton getjButtonSelecionar() {
		if(jButtonSelecionar == null){
			
			jButtonSelecionar = new JButton();
			jButtonSelecionar.setFont(Fontes.fontJButtonPlain3);			
			jButtonSelecionar.setBackground(Cores.azul1);
			jButtonSelecionar.setForeground(Color.white);
			jButtonSelecionar.setText("Seleciona");
			jButtonSelecionar.setSize(86,23);
			jButtonSelecionar.setFocusable(false);
			jButtonSelecionar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
			}	
		
		return jButtonSelecionar;
	
	}

	//** Fim getters JButton **


	//** In�cio getters JLabel **	
	
	public JTextField getjTextFieldCampoPesquisa() {
		if(jTextFieldCampoPesquisa == null){
	
			jTextFieldCampoPesquisa = new JTextField();
			jTextFieldCampoPesquisa.setSize(182, 21);
			jTextFieldCampoPesquisa.setBorder(BorderFactory.
				createLineBorder(Cores.cinza2, 1, false));
			jTextFieldCampoPesquisa.setForeground(Cores.preto);
			jTextFieldCampoPesquisa.setFont(Fontes.fontJTFieldPlain1);
			jTextFieldCampoPesquisa.setOpaque(true);
		}
		return jTextFieldCampoPesquisa;
	}

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
	
	
	//** In�cio getters JTextField **
	//** Fim getters JTextField **
	
	
	//** In�cio getters JComboBox **
		public JComboBox<String> getjComboBoxPesquisa() {
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
	
	
	//** In�cio m�todos adi��o de componentes **
	void addCompJDialogProcurarCliente() {
		this.getJDialogProcurarCliente().getContentPane().add(getjLabelPesquisarPor());
		this.getjLabelPesquisarPor().setLocation(51, 64);
		
		this.getJDialogProcurarCliente().getContentPane().add(getjComboBoxPesquisa());
		this.getjComboBoxPesquisa().setLocation(155, 64);
		
		this.getJDialogProcurarCliente().getContentPane().add(getjTextFieldCampoPesquisa());
		this.getjTextFieldCampoPesquisa().setLocation(319, 64);
		
		this.getJDialogProcurarCliente().getContentPane().add(getjButtonPesquisar());
		this.getjButtonPesquisar().setLocation(511, 64);
		
		this.getJDialogProcurarCliente().getContentPane().add(getjButtonCancelar());
		this.getjButtonCancelar().setLocation(704, 235);
		
		this.getJDialogProcurarCliente().getContentPane().add(getjButtonSelecionar());
		this.getjButtonSelecionar().setLocation(800, 235);
	}


	
	
	
		
}