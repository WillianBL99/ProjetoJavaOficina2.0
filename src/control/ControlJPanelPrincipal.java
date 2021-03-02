package control;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

import icons.Icones;
import model.Cores;
import model.SetSizeIcon;
import view.JDialogProcurarVeiculo;
import view.JFramePrincipal;
import view.JPanelConsultarOS;
import view.JPanelEstoque;
import view.JPanelGeraOS;
import view.JPanelHome;
import view.JPanelOrcamentoFinal;
import view.JPanelPreOrcamento;
import view.JPanelPreOrcamentoNovo;
import view.JPanelPrincipal;
import view.JPanelUsuarios;
import view.JPanelVendas;

public class ControlJPanelPrincipal  implements MouseListener, KeyListener {
	

	
	//** Início declaração de variáveis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	
	private JFramePrincipal jFramePrincipal;
	private JPanelPrincipal jPanelPrincipal;
	
	private JPanelHome jPanelHome;
	private JPanelGeraOS jPanelGeraOS;
	private JPanelConsultarOS jPanelConsultarOS;
	private JPanelVendas jPanelVendas;
	private JPanelPreOrcamento jPanelPreOrcamento;
	private JPanelOrcamentoFinal jPanelOrcamentoFinal;
	private JPanelUsuarios jPanelUsuarios;
	private JPanelEstoque jPanelEstoque;

	private ControlJPanelHome controlJPanelHome;
	private ControlJPanelVendas controlJPanelVendas;

	private int sizeOSOpen;
	private int sizeOrcamentoOpen;
	private JButton jButtonClicado; // guarda o jbutton clicado
	private String iconeJButtonClicado; // guarda o caminho do icone do jbutton clicado
	
	private Point point = new Point(250, 47); // posição que a tela e setada na jpanelprincipal
	
	
	//** Fim declaração de variáveis **	
	
	public ControlJPanelPrincipal(JFramePrincipal jFramePricipal, JPanelPrincipal jPanelPrincipal) {		
		this.jPanelPrincipal = jPanelPrincipal;
		this.jFramePrincipal = jFramePricipal;
		
		jButtonClicado = this.getjPanelPrincipal().getJButtonInicio();
		iconeJButtonClicado = Icones.getHomeOff();
		
		getjPanelPrincipal().alterarJPanel(this.getjPanelHome(), point);
		getControlJPanelHome();

		AddEvent();
		
	}


