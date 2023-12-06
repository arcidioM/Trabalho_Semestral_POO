package com.sbmicrocredito.model;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {
    private String nome;
    private String dataNascimento;
    private String sexo;
    private String numeroBI;
    private String localResidencia;
    private String numeroCasa;
    private String quarterao;
    private long contacto;
    private long contactoAlt;

    /**
     * Construtor que inicializa os atributos da classe.
     *
     * @param nome             Nome da pessoa.
     * @param dataNascimento   Data de nascimento da pessoa.
     * @param sexo             Sexo da pessoa.
     * @param numeroBI         Número do Bilhete de Identidade da pessoa.
     * @param localResidencia  Local de residência da pessoa.
     * @param numeroCasa       Número da casa da pessoa.
     * @param quarterao        Bairro ou quarteirão da pessoa.
     * @param contacto         Número de contacto da pessoa.
     * @param contactoAlt      Número de contacto alternativo da pessoa.
     */
    public Pessoa(String nome, String dataNascimento, String sexo, String numeroBI,
                  String localResidencia, String numeroCasa, String quarterao,
                  long contacto, long contactoAlt) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.numeroBI = numeroBI;
        this.localResidencia = localResidencia;
        this.numeroCasa = numeroCasa;
        this.quarterao = quarterao;
        this.contacto = contacto;
        this.contactoAlt = contactoAlt;
    }

    /**
     * Construtor vazio.
     */
    public Pessoa() {
    }

    /**
     * Obtém o nome da pessoa.
     *
     * @return O nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da pessoa.
     *
     * @param nome O nome da pessoa.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a data de nascimento da pessoa.
     *
     * @return A data de nascimento da pessoa.
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Define a data de nascimento da pessoa.
     *
     * @param dataNascimento A data de nascimento da pessoa.
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Obtém o sexo da pessoa.
     *
     * @return O sexo da pessoa.
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Define o sexo da pessoa.
     *
     * @param sexo O sexo da pessoa.
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Obtém o número do Bilhete de Identidade da pessoa.
     *
     * @return O número do Bilhete de Identidade da pessoa.
     */
    public String getNumeroBI() {
        return numeroBI;
    }

    /**
     * Define o número do Bilhete de Identidade da pessoa.
     *
     * @param numeroBI O número do Bilhete de Identidade da pessoa.
     */
    public void setNumeroBI(String numeroBI) {
        this.numeroBI = numeroBI;
    }

    /**
     * Obtém o local de residência da pessoa.
     *
     * @return O local de residência da pessoa.
     */
    public String getLocalResidencia() {
        return localResidencia;
    }

    /**
     * Define o local de residência da pessoa.
     *
     * @param localResidencia O local de residência da pessoa.
     */
    public void setLocalResidencia(String localResidencia) {
        this.localResidencia = localResidencia;
    }

    /**
     * Obtém o número da casa da pessoa.
     *
     * @return O número da casa da pessoa.
     */
    public String getNumeroCasa() {
        return numeroCasa;
    }

    /**
     * Define o número da casa da pessoa.
     *
     * @param numeroCasa O número da casa da pessoa.
     */
    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    /**
     * Obtém o bairro ou quarteirão da pessoa.
     *
     * @return O bairro ou quarteirão da pessoa.
     */
    public String getQuarterao() {
        return quarterao;
    }

    /**
     * Define o bairro ou quarteirão da pessoa.
     *
     * @param quarterao O bairro ou quarteirão da pessoa.
     */
    public void setQuarterao(String quarterao) {
        this.quarterao = quarterao;
    }

    /**
     * Obtém o número de contacto da pessoa.
     *
     * @return O número de contacto da pessoa.
     */
    public long getContacto() {
        return contacto;
    }

    /**
     * Define o número de contacto da pessoa.
     *
     * @param contacto O número de contacto da pessoa.
     */
    public void setContacto(long contacto) {
        this.contacto = contacto;
    }

    /**
     * Obtém o número de contacto alternativo da pessoa.
     *
     * @return O número de contacto alternativo da pessoa.
     */
    public long getContactoAlt() {
        return contactoAlt;
    }

    /**
     * Define o número de contacto alternativo da pessoa.
     *
     * @param contactoAlt O número de contacto alternativo da pessoa.
     */
    public void setContactoAlt(long contactoAlt) {
        this.contactoAlt = contactoAlt;
    }
}
