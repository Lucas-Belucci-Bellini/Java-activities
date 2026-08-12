package ATV1.ALFA;

public class Produto {
    String nome;
    double preco;
    int quantidadeEmEstoque;

    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void apresentarProduto() {
        System.out.printf("Produto: %s | Preço: R$ %.2f | Estoque: %d unidades%n",
                nome, preco, quantidadeEmEstoque);
    }
}