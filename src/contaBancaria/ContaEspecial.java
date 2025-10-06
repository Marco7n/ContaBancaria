package contaBancaria;

import java.util.ArrayList;
import java.util.List;

public class ContaEspecial extends ContaBancaria{
	List<ContaEspecial> contasE = new ArrayList<>();
	private double LimiteCredito;
	public ContaEspecial() {
		
	}
	public ContaEspecial(String numero, double saldo, Cliente titular, double limite) {
		super(numero,saldo, titular);
		
		setLimite(limite);
	}
	public double getLimite() {
		return LimiteCredito;
	}
	public void setLimite(double limiteCredito) {
		LimiteCredito = limiteCredito;
	}
	
	public void sacar(double valor) {
		if(valor <= 0) {
			throw new IllegalArgumentException("Valor de saque deve ser maior que zero");
		}
		if(LimiteCredito <= 0) {
			throw new IllegalArgumentException("Seu limite está negativo!!");
		}
		LimiteCredito -= valor;
	}
}
