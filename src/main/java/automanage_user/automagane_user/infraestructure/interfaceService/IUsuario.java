package automanage_user.automagane_user.infraestructure.interfaceService;

import automanage_user.automagane_user.domain.dto.EmpleadoDto;
import automanage_user.automagane_user.domain.dto.UsuarioDto;

import java.security.NoSuchAlgorithmException;

public interface IUsuario {

    public UsuarioDto save(UsuarioDto usuarioDto);

}
