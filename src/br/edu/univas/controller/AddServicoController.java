package br.edu.univas.controller;

import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.dao.ServicoDAO;
import br.edu.univas.listener.SaveButtonListener;
import br.edu.univas.model.Servico;
import br.edu.univas.view.AddServicoPanel;

public class AddServicoController {

	private AddServicoPanel addServicoPanel;
	private ServicoDAO dao;
	private Servico servico;
	
	public AddServicoController() {
		dao = new ServicoDAO();
		addServicoPanel = new AddServicoPanel();
		addServicoPanel.setListener(new SaveButtonListener() {
			@Override
			public void save() {
				saveServico();
			}
		});
	}
	
	private void saveServico() {
		servico = new Servico();
		servico.setCodCliente(addServicoPanel.getTxtCodCliente().getText());
		servico.setCodCarro(addServicoPanel.getTxtCodCarro().getText());
		servico.setStatus(addServicoPanel.getTxtStatus().getText());
		servico.setDataEntrada(addServicoPanel.getTxtDataEntrada().getText());
		servico.setDataSaida(addServicoPanel.getTxtDataSaida().getText());
		servico.setValorFinal(addServicoPanel.getTxtValorFinal().getText());
		
		dao.save(servico);
		limparCampos();
	}
	
	private void limparCampos() {
		List<JTextField> fields = Arrays.asList(
				addServicoPanel.getTxtCodCliente(),
				addServicoPanel.getTxtCodCarro(),
				addServicoPanel.getTxtStatus(),
				addServicoPanel.getTxtDataEntrada(),
				addServicoPanel.getTxtDataSaida(),
				addServicoPanel.getTxtValorFinal());
		
		for (JTextField jTextField : fields) {
			jTextField.setText(null);
		}
	}
	
	public JPanel getComponent() {
		return addServicoPanel;
	}
}
