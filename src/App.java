import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();

        // Adicionar produtos
        produtos.add(new Produto("Notebook", 2500.00));
        produtos.add(new Produto("Smartphone", 1200.00));
        produtos.add(new Produto("Tablet", 800.00));

        // Adicionar clientes
        clientes.add(new Cliente("Alice", 30));
        clientes.add(new Cliente("Bob", 25));
        clientes.add(new Cliente("Carlos", 40));

        // Interação com o usuário
        System.out.println("Produtos disponíveis:");
        produtos.forEach(System.out::println);

        System.out.println("\nClientes:");
        clientes.forEach(System.out::println);

        // Filtrando produtos com preço maior que 1000
        System.out.println("\nProdutos com preço maior que R$1000:");
        List<Produto> produtosCaros = produtos.stream()
                                              .filter(p -> p.getPreco() > 1000)
                                              .collect(Collectors.toList());
        produtosCaros.forEach(System.out::println);

        // Filtrando clientes com idade maior que 30
        System.out.println("\nClientes com idade maior que 30 anos:");
        List<Cliente> clientesVelhos = clientes.stream()
                                                .filter(c -> c.getIdade() > 30)
                                                .collect(Collectors.toList());
        clientesVelhos.forEach(System.out::println);

        // Interação adicional
        System.out.print("\nDigite o nome de um novo produto: ");
        String nomeProduto = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double precoProduto = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha

        produtos.add(new Produto(nomeProduto, precoProduto));
        System.out.println("Produto adicionado: " + produtos.get(produtos.size() - 1));

        // Fechar o scanner
        scanner.close();
    }
}
