package br.edu.univas.model;

import java.util.Date;

public class Servico {

	private String codCliente;
	private String codCarro;
	private String status;
	private Date dataEntrada;
	private Date dataSaida;
	private float valorFinal;
	
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
	
	public Date getDataEntrada() {
		return dataEntrada;
	}
	
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	public Date getDataSaida() {
		return dataSaida;
	}
	
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	public float getValorFinal() {
		return valorFinal;
	}
	
	public void setValorFinal(float valorFinal) {
		this.valorFinal = valorFinal;
	}
	
}
