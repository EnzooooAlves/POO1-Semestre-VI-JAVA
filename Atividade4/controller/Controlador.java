package Atividade4.controller;

import java.util.ArrayList;
import java.util.List;

import Atividade4.model.Aluno;

public class Controlador {
    private List<Aluno> alunos = new ArrayList<>();

    public boolean cadastrarAluno(Aluno aluno) {
        if (aluno != null) {
            alunos.add(aluno);
            return true;
        }
        return false;
    }

    public List<Aluno> listarAlunos() {
        return alunos;
    }
}
