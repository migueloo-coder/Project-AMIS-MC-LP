package Lab3_3;

import java.util.Date;

public class ContaPrazo extends Conta {
    private double taxaJuros;

    public ContaPrazo(int numero, String titular, Date dataAbertura, double saldo, double taxaJuros) {
        super(numero, titular, dataAbertura, saldo);
        this.taxaJuros = taxaJuros;
    }

    public void aplicarJuros() {
        saldo *= (1 + taxaJuros);
    }
}