package br.edu.univas.model;

import java.util.Date;

public class Servico {

	private String codCliente;
	private String codCarro;
	private String status;
	private String dataEntrada;
	private String dataSaida;
	private String valorFinal;
	
	public String getCodCliente() {
		return codCliente;
	}
	
	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}
	
	public String getCodCarro() {
		return codCarro;
	}
	
	public void setCodCarro(String codCarro) {
		this.codCarro = codCarro;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getDataEntrada() {
		return dataEntrada;
	}
	
	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	public String getDataSaida() {
		return dataSaida;
	}
	
	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	public String getValorFinal() {
		return valorFinal;
	}
	
	public void setValorFinal(String valorFinal) {
		this.valorFinal = valorFinal;
	}
	
}
