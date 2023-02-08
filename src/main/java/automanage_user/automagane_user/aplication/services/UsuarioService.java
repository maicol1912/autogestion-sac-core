package automanage_user.automagane_user.aplication.services;

import automanage_user.automagane_user.aplication.Validaciones.FormatearUsuario;
import automanage_user.automagane_user.aplication.Validaciones.ValidacionUsuarioService;
import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import automanage_user.automagane_user.infraestructure.interfaceService.IUsuario;
import automanage_user.automagane_user.infraestructure.repository.UsuarioRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuario {

    private static final Logger LOGGER = Logger.getLogger(UsuarioService.class);
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ValidacionUsuarioService validacionUsuarioService;

    @Autowired
    private FormatearUsuario formatearUsuario;
    @Override
    public UsuarioGeneralDto save(UsuarioGeneralDto usuarioGeneralDto){
        if(validacionUsuarioService.validateUsuario(formatearUsuario.formatearEntidadUsuario(usuarioGeneralDto))){
            LOGGER.info("el empleado es valido y se inserto en la base de datos");
            return usuarioRepository.save(formatearUsuario.formatearEntidadUsuario(usuarioGeneralDto));
        }
        LOGGER.info("el usuario no se pudo validar y no se realizo la insercion en la base de datos");
        return null;
    }

    @Override
    public Boolean cambiarEstadoUsuario(String cedula) {
        if(!validacionUsuarioService.validateCambioEstadoUsuario(cedula)){
            return false;
        }
        LOGGER.info("se realizo el cambio de estado del usuario");
        return usuarioRepository.cambiarEstado(cedula);
    }


}
