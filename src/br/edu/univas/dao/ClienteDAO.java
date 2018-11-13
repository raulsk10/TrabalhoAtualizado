package br.edu.univas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.univas.model.Cliente;

public class ClienteDAO {

	private Connection connection;
	
	public ClienteDAO() {
		connection = ConnectionUtil.getConnection();
	}
	
	public void save(Cliente cliente) {
		String sql = "insert into cliente (nome, cpf, email, telefone) "
				+ "values (?, ?, ?, ?)";
		
		int index = 1;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(index++, cliente.getNome());
			statement.setString(index++, cliente.getCpf());
			statement.setString(index++, cliente.getEmail());
			statement.setString(index++, cliente.getTelefone());
			
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Cliente> getAll() {
		ArrayList<Cliente> data = new ArrayList<>();
		
		String sql = "select * from cliente";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setEmail(resultSet.getString("email"));
				cliente.setTelefone(resultSet.getString("telefone"));
				
				data.add(cliente);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return data;
	}
}
