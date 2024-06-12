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

        int opcao;
        do {
            // Exibir menu
            System.out.println("\nMenu:");
            System.out.println("1. Listar todos os produtos");
            System.out.println("2. Listar todos os clientes");
            System.out.println("3. Filtrar produtos por preço");
            System.out.println("4. Filtrar clientes por idade");
            System.out.println("5. Adicionar um novo produto");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    listarProdutos(produtos);
                    break;
                case 2:
                    listarClientes(clientes);
                    break;
                case 3:
                    filtrarProdutosPorPreco(scanner, produtos);
                    break;
                case 4:
                    filtrarClientesPorIdade(scanner, clientes);
                    break;
                case 5:
                    adicionarProduto(scanner, produtos);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }

    private static void listarProdutos(List<Produto> produtos) {
        System.out.println("Produtos disponíveis:");
        produtos.forEach(System.out::println);
    }

    private static void listarClientes(List<Cliente> clientes) {
        System.out.println("\nClientes:");
        clientes.forEach(System.out::println);
    }

    private static void filtrarProdutosPorPreco(Scanner scanner, List<Produto> produtos) {
        System.out.print("Digite o preço mínimo para filtrar os produtos: ");
        double precoMinimo = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha

        List<Produto> produtosFiltrados = produtos.stream()
                                                  .filter(p -> p.getPreco() > precoMinimo)
                                                  .collect(Collectors.toList());
        if (produtosFiltrados.isEmpty()) {
            System.out.println("Nenhum produto encontrado com preço maior que R$" + precoMinimo);
        } else {
            System.out.println("Produtos com preço maior que R$" + precoMinimo + ":");
            produtosFiltrados.forEach(System.out::println);
        }
    }

    private static void filtrarClientesPorIdade(Scanner scanner, List<Cliente> clientes) {
        System.out.print("Digite a idade mínima para filtrar os clientes: ");
        int idadeMinima = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        List<Cliente> clientesFiltrados = clientes.stream()
                                                  .filter(c -> c.getIdade() > idadeMinima)
                                                  .collect(Collectors.toList());
        if (clientesFiltrados.isEmpty()) {
            System.out.println("Nenhum cliente encontrado com idade maior que " + idadeMinima + " anos.");
        } else {
            System.out.println("Clientes com idade maior que " + idadeMinima + " anos:");
            clientesFiltrados.forEach(System.out::println);
        }
    }

    private static void adicionarProduto(Scanner scanner, List<Produto> produtos) {
        System.out.print("Digite o nome do novo produto: ");
        String nomeProduto = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double precoProduto = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha

        Produto novoProduto = new Produto(nomeProduto, precoProduto);
        produtos.add(novoProduto);
        System.out.println("Produto adicionado: " + novoProduto);
    }
}
