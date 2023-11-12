package lab3;


import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Veiculo> veiculos = new ArrayList<>();

        exibirMenu(veiculos);
    }

    private static void exibirMenu(List<Veiculo> veiculos) {
        int opcao;
        do {
            String menu = "Escolha uma opção:\n" +
                          "1. Adicionar Carro\n" +
                          "2. Adicionar Bicicleta\n" +
                          "3. Aplicar Desconto\n" +
                          "4. Mostrar Detalhes dos Veículos\n" +
                          "5. Mostrar Detalhes Agrupados por Tipo\n" +
                          "6. Mostrar Detalhes Ordenados por Marca\n" +
                          "0. Sair";

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    adicionarCarro(veiculos);
                    break;
                case 2:
                    adicionarBicicleta(veiculos);
                    break;
                case 3:
                    aplicarDesconto(veiculos);
                    break;
                case 4:
                    mostrarDetalhesVeiculos(veiculos);
                    break;
                case 5:
                    mostrarDetalhesAgrupadosPorTipo(veiculos);
                    break;
                case 6:
                    mostrarDetalhesOrdenadosPorMarca(veiculos);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo do programa.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } while (opcao != 0);
    }

    private static void adicionarCarro(List<Veiculo> veiculos) {
        String marca = JOptionPane.showInputDialog("Digite a marca do carro:");
        double precoAluguer = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço de aluguer do carro:"));
        String modelo = JOptionPane.showInputDialog("Digite o modelo do carro:");
        double quilometragem = Double.parseDouble(JOptionPane.showInputDialog("Digite a quilometragem do carro:"));

        veiculos.add(new Carro(marca, precoAluguer, modelo, quilometragem));

        JOptionPane.showMessageDialog(null, "Carro adicionado com sucesso!");
    }

    private static void adicionarBicicleta(List<Veiculo> veiculos) {
        String marca = JOptionPane.showInputDialog("Digite a marca da bicicleta:");
        double precoAluguer = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço de aluguer da bicicleta:"));
        boolean eletrica = JOptionPane.showInputDialog("A bicicleta é elétrica? (Sim/Não)").equalsIgnoreCase("Sim");

        veiculos.add(new Bicicleta(marca, precoAluguer, eletrica));

        JOptionPane.showMessageDialog(null, "Bicicleta adicionada com sucesso!");
    }

    private static void aplicarDesconto(List<Veiculo> veiculos) {
        int indice = Integer.parseInt(JOptionPane.showInputDialog("Digite o índice do veículo para aplicar desconto:"));
        double desconto = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do desconto:"));

        veiculos.get(indice).aplicarDesconto(desconto);

        JOptionPane.showMessageDialog(null, "Desconto aplicado com sucesso!");
    }

    private static void mostrarDetalhesVeiculos(List<Veiculo> veiculos) {
        JOptionPane.showMessageDialog(null, "Detalhes de todos os veículos:\n" + obterDetalhesVeiculos(veiculos));
    }

    private static void mostrarDetalhesAgrupadosPorTipo(List<Veiculo> veiculos) {
        StringBuilder detalhesCarros = new StringBuilder("Detalhes dos carros:\n");
        StringBuilder detalhesBicicletas = new StringBuilder("Detalhes das bicicletas:\n");

        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof Carro) {
                detalhesCarros.append(veiculo).append("\n");
            } else if (veiculo instanceof Bicicleta) {
                detalhesBicicletas.append(veiculo).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, detalhesCarros.toString() + detalhesBicicletas.toString());
    }

    private static void mostrarDetalhesOrdenadosPorMarca(List<Veiculo> veiculos) {
        Collections.sort(veiculos, Comparator.comparing(Veiculo::getMarca));

        JOptionPane.showMessageDialog(null, "Detalhes de todos os veículos ordenados por marca:\n" + obterDetalhesVeiculos(veiculos));
    }

    private static String obterDetalhesVeiculos(List<Veiculo> veiculos) {
        StringBuilder detalhes = new StringBuilder();
        for (Veiculo veiculo : veiculos) {
            detalhes.append(veiculo).append("\n");
        }
        return detalhes.toString();
    }
}

/*import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Veiculo> veiculos = new ArrayList<>();

        veiculos.add(new Carro("Toyota", 50.0, "Corolla", 50000));
        veiculos.add(new Carro("Honda", 45.0, "Civic", 60000));
        veiculos.add(new Bicicleta("Trek", 10.0, true));
        veiculos.add(new Bicicleta("Giant", 8.0, false));

        veiculos.get(0).aplicarDesconto(10.0);

        int opcao;
        do {
            String menu = "Escolha uma opção:\n" +
                    "1. Aplicar desconto a um veículo\n" +
                    "2. Mostrar detalhes de todos os veículos\n" +
                    "3. Mostrar detalhes dos veículos agrupados por tipo\n" +
                    "4. Mostrar detalhes de todos os veículos ordenados por marca\n" +
                    "0. Sair";

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    int indiceVeiculo = Integer.parseInt(JOptionPane.showInputDialog("Digite o índice do veículo:"));
                    double desconto = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do desconto:"));
                    veiculos.get(indiceVeiculo).aplicarDesconto(desconto);
                    JOptionPane.showMessageDialog(null, "Desconto aplicado com sucesso!");
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "Detalhes de todos os veículos:");
                    for (Veiculo veiculo : veiculos) {
                        JOptionPane.showMessageDialog(null, veiculo);
                    }
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Detalhes dos veículos agrupados por tipo:");
                    for (Veiculo veiculo : veiculos) {
                        if (veiculo instanceof Carro) {
                            JOptionPane.showMessageDialog(null, "Carro: " + veiculo);
                        } else if (veiculo instanceof Bicicleta) {
                            JOptionPane.showMessageDialog(null, "Bicicleta: " + veiculo);
                        }
                    }
                    break;

                case 4:
                    Collections.sort(veiculos, Comparator.comparing(Veiculo::getMarca));
                    JOptionPane.showMessageDialog(null, "Detalhes de todos os veículos ordenados por marca:");
                    for (Veiculo veiculo : veiculos) {
                        JOptionPane.showMessageDialog(null, veiculo);
                    }
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo do programa.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }
}

*/