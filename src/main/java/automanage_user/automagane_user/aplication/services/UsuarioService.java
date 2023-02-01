package automanage_user.automagane_user.aplication.services;

import automanage_user.automagane_user.aplication.Validaciones.FormatearUsuario;
import automanage_user.automagane_user.aplication.Validaciones.ValidacionUsuarioService;
import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import automanage_user.automagane_user.infraestructure.interfaceService.IUsuario;
import automanage_user.automagane_user.infraestructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ValidacionUsuarioService validacionUsuarioService;

    @Autowired
    private FormatearUsuario formatearUsuario;
    @Override
    public UsuarioGeneralDto save(UsuarioGeneralDto usuarioGeneralDto){
        if(validacionUsuarioService.validateUsuario(formatearUsuario.formatearEntidadUsuario(usuarioGeneralDto))){
            return usuarioRepository.save(formatearUsuario.formatearEntidadUsuario(usuarioGeneralDto));
        }
        return null;
    }

    @Override
    public Boolean cambiarEstadoUsuario(String cedula) {
        if(!validacionUsuarioService.validateCambioEstadoEmpleado(cedula)){
            return false;
        }
        return true;
    }


}
