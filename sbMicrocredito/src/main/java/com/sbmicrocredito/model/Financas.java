package com.sbmicrocredito.model;

import java.io.Serializable;

public class Financas implements Serializable {
    private double saldo;
    private double lucro;

    /**
     * Construtor que inicializa os atributos da classe `Financas`.
     *
     * @param saldo Valor do saldo financeiro.
     * @param lucro Valor do lucro financeiro.
     */
    public Financas(double saldo, double lucro) {
        this.saldo = saldo;
        this.lucro = lucro;
    }

    /**
     * Obtém o valor do saldo financeiro.
     *
     * @return O valor do saldo financeiro.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Define o valor do saldo financeiro.
     *
     * @param saldo O valor do saldo financeiro.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtém o valor do lucro financeiro.
     *
     * @return O valor do lucro financeiro.
     */
    public double getLucro() {
        return lucro;
    }

    /**
     * Define o valor do lucro financeiro.
     *
     * @param lucro O valor do lucro financeiro.
     */
    public void setLucro(double lucro) {
        this.lucro = lucro;
    }
}
