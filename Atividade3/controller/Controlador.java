package Atividade3.controller;

import java.util.ArrayList;
import java.util.List;

import Atividade3.model.Aluno;

public class Controlador {
    private List<Aluno> alunos = new ArrayList<>();

    // Método para obter a lista de alunos
    public List<Aluno> getAlunos() {
        return alunos;
    }

    // Método para cadastrar aluno
    public boolean cadastrarAluno(Aluno aluno) {
        if (aluno != null) {
            alunos.add(aluno);
            return true;
        }
        return false;
    }

    // Método para listar alunos
    public List<Aluno> listarAlunos() {
        return new ArrayList<>(alunos);
    }

    // Método para calcular a média das notas
    public double calcularMedia() {
        if (alunos.isEmpty()) {
            return 0;
        }
        double soma = 0;
        for (Aluno aluno : alunos) {
            soma += aluno.getNota();
        }
        return soma / alunos.size();
    }
}

