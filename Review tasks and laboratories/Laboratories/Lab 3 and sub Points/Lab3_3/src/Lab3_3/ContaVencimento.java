package Lab3_3;

import java.util.Date;

public class ContaVencimento extends Conta {
    private double limiteNegativo;

    public ContaVencimento(int numero, String titular, Date dataAbertura, double saldo, double limiteNegativo) {
        super(numero, titular, dataAbertura, saldo);
        this.limiteNegativo = limiteNegativo;
    }

    @Override
    public void levantar(double quantia) throws SaldoInsuficienteException {
        if (saldo - quantia < -limiteNegativo) {
            throw new SaldoInsuficienteException("Excedido o limite de levantamento.");
        }
        saldo -= quantia;
    }
}
