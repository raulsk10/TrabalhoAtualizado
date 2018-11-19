package br.edu.univas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.edu.univas.model.Servico;

public class ServicoDAO {

private Connection connection;

	public ServicoDAO() {
		connection = ConnectionUtil.getConnection();
	}
	
	public void save(Servico servico) {
		String sql = "insert into servico (codCliente, codCarro, status, dataEntrada, dataSaida, valorFinal) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		int index = 1;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(index++, servico.getCodCliente());
			statement.setString(index++, servico.getCodCarro());
			statement.setString(index++, servico.getStatus());
			statement.setString(index++, servico.getDataEntrada());
			statement.setString(index++, servico.getDataSaida());
			statement.setFloat(index++, servico.getValorFinal());
			
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizaStatus(String codServico) {
		String sql = "update servico set status = 'F'"
				+ "where codigo = '" + codServico + "'";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Servico> filtraTabela(String filtro, String ordem) {
		ArrayList<Servico> data = new ArrayList<>();
		String sql;
		
		sql = "select s.codigo, s.codcliente, c.nome , s.codcarro, s.status, s.dataentrada, s.datasaida, s.valorfinal"
				+ " from servico as s join cliente as c on s.codcliente = c.cpf";
		if (filtro.equals("1"))
			sql = sql + " where status = 'A'";
		else 
		if (filtro.equals("2"))
			sql = sql + " where status = 'F'";
		
		if (ordem.equals("0"))
			sql = sql + " order by nome";
		else
			sql = sql + " order by codigo";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				Servico servico = new Servico();
				servico.setCodigo(resultSet.getString("codigo"));
				servico.setCodCliente(resultSet.getString("codCliente"));
				servico.setNomeCliente(resultSet.getString("nome"));
				servico.setCodCarro(resultSet.getString("codCarro"));
				servico.setStatus(resultSet.getString("status"));
				servico.setDataEntrada(resultSet.getString("dataEntrada"));
				servico.setDataSaida(resultSet.getString("dataSaida"));
				servico.setValorFinal(resultSet.getFloat("valorFinal"));
				
				data.add(servico);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return data;
	}
	
	public ArrayList<Servico> getAll() {
		ArrayList<Servico> data = new ArrayList<>();
		
		String sql = "select s.codigo, s.codcliente, c.nome, s.codcarro, s.status, s.dataentrada, s.datasaida, s.valorfinal"
				+ " from servico as s join cliente as c on s.codcliente = c.cpf"
				+ " order by codigo";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				Servico servico = new Servico();
				servico.setCodigo(resultSet.getString("codigo"));
				servico.setCodCliente(resultSet.getString("codCliente"));
				servico.setNomeCliente(resultSet.getString("nome"));
				servico.setCodCarro(resultSet.getString("codCarro"));
				servico.setStatus(resultSet.getString("status"));
				servico.setDataEntrada(resultSet.getString("dataEntrada"));
				servico.setDataSaida(resultSet.getString("dataSaida"));
				servico.setValorFinal(resultSet.getFloat("valorFinal"));
				
				data.add(servico);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return data;
	}
}
