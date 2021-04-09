/**
 * 
 */
package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class JPanelVeiculos extends JPanel{


	
	//** Início declaração de variáveis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	
	private JButton jButtonEditar;
	private JButton jButtonApagar;
	private JButton jButtonFiltrar;
	private JButton jButtonPesquisarTodos;
	
	private JTextField jTFieldBuscarPor;
	
	private JPanel jPanelBuscaVeiculos; // barra que contem componentes para realizar busca de vendas
	
	private JScrollPane jSPVeiculos;
	
	private JTable jTableVeiculos;
	
	private Choice choicePesquisarPor;
		
	//** Fim declaração de variáveis **
	
	//** Início construtor **



	public JPanelVeiculos() {
		this.addCompJPanelBuscaVeiculos();
		this.addCompJPanelVeiculos();
	}
	
	//** Fim construtor **
	
	//** Início getters JPanels **

	public JPanelVeiculos getJPanelVeiculos() { // OK
		this.setLayout(null);
		this.setBackground(Cores.cinza3);
		this.setSize(new Dimension(1030,674));
		this.setVisible(true);
		return this;
	}
	
	
	public JPanel getjPanelBuscaVeiculos() {
		if(jPanelBuscaVeiculos == null){
			jPanelBuscaVeiculos = new JPanel();
			jPanelBuscaVeiculos.setLayout(null);
			jPanelBuscaVeiculos.setBackground(Cores.branco);
			jPanelBuscaVeiculos.setSize(990, 50);
			jPanelBuscaVeiculos.setBorder(null);
		}
		return jPanelBuscaVeiculos;
	}
	
	//** Fim getters JPanel **
	
	//** Início getters JLabel **
		
	
	//** Fim getters JLabel **
	
	//** Início getters JButon **
	
	
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
					getVeiculosOn(), 18, 18);
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
	
		public Choice choicePesquisarPor() {
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
	
	public JScrollPane getjSPVeiculos() {
		if(jSPVeiculos == null){
			jSPVeiculos = new JScrollPane();
			jSPVeiculos.setViewportView(getjTableVeiculos());
			jSPVeiculos.setSize(990, 225);	
		}
		return jSPVeiculos;
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

			jTableVeiculos.setFont(Fontes.fontJTablePlain2);
			jTableVeiculos.setOpaque(false);
			jTableVeiculos.getTableHeader().setFont(Fontes.fontJTableBold2);
			jTableVeiculos.getTableHeader().setForeground(Cores.branco);
			jTableVeiculos.getTableHeader().setBackground(Cores.azul1);
		}
		return jTableVeiculos;
	}
	
	
	//** Fim getters conjuto JScrollPane/JTable **
		
	//** Início métodos adição de componentes **	

	

	public void addCompJPanelVeiculos() { 
	
		this.getJPanelVeiculos().add(this.getjButtonEditar());
		this.getjButtonEditar().setLocation(884, 20);
		
		this.getJPanelVeiculos().add(this.getjButtonApagar());
		this.getjButtonApagar().setLocation(950, 20);
		
		this.getJPanelVeiculos().add(this.getjPanelBuscaVeiculos());
		this.getjPanelBuscaVeiculos().setLocation(14, 75);
		
		this.getJPanelVeiculos().add(this.getjSPVeiculos());
		this.getjSPVeiculos().setLocation(14, 145);
	}

	
	public void addCompJPanelBuscaVeiculos() {		

		this.getjPanelBuscaVeiculos().add(this.choicePesquisarPor());
		this.choicePesquisarPor().setLocation(14, 16);
		
		this.getjPanelBuscaVeiculos().add(this.getjTFieldBuscarPor());
		this.getjTFieldBuscarPor().setLocation(180, 16);

		this.getjPanelBuscaVeiculos().add(this.getjButtonFiltrar());
		this.getjButtonFiltrar().setLocation(790, 16);

		this.getjPanelBuscaVeiculos().add(this.getjButtonPesquisarTodos());
		this.getjButtonPesquisarTodos().setLocation(864, 16);
	}
	
	//** Fim métodos adição de componentes **
	

}