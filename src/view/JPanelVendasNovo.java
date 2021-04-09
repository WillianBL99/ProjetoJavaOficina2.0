package view;

import java.awt.Choice;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import model.Cores;
import model.Fontes;

@SuppressWarnings("serial")
public class JPanelVendasNovo extends JPanel {

	
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
	
	private Choice choiceBoxDesc;
	
	private JScrollPane jSPInserirProduto;
	private JScrollPane jSPProdutosCompra;
	
	private JTable jTableInserirProduto;
	private JTable jTableProdutosCompra;

	private JLabel jLabelProdutoDescricao;
	private JLabel jLabelQuantidade;
	private JLabel jLabelX;
	
	private JButton jButtonProsseguir;
	private JButton jButtonCancelar;
	private JButton jButtonInserir;
	
		
	//** Fim declaração de variáveis **
	
	//** Início construtor **
	
	public JPanelVendasNovo() {
		this.addCompJPanelProdutoCompra();
		this.addCompJPanelInserirProduto();
		this.addCompJPanelProduto();
		this.addCompJPanelCentralVendas();
		this.addCompJPanelVendas();
	}
	
	//** Fim construtor **
	
	//** Início getters JPanels **
	
	public JPanelVendasNovo getJPanelVendasNovo() { // OK
		this.setLayout(null);
		this.setBackground(Cores.cinza3);
		this.setSize(1280, 720);
		this.setVisible(true);
		return this;
	}
	
	public JPanel getjPanelBarraSup() { // OK
		if(jPanelBarraSup == null) {
			jPanelBarraSup = new JPanel();
			jPanelBarraSup.setLayout(null);
			jPanelBarraSup.setBackground(Cores.azul1);
			jPanelBarraSup.setSize(1280, 46);
			jPanelBarraSup.setBorder(null);
		}
		return jPanelBarraSup;
	}

	public JPanel getjPanelCentroVendas() { // OK
		if(jPanelCentroVendas == null) {
			jPanelCentroVendas = new JPanel();
			jPanelCentroVendas.setLayout(null);
			jPanelCentroVendas.setBackground(Cores.branco);
			jPanelCentroVendas.setSize(1240,567);
			jPanelCentroVendas.setBorder(null);
		}
		return jPanelCentroVendas;
	}

	public JPanel getjPanelProduto() { // OK
		if(jPanelProduto == null) {
			jPanelProduto = new JPanel();
			jPanelProduto.setLayout(null);
			jPanelProduto.setOpaque(false);
			jPanelProduto.setSize(727, 172);
			jPanelProduto.setBorder(BorderFactory.
					createTitledBorder(new javax.swing.border.
							LineBorder(Cores.cinza2, 3, true),
							"Produto",
							javax.swing.border.TitledBorder.LEFT,
							javax.swing.border.TitledBorder.DEFAULT_POSITION,
							Fontes.fontBorda2,
							Cores.azul1)
					);
			jPanelProduto.setVisible(true);
		}
		return jPanelProduto;
	}

	public JPanel getjPanelInserirProduto() { // OK
		if(jPanelInserirProduto == null) {
			jPanelInserirProduto = new JPanel();
			jPanelInserirProduto.setLayout(null);
			jPanelInserirProduto.setOpaque(false);
			jPanelInserirProduto.setSize(617, 332);
			jPanelInserirProduto.setBorder(BorderFactory.
					createTitledBorder(new javax.swing.border.
							LineBorder(Cores.cinza2, 3, true),
							"Iserir Produto",
							javax.swing.border.TitledBorder.LEFT,
							javax.swing.border.TitledBorder.DEFAULT_POSITION,
							Fontes.fontBorda2,
							Cores.azul1)
					);
			jPanelInserirProduto.setVisible(true);
		}
		return jPanelInserirProduto;
	}

