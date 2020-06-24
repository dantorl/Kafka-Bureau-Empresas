package com.Bureau.ValidarCNPJ;

import com.Bureau.CadastrarCNPJ.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class ValidarCNPJConsumer {

    @Autowired
    private ConsultaCapital consultaCapital;

    @Autowired
    private AtualizarEmpresaProducer atualizarEmpresaProducer;

    @KafkaListener(topics = "spec2-daniel-torquato-2", groupId = "batman")
    public void receber(@Payload Empresa empresa){
        System.out.println("Recebi cadastro " + empresa.getNome() + " CNPJ" + empresa.getCnpj());
        EmpresaDTO empresaDTO;
        empresaDTO = consultaCapital.getByCnpj(empresa.getCnpj());

        empresa.setNome(empresaDTO.getNome());
        empresa.setCapital(empresaDTO.getCapital_social());
        empresa.setCnpj(empresaDTO.getCnpj());

        if(empresaDTO.getCapital_social() >= 1000000.00){
            empresa.setStatus("APROVADO");
        }else{
            empresa.setStatus("NEGADO");
        }

        System.out.println("Consultei cadastro receita" + empresa.getNome() + " CNPJ " + empresa.getCnpj() + " Status " + empresa.getStatus());

        atualizarEmpresaProducer.enviarAoKafka(empresa);
    }
}
