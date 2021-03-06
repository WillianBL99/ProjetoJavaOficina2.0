/**
 * 
 */
package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import icons.Icones;
import model.Cores;
import model.Fontes;
import model.SetSizeIcon;

/**
 * @author Paulo Uilian
 *
 */
@SuppressWarnings("serial")
public class JDialogProcurarServico  extends JDialog{	
	
	//** In�cio declara��o de vari�veis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	
	private boolean modal;
	private JButton jButtonCancelar;
	private JButton jButtonSelecionar;
	private JButton jButtonProcurar;	

	private JTextField jTFieldProcurar;
	
	private JLabel jLabelPesquisarPor;
	
	private JScrollPane jSPanelSevicos;
	
	private JTable jTableVeiculos;

	private Choice choicePesquisarPor;
	
	
	//** Fim declara��o de vari�veis **
	
	//** In�cio construtor **
	public JDialogProcurarServico(Frame frame, boolean modal) {
		super(frame, "Procurar servi�o");
		this.modal = modal;
		this.addCompJDialogProcurarServico();
	}	

	
	//** Fim construtor **
	
	//** In�cio getters JPanels **
	public JDialogProcurarServico getJDialogProcurarServico() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Cores.cinza5);
		this.setSize(975, 310);
		this.setVisible(true);
		this.setModal(modal);
		this.setVisible(true);
		return this;
	}
	
	
	// utilizar caso venha ser criada um jdialog comm o undecored true
	/*public JPanel getjPanelBarraMenu() {
		if(jPanelBarraMenu == null) {
			jPanelBarraMenu = new JPanel();
			jPanelBarraMenu.setLayout(null);
			jPanelBarraMenu.setBackground(Cores.azul1);
			jPanelBarraMenu.setSize(getJDialogProcurarServico().getWidth(),25);
		}
		return jPanelBarraMenu;
	}*/	
	
	
	//** Fim getters JPanel **
	
	//** In�cio getters JLabel **
	
	// utilizar caso venha ser criada um jdialog comm o undecored true
		/*public JLabel getjLabelTituloTela() {
		if(jLabelTituloTela == null){
			jLabelTituloTela = new JLabel();
			jLabelTituloTela.setFont(Fontes.fontJLabelPlain1);
			jLabelTituloTela.setForeground(Cores.branco);
			jLabelTituloTela.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelTituloTela.setText("Procurar ve�culo");
			jLabelTituloTela.setOpaque(false);
		}
		return jLabelTituloTela;
	}*/
	
	
	public JLabel getjLabelPesquisarPor() {
		if(jLabelPesquisarPor == null){
			jLabelPesquisarPor = new JLabel();
			jLabelPesquisarPor.setFont(Fontes.fontJLabelPlain1);
			jLabelPesquisarPor.setForeground(Cores.preto);
			jLabelPesquisarPor.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelPesquisarPor.setText("Pesquisar por:");
			jLabelPesquisarPor.setOpaque(false);
			jLabelPesquisarPor.setSize(100, 25);
		}
		return jLabelPesquisarPor;
	}

	
	
	//** Fim getters JButon **
	
	// utilizar caso venha ser criada um jdialog comm o undecored true
		/*public JButton getjButtonFecharTela() {
		if(jButtonFecharTela == null){
			jButtonFecharTela = new JButton();			
			jButtonFecharTela.setFont(Fontes.fontJButtonPlain3);
			jButtonFecharTela.setBackground(Cores.transparent);
			jButtonFecharTela.setForeground(Cores.branco);
			jButtonFecharTela.setText("X");
			jButtonFecharTela.setSize(25, 25);
			jButtonFecharTela.setFocusable(false);
			jButtonFecharTela.setBorder(null);
	        
		}
		return jButtonFecharTela;
	}*/
	
	
	public JButton getjButtonCancelar() {
		if(jButtonCancelar == null){
			jButtonCancelar = new JButton();			
			jButtonCancelar.setFont(Fontes.fontJButtonPlain2);
			jButtonCancelar.setBackground(Cores.azul1);
			jButtonCancelar.setForeground(Color.white);
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setSize(90, 25);
			jButtonCancelar.setFocusable(false);
			jButtonCancelar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
	        
		}
		return jButtonCancelar;
	}


	public JButton getjButtonSelecionar() {
		if(jButtonSelecionar == null){
			jButtonSelecionar = new JButton();			
			jButtonSelecionar.setFont(Fontes.fontJButtonPlain2);
			jButtonSelecionar.setBackground(Cores.azul1);
			jButtonSelecionar.setForeground(Color.white);
			jButtonSelecionar.setText("Selecionar");
			jButtonSelecionar.setSize(90, 25);
			jButtonSelecionar.setFocusable(false);
			jButtonSelecionar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}
		return jButtonSelecionar;
	}


	public JButton getjButtonProcurar() {
		if(jButtonProcurar == null){
			jButtonProcurar = new JButton();			
			jButtonProcurar.setFont(Fontes.fontJButtonPlain2);
			jButtonProcurar.setBackground(Cores.azul1);
			jButtonProcurar.setForeground(Color.white);
			setSizeIcon.setIconJButton(jButtonProcurar, Icones.
					getBuscar(), 22, 22);
			jButtonProcurar.setSize(48, 25);
			jButtonProcurar.setFocusable(false);
			jButtonProcurar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}
		return jButtonProcurar;
	}
	
	//** In�cio getters JFields **
	
	public JTextField getjTFieldProcurar() {
		if(jTFieldProcurar == null){
			jTFieldProcurar = new JTextField();
			jTFieldProcurar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldProcurar.setForeground(Cores.azul1);
			jTFieldProcurar.setFont(Fontes.fontJTFieldPlain3);
			jTFieldProcurar.setSize(185, 25);
			jTFieldProcurar.setOpaque(true);
			
		}
		return jTFieldProcurar;
	}
	
	
	//** Fim getters JTextField **	
	
	
	//** In�cio getters conjuto JScrollPane/JTable **
	
	public JScrollPane getjSPanelSevicos() {
		if(jSPanelSevicos == null){
			jSPanelSevicos = new JScrollPane();
			jSPanelSevicos.setViewportView(getjTableVeiculos());
			jSPanelSevicos.setSize(900, 110);
		}
		return jSPanelSevicos;
	}


	public JTable getjTableVeiculos() {
		if(jTableVeiculos == null){
			jTableVeiculos = new JTable();
			jTableVeiculos.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		                {null, null, null},
		                {null, null, null},
		                {null, null, null},
		                {null, null, null},
		                {null, null, null},
		                {null, null, null},
		                {null, null, null},
		                {null, null, null},
		                {null, null, null},
		                {null, null, null},
		                {null, null, null},
		                {null, null, null},
		                
		            },
		            new String [] {
		                "Cod.Sevi�o", "Descri��o", "Pre�o"
		            }
		        ));				
			jTableVeiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jTableVeiculos.setFont(Fontes.fontJTablePlain1);
			jTableVeiculos.setOpaque(false);
			jTableVeiculos.getTableHeader().setFont(Fontes.fontJTableBold1);
			jTableVeiculos.getTableHeader().setForeground(Cores.branco);
			jTableVeiculos.getTableHeader().setBackground(Cores.azul1);
		}
		return jTableVeiculos;
	}
	
	
	public Choice getChoicePesquisarPor() {
		if(choicePesquisarPor == null){
			choicePesquisarPor = new Choice();
			choicePesquisarPor.setSize(175, 50);
			choicePesquisarPor.setFont(Fontes.fontJTFieldPlain1);
			choicePesquisarPor.setVisible(true);
			choicePesquisarPor.add("Descri��o sevi�o");
			choicePesquisarPor.add("C�digo servi�o");
			choicePesquisarPor.setFocusable(false);
	
		}
		return choicePesquisarPor;
	}
	
	
	//** Fim getters conjuto JScrollPane/JTable **
	
	//** In�cio m�todos adi��o de componentes **
	
	
	public void addCompJDialogProcurarServico() {

		/*getJDialogProcurarServico().getContentPane().add(getjPanelBarraMenu());
		getjPanelBarraMenu().setLocation(0, 0);*/

		getJDialogProcurarServico().getContentPane().add(getjLabelPesquisarPor());
		getjLabelPesquisarPor().setLocation(50, 40);
		
		getJDialogProcurarServico().getContentPane().add(getChoicePesquisarPor());
		getChoicePesquisarPor().setLocation(155, 40);

		getJDialogProcurarServico().getContentPane().add(getjTFieldProcurar());
		getjTFieldProcurar().setLocation(319, 40);
		
		getJDialogProcurarServico().getContentPane().add(getjButtonProcurar());
		getjButtonProcurar().setLocation(511, 40);

		getJDialogProcurarServico().getContentPane().add(getjSPanelSevicos());
		getjSPanelSevicos().setLocation(50, 100);

		getJDialogProcurarServico().getContentPane().add(getjButtonCancelar());
		getjButtonCancelar().setLocation(744, 235);

		getJDialogProcurarServico().getContentPane().add(getjButtonSelecionar());
		getjButtonSelecionar().setLocation(860, 235);
	}
	
	
	// utilizar caso venha ser criada um jdialog comm o undecored true
	/*public void addCompJPanelBarraMenu() {

		getjPanelBarraMenu().add(getjLabelTituloTela());
		getjLabelTituloTela().setLocation(((getjPanelBarraMenu().getWidth()/2) + (getjLabelTituloTela().getWidth()/2)), 0);

		getjPanelBarraMenu().add(getjButtonFecharTela());
		getjButtonFecharTela().setLocation(getjPanelBarraMenu().getWidth() - (5 + getjButtonFecharTela().getWidth()), 0);
	}*/
	
	//** Fim m�todos adi��o de componentes **
	

}