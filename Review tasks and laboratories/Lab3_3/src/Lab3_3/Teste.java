package Lab3_3;


import java.util.Date;


import javax.swing.JOptionPane;

public class Teste {
	public static void main(String[] args) {
		
        Banco banco = new Banco();
        

        ContaNormal contaNormal = new ContaNormal(187557558, "Titular Normal", new Date(), 1000.0);
        ContaVencimento contaVencimento = new ContaVencimento(2, "Titular Vencimento", new Date(), 500.0, 200.0);
        ContaPrazo contaPrazo = new ContaPrazo(3, "Titular Prazo", new Date(), 2000.0, 0.05);

        banco.criarConta(contaNormal);
        banco.criarConta(contaVencimento);
        banco.criarConta(contaPrazo);

        exibirMenu(banco);
    }

    public static void exibirMenu(Banco banco) {
        int op;
        do {
            String menu = "Escolha uma opção:\n" +
                          "1. Depositar\n" +
                          "2. Levantar\n" +
                          "3. Consultar Saldo\n" +
                          "4. Consultar Últimos Movimentos\n" +
                          "0. Sair";
            
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (op) {
                case 1:
                    int numeroContaDeposito = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta para depósito:"));
                    double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do depósito:"));
                    banco.depositar(numeroContaDeposito, valorDeposito);
                    JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
                    break;

                case 2:

                    try {
                        int numeroContaLevantamento = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta para levantamento:"));
                        double valorLevantamento = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do levantamento:"));
                        banco.levantar(numeroContaLevantamento, valorLevantamento);
                        JOptionPane.showMessageDialog(null, "Levantamento realizado com sucesso!");
                    } catch (SaldoInsuficienteException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 3:

                    int numeroContaConsulta = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta para consulta de saldo:"));
                    double saldoConta = banco.consultarSaldo(numeroContaConsulta);
                    JOptionPane.showMessageDialog(null, "Saldo da conta: " + saldoConta);
                    break;

                case 4:

                    int numeroContaMovimentos = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta para consulta de últimos movimentos:"));
                    banco.consultarUltimosMovimentos(numeroContaMovimentos);
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo do programa.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } while (op != 0);
    }
}

	



