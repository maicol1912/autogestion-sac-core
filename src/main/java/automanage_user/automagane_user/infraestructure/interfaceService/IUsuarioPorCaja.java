package automanage_user.automagane_user.infraestructure.interfaceService;

import automanage_user.automagane_user.domain.dto.UsuarioDto;
import automanage_user.automagane_user.domain.dto.UsuarioPorCaja;

import java.util.Optional;

public interface IUsuarioPorCaja {
    public void save(UsuarioPorCaja usuarioPorCaja);
}
