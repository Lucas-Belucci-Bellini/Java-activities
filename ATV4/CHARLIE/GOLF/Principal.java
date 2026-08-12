package GOLF;

public class Principal {
    public static void main(String[] args) {
        ItemEstoque item = new ItemEstoque("Teclado", 20, 150.00);

        System.out.println("Estoque inicial:");
        item.mostrarEstoque();

        item.setPrecoUnitario(135.00);
        item.adicionarQuantidade(10);
        item.retirarQuantidade(5);

        System.out.println("\nQuantidade disponível: " + item.getQuantidadeDisponivel());

        System.out.println("\nEstoque atualizado:");
        item.mostrarEstoque();
    }
}
