package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.mapper.ClienteMapper;
import br.gov.sp.fatec.domain.request.ClienteRequest;
import br.gov.sp.fatec.domain.request.ClienteUpdateRequest;
import br.gov.sp.fatec.domain.response.ClienteResponse;
import br.gov.sp.fatec.repository.ClienteRepository;
import br.gov.sp.fatec.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    @Transactional
    public ClienteResponse save(final ClienteRequest clienteRequest) {
        final var cliente = this.clienteMapper.map(clienteRequest);

        final var savedCliente = this.clienteRepository.save(cliente);

        final var clienteResponse = this.clienteMapper.map(savedCliente);

        return clienteResponse;
    }

    @Override
    @Transactional
    public ClienteResponse findById(final Long id) {
        return this.clienteMapper.map(this.clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado."))
        );
    }

    @Override
    @Transactional
    public List<ClienteResponse> findAll() {
        return this.clienteRepository.findAll().stream()
                .map(this.clienteMapper::map)
                .toList();
    }

    @Override
    @Transactional
    public void updateById(final Long id, final ClienteUpdateRequest clienteUpdateRequest) {
        final var saved = this.clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado."));

        final var updated = this.clienteMapper.map(clienteUpdateRequest);
        updated.setId(saved.getId());

        this.clienteRepository.save(updated);
    }

    @Override
    @Transactional
    public void deleteById(final Long id) {
        if (this.clienteRepository.existsById(id))
            this.clienteRepository.deleteById(id);
    }
}
