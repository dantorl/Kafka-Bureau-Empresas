package com.Bureau.GerarCSV;

import com.Bureau.CadastrarCNPJ.Empresa;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class GerarCSVConsumer {
    @KafkaListener(topics = "spec2-daniel-torquato-3", groupId = "batman")
    public void receber(@Payload Empresa empresa) throws IOException {
        System.out.println("Recebi um cadastro" + empresa.getNome() + " CNPJ " + empresa.getCnpj() + " Status " + empresa.getStatus());
        try {
            // O parametro é que indica se deve sobrescrever ou continua no
            // arquivo.
            FileWriter fw = new FileWriter("/home/a2/Documentos/Daniel Torquato - Itau/Kafka - Exercicio 2/CadastroEmpresas.txt", true);
            BufferedWriter conexao = new BufferedWriter(fw);
            conexao.write(empresa.getCnpj() + ";" + empresa.getNome() + ";" + empresa.getCapital() + ";" + empresa.getStatus() + ";");
            conexao.newLine();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
