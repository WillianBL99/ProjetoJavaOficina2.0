/**
 * 
 */
package view;

import java.awt.Choice;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import dao.ComandosSQL;
import dao.ModuloConexao;
import dao.PreencherTabela;
import model.Cores;
import model.Fontes;

/**
 * @author Paulo Uilian
 *
 */


@SuppressWarnings("serial")
public class JDialogInserirProduto extends JDialog{	
	
	
	//** Início declaração de variáveis **
	private ModuloConexao moduloConexao;
	private boolean modalTela;
	
	private JButton jButtonCancelar;
	private JButton jButtonInserirPeca;
	
	
	private JLabel jLabelDadosProduto;

	private JLabel jLabelPesquisarPor;
	private JLabel jLabelCodigo;
	private JLabel jLabelDescricao;
	private JLabel jLabelQuantidadeEstoque;
	private JLabel jLabelPreco;
	
	private JLabel jLabelDetalheInsercao;
		
	private JLabel jLabelQuantidadeInserir;
	private JLabel jLabelAtendidos;
	private JLabel jLabelComprar;
	private JLabel jLabelDesconto;
	private JLabel jLabelValorDesconto;
	private JLabel jLabelValorTotal;
	

	private JTextField jTFieldProcurar;
	private JTextField jTFieldCodigo;
	private JTextField jTFieldDescricao;
	private JTextField jTFieldQuantidadeEstoque;
	private JTextField jTFieldPreco;

	private JTextField jTFieldQuantidadeInserir;
	private JTextField jTFieldAtendidos;
	private JTextField jTFieldComprar;
	private JTextField jTFieldDesconto;
	private JTextField jTFieldValorDesconto;
	private JTextField jTFieldValorTotal;
	
	private JScrollPane jSPanePeca;
	
	private JTable jTablePecas;
	
	private Choice choicePesquisarPor;
	
	//** Fim declaração de variáveis **
	
	//** Início construtor **
	public JDialogInserirProduto(Frame frame, boolean modalTela) {
		super(frame, "Inserir produto");
		setmodalTela(modalTela);
		this.addCompJDialogInserirPeca();
	}	

	
	//** Fim construtor **
	
