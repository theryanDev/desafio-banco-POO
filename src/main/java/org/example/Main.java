package org.example;

import org.example.conta.Conta;
import org.example.conta.ContaCorrente;
import org.example.conta.ContaPoupanca;
import org.example.model.Cliente;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite o nome do cliente:");
		String nomeCliente = scanner.nextLine();
		System.out.println("Digite o cpf do cliente:");
		String cpf = scanner.nextLine();

		Cliente cliente = new Cliente(nomeCliente, cpf);

		Conta cc = new ContaCorrente(cliente);
		Conta poupanca = new ContaPoupanca(cliente);
		poupanca.setAgencia(cc.getAgencia());
		poupanca.setNumero(cc.getNumero());

		System.out.println("Digite a quantidade a ser depositada na conta corrente:");
		double valorDeposito = scanner.nextDouble();
		cc.depositar(valorDeposito);

		System.out.println("Digite a quantidade a ser transferida para a conta poupança:");
		double valorTransferencia = scanner.nextDouble();
		cc.transferir(valorTransferencia, poupanca);

		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

		scanner.close();
	}
}