package br.edu.univas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.univas.model.Servico;

public class ServicoDAO {

private Connection connection;
	
	public ServicoDAO() {
		connection = ConnectionUtil.getConnection();
	}
	
	public void save(Servico servico) {
		String sql = "insert into servico (codCliente, codCarro, status, dataEntrada, dataSaida, valorFinal) "
				+ "values (?, ?, ?, ?, ?, ?)";
		
		int index = 1;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(index++, servico.getCodCliente());
			statement.setString(index++, servico.getCodCarro());
			statement.setString(index++, servico.getStatus());
			statement.setDate(index++, servico.getDataEntrada());
			statement.setDate(index++, servico.getDataEntrada());
			statement.setFloat(index++, servico.getValorFinal());
			
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Servico> getAll() {
		ArrayList<Servico> data = new ArrayList<>();
		
		String sql = "select * from servico";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				Servico servico = new Servico();
				servico.setCodCliente(resultSet.getString("codCliente"));
				servico.setCodCarro(resultSet.getString("codCarro"));
				servico.setStatus(resultSet.getString("status"));
				servico.setDataEntrada(resultSet.getDate("dataEntrada"));
				servico.setDataSaida(resultSet.getDate("dataSaida"));
				servico.setValorFinal(resultSet.getFloat("valorFinal"));
				
				data.add(servico);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return data;
	}
}
