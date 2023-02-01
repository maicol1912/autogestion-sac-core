package automanage_user.automagane_user.infraestructure.interfaceService;

import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;

public interface IUsuario {

    public UsuarioGeneralDto save(UsuarioGeneralDto usuarioGeneralDto);

    public Boolean cambiarEstadoUsuario(String cedula);
}
