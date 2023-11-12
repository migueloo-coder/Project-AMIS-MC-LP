package lab3_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Leitura do texto introduzido pelo utilizador
        String texto = JOptionPane.showInputDialog("Introduza o texto:");

        // a) Frequência absoluta de cada palavra no texto
        Map<String, Integer> frequenciaPalavras = calcularFrequenciaPalavras(texto);
        exibirFrequenciaPalavras(frequenciaPalavras);

        // b) Lista de palavras com posição de ocorrência
        String[] palavras = texto.split("\\s+");
        exibirPosicaoOcorrenciaPalavras(palavras);

        // c) Frequência de ocorrência de cada dupleto no texto
        Map<String, Integer> frequenciaDupleto = calcularFrequenciaDupleto(texto);
        exibirFrequenciaDupleto(frequenciaDupleto);

        // d) Pesquisa de uma dada palavra
        String palavraPesquisa = JOptionPane.showInputDialog("Digite uma palavra para pesquisar:").toLowerCase(); // Ignorar maiúsculas/minúsculas
        pesquisarPalavra(frequenciaPalavras, palavraPesquisa);
    }

    // Método para calcular a frequência absoluta de cada palavra no texto
    private static Map<String, Integer> calcularFrequenciaPalavras(String texto) {
        String[] palavras = texto.split("\\s+");
        Arrays.sort(palavras); // Ordenar alfabeticamente
        Map<String, Integer> frequencia = new HashMap<>();

        for (String palavra : palavras) {
            palavra = palavra.toLowerCase(); // Ignorar maiúsculas/minúsculas
            frequencia.put(palavra, frequencia.getOrDefault(palavra, 0) + 1);
        }

        return frequencia;
    }

    // Método para exibir a frequência absoluta de cada palavra
    private static void exibirFrequenciaPalavras(Map<String, Integer> frequenciaPalavras) {
        StringBuilder mensagem = new StringBuilder("Frequência absoluta de cada palavra (ordenadas alfabeticamente):\n");
        for (String palavra : frequenciaPalavras.keySet()) {
            mensagem.append(palavra).append(": ").append(frequenciaPalavras.get(palavra)).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensagem.toString());
    }

    // Método para exibir a lista de palavras com posição de ocorrência
    private static void exibirPosicaoOcorrenciaPalavras(String[] palavras) {
        StringBuilder mensagem = new StringBuilder("Lista de palavras com posição de ocorrência:\n");
        for (int i = 0; i < palavras.length; i++) {
            mensagem.append(palavras[i]).append(": Posição ").append(i + 1).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensagem.toString());
    }

    // Método para calcular a frequência de ocorrência de cada dupleto no texto
    private static Map<String, Integer> calcularFrequenciaDupleto(String texto) {
        Map<String, Integer> frequencia = new HashMap<>();

        for (int i = 0; i < texto.length() - 1; i++) {
            String dupleto = texto.substring(i, i + 2);
            frequencia.put(dupleto, frequencia.getOrDefault(dupleto, 0) + 1);
        }

        return frequencia;
    }

    // Método para exibir a frequência de ocorrência de cada dupleto
    private static void exibirFrequenciaDupleto(Map<String, Integer> frequenciaDupleto) {
        StringBuilder mensagem = new StringBuilder("Frequência de ocorrência de cada dupleto:\n");
        for (String dupleto : frequenciaDupleto.keySet()) {
            mensagem.append(dupleto).append(": ").append(frequenciaDupleto.get(dupleto)).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensagem.toString());
    }

    // Método para pesquisar uma palavra no mapa de frequência
    private static void pesquisarPalavra(Map<String, Integer> frequenciaPalavras, String palavraPesquisa) {
        if (frequenciaPalavras.containsKey(palavraPesquisa)) {
            JOptionPane.showMessageDialog(null, "A palavra '" + palavraPesquisa + "' ocorre " +
                    frequenciaPalavras.get(palavraPesquisa) + " vezes.");
        } else {
            JOptionPane.showMessageDialog(null, "A palavra '" + palavraPesquisa + "' não existe.");
        }
    }
}

