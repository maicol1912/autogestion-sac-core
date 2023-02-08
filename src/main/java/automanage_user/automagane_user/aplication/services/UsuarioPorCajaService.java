package automanage_user.automagane_user.aplication.services;


import automanage_user.automagane_user.aplication.Validaciones.FormatearUsuario;
import automanage_user.automagane_user.aplication.Validaciones.ValidacionUsuarioPorCajaService;
import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import automanage_user.automagane_user.infraestructure.interfaceService.IUsuarioPorCaja;
import automanage_user.automagane_user.infraestructure.repository.UsuarioPorCajaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioPorCajaService implements IUsuarioPorCaja {

    private static final Logger LOGGER = Logger.getLogger(UsuarioPorCajaService.class);
    @Autowired
    private UsuarioPorCajaRepository usuarioPorCajaRepository;

    @Autowired
    private ValidacionUsuarioPorCajaService validacionUsuarioPorCajaService;
    @Autowired
    private FormatearUsuario formatearUsuario;
    @Override
    public UsuarioGeneralDto save(UsuarioGeneralDto usuarioGeneralDto) {
        if(validacionUsuarioPorCajaService.validateUsuarioPorCaja(formatearUsuario.formatearEntidadUsuario(usuarioGeneralDto))){
            LOGGER.info("el empleado es valido y se inserto en la base de datos");
            return usuarioPorCajaRepository.save(formatearUsuario.formatearEntidadUsuario(usuarioGeneralDto));
        }
        LOGGER.info("el usuario no se pudo validar y no se realizo la insercion en la base de datos");
        return null;
    }

    @Override
    public Boolean cambiarEstadoUsuarioPorCaja(String cedula) {
        if(!validacionUsuarioPorCajaService.validateCambioEstadoUsuarioPorCaja(cedula)){
            return false;
        }
        LOGGER.info("se realizo el cambio de estado del usuario por caja");
        return usuarioPorCajaRepository.cambiarEstado(cedula);
    }


}
