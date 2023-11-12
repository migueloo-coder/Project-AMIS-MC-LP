package Lab3_3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {
    private List<Conta> contas;
    private List<Movimento> movimentos;

    public Banco() {
        this.contas = new ArrayList<>();
        this.movimentos = new ArrayList<>();
    }

    public void criarConta(Conta conta) {
        contas.add(conta);
    }

    public void depositar(int numeroConta, double quantia) {
        Conta conta = encontrarConta(numeroConta);
        if (conta != null) {
            conta.depositar(quantia);
            movimentos.add(new Movimento(new Date(), "Depósito", quantia));
        }
    }

    public void levantar(int numeroConta, double quantia) throws SaldoInsuficienteException {
        Conta conta = encontrarConta(numeroConta);
        if (conta != null) {
            conta.levantar(quantia);
            movimentos.add(new Movimento(new Date(), "Levantamento", quantia));
        }
    }

    public double consultarSaldo(int numeroConta) {
        Conta conta = encontrarConta(numeroConta);
        return (conta != null) ? conta.consultarSaldo() : 0.0;
    }

    public void consultarUltimosMovimentos(int numeroConta) {
        Conta conta = encontrarConta(numeroConta);
        if (conta != null) {
            System.out.println("Últimos movimentos da conta " + numeroConta + ":");
            
            for (int i = Math.max(0, movimentos.size() - 5); i < movimentos.size(); i++) {
                System.out.println(movimentos.get(i));
            }
        }
    }

    private Conta encontrarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

}