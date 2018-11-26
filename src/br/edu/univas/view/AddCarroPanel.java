package br.edu.univas.view;

import java.awt.BorderLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.dao.ClienteDAO;
import br.edu.univas.listener.SaveButtonListener;

public class AddCarroPanel extends JPanel {
	
	private JComboBox txtCliente;
	private JTextField txtModelo;
	private JTextField txtPlaca;
	private JTextField txtCor;
	private GridBagConstraints gbc;
	private SaveButtonListener listener;
	private ClienteDAO cliDao;
	private JPanel content;

	public AddCarroPanel() {
		addComponents();
	}
	
	public void setListener(SaveButtonListener listener) {
		this.listener = listener;
	}
	
	private void addComponents() {
		this.setLayout(new BorderLayout());
		content = new JPanel();
		
		content.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
		JLabel clienteLabel = new JLabel();
		clienteLabel.setText("Cliente:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5, 5, 5, 5);
		content.add(clienteLabel, gbc);
		
		gbc = new GridBagConstraints();
		txtCliente = new JComboBox();
		cliDao = new ClienteDAO();
		ArrayList<String> cpfs = new ArrayList<String>();
		cpfs = cliDao.getCpfs();
		for (String string : cpfs) {
			txtCliente.addItem(preencheCliente(string) +" - "+ string);
		}
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weightx = 1.0;
		gbc.weighty = 0;
		content.add(txtCliente, gbc);
		
		gbc = new GridBagConstraints();
		JLabel modeloLabel = new JLabel();
		modeloLabel.setText("Modelo:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weightx = 0;
		gbc.weighty = 0;
		content.add(modeloLabel, gbc);
		
		gbc = new GridBagConstraints();
		txtModelo = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weightx = 1.0;
		gbc.weighty = 0;
		content.add(txtModelo, gbc);
		
		gbc = new GridBagConstraints();
		JLabel placaLabel = new JLabel();
		placaLabel.setText("Placa:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weightx = 0;
		gbc.weighty = 0;
		content.add(placaLabel, gbc);
		
		gbc = new GridBagConstraints();
		txtPlaca = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weightx = 1.0;
		gbc.weighty = 0;
		content.add(txtPlaca, gbc);
		
		gbc = new GridBagConstraints();
		JLabel corLabel = new JLabel();
		corLabel.setText("Cor:");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weightx = 0;
		gbc.weighty = 0;
		content.add(corLabel, gbc);
		
		gbc = new GridBagConstraints();
		txtCor = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weightx = 1.0;
		gbc.weighty = 0;
		content.add(txtCor, gbc);
		
		gbc = new GridBagConstraints();
		JButton btnSalvar = new JButton();
		btnSalvar.setText("Salvar");
		btnSalvar.setPreferredSize(new Dimension(128, 32));
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {	
				if (verificaCampos())
					listener.save();
				else
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Cadastro Serviço", JOptionPane.WARNING_MESSAGE);
			}
		});
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 2;
		content.add(btnSalvar, gbc);

		this.add(content);
	}
	
	public boolean verificaCampos() {
		boolean preenchidos = true;
		
		if (txtCliente.getSelectedItem().toString().equals(""))
			preenchidos = false;
		if (txtModelo.getText().toString().equals(""))
			preenchidos = false;
		if (txtPlaca.getText().toString().equals(""))
			preenchidos = false;
		if (txtCor.getText().toString().equals(""))
			preenchidos = false;
		
		return preenchidos;
	}
	
	public String preencheCliente(String cpf) {
		return cliDao.getCliente(cpf);
	}
	
	public String getTxtCliente() {
		return txtCliente.getSelectedItem().toString();
	}

	public JTextField getTxtModelo() {
		return txtModelo;
	}

	public JTextField getTxtPlaca() {
		return txtPlaca;
	}

	public JTextField getTxtCor() {
		return txtCor;
	}
}
