/**
 * 
 */
package control;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

import dao.DaoJPanelVendas;
import model.Cores;
import model.Mascara;
import model.Validar;
import view.JFramePrincipal;
import view.JPanelPrincipal;
import view.JPanelVendas;
import view.JPanelVendasNovo;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJPanelVendas implements MouseListener, KeyListener, FocusListener, WindowListener, ItemListener {
	

	//** In�cio declara��o de vari�veis **
	private JFramePrincipal jFramePricipal;
	private JPanelVendas jPanelVendas;
	private JPanelPrincipal jPanelPrincipal;
	private JPanelVendasNovo jPanelVendasNovo;
	private ControlJPanelVendasNovo controlJPanelVendasNovo;
	private DaoJPanelVendas daoJPanelVendas;
	
	private String data1;
	private String data2;
	
	//** Fim declara��o de vari�veis **	
	
	
	/**
	 * @param jFramePricipal
	 * @param jPanelVendas
	 * @param jPanelPrincipal
	 */
	public ControlJPanelVendas(JFramePrincipal jFramePricipal, JPanelVendas jPanelVendas,
			JPanelPrincipal jPanelPrincipal) {
		this.jFramePricipal = jFramePricipal;
		this.jPanelVendas = jPanelVendas;
		this.jPanelPrincipal = jPanelPrincipal;
		this.AddEvent();
	}


	/**
	 * O m�todo AddEvent() addiciona as as a��es para os componentes.
	 */
	private void AddEvent() {
		getjFramePricipal().addWindowListener(this);
		getjPanelVendasNovo().addFocusListener(this);
		getjPanelVendas().getjButtonNovaVenda().addMouseListener(this);
		getjPanelVendas().getjButtonApagar().addMouseListener(this);
		getjPanelVendas().getjButtonImprimir().addMouseListener(this);
		getjPanelVendas().getjButtonFiltrar().addMouseListener(this);
		getjPanelVendas().getjButtonPesquisarTodos().addMouseListener(this);
		getjPanelVendas().getjTFieldDTInicial().addFocusListener(this);
		getjPanelVendas().getjTFieldFormPesquisa().addKeyListener(this);
		getjPanelVendas().getjTFieldDTFinal().addFocusListener(this);
		getjPanelVendas().getChoiceFormPesquisa().addItemListener(this);
		
	}		
		
	//** In�cio m�todos sobrescritos **	
	
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
		// Quando for digitado em pesquisar como
		if(e.getSource() == getjPanelVendas().getjTFieldFormPesquisa()) {
			// Verificar sele��o no choice			
			switch(getjPanelVendas().getChoiceFormPesquisa().getSelectedItem().replace(" ", "")) {
			case "Vendedor":
				getDaoJPanelVendas().consultaVendasVendedor(getjPanelVendas().getjTFieldFormPesquisa().getText());
				break;
				
			case "Cliente":
				getDaoJPanelVendas().consultaVendasCliente(getjPanelVendas().getjTFieldFormPesquisa().getText());
				break;
			}
		}
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	
	
	@Override
	public void focusGained(FocusEvent e) {
		// Quando o campo DataInicial ganhar foco
		if(e.getSource() == getjPanelVendas().getjTFieldDTInicial()) {			
			Mascara.setMascara(getjPanelVendas().getjTFieldDTInicial(), Mascara.mascaraData());		
		}
		
		
		// Quando o campo DataFinal ganhar foco		
		else if(e.getSource() == getjPanelVendas().getjTFieldDTFinal()) {			
			Mascara.setMascara(getjPanelVendas().getjTFieldDTFinal(), Mascara.mascaraData());		
		}
	}
	
	@Override
	public void focusLost(FocusEvent e) {
		// Quando o campo dataInicial perder o foco
		if(e.getSource() == getjPanelVendas().getjTFieldDTInicial()) {
			// Verifica e formata o campo de acordo com a validade da data passada
			if(verificarCampoData(getjPanelVendas().getjTFieldDTInicial()));
				setData1(getjPanelVendas().getjTFieldDTInicial().getText());
		}
		
		
		// Quando o campo dataFinal perder o foco
		else if(e.getSource() == getjPanelVendas().getjTFieldDTFinal()) {
			// Verifica e formata o campo de acordo com a validade da data passada
			if(verificarCampoData(getjPanelVendas().getjTFieldDTFinal()));
				setData2(getjPanelVendas().getjTFieldDTFinal().getText());		
		}
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		// Quando o bot�o nova venda for clicado
		if(e.getSource() == getjPanelVendas().getjButtonNovaVenda()) {
			jPanelVendasNovo = null;
			controlJPanelVendasNovo = null;
			getjFramePricipal().alterarJPanel(getjPanelVendasNovo());
			getControlJPanelVendasNovo();
		}
		
		
		// Quando o bot�o pesquisar todos for clicado
		else if(e.getSource() == getjPanelVendas().getjButtonPesquisarTodos()) {
			// Realizar buscas de todos as vendas
			getjPanelVendas().getjTFieldFormPesquisa().setText("");
			getDaoJPanelVendas().consultarVendas();
		}
		
		
		// Quando o bot�o filtrar for clicado
		else if(e.getSource() == getjPanelVendas().getjButtonFiltrar()) {
			// Colocar foco no jtfild
			getjPanelVendas().getjTFieldFormPesquisa().requestFocus();
			
			// Validar os campos de data
			if (verificarCamposData())
				getDaoJPanelVendas().consultaVendasData(getData1(), getData2());
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// Quando for selecionado algum �tem do choice FormPesquisa
		if(e.getSource() == getjPanelVendas().getChoiceFormPesquisa()) {
			// Verificar qual �tem foi selecionado
			switch(getjPanelVendas().getChoiceFormPesquisa().getSelectedItem().replace(" ", "")) {
											
			case "Cart�o":
				// Realizar a buscas no banco de dados
				System.out.println("pesquisa cart�o");
				getDaoJPanelVendas().consultaVendasCartao();
				getjPanelVendas().getjTFieldFormPesquisa().setEnabled(false);
				break;
				
			case "Dinheiro":
				// Realizar a buscas no banco de dados
				getDaoJPanelVendas().consultaVendasDinheiro();
				getjPanelVendas().getjTFieldFormPesquisa().setEnabled(false);
				break;
				
			default:
				// Realizar a buscas no banco de dados
				getjPanelVendas().getjTFieldFormPesquisa().setEnabled(true);
				getjPanelVendas().getjTFieldFormPesquisa().requestFocus();
				break;
			}
		}
	}
	

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// Quando o JFrame for ativado
		if(e.getSource() == getjFramePricipal()) {
			// Atualizar a tabela de vendas
			System.out.println("Atualizou tabela vendas");
			getDaoJPanelVendas().consultarVendas();
		}
		
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
		
	//** Fim m�todos sobrescritos **
	
	//** In�cio m�todos da classe **

	
	public JFramePrincipal getjFramePricipal() {
		if(jFramePricipal == null) {
			jFramePricipal = new JFramePrincipal();
		}
		return jFramePricipal;
	}



	public JPanelVendas getjPanelVendas() {
		if(jPanelVendas == null) {
			jPanelVendas = new JPanelVendas();
		}
		return jPanelVendas;
	}



	public JPanelPrincipal getjPanelPrincipal() {
		if(jPanelPrincipal == null) {
			jPanelPrincipal = new JPanelPrincipal();
		}
		return jPanelPrincipal;
	}		
		
		
	public JPanelVendasNovo getjPanelVendasNovo() {
		if(jPanelVendasNovo == null){
			jPanelVendasNovo = new JPanelVendasNovo();	
		}
		return jPanelVendasNovo;
	}	
	
		
	public DaoJPanelVendas getDaoJPanelVendas() {
		if(daoJPanelVendas == null){
			daoJPanelVendas = new DaoJPanelVendas(getjPanelVendas());	
		}
		return daoJPanelVendas;
	}


	public ControlJPanelVendasNovo getControlJPanelVendasNovo() {
		if(controlJPanelVendasNovo == null){
			controlJPanelVendasNovo = new ControlJPanelVendasNovo(getjFramePricipal(), getjPanelVendasNovo(),
					getjPanelVendas(), getjPanelPrincipal());
	
		}
		return controlJPanelVendasNovo;
	}


	public String getData1() {
		return data1;
	}


	public void setData1(String data1) {
		this.data1 = data1.replace(" ", "");
	}


	public String getData2() {
		return data2;
	}


	public void setData2(String data2) {
		this.data2 = data2.replace(" ", "");
	}
	
	
	/**
	 * O m�todo verificarCampoData(JFormatterdTextField @{code: campo}), Verica se o campo passado como parametro tem a data
	 * setada corretamente.
	 * @param campo recebe um JFormattedTextField contendo uma data.
	 * @return boolean retorna falso caso a data n�o tenha sido setada corretamente.
	 */
	private boolean verificarCampoData(JFormattedTextField campo) {
		String dataInicial = campo.getText().replace(" ", "").replace("/", "");
		if(!dataInicial.isEmpty()) {
			// Verifica se est� faltando n�meros
			if(dataInicial.length() < 8) {			
				Mascara.setMascara(campo, Mascara.mascaraNula());
				return false;
			}
			// Verifica se � v�lido
			else if(!Validar.validarData(campo.getText())){
				JOptionPane.showConfirmDialog(
					getjPanelVendas(), // componente
					"Data inv�lida, digite novamente", // texto
					"Data inv�lida", // titulo
					JOptionPane.DEFAULT_OPTION, // bot�es
					JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
					);
				campo.setText("");
				campo.requestFocus();					
			}
			// se for v�lida
			else {
				campo.setBorder(BorderFactory.
						createLineBorder(Cores.cinza2, 1, false));	
				return true;
			}
		}	
		return false;		
	}
	
	
	/**
	 * O m�todo verificarCamposData(), Verifica se os dois campos de datas est�o setados corretamente.
	 * @return boolean retorna falso caso o campo data1 e/ou data2 tenha sido setado incorretamente.
	 */
	private boolean verificarCamposData() {
		// Verificar se o campo data1 est� preenchido
		if(getData1() == null) {
			// Colocar o foco no campo data1
			getjPanelVendas().getjTFieldDTInicial().setBorder(BorderFactory.
					createLineBorder(Cores.vermelho, 1, false));
			getjPanelVendas().getjTFieldDTInicial().requestFocus();
			return false;
		}
		// Verificar se o campo data2 est� preenchido
		else if(getData2() == null) {
			// Colocar o foco no campo data2
			getjPanelVendas().getjTFieldDTFinal().setBorder(BorderFactory.
					createLineBorder(Cores.vermelho, 1, false));	
			getjPanelVendas().getjTFieldDTFinal().requestFocus();			
			return false;
		}
		// Verificar se data1 � menor ou igual a data2
		else if(Validar.compareDateTo(data1, data2)) return true;
		// Se a data1 for mairo que a data2
		else {
			JOptionPane.showConfirmDialog(
				getjPanelVendas(), // componente
				"A data inicial � maior que a data final", // texto
				"Erro ao passar datas", // titulo
				JOptionPane.DEFAULT_OPTION, // bot�es
				JOptionPane.ERROR_MESSAGE // tipo de mensagem
			);
		}
		return false;
	}
	
	//** Fim m�todos da classe **

}
