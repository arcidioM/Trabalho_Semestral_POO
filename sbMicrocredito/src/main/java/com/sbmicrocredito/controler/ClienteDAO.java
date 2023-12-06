package com.sbmicrocredito.controler;

import com.sbmicrocredito.model.Cliente;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteDAO {
    public void cadastroCliente (Cliente p){
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
        }finally{
            cli.add(p);
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
            JOptionPane.showMessageDialog(null, "Emprestimo efectuado com Sucesso.");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!"+ e.getMessage());
        }
        }
    }
    public long numeroID(){
        ArrayList<Cliente> fun = new ArrayList();
        long codigo= 0;
        try {
            FileInputStream fileInput = new FileInputStream("Cliente.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Cliente vic = null;
            while ((vic = (Cliente)objInput.readObject())!= null){
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
                if(codigo == fun.get(f).getiD()){
                    verificador=true;
                }
            }
        }
        return codigo;
    }
    public boolean consultar(String nome){
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
            if(cli.get(f).getNome().equals(nome))
                return false;
            break;
        }
        return true;
    }
    public void actualizar(long Id, String numeroBI, String profissao, String localResidencia, String numeroQuarteirao, String numeroCasa, String provincia,
            long contacto, long contactoAlternativo){
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
            if(cli.get(f).getiD()==Id){
                cli.get(f).setNumeroBI(numeroBI);
                cli.get(f).setProfissao(profissao);
                cli.get(f).setLocalResidencia(localResidencia);
                cli.get(f).setQuarterao(numeroQuarteirao);
                cli.get(f).setNumeroCasa(numeroCasa);
                cli.get(f).setProvincia(provincia);
                cli.get(f).setContacto(contacto);
                cli.get(f).setContactoAlt(contactoAlternativo);
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
            JOptionPane.showMessageDialog(null, "Dados actualizados com Sucesso!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!"+ e.getMessage(), "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
    }
    public boolean verificadorData(String nome){
        boolean verf = false;
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
            if(cli.get(f).getNome().equals(nome)){
                LocalDate dataDoSistema = LocalDate.now();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataIntroduzida = LocalDate.parse(cli.get(f).getDataEmprestimo(), formatter);

                long mesesPassados = ChronoUnit.MONTHS.between(dataIntroduzida, dataDoSistema);
                if(mesesPassados>=1){
                    verf = true;
                    break;
                }
            }
        }
        return verf;
    }
    public void renovarEmprestimo(String nome){
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
            if(cli.get(f).getNome().equals(nome)){
                cli.get(f).setDataEmprestimo(new Cliente().dataActual());
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
            JOptionPane.showMessageDialog(null, "Emprestimo renovado com Sucesso!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!"+ e.getMessage(), "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public long contEmprestimos(){
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
        return cli.size();
    }
    public long contEmprestimosActivos(){
        long cont = 0;
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
            if(cli.get(f).getStatus()){
                cont += 1;
            }
        }
        return cont;
    }
    public long contEmprestimosNaoActivos(){
        long cont = 0;
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
            if(!cli.get(f).getStatus()){
                cont += 1;
            }
        }
        return cont;
    }
}