package br.edu.univas.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.listener.SaveButtonListener;

public class AddClientePanel extends JPanel{

	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private SaveButtonListener listener;
	
	public AddClientePanel() {
		addComponents();
	}
	
	public void setListener(SaveButtonListener listener) {
		this.listener = listener;
	}
	
	private void addComponents() {
		JPanel northPanel = new JPanel();
		addNorthComponents(northPanel);
		northPanel.setBackground(Color.LIGHT_GRAY);
		northPanel.setPreferredSize(new Dimension(0, 250));
		this.add(northPanel, BorderLayout.NORTH);
		
		/*JPanel centerPanel = new JPanel();
		addCenterComponents(centerPanel);
		this.add(centerPanel, BorderLayout.CENTER);*/
	}
	
	private void addNorthComponents(JPanel content) {
		content.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText("Nome:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		content.add(nameLabel, gbc);
		
		JTextField nameTextField = new JTextField();
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.weightx = 1.0;
		content.add(nameTextField, gbc);
		
		JLabel placaLabel = new JLabel();
		placaLabel.setText("Placa:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.weightx = 0;
		content.add(placaLabel, gbc);
		
		JTextField placaTextField = new JTextField();
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.weightx = 1.0;
		content.add(placaTextField, gbc);
		
		JLabel modeloLabel = new JLabel();
		modeloLabel.setText("Modelo:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.weightx = 0;
		content.add(modeloLabel, gbc);
		
		JTextField modeloTextField = new JTextField();
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.weightx = 1.0;
		content.add(modeloTextField, gbc);
		
		JLabel enderecoLabel = new JLabel();
		enderecoLabel.setText("Endereço:");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.weightx = 0;
		content.add(enderecoLabel, gbc);
		
		JTextField enderecoTextField = new JTextField();
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.weightx = 1.0;
		content.add(enderecoTextField, gbc);
		
		JLabel telefoneLabel = new JLabel();
		telefoneLabel.setText("Telefone 1:");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.weightx = 0;
		content.add(telefoneLabel, gbc);
		
		JTextField telefoneTextField = new JTextField();
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.weightx = 1.0;
		content.add(telefoneTextField, gbc);
		
		JLabel telefone2Label = new JLabel();
		telefone2Label.setText("Telefone 2:");
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.weightx = 0;
		content.add(telefone2Label, gbc);
		
		JTextField telefone2TextField = new JTextField();
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.weightx = 1.0;
		content.add(telefone2TextField, gbc);
		
		JLabel emailLabel = new JLabel();
		emailLabel.setText("E-mail:");
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.weightx = 0;
		content.add(emailLabel, gbc);
		
		JTextField emailTextField = new JTextField();
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.weightx = 1.0;
		content.add(emailTextField, gbc);
	}
	
	public JTextField getTxtNome() {
		return txtNome;
	}

	public JTextField getTxtCpf() {
		return txtCpf;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JTextField getTxtTelefone() {
		return txtTelefone;
	}
	
}
