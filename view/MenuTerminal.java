package view;

import java.util.List;
import java.util.Scanner;
import model.NotaFiscal;
import repository.NotaFiscalRepository;
import service.NotaFiscalService;

public class MenuTerminal {

    private Scanner scanner;
    private NotaFiscalRepository repository;
    private NotaFiscalService service;

    public MenuTerminal() {
        scanner = new Scanner(System.in);
        repository = new NotaFiscalRepository();
        service = new NotaFiscalService();
    }

    public void exibirMenu() {

        System.out.println("\n=== NOTAS CADASTRADAS ===");
        List<NotaFiscal> todas = repository.listarTodas();
        for (NotaFiscal n : todas) {
            System.out.println("Nota " + n.getNumeroNota() + " | Status: " + n.getStatus());
        }

        System.out.println("\n=== CONSULTA DE NOTA FISCAL ===");
        System.out.print("Digite o numero da nota: ");
        int numero = scanner.nextInt();

        NotaFiscal nota = repository.buscarPorNumero(numero);

        if (nota != null) {
            exibirDadosNota(nota);
            exibirOpcoesNota(nota);
        } else {
            System.out.println("Nota nao encontrada.");
            exibirMenuFinal();
        }
    }

    private void exibirDadosNota(NotaFiscal nota) {
        System.out.println("\n=== DADOS DA NOTA ===");
        System.out.println("Numero: " + nota.getNumeroNota());
        System.out.println("Serie: " + nota.getSerie());
        System.out.println("Natureza: " + nota.getNaturezaOperacao());
        System.out.println("Quantidade de itens: " + nota.getQuantidadeItens());
        System.out.println("Valor total: R$ " + nota.getValorTotal());
        System.out.println("Data de emissao: " + nota.getDataEmissao());
        System.out.println("Status: " + nota.getStatus());
    }

    private void exibirOpcoesNota(NotaFiscal nota) {
        System.out.println("\n=== OPCOES ===");
        System.out.println("1 - Acessar nota");
        System.out.println("0 - Fechar");
        System.out.print("Escolha: ");

        int opcao = scanner.nextInt();

        if (opcao == 1) {
            exibirAcoes(nota);
        } else {
            System.out.println("Encerrando...");
        }
    }

    private void exibirAcoes(NotaFiscal nota) {
        System.out.println("\n=== ACOES ===");
        System.out.println("1 - Autorizar");
        System.out.println("2 - Cancelar");
        System.out.println("3 - Inutilizar");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");

        int acao = scanner.nextInt();

        switch (acao) {
            case 1:
                service.autorizarNota(nota);
                exibirMenuFinal();
                break;
            case 2:
                service.cancelarNota(nota);
                exibirMenuFinal();
                break;
            case 3:
                service.inutilizarNota(nota);
                exibirMenuFinal();
                break;
            case 0:
                exibirOpcoesNota(nota);
                break;
            default:
                System.out.println("Opcao invalida.");
                exibirMenuFinal();
        }
    }

    private void exibirMenuFinal() {
        System.out.println("\n=== O QUE DESEJA FAZER? ===");
        System.out.println("1 - Acessar outra nota");
        System.out.println("0 - Fechar");
        System.out.print("Escolha: ");

        int opcao = scanner.nextInt();

        if (opcao == 1) {
            exibirMenu();
        } else {
            System.out.println("Encerrando...");
        }
    }
}