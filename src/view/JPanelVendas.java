package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import dao.ComandosSQL;
import dao.ModuloConexao;
import dao.PreencherTabela;
import icons.Icones;
import model.Cores;
import model.Fontes;
import model.SetSizeIcon;

@SuppressWarnings("serial")
public class JPanelVendas extends JPanel{


	
	//** Início declaração de variáveis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	private String tituloDescricaoTela; // título que descreve a tela que foi chamanda no JPanelPrincipal
	private ModuloConexao moduloConexao;
	
	private JButton jButtonNovaVenda;
	private JButton jButtonImprimir;
	private JButton jButtonApagar;
	private JButton jButtonFiltrar;
	private JButton jButtonPesquisarTodos;
	
	private JLabel jLabelDTInicial;
	private JLabel jLabelDTFinal;
	
	private JFormattedTextField jTFieldDTInicial;
	private JFormattedTextField jTFieldDTFinal;
	private JTextField jTFieldFormPesquisa;
	
	private Choice choiceFormPesquisa;
	
	private JPanel jPanelBuscaVenda; // barra que contem componentes para realizar busca de vendas
	
	private JScrollPane jSPVendas;
	
	private JTable jTableVendas;
		
	//** Fim declaração de variáveis **
	
	//** Início construtor **



	public JPanelVendas() {
		this.addCompJPanelBuscaVenda();
		this.addCompJPanelVendas();
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
		
	public String getTituloDescricaoTela() {
		if(tituloDescricaoTela == null){	
			tituloDescricaoTela = "Vendas";	
		}
		return tituloDescricaoTela;
	}
	
	
	public JLabel getjLabelDTInicial() {
		if(jLabelDTInicial == null){
			jLabelDTInicial = new JLabel();
			jLabelDTInicial.setFont(Fontes.fontJLabelPlain1);
			jLabelDTInicial.setForeground(Cores.preto);
			jLabelDTInicial.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelDTInicial.setText("Data inicial");
			jLabelDTInicial.setOpaque(false);
			jLabelDTInicial.setSize(80,24);
		}
		return jLabelDTInicial;
	}
	

	public JLabel getjLabelDTFinal() {
		
		if(jLabelDTFinal == null){
			jLabelDTFinal = new JLabel();
			jLabelDTFinal.setFont(Fontes.fontJLabelPlain1);
			jLabelDTFinal.setForeground(Cores.preto);
			jLabelDTFinal.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelDTFinal.setText("Data final");
			jLabelDTFinal.setOpaque(false);
			jLabelDTFinal.setSize(70,24);	
		}
		return jLabelDTFinal;
	}
	
	//** Fim getters JLabel **
	
	//** Início getters JButon **
	
	public JButton getjButtonNovaVenda() {
		if(jButtonNovaVenda == null){
			jButtonNovaVenda = new JButton();			
			jButtonNovaVenda.setFont(Fontes.fontJButtonPlain2);
			jButtonNovaVenda.setBackground(Cores.azul1);
			jButtonNovaVenda.setForeground(Color.white);
			jButtonNovaVenda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			setSizeIcon.setIconJButton(jButtonNovaVenda, Icones.
					getAddCompra(), 25, 25);
			jButtonNovaVenda.setSize(56, 35);
			jButtonNovaVenda.setFocusable(false);
			jButtonNovaVenda.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
			jButtonNovaVenda.setToolTipText("Nova venda");
		}
		return jButtonNovaVenda;
	}

	
	public JButton getjButtonImprimir() {
		if(jButtonImprimir == null){
			jButtonImprimir = new JButton();			
			jButtonImprimir.setFont(Fontes.fontJButtonPlain3);
			jButtonImprimir.setBackground(Cores.azul1);
			jButtonImprimir.setForeground(Color.white);
			jButtonImprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			setSizeIcon.setIconJButton(jButtonImprimir, Icones.
					getImprimir(), 30, 30);
			jButtonImprimir.setSize(56, 35);
			jButtonImprimir.setFocusable(false);
			jButtonImprimir.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
			jButtonImprimir.setToolTipText("Imprimir");
		}
		return jButtonImprimir;
	}

	
	public JButton getjButtonApagar() {
		if(jButtonApagar == null){
			jButtonApagar = new JButton();			
			jButtonApagar.setFont(Fontes.fontJButtonPlain3);
			jButtonApagar.setBackground(Cores.azul1);
			jButtonApagar.setForeground(Color.white);
			jButtonApagar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			setSizeIcon.setIconJButton(jButtonApagar, Icones.
					getApagar(), 30, 30);
			jButtonApagar.setSize(56, 35);
			jButtonApagar.setFocusable(false);
			jButtonApagar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
			jButtonApagar.setToolTipText("Apagar");
		}
		return jButtonApagar;
	}
	

	public JButton getjButtonFiltrar() {
		if(jButtonFiltrar == null){
			jButtonFiltrar = new JButton();			
			jButtonFiltrar.setFont(Fontes.fontJButtonPlain2);
			jButtonFiltrar.setBackground(Cores.azul1);
			jButtonFiltrar.setForeground(Color.white);
			jButtonFiltrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			setSizeIcon.setIconJButton(jButtonFiltrar, Icones.
					getFiltrar(), 25, 25);
			jButtonFiltrar.setSize(40, 32);
			jButtonFiltrar.setFocusable(false);
			jButtonFiltrar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
			jButtonFiltrar.setToolTipText("Filtrar pesquisa");

		}
		return jButtonFiltrar;
	}
	

	public JButton getjButtonPesquisarTodos() {
		if(jButtonPesquisarTodos == null){
			jButtonPesquisarTodos = new JButton();			
			jButtonPesquisarTodos.setFont(Fontes.fontJButtonPlain2);
			jButtonPesquisarTodos.setBackground(Cores.azul1);
			jButtonPesquisarTodos.setForeground(Color.white);
			jButtonPesquisarTodos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			setSizeIcon.setIconJButton(jButtonPesquisarTodos, Icones.
					getBuscarCompra(), 25, 25);
			jButtonPesquisarTodos.setSize(40, 32);
			jButtonPesquisarTodos.setFocusable(false);
			jButtonPesquisarTodos.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
			jButtonPesquisarTodos.setToolTipText("Pesquisar todos");
		
		}
		return jButtonPesquisarTodos;
	}
	
	//** Fim getters JButon **
	
	
	
	//** Início getters JFields **
	
	public void setjTFieldDTInicial(JFormattedTextField jTFieldDTInicial) {
		this.jTFieldDTInicial = jTFieldDTInicial;
	}

	
	
	public JFormattedTextField getjTFieldDTInicial() {
		if(jTFieldDTInicial == null){
			jTFieldDTInicial = new JFormattedTextField();
			jTFieldDTInicial.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldDTInicial.setForeground(Cores.preto);
			jTFieldDTInicial.setFont(Fontes.fontJTFieldPlain1);
			jTFieldDTInicial.setSize(85, 24);
			jTFieldDTInicial.setOpaque(true);
		}
		return jTFieldDTInicial;
	}

	
	public JFormattedTextField getjTFieldDTFinal( ) {
		if(jTFieldDTFinal == null){
			jTFieldDTFinal = new JFormattedTextField();
			jTFieldDTFinal.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldDTFinal.setForeground(Cores.preto);
			jTFieldDTFinal.setFont(Fontes.fontJTFieldPlain1);
			jTFieldDTFinal.setSize(85, 24);
			jTFieldDTFinal.setOpaque(true);
		}
		return jTFieldDTFinal;
	}

	
	public JTextField getjTFieldFormPesquisa() {
		if(jTFieldFormPesquisa == null){
			jTFieldFormPesquisa = new JTextField();
			jTFieldFormPesquisa.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldFormPesquisa.setForeground(Cores.preto);
			jTFieldFormPesquisa.setFont(Fontes.fontJTFieldPlain1);
			jTFieldFormPesquisa.setSize(240, 24);
			jTFieldFormPesquisa.setOpaque(true);
		}
		return jTFieldFormPesquisa;
	}
	
	
	//** Fim getters JFields **
	
	
	
	//** Início getters Choice **
	
	public Choice getChoiceFormPesquisa() {
		if(choiceFormPesquisa == null) {
			choiceFormPesquisa = new Choice();			
			choiceFormPesquisa.setSize(150, 24);
			choiceFormPesquisa.setFont(Fontes.fontJTFieldPlain1);
			choiceFormPesquisa.setForeground(Cores.preto);
			choiceFormPesquisa.setVisible(true);
			choiceFormPesquisa.setFocusable(false);	
			choiceFormPesquisa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			choiceFormPesquisa.add(String.format("%-150s", "Vendedor"));			
			choiceFormPesquisa.add(String.format("%-150s", "Cliente"));			
			choiceFormPesquisa.add(String.format("%-150s", "Cartão"));			
			choiceFormPesquisa.add(String.format("%-150s", "Dinheiro"));
		}
		return choiceFormPesquisa;
	}
	
	
	//** Fim getters Choice **
	
	//** Início getters conjuto JScrollPane/JTable **
	
	public JScrollPane getjSPVendas() {
		if(jSPVendas == null){
			jSPVendas = new JScrollPane();
			jSPVendas.setViewportView(getjTableVendas());
			jSPVendas.setSize(1000, 500);	
		}
		return jSPVendas;
	}
	

	/**
	 * @param jTFieldDTInicial the jTFieldDTInicial to set
	 */

	public JTable getjTableVendas() {
		if(jTableVendas == null){
			jTableVendas = new JTable();
			getModuloConexao().executeQuery(ComandosSQL.consultarVendasTodasTodas());
			jTableVendas.setModel(new PreencherTabela().preencher(getModuloConexao().getResultSet(),
					"Nº",
					"Data",
					"Vendedor",
					"Cliente",
					"Forma Pag.",
					"Qtd. Peças",
					"Desconto",
					"Total"));					

			jTableVendas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jTableVendas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jTableVendas.setShowVerticalLines(false);
			jTableVendas.setRowHeight(23);
			jTableVendas.getColumnModel().getColumn(0).setMaxWidth(50);
			jTableVendas.getColumnModel().getColumn(4).setMaxWidth(110);
			jTableVendas.getColumnModel().getColumn(4).setMinWidth(110);
			jTableVendas.getColumnModel().getColumn(5).setMaxWidth(110);
			jTableVendas.getColumnModel().getColumn(5).setMinWidth(110);
			jTableVendas.getColumnModel().getColumn(6).setMaxWidth(90);
			jTableVendas.getColumnModel().getColumn(6).setMinWidth(90);
			jTableVendas.getColumnModel().getColumn(7).setMaxWidth(90);
			jTableVendas.getColumnModel().getColumn(7).setMinWidth(90);
			jTableVendas.setFont(Fontes.fontJTablePlain2);
			jTableVendas.setOpaque(false);
			jTableVendas.getTableHeader().setReorderingAllowed(false);
			jTableVendas.getTableHeader().setFont(Fontes.fontJTableBold2);
			jTableVendas.getTableHeader().setForeground(Cores.branco);
			jTableVendas.getTableHeader().setBackground(Cores.azul1);
		}
		return jTableVendas;
	}
	
	
	//** Fim getters conjuto JScrollPane/JTable **
		
	//** Início métodos adição de componentes **	

	

	public void addCompJPanelVendas() { 
	
		this.getJPanelVendas().add(this.getjButtonNovaVenda());
		this.getjButtonNovaVenda().setLocation(14, 15);
		
		this.getJPanelVendas().add(this.getjButtonImprimir());
		this.getjButtonImprimir().setLocation(887, 15);
		
		this.getJPanelVendas().add(this.getjButtonApagar());
		this.getjButtonApagar().setLocation(958, 15);
		
		this.getJPanelVendas().add(this.getjPanelBuscaVenda());
		this.getjPanelBuscaVenda().setLocation(14, 65);
		
		this.getJPanelVendas().add(this.getjSPVendas());
		this.getjSPVendas().setLocation(14, 130);
	}

	
	public void addCompJPanelBuscaVenda() { 
		
		this.getjPanelBuscaVenda().add(this.getjLabelDTInicial());
		this.getjLabelDTInicial().setLocation(10, 13);

		this.getjPanelBuscaVenda().add(this.getjTFieldDTInicial());
		this.getjTFieldDTInicial().setLocation(92, 13);
		

		this.getjPanelBuscaVenda().add(this.getjLabelDTFinal());
		this.getjLabelDTFinal().setLocation(184, 13);

		this.getjPanelBuscaVenda().add(this.getjTFieldDTFinal());
		this.getjTFieldDTFinal().setLocation(257, 13);		
		
		
		this.getjPanelBuscaVenda().add(this.getChoiceFormPesquisa());
		this.getChoiceFormPesquisa().setLocation(362,13);
		
		this.getjPanelBuscaVenda().add(this.getjTFieldFormPesquisa());
		this.getjTFieldFormPesquisa().setLocation(484, 13);

		
		this.getjPanelBuscaVenda().add(this.getjButtonFiltrar());
		this.getjButtonFiltrar().setLocation(886, 9);

		
		this.getjPanelBuscaVenda().add(this.getjButtonPesquisarTodos());
		this.getjButtonPesquisarTodos().setLocation(941, 9);
	}
	
	//** Fim métodos adição de componentes **

	
	private ModuloConexao getModuloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}		
		return moduloConexao;
	}

}
