package Atividade1;
import java.util.Scanner;

public class ReajusteSalarial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Informe o salário atual: R$ ");
        double salarioAtual = scanner.nextDouble();
        double percentualAumento;
        if (salarioAtual <= 280.00) {
            percentualAumento = 20;
        } else if (salarioAtual <= 700.00) {
            percentualAumento = 15;
        } else if (salarioAtual <= 1500.00) {
            percentualAumento = 10;
        } else {
            percentualAumento = 5;
        }
        double valorAumento = salarioAtual * (percentualAumento / 100);
        double novoSalario = salarioAtual + valorAumento;
        double inflacao = 3.8;
        double valorAumentoReal = valorAumento - (salarioAtual * (inflacao / 100));
        System.out.println("\nResultados:");
        System.out.printf("Salário antes do reajuste: R$ %.2f%n", salarioAtual);
        System.out.printf("Percentual de aumento aplicado: %.0f%%%n", percentualAumento);
        System.out.printf("Valor do aumento: R$ %.2f%n", valorAumento);
        System.out.printf("Novo salário após o aumento: R$ %.2f%n", novoSalario);
        System.out.printf("Valor do aumento real (descontada a inflação): R$ %.2f%n", valorAumentoReal);

        scanner.close();
    }
}