create table consultas (
    id bigint NOT NULL auto_increment,
    medico_id bigint NOT NULL,
    paciente_id bigint not null,
    fecha datetime NOT NULL,

    primary key (id),
    constraint fk_consultas_medico_id foreign key (medico_id) references medicos(id),
    constraint fk_consultas_paciente_id foreign key (paciente_id) references pacientes(id)

  );
