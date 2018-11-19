package br.edu.univas.model;

import java.sql.Time;
import java.util.Date;

public class Servico {

	private String codigo;
	private String codCliente;
	private String nomeCliente;
	private String codCarro;
	private String status;
	private String dataEntrada;
	private String dataSaida;
	private float valorFinal;
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getCodCliente() {
		return codCliente;
	}
	
	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
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
	
	public float getValorFinal() {
		return valorFinal;
	}
	
	public void setValorFinal(float valorFinal) {
		this.valorFinal = valorFinal;
	}
	
}
