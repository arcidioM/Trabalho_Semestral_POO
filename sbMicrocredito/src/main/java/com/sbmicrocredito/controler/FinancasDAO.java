package com.sbmicrocredito.controler;

import com.sbmicrocredito.model.Cliente;
import com.sbmicrocredito.model.Financas;
import com.sbmicrocredito.model.Relatorio;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 */
public class FinancasDAO {
    public void fundoFinasceiro (Financas p){
        ArrayList<Financas> financas = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Financas.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Financas vic = null;
            while ((vic = (Financas)objInput.readObject())!= null){
               financas.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {
        }finally{
            financas.add(p);
            try {
            FileOutputStream fileOutput = new FileOutputStream("Financas.txt");
            ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
            for (int f = 0; f< financas.size(); f++){
                objOutput.writeObject(financas.get(f));
            }
            
            objOutput.flush();
            fileOutput.flush();
            objOutput.close();
            fileOutput.close();
            JOptionPane.showMessageDialog(null, "Saldo actualizado com sucesso!");
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!"+ e.getMessage());
            }
        }
    }
    public boolean retirarSal(double quantia){
        ArrayList<Financas> financas = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Financas.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Financas vic = null;
            while ((vic = (Financas)objInput.readObject())!= null){
               financas.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        double sal=0;
        for (int f = 0; f< financas.size(); f++){
            sal +=financas.get(f).getSaldo();
        }
        if(quantia >= sal){
            JOptionPane.showMessageDialog(null, "Saldo insuficiente! Contacte a Direccao.","Mensagem", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if((quantia<sal)){
            for (int f = 0; f< financas.size(); f++){
                financas.get(f).setSaldo(financas.get(f).getSaldo() - quantia);
            }
            try {
                FileOutputStream fileOutput = new FileOutputStream("Financas.txt");
                ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
                for (int f = 0; f< financas.size(); f++){
                    objOutput.writeObject(financas.get(f));
                }
            
                objOutput.flush();
                fileOutput.flush();
                objOutput.close();
                fileOutput.close();
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!"+ e.getMessage());
            }
            return true;
        }
        return true;
    }
    public void pagarDividida(String nome){
        ArrayList<Cliente> cli = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Cliente.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Cliente vic = null;
            while ((vic = (Cliente)objInput.readObject())!= null){
               cli.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        for (int f = 0; f< cli.size(); f++){
            if(nome.equals(cli.get(f).getNome())){
                
                ArrayList<Financas> financas = new ArrayList();
                try {
                    FileInputStream fileInput = new FileInputStream("Financas.txt");
                    ObjectInputStream objInput = new ObjectInputStream(fileInput);

                    Financas vic = null;
                    while ((vic = (Financas)objInput.readObject())!= null){
                       financas.add(vic);
                    }
                    objInput.close();
                    fileInput.close();
                } catch (Exception e) {}
                for (int i = 0; i< financas.size(); i++){
                    if(cli.get(f).getStatus()){
                        financas.get(i).setSaldo(financas.get(i).getSaldo() + cli.get(f).getQuantia());
                        financas.get(i).setLucro(financas.get(i).getLucro()+ (cli.get(f).getQuantia()/1.3)*0.3);
                    }
                }
                try {
                    FileOutputStream fileOutput = new FileOutputStream("Financas.txt");
                    ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);

                    for (int j = 0; j< financas.size(); j++){
                        objOutput.writeObject(financas.get(j));
                    }

                    objOutput.flush();
                    fileOutput.flush();
                    objOutput.close();
                    fileOutput.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro!!"+ e.getMessage());
                }
                if(cli.get(f).getStatus()){
                    cli.get(f).setStatus(false);
                    this.relatorio(cli.get(f).getiD(), cli.get(f).getNome(), cli.get(f).getQuantia()/1.3, cli.get(f).getDataEmprestimo(), cli.get(f).getValidadeEmprestimo(), new Cliente().dataActual(), new ClienteDAO().verificadorData(cli.get(f).getNome()));
                    JOptionPane.showMessageDialog(null, "Emprestimo pago com sucesso!");
                }else{
                    JOptionPane.showMessageDialog(null, "O emprestimo ja foi pago com sucesso!", "Mensagem", JOptionPane.ERROR_MESSAGE);
                    
                }
            }
        }
        try {
            FileOutputStream fileOutput = new FileOutputStream("Cliente.txt");
            ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
            
            for (int f = 0; f< cli.size(); f++){
                objOutput.writeObject(cli.get(f));
            }
            
            objOutput.flush();
            fileOutput.flush();
            objOutput.close();
            fileOutput.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!"+ e.getMessage());
        }
    }
    private final boolean registoFundo(){
        ArrayList<Financas> financas = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Financas.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Financas vic = null;
            while ((vic = (Financas)objInput.readObject())!= null){
               financas.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        if(financas.size()==1){
            return false;
        }
        return true;
    }
    public void arecadarFundos(double sal){
        ArrayList<Financas> financas = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Financas.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Financas vic = null;
            while ((vic = (Financas)objInput.readObject())!= null){
               financas.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        for (int f = 0; f< financas.size(); f++){
            financas.get(f).setSaldo(financas.get(f).getSaldo() + sal );
        }
        try {
            FileOutputStream fileOutput = new FileOutputStream("Financas.txt");
            ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
            
            for (int f = 0; f< financas.size(); f++){
                objOutput.writeObject(financas.get(f));
            }
            
            objOutput.flush();
            fileOutput.flush();
            objOutput.close();
            fileOutput.close();
            JOptionPane.showMessageDialog(null, "Saldo actualizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!"+ e.getMessage());
        }
    }
    public boolean retirarLucro(double quantia){
        ArrayList<Financas> financas = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Financas.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Financas vic = null;
            while ((vic = (Financas)objInput.readObject())!= null){
               financas.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        double sal=0, luc=0;
        for (int f = 0; f< financas.size(); f++){
            sal +=financas.get(f).getSaldo();
            luc +=financas.get(f).getLucro();
        }
        if((quantia > sal)&&(quantia > luc)){
            JOptionPane.showMessageDialog(null, "Saldo insuficiente! Contacte a Direccao.","Mensagem", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if((quantia<=sal)&&(quantia<= luc)){
            for (int f = 0; f< financas.size(); f++){
                financas.get(f).setLucro(financas.get(f).getLucro()- quantia);
                financas.get(f).setSaldo(financas.get(f).getSaldo()- quantia);
                JOptionPane.showMessageDialog(null, "Salario pago com sucesso!!!","Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
            try {
                FileOutputStream fileOutput = new FileOutputStream("Financas.txt");
                ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
                for (int f = 0; f< financas.size(); f++){
                    objOutput.writeObject(financas.get(f));
                }
            
                objOutput.flush();
                fileOutput.flush();
                objOutput.close();
                fileOutput.close();
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!"+ e.getMessage());
            }
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Saldo Insuficiente para o pagamento do Salario.", "Mensagem", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public double consultarSaldo(){
        ArrayList<Financas> financas = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Financas.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Financas vic = null;
            while ((vic = (Financas)objInput.readObject())!= null){
               financas.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        double saldo = 0;
        for (int f = 0; f< 1; f++){
            saldo = financas.get(0).getSaldo();
        }
        return saldo;
    }
    public double consultarLucro(){
        ArrayList<Financas> financas = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Financas.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Financas vic = null;
            while ((vic = (Financas)objInput.readObject())!= null){
               financas.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        double lucro = 0;
        for (int f = 0; f< 1; f++){
            lucro = financas.get(0).getLucro();
        }
        return lucro;
    }
    public long sizee(){
        ArrayList<Financas> financas = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Financas.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Financas vic = null;
            while ((vic = (Financas)objInput.readObject())!= null){
               financas.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        return financas.size();
    }
    public void pagarRenovarEm(String nome){
        ArrayList<Cliente> cli = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Cliente.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Cliente vic = null;
            while ((vic = (Cliente)objInput.readObject())!= null){
               cli.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo!!" +e);
        }
        for (int f = 0; f< cli.size(); f++){
            if(nome.equals(cli.get(f).getNome())){
                
                ArrayList<Financas> financas = new ArrayList();
                try {
                    FileInputStream fileInput = new FileInputStream("Financas.txt");
                    ObjectInputStream objInput = new ObjectInputStream(fileInput);

                    Financas vic = null;
                    while ((vic = (Financas)objInput.readObject())!= null){
                       financas.add(vic);
                    }
                    objInput.close();
                    fileInput.close();
                } catch (Exception e) {}
                for (int i = 0; i< financas.size(); i++){
                    financas.get(0).setSaldo(financas.get(0).getSaldo() + (cli.get(f).getQuantia()/1.3)*0.3);
                    financas.get(0).setLucro(financas.get(0).getLucro()+ (cli.get(f).getQuantia()/1.3)*0.3);
                }
                try {
                    FileOutputStream fileOutput = new FileOutputStream("Financas.txt");
                    ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);

                    for (int j = 0; j< financas.size(); j++){
                        objOutput.writeObject(financas.get(j));
                    }

                    objOutput.flush();
                    fileOutput.flush();
                    objOutput.close();
                    fileOutput.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro!!"+ e.getMessage());
                }
                break;
            }
        }
        try {
            FileOutputStream fileOutput = new FileOutputStream("Cliente.txt");
            ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
            
            for (int f = 0; f< cli.size(); f++){
                objOutput.writeObject(cli.get(f));
            }
            
            objOutput.flush();
            fileOutput.flush();
            objOutput.close();
            fileOutput.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!"+ e.getMessage());
        }
    }
    public void relatorio(long id, String nome, double valor, String dataEmprestimo, String validade, String dataPagamento, boolean classif){
        String classificacao;
        if(classif){
            classificacao = "Pessimo";
        }else{
            classificacao = "Bom";
        }
        new RelatorioDAO().elaborarRelatorio(new Relatorio(id, nome, valor, dataEmprestimo, validade, dataPagamento, classificacao));
        
    }
}
