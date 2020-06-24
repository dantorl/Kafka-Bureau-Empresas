package com.Bureau.CadastrarCNPJ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CadastroProducer {
    @Autowired
    private KafkaTemplate<String, Empresa> producer;

    public Empresa enviarAoKafka(String cnpj, String nome) {
        Empresa empresa = new Empresa();

        empresa.setCnpj(cnpj);
        empresa.setNome(nome);
        empresa.setCapital(0.00);

        producer.send("spec2-daniel-torquato-2", empresa);

        return empresa;
    }
}
