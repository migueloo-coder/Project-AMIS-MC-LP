package lab1;

import javax.swing.JOptionPane;

public class Teste {

	public static void main(String[] args) {
		
		GereNotas gereNotas = new GereNotas();

		int op1;

        do {
            String menuPrincipal = "Menu Principal:\n" +
                    "1. Inserir dados pré-inseridos\n" +
                    "2. Inserir dados Manual\n" +
                    "3. Mostrar Dados\n" +
                    "4. Sair";

            op1 = Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal));
            switch (op1) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Selecionou a opção 1.");
                    //----------------------------------------------------------------------------------------------------
                    Aluno aluno1 = new Aluno("Miguel", 98765);
                    Aluno aluno2 = new Aluno("Juliana", 34568);
                    Aluno aluno3 = new Aluno("Jorge", 45677);
                    Aluno aluno4 = new Aluno("Luis", 98753);
                    Aluno aluno5 = new Aluno("Helena", 54994);
                    gereNotas.registarAluno(aluno1);
                    gereNotas.registarAluno(aluno2);
                    gereNotas.registarAluno(aluno3);
                    gereNotas.registarAluno(aluno4);
                    gereNotas.registarAluno(aluno5);
                    //----------------------------------------------------------------------------------------------------
                    UnidadesCurr uc1 = new UnidadesCurr("Laboratorio de Programação", 2010, "Engenharia Informática");
                    UnidadesCurr uc2 = new UnidadesCurr("Base de Dados", 2020, "Engenharia Informática");
                    UnidadesCurr uc3 = new UnidadesCurr("Arquitectura de Computadores", 1010, "Engenharia Informática");
                    UnidadesCurr uc4 = new UnidadesCurr("Gestao de Projetos", 3010, "Engenharia Informática");
                    UnidadesCurr uc5 = new UnidadesCurr("Enginheria de Software", 2021, "Engenharia Informática");
                    //----------------------------------------------------------------------------------------------------
                    gereNotas.registarUC(uc1);
                    gereNotas.registarUC(uc2);
                    gereNotas.registarUC(uc3);
                    gereNotas.registarUC(uc4);
                    gereNotas.registarUC(uc5);
                    //----------------------------------------------------------------------------------------------------
                    gereNotas.registarNota(98765, 2010, 7.5);
                    gereNotas.registarNota(98765, 2020, 7.5);
                    gereNotas.registarNota(98765, 1010, 7.5);
                    gereNotas.registarNota(98765, 3010, 7.5);
                    gereNotas.registarNota(98765, 2021, 7.5);
                    gereNotas.registarNota(34568, 2020, 8.0);
                    gereNotas.registarNota(45677, 1010, 8.0);
                    gereNotas.registarNota(98753, 3010, 8.0);
                    gereNotas.registarNota(54994, 2021, 8.0);
                    
                    JOptionPane.showMessageDialog(null, "Dados introduzidos com sucesso.");
                    
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "Selecionou a opção 2, Inserir Dados Manual.");
                    
                    int op2;
                    do {
                        String menuInserirDados = "Selecione uma opção:\n" +
                                "1. Registar UC\n" +
                                "2. Registar Aluno\n" +
                                "3. Registar Nota\n" +
                                "0. Sair";

                        op2 = Integer.parseInt(JOptionPane.showInputDialog(menuInserirDados));

                        switch (op2) {
                            case 1:

                                String nomeUC = JOptionPane.showInputDialog("Digite o nome da UC:");
                                int codigoUC = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da UC:"));
                                String cursoUC = JOptionPane.showInputDialog("Digite o curso:");
                                
                                UnidadesCurr uc = new UnidadesCurr(nomeUC, codigoUC, cursoUC);
                                gereNotas.registarUC(uc);
                                JOptionPane.showMessageDialog(null, "UC registada com sucesso!");
                                break;

                            case 2:
                                String nomeAl = JOptionPane.showInputDialog("Digite o nome do Aluno:");
                                int numeroAl = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do Aluno:"));
                                Aluno aluno = new Aluno(nomeAl, numeroAl);
                                gereNotas.registarAluno(aluno);
                                JOptionPane.showMessageDialog(null, "Aluno registado com sucesso!");
                                break;

                            case 3:                         
                                int numAluno = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do Aluno:"));
                                int codUC = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da UC:"));
                                double notaFinal = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota final:"));
                                JOptionPane.showMessageDialog(null, "Nota registada com sucesso!");
                                break;
                            case 0:
                                JOptionPane.showMessageDialog(null, "Saindo do menu de inserção de dados.");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                        }
                    } while (op2 != 0);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Selecionou a opção 3, Mostrar Todos Dados.");       
                    int op3;
                    do {
                        String menuMostrarDados = "Menu 3:\n" +
                                "1. Mostrar Alunos\n" +
                                "2. Mostrar Unidades Curriculares\n" +
                                "3. Ir para o menu anterior";

                        op3 = Integer.parseInt(JOptionPane.showInputDialog(menuMostrarDados));

                        switch (op3) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Selecionou a opção 1, Mostrar Alunos.");
                                gereNotas.imprimirInfoAlunos();
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Selecionou a opção 2, Mostrar Unidades Curriculares.");
                                gereNotas.imprimirInfoUCs();
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Saindo do menu 3.");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, seleccione novamente.");
                        }
                    } while (op3 != 3);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Deixar o programa - até logo!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, seleccione novamente.");
            }
        } while (op1 != 4);
    }
		
}
	

