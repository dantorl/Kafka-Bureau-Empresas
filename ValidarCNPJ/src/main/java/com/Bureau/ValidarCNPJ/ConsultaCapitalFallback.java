package com.Bureau.ValidarCNPJ;

public class ConsultaCapitalFallback implements ConsultaCapital {
    private Exception cause;

    ConsultaCapitalFallback(Exception cause) {
        this.cause = cause;
    }

    @Override
    public EmpresaDTO getByCnpj(String cnpj) {
        EmpresaDTO empresaDTO = new EmpresaDTO();
        empresaDTO.setCnpj(cnpj);
        empresaDTO.setNome("CNPJ NÃO ENCONTRADO NA RECEITA");
        empresaDTO.setCapital_social(0.00);
        return empresaDTO;
    }
}
