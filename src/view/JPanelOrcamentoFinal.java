/**
 * 
 */
package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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

@SuppressWarnings("serial")
public class JPanelOrcamentoFinal  extends JPanel {


	
	//** Início declaração de variáveis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	private String tituloDescricaoTela; // título que descreve a tela que foi chamanda no JPanelPrincipal

	private JPanel jPanelBuscaOrcamentos; // barra que contem componentes para realizar busca de orcamentos
	
	private JButton jButtonNovoOrcamentoFinal;
	private JButton jButtonImprimir;
	private JButton jButtonEditar;
	private JButton jButtonApagar;
	private JButton jButtonFiltrar;
	private JButton jButtonPesquisarTodos;
	
	private JLabel jLabelDTInicial;
	private JLabel jLabelDTFinal;
	
	private JTextField jTFieldDTInicial;
	private JTextField jTFieldDTFinal;
	private JTextField jTFieldPesquisarPor;
	
	private Choice choicePesquisarPor;
	
	private JScrollPane jSPOrcamentos;
	
	private JTable jTableOrcamentos;
		
	//** Fim declaração de variáveis **
	
	//** Início construtor **



	public JPanelOrcamentoFinal() {
		this.addCompJPanelBuscaOrcamentos();
		this.addCompJPanelOrcamentoFinal();
	}
	
	//** Fim construtor **
	
	//** Início getters JPanels **

	public JPanelOrcamentoFinal getJPanelOrcamentoFinal() { // OK
		this.setLayout(null);
		this.setBackground(Cores.cinza3);
		this.setSize(new Dimension(1030,674));
		this.setVisible(true);
		return this;
	}
	
	
	public JPanel getjPanelBuscaOrcamentos() {
		if(jPanelBuscaOrcamentos == null){
			jPanelBuscaOrcamentos = new JPanel();
			jPanelBuscaOrcamentos.setLayout(null);
			jPanelBuscaOrcamentos.setBackground(Cores.branco);
			jPanelBuscaOrcamentos.setSize(990, 50);
			jPanelBuscaOrcamentos.setBorder(null);
		}
		return jPanelBuscaOrcamentos;
	}
	
	//** Fim getters JPanel **
	
	//** Início getters JLabel **
	
