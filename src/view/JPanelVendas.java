package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Cores;
import model.Fontes;

public class JPanelVendas extends JPanel{


	
	//** Início declaração de variáveis **
	private JButton jButtonNovaVenda;
	private JButton jButtonImprimir;
	private JButton jButtonApagar;
	private JButton jButtonFiltrar;
	private JButton jButtonPesquisarTodos;
	
	private JLabel jLabelDTInicial;
	private JLabel jLabelDTFinal;
	private JLabel jLabelCliente;
	
	private JTextField jTFieldDTInicial;
	private JTextField jTFieldDTFinal;
	private JTextField jTFieldCliente;
	
	private JPanel jPanelBuscaVenda; // barra que contem componentes para realizar busca de vendas
	
	private JScrollPane jSPVendas;
	
	private JTable jTableVendas;
		
	//** Fim declaração de variáveis **
	
	//** Início construtor **



	public JPanelVendas() {
		
	}
	
	//** Fim construtor **
	
	//** Início getters JPanels **
	
	

	

	public JPanelVendas getJPanelVendas() { // OK
		this.setLayout(null);
		this.setBackground(Cores.cinza3);
		this.setSize(new Dimension(1030,674));
		this.setVisible(true);
		return this;
	}
	
	
	public JPanel getjPanelBuscaVenda() {
		if(jPanelBuscaVenda == null){
			jPanelBuscaVenda = new JPanel();
			jPanelBuscaVenda.setLayout(null);
			jPanelBuscaVenda.setBackground(Cores.branco);
			jPanelBuscaVenda.setSize(1000, 50);
			jPanelBuscaVenda.setBorder(null);
		}
		return jPanelBuscaVenda;
	}
	
	//** Fim getters JPanel **
	
	//** Início getters JLabel **
		

	public JLabel getjLabelDTInicial() {
		if(jLabelDTInicial == null){
			jLabelDTInicial = new JLabel();
			jLabelDTInicial.setFont(Fontes.fontTitleTField);
			jLabelDTInicial.setForeground(Cores.preto);
			jLabelDTInicial.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelDTInicial.setText("Data inicial");
			jLabelDTInicial.setOpaque(false);
			jLabelDTInicial.setSize(80,21);
		}
		return jLabelDTInicial;
	}
	

	public JLabel getjLabelDTFinal() {
		if(jLabelDTFinal == null){
			jLabelDTFinal = new TODO;
	
		}
		return jLabelDTFinal;
	}
	

	public JLabel getjLabelCliente() {
		if(jLabelCliente == null){
			jLabelCliente = new TODO;
	
		}
		return jLabelCliente;
	}
	
	
	//** Fim getters JLabel **
	
	//** Início getters JButon **
	
	public JButton getjButtonNovaVenda() {
		if(jButtonNovaVenda == null){
			jButtonNovaVenda = new TODO;
	
		}
		return jButtonNovaVenda;
	}

	
	public JButton getjButtonImprimir() {
		if(jButtonImprimir == null){
			jButtonImprimir = new TODO;
	
		}
		return jButtonImprimir;
	}

	
	public JButton getjButtonApagar() {
		if(jButtonApagar == null){
			jButtonApagar = new TODO;
	
		}
		return jButtonApagar;
	}
	

	public JButton getjButtonFiltrar() {
		if(jButtonFiltrar == null){
			jButtonFiltrar = new TODO;
	
		}
		return jButtonFiltrar;
	}
	

	public JButton getjButtonPesquisarTodos() {
		if(jButtonPesquisarTodos == null){
			jButtonPesquisarTodos = new TODO;
	
		}
		return jButtonPesquisarTodos;
	}
	
	//** Fim getters JButon **
	
	
	
	//** Início getters JFields **
	
	public JTextField getjTFieldDTInicial() {
		if(jTFieldDTInicial == null){
			jTFieldDTInicial = new TODO;
	
		}
		return jTFieldDTInicial;
	}

	
	public JTextField getjTFieldDTFinal() {
		if(jTFieldDTFinal == null){
			jTFieldDTFinal = new TODO;
	
		}
		return jTFieldDTFinal;
	}

	
	public JTextField getjTFieldCliente() {
		if(jTFieldCliente == null){
			jTFieldCliente = new TODO;
	
		}
		return jTFieldCliente;
	}
	
	
	//** Fim getters JFields **
	
	
	
	//** Início getters JComboBox **
	
	
	
	//** Fim getters JComboBox **
	
	//** Início getters conjuto JScrollPane/JTable **
	
	public JScrollPane getjSPVendas() {
		if(jSPVendas == null){
			jSPVendas = new TODO;
	
		}
		return jSPVendas;
	}
	

	public JTable getjTableVendas() {
		if(jTableVendas == null){
			jTableVendas = new TODO;
	
		}
		return jTableVendas;
	}
	
	
	//** Fim getters conjuto JScrollPane/JTable **
		
	//** Início métodos adição de componentes **	

	

	public void addCompJPanelVendas() { 
	
	}

	


	

	

	

	
	
	//** Fim métodos adição de componentes **
	

}
