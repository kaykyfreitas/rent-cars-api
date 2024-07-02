package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.mapper.CarroMapper;
import br.gov.sp.fatec.domain.request.CarroRequest;
import br.gov.sp.fatec.domain.request.CarroUpdateRequest;
import br.gov.sp.fatec.domain.response.CarroResponse;
import br.gov.sp.fatec.repository.CarroRepository;
import br.gov.sp.fatec.service.CarroService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarroServiceImpl implements CarroService {

    private final CarroRepository carroRepository;
    private final CarroMapper carroMapper;

    @Override
    @Transactional
    public CarroResponse save(final CarroRequest carroRequest) {
        return this.carroMapper.map(this.carroRepository.save(this.carroMapper.map(carroRequest)));
    }

    @Override
    @Transactional
    public CarroResponse findById(final Long id) {
        return this.carroMapper.map(this.carroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado."))
        );
    }

    @Override
    @Transactional
    public List<CarroResponse> findAll() {
        return this.carroRepository.findAll().stream()
                .map(this.carroMapper::map)
                .toList();
    }

    @Override
    @Transactional
    public void updateById(final Long id, final CarroUpdateRequest carroUpdateRequest) {
        final var saved = this.carroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado."));

        final var updated = this.carroMapper.map(carroUpdateRequest);
        updated.setId(saved.getId());

        this.carroRepository.save(updated);
    }

    @Override
    @Transactional
    public void deleteById(final Long id) {
        if (this.carroRepository.existsById(id))
            this.carroRepository.deleteById(id);
    }
}
