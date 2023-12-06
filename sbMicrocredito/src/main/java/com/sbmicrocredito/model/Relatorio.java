package com.sbmicrocredito.model;

import java.io.Serializable;

public class Relatorio implements Serializable {
    private long iD;
    private String nome;
    private double valorEmprestimo;
    private String dataEmprestimo;
    private String validade;
    private String dataPagamento;
    private String Classificao;

    /**
     * Construtor que inicializa os atributos da classe.
     *
     * @param iD              Identificador do relatório.
     * @param nome            Nome associado ao relatório.
     * @param valorEmprestimo Valor do empréstimo associado ao relatório.
     * @param dataEmprestimo  Data do empréstimo associado ao relatório.
     * @param validade        Data de validade do relatório.
     * @param dataPagamento   Data de pagamento associada ao relatório.
     * @param Classificao     Classificação associada ao relatório.
     */
    public Relatorio(long iD, String nome, double valorEmprestimo, String dataEmprestimo, String validade, String dataPagamento, String Classificao) {
        this.iD = iD;
        this.nome = nome;
        this.valorEmprestimo = valorEmprestimo;
        this.dataEmprestimo = dataEmprestimo;
        this.validade = validade;
        this.dataPagamento = dataPagamento;
        this.Classificao = Classificao;
    }

    /**
     * Obtém o identificador do relatório.
     *
     * @return O identificador do relatório.
     */
    public long getiD() {
        return iD;
    }

    /**
     * Define o identificador do relatório.
     *
     * @param iD O identificador do relatório.
     */
    public void setiD(long iD) {
        this.iD = iD;
    }

    /**
     * Obtém o nome associado ao relatório.
     *
     * @return O nome associado ao relatório.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome associado ao relatório.
     *
     * @param nome O nome associado ao relatório.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o valor do empréstimo associado ao relatório.
     *
     * @return O valor do empréstimo associado ao relatório.
     */
    public double getValorEmprestimo() {
        return valorEmprestimo;
    }

    /**
     * Define o valor do empréstimo associado ao relatório.
     *
     * @param valorEmprestimo O valor do empréstimo associado ao relatório.
     */
    public void setValorEmprestimo(double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    /**
     * Obtém a data do empréstimo associado ao relatório.
     *
     * @return A data do empréstimo associado ao relatório.
     */
    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    /**
     * Define a data do empréstimo associado ao relatório.
     *
     * @param dataEmprestimo A data do empréstimo associado ao relatório.
     */
    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    /**
     * Obtém a data de validade do relatório.
     *
     * @return A data de validade do relatório.
     */
    public String getValidade() {
        return validade;
    }

    /**
     * Define a data de validade do relatório.
     *
     * @param validade A data de validade do relatório.
     */
    public void setValidade(String validade) {
        this.validade = validade;
    }

    /**
     * Obtém a data de pagamento associada ao relatório.
     *
     * @return A data de pagamento associada ao relatório.
     */
    public String getDataPagamento() {
        return dataPagamento;
    }

    /**
     * Define a data de pagamento associada ao relatório.
     *
     * @param dataPagamento A data de pagamento associada ao relatório.
     */
    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    /**
     * Obtém a classificação associada ao relatório.
     *
     * @return A classificação associada ao relatório.
     */
    public String getClassificao() {
        return Classificao;
    }

    /**
     * Define a classificação associada ao relatório.
     *
     * @param Classificao A classificação associada ao relatório.
     */
    public void setClassificao(String Classificao) {
        this.Classificao = Classificao;
    }
}
