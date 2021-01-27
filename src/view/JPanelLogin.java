package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Cores;
import model.Fontes;
import model.SetSizeIcon;

public class JPanelLogin extends JPanel{
	
	//** Início declaração de variáveis **
	
	SetSizeIcon setSizeIcon = new SetSizeIcon();	
	
	private JLabel jLabelImagemFundoLogin;
	
	private JPanel jPanelCentralLogin;
	
	private JTextField jTFieldUsuario;
	private JPasswordField jPFieldSenha;
	
	private JCheckBox jCBoxLembrarSenha;
	
	private JButton jButtonEntrar;
	
	private JLabel jLabelIconTitulo;
	private JLabel jLabelTitulo;
	private JLabel jLabelTitulo1;
	private JLabel jLabelUsuario;
	private JLabel jLabelSenha;
	private JLabel jLabelErro;
	
	
		
	//** Fim declaração de variáveis **
	
	//** Início construtor **
	
	public JPanelLogin() {
		
		this.addCompJPanelCentralLogin();		
		this.addCompJPanelLogin();
	}
	//** Fim construtor **
	
	//** Início getters JPanels **
	
	public JPanel getjPanelCentralLogin() {
		if(jPanelCentralLogin == null) {
			jPanelCentralLogin = new JPanel();
			jPanelCentralLogin.setLayout(null);
			jPanelCentralLogin.setBackground(Cores.pretoTransparent);
			jPanelCentralLogin.setSize(307,504);
			jPanelCentralLogin.setBorder(BorderFactory.createLineBorder(Cores.cinza2, 1));
		}
		return jPanelCentralLogin;
	}
	
	
	public JPanel getJPanelLogin() {
		this.setLayout(null);
		this.setSize(new Dimension(1280,720));
		this.setBackground(Cores.cinza2);
		this.setVisible(true);
		
		return this;
	}
	
	//** Fim getters JPanel **
	
	
	
	//** Início getters JLabel **
	

	public JLabel getjLabelImagemFundoLogin() {
		if(jLabelImagemFundoLogin == null) {
			jLabelImagemFundoLogin = new JLabel();
			jLabelImagemFundoLogin.setIcon(new ImageIcon(JPanelLogin.class.getResource("/images/Login.jpg")));
			jLabelImagemFundoLogin.setSize(1280, 720);
		}
		return jLabelImagemFundoLogin;
	}
	
	public JLabel getjLabelIconTitulo() {
		if(jLabelIconTitulo == null) {
			jLabelIconTitulo = new JLabel();
			jLabelIconTitulo.setSize(110, 110);
			setSizeIcon.redimencionaImagem(jLabelIconTitulo, "/images/accounting-30.png");
		}
		return jLabelIconTitulo;
	}
	
	

	public JLabel getjLabelTitulo() {
		if(jLabelTitulo == null) {
			jLabelTitulo = new JLabel();
			jLabelTitulo.setFont(Fontes.fontLoginMax);
			jLabelTitulo.setForeground(Color.white);
			jLabelTitulo.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelTitulo.setText("Workshop");
			jLabelTitulo.setOpaque(false);
			jLabelTitulo.setSize(110,30);
		}
		return jLabelTitulo;
	}
	
	
	public JLabel getjLabelTitulo1() {
		if(jLabelTitulo1 == null) {
			jLabelTitulo1 = new JLabel();
			jLabelTitulo1.setFont(Fontes.fontLoginMax);
			jLabelTitulo1.setForeground(Color.white);
			jLabelTitulo1.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelTitulo1.setText("Manager");
			jLabelTitulo1.setOpaque(false);
			jLabelTitulo1.setSize(95,30);
		}
		return jLabelTitulo1;
	}
	
	
	
	public JLabel getjLabelUsuario() {
		if(jLabelUsuario == null) {
			jLabelUsuario = new JLabel();
			jLabelUsuario.setFont(Fontes.fontLoginMax);
			jLabelUsuario.setForeground(Color.white);
			jLabelUsuario.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUsuario.setText("USUÁRIO");
			jLabelUsuario.setOpaque(false);
			jLabelUsuario.setSize(100,30);
		}
		return jLabelUsuario;
	}
	
	
	public JLabel getjLabelSenha() {
		if(jLabelSenha == null) {
			jLabelSenha = new JLabel();
			jLabelSenha = new JLabel();
			jLabelSenha.setFont(Fontes.fontLoginMax);
			jLabelSenha.setForeground(Color.white);
			jLabelSenha.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelSenha.setText("SENHA");
			jLabelSenha.setOpaque(false);
			jLabelSenha.setSize(100,30);
		}
		return jLabelSenha;
	}
	
	
	public JLabel getjLabelErro() {
		if(jLabelErro == null) {
			jLabelErro = new JLabel();
			jLabelErro.setFont(Fontes.fontLoginMin);
			jLabelErro.setForeground(Cores.vermelho);
			jLabelErro.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelErro.setText("Senha ou usuário incorretos");
			jLabelErro.setOpaque(false);
			jLabelErro.setVisible(false);
			jLabelErro.setSize(215,21);
		}
		return jLabelErro;
	}
	
