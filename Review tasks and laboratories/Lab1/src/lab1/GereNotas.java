package lab1;

import java.util.ArrayList;
import java.util.List;

public class GereNotas {
	
	    private List<Aluno> alunos;
	    private List<UnidadesCurr> unidadesCurriculares;

	    public GereNotas() {
	        this.alunos = new ArrayList<>();
	        this.unidadesCurriculares = new ArrayList<>();
	    }

	    public void registarAluno(Aluno aluno) {
	        alunos.add(aluno);
	        
	    }

	    public void registarUC(UnidadesCurr uc) {
	        unidadesCurriculares.add(uc);
	    }

	    public void registarNota(int numeroAl, int codigoUC, double notaFinal) {
	        for (Aluno aluno : alunos) {
	            if (aluno.getNumeroAl() == numeroAl) {
	                aluno.adicionarNota(codigoUC, notaFinal);
	            }
	        }

	        for (UnidadesCurr uc : unidadesCurriculares) {
	            if (uc.getCodigoUC() == codigoUC) {
	                uc.adicionarNota(numeroAl, notaFinal);
	            }
	        }
	    }

	    public void imprimirInfoAlunos() {
	        for (Aluno aluno : alunos) {
	            System.out.println(aluno);
	        }
	    }

	    public void imprimirInfoUCs() {
	        for (UnidadesCurr uc : unidadesCurriculares) {
	            System.out.println(uc);
	        }
	    }
	}

