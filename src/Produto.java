public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    // Getters (métodos de acesso)
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