	public JPanel getjPanelProdutoCompra() {  // OK
		if(jPanelProdutoCompra == null) {
			jPanelProdutoCompra = new JPanel();
			jPanelProdutoCompra.setLayout(null);
			jPanelProdutoCompra.setOpaque(false);
			jPanelProdutoCompra.setSize(429, 312);
			jPanelProdutoCompra.setBorder(BorderFactory.
					createTitledBorder(new javax.swing.border.
							LineBorder(Cores.cinza2, 3, true),
							"Produtos da compra",
							javax.swing.border.TitledBorder.LEFT,
							javax.swing.border.TitledBorder.DEFAULT_POSITION,
							Fontes.fontBorda2,
							Cores.azul1)
					);

			jPanelProdutoCompra.setVisible(true);
		}
		return jPanelProdutoCompra;
	}
	
	
	//** Fim getters JPanel **
	
	
	
	//** Início getters JLabel **
		
	public JLabel getjLabelQuantidade() { // OK
		if(jLabelQuantidade == null) {
			jLabelQuantidade = new JLabel();
			jLabelQuantidade.setFont(Fontes.fontJLabelBold1);
			jLabelQuantidade.setForeground(Cores.preto);
			jLabelQuantidade.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelQuantidade.setText("Quantidade");
			jLabelQuantidade.setOpaque(false);
			jLabelQuantidade.setSize(90,21);
		}
		return jLabelQuantidade;
	}

	
	public JLabel getjLabelProdutoDescricao() { // OK
		if(jLabelProdutoDescricao == null) {
			jLabelProdutoDescricao = new JLabel();
			jLabelProdutoDescricao.setFont(Fontes.fontJLabelBold3);
			jLabelProdutoDescricao.setForeground(Cores.preto);
			jLabelProdutoDescricao.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelProdutoDescricao.setText("Algum produto");
			jLabelProdutoDescricao.setOpaque(false);
			jLabelProdutoDescricao.setSize(700, 33);
		}
		return jLabelProdutoDescricao;
	}

	
	public JLabel getjLabelX() { // OK
		if(jLabelX == null) {
			jLabelX = new JLabel();
			jLabelX.setFont(Fontes.fontJLabelBold3);
			jLabelX.setForeground(Cores.azul1);
			jLabelX.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelX.setText("X");
			jLabelX.setOpaque(false);
			jLabelX.setSize(18, 33);
		}
		return jLabelX;
	}
	//** Fim getters JLabel **
	
	
	
	
	//** Início getters JButon **
	
	public JButton getjButtonProsseguir() { // OK
		if(jButtonProsseguir == null) {
			jButtonProsseguir = new JButton();			
			jButtonProsseguir.setFont(Fontes.fontJButtonBold3);
			jButtonProsseguir.setBackground(Cores.azul1);
			jButtonProsseguir.setForeground(Color.white);
			jButtonProsseguir.setText("Prosseguir compra");
			jButtonProsseguir.setSize(429, 45);
			jButtonProsseguir.setFocusable(false);
			jButtonProsseguir.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
	        
		}
		return jButtonProsseguir;
	}
	
	
	public JButton getjButtonCancelar() { // OK 
		if(jButtonCancelar == null) {
			jButtonCancelar = new JButton();			
			jButtonCancelar.setFont(Fontes.fontJButtonPlain3);
			jButtonCancelar.setBackground(Cores.azul1);
			jButtonCancelar.setForeground(Color.white);
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setSize(110, 35);
			jButtonCancelar.setFocusable(false);
			jButtonCancelar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
	        
		}
		return jButtonCancelar;
	}
	
	
	public JButton getjButtonInserir() { // OK 
		if(jButtonInserir == null) {
			jButtonInserir = new JButton();			
			jButtonInserir.setFont(Fontes.fontJButtonPlain3);
			jButtonInserir.setBackground(Cores.azul1);
			jButtonInserir.setForeground(Color.white);
			jButtonInserir.setText("Inserir");
			jButtonInserir.setSize(100, 35);
			jButtonInserir.setFocusable(false);
			jButtonInserir.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
	        
		}
		return jButtonInserir;
	}
	
