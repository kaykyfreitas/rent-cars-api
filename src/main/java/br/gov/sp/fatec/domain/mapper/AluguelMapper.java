package br.gov.sp.fatec.domain.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.AluguelUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = SPRING)
public interface AluguelMapper {
    Aluguel map(AluguelRequest source);

    AluguelResponse map(Aluguel source);

    Aluguel map(AluguelUpdateRequest source);
}
