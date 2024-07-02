package br.gov.sp.fatec.domain.entity;

import br.gov.sp.fatec.domain.enums.CarroStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Carro {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "ano", nullable = false)
    private Integer ano;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CarroStatus status;

}
