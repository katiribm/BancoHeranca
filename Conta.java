package BancoHeranca;

import java.util.ArrayList;
import java.util.List;

import java.text.NumberFormat;

public class Conta {
	
	private String correntista; 
	private int numero, agencia, tipoConta;
	
	private double saldo;
	
	private List<String> ListaExtratoConta = new ArrayList<String>();
	
	public Conta(String correntista, int numero, int agencia, int tipoConta) {
		this.correntista = correntista;
		this.numero = numero;
		this.agencia = agencia;
		this.tipoConta = tipoConta;
	} 
	
	public boolean calculaCedulas(double valor) {
		
		int[] cedulas = {200,100,50,20,10,5,2};
		System.out.println("Número de cédulas: ");
		for(int i = 0; i < cedulas.length; i++){
			if( valor >= cedulas[i]){
				System.out.println( (int)valor/cedulas[i] + " notas de " + cedulas[i]);
				valor = valor % cedulas[i];
			}}
		if (valor > 0) {
			System.out.println("Não é possivel sacar esse valor");
			return false;
		}else {
			
			return true;
		}
	}
	
	public void sacar(double saque, double taxa) {	
		
		if(this.saldo >= saque + taxa) {
			this.saldo = this.saldo - (saque + taxa); 
			System.out.println("Valor saque: " + NumberFormat.getCurrencyInstance().format(saque));
			ListaExtratoConta.add("Saque: - " + NumberFormat.getCurrencyInstance().format(saque));
			if (taxa != 0) {
				System.out.println("Taxa de saque: " + NumberFormat.getCurrencyInstance().format(taxa));
				ListaExtratoConta.add("Taxa de saque: - " + NumberFormat.getCurrencyInstance().format(taxa));
			}
			System.out.println("Novo Saldo: " + NumberFormat.getCurrencyInstance().format(saldo));
		}else if(saque<0){
			System.out.println("Não é possível fazer saques negativos");
		}else {
				System.out.println("Saldo indisponível para saque.");
		}
	}
		
	public void depositar(double deposito) {
		if(deposito>0) {
			this.saldo = this.saldo + deposito; 
			//this.depositos++; 
			System.out.println("Valor depositado: " + NumberFormat.getCurrencyInstance().format(deposito)); 
			System.out.println("Saldo: " + NumberFormat.getCurrencyInstance().format(saldo));
			ListaExtratoConta.add("Depósito: + " + NumberFormat.getCurrencyInstance().format(deposito));
		}else {
			System.out.println("Não é possível realizar depósitos negativos");
		}
	}
	
	public void extrato() {
			for (String extrato : ListaExtratoConta) {
			System.out.println(extrato);
		} mostrarSaldo();
	}
	
	public void mostrarSaldo() {
		System.out.println("Saldo: " + NumberFormat.getCurrencyInstance().format(saldo));
	}
	
	public void criarConta(String correntista, int numero, int agencia, int tipoConta) {
		this.correntista = correntista;
		this.agencia = agencia;
		this.numero = numero;
		this.setTipoConta(tipoConta);
	}
	
	public Boolean descontaTaxaExtrato(double taxa) {	
		
		if(this.saldo >= taxa) {
			this.saldo = this.saldo - taxa; 
			ListaExtratoConta.add("Taxa de impressão de extrato: - " + NumberFormat.getCurrencyInstance().format(taxa));
			return true;
		}else {
			System.out.println("Saldo indisponível para impressão de extrato.");
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Conta [correntista=" + this.correntista + ", agencia=" +this.agencia+ ", numero=" + this.numero + ", saldo=" + NumberFormat.getCurrencyInstance().format(this.saldo) +  " ]";
	}

	public int getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(int tipoConta) {
		this.tipoConta = tipoConta;
	}
}

