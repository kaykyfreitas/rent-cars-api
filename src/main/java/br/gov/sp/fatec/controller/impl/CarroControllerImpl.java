package br.gov.sp.fatec.controller.impl;

import br.gov.sp.fatec.controller.CarroController;
import br.gov.sp.fatec.domain.request.CarroRequest;
import br.gov.sp.fatec.domain.request.CarroUpdateRequest;
import br.gov.sp.fatec.domain.response.CarroResponse;
import br.gov.sp.fatec.service.CarroService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CarroControllerImpl implements CarroController {

    private final CarroService carroService;

    @Override
    public ResponseEntity<CarroResponse> save(final CarroRequest carro) {
        return ResponseEntity.ok(this.carroService.save(carro));
    }

    @Override
    public ResponseEntity<CarroResponse> findById(final Long id) {
        return ResponseEntity.ok(this.carroService.findById(id));
    }

    @Override
    public ResponseEntity<List<CarroResponse>> findAll() {
        return ResponseEntity.ok(this.carroService.findAll());
    }

    @Override
    public ResponseEntity<Void> updateById(final Long id, final CarroUpdateRequest request) {
        this.carroService.updateById(id, request);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteById(final Long id) {
        this.carroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
