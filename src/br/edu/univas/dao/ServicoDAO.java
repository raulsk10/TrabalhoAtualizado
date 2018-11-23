package br.edu.univas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.edu.univas.model.Servico;

public class ServicoDAO {

private Connection connection;
private String horaSaida;

	public ServicoDAO() {
		connection = ConnectionUtil.getConnection();
	}
	
	public void save(Servico servico) {
		String sql = "insert into servico (codCliente, codCarro, status, dataEntrada, dataSaida, valorFinal) "
				+ "values (?, ?, ?, ?, ?, ?)";
		
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SSS");
	    Date parsedDate = null;
		try {
			parsedDate = dateFormat.parse(servico.getDataEntrada()+":00.0");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
	    
	    String[] cliente = servico.getCodCliente().toString().split(" - ");
		
		int index = 1;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(index++, cliente[1]);
			statement.setString(index++, servico.getCodCarro());
			statement.setString(index++, "A");
			statement.setTimestamp(index++, timestamp);
			statement.setTimestamp(index++, timestamp);
			statement.setFloat(index++, 0);
			
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizaServico(String codServico, float preco, String horaEntrada) {
		int horas = calculaHoras(horaEntrada);
		float precoFinal = preco * horas;
		
		String sql = "update servico set status = 'F'"
				+ ", valorfinal = '" + precoFinal + "'"
				+ ", dataSaida = '" + horaSaida + "'"
				+ "where codigo = '" + codServico + "'";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int calculaHoras(String horaEntrada) {
		int horas = 0;
		
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		horaSaida = ts+"";
		
		String sql = "select ROUND("
				+ "EXTRACT( EPOCH FROM timestamp '"+horaSaida+"' - timestamp '"+horaEntrada+"' ) / 3600)"
				+ " as horas;";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				horas = resultSet.getInt("horas");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return horas;
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
			sql = sql + " order by codigo";
		else
			sql = sql + " order by nome";
		
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
