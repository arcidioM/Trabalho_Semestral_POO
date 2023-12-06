package com.sbmicrocredito.model;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Funcionarios extends Pessoa implements Serializable{
    private double salario;
    private String email;
    private long senha;
    private long ID;
    private String alocacao;
    private byte[] imagem;
    private boolean status;
    private String provincia;

    public Funcionarios() {}
    
    public Funcionarios(double salario, String email, long senha, long ID, String nome, String dataNascimento, String sexo, String numeroBI, String localResidencia, String numeroCasa, String quarterao, long contacto, long contactoAlt, String alocacao, boolean status, byte[] imagem, String provincia) {
        super(nome, dataNascimento, sexo, numeroBI, localResidencia, numeroCasa, quarterao, contacto, contactoAlt);
        this.salario = salario;
        this.email = email;
        this.senha = senha;
        this.ID = ID;
        this.alocacao = alocacao;
        this.status = status;
        this.imagem = imagem;
        this.provincia = provincia;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getSenha() {
        return senha;
    }

    public void setSenha(long senha) {
        this.senha = senha;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getAlocacao() {
        return alocacao;
    }

    public void setAlocacao(String alocacao) {
        this.alocacao = alocacao;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        
        Pattern pattern = Pattern.compile(regex);
        
        Matcher matcher = pattern.matcher(email);
        
        return matcher.matches();
    }
    
}
