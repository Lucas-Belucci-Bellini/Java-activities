package GOLF;

public class ItemEstoque {
    private String nome;
    private int quantidadeDisponivel;
    private double precoUnitario;

    public ItemEstoque(String nome, int quantidadeDisponivel, double precoUnitario) {
        setNome(nome);

        if (quantidadeDisponivel < 0) {
            throw new IllegalArgumentException("A quantidade disponível não pode ser negativa.");
        }
        this.quantidadeDisponivel = quantidadeDisponivel;

        setPrecoUnitario(precoUnitario);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do item não pode ficar vazio.");
        }
        this.nome = nome;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        if (precoUnitario <= 0) {
            throw new IllegalArgumentException("O preço unitário deve ser maior que zero.");
        }
        this.precoUnitario = precoUnitario;
    }

    public void adicionarQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade adicionada deve ser maior que zero.");
        }
        quantidadeDisponivel += quantidade;
    }

    public void retirarQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade retirada deve ser maior que zero.");
        }

        if (quantidade > quantidadeDisponivel) {
            throw new IllegalArgumentException("Quantidade insuficiente no estoque.");
        }

        quantidadeDisponivel -= quantidade;
    }

    public void mostrarEstoque() {
        System.out.println("Nome do item: " + nome);
        System.out.println("Quantidade disponível: " + quantidadeDisponivel);
        System.out.printf("Preço unitário: R$ %.2f%n", precoUnitario);
    }
}
