package com.Bureau.ValidarCNPJ;

import com.Bureau.CadastrarCNPJ.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AtualizarEmpresaProducer {
    @Autowired
    private KafkaTemplate<String, Empresa> producer;

    public void enviarAoKafka(Empresa empresa) {

        producer.send("spec2-daniel-torquato-3", empresa);

        System.out.println("Atualizei o cadastro da empresa" + empresa.getNome() + " CNPJ " + empresa.getCnpj() + " Status " + empresa.getStatus());
    }
}
