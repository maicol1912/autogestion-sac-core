package automanage_user.automagane_user.aplication.services;

import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import automanage_user.automagane_user.infraestructure.interfaceService.IEmpleado;
import automanage_user.automagane_user.infraestructure.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService implements IEmpleado {
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Override
    public UsuarioGeneralDto save(UsuarioGeneralDto usuarioGeneral){
        return empleadoRepository.save(usuarioGeneral);
    }

}
