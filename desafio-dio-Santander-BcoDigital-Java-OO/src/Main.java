import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String cliente="";
		int option = 99;
		Banco banco = new Banco();
		Cliente clienteDigitado = new Cliente();
		Conta cc = new ContaCorrente(clienteDigitado);
		Conta cp = new ContaPoupanca(clienteDigitado); 
		
		System.out.println("\n" + "Digite o nome do cliente: ");
		Scanner scan = new Scanner(System.in);
		cliente = scan.next();
		while (option != 0) {
			clienteDigitado.setNome(cliente);
			
			
			System.out.println("\n\nOlá " + cliente +", Digite o código da operação que deseja realizar ou \"0\" para finalizar: \n");
			System.out.println("1. Depósito conta-corrente");
			System.out.println("2. Depósito conta-poupança");
			System.out.println("3. Saque conta-corrente");
			System.out.println("4. Saque conta-poupança");
			System.out.println("5. Transferência conta-corrente para conta-poupança");
			System.out.println("6. Transferência conta-poupança para conta-corrente");
			System.out.println("7. Saldo da conta-corrente");
			System.out.println("8. Saldo da conta-poupança");
			option = scan.nextInt();
	
			if (option!=0) {
				double valor;
				switch (option) {
					case 0:
					break;
					case 1:
						System.out.println("digite o valor: ");
						valor = scan.nextDouble();
						cc.depositar(valor);
						
						System.out.printf("\n" + "*** Deposito na Conta Poupança no valor de: %.2f", valor);
					break;
					case 2:
						System.out.println("digite o valor: ");
						valor = scan.nextDouble();
						cp.depositar(valor);
						System.out.printf("\n" + "*** Deposito na Conta Poupança no valor de: %.2f", valor);
					break;
					case 3:
						System.out.println("digite o valor: ");
						valor = scan.nextDouble();
						cc.sacar(valor);
						System.out.printf("\n" + "*** Saque na Conta Corrente no valor de %.2f", valor);
					break;
					case 4:
						System.out.println("digite o valor: ");
						valor = scan.nextDouble();
						cp.sacar(valor);
						System.out.printf("\n" + "*** Saque na Conta Poupança no valor de %.2f", valor);
					break;
					case 5:
						System.out.println("digite o valor: ");
						valor = scan.nextDouble();
						cc.transferir(valor, cp);
						System.out.printf("\n" + "*** Transferência da Conta Corrente para Conta Poupança no valor de %.2f", valor);
					break;
					case 6:
						System.out.println("digite o valor: ");
						valor = scan.nextDouble();
						cp.transferir(valor, cc);
						System.out.printf("\n" + "*** Transferência da Conta Poupança para Conta Corrente no valor de %.2f", valor);
					break;
					case 7:
						cc.imprimirSaldo();
					break;
					case 8:
						cp.imprimirSaldo();
					break;
				}
			}
		}
		System.out.println("\n" + "Aplicação encerrada.");
		scan.close();
	}
}
