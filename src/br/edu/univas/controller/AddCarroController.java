package br.edu.univas.controller;

import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.dao.CarroDAO;
import br.edu.univas.listener.SaveButtonListener;
import br.edu.univas.model.Carro;
import br.edu.univas.view.AddCarroPanel;

public class AddCarroController {

	private AddCarroPanel addCarroPanel;
	private CarroDAO dao;
	private Carro carro;
	
	public AddCarroController() {
		dao = new CarroDAO();
		addCarroPanel = new AddCarroPanel();
		addCarroPanel.setListener(new SaveButtonListener() {
			@Override
			public void save() {
				saveCarro();
			}
		});
	}
	
	private void saveCarro() {
		carro = new Carro();
		carro.setCodCliente(addCarroPanel.getTxtCliente().toString());
		carro.setModelo(addCarroPanel.getTxtModelo().getText());
		carro.setPlaca(addCarroPanel.getTxtPlaca().getText());
		carro.setCor(addCarroPanel.getTxtCor().getText());
		
		dao.save(carro);
		limparCampos();
	}
	
	private void limparCampos() {
		List<JTextField> fields = Arrays.asList(
				//addCarroPanel.getTxtCliente(),
				addCarroPanel.getTxtModelo(),
				addCarroPanel.getTxtPlaca(),
				addCarroPanel.getTxtCor());
		
		for (JTextField jTextField : fields) {
			jTextField.setText(null);
		}
	}
	
	public JPanel getComponent() {
		return addCarroPanel;
	}
}
