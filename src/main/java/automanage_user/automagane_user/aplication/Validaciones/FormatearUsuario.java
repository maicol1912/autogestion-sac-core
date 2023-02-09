package automanage_user.automagane_user.aplication.Validaciones;

import automanage_user.automagane_user.aplication.Exception.NotFoundFields;
import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import org.springframework.stereotype.Component;

@Component
public class FormatearUsuario {

    public UsuarioGeneralDto formatearEntidadUsuario(UsuarioGeneralDto usuarioGeneralDto){

        if(usuarioGeneralDto.getEpl_nroid() == null || usuarioGeneralDto.getEpl_nombreuno()== null ||
            usuarioGeneralDto.getEpl_nombredos()== null|| usuarioGeneralDto.getEpl_apellidouno()== null||
            usuarioGeneralDto.getEpl_apellidodos()== null || usuarioGeneralDto.getEmp_empresa()== null ||
            usuarioGeneralDto.getPuc_puntoCredito()== null){
            throw new NotFoundFields("los campos que intentas enviar no estan completos o mal nombrados",409);
        }

        usuarioGeneralDto.setEpl_nroid(usuarioGeneralDto.getEpl_nroid().trim());
        usuarioGeneralDto.setEpl_nombreuno(usuarioGeneralDto.getEpl_nombreuno().trim().toUpperCase());
        usuarioGeneralDto.setEpl_nombredos(usuarioGeneralDto.getEpl_nombredos().trim().toUpperCase());
        usuarioGeneralDto.setEpl_apellidouno(usuarioGeneralDto.getEpl_apellidouno().trim().toUpperCase());
        usuarioGeneralDto.setEpl_apellidodos(usuarioGeneralDto.getEpl_apellidodos().trim().toUpperCase());
        return usuarioGeneralDto;
    }
}
