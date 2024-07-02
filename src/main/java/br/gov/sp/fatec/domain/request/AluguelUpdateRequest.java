package br.gov.sp.fatec.domain.request;

import br.gov.sp.fatec.domain.enums.AluguelStatus;

import java.util.Date;

public record AluguelUpdateRequest(
        Date dataInicio,
        Date dataFim,
        Double valor,
        AluguelStatus status,
        Long carroId,
        Long clienteId
) {}
