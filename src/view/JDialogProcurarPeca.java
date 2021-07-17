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
import model.Cores;
import model.Fontes;

/**
 * @author Paulo Uilian
 *
 */
@SuppressWarnings("serial")
public class JDialogProcurarPeca extends JDialog{	
	
	
	//** Início declaração de variáveis **
	
	private boolean modal;
	private JButton jButtonCancelar;
	private JButton jButtonSelecionar;

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
		this.getContentPane().setBackground(Cores.cinza5);
		this.setSize(975, 310);
		this.setVisible(true);
		this.setModal(modal);
		
		return this;
	}	
	
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
			jTablePecas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
			choicePesquisarPor.add("Código                  ");
			choicePesquisarPor.add("Descrição               ");
			choicePesquisarPor.add("Marca                   ");
			choicePesquisarPor.setFocusable(false);	
	
		}
		return choicePesquisarPor;
	}
	
	
	//** Fim getters conjuto JScrollPane/JTable **
	
	//** Início métodos adição de componentes **
	
	
	public void addCompJDialogProcurarPeca() {

		getJDialogProcurarPeca().getContentPane().add(getjLabelPesquisarPor());
		getjLabelPesquisarPor().setLocation(50, 40);
		
		getJDialogProcurarPeca().getContentPane().add(getChoicePesquisarPor());
		getChoicePesquisarPor().setLocation(155, 40);

		getJDialogProcurarPeca().getContentPane().add(getjTFieldProcurar());
		getjTFieldProcurar().setLocation(319, 40);

		getJDialogProcurarPeca().getContentPane().add(getjSPanePeca());
		getjSPanePeca().setLocation(50, 100);

		getJDialogProcurarPeca().getContentPane().add(getjButtonCancelar());
		getjButtonCancelar().setLocation(744, 235);

		getJDialogProcurarPeca().getContentPane().add(getjButtonSelecionar());
		getjButtonSelecionar().setLocation(860, 235);
	}
	
	//** Fim métodos adição de componentes **
	

}