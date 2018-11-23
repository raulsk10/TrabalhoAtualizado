package br.edu.univas.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import br.edu.univas.dao.ServicoDAO;
import br.edu.univas.model.Servico;

public class ListServicoPanel extends JPanel {

	private JTable table;
	private GridBagConstraints gbc;
	private ServicoDAO dao;
	private JTextField txtValorHora;
	
	public ListServicoPanel() {
		addComponents();
	}
	
	private void addComponents() {
		this.setLayout(new BorderLayout());
		
		JPanel westPanel = new JPanel();
		addWestComponents(westPanel);
		westPanel.setPreferredSize(new Dimension(750, 0));
		this.add(westPanel, BorderLayout.WEST);
		
		JPanel eastPanel = new JPanel();
		addEastComponents(eastPanel);
		eastPanel.setPreferredSize(new Dimension(150, 0));
		this.add(eastPanel, BorderLayout.EAST);
	}
	
	public void addWestComponents(JPanel content) {
		content.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		JLabel headerLabel = new JLabel();
		headerLabel.setText("Serviços Cadastrados");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		content.add(headerLabel, gbc);
		
		Vector<String> columns = new Vector<>();
		columns.add("Código");
		columns.add("Cód. Cliente");
		columns.add("Nome Cliente");
		columns.add("Carro");
		columns.add("Status");
		columns.add("Entrada");
		columns.add("Saída");
		columns.add("Valor");
	
		table = new JTable(null, columns);
		
		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(0, 10, 5, 10);
		content.add(tableScrollPane, gbc);
	}
	
	public void addEastComponents(JPanel content) {
		content.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Insets insets = new Insets(0, 7, 0, 5);
		
		JLabel lblFiltrar = new JLabel();
		lblFiltrar.setText("Filtrar por:");
		gbc = new GridBagConstraints();
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.weightx = 1.0;
		gbc.insets = insets;
		content.add(lblFiltrar, gbc);
		
		JRadioButton rbTodos = new JRadioButton();
		rbTodos.setText("Todos");
		rbTodos.setSelected(true);
		rbTodos.setActionCommand("0");
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = insets;
		content.add(rbTodos, gbc);
		
		
		JRadioButton rbAberto = new JRadioButton();
		rbAberto.setText("Aberto");
		rbAberto.setActionCommand("1");
		gbc = new GridBagConstraints();
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = insets;
		content.add(rbAberto, gbc);
		
		JRadioButton rbFechado = new JRadioButton();
		rbFechado.setText("Fechado");
		rbFechado.setActionCommand("2");
		gbc = new GridBagConstraints();
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = insets;
		content.add(rbFechado, gbc);
		
		ButtonGroup gpFiltrar = new ButtonGroup();
		gpFiltrar.add(rbTodos);
		gpFiltrar.add(rbAberto);
		gpFiltrar.add(rbFechado);
		
		JLabel lblOrdem = new JLabel();
		lblOrdem.setText("Ordenar por:");
		gbc = new GridBagConstraints();
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(10, 7, 0 , 5);
		content.add(lblOrdem, gbc);
		
		JRadioButton rbCodigo = new JRadioButton();
		rbCodigo.setText("Código");
		rbCodigo.setSelected(true);
		rbCodigo.setActionCommand("0");
		gbc = new GridBagConstraints();
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = insets;
		content.add(rbCodigo, gbc);
		
		JRadioButton rbNome = new JRadioButton();
		rbNome.setText("Nome");
		rbNome.setActionCommand("1");
		gbc = new GridBagConstraints();
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = insets;
		content.add(rbNome, gbc);
		
		ButtonGroup gpOrdem = new ButtonGroup();
		gpOrdem.add(rbNome);
		gpOrdem.add(rbCodigo);
		
		gbc = new GridBagConstraints();
		JButton btnFiltrar = new JButton();
		btnFiltrar.setText("Filtrar");
		btnFiltrar.setPreferredSize(new Dimension(128, 20));
		btnFiltrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dao = new ServicoDAO();
				String filtro = gpFiltrar.getSelection().getActionCommand();
				String ordem = gpOrdem.getSelection().getActionCommand();
				updateServicos(dao.filtraTabela(filtro, ordem));
			}
		});
		gbc.gridy = 7;
		gbc.insets = new Insets(15, 5, 5, 5);
		content.add(btnFiltrar, gbc);
		
		gbc = new GridBagConstraints();
		JButton btnFinalizar = new JButton();
		btnFinalizar.setText("Finalizar Serviço");
		btnFinalizar.setPreferredSize(new Dimension(128, 20));
		btnFinalizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				finalizaServico();
			}
		});
		gbc.gridy = 8;
		gbc.insets = new Insets(15, 5, 5, 5);
		content.add(btnFinalizar, gbc);
		
		gbc = new GridBagConstraints();
		JLabel lblValorHora = new JLabel("Preço da Hora:");
		gbc.gridy = 9;
		gbc.insets = new Insets(0, 5, 0, 5);
		content.add(lblValorHora, gbc);
		
		gbc = new GridBagConstraints();
		txtValorHora = new JTextField();
		txtValorHora.setColumns(4);
		gbc.gridy = 10;
		gbc.insets = new Insets(5, 5, 5, 5);
		content.add(txtValorHora, gbc);
	}
	
	public void finalizaServico() {
		dao = new ServicoDAO();
		String codServico;
		String status;
		String linhas = table.getModel().getRowCount()+"";
		float preco = 0;
		try {
			preco = Float.parseFloat(txtValorHora.getText().toString());
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Por favor corrija o preço!", "Finalizar Serviço", JOptionPane.ERROR_MESSAGE);
		}
				
		if (!linhas.equals("0")){
			codServico = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
			status = table.getModel().getValueAt(table.getSelectedRow(), 4).toString();
			String horaEntrada = table.getModel().getValueAt(table.getSelectedRow(), 5).toString();
			if (status.equals("F")) {
				JOptionPane.showMessageDialog(null, "Este serviço já está fechado!", "Finalizar Serviço", JOptionPane.ERROR_MESSAGE);
			} else {
				if (!txtValorHora.getText().toString().equals("")) {
					dao.atualizaServico(codServico, preco, horaEntrada);
					updateServicos(dao.getAll());
				} else 
					JOptionPane.showMessageDialog(null, "Campo de preço vazio!", "Finalizar Serviço", JOptionPane.WARNING_MESSAGE);
			}
		} else
			JOptionPane.showMessageDialog(null, "Tabela vazia!", "Finalizar Serviço", JOptionPane.WARNING_MESSAGE);
	}
	
	public void updateServicos(ArrayList<Servico> servicos) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		model.setRowCount(0);
		
		for (Servico servico: servicos) {
			model.addRow(new Object[] {
					servico.getCodigo(),
					servico.getCodCliente(),
					servico.getNomeCliente(),
					servico.getCodCarro(),
					servico.getStatus(),
					servico.getDataEntrada(),
					servico.getDataSaida(),
					servico.getValorFinal()
			});
		}
		if (!servicos.isEmpty())
			table.setRowSelectionInterval(0, 0);
	}
}
