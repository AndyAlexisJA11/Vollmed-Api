package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosReservaConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarMedicoConOtraConsultaEnelMismoHorario implements ValidadorDeConsultas {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DatosReservaConsulta datos){
        var medicoTieneOtraConsultaEnelMismoHorario = repository.existsByMedicoIdAndFecha(datos.idMedico(), datos.fecha());
        if (medicoTieneOtraConsultaEnelMismoHorario){
            throw new ValidacionException("El médico ya tiene una consulta en esa misma fecha y hora");
        }
    }
}
