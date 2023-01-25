package automanage_user.automagane_user.aplication.services;

import automanage_user.automagane_user.domain.dto.EmpleadoDto;
import automanage_user.automagane_user.domain.entity.Empleado;
import automanage_user.automagane_user.infraestructure.interfaceService.IEmployed;
import automanage_user.automagane_user.infraestructure.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployedService implements IEmployed {
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Override
    public void save(EmpleadoDto infoEmpleado) {
        empleadoRepository.save(infoEmpleado);
    }

}
