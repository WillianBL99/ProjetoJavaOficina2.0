/**
 * 
 */
package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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

/**
 * @author pWili
 *
 */
@SuppressWarnings("serial")
public class JPanelEstoque  extends JPanel{


	
	//** Início declaração de variáveis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	private ModuloConexao moduloConexao;
	private String tituloDescricaoTela; // título que descreve a tela que foi chamanda no JPanelPrincipal
	
	private JButton jButtonAdicionar;
	private JButton jButtonEditar;
	private JButton jButtonApagar;
	private JButton jButtonFiltrar;
	private JButton jButtonPesquisarTodos;
	
	private JTextField jTFieldBuscarPor;
	
	private JPanel jPanelBuscaEstoque; // barra que contem componentes para realizar busca de vendas
	
	private JScrollPane jSPEstoque;
	
	private JTable jTableEstoque;
	
	private Choice choicePesquisarPor;
		
	//** Fim declaração de variáveis **
	
	//** Início construtor **



	public JPanelEstoque() {
		this.addCompJPanelBuscaEstoque();
		this.addCompJPanelEstoque();
	}
	
	//** Fim construtor **
	
	//** Início getters JPanels **

	public JPanelEstoque getJPanelEstoque() { // OK
		this.setLayout(null);
		this.setBackground(Cores.cinza3);
		this.setSize(new Dimension(1030,674));
		this.setVisible(true);
		return this;
	}
	
	
	public JPanel getjPanelBuscaEstoque() {
		if(jPanelBuscaEstoque == null){
			jPanelBuscaEstoque = new JPanel();
			jPanelBuscaEstoque.setLayout(null);
			jPanelBuscaEstoque.setBackground(Cores.branco);
			jPanelBuscaEstoque.setSize(990, 50);
			jPanelBuscaEstoque.setBorder(null);
		}
		return jPanelBuscaEstoque;
	}
	
	//** Fim getters JPanel **
	
	//** Início getters JLabel **
		
	public String getTituloDescricaoTela() {
		if(tituloDescricaoTela == null){	
			tituloDescricaoTela = "Estoque";	
		}
		return tituloDescricaoTela;
	}
	
		
	//** Fim getters JLabel **
	
	//** Início getters JButon **
	
