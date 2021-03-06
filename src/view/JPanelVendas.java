package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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


	
	//** In�cio declara��o de vari�veis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	private String tituloDescricaoTela; // t�tulo que descreve a tela que foi chamanda no JPanelPrincipal
	private ModuloConexao moduloConexao;
	
	private JButton jButtonNovaVenda;
	private JButton jButtonImprimir;
	private JButton jButtonApagar;
	private JButton jButtonFiltrar;
	private JButton jButtonPesquisarTodos;
	
	private JLabel jLabelDTInicial;
	private JLabel jLabelDTFinal;
	private JLabel jLabelCliente;
	
	private JFormattedTextField jTFieldDTInicial;
	private JFormattedTextField jTFieldDTFinal;
	private JTextField jTFieldCliente;
	
	private JPanel jPanelBuscaVenda; // barra que contem componentes para realizar busca de vendas
	
	private JScrollPane jSPVendas;
	
	private JTable jTableVendas;
		
	//** Fim declara��o de vari�veis **
	
	//** In�cio construtor **



	public JPanelVendas() {
		this.addCompJPanelBuscaVenda();
		this.addCompJPanelVendas();
	}
	
	//** Fim construtor **
	
	//** In�cio getters JPanels **

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
	
	//** In�cio getters JLabel **
		
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
			jLabelDTInicial.setSize(80,21);
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
			jLabelDTFinal.setSize(70,21);	
		}
		return jLabelDTFinal;
	}
	

	public JLabel getjLabelCliente() {
		if(jLabelCliente == null){
			jLabelCliente = new JLabel();
			jLabelCliente.setFont(Fontes.fontJLabelPlain1);
			jLabelCliente.setForeground(Cores.preto);
			jLabelCliente.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelCliente.setText("Cliente");
			jLabelCliente.setOpaque(false);
			jLabelCliente.setSize(50,21);	
		}
		return jLabelCliente;
	}
	
	
	//** Fim getters JLabel **
	
	//** In�cio getters JButon **
	
	public JButton getjButtonNovaVenda() {
		if(jButtonNovaVenda == null){
			jButtonNovaVenda = new JButton();			
			jButtonNovaVenda.setFont(Fontes.fontJButtonPlain2);
			jButtonNovaVenda.setBackground(Cores.azul1);
			jButtonNovaVenda.setForeground(Color.white);
			jButtonNovaVenda.setHorizontalTextPosition(SwingConstants.LEFT);
			setSizeIcon.setIconJButton(jButtonNovaVenda, Icones.
					getAddCompra(), 25, 25);
			jButtonNovaVenda.setText("Nova");
			jButtonNovaVenda.setSize(125, 35);
			jButtonNovaVenda.setFocusable(false);
			jButtonNovaVenda.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}
		return jButtonNovaVenda;
	}

	
	public JButton getjButtonImprimir() {
		if(jButtonImprimir == null){
			jButtonImprimir = new JButton();			
			jButtonImprimir.setFont(Fontes.fontJButtonPlain3);
			jButtonImprimir.setBackground(Cores.azul1);
			jButtonImprimir.setForeground(Color.white);
			setSizeIcon.setIconJButton(jButtonImprimir, Icones.
					getImprimir(), 30, 30);
			jButtonImprimir.setSize(56, 35);
			jButtonImprimir.setFocusable(false);
			jButtonImprimir.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}
		return jButtonImprimir;
	}

	
	public JButton getjButtonApagar() {
		if(jButtonApagar == null){
			jButtonApagar = new JButton();			
			jButtonApagar.setFont(Fontes.fontJButtonPlain3);
			jButtonApagar.setBackground(Cores.azul1);
			jButtonApagar.setForeground(Color.white);
			setSizeIcon.setIconJButton(jButtonApagar, Icones.
					getApagar(), 30, 30);
			jButtonApagar.setSize(56, 35);
			jButtonApagar.setFocusable(false);
			jButtonApagar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}
		return jButtonApagar;
	}
	

	public JButton getjButtonFiltrar() {
		if(jButtonFiltrar == null){
			jButtonFiltrar = new JButton();			
			jButtonFiltrar.setFont(Fontes.fontJButtonPlain2);
			jButtonFiltrar.setBackground(Cores.azul1);
			jButtonFiltrar.setForeground(Color.white);
			jButtonFiltrar.setHorizontalTextPosition(SwingConstants.LEFT);
			setSizeIcon.setIconJButton(jButtonFiltrar, Icones.
					getFiltrar(), 25, 25);
			jButtonFiltrar.setText("Filtrar");
			jButtonFiltrar.setSize(125, 32);
			jButtonFiltrar.setFocusable(false);
			jButtonFiltrar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));

		}
		return jButtonFiltrar;
	}
	

	public JButton getjButtonPesquisarTodos() {
		if(jButtonPesquisarTodos == null){
			jButtonPesquisarTodos = new JButton();			
			jButtonPesquisarTodos.setFont(Fontes.fontJButtonPlain2);
			jButtonPesquisarTodos.setBackground(Cores.azul1);
			jButtonPesquisarTodos.setForeground(Color.white);
			jButtonPesquisarTodos.setHorizontalTextPosition(SwingConstants.LEFT);
			setSizeIcon.setIconJButton(jButtonPesquisarTodos, Icones.
					getBuscarCompra(), 25, 25);
			jButtonPesquisarTodos.setText("buscar todos");
			jButtonPesquisarTodos.setSize(125, 32);
			jButtonPesquisarTodos.setFocusable(false);
			jButtonPesquisarTodos.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		
		}
		return jButtonPesquisarTodos;
	}
	
	//** Fim getters JButon **
	
	
	
	//** In�cio getters JFields **
	
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
			jTFieldDTInicial.setSize(85, 21);
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
			jTFieldDTFinal.setSize(85, 21);
			jTFieldDTFinal.setOpaque(true);
		}
		return jTFieldDTFinal;
	}

	
	public JTextField getjTFieldCliente() {
		if(jTFieldCliente == null){
			jTFieldCliente = new JTextField();
			jTFieldCliente.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldCliente.setForeground(Cores.preto);
			jTFieldCliente.setFont(Fontes.fontJTFieldPlain1);
			jTFieldCliente.setSize(195, 21);
			jTFieldCliente.setOpaque(true);
		}
		return jTFieldCliente;
	}
	
	
	//** Fim getters JFields **
	
	
	
	//** In�cio getters JComboBox **
	
	
	
	//** Fim getters JComboBox **
	
	//** In�cio getters conjuto JScrollPane/JTable **
	
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
					"N�",
					"Data",
					"Vendedor",
					"Cliente",
					"Qtd. Pe�as",
					"Desconto",
					"Total"));					

			jTableVendas.setFont(Fontes.fontJTablePlain2);
			jTableVendas.setOpaque(false);
			jTableVendas.getTableHeader().setFont(Fontes.fontJTableBold2);
			jTableVendas.getTableHeader().setForeground(Cores.branco);
			jTableVendas.getTableHeader().setBackground(Cores.azul1);
		}
		return jTableVendas;
	}
	
	
	//** Fim getters conjuto JScrollPane/JTable **
		
	//** In�cio m�todos adi��o de componentes **	

	

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
		this.getjLabelDTInicial().setLocation(10, 14);

		this.getjPanelBuscaVenda().add(this.getjTFieldDTInicial());
		this.getjTFieldDTInicial().setLocation(92, 14);

		this.getjPanelBuscaVenda().add(this.getjLabelDTFinal());
		this.getjLabelDTFinal().setLocation(184, 14);

		this.getjPanelBuscaVenda().add(this.getjTFieldDTFinal());
		this.getjTFieldDTFinal().setLocation(257, 14);

		this.getjPanelBuscaVenda().add(this.getjLabelCliente());
		this.getjLabelCliente().setLocation(349, 14);

		this.getjPanelBuscaVenda().add(this.getjTFieldCliente());
		this.getjTFieldCliente().setLocation(400, 14);

		this.getjPanelBuscaVenda().add(this.getjButtonFiltrar());
		this.getjButtonFiltrar().setLocation(730, 9);

		this.getjPanelBuscaVenda().add(this.getjButtonPesquisarTodos());
		this.getjButtonPesquisarTodos().setLocation(865, 9);
	}
	
	//** Fim m�todos adi��o de componentes **

	
	private ModuloConexao getModuloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}		
		return moduloConexao;
	}

}
