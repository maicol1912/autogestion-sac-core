package automanage_user.automagane_user.aplication.services;

import automanage_user.automagane_user.domain.dto.EmpleadoDto;
import automanage_user.automagane_user.infraestructure.interfaceService.IEmpleado;
import automanage_user.automagane_user.infraestructure.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class EmpleadoService implements IEmpleado {
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Override
    public EmpleadoDto save(EmpleadoDto infoEmpleado){
        return empleadoRepository.save(infoEmpleado);
    }

}
