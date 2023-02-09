package automanage_user.automagane_user.aplication.services;
import automanage_user.automagane_user.aplication.Validaciones.FormatearUsuario;
import automanage_user.automagane_user.aplication.Validaciones.ValidacionEmpleadoService;
import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import automanage_user.automagane_user.infraestructure.interfaceService.IEmpleado;
import automanage_user.automagane_user.infraestructure.repository.EmpleadoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService implements IEmpleado {

    private static final Logger LOGGER = Logger.getLogger(EmpleadoService.class);
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private ValidacionEmpleadoService validacionEmpleadoService;

    @Autowired
    private FormatearUsuario formatearUsuario;
    @Override
    public UsuarioGeneralDto save(UsuarioGeneralDto usuarioGeneralDto){
        if(validacionEmpleadoService.validateEmpleado(formatearUsuario.formatearEntidadUsuario(usuarioGeneralDto))){
            LOGGER.info("el empleado es valido y se inserto en la base de datos");
            return empleadoRepository.save(formatearUsuario.formatearEntidadUsuario(usuarioGeneralDto));
        }
        LOGGER.info("el usuario no se pudo validar y no se realizo la insercion en la base de datos");
        return null;
    }

    @Override
    public Boolean cambiarEstadoEmpleado(String cedula) {
        if(!validacionEmpleadoService.validateCambioEstadoEmpleado(cedula)){
            LOGGER.info("no se  cambio el estado del empleado ya que no fue posible realizarlo");
            return false;
        }
        LOGGER.info("se realizo el cambio de estado del empleado");
        return empleadoRepository.cambiarEstado(cedula);
    }


}
