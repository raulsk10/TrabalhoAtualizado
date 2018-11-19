package br.edu.univas.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import br.edu.univas.model.Cliente;

public class ListClientePanel extends JPanel {

private JTable table;
	
	public ListClientePanel() {
		addComponents();
	}
	
	private void addComponents() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel headerLabel = new JLabel();
		headerLabel.setText("Clientes Cadastrados");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(headerLabel, gbc);
		
		Vector<String> columns = new Vector<>();
		columns.add("Nome");
		columns.add("CPF");
		columns.add("E-mail");
		columns.add("Telefone");
	
		table = new JTable(null, columns);
		table.setEnabled(false);
		
		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(0, 10, 10, 10);
		this.add(tableScrollPane, gbc);
	}

	public void updateClientes(ArrayList<Cliente> clientes) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		model.setRowCount(0);
		
		for (Cliente cliente : clientes) {
			model.addRow(new Object[] {
					cliente.getNome(),
					cliente.getCpf(),
					cliente.getEmail(),
					cliente.getTelefone()
			});
		}
	}
}