	//** Fim getters JLabel **
	
	
	
	
	//** Início getters JButon **
	
	public JButton getjButtonEntrar() {
		if(jButtonEntrar == null) {
			jButtonEntrar = new JButton();
			
			jButtonEntrar.setFont(Fontes.fontLoginMax);
			jButtonEntrar.setBackground(Cores.azul1);
			jButtonEntrar.setForeground(Color.white);
			jButtonEntrar.setText("Entrar");
			jButtonEntrar.setSize(271,45);
			jButtonEntrar.setFocusable(false);
			jButtonEntrar.setBorder(BorderFactory.createLineBorder(Cores.cinza2, 1));
		}
		return jButtonEntrar;
	}
	
	//** Fim getters JButon **
	
	
	
	//** Início getters JFields **
	
	public JTextField getjTFieldUsuario() {
		if(jTFieldUsuario == null) {
			jTFieldUsuario = new JTextField();
			jTFieldUsuario.setBorder(BorderFactory.createLineBorder(Cores.cinza2, 1));
			jTFieldUsuario.setBackground(Color.white);
			jTFieldUsuario.setForeground(Cores.preto);
			jTFieldUsuario.setFont(Fontes.fontLoginMax);
			jTFieldUsuario.setSize(270, 45);
			jTFieldUsuario.setOpaque(true);
			
		}
		return jTFieldUsuario;
	}
	
	
	public JPasswordField getjPFieldSenha() {
		if(jPFieldSenha == null) {
			jPFieldSenha = new JPasswordField();
			jPFieldSenha.setBorder(BorderFactory.createLineBorder(Cores.cinza2, 1));
			jPFieldSenha.setBackground(Color.white);
			jPFieldSenha.setForeground(Cores.preto);
			jPFieldSenha.setFont(Fontes.fontLoginMax);
			jPFieldSenha.setSize(270, 45);
			jPFieldSenha.setOpaque(true);
		}
		return jPFieldSenha;
	}
	
	//** Fim getters JFields **
	
	
	
	//** Início getters JComboBox **
	
	public JCheckBox getjCBoxLembrarSenha() {
		if(jCBoxLembrarSenha == null) {
			jCBoxLembrarSenha = new JCheckBox();
			jCBoxLembrarSenha.setForeground(Color.white);
			jCBoxLembrarSenha.setFont(Fontes.fontLoginMin);
			jCBoxLembrarSenha.setSize(271,21);
			jCBoxLembrarSenha.setOpaque(false);
			jCBoxLembrarSenha.setFocusable(false);
			jCBoxLembrarSenha.setText("Lembrar senha");
		}
		return jCBoxLembrarSenha;
		
	}
	
	//** Fim getters JComboBox **
	
	
	
	
	//** Início métodos adição de componentes **
	
	public void addCompJPanelLogin() {
		
		this.add(this.getjPanelCentralLogin());
		this.getjPanelCentralLogin().setLocation(487, 108);
		
		this.add(this.getjLabelImagemFundoLogin());
		this.getjLabelImagemFundoLogin().setLocation(0,0);
		
	
	}
	
	
	public void addCompJPanelCentralLogin() {
		
		this.jPanelCentralLogin.add(this.getjLabelIconTitulo());
		this.getjLabelIconTitulo().setLocation(12, 12);
		
		this.jPanelCentralLogin.add(this.getjLabelTitulo());
		this.getjLabelTitulo().setLocation(132, 39);
		
		this.jPanelCentralLogin.add(this.getjLabelTitulo1());
		this.getjLabelTitulo1().setLocation(173, 69);
		
		this.jPanelCentralLogin.add(this.getjLabelUsuario());
		this.getjLabelUsuario().setLocation(19, 158);
		
		this.jPanelCentralLogin.add(this.getjTFieldUsuario());
		this.getjTFieldUsuario().setLocation(19, 197);	
		
		this.jPanelCentralLogin.add(this.getjLabelSenha());
		this.getjLabelSenha().setLocation(19, 260);
		
		this.jPanelCentralLogin.add(this.getjPFieldSenha());
		this.getjPFieldSenha().setLocation(19, 299);	
		
		this.jPanelCentralLogin.add(this.getjCBoxLembrarSenha());
		this.getjCBoxLembrarSenha().setLocation(19, 362);
				
		this.jPanelCentralLogin.add(this.getjLabelErro());
		this.getjLabelErro().setLocation(19, 401);
		
		this.jPanelCentralLogin.add(this.getjButtonEntrar());
		this.getjButtonEntrar().setLocation(18, 440);
	}
	//** Fim métodos adição de componentes **
	
	
}
