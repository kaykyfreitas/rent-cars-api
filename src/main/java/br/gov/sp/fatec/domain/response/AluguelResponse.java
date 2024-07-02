package br.gov.sp.fatec.domain.response;

import br.gov.sp.fatec.domain.enums.AluguelStatus;

import java.util.Date;

public record AluguelResponse(
        Long id,
        Date dataInicio,
        Date dataFim,
        Double valor,
        AluguelStatus status,
        Integer carroId,
        Integer clienteId
) {}
