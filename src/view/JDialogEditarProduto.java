/**
 * 
 */
package view;

import java.awt.ComponentOrientation;
import java.awt.Frame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import icons.Icones;
import model.Cores;
import model.Fontes;
import model.SetSizeIcon;

/**
 * @author Paulo Uilian
 *
 */


@SuppressWarnings("serial")
public class JDialogEditarProduto extends JDialog{	
	
	
	//** Início declaração de variáveis **
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	private boolean modalTela;
	
	private JButton jButtonProcurarCodigo;
	private JButton jButtonCancelar;
	private JButton jButtonEditarProduto;
		
	private JLabel jLabelDadosDoProduto;
	
	private JLabel jLabelCodigo;
	private JLabel jLabelDescricao;
	private JLabel jLabelMarca;
	private JLabel jLabelQuantidadeEstoque;
	private JLabel jLabelPreco;
	
	private JLabel jLabelNovosVaores;
		
	private JLabel jLabelNovaQuantidade;
	private JLabel jLabelNovoValor;	
	
	private JTextField jTFieldCodigo;
	private JTextField jTFieldDescricao;
	private JTextField jTFieldMarca;
	private JTextField jTFieldQuantidadeEstoque;
	private JTextField jTFieldPreco;

	private JTextField jTFieldNovaQuantidade;
	private JTextField jTFieldNovoValor;
	
	//** Fim declaração de variáveis **
	
	//** Início construtor **
	public JDialogEditarProduto(Frame frame, boolean modalTela) {
		super(frame, "Editar produto");
		setmodalTela(modalTela);
		this.addCompJDialogEditarProduto();
	}	

	
	//** Fim construtor **
	
	//** Início getters JPanels **
	public JDialogEditarProduto  getJDialogEditarProduto() {

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		this.getContentPane().setBackground(Cores.cinza5);
		this.setLocationRelativeTo(null);
		this.setSize(1005, 345);
		this.setVisible(true);
		return this;
	}
	
	//** Fim getters JPanel **
	
	//** Início getters JLabel **
	
	public JLabel getjLabelDadosDoProduto() {
		if(jLabelDadosDoProduto == null){	
			jLabelDadosDoProduto = new JLabel("Dados do produto");
			jLabelDadosDoProduto.setFont(Fontes.fontJLabelBold2);
			jLabelDadosDoProduto.setSize(213, 25);
			jLabelDadosDoProduto.setForeground(Cores.azul1);
			jLabelDadosDoProduto.setOpaque(false);
		}
		return jLabelDadosDoProduto;
	}


	public JLabel getjLabelNovaQuantidade() {
		if(jLabelNovaQuantidade == null){
			jLabelNovaQuantidade = new JLabel("Nova qtd.:");
			jLabelNovaQuantidade.setFont(Fontes.fontJLabelPlain1);
			jLabelNovaQuantidade.setSize(82, 25);
			jLabelNovaQuantidade.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelNovaQuantidade.setForeground(Cores.preto);
			jLabelNovaQuantidade.setOpaque(false);
			jLabelNovaQuantidade.setVisible(true);
		}
		return jLabelNovaQuantidade;
	}


	public JLabel getjLabelNovoValor() {
		if(jLabelNovoValor == null){
			jLabelNovoValor = new JLabel("Novo valor:");
			jLabelNovoValor.setFont(Fontes.fontJLabelPlain1);
			jLabelNovoValor.setSize(100, 25);
			jLabelNovoValor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelNovoValor.setForeground(Cores.preto);
			jLabelNovoValor.setOpaque(false);
			jLabelNovoValor.setVisible(true);
		}
		return jLabelNovoValor;
	}


	public JLabel getjLabelNovosValores() {
		if(jLabelNovosVaores == null){	
			jLabelNovosVaores = new JLabel("Novos valores");
			jLabelNovosVaores.setFont(Fontes.fontJLabelBold2);
			jLabelNovosVaores.setSize(180, 25);
			jLabelNovosVaores.setForeground(Cores.azul1);
			jLabelNovosVaores.setOpaque(false);
		}
		return jLabelNovosVaores;
	}


	public JLabel getjLabelCodigo() {
		if(jLabelCodigo == null){	
			jLabelCodigo = new JLabel("Código:");
			jLabelCodigo.setFont(Fontes.fontJLabelPlain1);
			jLabelCodigo.setSize(100, 25);
			jLabelCodigo.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
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
			jLabelDescricao.setSize(100, 25);
			jLabelDescricao.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelDescricao.setForeground(Cores.preto);
			jLabelDescricao.setOpaque(false);
			jLabelDescricao.setVisible(true);
		}
		return jLabelDescricao;
	}


	public JLabel getjLabelMarca() {
		if(jLabelMarca == null){	
			jLabelMarca = new JLabel("Marca:");
			jLabelMarca.setFont(Fontes.fontJLabelPlain1);
			jLabelMarca.setSize(100, 25);
			jLabelMarca.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelMarca.setForeground(Cores.preto);
			jLabelMarca.setOpaque(false);
			jLabelMarca.setVisible(true);
		}
		return jLabelMarca;
	}


