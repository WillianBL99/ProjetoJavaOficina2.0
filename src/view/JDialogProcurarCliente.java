/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Frame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import dao.ComandosSQL;
import dao.ModuloConexao;
import dao.PreencherTabela;
import icons.Icones;
import model.Cores;
import model.Fontes;
import model.SetSizeIcon;

/**
 * @author josim
 *
 */

@SuppressWarnings("serial")
public class JDialogProcurarCliente extends JDialog{


	//** Início declaração de variáveis **
	private boolean modalTela;
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	private ModuloConexao moduloConexao;
		
	
	private JLabel jLabelPesquisarPor;
		
	private JTextField jTextFieldCampoPesquisa;
		
	private JButton jButtonPesquisar;
	private JButton jButtonNovoCliente;
	private JButton jButtonCancelar;
	private JButton jButtonSelecionar;
		
	private JComboBox<String> jComboBoxPesquisa;
		
	private JTable jTableCliente;
		
	private JScrollPane jSPanel;
		
	public JDialogProcurarCliente(Frame frame, boolean modalTela) {
		super(frame, "Procurar clientes");
		setmodalTela(modalTela);
		getJDialogProcurarCliente();
		addCompJDialogProcurarCliente();
	}	

	
	//** Fim construtor **
	
	//** Início getters JPanels **
	public JDialogProcurarCliente getJDialogProcurarCliente() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Cores.cinza5);
		this.setSize(975, 310);
		this.setVisible(true);
		
		return this;
	}

	
	public JScrollPane getjSPanel() {
		if(jSPanel == null){
			jSPanel = new JScrollPane();
			jSPanel.setViewportView(getjTableCliente());
			jSPanel.setSize(880,112);
		}
		return jSPanel;
	}

	
	//** Fim getters JPanel **


	//** Início getters JButon **
	public JButton getjButtonPesquisar() {
		if(jButtonPesquisar == null){
			
			jButtonPesquisar = new JButton();			
			jButtonPesquisar.setFont(Fontes.fontJButtonPlain3);
			jButtonPesquisar.setBackground(Cores.azul1);
			jButtonPesquisar.setForeground(Color.white);
			jButtonPesquisar.setSize(48, 23);
			jButtonPesquisar.setFocusable(false);
			jButtonPesquisar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
			setSizeIcon.setIconJButton(jButtonPesquisar, Icones.
					getBuscar(), 22, 22);
		}	
		return jButtonPesquisar;

	}

	public JButton getjButtonNovoCliente() {
		if(jButtonNovoCliente == null){
			jButtonNovoCliente = new JButton();			
			jButtonNovoCliente.setFont(Fontes.fontJButtonPlain3);
			jButtonNovoCliente.setBackground(Cores.azul1);
			jButtonNovoCliente.setForeground(Color.white);
			setSizeIcon.setIconJButton(jButtonNovoCliente, Icones.
					getNewUser(), 20, 20);
			jButtonNovoCliente.setSize(48, 23);
			jButtonNovoCliente.setFocusable(false);
			jButtonNovoCliente.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}	
		return jButtonNovoCliente;
	}

	public JButton getjButtonCancelar() {
		if(jButtonCancelar == null){
			jButtonCancelar = new JButton();			
			jButtonCancelar.setFont(Fontes.fontJButtonPlain3);
			jButtonCancelar.setBackground(Cores.azul1);
			jButtonCancelar.setForeground(Color.white);
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setSize(86, 23);
			jButtonCancelar.setFocusable(false);
			jButtonCancelar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}	
		return jButtonCancelar;
	}

	public JButton getjButtonSelecionar() {
		if(jButtonSelecionar == null){
			
			jButtonSelecionar = new JButton();
			jButtonSelecionar.setFont(Fontes.fontJButtonPlain3);			
			jButtonSelecionar.setBackground(Cores.azul1);
			jButtonSelecionar.setForeground(Color.white);
			jButtonSelecionar.setText("Seleciona");
			jButtonSelecionar.setSize(86,23);
			jButtonSelecionar.setFocusable(false);
			jButtonSelecionar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
			}	
		
		return jButtonSelecionar;
	
	}

	//** Fim getters JButton **


	//** Início getters JLabel **	
	
	public JTextField getjTextFieldCampoPesquisa() {
		if(jTextFieldCampoPesquisa == null){
	
			jTextFieldCampoPesquisa = new JTextField();
			jTextFieldCampoPesquisa.setSize(182, 21);
			jTextFieldCampoPesquisa.setBorder(BorderFactory.
				createLineBorder(Cores.cinza2, 1, false));
			jTextFieldCampoPesquisa.setForeground(Cores.preto);
			jTextFieldCampoPesquisa.setFont(Fontes.fontJTFieldPlain1);
			jTextFieldCampoPesquisa.setOpaque(true);
		}
		return jTextFieldCampoPesquisa;
	}

	public JLabel getjLabelPesquisarPor() {
		if(jLabelPesquisarPor == null){
		
			jLabelPesquisarPor = new JLabel("Pesquisar por:");
			jLabelPesquisarPor.setFont(Fontes.fontJLabelPlain1);
			jLabelPesquisarPor.setSize(99, 21);
			jLabelPesquisarPor.setForeground(Cores.preto);
			jLabelPesquisarPor.setOpaque(false);
				
		}
		return jLabelPesquisarPor;
	}
	
	//** Fim getters JLabel **
	
	
	//** Início getters JTextField **
	//** Fim getters JTextField **
	
	
	//** Início getters JComboBox **
	public JComboBox<String> getjComboBoxPesquisa() {
			if(jComboBoxPesquisa == null){
				
				jComboBoxPesquisa = new JComboBox<String>();
				jComboBoxPesquisa.setSize(144, 21);
				jComboBoxPesquisa.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
				jComboBoxPesquisa.setForeground(Cores.preto);
				jComboBoxPesquisa.setFont(Fontes.fontJTFieldPlain1);
				jComboBoxPesquisa.setOpaque(true);
				jComboBoxPesquisa.addItem("Nome");
				jComboBoxPesquisa.addItem("CPF");
				jComboBoxPesquisa.addItem("CNPj");
			}
			return jComboBoxPesquisa;
		}

	//** Fim getters JComboBox **
	
	//** Início getters Table **
	
	public JTable getjTableCliente() {
			if(jTableCliente == null){		
				jTableCliente = new JTable();
				getModuloConexao().executeQuery(ComandosSQL.getconsultarClientesNome(), "");
				jTableCliente.setModel(new PreencherTabela().preencher(getModuloConexao().getResultSet(),
						"Nº",
						"CNPj",
						"CPF",
						"Nome",
						"email",
						"Telefone",
						"Cidade"));

				jTableCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				jTableCliente.setFont(Fontes.fontJTablePlain2);
				jTableCliente.setOpaque(false);
				jTableCliente.getTableHeader().setFont(Fontes.fontJTableBold2);
				jTableCliente.getTableHeader().setForeground(Cores.branco);
				jTableCliente.getTableHeader().setBackground(Cores.azul1);
			}
			return jTableCliente;
		}
		
	//** Fim getters Table **


		
		
	//** Início métodos adição de componentes **
	private void addCompJDialogProcurarCliente() {
		this.getJDialogProcurarCliente().getContentPane().add(getjLabelPesquisarPor());
		this.getjLabelPesquisarPor().setLocation(51, 64);
		
		this.getJDialogProcurarCliente().getContentPane().add(getjComboBoxPesquisa());
		this.getjComboBoxPesquisa().setLocation(155, 64);
		
		this.getJDialogProcurarCliente().getContentPane().add(getjTextFieldCampoPesquisa());
		this.getjTextFieldCampoPesquisa().setLocation(319, 64);
		
		this.getJDialogProcurarCliente().getContentPane().add(getjButtonPesquisar());
		this.getjButtonPesquisar().setLocation(511, 64);
		
		this.getJDialogProcurarCliente().getContentPane().add(getjButtonNovoCliente());
		this.getjButtonNovoCliente().setLocation(874, 64);
		
		this.getJDialogProcurarCliente().getContentPane().add(getjButtonCancelar());
		this.getjButtonCancelar().setLocation(748, 235);
		
		this.getJDialogProcurarCliente().getContentPane().add(getjButtonSelecionar());
		this.getjButtonSelecionar().setLocation(844, 235);
		
		this.getJDialogProcurarCliente().getContentPane().add(getjSPanel());
		this.getjSPanel().setLocation(50,112);
	}
	
	
	public boolean ismodalTela() {
		return modalTela;
	}
	
	
	public void setmodalTela(boolean modalTela) {
		this.modalTela = modalTela;
	}
	
	
	private ModuloConexao getModuloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}
		return moduloConexao;
	}
		
}
