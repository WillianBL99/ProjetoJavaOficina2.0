/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
public class JDialogProcurarVeiculo extends JDialog{


	
	
	
	//** Início declaração de variáveis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	
	private boolean modal;
	
	private JButton jButtonCancelar;
	private JButton jButtonSelecionar;
	private JButton jButtonProcurar;	

	private JTextField jTFieldProcurar;
	
	private JLabel jLabelPesquisarPor;
	
	private JScrollPane jSPaneVeiculos;
	
	private JTable jTableVeiculos;

	private Choice choicePesquisarPor;
	
	
	//** Fim declaração de variáveis **
	
	//** Início construtor **
	public JDialogProcurarVeiculo(Frame frame, boolean modal) {
		super(frame,"Cadastrar veículo");
		this.modal = modal;
		this.addCompJDialogProcurarVeiculo();
	}	

	
	//** Fim construtor **
	
	//** Início getters JPanels **
	public JDialogProcurarVeiculo getJDialogProcurarVeiculo() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setBackground(Cores.branco);
		this.setSize(975, 310);
		this.setVisible(true);
		this.setModal(modal);
		return this;
	}
	
	
	
	
	//** Fim getters JPanel **
	
	//** Início getters JLabel **
	
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
	
	public JScrollPane getjSPaneVeiculos() {
		if(jSPaneVeiculos == null){
			jSPaneVeiculos = new JScrollPane();
			jSPaneVeiculos.setViewportView(getjTableVeiculos());
			jSPaneVeiculos.setSize(900, 110);
		}
		return jSPaneVeiculos;
	}


	public JTable getjTableVeiculos() {
		if(jTableVeiculos == null){
			jTableVeiculos = new JTable();
			jTableVeiculos.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		                {null, null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null, null},
		                
		            },
		            new String [] {
		                "Nº Veículo", "Placa", "Chassi", "Marca",
		                "Modelo", "Motor", "Combustível", "Cor", "Ano"
		            }
		        ));				

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
			choicePesquisarPor.add("Descrição produto");
			choicePesquisarPor.add("Código produto");
			choicePesquisarPor.setFocusable(false);
	
		}
		return choicePesquisarPor;
	}
	
	
	//** Fim getters conjuto JScrollPane/JTable **
	
	//** Início métodos adição de componentes **
	
	
	public void addCompJDialogProcurarVeiculo() {

		getJDialogProcurarVeiculo().getContentPane().add(getjLabelPesquisarPor());
		getjLabelPesquisarPor().setLocation(50, 40);
		
		getJDialogProcurarVeiculo().getContentPane().add(getChoicePesquisarPor());
		getChoicePesquisarPor().setLocation(155, 40);

		getJDialogProcurarVeiculo().getContentPane().add(getjTFieldProcurar());
		getjTFieldProcurar().setLocation(319, 40);
		
		getJDialogProcurarVeiculo().getContentPane().add(getjButtonProcurar());
		getjButtonProcurar().setLocation(511, 40);

		getJDialogProcurarVeiculo().getContentPane().add(getjSPaneVeiculos());
		getjSPaneVeiculos().setLocation(50, 100);

		getJDialogProcurarVeiculo().getContentPane().add(getjButtonCancelar());
		getjButtonCancelar().setLocation(744, 235);

		getJDialogProcurarVeiculo().getContentPane().add(getjButtonSelecionar());
		getjButtonSelecionar().setLocation(860, 235);
	}
	
	//** Fim métodos adição de componentes **
	

}