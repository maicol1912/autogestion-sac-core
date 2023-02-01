package automanage_user.automagane_user.infraestructure.interfaceService;

import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;

public interface IUsuarioPorCaja {
    public UsuarioGeneralDto save(UsuarioGeneralDto usuarioPorCajaDto);
    public Boolean cambiarEstadoUsuarioPorCaja(String cedula);
}
