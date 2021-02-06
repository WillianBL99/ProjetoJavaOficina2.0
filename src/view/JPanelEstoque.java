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
public class JPanelEstoque  extends JPanel{


	
	//** In�cio declara��o de vari�veis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	
	private JButton jButtonAdicionar;
	private JButton jButtonEditar;
	private JButton jButtonApagar;
	private JButton jButtonFiltrar;
	private JButton jButtonPesquisarTodos;
	
	private JTextField jTFieldBuscarPor;
	
	private JPanel jPanelBuscaEstoque; // barra que contem componentes para realizar busca de vendas
	
	private JScrollPane jSPEstoque;
	
	private JTable jTableEstoque;
	
	private JComboBox<String> jComboPesquisarPor;
		
	//** Fim declara��o de vari�veis **
	
	//** In�cio construtor **



	public JPanelEstoque() {
		this.addCompJPanelBuscaEstoque();
		this.addCompJPanelEstoque();
	}
	
	//** Fim construtor **
	
	//** In�cio getters JPanels **

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
			jPanelBuscaEstoque.setSize(1000, 50);
			jPanelBuscaEstoque.setBorder(null);
		}
		return jPanelBuscaEstoque;
	}
	
	//** Fim getters JPanel **
	
	//** In�cio getters JLabel **
		
	
	//** Fim getters JLabel **
	
	//** In�cio getters JButon **
	
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
					getEstoqueBranco(), 18, 18);
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
						DefaultComboBoxModel<>(new String[] { "Selecione uma op��o", "C�digo", "Descri��o", "Marca"}));
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
			jTableEstoque.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		                {null, null, null, null, null},
		                {null, null, null, null, null},
		                {null, null, null, null, null},
		                {null, null, null, null, null},
		                {null, null, null, null, null},
		                {null, null, null, null, null},
		                {null, null, null, null, null},
		                {null, null, null, null, null},
		                {null, null, null, null, null},
		                {null, null, null, null, null},
		                {null, null, null, null, null},
		                {null, null, null, null, null},
		                
		            },
		            new String [] {
		                "C�digo", "Descri��o", "Marca", "Quantidade",
		                "Pre�o"
		            }
		        ));			

			jTableEstoque.setFont(Fontes.fontJTablePlain2);
			jTableEstoque.setOpaque(false);
			jTableEstoque.getTableHeader().setFont(Fontes.fontJTableBold2);
			jTableEstoque.getTableHeader().setForeground(Cores.branco);
			jTableEstoque.getTableHeader().setBackground(Cores.azul1);
		}
		return jTableEstoque;
	}
	
	
	//** Fim getters conjuto JScrollPane/JTable **
		
	//** In�cio m�todos adi��o de componentes **	

	

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

		this.getjPanelBuscaEstoque().add(this.getjComboPesquisarPor());
		this.getjComboPesquisarPor().setLocation(14, 16);
		
		this.getjPanelBuscaEstoque().add(this.getjTFieldBuscarPor());
		this.getjTFieldBuscarPor().setLocation(180, 16);

		this.getjPanelBuscaEstoque().add(this.getjButtonFiltrar());
		this.getjButtonFiltrar().setLocation(800, 16);

		this.getjPanelBuscaEstoque().add(this.getjButtonPesquisarTodos());
		this.getjButtonPesquisarTodos().setLocation(874, 16);
	}
	
	//** Fim m�todos adi��o de componentes **
	

}