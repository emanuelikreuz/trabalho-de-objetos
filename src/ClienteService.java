

import java.util.List;
import java.util.stream.Collectors;

public class ClienteService {

    // Busca clientes por nome
    public static List<Cliente> buscarPorNome(Cliente clienteInformado, List<Cliente> clientes) {
        return clientes.stream()
            .filter(cliente -> cliente.getNome().equalsIgnoreCase(clienteInformado.getNome()))
            .collect(Collectors.toList());
    }

    // Busca clientes por idade
    public static List<Cliente> buscarPorIdade(Cliente clienteInformado, List<Cliente> clientes) {
        return clientes.stream()
            .filter(cliente -> cliente.getIdade() == clienteInformado.getIdade())
            .collect(Collectors.toList());
    }

    // Busca um cliente específico baseado em todos os critérios
    public Cliente buscarClienteEspecifico(Cliente clienteInformado, List<Cliente> clientes) {
        return clientes.stream()
            .filter(cliente -> comparaCliente(cliente, clienteInformado))
            .findFirst().orElse(null);
    }

    // Método privado para comparar todos os atributos do cliente
    private boolean comparaCliente(Cliente c1, Cliente c2) {
        return c1.getNome().equalsIgnoreCase(c2.getNome()) &&
               c1.getIdade() == c2.getIdade();
    }
}




