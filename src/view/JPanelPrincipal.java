package view;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import icons.Icones;
import model.Cores;
import model.Fontes;
import model.SetSizeIcon;

public class JPanelPrincipal extends JPanel{
	
	//** Início declaração de variáveis **
	

	private JPanel jPanelCenterAnterior;
	
	// variáveis para relocalização dos botoes apos abertura do btn "OS" ou "Orçamento"
	private int sizeOSOpen = 0; // 60
	private int sizeOrcamentoOpen = 0; // 60
		
		
	private SetSizeIcon setSizeIcon = new SetSizeIcon(); // iniciando objeto para rendimensionamento de imagens
	
	private int xIconJButton = 34, yIconJButton = 34; // tamanho dos icones dos botoes do menu lateral
	
	
	private JPanel jPanelMenuLateral;
	private JPanel jPanelBarraMenu;
	
	private JLabel jLabelUser;
	private JLabel jLabelDescricaoTela; // descreve as telas inseridas
	
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
		
		this.addCompJPanelBarraMenu();
		
		this.addCompJPanelMenuLateral();
		
		//this.getjPanelPrincipalBase();
		this.addCompJPanelPrincipal();
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
			jPanelMenuLateral.setBackground(Cores.branco);
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
			jButtonInicio.setForeground(Cores.branco);
			setSizeIcon.setIconJButton(jButtonInicio, Icones.
					getHome(this), xIconJButton, yIconJButton);
			jButtonInicio.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonInicio.setBorder(null);
			jButtonInicio.setFocusPainted(false);
			jButtonInicio.setSize(250,36);
			
		}
		return jButtonInicio;
	}


	public JButton getjButtonOS() {
		if(jButtonOS == null) {
			jButtonOS = new JButton();
			jButtonOS.setBackground(Cores.branco);
			jButtonOS.setFont(Fontes.fontJButtonsMenuLateral);
			jButtonOS.setText(" O.S.");
			jButtonOS.setForeground(Cores.cinza2);
			setSizeIcon.setIconJButton(jButtonOS, Icones.
					getOS(this), xIconJButton, yIconJButton);
			jButtonOS.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonOS.setBorder(null);
			jButtonOS.setFocusPainted(false);
			jButtonOS.setSize(250,36);
			
		}
		return jButtonOS;
	}


	public JButton getjButtonOSConsulta() {
		if(jButtonOSConsulta == null) {
			jButtonOSConsulta = new JButton();
			jButtonOSConsulta.setBackground(Cores.branco);
			jButtonOSConsulta.setFont(Fontes.fontJButtonsMenuLateral);
			jButtonOSConsulta.setText("Consultar O.S.");
			jButtonOSConsulta.setForeground(Cores.cinza3);
			jButtonOSConsulta.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonOSConsulta.setBorder(null);
			jButtonOSConsulta.setFocusPainted(false);
			jButtonOSConsulta.setSize(155,27);
			jButtonOSConsulta.setVisible(false);
			
		}
		return jButtonOSConsulta;
	}


	public JButton getjButtonOSCriar() {
		if(jButtonOSCriar == null) {
			jButtonOSCriar = new JButton();
			jButtonOSCriar.setBackground(Cores.branco);
			jButtonOSCriar.setFont(Fontes.fontJButtonsMenuLateral);
			jButtonOSCriar.setText("Gerar O.S.");
			jButtonOSCriar.setForeground(Cores.cinza3);
			jButtonOSCriar.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonOSCriar.setBorder(null);
			jButtonOSCriar.setFocusPainted(false);
			jButtonOSCriar.setSize(155,27);
			jButtonOSCriar.setVisible(false);
			
		}
		return jButtonOSCriar;
	}


	public JButton getjButtonVendas() {
		if(jButtonVendas == null) {
			jButtonVendas = new JButton();
			jButtonVendas.setBackground(Cores.branco);
			jButtonVendas.setFont(Fontes.fontJButtonsMenuLateral);
			jButtonVendas.setText(" Vendas");
			jButtonVendas.setForeground(Cores.cinza2);
			setSizeIcon.setIconJButton(jButtonVendas, Icones.
					getVendas(this), xIconJButton, yIconJButton);
			jButtonVendas.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonVendas.setBorder(null);
			jButtonVendas.setFocusPainted(false);
			jButtonVendas.setSize(250,36);
			
		}
		return jButtonVendas;
	}


	public JButton getjButtonOrcamento() {
		if(jButtonOrcamento == null) {
			jButtonOrcamento = new JButton();
			jButtonOrcamento.setBackground(Cores.branco);
			jButtonOrcamento.setFont(Fontes.fontJButtonsMenuLateral);
			jButtonOrcamento.setText(" Orçamento");
			jButtonOrcamento.setForeground(Cores.cinza2);
			setSizeIcon.setIconJButton(jButtonOrcamento, Icones.
					getOrcamento(this), xIconJButton, yIconJButton);
			jButtonOrcamento.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonOrcamento.setBorder(null);
			jButtonOrcamento.setFocusPainted(false);
			jButtonOrcamento.setSize(250,36);
			
		}
		return jButtonOrcamento;
	}


	public JButton getjButtonPreOrcamento() {
		if(jButtonPreOrcamento == null) {
			jButtonPreOrcamento = new JButton();
			jButtonPreOrcamento.setBackground(Cores.branco);
			jButtonPreOrcamento.setFont(Fontes.fontJButtonsMenuLateral);
			jButtonPreOrcamento.setText("Pré Orçamento");
			jButtonPreOrcamento.setForeground(Cores.cinza3);
			jButtonPreOrcamento.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonPreOrcamento.setBorder(null);
			jButtonPreOrcamento.setFocusPainted(false);
			jButtonPreOrcamento.setSize(250,36);
			jButtonPreOrcamento.setVisible(false);
			
		}
		return jButtonPreOrcamento;
	}


	public JButton getjButtonOrcamentoFinal() {
		if(jButtonOrcamentoFinal == null) {
			jButtonOrcamentoFinal = new JButton();
			jButtonOrcamentoFinal.setBackground(Cores.branco);
			jButtonOrcamentoFinal.setFont(Fontes.fontJButtonsMenuLateral);
			jButtonOrcamentoFinal.setText("Orçamento Final");
			jButtonOrcamentoFinal.setForeground(Cores.cinza3);
			jButtonOrcamentoFinal.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonOrcamentoFinal.setBorder(null);
			jButtonOrcamentoFinal.setFocusPainted(false);
			jButtonOrcamentoFinal.setSize(250,36);
			jButtonOrcamentoFinal.setVisible(false);
			
		}
		return jButtonOrcamentoFinal;
	}


	public JButton getjButtonVeiculos() {
		if(jButtonVeiculos == null) {
			jButtonVeiculos = new JButton();
			jButtonVeiculos.setBackground(Cores.branco);
			jButtonVeiculos.setFont(Fontes.fontJButtonsMenuLateral);
			jButtonVeiculos.setText(" Veículos");
			jButtonVeiculos.setForeground(Cores.cinza2);
			setSizeIcon.setIconJButton(jButtonVeiculos, Icones.
					getVeiculos(this), xIconJButton, yIconJButton);
			jButtonVeiculos.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonVeiculos.setBorder(null);
			jButtonVeiculos.setFocusPainted(true);
			jButtonVeiculos.setSize(250,36);
			
		}
		return jButtonVeiculos;
	}


	public JButton getjButtonClientes() {
		if(jButtonClientes == null) {
			jButtonClientes = new JButton();
			jButtonClientes.setBackground(Cores.branco);
			jButtonClientes.setFont(Fontes.fontJButtonsMenuLateral);
			jButtonClientes.setText(" Clientes");
			jButtonClientes.setForeground(Cores.cinza2);
			setSizeIcon.setIconJButton(jButtonClientes, Icones.
					getClientes(this), xIconJButton, yIconJButton);
			jButtonClientes.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonClientes.setBorder(null);
			jButtonClientes.setFocusPainted(false);
			jButtonClientes.setSize(250,36);
			
		}
		return jButtonClientes;
	}


	public JButton getjButtonUsuarios() {
		if(jButtonUsuarios == null) {
			jButtonUsuarios = new JButton();
			jButtonUsuarios.setBackground(Cores.branco);
			jButtonUsuarios.setFont(Fontes.fontJButtonsMenuLateral);
			jButtonUsuarios.setText(" Usuários");
			jButtonUsuarios.setForeground(Cores.cinza2);
			setSizeIcon.setIconJButton(jButtonUsuarios, Icones.
					getUsuarios(this), xIconJButton, yIconJButton);
			jButtonUsuarios.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonUsuarios.setBorder(null);
			jButtonUsuarios.setFocusPainted(false);
			jButtonUsuarios.setSize(250,36);
			
		}
		return jButtonUsuarios;
	}


	public JButton getjButtonEstoque() {
		if(jButtonEstoque == null) {
			jButtonEstoque = new JButton();
			jButtonEstoque.setBackground(Cores.branco);
			jButtonEstoque.setFont(Fontes.fontJButtonsMenuLateral);
			jButtonEstoque.setText(" Estoque");
			jButtonEstoque.setForeground(Cores.cinza2);
			setSizeIcon.setIconJButton(jButtonEstoque, Icones.
					getEstoque(this), xIconJButton, yIconJButton);
			jButtonEstoque.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonEstoque.setBorder(null);
			jButtonEstoque.setFocusPainted(false);
			jButtonEstoque.setSize(250,36);
			
		}
		return jButtonEstoque;
	}


	public JButton getjButtonConfiguracao() {
		if(jButtonConfiguracao == null) {
			jButtonConfiguracao = new JButton();
			jButtonConfiguracao.setBackground(Cores.branco);
			jButtonConfiguracao.setFont(Fontes.fontJButtonsMenuLateral);
			jButtonConfiguracao.setText(" Configurações");
			jButtonConfiguracao.setForeground(Cores.cinza2);
			setSizeIcon.setIconJButton(jButtonConfiguracao, Icones.
					getConfiguracao(this), xIconJButton, yIconJButton);
			jButtonConfiguracao.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonConfiguracao.setBorder(null);
			jButtonConfiguracao.setFocusPainted(false);
			jButtonConfiguracao.setSize(250,36);
			
		}
		return jButtonConfiguracao;
	}
	
	
	
	//** Fim getters JButon **
	
	
	//** Início getters JLabel **
	
	public JLabel getjLabelUser() {
		if(jLabelUser == null) {
			jLabelUser = new JLabel();
			jLabelUser.setBackground(Cores.branco);
			jLabelUser.setFont(Fontes.fontJButtonsMenuLateral);
			jLabelUser.setText(" Uilian");
			jLabelUser.setForeground(Cores.cinza2);
			setSizeIcon.setIconJLabel(jLabelUser, Icones.
					getUser(this), 52, 52);
			jLabelUser.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUser.setBorder(null);
			jLabelUser.setSize(167,52);
			
		}
		return jLabelUser;
	}
	
	
	public JLabel getjLabelDescricaoTela() {
		if(jLabelDescricaoTela == null) {
			jLabelDescricaoTela = new JLabel();
			jLabelDescricaoTela.setBackground(Cores.branco);
			jLabelDescricaoTela.setFont(Fontes.fontJLabelBarraMenu);
			jLabelDescricaoTela.setText("Início");
			jLabelDescricaoTela.setForeground(Cores.branco);
			jLabelDescricaoTela.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelDescricaoTela.setBorder(null);
			jLabelDescricaoTela.setSize(280,30);
			
		}
		return jLabelDescricaoTela;
	}

	//** Fim getters JLabel **
	
	//** Início métodos adição de componentes **
	
	
	


	public void addCompJPanelPrincipal() {
		this.getJPanelPrincipal().add(this.getjPanelMenuLateral());
		this.getjPanelMenuLateral().setLocation(0,0);
		
		this.getJPanelPrincipal().add(this.getjPanelBarraMenu());
		this.getjPanelBarraMenu().setLocation(250,0);
	}
	
	
	public void addCompJPanelBarraMenu(){
		this.getjPanelBarraMenu().add(this.getjLabelDescricaoTela());
		this.getjLabelDescricaoTela().setLocation(17, 9);
	}
	
	
	public void addCompJPanelMenuLateral() {
		this.getjPanelMenuLateral().add(this.getjLabelUser());
		this.getjLabelUser().setLocation(5,7);
		
		
		this.getjPanelMenuLateral().add(this.getJButtonInicio());
		this.getJButtonInicio().setLocation(4,95);

		
		this.getjPanelMenuLateral().add(this.getjButtonOS());
		this.getjButtonOS().setLocation(4,140);

		
		this.getjPanelMenuLateral().add(this.getjButtonOSConsulta());
		this.getjButtonOSConsulta().setLocation(40,178);

		
		this.getjPanelMenuLateral().add(this.getjButtonOSCriar());
		this.getjButtonOSCriar().setLocation(44,208);

		
		this.getjPanelMenuLateral().add(this.getjButtonVendas());
		this.getjButtonVendas().setLocation(4, 185 + getSizeOSOpen());

		
		this.getjPanelMenuLateral().add(this.getjButtonOrcamento());
		this.getjButtonOrcamento().setLocation(4,230 + getSizeOSOpen());

		
		this.getjPanelMenuLateral().add(this.getjButtonPreOrcamento());
		this.getjButtonPreOrcamento().setLocation(44,268 + getSizeOSOpen());

		
		this.getjPanelMenuLateral().add(this.getjButtonOrcamentoFinal());
		this.getjButtonOrcamentoFinal().setLocation(44,298 + getSizeOSOpen());

		
		this.getjPanelMenuLateral().add(this.getjButtonVeiculos());
		this.getjButtonVeiculos().setLocation(4,275 + getSizeOSOpen() +
				getSizeOrcamentoOpen());

		
		this.getjPanelMenuLateral().add(this.getjButtonClientes());
		this.getjButtonClientes().setLocation(4,320 + getSizeOSOpen() +
				getSizeOrcamentoOpen());

		
		this.getjPanelMenuLateral().add(this.getjButtonUsuarios());
		this.getjButtonUsuarios().setLocation(4,365 + getSizeOSOpen() +
				getSizeOrcamentoOpen());

		
		this.getjPanelMenuLateral().add(this.getjButtonEstoque());
		this.getjButtonEstoque().setLocation(4, 410 + getSizeOSOpen() +
				getSizeOrcamentoOpen());

		
		this.getjPanelMenuLateral().add(this.getjButtonConfiguracao());
		this.getjButtonConfiguracao().setLocation(4,455 + getSizeOSOpen() +
				getSizeOrcamentoOpen());
		
	}


	
	
	
	//** Fim métodos adição de componentes **
	
	//** Início métodos da classe **
	public int getSizeOSOpen() {
		return sizeOSOpen;
	}


	public void setSizeOSOpen(int sizeOSOpen) {
		this.sizeOSOpen = sizeOSOpen;
	}


	public int getSizeOrcamentoOpen() {
		return sizeOrcamentoOpen;
	}


	public void setSizeOrcamentoOpen(int sizeOrcamentoOpen) {
		this.sizeOrcamentoOpen = sizeOrcamentoOpen;
	}
	
	

	public JPanel getjPanelCenterAnterior() {
		if(jPanelCenterAnterior == null){
			jPanelCenterAnterior = new JPanel();
		}
		return jPanelCenterAnterior;
	}
	
	
	public void setjPanelCenterAnterior(JPanel jPanel) {
		jPanelCenterAnterior = jPanel;
	}
	
	
	// Isere um jPanel e sua respectiva localização na Frame
	public void alterarJPanel(JPanel jPanel, Point point) {	
		if(getjPanelCenterAnterior() != null) { // Condição para retirar jPanel do JFrame, caso haja algum.
			this.getJPanelPrincipal().remove(getjPanelCenterAnterior());
		}
		
		this.getJPanelPrincipal().add(jPanel);
		jPanel.setLocation(point);
		
		this.setjPanelCenterAnterior(jPanel);
		
		System.out.println("adicionou nova tela à jpanelprincipal");
		this.repaint();
		this.validate();
	}
	
	//** Fim métodos da classe **
	

}
