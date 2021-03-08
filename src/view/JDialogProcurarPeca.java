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
public class JDialogProcurarPeca extends JDialog{	
	
	
	//** Início declaração de variáveis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	
	private boolean modal;
	private JButton jButtonCancelar;
	private JButton jButtonSelecionar;
	private JButton jButtonProcurar;	

	private JTextField jTFieldProcurar;
	
	private JLabel jLabelPesquisarPor;
	
	private JScrollPane jSPanePeca;
	
	private JTable jTablePecas;

	private Choice choicePesquisarPor;
	
	
	//** Fim declaração de variáveis **
	
	//** Início construtor **
	public JDialogProcurarPeca(Frame frame, boolean modal) {
		super(frame, "Procurar peças");
		this.modal = modal;
		this.addCompJDialogProcurarPeca();
	}	

	
	//** Fim construtor **
	
	//** Início getters JPanels **
	public JDialogProcurarPeca getJDialogProcurarPeca() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setBackground(Cores.branco);
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
			jPanelBarraMenu.setSize(getJDialogProcurarPeca().getWidth(),25);
		}
		return jPanelBarraMenu;
	}*/	
	
	
	//** Fim getters JPanel **
	
	//** Início getters JLabel **
	
	// utilizar caso venha ser criada um jdialog comm o undecored true
		/*public JLabel getjLabelTituloTela() {
		if(jLabelTituloTela == null){
			jLabelTituloTela = new JLabel();
			jLabelTituloTela.setFont(Fontes.fontJLabelPlain1);
			jLabelTituloTela.setForeground(Cores.branco);
			jLabelTituloTela.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelTituloTela.setText("Procurar veículo");
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
	
	//** Início getters JFields **
	
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
	
	
	//** Início getters conjuto JScrollPane/JTable **
	
	public JScrollPane getjSPanePeca() {
		if(jSPanePeca == null){
			jSPanePeca = new JScrollPane();
			jSPanePeca.setViewportView(getjTablePecas());
			jSPanePeca.setSize(900, 110);
		}
		return jSPanePeca;
	}


	public JTable getjTablePecas() {
		if(jTablePecas == null){
			jTablePecas = new JTable();
			jTablePecas.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		                {null, null, null, null},
		                {null, null, null, null},
		                {null, null, null, null},
		                {null, null, null, null},
		                {null, null, null, null},
		                {null, null, null, null},
		                {null, null, null, null},
		                {null, null, null, null},
		                {null, null, null, null},
		                {null, null, null, null},
		                {null, null, null, null},
		                {null, null, null, null},
		                
		            },
		            new String [] {
		            	"Cod.Produto", "Qtd.Estoque", "Descrição", "Preço",
		            }
		        ));				

			jTablePecas.setFont(Fontes.fontJTablePlain1);
			jTablePecas.setOpaque(false);
			jTablePecas.getTableHeader().setFont(Fontes.fontJTableBold1);
			jTablePecas.getTableHeader().setForeground(Cores.branco);
			jTablePecas.getTableHeader().setBackground(Cores.azul1);
		}
		return jTablePecas;
	}
	
	
	public Choice getChoicePesquisarPor() {
		if(choicePesquisarPor == null){
			choicePesquisarPor = new Choice();
			choicePesquisarPor.setSize(175, 50);
			choicePesquisarPor.setFont(Fontes.fontJTFieldPlain1);
			choicePesquisarPor.setVisible(true);
			choicePesquisarPor.add("Descrição Peça");
			choicePesquisarPor.add("Código Peça");
			choicePesquisarPor.setFocusable(false);
	
		}
		return choicePesquisarPor;
	}
	
	
	//** Fim getters conjuto JScrollPane/JTable **
	
	//** Início métodos adição de componentes **
	
	
	public void addCompJDialogProcurarPeca() {

		/*getJDialogProcurarPeca().getContentPane().add(getjPanelBarraMenu());
		getjPanelBarraMenu().setLocation(0, 0);*/

		getJDialogProcurarPeca().getContentPane().add(getjLabelPesquisarPor());
		getjLabelPesquisarPor().setLocation(50, 40);
		
		getJDialogProcurarPeca().getContentPane().add(getChoicePesquisarPor());
		getChoicePesquisarPor().setLocation(155, 40);

		getJDialogProcurarPeca().getContentPane().add(getjTFieldProcurar());
		getjTFieldProcurar().setLocation(319, 40);
		
		getJDialogProcurarPeca().getContentPane().add(getjButtonProcurar());
		getjButtonProcurar().setLocation(511, 40);

		getJDialogProcurarPeca().getContentPane().add(getjSPanePeca());
		getjSPanePeca().setLocation(50, 100);

		getJDialogProcurarPeca().getContentPane().add(getjButtonCancelar());
		getjButtonCancelar().setLocation(744, 235);

		getJDialogProcurarPeca().getContentPane().add(getjButtonSelecionar());
		getjButtonSelecionar().setLocation(860, 235);
	}
	
	
	// utilizar caso venha ser criada um jdialog comm o undecored true
	/*public void addCompJPanelBarraMenu() {

		getjPanelBarraMenu().add(getjLabelTituloTela());
		getjLabelTituloTela().setLocation(((getjPanelBarraMenu().getWidth()/2) + (getjLabelTituloTela().getWidth()/2)), 0);

		getjPanelBarraMenu().add(getjButtonFecharTela());
		getjButtonFecharTela().setLocation(getjPanelBarraMenu().getWidth() - (5 + getjButtonFecharTela().getWidth()), 0);
	}*/
	
	//** Fim métodos adição de componentes **
	

}