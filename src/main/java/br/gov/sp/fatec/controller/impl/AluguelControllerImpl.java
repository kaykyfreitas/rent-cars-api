package br.gov.sp.fatec.controller.impl;

import br.gov.sp.fatec.controller.AluguelController;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.AluguelUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import br.gov.sp.fatec.service.AluguelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AluguelControllerImpl implements AluguelController {

    private final AluguelService aluguelService;

    @Override
    public ResponseEntity<AluguelResponse> save(final AluguelRequest aluguel) {
        return ResponseEntity.ok(this.aluguelService.save(aluguel));
    }

    @Override
    public ResponseEntity<AluguelResponse> findById(final Long id) {
        return ResponseEntity.ok(this.aluguelService.findById(id));
    }

    @Override
    public ResponseEntity<List<AluguelResponse>> findAll() {
        return ResponseEntity.ok(this.aluguelService.findAll());
    }

    @Override
    public ResponseEntity<Void> updateById(final Long id, final AluguelUpdateRequest request) {
        this.aluguelService.updateById(id, request);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteById(final Long id) {
        this.aluguelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
