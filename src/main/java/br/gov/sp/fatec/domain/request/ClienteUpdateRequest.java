package br.gov.sp.fatec.domain.request;

public record ClienteUpdateRequest(
        String nome,
        String cpf,
        String telefone
) {}
