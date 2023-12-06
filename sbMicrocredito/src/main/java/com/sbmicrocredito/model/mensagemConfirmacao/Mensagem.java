/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sbmicrocredito.model.mensagemConfirmacao;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Mensagem {
    public void mensagem(String nome, double valor, long codigo, String validade) {
        try {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            String dateStr = dateFormat.format(date);
            Twilio.init("ACb89ad02a4c2af7eba77c09daa758c58d", "f3b0fd32b3a727593c5279f5a6713e5f");
            Message message = Message.creator(
            new com.twilio.type.PhoneNumber("+258874352370"),
            new com.twilio.type.PhoneNumber("+16186740522"),
            "Confirmado Ajkk"+ codigo+ "Q. Efectou um emprestimo de "+ valor+" Mt na SB_Microcredito Aos "+ dateStr+ " valido ate "+ validade+".")
            .create();

            System.out.println(message.getBody());
        } catch (Exception e) {
        }
        
    }
}
