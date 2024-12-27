package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosReservaConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSinOtraConsultaEnElMismoDia implements ValidadorDeConsultas {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DatosReservaConsulta datos){
        var primerHorario = datos.fecha().withHour(7);
        var ultimoHoraro = datos.fecha().withHour(18);

        var pacienteTieneOtraconsultaEnElDia = repository.existsByPacienteIdAndFechaBetween(datos.idPaciente(), primerHorario, ultimoHoraro);
        if (pacienteTieneOtraconsultaEnElDia){
            throw new ValidacionException("El paciente ya tiene una consulta reservada para este dia");
        }
    }
}
