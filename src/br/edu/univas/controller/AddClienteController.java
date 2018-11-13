package br.edu.univas.controller;

import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.dao.ClienteDAO;
import br.edu.univas.listener.SaveButtonListener;
import br.edu.univas.model.Cliente;
import br.edu.univas.view.AddClientePanel;

public class AddClienteController {

	private AddClientePanel addClientePanel;
	private ClienteDAO dao;
	private Cliente cliente;
	
	public AddClienteController() {
		dao = new ClienteDAO();
		addClientePanel = new AddClientePanel();
		addClientePanel.setListener(new SaveButtonListener() {
			@Override
			public void save() {
				saveCliente();
			}
		});
	}
	
	private void saveCliente() {
		cliente = new Cliente();
		cliente.setNome(addClientePanel.getTxtNome().getText());
		cliente.setCpf(addClientePanel.getTxtCpf().getText());
		cliente.setEmail(addClientePanel.getTxtEmail().getText());
		cliente.setTelefone(addClientePanel.getTxtTelefone().getText());
		
		dao.save(cliente);
		limparCampos();
	}
	
	private void limparCampos() {
		List<JTextField> fields = Arrays.asList(
				addClientePanel.getTxtNome(),
				addClientePanel.getTxtCpf(),
				addClientePanel.getTxtEmail(),
				addClientePanel.getTxtTelefone());
		
		for (JTextField jTextField : fields) {
			jTextField.setText(null);
		}
	}
	
	public JPanel getComponent() {
		return addClientePanel;
	}
}
