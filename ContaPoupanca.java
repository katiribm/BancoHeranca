package BancoHeranca;

public class ContaPoupanca extends Conta{

	public ContaPoupanca(String correntista, int numero, int agencia, int tipoConta) {
		super(correntista, numero, agencia, tipoConta);
	}
	
	@Override
	public void criarConta(String correntista, int numero, int agencia, int tipoConta) {
		super.criarConta(correntista, numero, agencia, 2);
	}
	
	@Override
	public void sacar(double saque, double taxa) {
		taxa = saque * 3 / 100;
		super.sacar(saque, taxa);
	}
	
	@Override
	public void extrato() {
		double valorTaxa = 2.00;
		// TODO Auto-generated method stub
		var resultado = super.descontaTaxaExtrato(valorTaxa);
		if (resultado) super.extrato();
	}
}
