package br.gov.sp.fatec.domain.response;

public record ClienteResponse(
        Long id,
        String nome,
        String cpf,
        String telefone
) {}
