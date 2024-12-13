package Atividade3.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Atividade3.controller.Controlador;
import Atividade3.model.Aluno;

public class AlunoFrame extends JFrame {
    private JTextField nomeTextField = new JTextField();
    private JTextField notaTextField = new JTextField();
    private JButton okButton = new JButton("OK");
    private JButton cancelarButton = new JButton("Cancelar");
    @SuppressWarnings("unused")
    private Controlador controlador;

    // Construtor
    public AlunoFrame(Controlador controlador) {
        this.controlador = controlador;

        setTitle("Cadastrar Aluno");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(20, 20, 80, 25);
        add(nomeLabel);

        nomeTextField.setBounds(100, 20, 150, 25);
        add(nomeTextField);

        JLabel notaLabel = new JLabel("Nota:");
        notaLabel.setBounds(20, 60, 80, 25);
        add(notaLabel);

        notaTextField.setBounds(100, 60, 150, 25);
        add(notaTextField);

        okButton.setBounds(50, 110, 80, 30);
        add(okButton);

        cancelarButton.setBounds(150, 110, 100, 30);
        add(cancelarButton);

        // Listeners
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeTextField.getText();
                if (nome.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O nome não pode estar vazio!");
                    return;
                }

                double nota;
                try {
                    nota = Double.parseDouble(notaTextField.getText());
                    if (nota < 0 || nota > 10) {
                        JOptionPane.showMessageDialog(null, "A nota deve estar entre 0 e 10!");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Nota inválida!");
                    return;
                }

                Aluno aluno = new Aluno(nome, nota);
                controlador.cadastrarAluno(aluno);
                JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
                dispose();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
