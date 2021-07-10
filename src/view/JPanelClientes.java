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
import icons.Icones;
import model.Cores;
import model.Fontes;
import model.SetSizeIcon;

/**
 * @author pWili
 *
 */

@SuppressWarnings("serial")
public class JPanelClientes  extends JPanel{


	
	//** Início declaração de variáveis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	
	private JButton jButtonEditar;
	private JButton jButtonApagar;
	private JButton jButtonFiltrar;
	private JButton jButtonPesquisarTodos;
	
	private JTextField jTFieldBuscarPor;
	
	private JPanel jPanelBuscaClientes; // barra que contem componentes para realizar busca de vendas
	
	private JScrollPane jSPClientes;
	
	private JTable jTableClientes;
	
	private Choice choicePesquisarPor;
		
	//** Fim declaração de variáveis **
	
	//** Início construtor **



	public JPanelClientes() {
		this.addCompJPanelBuscaClientes();
		this.addCompJPanelClientes();
	}
	
	//** Fim construtor **
	
	//** Início getters JPanels **

	public JPanelClientes getJPanelClientes() { // OK
		this.setLayout(null);
		this.setBackground(Cores.cinza3);
		this.setSize(new Dimension(1030,674));
		this.setVisible(true);
		return this;
	}
	
	
	public JPanel getjPanelBuscaClientes() {
		if(jPanelBuscaClientes == null){
			jPanelBuscaClientes = new JPanel();
			jPanelBuscaClientes.setLayout(null);
			jPanelBuscaClientes.setBackground(Cores.branco);
			jPanelBuscaClientes.setSize(1000, 50);
			jPanelBuscaClientes.setBorder(null);
		}
		return jPanelBuscaClientes;
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
					getUser(), 18, 18);
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
	
	public Choice getChoicePesquisarPor() {
		if(choicePesquisarPor == null){
			choicePesquisarPor = new Choice();
			choicePesquisarPor.setSize(150, 25);
			choicePesquisarPor.setFont(Fontes.fontJTFieldPlain1);
			choicePesquisarPor.setVisible(true);
			choicePesquisarPor.add("Cliente          ");
			choicePesquisarPor.add("Placa            ");
			choicePesquisarPor.setFocusable(false);	
		}
		return choicePesquisarPor;
	}
		
		
		
		//** Fim getters JComboBox **
	
	//** Início getters conjuto JScrollPane/JTable **
	
	public JScrollPane getjSPClientes() {
		if(jSPClientes == null){
			jSPClientes = new JScrollPane();
			jSPClientes.setViewportView(getjTableClientes());
			jSPClientes.setSize(1000, 225);	
		}
		return jSPClientes;
	}
	

	public JTable getjTableClientes() {
		if(jTableClientes == null){
			jTableClientes = new JTable();
			jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
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
		                "CPF", "CNPJ", "Nome", "Email",
		                "Telefone", "Cidade", "Bairro", "Rua", "Nº Casa"
		            }
		        ));			

			jTableClientes.setFont(Fontes.fontJTablePlain2);
			jTableClientes.setOpaque(false);
			jTableClientes.getTableHeader().setFont(Fontes.fontJTableBold2);
			jTableClientes.getTableHeader().setForeground(Cores.branco);
			jTableClientes.getTableHeader().setBackground(Cores.azul1);
		}
		return jTableClientes;
	}
	
	
	//** Fim getters conjuto JScrollPane/JTable **
		
	//** Início métodos adição de componentes **	

	

	public void addCompJPanelClientes() { 
	
		this.getJPanelClientes().add(this.getjButtonEditar());
		this.getjButtonEditar().setLocation(884, 20);
		
		this.getJPanelClientes().add(this.getjButtonApagar());
		this.getjButtonApagar().setLocation(950, 20);
		
		this.getJPanelClientes().add(this.getjPanelBuscaClientes());
		this.getjPanelBuscaClientes().setLocation(14, 75);
		
		this.getJPanelClientes().add(this.getjSPClientes());
		this.getjSPClientes().setLocation(14, 145);
	}

	
	public void addCompJPanelBuscaClientes() {		

		this.getjPanelBuscaClientes().add(this.getChoicePesquisarPor());
		this.getChoicePesquisarPor().setLocation(14, 16);
		
		this.getjPanelBuscaClientes().add(this.getjTFieldBuscarPor());
		this.getjTFieldBuscarPor().setLocation(180, 16);

		this.getjPanelBuscaClientes().add(this.getjButtonFiltrar());
		this.getjButtonFiltrar().setLocation(800, 16);

		this.getjPanelBuscaClientes().add(this.getjButtonPesquisarTodos());
		this.getjButtonPesquisarTodos().setLocation(874, 16);
	}
	
	//** Fim métodos adição de componentes **
	

}