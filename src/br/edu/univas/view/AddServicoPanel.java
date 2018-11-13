package br.edu.univas.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.listener.SaveButtonListener;

public class AddServicoPanel extends JPanel {

	private JTextField txtCodCliente;
	private JTextField txtCodCarro;
	private JTextField txtStatus;
	private JTextField txtDataEntrada;
	private JTextField txtDataSaida;
	private JTextField txtValorFinal;
	
	private SaveButtonListener listener;
	
	public AddServicoPanel() {
		addComponents();
	}
	
	public void setListener(SaveButtonListener listener) {
		this.listener = listener;
	}
	
	private void addComponents() {
		this.setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		addNorthComponents(northPanel);
		northPanel.setPreferredSize(new Dimension(0, 250));
		this.add(northPanel, BorderLayout.NORTH);
	}
	
	private void addNorthComponents(JPanel northPanel) {
		
	}
	
	public JTextField getTxtCodCliente() {
		return txtCodCliente;
	}
	
	public JTextField getTxtCodCarro() {
		return txtCodCarro;
	}
	
	public JTextField getTxtStatus() {
		return txtStatus;
	}
	
	public JTextField getTxtDataEntrada() {
		return txtDataEntrada;
	}
	
	public JTextField getTxtDataSaida() {
		return txtDataSaida;
	}
	
	public JTextField getTxtValorFinal() {
		return txtValorFinal;
	}
	
}
