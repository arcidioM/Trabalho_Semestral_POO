package com.sbmicrocredito.controler;

import com.sbmicrocredito.model.Relatorio;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class RelatorioDAO {
    public void elaborarRelatorio (Relatorio p){
        ArrayList<Relatorio> relat = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Relatorio.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Relatorio vic = null;
            while ((vic = (Relatorio)objInput.readObject())!= null){
               relat.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {
        }finally{
            relat.add(p);
            try {
            FileOutputStream fileOutput = new FileOutputStream("Relatorio.txt");
            ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
            
            for (int f = 0; f< relat.size(); f++){
                objOutput.writeObject(relat.get(f));
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
    
}
