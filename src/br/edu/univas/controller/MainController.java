package br.edu.univas.controller;

import java.awt.Component;

import javax.swing.SwingUtilities;

import br.edu.univas.listener.TrocaTelaListener;
import br.edu.univas.view.MainView;

public class MainController {
	
	private AddClienteController addClienteController;
	private AddCarroController addCarroController;
	private AddServicoController addServicoController;
	private ListClienteController listClienteController;
	private ListServicoController listServicoController;
	private MainView mainView;

	public MainController() {
		mainView = new MainView();
		addClienteController = new AddClienteController();
		addCarroController = new AddCarroController();
		addServicoController = new AddServicoController();
		listClienteController = new ListClienteController();
		listServicoController = new ListServicoController();
	}
	
	public void initApp() {
		mainView.setListener(new TrocaTelaListener() {
			@Override
			public void showAddClienteView() {
				showAddClientePanel();
			}
			
			@Override
			public void showAddCarroView() {
				showAddCarroPanel();
			}
			
			@Override
			public void showAddServicoView() {
				showAddServicoPanel();
			}
			
			@Override
			public void showListClienteView() {
				showListClientePanel();
			}
			
			@Override
			public void showListServicoView() {
				showListServicoPanel();
			}
		});
		
		mainView.setVisible(true);
		showAddClientePanel();
	}
	
	private void showAddClientePanel() {
		showPanel(addClienteController.getComponent());
	}
	
	private void showAddCarroPanel() {
		showPanel(addCarroController.getComponent());
	}

	private void showAddServicoPanel() {
		showPanel(addServicoController.getComponent());
	}
	
	private void showListClientePanel() {
		showPanel(listClienteController.getComponent());
	}
	
	private void showListServicoPanel() {
		showPanel(listServicoController.getComponent());
	}
	
	private void showPanel(Component component) {
		mainView.getCenterPanel().removeAll();
		mainView.getCenterPanel().add(component);
		mainView.getCenterPanel().revalidate();
		SwingUtilities.updateComponentTreeUI(mainView);
	}
}
