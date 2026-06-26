package repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.NotaFiscal;
import model.StatusNota;

public class NotaFiscalRepository {
    private List<NotaFiscal> notas;

    public NotaFiscalRepository() {
        this.notas = new ArrayList<>();

        notas.add(new NotaFiscal(
                1001,
                1,
                "Venda de Mercadoria",
                67,
                2590.00,
                LocalDate.of(2026, 6, 20),
                StatusNota.AUTORIZADA));

        notas.add(new NotaFiscal(
                1002,
                1,
                "Prestação de Serviço",
                3,
                900.00,
                LocalDate.of(2026, 4, 21), // fora do prazo de autorização
                StatusNota.PENDENTE_AUTORIZACAO));

        notas.add(new NotaFiscal(
            1003,
            1,
            "Devolução de Mercadoria",
            5,
            450.00,
            LocalDate.of(2026, 6, 22),
            StatusNota.REJEICAO_SEFAZ));

        notas.add(new NotaFiscal(
            1004,
            1,
            "Venda de Mercadoria",
            12,
            1800.00,
            LocalDate.of(2026, 6, 25),  // dentro do prazo de 30 dias
            StatusNota.AUTORIZADA));
    }

    public void adicionarNota(NotaFiscal nota) {
        notas.add(nota);
    }

    public NotaFiscal buscarPorNumero(int numero) {
        for (NotaFiscal nota : notas) {
            if (nota.getNumeroNota() == numero) {
                return nota;
            }
        }
        return null;
    }

    public List<NotaFiscal> listarTodas() {
    return notas;
}
}
