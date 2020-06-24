package com.Bureau.CadastrarCNPJ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastroController {

    @Autowired
    private CadastroProducer cadastroProducer;

    @PostMapping("/cadastraremp/{cnpj}/{nome}")
    public Empresa create(@PathVariable String cnpj, @PathVariable String nome) {
        return cadastroProducer.enviarAoKafka(cnpj, nome);
    }
}
