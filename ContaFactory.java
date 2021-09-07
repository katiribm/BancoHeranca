package BancoHeranca;

import java.util.*;

public class ContaFactory {

	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in); 
		System.out.println("Informe o nome do correntista:");
		String correntista = sc.nextLine(); 
		System.out.println("Informe a agência:");
		int agencia = sc.nextInt(); 
		System.out.println("Informe o número da conta: ");
		int numero = sc.nextInt(); 		
		System.out.println("Informe o tipo da conta (1 - Conta Corrente / 2 - Conta Poupança)");
		int tipoConta = sc.nextInt(); 		
		
		//Conta conta = new Conta(correntista, numero, agencia, tipoConta);
		ContaCorrente CC = new ContaCorrente(correntista, numero, agencia, tipoConta);
		ContaPoupanca CP = new ContaPoupanca(correntista, numero, agencia, tipoConta);
		
		int opcao; 
		
		do {
			System.out.println("===================");
			System.out.println("Menu Internet Banking");
			System.out.println("1 - Mostrar saldo");
			System.out.println("2 - Extrato");
			System.out.println("3 - Sacar");
			System.out.println("4 - Depósito");
			System.out.println("0 - Encerrar");
			System.out.println("Informe sua opção: \n");
			opcao = sc.nextInt(); 
			
			switch (opcao) {
			case 1 :
				//conta.mostrarSaldo();
				if (tipoConta == 1) CC.mostrarSaldo();
				else CP.mostrarSaldo();
			break;
				
			case 2 :
				System.out.println("Imprimir extrato de movimentações (S/N): ");
				String informaExtrato = sc.next();
				if("S".equals(informaExtrato)) {
					if (tipoConta == 1) CC.extrato();
					else CP.extrato();
				}
				break;
				
			case 3 :
				System.out.println("Digite o valor do saque: ");
				double valor = sc.nextDouble();
				if(valor>0) {
					boolean cedulaResult = false;
					if (tipoConta == 1) {
						cedulaResult = CC.calculaCedulas(valor);
						if (cedulaResult == true) CC.sacar(valor, 0);
					} else {
						cedulaResult = CP.calculaCedulas(valor);
						if (cedulaResult == true) CP.sacar(valor, 0);
					}
					
				}else {
					System.out.println("Não é possível sacar valores negativos");
				}
				break;
		
			case 4 :
				System.out.println("Digite o valor do depósito: ");
				double deposito = sc.nextDouble();
				if (tipoConta == 1) CC.depositar(deposito);
				else CP.depositar(deposito);
				break;
				
			case 0 :
				System.out.println("Programa encerrado");
				break;

			default:
				System.out.println("Opção inválida");
				break;
			}
		}while (opcao!=0); 
		
		if (tipoConta == 1) System.out.println(CC);
		else System.out.println(CP);
		
		sc.close(); 
	}

}