	public JLabel getjLabelQuantidadeEstoque() {
		if(jLabelQuantidadeEstoque == null){	
			jLabelQuantidadeEstoque = new JLabel("Qtd.Estoque:");
			jLabelQuantidadeEstoque.setFont(Fontes.fontJLabelPlain1);
			jLabelQuantidadeEstoque.setSize(100, 25);
			jLabelQuantidadeEstoque.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
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
			jLabelPreco.setSize(100, 25);
			jLabelPreco.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelPreco.setForeground(Cores.preto);
			jLabelPreco.setOpaque(false);
			jLabelPreco.setVisible(true);
		}
		return jLabelPreco;
	}
	
	
	//** Fim getters JLabel **
	
	//** Início getters JButton **


	public JButton getjButtonProcurarCodigo() {
		if(jButtonProcurarCodigo == null){		
			jButtonProcurarCodigo = new JButton();			
			jButtonProcurarCodigo.setBackground(Cores.azul1);
			jButtonProcurarCodigo.setForeground(Cores.branco);
			setSizeIcon.setIconJButton(jButtonProcurarCodigo,
					Icones.getBuscar(), 16, 16);
			jButtonProcurarCodigo.setSize(30, 21);
			jButtonProcurarCodigo.setFocusable(false);
			jButtonProcurarCodigo.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
			jButtonProcurarCodigo.setVisible(true);	
		}
		return jButtonProcurarCodigo;
	}


