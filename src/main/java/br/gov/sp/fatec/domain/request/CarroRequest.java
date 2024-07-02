package br.gov.sp.fatec.domain.request;

public record CarroRequest(
        String modelo,
        String marca,
        Integer ano,
        String status
) {}
