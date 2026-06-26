
// visao do sistema no terminal
import java.util.Scanner;

public class MenuTerminal {

    private Scanner scanner;
    private NotaFiscalRepository repository;

    public MenuTerminal() {
        scanner = new Scanner(System.in);
        repository = new NotaFiscalRepository();
    }

    public void exibirMenu() {

        System.out.println("=== CONSULTA DE NOTA FISCAL ===");
        System.out.print("Digite o numero da nota: ");

        int numero = scanner.nextInt();

        NotaFiscal nota = repository.buscarPorNumero(numero);

        if (nota != null) {
            System.out.println("\n=== DADOS DA NOTA ===");
            System.out.println("Numero: " + nota.getNumeroNota());
            System.out.println("Serie: " + nota.getSerie());
            System.out.println("Natureza: " + nota.getNaturezaOperacao());
            System.out.println("Quantidade de itens: " + nota.getQuantidadeItens());
            System.out.println("Valor total: R$ " + nota.getValorTotal());
            System.out.println("Data de emissao: " + nota.getDataEmissao());
        } else {
            System.out.println("Nota nao encontrada.");
        }

    }
}