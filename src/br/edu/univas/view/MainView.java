package br.edu.univas.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.edu.univas.listener.TrocaTelaListener;

public class MainView extends JFrame {
	
	private TrocaTelaListener listener;
	private JPanel centerPanel;

	public MainView() {
		this.setTitle("Casa dos Carros");
		this.setSize(900, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		addComponents();
	}
	
	public JPanel getCenterPanel() {
		return centerPanel;
	}
	
	public void setListener(TrocaTelaListener listener) {
		this.listener = listener;
	}
	
	public void addComponents() {
		this.setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		addButtons(northPanel);
		this.getContentPane().add(northPanel, BorderLayout.NORTH);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
	}
	
	public void addButtons(JPanel panel) {
		Dimension btnDimension = new Dimension(170, 50);
		
		JButton btnCliente = new JButton();
		btnCliente.setText("Cadastro Clientes");
		btnCliente.setPreferredSize(btnDimension);
		btnCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listener.showAddClienteView();
			}
		});
		panel.add(btnCliente);
		
		JButton btnServicos = new JButton();
		btnServicos.setText("Serviços");
		btnServicos.setPreferredSize(btnDimension);
		btnServicos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.showAddServicoView();
			}
		});
		panel.add(btnServicos);
		
		JButton btnListar = new JButton();
		btnListar.setText("Listar Clientes");
		btnListar.setPreferredSize(btnDimension);
		btnListar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.showListClienteView();
			}
		});
		panel.add(btnListar);
	}
	
}
