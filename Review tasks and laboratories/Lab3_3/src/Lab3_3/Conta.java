package Lab3_3;

import java.util.Date;


public class Conta {
	    private int numero;
	    private String titular;
	    private Date dataAbertura;
	    protected double saldo; 

	    public Conta(int numero, String titular, Date dataAbertura, double saldo) {
	        this.numero = numero;
	        this.titular = titular;
	        this.dataAbertura = dataAbertura;
	        this.saldo = saldo;
	    }

	    public void depositar(double quantia) {
	        saldo += quantia;
	    }

	    public void levantar(double quantia) throws SaldoInsuficienteException {
	        if (this instanceof ContaNormal && saldo - quantia < 0) {
	            throw new SaldoInsuficienteException("Saldo insuficiente para levantamento.");
	        }
	        saldo -= quantia;
	    }

	    public double consultarSaldo() {
	        return saldo;
	    }

	    public int getNumero() {
	        return numero;
	    }

	    public String getTitular() {
	        return titular;
	    }

}
