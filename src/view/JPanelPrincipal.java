package view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import icons.Icones;
import model.Cores;
import model.Fontes;

public class JPanelPrincipal extends JPanel{
	
	//** Início declaração de variáveis **
	
	private JPanel jPanelPrincipalBase; // base do programa. Aplicada sobre JPanelPrincipal
	private JPanel jPanelMenuLateral;
	private JPanel jPanelBarraMenu;
	
	private JButton jButtonInicio;
	private JButton jButtonEstoque;
	private JButton jButtonVender;
	private JButton jButtonVendas;
	private JButton jButtonConfiguracao;
	
	//** Fim declaração de variáveis **
	
	public JPanelPrincipal() {
		
		this.getjPanelBarraMenu();
		
		this.getJButtonInicio();
		this.getjButtonEstoque();
		this.getjButtonVender();
		this.getjButtonVendas();
		this.getjButtonConfiguracao();
		
		this.addCompJPanelMenuLateral();
		this.getjPanelMenuLateral();
		
		this.getjPanelPrincipalBase();
		this.addCompJPanelPrincipal();
		this.getJPanelPrincipal();
	}
	
	
	//** Início getters JPanels **
	
	public JPanelPrincipal getJPanelPrincipal() {
		this.setLayout(null);
		this.setBackground(Cores.cinza2);
		this.setPreferredSize(new Dimension(1280,720));
		
		return this;
	}

	public JPanel getjPanelPrincipalBase() {
		if(jPanelPrincipalBase == null) {
			jPanelPrincipalBase = new JPanel();
			jPanelPrincipalBase.setLayout(null);
			jPanelPrincipalBase.setBackground(Cores.cinza2);
			jPanelPrincipalBase.setSize(1280,720);
			
		}
		return jPanelPrincipalBase;
	}

	public JPanel getjPanelMenuLateral() {
		if(jPanelMenuLateral == null) {
			jPanelMenuLateral = new JPanel();
			jPanelMenuLateral.setLayout(null);
			jPanelMenuLateral.setBackground(Cores.azul1);
			jPanelMenuLateral.setSize(250,675);
		}
		return jPanelMenuLateral;
	}
	
	public JPanel getjPanelBarraMenu() {
		if(jPanelBarraMenu == null) {
			jPanelBarraMenu = new JPanel();
			jPanelBarraMenu.setLayout(null);
			jPanelBarraMenu.setBackground(Cores.cinza1);
			jPanelBarraMenu.setSize(1280,45);
		}
		return jPanelBarraMenu;
	}
	
	//** Fim getters JPanel **
	
	//** Início getters JButon **
	
	public JButton getJButtonInicio() {
		if(jButtonInicio == null) {
			jButtonInicio = new JButton();
			jButtonInicio.setBackground(Cores.azul2);
			jButtonInicio.setFont(Fontes.fontJButtons);
			jButtonInicio.setText(" Início");
			jButtonInicio.setForeground(Cores.foregroundJButton);
			jButtonInicio.setIcon(Icones.getHome(this));
			jButtonInicio.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonInicio.setBorder(null);
			jButtonInicio.setSelected(false);
			jButtonInicio.setSize(250,36);
			
		}
		return jButtonInicio;
	}
	
	public JButton getjButtonEstoque() {
		if(jButtonEstoque == null) {
			jButtonEstoque = new JButton();
			jButtonEstoque.setBackground(Cores.azul2);
			jButtonEstoque.setFont(Fontes.fontJButtons);
			jButtonEstoque.setText(" Estoque");
			jButtonEstoque.setForeground(Cores.foregroundJButton);
			jButtonEstoque.setIcon(Icones.getEstoque(this));
			jButtonEstoque.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonEstoque.setBorder(null);
			jButtonEstoque.setSize(250,36);
		}
		return jButtonEstoque;
	}
	
	public JButton getjButtonVender() {
		if(jButtonVender == null) {
			jButtonVender = new JButton();
			jButtonVender.setBackground(Cores.azul2);
			jButtonVender.setFont(Fontes.fontJButtons);
			jButtonVender.setText(" Estoque");
			jButtonVender.setForeground(Cores.foregroundJButton);
			jButtonVender.setIcon(Icones.getVender(this));
			jButtonVender.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonVender.setBorder(null);
			jButtonVender.setSize(250,36);
		}
		return jButtonVender;
	}
	
	
	public JButton getjButtonVendas() {
		if(jButtonVendas == null) {
			jButtonVendas = new JButton();
			jButtonVendas.setBackground(Cores.azul2);
			jButtonVendas.setFont(Fontes.fontJButtons);
			jButtonVendas.setText(" Estoque");
			jButtonVendas.setForeground(Cores.foregroundJButton);
			jButtonVendas.setIcon(Icones.getVendas(this));
			jButtonVendas.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonVendas.setBorder(null);
			jButtonVendas.setSize(250,36);
		}
		return jButtonVendas;
	}
	
	
	public JButton getjButtonConfiguracao() {
		if(jButtonConfiguracao == null) {
			jButtonConfiguracao = new JButton();
			jButtonConfiguracao.setBackground(Cores.azul2);
			jButtonConfiguracao.setFont(Fontes.fontJButtons);
			jButtonConfiguracao.setText(" Estoque");
			jButtonConfiguracao.setForeground(Cores.foregroundJButton);
			jButtonConfiguracao.setIcon(Icones.getConfiguracao(this));
			jButtonConfiguracao.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonConfiguracao.setBorder(null);
			jButtonConfiguracao.setSize(250,36);
		}
		return jButtonConfiguracao;
	}
	
	
	//** Fim getters JButon **
	
	//** Início métodos adição de componentes **
	
	
	public void addCompJPanelPrincipal() {
		this.getJPanelPrincipal().add(this.getjPanelMenuLateral());
		this.getjPanelMenuLateral().setLocation(0,45);
		
		this.getJPanelPrincipal().add(this.getjPanelBarraMenu());
		this.getjPanelBarraMenu().setLocation(0,0);
	}
	

	public void addCompJPanelMenuLateral() {
		this.getjPanelMenuLateral().add(this.getJButtonInicio());
		this.getJButtonInicio().setLocation(0,4);
		
		this.getjPanelMenuLateral().add(this.getjButtonEstoque());
		this.getjButtonEstoque().setLocation(0,44);
		
		this.getjPanelMenuLateral().add(this.getjButtonVender());
		this.getjButtonVender().setLocation(0,84);
		
		this.getjPanelMenuLateral().add(this.getjButtonVendas());
		this.getjButtonVendas().setLocation(0,124);
		
		this.getjPanelMenuLateral().add(this.getjButtonConfiguracao());
		this.getjButtonConfiguracao().setLocation(0,164);
	}
	
	
	//** Fim métodos adição de componentes **
	

}
