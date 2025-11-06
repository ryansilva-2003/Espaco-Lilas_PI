package com.espacolilas.espacolilas.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "agendamentos")
public class Agendamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_agendamento", nullable = false)
    private Integer id_agendamento;

    @Column (name = "id_paciente", nullable = false)
    private Integer id_paciente;

    @Column (name = "id_profissional", nullable = false)
    private Integer id_profissional;

    @Column (name = "data", nullable = false)
    private LocalDate data;

    @Column (name = "hora_inicio", nullable = false)
    private LocalTime hora_inicio;

    @Column (name = "hora_fim", nullable = false)
    private LocalTime hora_fim;
}