	public String getTituloDescricaoTela() {
		if(tituloDescricaoTela == null){	
			tituloDescricaoTela = "Orçamento Final";	
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
	
	//** Fim getters JLabel **
	
	//** Início getters JButon **
	
	
	public JButton getjButtonNovoOrcamentoFinal() {
		if(jButtonNovoOrcamentoFinal == null){
			jButtonNovoOrcamentoFinal = new JButton();			
			jButtonNovoOrcamentoFinal.setFont(Fontes.fontJButtonPlain3);
			jButtonNovoOrcamentoFinal.setBackground(Cores.azul1);
			jButtonNovoOrcamentoFinal.setForeground(Color.white);
			jButtonNovoOrcamentoFinal.setHorizontalTextPosition(SwingConstants.LEFT);
			setSizeIcon.setIconJButton(jButtonNovoOrcamentoFinal, Icones.
					getOrcamentoOn(), 20, 20);
			jButtonNovoOrcamentoFinal.setText("Novo");
			jButtonNovoOrcamentoFinal.setSize(95, 35);
			jButtonNovoOrcamentoFinal.setFocusable(false);
			jButtonNovoOrcamentoFinal.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}
		return jButtonNovoOrcamentoFinal;
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
	
	
	public JButton getjButtonEditar() {
		if(jButtonEditar == null){
			jButtonEditar = new JButton();			
			jButtonEditar.setFont(Fontes.fontJButtonPlain3);
			jButtonEditar.setBackground(Cores.azul1);
			jButtonEditar.setForeground(Color.white);
			setSizeIcon.setIconJButton(jButtonEditar, Icones.
					getEditar(), 30, 30);
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
					getOrcamentoOn(), 18, 18);
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
	
	public JTextField getjTFieldDTInicial() {
		if(jTFieldDTInicial == null){
			jTFieldDTInicial = new JTextField();
			jTFieldDTInicial.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldDTInicial.setForeground(Cores.preto);
			jTFieldDTInicial.setFont(Fontes.fontJTFieldPlain1);
			jTFieldDTInicial.setSize(85, 25);
			jTFieldDTInicial.setOpaque(true);
		}
		return jTFieldDTInicial;
	}

	
	public JTextField getjTFieldDTFinal() {
		if(jTFieldDTFinal == null){
			jTFieldDTFinal = new JTextField();
			jTFieldDTFinal.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldDTFinal.setForeground(Cores.preto);
			jTFieldDTFinal.setFont(Fontes.fontJTFieldPlain1);
			jTFieldDTFinal.setSize(85, 25);
			jTFieldDTFinal.setOpaque(true);
		}
		return jTFieldDTFinal;
	}

	
	public JTextField getjTextFieldPesquisarPor() {
		if(jTFieldPesquisarPor == null){
			jTFieldPesquisarPor = new JTextField();
			jTFieldPesquisarPor.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldPesquisarPor.setForeground(Cores.preto);
			jTFieldPesquisarPor.setFont(Fontes.fontJTFieldPlain1);
			jTFieldPesquisarPor.setSize(170, 25);
			jTFieldDTFinal.setOpaque(true);
		}
		return jTFieldPesquisarPor;
	}
	
	
	//** Fim getters JFields **
	
	
	
	//** Início getters JComboBox **	

	
	public Choice getChoicePesquisarPor() {
		if(choicePesquisarPor == null){
			choicePesquisarPor = new Choice();
			choicePesquisarPor.setSize(150, 25);
			choicePesquisarPor.setFont(Fontes.fontJTFieldPlain1);
			choicePesquisarPor.setVisible(true);
			choicePesquisarPor.add("Selec. opção");
			choicePesquisarPor.add("Cliente");
			choicePesquisarPor.add("Placa");
			choicePesquisarPor.setFocusable(false);
	
		}
		return choicePesquisarPor;
	}		
		
	//** Fim getters JComboBox **
	
	//** Início getters conjuto JScrollPane/JTable **
	
	public JScrollPane getjSPOrcamentos() {
		if(jSPOrcamentos == null){
			jSPOrcamentos = new JScrollPane();
			jSPOrcamentos.setViewportView(getjTableOrcamentos());
			jSPOrcamentos.setSize(990, 225);	
		}
		return jSPOrcamentos;
	}
	

	public JTable getjTableOrcamentos() {
		if(jTableOrcamentos == null){
			jTableOrcamentos = new JTable();
			jTableOrcamentos.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                
		            },
		            new String [] {
		                "Data", "Cliente", "Placa", "Qtd.Produtos",
		                "Desconto", "Valor"
		            }
		        ));			

			jTableOrcamentos.setFont(Fontes.fontJTablePlain2);
			jTableOrcamentos.setOpaque(false);
			jTableOrcamentos.getTableHeader().setFont(Fontes.fontJTableBold2);
			jTableOrcamentos.getTableHeader().setForeground(Cores.branco);
			jTableOrcamentos.getTableHeader().setBackground(Cores.azul1);
		}
		return jTableOrcamentos;
	}
	
	
	//** Fim getters conjuto JScrollPane/JTable **
		
	//** Início métodos adição de componentes **	

	

	public void addCompJPanelOrcamentoFinal() { 
	
		this.getJPanelOrcamentoFinal().add(this.getjButtonNovoOrcamentoFinal());
		this.getjButtonNovoOrcamentoFinal().setLocation(14, 20);
	
		this.getJPanelOrcamentoFinal().add(this.getjButtonImprimir());
		this.getjButtonImprimir().setLocation(816, 20);
	
		this.getJPanelOrcamentoFinal().add(this.getjButtonEditar());
		this.getjButtonEditar().setLocation(882, 20);
		
		this.getJPanelOrcamentoFinal().add(this.getjButtonApagar());
		this.getjButtonApagar().setLocation(948, 20);
		
		this.getJPanelOrcamentoFinal().add(this.getjPanelBuscaOrcamentos());
		this.getjPanelBuscaOrcamentos().setLocation(14, 75);
		
		this.getJPanelOrcamentoFinal().add(this.getjSPOrcamentos());
		this.getjSPOrcamentos().setLocation(14, 145);
	}

	
	public void addCompJPanelBuscaOrcamentos() {		
		
		this.getjPanelBuscaOrcamentos().add(this.getjLabelDTInicial());
		this.getjLabelDTInicial().setLocation(5, 16);

		this.getjPanelBuscaOrcamentos().add(this.getjTFieldDTInicial());
		this.getjTFieldDTInicial().setLocation(87, 16);

		this.getjPanelBuscaOrcamentos().add(this.getjLabelDTFinal());
		this.getjLabelDTFinal().setLocation(179, 16);

		this.getjPanelBuscaOrcamentos().add(this.getjTFieldDTFinal());
		this.getjTFieldDTFinal().setLocation(252, 16);
		
		this.getjPanelBuscaOrcamentos().add(this.getChoicePesquisarPor());
		this.getChoicePesquisarPor().setLocation(368, 16);
		
		this.getjPanelBuscaOrcamentos().add(this.getjTextFieldPesquisarPor());
		this.getjTextFieldPesquisarPor().setLocation(498, 16);

		this.getjPanelBuscaOrcamentos().add(this.getjButtonFiltrar());
		this.getjButtonFiltrar().setLocation(790, 16);

		this.getjPanelBuscaOrcamentos().add(this.getjButtonPesquisarTodos());
		this.getjButtonPesquisarTodos().setLocation(864, 16);
	}
	
	//** Fim métodos adição de componentes **
	

}