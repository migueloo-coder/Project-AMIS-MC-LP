package lab3;

//Classe derivada (herança)
public class Bicicleta extends Veiculo {
 private boolean eletricamenteAssistida;

 public Bicicleta(String marca, double precoAluguer, boolean eletricamenteAssistida) {
     super(marca, precoAluguer);
     this.eletricamenteAssistida = eletricamenteAssistida;
 }

 @Override
 public String toString() {
     return super.toString() + ", Eletricamente Assistida: " + eletricamenteAssistida;
 }
}
