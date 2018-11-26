package br.edu.univas.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.edu.univas.listener.TrocaTelaListener;

public class MainView extends JFrame {
	
	private TrocaTelaListener listener;
	private JPanel centerPanel;

	public MainView() {
		this.setTitle("");
		this.setSize(1150, 500);
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
		this.setIconImage(new ImageIcon("resources/carro.png").getImage());
		
		JPanel northPanel = new JPanel();
		northPanel.setBackground(new Color(204, 229, 255));
		addNorthButtons(northPanel);
		this.getContentPane().add(northPanel, BorderLayout.NORTH);
		
		JPanel southPanel = new JPanel();
		southPanel.setBackground(new Color(204, 229, 255));
		addSouthButtons(southPanel);
		this.getContentPane().add(southPanel, BorderLayout.SOUTH);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
	}
	
	public void addNorthButtons(JPanel panel) {
		JLabel lblTitulo = new JLabel(new ImageIcon("resources/carro.png"));
		lblTitulo.setText("Controle de Entrada e Saída de Veículos");
		lblTitulo.setFont(new Font("Serif", Font.PLAIN, 28));
		panel.add(lblTitulo);
		
		/*JButton btnSair = new JButton("Sair");
		btnSair.setPreferredSize(new Dimension(64, 30));
		panel.add(btnSair);*/
	}
	
	public void addSouthButtons(JPanel panel) {
		Dimension btnDimension = new Dimension(190, 50);
		
		JButton btnCliente = new JButton(new ImageIcon("resources/cliente.png"));
		btnCliente.setText("Cadastro Clientes");
		btnCliente.setPreferredSize(btnDimension);
		btnCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listener.showAddClienteView();
			}
		});
		panel.add(btnCliente);
		
		JButton btnCarro = new JButton(new ImageIcon("resources/carro.png"));
		btnCarro.setText("Cadastro Carros");
		btnCarro.setPreferredSize(btnDimension);
		btnCarro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listener.showAddCarroView();
			}
		});
		panel.add(btnCarro);
		
		JButton btnServicos = new JButton(new ImageIcon("resources/servico.png"));
		btnServicos.setText("Cadastro Serviços");
		btnServicos.setPreferredSize(btnDimension);
		btnServicos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.showAddServicoView();
			}
		});
		panel.add(btnServicos);
		
		JButton btnListarClientes = new JButton(new ImageIcon("resources/cliente.png"));
		btnListarClientes.setText("Listar Clientes");
		btnListarClientes.setPreferredSize(btnDimension);
		btnListarClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.showListClienteView();
			}
		});
		panel.add(btnListarClientes);
		
		JButton btnListarServicos = new JButton(new ImageIcon("resources/servico.png"));
		btnListarServicos.setText("Listar Serviços");
		btnListarServicos.setPreferredSize(btnDimension);
		btnListarServicos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.showListServicoView();
			}
		});
		panel.add(btnListarServicos);
	}
	
}