	//** Início getters JPanels **
	public JDialogInserirProduto  getJDialogInserirPeca() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setBackground(Cores.branco);
		this.setSize(977, 440);
		this.setVisible(true);
		setmodalTela(modalTela);
		return this;
	}
	
	//** Fim getters JPanel **
	
	//** Início getters JLabel **
	
	public JLabel getjLabelPesquisarPor() {
		if(jLabelPesquisarPor == null){
			jLabelPesquisarPor = new JLabel();
			jLabelPesquisarPor.setFont(Fontes.fontJLabelPlain1);
			jLabelPesquisarPor.setForeground(Cores.preto);
			jLabelPesquisarPor.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelPesquisarPor.setText("Pesquisar por:");
			jLabelPesquisarPor.setOpaque(false);
			jLabelPesquisarPor.setSize(100, 25);
		}
		return jLabelPesquisarPor;
	}
	
	public JLabel getjLabelDetalheInsercao() {
		if(jLabelDetalheInsercao == null){	
			jLabelDetalheInsercao = new JLabel("Destalhes da inserção");
			jLabelDetalheInsercao.setFont(Fontes.fontJLabelBold2);
			jLabelDetalheInsercao.setSize(300, 25);
			jLabelDetalheInsercao.setForeground(Cores.azul1);
			jLabelDetalheInsercao.setOpaque(false);
		}
		return jLabelDetalheInsercao;
	}


	public JLabel getjLabelQuantidadeInserir() {
		if(jLabelQuantidadeInserir == null){
			jLabelQuantidadeInserir = new JLabel("Qtd.Inserir:");
			jLabelQuantidadeInserir.setFont(Fontes.fontJLabelPlain1);
			jLabelQuantidadeInserir.setSize(82, 25);
			jLabelQuantidadeInserir.setForeground(Cores.preto);
			jLabelQuantidadeInserir.setOpaque(false);
			jLabelQuantidadeInserir.setVisible(true);
		}
		return jLabelQuantidadeInserir;
	}


	public JLabel getjLabelAtendidos() {
		if(jLabelAtendidos == null){
			jLabelAtendidos = new JLabel("Atendido:");
			jLabelAtendidos.setFont(Fontes.fontJLabelPlain1);
			jLabelAtendidos.setSize(69, 25);
			jLabelAtendidos.setForeground(Cores.preto);
			jLabelAtendidos.setOpaque(false);
			jLabelAtendidos.setVisible(true);
		}
		return jLabelAtendidos;
	}


	public JLabel getjLabelComprar() {
		if(jLabelComprar == null){
			jLabelComprar = new JLabel("A comprar:");
			jLabelComprar.setFont(Fontes.fontJLabelPlain1);
			jLabelComprar.setSize(77, 25);
			jLabelComprar.setForeground(Cores.preto);
			jLabelComprar.setOpaque(false);
			jLabelComprar.setVisible(true);
		}
		return jLabelComprar;
	}


	public JLabel getjLabelDesconto() {
		if(jLabelDesconto == null){
			jLabelDesconto = new JLabel("Desconto%:");
			jLabelDesconto.setFont(Fontes.fontJLabelPlain1);
			jLabelDesconto.setSize(84, 25);
			jLabelDesconto.setForeground(Cores.preto);
			jLabelDesconto.setOpaque(false);
			jLabelDesconto.setVisible(true);
		}
		return jLabelDesconto;
	}


	public JLabel getjLabelValorDesconto() {
		if(jLabelValorDesconto == null){
			jLabelValorDesconto = new JLabel("Val.Desconto:");
			jLabelValorDesconto.setFont(Fontes.fontJLabelPlain1);
			jLabelValorDesconto.setSize(97, 25);
			jLabelValorDesconto.setForeground(Cores.preto);
			jLabelValorDesconto.setOpaque(false);
			jLabelValorDesconto.setVisible(true);
		}
		return jLabelValorDesconto;
	}


	public JLabel getjLabelValorTotal() {
		if(jLabelValorTotal == null){
			jLabelValorTotal = new JLabel("Val.Total:");
			jLabelValorTotal.setFont(Fontes.fontJLabelPlain1);
			jLabelValorTotal.setSize(73, 25);
			jLabelValorTotal.setForeground(Cores.preto);
			jLabelValorTotal.setOpaque(false);
			jLabelValorTotal.setVisible(true);
		}
		return jLabelValorTotal;
	}


	public JLabel getjLabelDadosProduto() {
		if(jLabelDadosProduto == null){	
			jLabelDadosProduto = new JLabel("Dados do produto");
			jLabelDadosProduto.setFont(Fontes.fontJLabelBold2);
			jLabelDadosProduto.setSize(170, 25);
			jLabelDadosProduto.setForeground(Cores.azul1);
			jLabelDadosProduto.setOpaque(false);
		}
		return jLabelDadosProduto;
	}


	public JLabel getjLabelCodigo() {
		if(jLabelCodigo == null){	
			jLabelCodigo = new JLabel("Código:");
			jLabelCodigo.setFont(Fontes.fontJLabelPlain1);
			jLabelCodigo.setSize(55, 25);
			jLabelCodigo.setForeground(Cores.preto);
			jLabelCodigo.setOpaque(false);
			jLabelCodigo.setVisible(true);
		}
		return jLabelCodigo;
	}


	public JLabel getjLabelDescricao() {
		if(jLabelDescricao == null){	
			jLabelDescricao = new JLabel("Descrição:");
			jLabelDescricao.setFont(Fontes.fontJLabelPlain1);
			jLabelDescricao.setSize(72, 25);
			jLabelDescricao.setForeground(Cores.preto);
			jLabelDescricao.setOpaque(false);
			jLabelDescricao.setVisible(true);
		}
		return jLabelDescricao;
	}


	public JLabel getjLabelQuantidadeEstoque() {
		if(jLabelQuantidadeEstoque == null){	
			jLabelQuantidadeEstoque = new JLabel("Qtd.Estoque");
			jLabelQuantidadeEstoque.setFont(Fontes.fontJLabelPlain1);
			jLabelQuantidadeEstoque.setSize(103, 25);
			jLabelQuantidadeEstoque.setForeground(Cores.preto);
			jLabelQuantidadeEstoque.setOpaque(false);
			jLabelQuantidadeEstoque.setVisible(true);
		}
		return jLabelQuantidadeEstoque;
	}

	public JLabel getjLabelPreco() {
		if(jLabelPreco == null){	
			jLabelPreco = new JLabel("Preço:");
			jLabelPreco.setFont(Fontes.fontJLabelPlain1);
			jLabelPreco.setSize(43, 25);
			jLabelPreco.setForeground(Cores.preto);
			jLabelPreco.setOpaque(false);
			jLabelPreco.setVisible(true);
		}
		return jLabelPreco;
	}
	
	
	//** Fim getters JLabel **
	
	//** Início getters JButton **


	public JButton getjButtonCancelar() {
		if(jButtonCancelar == null){
			jButtonCancelar = new JButton();			
			jButtonCancelar.setFont(Fontes.fontJButtonPlain2);
			jButtonCancelar.setBackground(Cores.azul1);
			jButtonCancelar.setForeground(Cores.branco);
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setSize(82, 25);
			jButtonCancelar.setFocusable(false);
			jButtonCancelar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));	        
		}
		return jButtonCancelar;
	}


	public JButton getjButtonInserirPeca() {
		if(jButtonInserirPeca == null){
			jButtonInserirPeca = new JButton();			
			jButtonInserirPeca.setFont(Fontes.fontJButtonPlain2);
			jButtonInserirPeca.setBackground(Cores.azul1);
			jButtonInserirPeca.setForeground(Cores.branco);
			jButtonInserirPeca.setText("Inserir produto");
			jButtonInserirPeca.setSize(114, 25);
			jButtonInserirPeca.setFocusable(false);
			jButtonInserirPeca.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));	        
		}
		return jButtonInserirPeca;
	}
	
	
	
	//** Fim getters JButon **	
	
	//** Início getters JFields **
	
	public JTextField getjTFieldProcurar() {
		if(jTFieldProcurar == null){
			jTFieldProcurar = new JTextField();
			jTFieldProcurar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldProcurar.setForeground(Cores.azul1);
			jTFieldProcurar.setFont(Fontes.fontJTFieldPlain3);
			jTFieldProcurar.setSize(185, 25);
			jTFieldProcurar.setOpaque(true);			
		}
		return jTFieldProcurar;
	}

	public JTextField getjTFieldCodigo() {
		if(jTFieldCodigo == null){
			jTFieldCodigo = new JTextField();
			jTFieldCodigo.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldCodigo.setForeground(Cores.preto);
			jTFieldCodigo.setFont(Fontes.fontJTFieldPlain2);
			jTFieldCodigo.setSize(123, 25);
			jTFieldCodigo.setOpaque(true);	
			jTFieldCodigo.setVisible(true);		
		}
		return jTFieldCodigo;
	}


	public JTextField getjTFieldDescricao() {
		if(jTFieldDescricao == null){
			jTFieldDescricao = new JTextField();
			jTFieldDescricao.setBorder(null);
			jTFieldDescricao.setBackground(Cores.cinza4);
			jTFieldDescricao.setFont(Fontes.fontJTFieldPlain2);
			jTFieldDescricao.setSize(370, 25);
			jTFieldDescricao.setOpaque(true);	
			jTFieldDescricao.setVisible(true);	
			jTFieldDescricao.setEditable(false);	
		}
		return jTFieldDescricao;
	}


	public JTextField getjTFieldQuantidadeEstoque() {
		if(jTFieldQuantidadeEstoque == null){
			jTFieldQuantidadeEstoque = new JTextField();
			jTFieldQuantidadeEstoque.setBorder(null);
			jTFieldQuantidadeEstoque.setBackground(Cores.cinza4);
			jTFieldQuantidadeEstoque.setForeground(Cores.preto);
			jTFieldQuantidadeEstoque.setFont(Fontes.fontJTFieldPlain2);
			jTFieldQuantidadeEstoque.setSize(103, 25);
			jTFieldQuantidadeEstoque.setOpaque(true);	
			jTFieldQuantidadeEstoque.setVisible(true);	
			jTFieldQuantidadeEstoque.setEditable(false);	
		}
		return jTFieldQuantidadeEstoque;
	}


	public JTextField getjTFieldPreco() {
		if(jTFieldPreco == null){
			jTFieldPreco = new JTextField();
			jTFieldPreco.setBorder(null);
			jTFieldPreco.setBackground(Cores.cinza4);
			jTFieldPreco.setFont(Fontes.fontJTFieldPlain2);
			jTFieldPreco.setSize(142, 25);
			jTFieldPreco.setOpaque(true);	
			jTFieldPreco.setVisible(true);	
			jTFieldPreco.setEditable(false);	
		}
		return jTFieldPreco;
	}
	
	
	public JTextField getjTFieldQuantidadeInserir() {
		if(jTFieldQuantidadeInserir == null){
			jTFieldQuantidadeInserir = new JTextField();
			jTFieldQuantidadeInserir.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldQuantidadeInserir.setForeground(Cores.preto);
			jTFieldQuantidadeInserir.setBackground(Cores.cinza4);
			jTFieldQuantidadeInserir.setFont(Fontes.fontJTFieldPlain2);
			jTFieldQuantidadeInserir.setSize(70, 25);
			jTFieldQuantidadeInserir.setOpaque(true);	
			jTFieldQuantidadeInserir.setEnabled(false);	
		}
		return jTFieldQuantidadeInserir;
	}


	public JTextField getjTFieldAtendidos() {
		if(jTFieldAtendidos == null){
			jTFieldAtendidos = new JTextField();
			jTFieldAtendidos.setBorder(null);
			jTFieldAtendidos.setBackground(Cores.cinza4);
			jTFieldAtendidos.setFont(Fontes.fontJTFieldPlain2);
			jTFieldAtendidos.setSize(70, 25);
			jTFieldAtendidos.setOpaque(true);	
			jTFieldAtendidos.setVisible(true);	
			jTFieldAtendidos.setEditable(false);
		}
		return jTFieldAtendidos;
	}


	public JTextField getjTFieldComprar() {
		if(jTFieldComprar == null){
			jTFieldComprar = new JTextField();
			jTFieldComprar.setBorder(null);
			jTFieldComprar.setBackground(Cores.cinza4);
			jTFieldComprar.setFont(Fontes.fontJTFieldPlain2);
			jTFieldComprar.setSize(70, 25);
			jTFieldComprar.setOpaque(true);	
			jTFieldComprar.setVisible(true);
			jTFieldComprar.setEditable(false);	
		}
		return jTFieldComprar;
	}


	public JTextField getjTFieldDesconto() {
		if(jTFieldDesconto == null){
			jTFieldDesconto = new JTextField();
			jTFieldDesconto.setText("0");
			jTFieldDesconto.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldDesconto.setForeground(Cores.preto);
			jTFieldDesconto.setBackground(Cores.cinza4);
			jTFieldDesconto.setFont(Fontes.fontJTFieldPlain2);
			jTFieldDesconto.setSize(70, 25);
			jTFieldDesconto.setOpaque(true);	
			jTFieldDesconto.setVisible(true);		
			jTFieldDesconto.setEnabled(false);
		}
		return jTFieldDesconto;
	}


	public JTextField getjTFieldValorDesconto() {
		if(jTFieldValorDesconto == null){
			jTFieldValorDesconto = new JTextField();
			jTFieldValorDesconto.setBorder(null);
			jTFieldValorDesconto.setBackground(Cores.cinza4);
			jTFieldValorDesconto.setFont(Fontes.fontJTFieldPlain2);
			jTFieldValorDesconto.setSize(85, 25);
			jTFieldValorDesconto.setOpaque(true);	
			jTFieldValorDesconto.setVisible(true);
			jTFieldValorDesconto.setEditable(false);	
		}
		return jTFieldValorDesconto;
	}


	public JTextField getjTFieldValorTotal() {
		if(jTFieldValorTotal == null){
			jTFieldValorTotal = new JTextField();
			jTFieldValorTotal.setBorder(null);
			jTFieldValorTotal.setBackground(Cores.cinza4);
			jTFieldValorTotal.setFont(Fontes.fontJTFieldPlain2);
			jTFieldValorTotal.setSize(85, 25);
			jTFieldValorTotal.setOpaque(true);	
			jTFieldValorTotal.setVisible(true);		
			jTFieldValorTotal.setEditable(false);
		}
		return jTFieldValorTotal;
	}
	
	//** Fim getters JTextField **		
	
	//** Início getters conjuto JScrollPane/JTable **
	
		public JScrollPane getjSPanePeca() {
			if(jSPanePeca == null){
				jSPanePeca = new JScrollPane();
				jSPanePeca.setViewportView(getjTablePecas());
				jSPanePeca.setSize(913, 80);
			}
			return jSPanePeca;
		}


		public JTable getjTablePecas() {
			if(jTablePecas == null){
				jTablePecas = new JTable();
				getmoduloConexao().executeQuery(ComandosSQL.consultarProdutos());
				jTablePecas.setModel(new PreencherTabela().preencher(getmoduloConexao().getResultSet(), 
								 "Código",
								 "Descrição",
								 "Marca",
								 "Quantidade",
								 "Preço"));		
				jTablePecas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				jTablePecas.setRowHeight(21);
				jTablePecas.setFont(Fontes.fontJTablePlain1);
				jTablePecas.setOpaque(false);
				jTablePecas.getTableHeader().setFont(Fontes.fontJTableBold1);
				jTablePecas.getTableHeader().setForeground(Cores.branco);
				jTablePecas.getTableHeader().setBackground(Cores.azul1);
			}
			return jTablePecas;
		}
		
		
		public Choice getChoicePesquisarPor() {
			if(choicePesquisarPor == null){
				choicePesquisarPor = new Choice();
				choicePesquisarPor.setSize(175, 50);
				choicePesquisarPor.setFont(Fontes.fontJTFieldPlain1);
				choicePesquisarPor.setVisible(true);
				choicePesquisarPor.add("Código                  ");
				choicePesquisarPor.add("Descrição               ");
				choicePesquisarPor.add("Marca                   ");
				choicePesquisarPor.setFocusable(false);	
		
			}
			return choicePesquisarPor;
		}
		
		
		//** Fim getters conjuto JScrollPane/JTable **
	
	//** Início métodos adição de componentes **
	
	
	public void addCompJDialogInserirPeca() {

		
		getJDialogInserirPeca().getContentPane().add(getjLabelPesquisarPor());
		getjLabelPesquisarPor().setLocation(36, 15);
		
		getJDialogInserirPeca().getContentPane().add(getChoicePesquisarPor());
		getChoicePesquisarPor().setLocation(141, 15);

		getJDialogInserirPeca().getContentPane().add(getjTFieldProcurar());
		getjTFieldProcurar().setLocation(305, 15);

		getJDialogInserirPeca().getContentPane().add(getjSPanePeca());
		getjSPanePeca().setLocation(36, 55);
		
		
		
		getJDialogInserirPeca().getContentPane().add(getjLabelDadosProduto());
		getjLabelDadosProduto().setLocation(36, 150);

		
		getJDialogInserirPeca().getContentPane().add(getjLabelDescricao());
		getjLabelDescricao().setLocation(274, 194);
		
		getJDialogInserirPeca().getContentPane().add(getjTFieldDescricao());
		getjTFieldDescricao().setLocation(351, 194);
		
		
		getJDialogInserirPeca().getContentPane().add(getjLabelQuantidadeEstoque());
		getjLabelQuantidadeEstoque().setLocation(743, 194);
		
		getJDialogInserirPeca().getContentPane().add(getjTFieldQuantidadeEstoque());
		getjTFieldQuantidadeEstoque().setLocation(846, 194);
		
		
		getJDialogInserirPeca().getContentPane().add(getjLabelPreco());
		getjLabelPreco().setLocation(36, 194);
		
		getJDialogInserirPeca().getContentPane().add(getjTFieldPreco());
		getjTFieldPreco().setLocation(95, 194);

		
		getJDialogInserirPeca().getContentPane().add(getjLabelDetalheInsercao());
		getjLabelDetalheInsercao().setLocation(36, 233);
		
		
		getJDialogInserirPeca().getContentPane().add(getjLabelQuantidadeInserir());
		getjLabelQuantidadeInserir().setLocation(36, 275);
		
		getJDialogInserirPeca().getContentPane().add(getjTFieldQuantidadeInserir());
		getjTFieldQuantidadeInserir().setLocation(123, 275);
		
		
		getJDialogInserirPeca().getContentPane().add(getjLabelAtendidos());
		getjLabelAtendidos().setLocation(213, 275);
		
		getJDialogInserirPeca().getContentPane().add(getjTFieldAtendidos());
		getjTFieldAtendidos().setLocation(287, 275);
		
		
		getJDialogInserirPeca().getContentPane().add(getjLabelComprar());
		getjLabelComprar().setLocation(377, 275);
		
		getJDialogInserirPeca().getContentPane().add(getjTFieldComprar());
		getjTFieldComprar().setLocation(459, 275);
		
		
		getJDialogInserirPeca().getContentPane().add(getjLabelDesconto());
		getjLabelDesconto().setLocation(549, 275);
		
		getJDialogInserirPeca().getContentPane().add(getjTFieldDesconto());
		getjTFieldDesconto().setLocation(638, 275);

		
		getJDialogInserirPeca().getContentPane().add(getjLabelValorDesconto());
		getjLabelValorDesconto().setLocation(36, 326);
		
		getJDialogInserirPeca().getContentPane().add(getjTFieldValorDesconto());
		getjTFieldValorDesconto().setLocation(138, 326);
		

		getJDialogInserirPeca().getContentPane().add(getjLabelValorTotal());
		getjLabelValorTotal().setLocation(243, 326);
		
		getJDialogInserirPeca().getContentPane().add(getjTFieldValorTotal());
		getjTFieldValorTotal().setLocation(321, 326);
		
		
		getJDialogInserirPeca().getContentPane().add(getjButtonCancelar());
		getjButtonCancelar().setLocation(736, 365);
		
		getJDialogInserirPeca().getContentPane().add(getjButtonInserirPeca());
		getjButtonInserirPeca().setLocation(835, 365);
		
	}
		
	//** Fim métodos adição de componentes **
	
	private ModuloConexao getmoduloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}
		return moduloConexao;
	}
	
	public boolean ismodalTela() {
		return modalTela;
	}
	
	
	public void setmodalTela(boolean modalTela) {
		this.modalTela = modalTela;
	}
	

}