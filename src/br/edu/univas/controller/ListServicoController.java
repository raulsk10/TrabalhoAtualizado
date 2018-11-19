package br.edu.univas.controller;

import java.awt.Component;

import br.edu.univas.dao.ServicoDAO;
import br.edu.univas.view.ListServicoPanel;

public class ListServicoController {

	private ListServicoPanel panel;
	private ServicoDAO dao;
	
	public ListServicoController() {
		dao = new ServicoDAO();
		panel = new ListServicoPanel();
	}
	
	public Component getComponent() {
		panel.updateServicos(dao.getAll());
		return panel;
	}
}
