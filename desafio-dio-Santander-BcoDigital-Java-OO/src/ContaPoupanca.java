
public class ContaPoupanca extends Conta {
	
	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirSaldo() {
		System.out.println("\n" + "------------------------------");
		System.out.println("=== Saldo Conta Poupança ===");
		super.imprimirInfosComuns();
	}

	
}
