package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Cores;
import model.Fontes;
import model.SetSizeIcon;

public class JPanelVendas extends JPanel {

	
	//** Início declaração de variáveis **
	
	private JPanel jPanelBarraSup;
	private JPanel jPanelCentroVendas;
	private JPanel jPanelProduto;
	private JPanel jPanelInserirProduto;
	private JPanel jPanelProdutoCompra;
	
	private JTextField jTFieldProdutoQuantidade;
	private JTextField jTFieldProdutoVal;
	private JTextField jTFieldProdutoValTot;

	private JTextField jTFieldInserirProdutoDesc;
	private JTextField jTFieldInserirProdutoQuant;
	
	private JTextField JTFieldTotal;
	
	private JComboBox<String> jComboBoxDesc;
	
	private JScrollPane jSPInserirProduto;
	private JScrollPane jSPProdutosCompra;
	
	private JTable jTableInserirProduto;
	private JTable jTableProdutosCompra;

	
	private JLabel jLabelProdutoDesc;
	private JLabel jLabelTotal;
	private JLabel jLabelQuantidade;
	
	private JButton jButtonProsseguir;
	
	
		
	//** Fim declaração de variáveis **
	
	//** Início construtor **
	
	public JPanelVendas() {
		
	}
	
	//** Fim construtor **
	
	//** Início getters JPanels **
	
	
	public JPanel getjPanelBarraSup() {
		return jPanelBarraSup;
	}

	public JPanel getjPanelCentroVendas() {
		return jPanelCentroVendas;
	}

	public JPanel getjPanelProduto() {
		return jPanelProduto;
	}

	public JPanel getjPanelInserirProduto() {
		return jPanelInserirProduto;
	}

	public JPanel getjPanelProdutoCompra() {
		if(jPanelCentralLogin == null) {
			jPanelCentralLogin = new JPanel();
			jPanelCentralLogin.setLayout(null);
			jPanelCentralLogin.setBackground(Cores.pretoTransparent);
			jPanelCentralLogin.setSize(307,504);
			jPanelCentralLogin.setBorder(BorderFactory.createLineBorder(Cores.cinza2, 1));
		}
		return jPanelProdutoCompra;
	}
	
	
	
	
	public JPanel getjPanelVendas() {
		this.setLayout(null);
		this.setSize(new Dimension(1280,720));
		this.setBackground(Cores.cinza2);
		this.setVisible(true);
		
		return this;
	}
	
	//** Fim getters JPanel **
	
	
	
	//** Início getters JLabel **
	
	public JLabel getjLabelProdutoDesc() {
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
		return jLabelProdutoDesc;
	}

	public JLabel getjLabelTotal() {
		return jLabelTotal;
	}

	public JLabel getjLabelQuantidade() {
		return jLabelQuantidade;
	}
	

	//** Fim getters JLabel **
	
	
	
	
	//** Início getters JButon **
	
	public JButton getjButtonProsseguir() {
		if(jButtonProsseguir == null) {
			jButtonProsseguir = new JButton();
			
			jButtonProsseguir.setFont(Fontes.fontJButtonVenda);
			jButtonProsseguir.setBackground(Cores.azul1);
			jButtonProsseguir.setForeground(Color.white);
			jButtonProsseguir.setText("Prosseguir compra");
			jButtonProsseguir.setSize(429, 45);
			jButtonProsseguir.setFocusable(false);
			jButtonProsseguir.setBorder(javax.swing.BorderFactory.
					createTitledBorder(new javax.swing.border.
							LineBorder(new java.awt.Color(112, 112, 112), 3, true),
							"Quantidade",
							border.TitledBorder.LEFT,
							border.TitledBorder.DEFAULT_POSITION,
							Font("Segoe UI", 1, 16),
							Color(42, 63, 106)));
	        
		}
		return jButtonProsseguir;
	}
	
	
	//** Fim getters JButon **
	
	
	
	//** Início getters JFields **
	
	public JTextField getjTFieldProdutoQuantidade() {
		return jTFieldProdutoQuantidade;
	}

	public JTextField getjTFieldProdutoVal() {
		return jTFieldProdutoVal;
	}

	public JTextField getjTFieldProdutoValTot() {
		return jTFieldProdutoValTot;
	}

	public JTextField getjTFieldInserirProdutoDesc() {
		return jTFieldInserirProdutoDesc;
	}

	public JTextField getjTFieldInserirProdutoQuant() {
		return jTFieldInserirProdutoQuant;
	}

	public JTextField getJTFieldTotal() {
		if(jTFieldUsuario == null) {
			jTFieldUsuario = new JTextField();
			jTFieldUsuario.setBorder(BorderFactory.createLineBorder(Cores.cinza2, 1));
			jTFieldUsuario.setBackground(Color.white);
			jTFieldUsuario.setForeground(Cores.preto);
			jTFieldUsuario.setFont(Fontes.fontLoginMax);
			jTFieldUsuario.setSize(270, 45);
			jTFieldUsuario.setOpaque(true);
			
		}
		return JTFieldTotal;
	}
	
	
	
	
	//** Fim getters JFields **
	
	
	
	//** Início getters JComboBox **
	
	public JComboBox<String> getjComboBoxDesc() {
		if(jCBoxLembrarSenha == null) {
			jCBoxLembrarSenha = new JCheckBox();
			jCBoxLembrarSenha.setForeground(Color.white);
			jCBoxLembrarSenha.setFont(Fontes.fontLoginMin);
			jCBoxLembrarSenha.setSize(271,21);
			jCBoxLembrarSenha.setOpaque(false);
			jCBoxLembrarSenha.setFocusable(false);
			jCBoxLembrarSenha.setText("Lembrar senha");
		}
		return jComboBoxDesc;
	}
	
	
	//** Fim getters JComboBox **
	
	//** Início getters conjuto JScrollPane/JTable **
	
	public JScrollPane getjSPInserirProduto() {
		return jSPInserirProduto;
	}

	public JScrollPane getjSPProdutosCompra() {
		return jSPProdutosCompra;
	}

	public JTable getjTableInserirProduto() {
		return jTableInserirProduto;
	}

	public JTable getjTableProdutosCompra() {
		return jTableProdutosCompra;
	}
	
	//** Fim getters conjuto JScrollPane/JTable **
	
	
	//** Início métodos adição de componentes **	

	public void addCompJPanelLogin() {
		
	
	}
	
	
	public void addCompJPanelCentralLogin() {
		
		
	}
	//** Fim métodos adição de componentes **
	


}
