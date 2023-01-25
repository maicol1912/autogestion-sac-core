package automanage_user.automagane_user.infraestructure.interfaceService;

import automanage_user.automagane_user.domain.dto.EmpleadoDto;
import automanage_user.automagane_user.domain.entity.Empleado;

import java.util.Optional;

public interface IEmployed {

    public void save(EmpleadoDto empleadoDto);

}