	//** Fim getters JButon **
	
	
	
	//** Início getters JFields **
	
	public JTextField getjTFieldProdutoQuantidade() { // OK
		if(jTFieldProdutoQuantidade == null) {
			jTFieldProdutoQuantidade = new JTextField();
			jTFieldProdutoQuantidade.setBorder(BorderFactory.
					createTitledBorder(new javax.swing.border.
							LineBorder(Cores.cinza2, 3, true),
							"Quantidade",
							javax.swing.border.TitledBorder.LEFT,
							javax.swing.border.TitledBorder.DEFAULT_POSITION,
							Fontes.fontBorda1,
							Cores.azul1)
					);
			jTFieldProdutoQuantidade.setForeground(Cores.azul1);
			jTFieldProdutoQuantidade.setFont(Fontes.fontJTFieldBold2);
			jTFieldProdutoQuantidade.setSize(202, 83);
			jTFieldProdutoQuantidade.setOpaque(false);
			
		}
		return jTFieldProdutoQuantidade;
	}

	public JTextField getjTFieldProdutoVal() { // OK
		if(jTFieldProdutoVal == null) {
			jTFieldProdutoVal = new JTextField();
			jTFieldProdutoVal.setBorder(BorderFactory.
					createTitledBorder(new javax.swing.border.
							LineBorder(Cores.cinza2, 3, true),
							"Valor unitário",
							javax.swing.border.TitledBorder.LEFT,
							javax.swing.border.TitledBorder.DEFAULT_POSITION,
							Fontes.fontBorda1,
							Cores.azul1)
					);
			jTFieldProdutoVal.setForeground(Cores.azul1);
			jTFieldProdutoVal.setFont(Fontes.fontJTFieldBold2);
			jTFieldProdutoVal.setSize(202, 83);
			jTFieldProdutoVal.setOpaque(false);
			
		}
		return jTFieldProdutoVal;
	}

	public JTextField getjTFieldProdutoValTot() { // OK
		if(jTFieldProdutoValTot == null) {
			jTFieldProdutoValTot = new JTextField();
			jTFieldProdutoValTot.setBorder(BorderFactory.
					createTitledBorder(new javax.swing.border.
							LineBorder(Cores.cinza2, 3, true),
							"Valor total",
							javax.swing.border.TitledBorder.LEFT,
							javax.swing.border.TitledBorder.DEFAULT_POSITION,
							Fontes.fontBorda1,
							Cores.azul1)
					);
			jTFieldProdutoValTot.setForeground(Cores.azul1);
			jTFieldProdutoValTot.setFont(Fontes.fontJTFieldBold2);
			jTFieldProdutoValTot.setSize(202, 83);
			jTFieldProdutoValTot.setOpaque(false);
			
		}
		return jTFieldProdutoValTot;
	}

