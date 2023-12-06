package com.sbmicrocredito.controler;

import com.sbmicrocredito.model.Garantia;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GarantiaDAO {
    public void cadastroGarantia (Garantia p){
        ArrayList<Garantia> gar = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Garantia.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Garantia vic = null;
            while ((vic = (Garantia)objInput.readObject())!= null){
               gar.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo!!" +e);
        }finally{
            gar.add(p);
            try {
            FileOutputStream fileOutput = new FileOutputStream("Garantia.txt");
            ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
            
            for (int f = 0; f< gar.size(); f++){
                objOutput.writeObject(gar.get(f));
            }
            
            objOutput.flush();
            fileOutput.flush();
            objOutput.close();
            fileOutput.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!"+ e.getMessage());
        }
        }
    }
    public void removerGarantia(String nome){
        ArrayList<Garantia> gar = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Garantia.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Garantia vic = null;
            while ((vic = (Garantia)objInput.readObject())!= null){
               gar.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        for (int f = 0; f< gar.size(); f++){
            if(gar.get(f).getNome().equals(nome)){
                gar.remove(f);
                break;
            }
        }
        try {
            FileOutputStream fileOutput = new FileOutputStream("Garantia.txt");
            ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
            
            for (int f = 0; f< gar.size(); f++){
                objOutput.writeObject(gar.get(f));
            }
            
            objOutput.flush();
            fileOutput.flush();
            objOutput.close();
            fileOutput.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!"+ e.getMessage());
        }
    }
}
