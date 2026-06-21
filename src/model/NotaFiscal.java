import java.time.LocalDate;

// objetos que representam os dados do sistema.

public class NotaFiscal {
    private int numeroNota;
    private LocalDate dataEmissao; // classe imutavel, representa a data como ano-mes-dia
    private StatusNota status; // statusNotas é um enum

    // getters e setters pra levar os valores pras classes privates
    public StatusNota getStatus () {
        return status;
    }

    public void setStatus (StatusNota status) {
        this.status = status;
    }

    public LocalDate getDataEmissao () {
        return dataEmissao;
    }
}