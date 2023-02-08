package automanage_user.automagane_user.aplication.services;

import automanage_user.automagane_user.aplication.Exception.SpecifiedException;
import automanage_user.automagane_user.aplication.Validaciones.FormatearUsuario;
import automanage_user.automagane_user.aplication.Validaciones.ValidacionEmpleadoService;
import automanage_user.automagane_user.aplication.Validaciones.ValidacionUsuarioService;
import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import automanage_user.automagane_user.infraestructure.interfaceService.IEmpleado;
import automanage_user.automagane_user.infraestructure.repository.EmpleadoRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService implements IEmpleado {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private ValidacionEmpleadoService validacionEmpleadoService;

    @Autowired
    private FormatearUsuario formatearUsuario;
    @Override
    public UsuarioGeneralDto save(UsuarioGeneralDto usuarioGeneralDto){
        if(validacionEmpleadoService.validateEmpleado(formatearUsuario.formatearEntidadUsuario(usuarioGeneralDto))){
            return empleadoRepository.save(formatearUsuario.formatearEntidadUsuario(usuarioGeneralDto));
        }
        return null;
    }

    @Override
    public Boolean cambiarEstadoEmpleado(String cedula) {
        if(!validacionEmpleadoService.validateCambioEstadoEmpleado(cedula)){
            return false;
        }
        return empleadoRepository.cambiarEstado(cedula);
    }


}
