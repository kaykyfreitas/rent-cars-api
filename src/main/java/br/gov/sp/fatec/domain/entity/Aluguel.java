package br.gov.sp.fatec.domain.entity;

import br.gov.sp.fatec.domain.enums.AluguelStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Aluguel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "data_inicio", nullable = false)
    private Date dataInicio;

    @Column(name = "data_fim", nullable = false)
    private Date dataFim;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AluguelStatus status;

    @OneToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
