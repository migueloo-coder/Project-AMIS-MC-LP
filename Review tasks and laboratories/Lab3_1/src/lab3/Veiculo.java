package lab3;

interface Ordenavel {
    String getMarca();
}

// Classe base
public class Veiculo implements Ordenavel {
    private String marca;
    private double precoAluguer;
    private double desconto;

    public Veiculo(String marca, double precoAluguer) {
        this.marca = marca;
        this.precoAluguer = precoAluguer;
        this.desconto = 0.0;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecoAluguer() {
        return precoAluguer - desconto;
    }

    public void aplicarDesconto(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Preço de Aluguer: " + getPrecoAluguer();
    }
}
