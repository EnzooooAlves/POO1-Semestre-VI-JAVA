package Atividade3.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Atividade3.controller.Controlador;

public class TurmaFrame extends JFrame {
    private JButton listarAlunosButton = new JButton("Listar Alunos");
    private JButton resultadosButton = new JButton("Resultados");
    private JButton novoAlunoButton = new JButton("Novo Aluno");
    // Construtor
    public TurmaFrame(Controlador controlador) {
        setTitle("Gerenciar Turma");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        listarAlunosButton.setBounds(50, 30, 150, 30);
        resultadosButton.setBounds(50, 70, 150, 30);
        novoAlunoButton.setBounds(50, 110, 150, 30);

        add(listarAlunosButton);
        add(resultadosButton);
        add(novoAlunoButton);

        // Listeners
        listarAlunosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AlunosCadastradosFrame(controlador).setVisible(true);
            }
        });

        novoAlunoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AlunoFrame(controlador).setVisible(true);
            }
        });

        resultadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double media = controlador.calcularMedia();
                JOptionPane.showMessageDialog(null, "Média da Turma: " + media);
            }
        });
    }

    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        new TurmaFrame(controlador).setVisible(true);
    }
}

