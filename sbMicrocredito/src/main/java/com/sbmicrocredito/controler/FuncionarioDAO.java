package com.sbmicrocredito.controler;

import com.sbmicrocredito.model.Funcionarios;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

public class FuncionarioDAO {
    
    public void cadastroFuncionario (Funcionarios p){
        ArrayList<Funcionarios> fun = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Funcionario.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Funcionarios vic = null;
            while ((vic = (Funcionarios)objInput.readObject())!= null){
               fun.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo!!" +e);
        }finally{
            fun.add(p);
            try {
            FileOutputStream fileOutput = new FileOutputStream("Funcionario.txt");
            ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
            
            for (int f = 0; f< fun.size(); f++){
                objOutput.writeObject(fun.get(f));
            }
            
            objOutput.flush();
            fileOutput.flush();
            objOutput.close();
            fileOutput.close();
            JOptionPane.showMessageDialog(null, "O seu cadastro foi efectuado com Sucesso.");
            
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!"+ e.getMessage());
            }
        }
    }
    
    private final void adicionarFile(){
        ArrayList<Funcionarios> fun = new ArrayList();
        try {
            FileOutputStream fileOutput = new FileOutputStream("Funcionario.txt");
            ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
            
            for (int f = 0; f< fun.size(); f++){
                objOutput.writeObject(fun.get(f));
            }
            
            objOutput.flush();
            fileOutput.flush();
            objOutput.close();
            fileOutput.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!"+ e.getMessage());
        }
        
    }
    public long numeroID(){
        ArrayList<Funcionarios> fun = new ArrayList();
        long codigo= 0;
        try {
            FileInputStream fileInput = new FileInputStream("Funcionario.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Funcionarios vic = null;
            while ((vic = (Funcionarios)objInput.readObject())!= null){
               fun.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        boolean verificador = true;
        while (verificador){ 
            codigo = (long) (1000000 + Math.random() * (9999999 - 1000000));
            verificador=false;
            for (int f = 0; f< fun.size(); f++){
                if(codigo == fun.get(f).getID()){
                    verificador=true;
                }
            }
        }
        return codigo;
    }
    public long numeroSenha(){
        ArrayList<Funcionarios> fun = new ArrayList();
        long senha= 0;
        try {
            FileInputStream fileInput = new FileInputStream("Funcionario.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Funcionarios vic = null;
            while ((vic = (Funcionarios)objInput.readObject())!= null){
               fun.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        boolean verificador = true;
        while (verificador){
            senha = (long) (100000 + Math.random() * (999999 - 100000));
            verificador=false;
            for (int f = 0; f< fun.size(); f++){
                if(senha == fun.get(f).getSenha()){
                    verificador=true;
                }
            }
        }
        return senha;
    }
    public void demitir(String nome){
        ArrayList<Funcionarios> fun = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Funcionario.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Funcionarios vic = null;
            while ((vic = (Funcionarios)objInput.readObject())!= null){
               fun.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        for (int f = 0; f< fun.size(); f++){
            if(nome.equals(fun.get(f).getNome())){
                fun.get(f).setStatus(false);
                JOptionPane.showMessageDialog(null, "Funcionario demitido com sucesso!");
            }
        }
        try {
            FileOutputStream fileOutput = new FileOutputStream("Funcionario.txt");
            ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
            
            for (int f = 0; f< fun.size(); f++){
                objOutput.writeObject(fun.get(f));
            }
            
            objOutput.flush();
            fileOutput.flush();
            objOutput.close();
            fileOutput.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!"+ e.getMessage());
        }
    }
    public void actualizar(long iD, String numeroBI, String localResidencia, String quarteirao, String NumeroCasa, String provincia, long contacto, long contactoAlt,double salario, String email){
        ArrayList<Funcionarios> fun = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Funcionario.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Funcionarios vic = null;
            while ((vic = (Funcionarios)objInput.readObject())!= null){
               fun.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        for (int f = 0; f< fun.size(); f++){
            if(iD == fun.get(f).getID()){
                fun.get(f).setNumeroBI(numeroBI);
                fun.get(f).setLocalResidencia(localResidencia);
                fun.get(f).setQuarterao(quarteirao);
                fun.get(f).setNumeroCasa(NumeroCasa);
                fun.get(f).setContacto(contacto);
//                fun.get(f).setP(contacto);
                fun.get(f).setContactoAlt(contactoAlt);
                fun.get(f).setSalario(salario);
                fun.get(f).setEmail(email);
            }
        }
        try {
            FileOutputStream fileOutput = new FileOutputStream("Funcionario.txt");
            ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
            
            for (int f = 0; f< fun.size(); f++){
                objOutput.writeObject(fun.get(f));
            }
            
            objOutput.flush();
            fileOutput.flush();
            objOutput.close();
            fileOutput.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!"+ e.getMessage());
        }
    }
    public void email(){
        String meuEmail = "arcidio64@gmail.com";
        String minhaSenha = "atgq upjd fmfv rumi";
        
        SimpleEmail sEmail = new SimpleEmail();
        sEmail.setHostName("smtp.gmail.com");
        sEmail.setSmtpPort(465);
        sEmail.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
        sEmail.setSSLOnConnect(true);
        
        try {
            sEmail.setFrom(meuEmail);
            sEmail.setSubject("Confirmacao do salario");
            sEmail.setMsg("De acordo com o contrato de emprego, o seu salário mensal e de [Valor do Salário]."
                    + " Este valor foi depositado na sua conta bancária. Por favor, confirme o recebimento deste e-mail e a exatidão das informações.");
            sEmail.addTo(meuEmail);
            sEmail.send();
            JOptionPane.showMessageDialog(null, "Email enviado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println(e.getMessage());
        }
    }
    public boolean confirmacaoLogin(String usuario, long senha){
        ArrayList<Funcionarios> fun = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Funcionario.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Funcionarios vic = null;
            while ((vic = (Funcionarios)objInput.readObject())!= null){
               fun.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        for (int f = 0; f< fun.size(); f++){
            if(fun.get(f).getStatus()==true){
                if((fun.get(f).getNome().equals(usuario))&&(fun.get(f).getSenha()==senha)){
                    return true;
                }
            }
        }
        return false;
    }
    public long contFuncionario(){
        long cont = 0;
        ArrayList<Funcionarios> fun = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Funcionario.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Funcionarios vic = null;
            while ((vic = (Funcionarios)objInput.readObject())!= null){
               fun.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        for (int f = 0; f< fun.size(); f++){
            if(fun.get(f).getStatus())
                cont += 1;
            
        }
        return cont;
    }
    public long contFuncionarioHomem(){
        long cont = 0;
        ArrayList<Funcionarios> fun = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Funcionario.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Funcionarios vic = null;
            while ((vic = (Funcionarios)objInput.readObject())!= null){
               fun.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        for (int f = 0; f< fun.size(); f++){
            if((fun.get(f).getStatus()&&(fun.get(f).getSexo().equals("Masculino"))))
                cont += 1;
            
        }
        return cont;
    }
    public long contFuncionarioMulher(){
        long cont = 0;
        ArrayList<Funcionarios> fun = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Funcionario.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Funcionarios vic = null;
            while ((vic = (Funcionarios)objInput.readObject())!= null){
               fun.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        for (int f = 0; f< fun.size(); f++){
            if((fun.get(f).getStatus()&&(fun.get(f).getSexo().equals("Femenino"))))
                cont += 1;
            
        }
        return cont;
    }
    public void activarFuncionario(String nome){
        boolean verf = false;
        ArrayList<Funcionarios> fun = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Funcionario.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Funcionarios vic = null;
            while ((vic = (Funcionarios)objInput.readObject())!= null){
               fun.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        for (int f = 0; f< fun.size(); f++){
            if((!fun.get(f).getStatus()&&(fun.get(f).getNome().equals(nome)))){
                fun.get(f).setStatus(true);
                JOptionPane.showMessageDialog(null, "Funcionario activado com sucesso.");
                verf = true;
                break;
            }
        }
        try {
            FileOutputStream fileOutput = new FileOutputStream("Funcionario.txt");
            ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
            
            for (int f = 0; f< fun.size(); f++){
                objOutput.writeObject(fun.get(f));
            }
            
            objOutput.flush();
            fileOutput.flush();
            objOutput.close();
            fileOutput.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!"+ e.getMessage());
        }
        if(!verf)
            JOptionPane.showMessageDialog(null, "Funcionario nao encontrado.", "Mensagem", JOptionPane.ERROR_MESSAGE);
    }
    public byte[] retornarImagem(String usuario, String senha){
        ArrayList<Funcionarios> fun = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Funcionario.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Funcionarios vic = null;
            while ((vic = (Funcionarios)objInput.readObject())!= null){
               fun.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        for (int f = 0; f< fun.size(); f++){
            if(fun.get(f).getStatus()==true){
                if((fun.get(f).getNome().equals(usuario))&&(fun.get(f).getSenha()==Long.parseLong(senha))){
                    return fun.get(f).getImagem();
                }
            }
        }
        return null;
    }
    public String retornarCaixa(String usuario, String senha){
        ArrayList<Funcionarios> fun = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Funcionario.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Funcionarios vic = null;
            while ((vic = (Funcionarios)objInput.readObject())!= null){
               fun.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        for (int f = 0; f< fun.size(); f++){
            if(fun.get(f).getStatus()==true){
                if((fun.get(f).getNome().equals(usuario))&&(fun.get(f).getSenha()==Long.parseLong(senha))){
                    return fun.get(f).getAlocacao();
                }
            }
        }
        return null;
    }
}
