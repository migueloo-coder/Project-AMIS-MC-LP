package lab3;


public class Carro extends Veiculo {
 private String modelo;
 private double quilometragem;

 public Carro(String marca, double precoAluguer, String modelo, double quilometragem) {
     super(marca, precoAluguer);
     this.modelo = modelo;
     this.quilometragem = quilometragem;
 }

 @Override
 public String toString() {
     return super.toString() + ", Modelo: " + modelo + ", Quilometragem: " + quilometragem;
 }
}