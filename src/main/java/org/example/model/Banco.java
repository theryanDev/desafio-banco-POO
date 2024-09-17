package org.example.model;

import lombok.Getter;
import org.example.conta.Conta;

import java.util.List;

@Getter
public class Banco {

	private String nome;
	private List<Conta> contas;
}
