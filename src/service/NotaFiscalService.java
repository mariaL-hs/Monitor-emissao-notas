package service;

import java.time.LocalDate;
import model.NotaFiscal;
import model.StatusNota;

public class NotaFiscalService {
    public boolean inutilizarNota(NotaFiscal nota) {
        if (nota.getStatus() == StatusNota.REJEICAO_SEFAZ) {
            nota.setStatus(StatusNota.INUTILIZADA);
            System.out.println("Nota inutilizada com sucesso."); 
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
            System.out.println("Nota cancelada com sucesso.");  
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

    public boolean autorizarNota(NotaFiscal nota) {

        if (nota.getStatus() == StatusNota.PENDENTE_AUTORIZACAO) {
            nota.setStatus(StatusNota.AUTORIZADA);
            System.out.println("Nota autorizada com sucesso.");
            return true;
        }

        else if (nota.getStatus() == StatusNota.REJEICAO_SEFAZ) {
            nota.setStatus(StatusNota.AUTORIZADA);
            System.out.println("Nota autorizada com sucesso.");
            return true;
        }

        else if (nota.getStatus() == StatusNota.AUTORIZADA) {
            System.out.println("A nota já está autorizada.");
            return false;
        }

        else if (nota.getStatus() == StatusNota.CANCELADA) {
            System.out.println("Não é possível autorizar uma nota cancelada.");
            return false;
        }

        else if (nota.getStatus() == StatusNota.INUTILIZADA) {
            System.out.println("Não é possível autorizar uma nota inutilizada.");
            return false;
        }

        else {
            System.out.println("A nota não pode ser autorizada.");
            return false;
        }
    }
}
