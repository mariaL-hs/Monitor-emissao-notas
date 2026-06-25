
// armazenar e buscar dados 
// por a lista aqui
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
                LocalDate.of(2026, 6, 21),
                StatusNota.PENDENTE_AUTORIZACAO));
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
}