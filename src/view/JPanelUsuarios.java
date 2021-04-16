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
public class JPanelUsuarios  extends JPanel{


	
	//** Início declaração de variáveis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	private String tituloDescricaoTela; // título que descreve a tela que foi chamanda no JPanelPrincipal
	
	private JButton jButtonNovoUsuario;
	private JButton jButtonEditar;
	private JButton jButtonApagar;
	private JButton jButtonFiltrar;
	private JButton jButtonPesquisarTodos;
	
	private JTextField jTFieldBuscarPor;
	
	private JPanel jPanelBuscaUsuarios; // barra que contem componentes para realizar busca de vendas
	
	private JScrollPane jSPUsuarios;
	
	private JTable jTableUsuarios;
	
	private Choice choicePesquisarPor;
		
	//** Fim declaração de variáveis **
	
	//** Início construtor **



	public JPanelUsuarios() {
		this.addCompJPanelBuscaUsuarios();
		this.addCompJPanelUsuarios();
	}
	
	//** Fim construtor **
	
	//** Início getters JPanels **

	public JPanelUsuarios getJPanelUsuarios() { // OK
		this.setLayout(null);
		this.setBackground(Cores.cinza3);
		this.setSize(new Dimension(1030,674));
		this.setVisible(true);
		return this;
	}
	
	
	public JPanel getjPanelBuscaUsuarios() {
		if(jPanelBuscaUsuarios == null){
			jPanelBuscaUsuarios = new JPanel();
			jPanelBuscaUsuarios.setLayout(null);
			jPanelBuscaUsuarios.setBackground(Cores.branco);
			jPanelBuscaUsuarios.setSize(990, 50);
			jPanelBuscaUsuarios.setBorder(null);
		}
		return jPanelBuscaUsuarios;
	}
	
	//** Fim getters JPanel **
	
	//** Início getters JLabel **
	
	public String getTituloDescricaoTela() {
		if(tituloDescricaoTela == null){	
			tituloDescricaoTela = "Pré Orçamento";	
		}
		return tituloDescricaoTela;
	}		
	
	//** Fim getters JLabel **
	
	//** Início getters JButon **
	
	
	public JButton getjButtonNovoUsuario() {
		if(jButtonNovoUsuario == null){
			jButtonNovoUsuario = new JButton();			
			jButtonNovoUsuario.setFont(Fontes.fontJButtonPlain3);
			jButtonNovoUsuario.setBackground(Cores.azul1);
			jButtonNovoUsuario.setForeground(Color.white);
			jButtonNovoUsuario.setHorizontalTextPosition(SwingConstants.LEFT);
			setSizeIcon.setIconJButton(jButtonNovoUsuario, Icones.
					getUsuariosOn(), 20, 20);
			jButtonNovoUsuario.setText("Novo");
			jButtonNovoUsuario.setSize(95, 35);
			jButtonNovoUsuario.setFocusable(false);
			jButtonNovoUsuario.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}
		return jButtonNovoUsuario;
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
					getUsuariosOn(), 18, 18);
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
			choicePesquisarPor.add("Selecione uma opção");
			choicePesquisarPor.add("CPF");
			choicePesquisarPor.add("Nome");
			choicePesquisarPor.setFocusable(false);
	
		}
		return choicePesquisarPor;
	}
		
		
		
		
		
		//** Fim getters JComboBox **
	
	//** Início getters conjuto JScrollPane/JTable **
	
	public JScrollPane getjSPUsuarios() {
		if(jSPUsuarios == null){
			jSPUsuarios = new JScrollPane();
			jSPUsuarios.setViewportView(getjTableUsuarios());
			jSPUsuarios.setSize(990, 225);	
			jSPUsuarios.setBorder(null);
		}
		return jSPUsuarios;
	}
	

	public JTable getjTableUsuarios() {
		if(jTableUsuarios == null){
			jTableUsuarios = new JTable();
			jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		                {null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null, null},
		                
		            },
		            new String [] {
		                "CPF", "Nome", "Email",
		                "Telefone", "Cidade", "Usuário", "Senha","Função"
		            }
		        ));			

			jTableUsuarios.setFont(Fontes.fontJTablePlain2);
			jTableUsuarios.setOpaque(false);
			jTableUsuarios.getTableHeader().setFont(Fontes.fontJTableBold2);
			jTableUsuarios.getTableHeader().setForeground(Cores.branco);
			jTableUsuarios.getTableHeader().setBackground(Cores.azul1);
		}
		return jTableUsuarios;
	}
	
	
	//** Fim getters conjuto JScrollPane/JTable **
		
	//** Início métodos adição de componentes **	

	

	public void addCompJPanelUsuarios() { 
	
		this.getJPanelUsuarios().add(this.getjButtonNovoUsuario());
		this.getjButtonNovoUsuario().setLocation(14, 20);
	
		this.getJPanelUsuarios().add(this.getjButtonEditar());
		this.getjButtonEditar().setLocation(882, 20);
		
		this.getJPanelUsuarios().add(this.getjButtonApagar());
		this.getjButtonApagar().setLocation(948, 20);
		
		this.getJPanelUsuarios().add(this.getjPanelBuscaUsuarios());
		this.getjPanelBuscaUsuarios().setLocation(14, 75);
		
		this.getJPanelUsuarios().add(this.getjSPUsuarios());
		this.getjSPUsuarios().setLocation(14, 145);
	}

	
	public void addCompJPanelBuscaUsuarios() {		

		this.getjPanelBuscaUsuarios().add(this.getChoicePesquisarPor());
		this.getChoicePesquisarPor().setLocation(14, 16);
		
		this.getjPanelBuscaUsuarios().add(this.getjTFieldBuscarPor());
		this.getjTFieldBuscarPor().setLocation(180, 16);

		this.getjPanelBuscaUsuarios().add(this.getjButtonFiltrar());
		this.getjButtonFiltrar().setLocation(790, 16);

		this.getjPanelBuscaUsuarios().add(this.getjButtonPesquisarTodos());
		this.getjButtonPesquisarTodos().setLocation(864, 16);
	}
	
	//** Fim métodos adição de componentes **
	

}