	public JButton getjButtonAdicionar() {
		if(jButtonAdicionar == null){
			jButtonAdicionar = new JButton();			
			jButtonAdicionar.setFont(Fontes.fontJButtonPlain3);
			jButtonAdicionar.setBackground(Cores.azul1);
			jButtonAdicionar.setForeground(Color.white);
			setSizeIcon.setIconJButton(jButtonAdicionar, Icones.
					getEstoqueAdicionar(), 30, 30);
			jButtonAdicionar.setSize(56, 35);
			jButtonAdicionar.setFocusable(false);
			jButtonAdicionar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}
		return jButtonAdicionar;
	}
	
	
	public JButton getjButtonEditar() {
		if(jButtonEditar == null){
			jButtonEditar = new JButton();			
			jButtonEditar.setFont(Fontes.fontJButtonPlain3);
			jButtonEditar.setBackground(Cores.azul1);
			jButtonEditar.setForeground(Color.white);
			setSizeIcon.setIconJButton(jButtonEditar, Icones.
					getEstoqueEditar(), 30, 30);
			jButtonEditar.setSize(56, 35);
			jButtonEditar.setFocusable(false);
			jButtonEditar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}
		return jButtonEditar;
	}

	
	public JButton getjButtonApagar() {
		if(jButtonApagar == null){
			jButtonApagar = new JButton();			
			jButtonApagar.setFont(Fontes.fontJButtonPlain3);
			jButtonApagar.setBackground(Cores.azul1);
			jButtonApagar.setForeground(Color.white);
			setSizeIcon.setIconJButton(jButtonApagar, Icones.
					getEstoqueExcluir(), 30, 30);
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
			jButtonFiltrar.setFont(Fontes.fontJButtonPlain1);
			jButtonFiltrar.setBackground(Cores.azul1);
			jButtonFiltrar.setForeground(Color.white);
			jButtonFiltrar.setHorizontalTextPosition(SwingConstants.LEFT);
			setSizeIcon.setIconJButton(jButtonFiltrar, Icones.
					getFiltrar(), 14, 14);
			jButtonFiltrar.setText("Filtrar");
			jButtonFiltrar.setSize(61, 22);
			jButtonFiltrar.setFocusable(false);
			jButtonFiltrar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));

		}
		return jButtonFiltrar;
	}
	

	public JButton getjButtonPesquisarTodos() {
		if(jButtonPesquisarTodos == null){
			jButtonPesquisarTodos = new JButton();			
			jButtonPesquisarTodos.setFont(Fontes.fontJButtonPlain1);
			jButtonPesquisarTodos.setBackground(Cores.azul1);
			jButtonPesquisarTodos.setForeground(Color.white);
			jButtonPesquisarTodos.setHorizontalTextPosition(SwingConstants.LEFT);
			setSizeIcon.setIconJButton(jButtonPesquisarTodos, Icones.
					getEstoqueOn(), 18, 18);
			jButtonPesquisarTodos.setText("pesquisar todos");
			jButtonPesquisarTodos.setSize(118, 22);
			jButtonPesquisarTodos.setFocusable(false);
			jButtonPesquisarTodos.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		
		}
		return jButtonPesquisarTodos;
	}
	
	//** Fim getters JButon **
	
	
	
	//** Início getters JFields **
	
	
	public JTextField getjTFieldBuscarPor() {
		if(jTFieldBuscarPor == null){
			jTFieldBuscarPor = new JTextField();
			jTFieldBuscarPor.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldBuscarPor.setForeground(Cores.preto);
			jTFieldBuscarPor.setFont(Fontes.fontJTFieldPlain1);
			jTFieldBuscarPor.setSize(195, 21);
			jTFieldBuscarPor.setOpaque(true);
		}
		return jTFieldBuscarPor;
	}
	
	
	//** Fim getters JFields **
	
	
	
	//** Início getters JComboBox **
	
	public Choice getchoicePesquisarPor() {
		if(choicePesquisarPor == null){
			choicePesquisarPor = new Choice();
			choicePesquisarPor.setSize(150, 25);
			choicePesquisarPor.setFont(Fontes.fontJTFieldPlain1);
			choicePesquisarPor.setVisible(true);
			choicePesquisarPor.add("Cliente             ");
			choicePesquisarPor.add("Placa               ");
			choicePesquisarPor.setFocusable(false);	
		}
		return choicePesquisarPor;
	}
		
		
		
		//** Fim getters JComboBox **
	
	//** Início getters conjuto JScrollPane/JTable **
	
	public JScrollPane getjSPEstoque() {
		if(jSPEstoque == null){
			jSPEstoque = new JScrollPane();
			jSPEstoque.setViewportView(getjTableEstoque());
			jSPEstoque.setSize(1000, 225);	
		}
		return jSPEstoque;
	}
	

	public JTable getjTableEstoque() {
		if(jTableEstoque == null){
			jTableEstoque = new JTable();
			
			getModuloConexao().executeQuery(ComandosSQL.getconsultarProdutos());			
			jTableEstoque.setModel(new PreencherTabela().preencher(getModuloConexao().getResultSet(), 
	                "Código",
	                "Descrição",
	                "Marca",
	                "Quantidade",
	                "Preço"));
			
			jTableEstoque.setFont(Fontes.fontJTablePlain2);
			jTableEstoque.setOpaque(false);
			jTableEstoque.getTableHeader().setFont(Fontes.fontJTableBold2);
			jTableEstoque.getTableHeader().setForeground(Cores.branco);
			jTableEstoque.getTableHeader().setBackground(Cores.azul1);
		}
		return jTableEstoque;
	}
	
	
	//** Fim getters conjuto JScrollPane/JTable **
		
	//** Início métodos adição de componentes **	

	

	public void addCompJPanelEstoque() { 
	
		this.getJPanelEstoque().add(this.getjButtonAdicionar());
		this.getjButtonAdicionar().setLocation(818, 20);
	
		this.getJPanelEstoque().add(this.getjButtonEditar());
		this.getjButtonEditar().setLocation(884, 20);
		
		this.getJPanelEstoque().add(this.getjButtonApagar());
		this.getjButtonApagar().setLocation(950, 20);
		
		this.getJPanelEstoque().add(this.getjPanelBuscaEstoque());
		this.getjPanelBuscaEstoque().setLocation(14, 75);
		
		this.getJPanelEstoque().add(this.getjSPEstoque());
		this.getjSPEstoque().setLocation(14, 145);
	}

	
	public void addCompJPanelBuscaEstoque() {		

		this.getjPanelBuscaEstoque().add(this.getchoicePesquisarPor());
		this.getchoicePesquisarPor().setLocation(14, 16);
		
		this.getjPanelBuscaEstoque().add(this.getjTFieldBuscarPor());
		this.getjTFieldBuscarPor().setLocation(180, 16);

		this.getjPanelBuscaEstoque().add(this.getjButtonFiltrar());
		this.getjButtonFiltrar().setLocation(800, 16);

		this.getjPanelBuscaEstoque().add(this.getjButtonPesquisarTodos());
		this.getjButtonPesquisarTodos().setLocation(874, 16);
	}
	
	//** Fim métodos adição de componentes **

	
	private ModuloConexao getModuloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}
		
		return moduloConexao;
	}
	

}