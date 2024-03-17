import java.util.ArrayList;
import java.util.Scanner;

public class ListaCompras {

    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> lista = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarItem();
                    break;
                case 2:
                    removerItem();
                    break;
                case 3:
                    imprimirLista();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    private static void exibirMenu() {
        System.out.println("\n**Lista de Compras**");
        System.out.println("1. Adicionar item");
        System.out.println("2. Remover item");
        System.out.println("3. Imprimir lista");
        System.out.println("4. Sair");
        System.out.print("Digite a opção desejada: ");
    }

    private static void adicionarItem() {
        System.out.print("Digite o nome do item: ");
        String item = scanner.next();
        lista.add(item);
        System.out.println("Item adicionado com sucesso!");
    }

    private static void removerItem() {
        if (lista.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }

        System.out.println("**Lista de Itens:**");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i));
        }

        System.out.print("Digite o número do item para remover: ");
        int numeroItem = scanner.nextInt();

        if (numeroItem > 0 && numeroItem <= lista.size()) {
            lista.remove(numeroItem - 1);
            System.out.println("Item removido com sucesso!");
        } else {
            System.out.println("Número do item inválido!");
        }
    }

    private static void imprimirLista() {
        if (lista.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }

        System.out.println("\n**Lista de Compras:**");
        for (String item : lista) {
            System.out.println("- " + item);
        }
    }
}
