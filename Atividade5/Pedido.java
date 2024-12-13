package Atividade5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int idPedido;
    private Date data;
    private List<Produto> produtos;

    public Pedido(int idPedido, Date data) {
        this.idPedido = idPedido;
        this.data = data;
        this.produtos = new ArrayList<>();
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }

    @Override
    public String toString() {
        return "Pedido: id=" + idPedido + ", data=" + data + ", produtos=" + produtos;
    }
}
