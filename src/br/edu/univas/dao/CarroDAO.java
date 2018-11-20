package br.edu.univas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.univas.model.Carro;

public class CarroDAO {
	
private Connection connection;
	
	public CarroDAO() {
		connection = ConnectionUtil.getConnection();
	}
	
	public void save(Carro carro) {
		String sql = "insert into carro (codCliente, modelo, placa, cor) "
				+ "values (?, ?, ?, ?)";
		
		int index = 1;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(index++, carro.getCodCliente());
			statement.setString(index++, carro.getModelo());
			statement.setString(index++, carro.getPlaca());
			statement.setString(index++, carro.getCor());
			
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getPlacas(String cliente){
		ArrayList<String> placas = new ArrayList<>();
		
		String sql = "select placa from carro where codcliente = '" + cliente + "'";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				placas.add(resultSet.getString("placa"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return placas;
	}

	
	public ArrayList<Carro> getAll() {
		ArrayList<Carro> data = new ArrayList<>();
		
		String sql = "select * from carro";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				Carro carro = new Carro();
				carro.setCodCliente(resultSet.getString("codCliente"));
				carro.setModelo(resultSet.getString("modelo"));
				carro.setPlaca(resultSet.getString("placa"));
				carro.setCor(resultSet.getString("cor"));
				
				data.add(carro);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return data;
	}
}
