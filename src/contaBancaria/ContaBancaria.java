package contaBancaria;

import java.util.ArrayList;
import java.util.List;
public class ContaBancaria{
	private String numero;
	private double saldo; 
	private Cliente titular;
	List<ContaBancaria> contas = new ArrayList<>();
	public ContaBancaria() {
		
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public void depositar(double valor) {
		if(valor <= 0) {
			  throw new IllegalArgumentException("Valor do deposito deve ser maior que 0");
		}
		saldo += valor;
	}
	
	public void sacar(double valor) {
	    if (valor <= 0) {
	        throw new IllegalArgumentException("Valor do saque deve ser maior que 0");
	    }
	    if (valor > saldo) {
	        throw new IllegalArgumentException("Saldo insuficiente");
	    }
	    saldo -= valor;
	}

	public void transferir(double valor, ContaBancaria contaDestino) {
		if(valor <= 0) {
			throw new IllegalArgumentException("Valor da tranferencia deve ser maior que 0");
		}
		if(valor > saldo) {
			throw new IllegalArgumentException("Saldo em conta é insuficiente");
		}
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	public ContaBancaria(String numero, double saldo, Cliente titular) {
		this.numero = numero;
		this.saldo = saldo;
		this.titular = titular;
			}
	
	public String toString() {
	    return "Número: " + numero +
	           ", Titular: " + titular.getNome() +
	           ", Saldo: " + saldo;
	}
}
