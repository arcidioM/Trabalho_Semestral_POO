package com.sbmicrocredito.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Garantia implements Serializable {
    private long iD;
    private String nome;
    private ArrayList<Double> preco;
    private ArrayList<String> Garantia;
    private byte[] foto;
    private boolean estado;

    /**
     * Construtor que inicializa os atributos da classe.
     *
     * @param iD       Identificador da garantia.
     * @param nome     Nome da garantia.
     * @param preco    Lista de preços associados à garantia.
     * @param Garantia Lista de descrições da garantia.
     * @param foto     Dados da foto da garantia.
     * @param estado   Estado da garantia (ativo/inativo).
     */
    public Garantia(long iD, String nome, ArrayList<Double> preco, ArrayList<String> Garantia, byte[] foto, boolean estado) {
        this.iD = iD;
        this.nome = nome;
        this.preco = preco;
        this.Garantia = Garantia;
        this.foto = foto;
        this.estado = estado;
    }

    /**
     * Obtém o identificador da garantia.
     *
     * @return O identificador da garantia.
     */
    public long getiD() {
        return iD;
    }

    /**
     * Define o identificador da garantia.
     *
     * @param iD O identificador da garantia.
     */
    public void setiD(long iD) {
        this.iD = iD;
    }

    /**
     * Obtém o nome da garantia.
     *
     * @return O nome da garantia.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da garantia.
     *
     * @param nome O nome da garantia.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a lista de preços associados à garantia.
     *
     * @return A lista de preços associados à garantia.
     */
    public ArrayList<Double> getPreco() {
        return preco;
    }

    /**
     * Define a lista de preços associados à garantia.
     *
     * @param preco A lista de preços associados à garantia.
     */
    public void setPreco(ArrayList<Double> preco) {
        this.preco = preco;
    }

    /**
     * Obtém a foto da garantia.
     *
     * @return Os dados da foto da garantia.
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * Define a foto da garantia.
     *
     * @param foto Os dados da foto da garantia.
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    /**
     * Obtém a lista de descrições da garantia.
     *
     * @return A lista de descrições da garantia.
     */
    public ArrayList<String> getGarantia() {
        return Garantia;
    }

    /**
     * Define a lista de descrições da garantia.
     *
     * @param Garantia A lista de descrições da garantia.
     */
    public void setGarantia(ArrayList<String> Garantia) {
        this.Garantia = Garantia;
    }

    /**
     * Obtém o estado da garantia.
     *
     * @return O estado da garantia (ativo/inativo).
     */
    public boolean getEstado() {
        return estado;
    }

    /**
     * Define o estado da garantia.
     *
     * @param estado O estado da garantia (ativo/inativo).
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
