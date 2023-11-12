package lab1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnidadesCurr {
	
	    private String nomeUC;
	    private int codigoUC;
	    private String curso;
	    private Map<Integer, List<Nota>> notasPorAluno; 

	    public UnidadesCurr(String nomeUC, int codigoUC, String curso) {
	        this.nomeUC = nomeUC;
	        this.codigoUC = codigoUC;
	        this.curso = curso;
	        this.notasPorAluno = new HashMap<>();
	    }

	    public void adicionarNota(int numeroAl, double notaFinal) {
	        Nota nota = new Nota(numeroAl, codigoUC, notaFinal);
	        notasPorAluno.computeIfAbsent(numeroAl, k -> new ArrayList<>()).add(nota);
	    }

	    public int getCodigoUC() {
			return codigoUC;
		}

		public void setCodigoUC(int codigoUC) {
			this.codigoUC = codigoUC;
		}

		@Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("Unidades Curriculares ( Nome UC='").append(nomeUC).append("', Codigo UC=").append(codigoUC);
	        sb.append(", Curso='").append(curso).append("', Notas Por Aluno=").append(notasPorAluno).append(')');
	        return sb.toString();
	    }

		
	}