	public JTextField getjTFieldInserirProdutoDesc() { // OK
		if(jTFieldInserirProdutoDesc == null) {
			jTFieldInserirProdutoDesc = new JTextField();
			jTFieldInserirProdutoDesc.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 3, false));
			jTFieldInserirProdutoDesc.setForeground(Cores.azul1);
			jTFieldInserirProdutoDesc.setFont(Fontes.fontJTFieldPlain3);
			jTFieldInserirProdutoDesc.setSize(377, 30);
			jTFieldInserirProdutoDesc.setOpaque(true);
			
		}
		return jTFieldInserirProdutoDesc;
	}

	public JTextField getjTFieldInserirProdutoQuant() { // OK
		if(jTFieldInserirProdutoQuant == null) {
			jTFieldInserirProdutoQuant = new JTextField();
			jTFieldInserirProdutoQuant.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 3, false));
			jTFieldInserirProdutoQuant.setForeground(Cores.azul1);
			jTFieldInserirProdutoQuant.setFont(Fontes.fontJTFieldPlain3);
			jTFieldInserirProdutoQuant.setSize(140, 30);
			jTFieldInserirProdutoQuant.setOpaque(false);
			
		}
		return jTFieldInserirProdutoQuant;
	}

	
	public JTextField getJTFieldTotal() { // OK
		if(JTFieldTotal == null) {
			JTFieldTotal = new JTextField();
			JTFieldTotal.setBorder(BorderFactory.
					createTitledBorder(new javax.swing.border.
							LineBorder(Cores.cinza2, 2, true),
							"Total",
							javax.swing.border.TitledBorder.LEFT,
							javax.swing.border.TitledBorder.DEFAULT_POSITION,
							Fontes.fontBorda3,
							Cores.preto)
					);
			JTFieldTotal.setForeground(Cores.azul1);
			JTFieldTotal.setFont(Fontes.fontJTFieldBold3);
			JTFieldTotal.setSize(428, 77);
			jTFieldProdutoValTot.setOpaque(false);
			
		}
		return JTFieldTotal;
	}
	
	
	
	
	//** Fim getters JFields **
	
	
	
	//** Início getters JComboBox **
	
	public Choice getchoiceBoxDesc() {
		if(choiceBoxDesc == null){
			choiceBoxDesc = new Choice();
			choiceBoxDesc.setSize(170, 23);
			choiceBoxDesc.setFont(Fontes.fontJTFieldPlain1);
			choiceBoxDesc.setVisible(true);
			choiceBoxDesc.add("Descrição produto");
			choiceBoxDesc.add("Codigo produto");
			choiceBoxDesc.setFocusable(false);	
		}
		return choiceBoxDesc;
	}
	
	
	//** Fim getters JComboBox **
	
	//** Início getters conjuto JScrollPane/JTable **
	
	public JScrollPane getjSPInserirProduto() { // OK
		if(jSPInserirProduto == null) {
			jSPInserirProduto = new JScrollPane();
			jSPInserirProduto.setViewportView(getjTableInserirProduto());
			jSPInserirProduto.setSize(562, 150);
		}
		return jSPInserirProduto;
	}

	
	public JScrollPane getjSPProdutosCompra() { // OK
		if(jSPProdutosCompra == null) {
			jSPProdutosCompra = new JScrollPane();
			jSPProdutosCompra.setViewportView(getjTableProdutosCompra());
			jSPProdutosCompra.setSize(399, 150);
		}
		return jSPProdutosCompra;
	}

	
	public JTable getjTableInserirProduto() { // OK
		if(jTableInserirProduto == null) {
			jTableInserirProduto = new JTable();
			jTableInserirProduto.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		                {null, null, null, null},
		                {null, null, null, null},
		                {null, null, null, null},
		                {null, null, null, null}
		            },
		            new String [] {
		                "Cod. Produto", "Cod. Estoque", "Descrição", "Preço"
		            }
		        ));			

			jTableInserirProduto.setFont(Fontes.fontJTablePlain1);
			jTableInserirProduto.setOpaque(false);
			jTableInserirProduto.getTableHeader().setFont(Fontes.fontJTableBold1);
			jTableInserirProduto.getTableHeader().setForeground(Cores.branco);
			jTableInserirProduto.getTableHeader().setBackground(Cores.azul1);
		 }
		return jTableInserirProduto;
	}

	
	public JTable getjTableProdutosCompra() { // OK
		if(jTableProdutosCompra == null) {
			jTableProdutosCompra = new JTable();
			jTableProdutosCompra.setModel(new javax.swing.table.DefaultTableModel(
					
		            new Object [][] {
		                {null, null, null, null},
		                {null, null, null, null},
		                {null, null, null, null},
		                {null, null, null, null}
		            },
		            
		            new String [] {
		                "Item", "Qtd.", "Descrição", "Preço"
		            }
		        ));
			
			jTableProdutosCompra.setFont(Fontes.fontJTablePlain1);
			jTableProdutosCompra.setOpaque(false);
			jTableProdutosCompra.getTableHeader().setFont(Fontes.fontJTableBold1);
			jTableProdutosCompra.getTableHeader().setForeground(Cores.branco);
			jTableProdutosCompra.getTableHeader().setBackground(Cores.azul1);
		 }
		return jTableProdutosCompra;
	}
	
	//** Fim getters conjuto JScrollPane/JTable **
	
	
	//** Início métodos adição de componentes **	

	public void addCompJPanelVendas() { // OK
		
		this.getJPanelVendasNovo().add(this.getjPanelBarraSup());
		this.getjPanelBarraSup().setLocation(0, 0);		
		
		this.getJPanelVendasNovo().add(this.getjButtonCancelar());
		this.getjButtonCancelar().setLocation(14, 65);		
		
		this.getJPanelVendasNovo().add(this.getjPanelCentroVendas());
		this.getjPanelCentroVendas().setLocation(11, 122);
		
	
	}
	
	
	public void addCompJPanelCentralVendas() { // OK
		
		this.getjPanelCentroVendas().add(this.getjPanelProduto());
		this.getjPanelProduto().setLocation(22, 11);
		
		this.getjPanelCentroVendas().add(this.getjPanelInserirProduto());
		this.getjPanelInserirProduto().setLocation(22, 203);
		
		this.getjPanelCentroVendas().add(this.getjPanelProdutoCompra());
		this.getjPanelProdutoCompra().setLocation(787, 11);
		
		this.getjPanelCentroVendas().add(this.getJTFieldTotal());
		this.getJTFieldTotal().setLocation(787, 338);
		
		this.getjPanelCentroVendas().add(this.getjButtonProsseguir());
		this.getjButtonProsseguir().setLocation(787, 460);
		
		
	}
	
	 
	public void addCompJPanelProduto() { // OK
		
		this.getjPanelProduto().add(this.getjLabelProdutoDescricao());
		this.getjLabelProdutoDescricao().setLocation(21, 25);
		
		this.getjPanelProduto().add(this.getjTFieldProdutoQuantidade());
		this.getjTFieldProdutoQuantidade().setLocation(21, 57);
		
		this.getjPanelProduto().add(this.getjTFieldProdutoVal());
		this.getjTFieldProdutoVal().setLocation(243, 57);
		
		this.getjPanelProduto().add(this.getjTFieldProdutoValTot());
		this.getjTFieldProdutoValTot().setLocation(465, 57);
				
	}
	
	
	public void addCompJPanelInserirProduto() { // OK
		
		this.getjPanelInserirProduto().add(this.getchoiceBoxDesc());
		this.getchoiceBoxDesc().setLocation(15, 42);

		
		this.getjPanelInserirProduto().add(this.getjLabelQuantidade());
		this.getjLabelQuantidade().setLocation(438, 42);

		
		this.getjPanelInserirProduto().add(this.getjTFieldInserirProdutoDesc());
		this.getjTFieldInserirProdutoDesc().setLocation(12, 68);

		
		this.getjPanelInserirProduto().add(this.getjTFieldInserirProdutoQuant());
		this.getjTFieldInserirProdutoQuant().setLocation(435, 68);

		
		this.getjPanelInserirProduto().add(this.getjLabelX());
		this.getjLabelX().setLocation(403, 68);

		
		this.getjPanelInserirProduto().add(this.getjSPInserirProduto());
		this.getjSPInserirProduto().setLocation(12, 118);

		
		this.getjPanelInserirProduto().add(this.getjButtonInserir());
		this.getjButtonInserir().setLocation(471, 270);
				
	}
	
	
	public void addCompJPanelProdutoCompra() { // OK
		
		this.getjPanelProdutoCompra().add(this.getjSPProdutosCompra());
		this.getjSPProdutosCompra().setLocation(15, 30);
				
	}
	//** Fim métodos adição de componentes **
	


}
