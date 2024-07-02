package br.gov.sp.fatec.domain.response;

public record CarroResponse(
        Long id,
        String modelo,
        String marca,
        Integer ano,
        String status
) {}