	private void AddEvent() {
		getjPanelPrincipal().getJButtonInicio().addMouseListener(this);
		getjPanelPrincipal().getjButtonOS().addMouseListener(this);
		getjPanelPrincipal().getjButtonOSConsulta().addMouseListener(this);
		getjPanelPrincipal().getjButtonOSCriar().addMouseListener(this);
		getjPanelPrincipal().getjButtonVendas().addMouseListener(this);
		getjPanelPrincipal().getjButtonOrcamento().addMouseListener(this);
		getjPanelPrincipal().getjButtonPreOrcamento().addMouseListener(this);
		getjPanelPrincipal().getjButtonOrcamentoFinal().addMouseListener(this);
		getjPanelPrincipal().getjButtonVeiculos().addMouseListener(this);
		getjPanelPrincipal().getjButtonClientes().addMouseListener(this);
		getjPanelPrincipal().getjButtonUsuarios().addMouseListener(this);
		getjPanelPrincipal().getjButtonEstoque().addMouseListener(this);
		getjPanelPrincipal().getjButtonConfiguracao().addMouseListener(this);
		
	}
		
		
	//** Início métodos sobrescritos **
	@Override
	public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
			
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
			
	}

	
	@Override
	public void mouseClicked(MouseEvent e) { // Quando algum botão for clicado		
		
		if(e.getSource() == this.getjPanelPrincipal().getJButtonInicio()) {		
			this.mudarCorJButtonSelecionado(this.getjPanelPrincipal().getJButtonInicio(), Icones.getHomeOn(), Icones.getHomeOff());
			getjPanelPrincipal().alterarJPanel(this.getjPanelHome(), point);	
			this.setSizeOSOpen(false);
			this.setSizeOrcamentoOpen(false);
			
			
		} else if(e.getSource() == this.getjPanelPrincipal().getjButtonOS()) {
			this.mudarCorJButtonSelecionado(this.getjPanelPrincipal().getjButtonOS(), Icones.getOSOn(), Icones.getOSOff());
			this.setSizeOSOpen(true);
			this.setSizeOrcamentoOpen(false);
			
			
		} else if(e.getSource() == this.getjPanelPrincipal().getjButtonOSCriar()) {
			getjPanelPrincipal().alterarJPanel(this.getjPanelGerarOS(), point);	
			
			
		} else if(e.getSource() == this.getjPanelPrincipal().getjButtonOSConsulta()) {
			getjPanelPrincipal().alterarJPanel(this.getjPanelConsultarOS(), point);	
			
			
		}  else if(e.getSource() == this.getjPanelPrincipal().getjButtonVendas()) {
			this.mudarCorJButtonSelecionado(this.getjPanelPrincipal().getjButtonVendas(), Icones.getVendasOn(), Icones.getVendasOff());
			getjPanelPrincipal().alterarJPanel(getjPanelVendas(), point, this.getjPanelVendas().getTituloDescricaoTela());
			getControlJPanelVendas();
			this.setSizeOSOpen(false);
			this.setSizeOrcamentoOpen(false);
			
			
		} else if(e.getSource() == this.getjPanelPrincipal().getjButtonOrcamento()) {
			this.mudarCorJButtonSelecionado(this.getjPanelPrincipal().getjButtonOrcamento(), Icones.getOrcamentoOn(), Icones.getOrcamentoOff());
			this.setSizeOSOpen(false);
			this.setSizeOrcamentoOpen(true);
			
			
		} else if(e.getSource() == this.getjPanelPrincipal().getjButtonPreOrcamento()) {
			getjPanelPrincipal().alterarJPanel(getjPanelPreOrcamento(), point, this.getjPanelPreOrcamento().getTituloDescricaoTela());			
			
			
		} else if(e.getSource() == this.getjPanelPrincipal().getjButtonOrcamentoFinal()) {
			getjPanelPrincipal().alterarJPanel(getjPanelOrcamentoFinal(), point, this.getjPanelOrcamentoFinal().getTituloDescricaoTela());			
			
			
		} else if(e.getSource() == this.getjPanelPrincipal().getjButtonVeiculos()) {
			this.mudarCorJButtonSelecionado(this.getjPanelPrincipal().getjButtonVeiculos(), Icones.getVeiculosOn(), Icones.getVeiculosOff());
			this.setSizeOSOpen(false);
			this.setSizeOrcamentoOpen(false);
			
		} else if(e.getSource() == this.getjPanelPrincipal().getjButtonClientes()) {
			this.mudarCorJButtonSelecionado(this.getjPanelPrincipal().getjButtonClientes(), Icones.getClientesOn(), Icones.getClientesOff());
			this.setSizeOSOpen(false);
			this.setSizeOrcamentoOpen(false);
			
			
		} else if(e.getSource() == this.getjPanelPrincipal().getjButtonUsuarios()) {
			this.mudarCorJButtonSelecionado(this.getjPanelPrincipal().getjButtonUsuarios(), Icones.getUsuariosOn(), Icones.getUsuarioOff());
			getjPanelPrincipal().alterarJPanel(getjPanelUsuarios(), point);
			this.setSizeOSOpen(false);
			this.setSizeOrcamentoOpen(false);
			
			
		} else if(e.getSource() == this.getjPanelPrincipal().getjButtonEstoque()) {
			this.mudarCorJButtonSelecionado(this.getjPanelPrincipal().getjButtonEstoque(), Icones.getEstoqueOn(), Icones.getEstoqueOff());
			this.getjPanelPrincipal().alterarJPanel(this.getjPanelEstoque(), point, this.getjPanelEstoque().getTituloDescricaoTela());
			this.setSizeOSOpen(false);
			this.setSizeOrcamentoOpen(false);
			
		} else if(e.getSource() == this.getjPanelPrincipal().getjButtonConfiguracao()) {
			this.mudarCorJButtonSelecionado(this.getjPanelPrincipal().getjButtonConfiguracao(), Icones.getConfiguracaoOn(), Icones.getConfiguracaoOff());
			this.setSizeOSOpen(false);
			this.setSizeOrcamentoOpen(false);
			this.getjPanelPrincipal().alterarJPanel(new JPanelPreOrcamentoNovo(), point);
			//new JDialogProcurarVeiculo(getjFramePricipal(), false);
		}
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
			
	}


	@Override
	public void mouseReleased(MouseEvent e) {
			
	}
	

	@Override
	public void mouseEntered(MouseEvent e) { // Quando o ponteiro do mouse passar por algum componente
		
		if(e.getSource() == this.getjPanelPrincipal().getJButtonInicio()) {
			
			
		} else if(e.getSource() == this.getjPanelPrincipal().getjButtonOS()) {
			
			
		} else if(e.getSource() == this.getjPanelPrincipal().getjButtonVendas()) {
			
			
		} else if(e.getSource() == this.getjPanelPrincipal().getjButtonOrcamento()) {
			
			
		} else if(e.getSource() == this.getjPanelPrincipal().getjButtonVeiculos()) {
			
			
		} else if(e.getSource() == this.getjPanelPrincipal().getjButtonClientes()) {
			
			
		} else if(e.getSource() == this.getjPanelPrincipal().getjButtonUsuarios()) {
			
			
		} else if(e.getSource() == this.getjPanelPrincipal().getjButtonEstoque()) {
			
			
		} else if(e.getSource() == this.getjPanelPrincipal().getjButtonConfiguracao()) {
			
			
		}
	}


	@Override
	public void mouseExited(MouseEvent e) { // Quando o ponteiro do mouse sair de algum componente		}
			
	}	
		
	//** Fim métodos sobrescritos **
	
	//** Início métodos da classe **

		public JPanelPrincipal getjPanelPrincipal() {
			if(jPanelPrincipal == null){
				jPanelPrincipal = new JPanelPrincipal();
			}
			return jPanelPrincipal;
		}


		public JFramePrincipal getjFramePricipal() {
			if(jFramePrincipal == null){
				jFramePrincipal = new JFramePrincipal();
			}
			return jFramePrincipal;
		}
	
	
		public JPanelHome getjPanelHome() {
			if(jPanelHome == null){
				jPanelHome = new JPanelHome();
			}
			return jPanelHome;
		}
		
		
		public ControlJPanelHome getControlJPanelHome() {
			if(controlJPanelHome == null){
				controlJPanelHome = new ControlJPanelHome(getjPanelHome());
		
			}
			return controlJPanelHome;
		}
				
		
		public JPanelVendas getjPanelVendas() {
			if(jPanelVendas == null){
				jPanelVendas = new JPanelVendas();
			}
			return jPanelVendas;
		}
		
		
		public ControlJPanelVendas getControlJPanelVendas() {
			if(controlJPanelVendas == null){
				controlJPanelVendas = new ControlJPanelVendas(getjFramePricipal(), getjPanelVendas(), getjPanelPrincipal());
		
			}
			return controlJPanelVendas;
		}
		
		
		public JPanelGeraOS getjPanelGerarOS() {
			if(jPanelGeraOS == null){
				jPanelGeraOS = new JPanelGeraOS();
			}
			return jPanelGeraOS;
		}
		
		
		public JPanelConsultarOS getjPanelConsultarOS() {
			if(jPanelConsultarOS == null){
				jPanelConsultarOS = new JPanelConsultarOS();
			}
			return jPanelConsultarOS;
		}
		
		
		public JPanelPreOrcamento getjPanelPreOrcamento() {
			if(jPanelPreOrcamento == null){
				jPanelPreOrcamento = new JPanelPreOrcamento();
			}
			return jPanelPreOrcamento;
		}
		
		
		public JPanelOrcamentoFinal getjPanelOrcamentoFinal() {
			if(jPanelOrcamentoFinal == null){
				jPanelOrcamentoFinal = new JPanelOrcamentoFinal();
			}
			return jPanelOrcamentoFinal;
		}
		
		
		public JPanelUsuarios getjPanelUsuarios() {
			if(jPanelUsuarios == null){
				jPanelUsuarios = new JPanelUsuarios();
			}
			return jPanelUsuarios;
		}
		
		
		public JPanelEstoque getjPanelEstoque() {
			if(jPanelEstoque == null){
				jPanelEstoque = new JPanelEstoque();
			}
			return jPanelEstoque;
		}
		
		public void setLocalizaçãoJButtonsMenuLateral() { // quando os jbuttons OS ou Orçamento forem solicitados
			//chamar para setar a nova localização dos demais jbuttons
			this.getjPanelPrincipal().getjButtonVendas().setLocation(4, 185 + getSizeOSOpen());

			
			this.getjPanelPrincipal().getjButtonOrcamento().setLocation(4,230 + getSizeOSOpen());

			
			this.getjPanelPrincipal().getjButtonPreOrcamento().setLocation(44,268 + getSizeOSOpen());

			
			this.getjPanelPrincipal().getjButtonOrcamentoFinal().setLocation(44,298 + getSizeOSOpen());

			
			this.getjPanelPrincipal().getjButtonVeiculos().setLocation(4,275 + getSizeOSOpen() +
					getSizeOrcamentoOpen());

			
			this.getjPanelPrincipal().getjButtonClientes().setLocation(4,320 + getSizeOSOpen() +
					getSizeOrcamentoOpen());

			
			this.getjPanelPrincipal().getjButtonUsuarios().setLocation(4,365 + getSizeOSOpen() +
					getSizeOrcamentoOpen());

			
			this.getjPanelPrincipal().getjButtonEstoque().setLocation(4, 410 + getSizeOSOpen() +
					getSizeOrcamentoOpen());

			
			this.getjPanelPrincipal().getjButtonConfiguracao().setLocation(4,455 + getSizeOSOpen() +
					getSizeOrcamentoOpen());
			
		}
		
		
		public int getSizeOSOpen() {
			return sizeOSOpen;
		}


		public void setSizeOSOpen(boolean sizeOSOpen) {
			if(sizeOSOpen) { // se for verdadeiro
				this.sizeOSOpen = 60;
				this.getjPanelPrincipal().getjButtonOSConsulta().setVisible(true);
				this.getjPanelPrincipal().getjButtonOSCriar().setVisible(true);
			} else {
				this.sizeOSOpen = 0;
				this.getjPanelPrincipal().getjButtonOSConsulta().setVisible(false);
				this.getjPanelPrincipal().getjButtonOSCriar().setVisible(false);
			}
			
			this.setLocalizaçãoJButtonsMenuLateral();
		}


		public int getSizeOrcamentoOpen() {
			return sizeOrcamentoOpen;
		}

		
		/*
		 * método setSizeOrcamentoOpen(@sizeOrcamentoOpen)
		 * 
		 * @sizeOrcamentoOpen - Recebe um valor boolean para exibir as opções de Orçamento.
		 * Ao chegar um valor true os jbutons abaixo de jButtonInicio "decem" enquanto dois jbuttons ficão visíveis 
		 * abaixo do jButtonOS
		 *  
		 */
		public void setSizeOrcamentoOpen(boolean sizeOrcamentoOpen) { // Mostra os jButtons gerarOS e ConsultarOS
			if(sizeOrcamentoOpen) { // se for verdadeiro
				this.sizeOrcamentoOpen = 60;
				this.getjPanelPrincipal().getjButtonOrcamentoFinal().setVisible(true);
				this.getjPanelPrincipal().getjButtonPreOrcamento().setVisible(true);
			} else {
				this.sizeOrcamentoOpen = 0;
				this.getjPanelPrincipal().getjButtonOrcamentoFinal().setVisible(false);
				this.getjPanelPrincipal().getjButtonPreOrcamento().setVisible(false);
			}
			
			this.setLocalizaçãoJButtonsMenuLateral();
		}
		
		/*
		 * método mudarCorJButtonSelecionado(@jButton, @iconeSelected, @iconeNotSelected)
		 * 
		 * @jButton - Recebe como parâmetro o JButton para realização de mudança de ícone,
		 * mudança de background e mudança de foreground.
		 * 
		 * @iconeSelected - Recebe caminho do ícone que deve ser setado quando o JButton
		 * estiver selecionado.
		 * 
		 * @iconeNotSelected - Recebe caminho do ícone que deve ser setado quando o JButton não
		 * estiver selecionado.
		 * 
		 */
		public void mudarCorJButtonSelecionado(JButton jButton, String iconeSelected, String iconeNotSelected) {
			if(jButtonClicado != null && jButtonClicado != jButton) { 
				// setando a nova aparência do JButton clicado.
				jButton.setBackground(Cores.azul1);
				jButton.setForeground(Cores.branco);
				setSizeIcon.setIconJButton(jButton, iconeSelected, 34 ,34);
				// setando a aparência do JButton clicado ateriormente.
				jButtonClicado.setBackground(Cores.branco);
				jButtonClicado.setForeground(Cores.cinza2);
				setSizeIcon.setIconJButton(jButtonClicado, iconeJButtonClicado, 34 ,34);
				// guardando os caminhos dos ícones do JButton que está selecionado.
				jButtonClicado = jButton;
				iconeJButtonClicado = iconeNotSelected;
			}
		}
		
		
	//** Fim métodos da classe **
}