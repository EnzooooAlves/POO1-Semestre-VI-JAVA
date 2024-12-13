package Atividade4.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Atividade4.controller.Controlador;
import Atividade4.model.Aluno;

public class MainFrame extends JFrame {
    private JTextField nomeField;
    private JTextField notaField;
    private JTable tabelaAlunos;
    private DefaultTableModel tableModel;
    private Controlador controlador;

    public MainFrame() {
        controlador = new Controlador();

        // Configuração da Janela
        setTitle("Gerenciamento de Alunos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Componentes
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(20, 20, 100, 30);
        add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(80, 20, 200, 30);
        add(nomeField);

        JLabel notaLabel = new JLabel("Nota:");
        notaLabel.setBounds(20, 60, 100, 30);
        add(notaLabel);

        notaField = new JTextField();
        notaField.setBounds(80, 60, 200, 30);
        add(notaField);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(300, 20, 120, 30);
        add(cadastrarButton);

        JButton listarButton = new JButton("Listar");
        listarButton.setBounds(300, 60, 120, 30);
        add(listarButton);

        // Tabela
        tableModel = new DefaultTableModel(new String[]{"Nome", "Nota"}, 0);
        tabelaAlunos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelaAlunos);
        scrollPane.setBounds(20, 120, 450, 200);
        add(scrollPane);

        // Eventos
        cadastrarButton.addActionListener(e -> cadastrarAluno());
        listarButton.addActionListener(e -> listarAlunos());
    }

    private void cadastrarAluno() {
        String nome = nomeField.getText();
        double nota;
        try {
            nota = Double.parseDouble(notaField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite uma nota válida!");
            return;
        }

        Aluno aluno = new Aluno(nome, nota);
        if (controlador.cadastrarAluno(aluno)) {
            JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
            nomeField.setText("");
            notaField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar aluno.");
        }
    }

    private void listarAlunos() {
        tableModel.setRowCount(0); // Limpar tabela
        for (Aluno aluno : controlador.listarAlunos()) {
            tableModel.addRow(new Object[]{aluno.getNome(), aluno.getNota()});
        }
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
