public class Cliente {
    private String nome;
    private int idade;

    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }

    // Getters (métodos de acesso)
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}
