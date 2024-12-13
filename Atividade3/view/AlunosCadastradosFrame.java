package Atividade3.view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;  
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Atividade3.controller.Controlador;
import Atividade3.model.Aluno;

public class AlunosCadastradosFrame extends JFrame {
    private JTable tabelaAlunos;
    private DefaultTableModel modeloTabela;
    private Controlador controlador;

    // Construtor
    public AlunosCadastradosFrame(Controlador controlador) {
        this.controlador = controlador;

        setTitle("Alunos Cadastrados");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Configuração da tabela
        modeloTabela = new DefaultTableModel(new String[]{"Nome", "Nota"}, 0);
        tabelaAlunos = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaAlunos);

        add(scrollPane, BorderLayout.CENTER);

        // Botão para atualizar a tabela
        JButton atualizarButton = new JButton("Atualizar Lista");
        atualizarButton.addActionListener(e -> carregarAlunos());
        add(atualizarButton, BorderLayout.SOUTH);

        // Carrega os alunos na inicialização
        carregarAlunos();
    }

    // Método para carregar os alunos na tabela
    private void carregarAlunos() {
        // Limpa os dados existentes na tabela
        modeloTabela.setRowCount(0);

        // Obtém a lista de alunos do controlador
        List<Aluno> alunos = controlador.listarAlunos();

        // Adiciona os alunos à tabela
        for (Aluno aluno : alunos) {
            modeloTabela.addRow(new Object[]{aluno.getNome(), aluno.getNota()});
        }

        if (alunos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum aluno cadastrado.", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
