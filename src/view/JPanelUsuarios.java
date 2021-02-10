/**
 * 
 */
package view;

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
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;

import icons.Icones;
import model.Cores;
import model.Fontes;
import model.SetSizeIcon;

/**
 * @author pWili
 *
 */
public class JPanelUsuarios  extends JPanel{


	
	//** In�cio declara��o de vari�veis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	
	private JButton jButtonNovoUsuario;
	private JButton jButtonEditar;
	private JButton jButtonApagar;
	private JButton jButtonFiltrar;
	private JButton jButtonPesquisarTodos;
	
	private JTextField jTFieldBuscarPor;
	
	private JPanel jPanelBuscaUsuarios; // barra que contem componentes para realizar busca de vendas
	
	private JScrollPane jSPUsuarios;
	
	private JTable jTableUsuarios;
	
	private JComboBox<String> jComboPesquisarPor;
		
	//** Fim declara��o de vari�veis **
	
	//** In�cio construtor **



	public JPanelUsuarios() {
		this.addCompJPanelBuscaUsuarios();
		this.addCompJPanelUsuarios();
	}
	
	//** Fim construtor **
	
	//** In�cio getters JPanels **

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
			jPanelBuscaUsuarios.setSize(1000, 50);
			jPanelBuscaUsuarios.setBorder(null);
		}
		return jPanelBuscaUsuarios;
	}
	
	//** Fim getters JPanel **
	
	//** In�cio getters JLabel **
		
	
	//** Fim getters JLabel **
	
	//** In�cio getters JButon **
	
	
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
	
	
	
	//** In�cio getters JFields **
	
	
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
	
	
	
	//** In�cio getters JComboBox **
	
		public JComboBox<String> getjComboPesquisarPor() { // OK
			if(jComboPesquisarPor == null) {
				jComboPesquisarPor = new JComboBox<String>();
				jComboPesquisarPor.setForeground(Cores.preto);
				jComboPesquisarPor.setFont(Fontes.fontJLabelPlain1);
				jComboPesquisarPor.setSize(150, 25);
				jComboPesquisarPor.setOpaque(false);
				jComboPesquisarPor.setFocusable(false);
				jComboPesquisarPor.setModel(new javax.swing.
						DefaultComboBoxModel<>(new String[] { "Selecione uma op��o", "CPF", "Nome"}));
				jComboPesquisarPor.setBorder(null);
				
				jComboPesquisarPor.setUI(new BasicComboBoxUI() {
				    protected JButton createArrowButton() {
				        return new JButton() {
				        	@Override
				        	public Color getBackground() {		        		
				        		return super.getBackground().cyan;
				        	}
				        	@Override
				        	public Border getBorder() {
				        		return BorderFactory.createEmptyBorder();
				        	}
				        	@Override
				            public int getWidth() {
				            	  return 1;
				            }
				        	@Override
				            public int getHeight() {
				            	  return 1;
				            }
				        };
				    }
				});
				
			}
			
			return jComboPesquisarPor;
		}
		
		
		
		//** Fim getters JComboBox **
	
	//** In�cio getters conjuto JScrollPane/JTable **
	
	public JScrollPane getjSPUsuarios() {
		if(jSPUsuarios == null){
			jSPUsuarios = new JScrollPane();
			jSPUsuarios.setViewportView(getjTableUsuarios());
			jSPUsuarios.setSize(1000, 225);	
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
		                "Telefone", "Cidade", "Usu�rio", "Senha","Fun��o"
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
		
	//** In�cio m�todos adi��o de componentes **	

	

	public void addCompJPanelUsuarios() { 
	
		this.getJPanelUsuarios().add(this.getjButtonNovoUsuario());
		this.getjButtonNovoUsuario().setLocation(14, 20);
	
		this.getJPanelUsuarios().add(this.getjButtonEditar());
		this.getjButtonEditar().setLocation(884, 20);
		
		this.getJPanelUsuarios().add(this.getjButtonApagar());
		this.getjButtonApagar().setLocation(950, 20);
		
		this.getJPanelUsuarios().add(this.getjPanelBuscaUsuarios());
		this.getjPanelBuscaUsuarios().setLocation(14, 75);
		
		this.getJPanelUsuarios().add(this.getjSPUsuarios());
		this.getjSPUsuarios().setLocation(14, 145);
	}

	
	public void addCompJPanelBuscaUsuarios() {		

		this.getjPanelBuscaUsuarios().add(this.getjComboPesquisarPor());
		this.getjComboPesquisarPor().setLocation(14, 16);
		
		this.getjPanelBuscaUsuarios().add(this.getjTFieldBuscarPor());
		this.getjTFieldBuscarPor().setLocation(180, 16);

		this.getjPanelBuscaUsuarios().add(this.getjButtonFiltrar());
		this.getjButtonFiltrar().setLocation(800, 16);

		this.getjPanelBuscaUsuarios().add(this.getjButtonPesquisarTodos());
		this.getjButtonPesquisarTodos().setLocation(874, 16);
	}
	
	//** Fim m�todos adi��o de componentes **
	

}