package br.edu.univas.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.dao.CarroDAO;
import br.edu.univas.dao.ClienteDAO;
import br.edu.univas.listener.SaveButtonListener;

public class AddServicoPanel extends JPanel {

	private JComboBox<String> txtCodCliente;
	private JLabel lblCodCliente;
	private JComboBox<String> txtCodCarro;
	private JTextField txtDataEntrada;
	private JTextField txtHoraEntrada;
	private GridBagConstraints gbc;
	private ClienteDAO cliDao;
	private CarroDAO carDao;
	private SaveButtonListener listener;
	private String cpfCliente;
	
	public AddServicoPanel() {
		addComponents();
	}
	
	public void setListener(SaveButtonListener listener) {
		this.listener = listener;
	}
	
	private void addComponents() {
		this.setLayout(new GridBagLayout());
		Insets insets = new Insets(5, 5, 5, 5);
		
		
		gbc();
		lblCodCliente = new JLabel();
		lblCodCliente.setText("Cliente:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = insets;
		this.add(lblCodCliente, gbc);
		
		gbc();
		JLabel lblCarro = new JLabel();
		lblCarro.setText("Carro:");
		gbc.gridx = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = insets;
		this.add(lblCarro, gbc);
		
		gbc();
		txtCodCarro = new JComboBox<String>();
		gbc.gridx = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = insets;
		gbc.weightx = 1.0;
		this.add(txtCodCarro, gbc);
		
		gbc();
		txtCodCliente = new JComboBox<String>();
		cliDao = new ClienteDAO();
		carDao = new CarroDAO();
		txtCodCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				preencheCarros();
			}
		});
		ArrayList<String> cpfs = new ArrayList<String>();
		cpfs = cliDao.getCpfs();
		for (String string : cpfs) {
			txtCodCliente.addItem(preencheCliente(string) +" - "+ string);
		}
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = insets;
		gbc.weightx = 1.0;
		this.add(txtCodCliente, gbc);
		
		gbc();
		JLabel lblDataEntrada = new JLabel();
		lblDataEntrada.setText("Data de entrada:");
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = insets;
		this.add(lblDataEntrada, gbc);
		
		gbc();
		txtDataEntrada = new JTextField();
		txtDataEntrada.setColumns(6);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = insets;
		this.add(txtDataEntrada, gbc);
		
		gbc();
		JLabel lblHoraEntrada = new JLabel();
		lblHoraEntrada.setText("Hora de entrada:");
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = insets;
		this.add(lblHoraEntrada, gbc);
		
		gbc();
		txtHoraEntrada = new JTextField();
		txtHoraEntrada.setColumns(3);
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = insets;
		this.add(txtHoraEntrada, gbc);
		
		gbc();
		JButton btnSalvar = new JButton();
		btnSalvar.setText("Salvar");
		btnSalvar.setPreferredSize(new Dimension(128, 32));
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtDataEntrada.setText(txtDataEntrada.getText()+ " " +txtHoraEntrada.getText());
				listener.save();
			}
		});
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(btnSalvar, gbc);
	}
	
	public void preencheCarros() {
		txtCodCarro.removeAllItems();
		ArrayList<String> placas = new ArrayList<String>();
		String cliente = txtCodCliente.getSelectedItem().toString();
		String[] pieces = cliente.split(" - ");
		placas = carDao.getPlacas(pieces[1]);
		for (int i=0;i<placas.size();i++) {
			txtCodCarro.addItem(placas.get(i));
		}
	}
	
	public String preencheCliente(String cpf) {
		return cliDao.getCliente(cpf);
	}
	
	public String getTxtCodCliente() {
		return txtCodCliente.getSelectedItem().toString();
	}
	
	public String getTxtCodCarro() {
		return txtCodCarro.getSelectedItem().toString();
	}
	
	public JTextField getTxtDataEntrada() {
		return txtDataEntrada;
	}
	
	public JTextField getTxtHoraEntrada() {
		return txtHoraEntrada;
	}
	
	public String getCpfCliente() {
		return cpfCliente;
	}
	
	private void gbc() {
		gbc = new GridBagConstraints();
	}
}
