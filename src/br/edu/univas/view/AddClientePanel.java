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
		this.setLayout(new BorderLayout());
		
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
		
		JTextField txtNome = new JTextField();
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.weightx = 1.0;
		content.add(txtNome, gbc);
		
		JLabel cpfLabel = new JLabel();
		cpfLabel.setText("CPF:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.weightx = 0;
		content.add(cpfLabel, gbc);
		
		JTextField txtCpf = new JTextField();
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.weightx = 1.0;
		content.add(txtCpf, gbc);
		
		JLabel emailLabel = new JLabel();
		emailLabel.setText("E-mail:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.weightx = 0;
		content.add(emailLabel, gbc);
		
		JTextField txtEmail = new JTextField();
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.weightx = 1.0;
		content.add(txtEmail, gbc);
		
		JLabel telefoneLabel = new JLabel();
		telefoneLabel.setText("Endereço:");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.weightx = 0;
		content.add(telefoneLabel, gbc);
		
		JTextField txtTelefone = new JTextField();
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.weightx = 1.0;
		content.add(txtTelefone, gbc);
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
