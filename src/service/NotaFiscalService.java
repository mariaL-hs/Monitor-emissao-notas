// regras de negócio

package service;
import java.time.LocalDate;
import model.*;

// recebe uma nota fiscal e retorna true/false
public class NotaFiscalService {
    public boolean inutilizarNota(NotaFiscal nota) {
    if (nota.getStatus() == StatusNota.REJEICAO_SEFAZ) {
        nota.setStatus(StatusNota.INUTILIZADA);
        return true;
    }

    else if (nota.getStatus() == StatusNota.INUTILIZADA) {
        System.out.println("A nota já está inutilizada");
        return false;
    }

    else {
        System.out.println("A nota não está rejeitada pela SEFAZ");
        return false;
        }
    }

    public boolean cancelarNota(NotaFiscal nota) {
        if (nota.getStatus() == StatusNota.AUTORIZADA) {
            if (nota.getDataEmissao()
                .plusDays(30)
                .isBefore(LocalDate.now())) {
                System.out.println("Fora do prazo de cancelamento.");
                return false; 
                }

            nota.setStatus(StatusNota.CANCELADA);
            return true;
        }

        else if (nota.getStatus() == StatusNota.CANCELADA) {
            System.out.println("A nota já está cancelada");
            return false;
        
        }
        
        else {
        System.out.println("A nota não está autorizada pela SEFAZ e não pode ser cancelada");
        return false;
        }
    }
}