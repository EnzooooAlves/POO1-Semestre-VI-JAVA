package Atividade5;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Criando produtos
        Produto produto1 = new Produto(1, "Notebook", 3500.00, 5);
        Produto produto2 = new Produto(2, "Mouse", 50.00, 10);

        System.out.println(produto1);
        System.out.println(produto2);

        // Criando cliente
        Cliente cliente = new Cliente(1, "Enzo Enzo", "Enzo.Enzo@gmail.com");
        System.out.println(cliente);

        // Criando endereço
        Endereco endereco = new Endereco("Rua Principal", "Brasilia", "DF", "00000-000");
        System.out.println(endereco);

        // Criando categoria
        Categoria categoria = new Categoria(1, "Eletrônicos");
        System.out.println(categoria);

        // Criando fornecedor
        Fornecedor fornecedor = new Fornecedor(1, "Tech Mundo", "(00) 99999-8888");
        System.out.println(fornecedor);

        // Criando pedido
        Pedido pedido = new Pedido(1, new Date());
        pedido.addProduto(produto1);
        pedido.addProduto(produto2);

        System.out.println(pedido);

        // Testando todas as funções de adicionar e visualizar
        System.out.println("\n----- Testes Finais -----");
        System.out.println("Cliente associado: " + cliente);
        System.out.println("Produtos no pedido:");
        for (Produto p : pedido.getProdutos()) {
            System.out.println("- " + p.getNome() + " (Preço: R$ " + p.getPreco() + ")");
        }
    }
}
