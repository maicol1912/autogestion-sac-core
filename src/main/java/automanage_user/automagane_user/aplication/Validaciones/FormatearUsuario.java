package automanage_user.automagane_user.aplication.Validaciones;

import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import org.springframework.stereotype.Component;

@Component
public class FormatearUsuario {

    public UsuarioGeneralDto formatearEntidadUsuario(UsuarioGeneralDto usuarioGeneralDto){
        usuarioGeneralDto.setEpl_nroid(usuarioGeneralDto.getEpl_nroid().trim());
        usuarioGeneralDto.setEpl_nombreuno(usuarioGeneralDto.getEpl_nombreuno().trim().toUpperCase());
        usuarioGeneralDto.setEpl_nombredos(usuarioGeneralDto.getEpl_nombredos().trim().toUpperCase());
        usuarioGeneralDto.setEpl_apellidouno(usuarioGeneralDto.getEpl_apellidouno().trim().toUpperCase());
        usuarioGeneralDto.setEpl_apellidodos(usuarioGeneralDto.getEpl_apellidodos().trim().toUpperCase());
        return usuarioGeneralDto;
    }
}
