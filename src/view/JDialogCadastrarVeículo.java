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
public class JDialogCadastrarVe�culo extends JDialog{


	
	//** In�cio declara��o de vari�veis **
	
	
	
	
	//** Fim declara��o de vari�veis **
	
	//** In�cio construtor **
	
	public JDialogCadastrarVe�culo(Frame frame, boolean modal) {
		super(frame, modal);
		getJDialogCadastrarVe�culo();
	}
	
	
	//** Fim construtor **
	
	//** In�cio getters JPanels **
	public JDialogCadastrarVe�culo getJDialogCadastrarVe�culo() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Cadastrar ve�culo");
		this.setSize(975, 220);
		this.setVisible(true);
		return this;
	}
	
	
	
	//** Fim getters JPanel **
	
	//** In�cio getters JLabel **
	
	
	
	
	//** Fim getters JButon **
	
	
	
	//** In�cio getters JFields **
	
	
	
	
	//** Fim getters JFields **
	
	
	
	//** In�cio getters JComboBox **
	
	
	
	
	//** Fim getters conjuto JScrollPane/JTable **
		
	//** In�cio m�todos adi��o de componentes **
	
	
	
	
	//** Fim m�todos adi��o de componentes **
	

}