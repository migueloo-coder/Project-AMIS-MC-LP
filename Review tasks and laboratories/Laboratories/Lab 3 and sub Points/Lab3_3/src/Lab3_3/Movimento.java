package Lab3_3;

import java.util.Date;

public class Movimento {
    private Date data;
    private String tipo;
    private double montante;

    public Movimento(Date data, String tipo, double montante) {
        this.data = data;
        this.tipo = tipo;
        this.montante = montante;
    }

    @Override
    public String toString() {
        return "Data: " + data + ", Tipo: " + tipo + ", Montante: " + montante;
    }
}