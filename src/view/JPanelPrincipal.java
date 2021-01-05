package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import icons.Icones;
import model.Cores;
import model.Fontes;
import model.SetSizeIcon;

public class JPanelPrincipal extends JPanel{
	
	//** Início declaração de variáveis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	
	private int xIconJButton = 34, yIconJButton = 34;
	
	//private JPanel jPanelPrincipalBase; // base do programa. Aplicada sobre JPanelPrincipal
	private JPanel jPanelMenuLateral;
	private JPanel jPanelBarraMenu;
	
	private JButton jButtonInicio;
	private JButton jButtonOS;
	private JButton jButtonOSConsulta;
	private JButton jButtonOSCriar;
	private JButton jButtonVendas;
	private JButton jButtonOrcamento;
	private JButton jButtonPreOrcamento;
	private JButton jButtonOrcamentoFinal;
	private JButton jButtonVeiculos;
	private JButton jButtonClientes;
	private JButton jButtonUsuarios;
	private JButton jButtonEstoque;
	private JButton jButtonConfiguracao;
	
	//** Fim declaração de variáveis **
	
	public JPanelPrincipal() {
		
		this.getjPanelBarraMenu();
		
		this.getJButtonInicio();
		/*this.getjButtonEstoque();
		this.getjButtonVendas();
		this.getjButtonConfiguracao();*/
		
		this.addCompJPanelMenuLateral();
		this.getjPanelMenuLateral();
		
		//this.getjPanelPrincipalBase();
		this.addCompJPanelPrincipal();
		this.getJPanelPrincipal();
	}
	
	
	//** Início getters JPanels **
	
	public JPanelPrincipal getJPanelPrincipal() {
		this.setLayout(null);
		this.setBackground(Cores.cinza2);
		this.setSize(new Dimension(1280,720));
		
		return this;
	}

	/*public JPanel getjPanelPrincipalBase() {
		if(jPanelPrincipalBase == null) {
			jPanelPrincipalBase = new JPanel();
			jPanelPrincipalBase.setLayout(null);
			jPanelPrincipalBase.setBackground(Cores.cinza2);
			jPanelPrincipalBase.setSize(1280,720);
			
		}
		return jPanelPrincipalBase;
	}*/

	public JPanel getjPanelMenuLateral() {
		if(jPanelMenuLateral == null) {
			jPanelMenuLateral = new JPanel();
			jPanelMenuLateral.setLayout(null);
			jPanelMenuLateral.setBackground(Color.white);
			jPanelMenuLateral.setSize(250,720);
		}
		return jPanelMenuLateral;
	}
	
	public JPanel getjPanelBarraMenu() {
		if(jPanelBarraMenu == null) {
			jPanelBarraMenu = new JPanel();
			jPanelBarraMenu.setLayout(null);
			jPanelBarraMenu.setBackground(Cores.azul1);
			jPanelBarraMenu.setSize(1030,46);
		}
		return jPanelBarraMenu;
	}
	
	//** Fim getters JPanel **
	
	//** Início getters JButon **
	
	public JButton getJButtonInicio() {
		if(jButtonInicio == null) {
			jButtonInicio = new JButton();
			jButtonInicio.setBackground(Cores.azul1);
			jButtonInicio.setFont(Fontes.fontJButtonsMenuLateral);
			jButtonInicio.setText(" Início");
			jButtonInicio.setForeground(Color.white);
			setSizeIcon.setIconJButton(jButtonInicio, Icones.
					getHome(this), xIconJButton, yIconJButton);
			jButtonInicio.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonInicio.setBorder(null);
			jButtonInicio.setFocusPainted(false);
			jButtonInicio.setSize(250,36);
			
		}
		return jButtonInicio;
	}
	
	
	public JButton getjButtonInicio() {
		return jButtonInicio;
	}


	public JButton getjButtonOS() {
		return jButtonOS;
	}


	public JButton getjButtonOSConsulta() {
		return jButtonOSConsulta;
	}


	public JButton getjButtonOSCriar() {
		return jButtonOSCriar;
	}


	public JButton getjButtonVendas() {
		return jButtonVendas;
	}


	public JButton getjButtonOrcamento() {
		return jButtonOrcamento;
	}


	public JButton getjButtonPreOrcamento() {
		return jButtonPreOrcamento;
	}


	public JButton getjButtonOrcamentoFinal() {
		return jButtonOrcamentoFinal;
	}


	public JButton getjButtonVeiculos() {
		return jButtonVeiculos;
	}


	public JButton getjButtonClientes() {
		return jButtonClientes;
	}


	public JButton getjButtonUsuarios() {
		return jButtonUsuarios;
	}


	public JButton getjButtonEstoque() {
		return jButtonEstoque;
	}


	public JButton getjButtonConfiguracao() {
		return jButtonConfiguracao;
	}
	
	
	
	//** Fim getters JButon **
	
	//** Início métodos adição de componentes **
	
	
	


	public void addCompJPanelPrincipal() {
		this.getJPanelPrincipal().add(this.getjPanelMenuLateral());
		this.getjPanelMenuLateral().setLocation(0,0);
		
		this.getJPanelPrincipal().add(this.getjPanelBarraMenu());
		this.getjPanelBarraMenu().setLocation(250,0);
	}
	

	public void addCompJPanelMenuLateral() {
		this.getjPanelMenuLateral().add(this.getJButtonInicio());
		this.getJButtonInicio().setLocation(0,95);
		
		/*this.getjPanelMenuLateral().add(this.getjButtonEstoque());
		this.getjButtonEstoque().setLocation(0,44);
		
				
		this.getjPanelMenuLateral().add(this.getjButtonVendas());
		this.getjButtonVendas().setLocation(0,124);
		
		this.getjPanelMenuLateral().add(this.getjButtonConfiguracao());
		this.getjButtonConfiguracao().setLocation(0,164);*/
	}
	
	
	//** Fim métodos adição de componentes **
	

}