	public JButton getjButtonCancelar() {
		if(jButtonCancelar == null){
			jButtonCancelar = new JButton();			
			jButtonCancelar.setFont(Fontes.fontJButtonPlain2);
			jButtonCancelar.setBackground(Cores.azul1);
			jButtonCancelar.setForeground(Cores.branco);
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setSize(86, 25);
			jButtonCancelar.setFocusable(false);
			jButtonCancelar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));	        
		}
		return jButtonCancelar;
	}


	public JButton getjButtonEditarProduto() {
		if(jButtonEditarProduto == null){
			jButtonEditarProduto = new JButton();			
			jButtonEditarProduto.setFont(Fontes.fontJButtonPlain2);
			jButtonEditarProduto.setBackground(Cores.azul1);
			jButtonEditarProduto.setForeground(Cores.branco);
			jButtonEditarProduto.setText("Editar produto");
			jButtonEditarProduto.setSize(114, 25);
			jButtonEditarProduto.setFocusable(false);
			jButtonEditarProduto.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));	        
		}
		return jButtonEditarProduto;
	}
	
	
	
	//** Fim getters JButon **	
	
	//** Início getters JFields **

	public JTextField getjTFieldCodigo() {
		if(jTFieldCodigo == null){
			jTFieldCodigo = new JTextField();
			jTFieldCodigo.setSize(340, 21);
			jTFieldCodigo.setFont(Fontes.fontJTFieldPlain2);
			jTFieldCodigo.setForeground(Cores.preto);
			jTFieldCodigo.setBackground(Cores.branco);
			jTFieldCodigo.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldCodigo.setOpaque(true);	
			jTFieldCodigo.setVisible(true);		
		}
		return jTFieldCodigo;
	}


	public JTextField getjTFieldDescricao() {
		if(jTFieldDescricao == null){
			jTFieldDescricao = new JTextField();
			jTFieldDescricao.setBackground(Cores.branco);
			jTFieldDescricao.setFont(Fontes.fontJTFieldPlain2);
			jTFieldDescricao.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldDescricao.setSize(370, 21);
			jTFieldDescricao.setOpaque(true);	
			jTFieldDescricao.setVisible(true);		
		}
		return jTFieldDescricao;
	}


	public JTextField getjTFieldMarca() {
		if(jTFieldMarca == null){
			jTFieldMarca = new JTextField();
			jTFieldMarca.setSize(198, 21);
			jTFieldMarca.setFont(Fontes.fontJTFieldPlain2);
			jTFieldMarca.setBackground(Cores.branco);
			jTFieldMarca.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldMarca.setOpaque(true);	
			jTFieldMarca.setVisible(true);		
		}
		return jTFieldMarca;
	}


	public JTextField getjTFieldQuantidadeEstoque() {
		if(jTFieldQuantidadeEstoque == null){
			jTFieldQuantidadeEstoque = new JTextField();
			jTFieldQuantidadeEstoque.setSize(198, 21);
			jTFieldQuantidadeEstoque.setFont(Fontes.fontJTFieldPlain2);
			jTFieldQuantidadeEstoque.setForeground(Cores.preto);
			jTFieldQuantidadeEstoque.setBackground(Cores.cinza4);
			jTFieldQuantidadeEstoque.setBorder(null);
			jTFieldQuantidadeEstoque.setOpaque(true);	
			jTFieldQuantidadeEstoque.setEnabled(false);
			jTFieldQuantidadeEstoque.setVisible(true);		
		}
		return jTFieldQuantidadeEstoque;
	}


	public JTextField getjTFieldPreco() {
		if(jTFieldPreco == null){
			jTFieldPreco = new JTextField();
			jTFieldPreco.setSize(198, 21);
			jTFieldPreco.setBorder(null);
			jTFieldPreco.setFont(Fontes.fontJTFieldPlain2);
			jTFieldPreco.setBackground(Cores.cinza4);
			jTFieldPreco.setBorder(null);
			jTFieldPreco.setOpaque(true);	
			jTFieldPreco.setEnabled(false);
			jTFieldPreco.setVisible(true);		
		}
		return jTFieldPreco;
	}
	
	
	public JTextField getjTFieldNovaQuantidade() {
		if(jTFieldNovaQuantidade == null){
			jTFieldNovaQuantidade = new JTextField();
			jTFieldNovaQuantidade.setSize(200, 21);
			jTFieldNovaQuantidade.setFont(Fontes.fontJTFieldPlain2);
			jTFieldNovaQuantidade.setForeground(Cores.preto);
			jTFieldNovaQuantidade.setBackground(Cores.branco);
			jTFieldNovaQuantidade.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldNovaQuantidade.setOpaque(true);	
			jTFieldNovaQuantidade.setVisible(true);		
		}
		return jTFieldNovaQuantidade;
	}


	public JTextField getjTFieldNovoValor() {
		if(jTFieldNovoValor == null){
			jTFieldNovoValor = new JTextField();
			jTFieldNovoValor.setSize(200, 21);
			jTFieldNovoValor.setFont(Fontes.fontJTFieldPlain2);
			jTFieldNovoValor.setBackground(Cores.branco);
			jTFieldNovoValor.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldNovoValor.setOpaque(true);	
			jTFieldNovoValor.setVisible(true);		
		}
		return jTFieldNovoValor;
	}
	
	//** Fim getters JTextField **	
	
	
	//** Início métodos adição de componentes **
	
	
	public void addCompJDialogEditarProduto() {
		// Dados do Produto
		getJDialogEditarProduto().getContentPane().add(getjLabelDadosDoProduto());
		getjLabelDadosDoProduto().setLocation(15, 14);
		
		
		getJDialogEditarProduto().getContentPane().add(getjLabelCodigo());
		getjLabelCodigo().setLocation(15, 56);
		
		getJDialogEditarProduto().getContentPane().add(getjTFieldCodigo());
		getjTFieldCodigo().setLocation(122, 56);
		
		getJDialogEditarProduto().getContentPane().add(getjButtonProcurarCodigo());
		getjButtonProcurarCodigo().setLocation(460, 56);
		
		
		getJDialogEditarProduto().getContentPane().add(getjLabelDescricao());
		getjLabelDescricao().setLocation(502, 56);
		
		getJDialogEditarProduto().getContentPane().add(getjTFieldDescricao());
		getjTFieldDescricao().setLocation(609, 56);
		
		
		getJDialogEditarProduto().getContentPane().add(getjLabelQuantidadeEstoque());
		getjLabelQuantidadeEstoque().setLocation(15, 97);
		
		getJDialogEditarProduto().getContentPane().add(getjTFieldQuantidadeEstoque());
		getjTFieldQuantidadeEstoque().setLocation(122, 97);
		
		
		getJDialogEditarProduto().getContentPane().add(getjLabelMarca());
		getjLabelMarca().setLocation(502, 97);
		
		getJDialogEditarProduto().getContentPane().add(getjTFieldMarca());
		getjTFieldMarca().setLocation(609, 97);
		
		
		getJDialogEditarProduto().getContentPane().add(getjLabelPreco());
		getjLabelPreco().setLocation(15, 128);
		
		getJDialogEditarProduto().getContentPane().add(getjTFieldPreco());
		getjTFieldPreco().setLocation(122, 128);

		// Novos valores
		getJDialogEditarProduto().getContentPane().add(getjLabelNovosValores());
		getjLabelNovosValores().setLocation(15, 179);
		
		
		getJDialogEditarProduto().getContentPane().add(getjLabelNovaQuantidade());
		getjLabelNovaQuantidade().setLocation(15, 221);
		
		getJDialogEditarProduto().getContentPane().add(getjTFieldNovaQuantidade());
		getjTFieldNovaQuantidade().setLocation(120, 221);
		
		
		getJDialogEditarProduto().getContentPane().add(getjLabelNovoValor());
		getjLabelNovoValor().setLocation(360, 221);
		
		getJDialogEditarProduto().getContentPane().add(getjTFieldNovoValor());
		getjTFieldNovoValor().setLocation(465, 221);
		
		
		getJDialogEditarProduto().getContentPane().add(getjButtonCancelar());
		getjButtonCancelar().setLocation(764, 271);
		
		
		getJDialogEditarProduto().getContentPane().add(getjButtonEditarProduto());
		getjButtonEditarProduto().setLocation(865, 271);
		}
		
	
	//** Fim métodos adição de componentes **

		
	
	public boolean ismodalTela() {
		return modalTela;
	}
	
	
	public void setmodalTela(boolean modalTela) {
		this.modalTela = modalTela;
	}

}