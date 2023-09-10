package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import model.entidades.Conta;
import model.excecoes.MyException;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Insira os dados da conta");
		System.out.print("Numero da conta: ");
		Integer numero = sc.nextInt();
		System.out.print("Nome do titular: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.print("Saldo inicial da conta: $ ");
		double saldo = sc.nextDouble();
		System.out.print("Limite de saque: $");
		double limite = sc.nextDouble();
		Conta conta = new Conta(numero, nome, saldo, limite);
		
		System.out.println();
		System.out.print("Informe uma quantia para sacar: ");
		double valor = sc.nextDouble();
		
		try {
			conta.saque(valor);
			System.out.printf("Novo saldo: %.2f%n", conta.getSaldo());
		}
		catch (MyException x) {
			System.out.println(x.getMessage());
		}

		sc.close();
	}

}
