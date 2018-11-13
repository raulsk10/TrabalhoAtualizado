package br.edu.univas.controller;

import java.awt.Component;
import java.sql.SQLException;

import br.edu.univas.dao.ClienteDAO;
import br.edu.univas.view.ListClientePanel;

public class ListClienteController {

	private ListClientePanel panel;
	private ClienteDAO dao;
	
	public ListClienteController() {
		dao = new ClienteDAO();
		panel = new ListClientePanel();
	}
	
	public Component getComponent() {
		panel.updateClientes(dao.getAll());
		return panel;
	}
}
