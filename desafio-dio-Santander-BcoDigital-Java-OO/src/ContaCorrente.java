
public class ContaCorrente extends Conta{

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirSaldo() {
		System.out.println("\n" + "------------------------------");
		System.out.println("=== Saldo Conta Corrente ===");
		super.imprimirInfosComuns();
	}

}
