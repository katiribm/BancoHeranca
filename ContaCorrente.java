package BancoHeranca;

public class ContaCorrente extends Conta{

	public ContaCorrente(String correntista, int numero, int agencia, int tipoConta) {
		super(correntista, numero, agencia, tipoConta);
	}
	
	@Override
	public void criarConta(String correntista, int numero, int agencia, int tipoConta) {
		
		super.criarConta(correntista, numero, agencia, 1);
	}
	
	@Override
	public void sacar(double saque, double taxa) {
		taxa = saque * 2 / 100;
		super.sacar(saque, taxa);
	}
}
