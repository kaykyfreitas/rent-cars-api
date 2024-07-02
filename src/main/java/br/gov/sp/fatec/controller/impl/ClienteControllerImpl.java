package br.gov.sp.fatec.controller.impl;

import br.gov.sp.fatec.controller.ClienteController;
import br.gov.sp.fatec.domain.request.ClienteRequest;
import br.gov.sp.fatec.domain.request.ClienteUpdateRequest;
import br.gov.sp.fatec.domain.response.ClienteResponse;
import br.gov.sp.fatec.service.ClienteService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClienteControllerImpl implements ClienteController {

    private final ClienteService clienteService;

    @Override
    public ResponseEntity<ClienteResponse> save(final ClienteRequest cliente) {
        return ResponseEntity.ok(this.clienteService.save(cliente));
    }

    @Override
    public ResponseEntity<ClienteResponse> findById(final Long id) {
        return ResponseEntity.ok(this.clienteService.findById(id));
    }

    @Override
    public ResponseEntity<List<ClienteResponse>> findAll() {
        return ResponseEntity.ok(this.clienteService.findAll());
    }

    @Override
    public ResponseEntity<Void> updateById(final Long id, final ClienteUpdateRequest request) {
        this.clienteService.updateById(id, request);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteById(final Long id) {
        this.clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
