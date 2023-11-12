package lab1;

public class Nota {
	
	    private int numeroAl;
	    private int codigoUC;
	    private double notaFinal;

	    public Nota(int numeroAl, int codigoUC, double notaFinal) {
	        this.numeroAl = numeroAl;
	        this.codigoUC = codigoUC;
	        this.notaFinal = notaFinal;
	    }

	    @Override
	    public String toString() {
	        return "Nota ( Numero Aluno=" + numeroAl + ", Codigo UC=" + codigoUC + ", Nota Final=" + notaFinal + ')';
	        
	    }
	}

