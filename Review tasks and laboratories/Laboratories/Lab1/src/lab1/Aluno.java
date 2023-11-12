package lab1;

import java.util.HashMap;
import java.util.Map;

public class Aluno {
	
	    private String nomeAl;
	    private int numeroAl;
	    private Map<Integer, Double> notasPorUC;

	    public Aluno(String nomeAl, int numeroAl) {
	        this.nomeAl = nomeAl;
	        this.numeroAl = numeroAl;
	        this.notasPorUC = new HashMap<>();
	    }

	    public void adicionarNota(int codigoUC, double notaFinal) {
	        notasPorUC.put(codigoUC, notaFinal);
	    }

	    
	    public String getNomeAl() {
			return nomeAl;
		}

		public void setNomeAl(String nomeAl) {
			this.nomeAl = nomeAl;
		}

		public int getNumeroAl() {
			return numeroAl;
		}

		public void setNumeroAl(int numeroAl) {
			this.numeroAl = numeroAl;
		}

		@Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("Aluno ='").append(nomeAl).append("', Numero=").append(numeroAl);
	        sb.append(", Nota Por Unidade Curricular=").append(notasPorUC);
	        return sb.toString();
	    }

		
	}

