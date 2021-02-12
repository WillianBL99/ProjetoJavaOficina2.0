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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;

import icons.Icones;
import model.Cores;
import model.Fontes;
import model.SetSizeIcon;

/**
 * @author Paulo Uilian
 *
 */
public class JDialogCadastrarVeículo extends JDialog{


	
	//** Início declaração de variáveis **
	
	
	
	
	//** Fim declaração de variáveis **
	
	//** Início construtor **
	
	public JDialogCadastrarVeículo(Frame frame, boolean modal) {
		super(frame, modal);
		getJDialogCadastrarVeículo();
	}
	
	
	//** Fim construtor **
	
	//** Início getters JPanels **
	public JDialogCadastrarVeículo getJDialogCadastrarVeículo() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Cadastrar veículo");
		this.setSize(975, 220);
		this.setVisible(true);
		return this;
	}
	
	
	
	//** Fim getters JPanel **
	
	//** Início getters JLabel **
	
	
	
	
	//** Fim getters JButon **
	
	
	
	//** Início getters JFields **
	
	
	
	
	//** Fim getters JFields **
	
	
	
	//** Início getters JComboBox **
	
	
	
	
	//** Fim getters conjuto JScrollPane/JTable **
		
	//** Início métodos adição de componentes **
	
	
	
	
	//** Fim métodos adição de componentes **
	

}