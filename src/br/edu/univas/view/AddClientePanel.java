package br.edu.univas.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
	private GridBagConstraints gbc;
	private JPanel content;
	
	public AddClientePanel() {
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
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText("Nome:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5, 5, 5, 5);
		content.add(nameLabel, gbc);
		
		gbc = new GridBagConstraints();
		txtNome = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weightx = 1.0;
		gbc.weighty = 0;
		content.add(txtNome, gbc);
		
		gbc = new GridBagConstraints();
		JLabel cpfLabel = new JLabel();
		cpfLabel.setText("CPF:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weightx = 0;
		gbc.weighty = 0;
		content.add(cpfLabel, gbc);
		
		gbc = new GridBagConstraints();
		txtCpf = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weightx = 1.0;
		gbc.weighty = 0;
		content.add(txtCpf, gbc);
		
		gbc = new GridBagConstraints();
		JLabel emailLabel = new JLabel();
		emailLabel.setText("E-mail:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weightx = 0;
		gbc.weighty = 0;
		content.add(emailLabel, gbc);
		
		gbc = new GridBagConstraints();
		txtEmail = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weightx = 1.0;
		gbc.weighty = 0;
		content.add(txtEmail, gbc);
		
		gbc = new GridBagConstraints();
		JLabel telefoneLabel = new JLabel();
		telefoneLabel.setText("Telefone:");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weightx = 0;
		gbc.weighty = 0;
		content.add(telefoneLabel, gbc);
		
		gbc = new GridBagConstraints();
		txtTelefone = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weightx = 1.0;
		gbc.weighty = 0;
		content.add(txtTelefone, gbc);
		
		gbc = new GridBagConstraints();
		JButton btnSalvar = new JButton();
		btnSalvar.setText("Salvar");
		btnSalvar.setPreferredSize(new Dimension(128, 32));
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {	
				listener.save();
			}
		});
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 650, 5, 5);
		gbc.weightx = 0;
		gbc.weighty = 0;
		content.add(btnSalvar, gbc);

		this.add(content);
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