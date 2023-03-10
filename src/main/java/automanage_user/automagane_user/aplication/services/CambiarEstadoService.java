package automanage_user.automagane_user.aplication.services;
import automanage_user.automagane_user.aplication.Validaciones.ValidacionCambioEstadoUsuario;
import automanage_user.automagane_user.aplication.Validaciones.ValidacionEmpleadoService;
import automanage_user.automagane_user.aplication.Validaciones.ValidacionUsuarioPorCajaService;
import automanage_user.automagane_user.aplication.Validaciones.ValidacionUsuarioService;
import automanage_user.automagane_user.infraestructure.repository.UsuarioPorCajaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CambiarEstadoService {

    private static final Logger LOGGER = Logger.getLogger(CambiarEstadoService.class);
    @Autowired
    private ValidacionEmpleadoService validacionEmpleadoService;

    @Autowired
    private ValidacionUsuarioService validacionUsuarioService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private UsuarioPorCajaRepository usuarioPorCajaRepository;

    @Autowired
    private ValidacionUsuarioPorCajaService validacionUsuarioPorCajaService;

    @Autowired
    private ValidacionCambioEstadoUsuario validacionCambioEstadoUsuario;

    @Transactional
    public Boolean cambiarEstadoUsuarioGeneral(String cedula){
        validacionEmpleadoService.validateCambioEstadoEmpleado(cedula);
        validacionUsuarioService.validateCambioEstadoUsuario(cedula);
        validacionUsuarioPorCajaService.validateCambioEstadoUsuarioPorCaja(cedula);
        validacionCambioEstadoUsuario.validarEstadoUsuarioParaCambio(cedula);
        usuarioService.cambiarEstadoUsuario(cedula);
        empleadoService.cambiarEstadoEmpleado(cedula);
        usuarioPorCajaRepository.cambiarEstado(cedula);
        LOGGER.info("se valido el cambio de estado del usuario, y este es valido");
        return true;
    }
}
