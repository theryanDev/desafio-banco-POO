package org.example.conta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.Cliente;

import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Conta implements IConta {
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	private static final Random RANDOM = new Random();

	public Conta(Cliente cliente) {
		this.cliente = cliente;
		this.agencia = generateRandomNumber();
		this.numero = generateRandomNumber();
	}

	private int generateRandomNumber() {
		return RANDOM.nextInt(100000);
	}

	@Override
	public void sacar(double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			System.out.println("Saque de " + valor + " realizado com sucesso.");
		} else {
			System.out.println("Saldo insuficiente para realizar o saque.");
		}
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		System.out.println("Depósito de " + valor + " realizado com sucesso.");
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		if (saldo >= valor) {
			this.sacar(valor);
			contaDestino.depositar(valor);
			System.out.println("Transferência de " + valor + " realizada com sucesso.");
		} else {
			System.out.println("Saldo insuficiente para realizar a transferência.");
		}
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
