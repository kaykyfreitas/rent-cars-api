package br.gov.sp.fatec.domain.request;

public record ClienteRequest(
        String nome,
        String cpf,
        String telefone
) {}
