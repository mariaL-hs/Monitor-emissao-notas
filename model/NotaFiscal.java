package model;
import java.time.LocalDate;

// objetos que representam os dados do sistema.

public class NotaFiscal {
    private int numeroNota;
    private int serie;
    private String naturezaOperacao; // descrição da operação realizada.
    private int quantidadeItens;
    private double valorTotal;
    private LocalDate dataEmissao; // classe imutavel, representa a data como ano-mes-dia
    private StatusNota status; // statusNotas é um enum

    // constructor
    public NotaFiscal(
            int numeroNota,
            int serie,
            String naturezaOperacao,
            int quantidadeItens,
            double valorTotal,
            LocalDate dataEmissao,
            StatusNota status) {

        this.numeroNota = numeroNota;
        this.serie = serie;
        this.naturezaOperacao = naturezaOperacao;
        this.quantidadeItens = quantidadeItens;
        this.valorTotal = valorTotal;
        this.dataEmissao = dataEmissao;
        this.status = status;
    }

    // getters e setters pra levar os valores pras classes privates

    public int getNumeroNota(){
        return numeroNota;
    }

    public int getSerie(){
        return serie;
    }

    public String getNaturezaOperacao(){
        return naturezaOperacao;
    }

    public int getQuantidadeItens(){
        return quantidadeItens;
    }

    public double getValorTotal(){
        return valorTotal;
    }

    public StatusNota getStatus() {
        return status;
    }

    public void setStatus(StatusNota status) {
        this.status = status;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }
  
}