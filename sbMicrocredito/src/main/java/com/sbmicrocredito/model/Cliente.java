package com.sbmicrocredito.model;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente extends Pessoa implements Serializable {
    private double quantia;
    private String dataEmprestimo; 
    private String validadeEmprestimo;
    private String tipoEmprestimo;
    private String Profissao;
    private long iD;
    private boolean status;
    private byte [] imagem;
    private String provincia;

    /**
     * Construtor que inicializa os atributos da classe `Cliente`.
     *
     * @param quantia            Valor da quantia emprestada.
     * @param dataEmprestimo     Data do empréstimo.
     * @param validadeEmprestimo Validade do empréstimo.
     * @param tipoEmprestimo     Tipo de empréstimo.
     * @param Profissao          Profissão do cliente.
     * @param status             Status do cliente.
     * @param nome               Nome do cliente.
     * @param dataNascimento     Data de nascimento do cliente.
     * @param sexo               Sexo do cliente.
     * @param numeroBI           Número do Bilhete de Identidade do cliente.
     * @param localResidencia    Local de residência do cliente.
     * @param numeroCasa         Número da casa do cliente.
     * @param quarterao          Quarteirão do cliente.
     * @param contacto           Número de contato do cliente.
     * @param contactoAlt        Número de contato alternativo do cliente.
     * @param iD                 Identificação do cliente.
     * @param imagem             Imagem do cliente.
     * @param provincia          Província do cliente.
     */
    public Cliente(double quantia, String dataEmprestimo, String validadeEmprestimo, String tipoEmprestimo, String Profissao, boolean status, String nome, String dataNascimento, String sexo, String numeroBI, String localResidencia, String numeroCasa, String quarterao, long contacto, long contactoAlt, long iD, byte[] imagem, String provincia) {
        super(nome, dataNascimento, sexo, numeroBI, localResidencia, numeroCasa, quarterao, contacto, contactoAlt);
        this.quantia = quantia;
        this.dataEmprestimo = dataEmprestimo;
        this.validadeEmprestimo = validadeEmprestimo;
        this.tipoEmprestimo = tipoEmprestimo;
        this.Profissao = Profissao;
        this.iD = iD;
        this.status = status;
        this.imagem = imagem;
        this.provincia = provincia;
    }

    /**
     * Construtor vazio.
     */
    public Cliente() {
    }

    /**
     * Obtém a quantia do empréstimo.
     *
     * @return A quantia do empréstimo.
     */
    public double getQuantia() {
        return quantia;
    }

    /**
     * Define a quantia do empréstimo.
     *
     * @param quantia A quantia do empréstimo.
     */
    public void setQuantia(double quantia) {
        this.quantia = quantia;
    }

    /**
     * Obtém a data do empréstimo.
     *
     * @return A data do empréstimo.
     */
    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    /**
     * Define a data do empréstimo.
     *
     * @param dataEmprestimo A data do empréstimo.
     */
    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    /**
     * Obtém a validade do empréstimo.
     *
     * @return A validade do empréstimo.
     */
    public String getValidadeEmprestimo() {
        return validadeEmprestimo;
    }

    /**
     * Define a validade do empréstimo.
     *
     * @param validadeEmprestimo A validade do empréstimo.
     */
    public void setValidadeEmprestimo(String validadeEmprestimo) {
        this.validadeEmprestimo = validadeEmprestimo;
    }

    /**
     * Obtém o tipo de empréstimo.
     *
     * @return O tipo de empréstimo.
     */
    public String getTipoEmprestimo() {
        return tipoEmprestimo;
    }

    /**
     * Define o tipo de empréstimo.
     *
     * @param tipoEmprestimo O tipo de empréstimo.
     */
    public void setTipoEmprestimo(String tipoEmprestimo) {
        this.tipoEmprestimo = tipoEmprestimo;
    }

    /**
     * Obtém a profissão do cliente.
     *
     * @return A profissão do cliente.
     */
    public String getProfissao() {
        return Profissao;
    }

    /**
     * Define a profissão do cliente.
     *
     * @param Profissao A profissão do cliente.
     */
    public void setProfissao(String Profissao) {
        this.Profissao = Profissao;
    }

    /**
     * Obtém o status do cliente.
     *
     * @return O status do cliente.
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * Define o status do cliente.
     *
     * @param status O status do cliente.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Obtém a identificação do cliente.
     *
     * @return A identificação do cliente.
     */
    public long getiD() {
        return iD;
    }

    /**
     * Define a identificação do cliente.
     *
     * @param iD A identificação do cliente.
     */
    public void setiD(long iD) {
        this.iD = iD;
    }

    /**
     * Obtém a imagem do cliente.
     *
     * @return A imagem do cliente.
     */
    public byte[] getImagem() {
        return imagem;
    }

    /**
     * Define a imagem do cliente.
     *
     * @param imagem A imagem do cliente.
     */
    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    /**
     * Obtém a província do cliente.
     *
     * @return A província do cliente.
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Define a província do cliente.
     *
     * @param provincia A província do cliente.
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Calcula o preço final com uma taxa de 30%.
     *
     * @param preco Preço base.
     * @return O preço final com a taxa aplicada.
     */
    public double precoFinal(double preco) {
        return preco + (preco * 0.3);
    }

    /**
     * Obtém a data atual no formato "dd/MM/yyyy".
     *
     * @return A data atual formatada.
     */

    public String dataActual(){
        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        return formatar.format(data);
    }
    /**
     * Calcula a data de validade adicionando 1 mês à data atual.
     *
     * @return A data de validade formatada.
     */
    public String dataValidade(){
        Date dataVal = new Date();
        SimpleDateFormat formatarVal = new SimpleDateFormat("MM");
        int cont = Integer.parseInt(formatarVal.format(dataVal));
        if(cont==12)
            cont = 01;
        else
        cont++;
        
        Date dataVal1 = new Date();
        SimpleDateFormat formatarVal1 = new SimpleDateFormat("dd/"+cont+"/yyyy");
        
    return formatarVal1.format(dataVal1);    
    }
    
}
