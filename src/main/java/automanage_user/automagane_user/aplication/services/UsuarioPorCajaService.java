package automanage_user.automagane_user.aplication.services;


import automanage_user.automagane_user.aplication.Validaciones.FormatearUsuario;
import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import automanage_user.automagane_user.infraestructure.interfaceService.IUsuarioPorCaja;
import automanage_user.automagane_user.infraestructure.repository.UsuarioPorCajaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioPorCajaService implements IUsuarioPorCaja {

    @Autowired
    private UsuarioPorCajaRepository usuarioPorCajaRepository;

    @Autowired
    private FormatearUsuario formatearUsuario;
    @Override
    public UsuarioGeneralDto save(UsuarioGeneralDto usuarioGeneralDto) {
        return usuarioPorCajaRepository.save(formatearUsuario.formatearEntidadUsuario(usuarioGeneralDto));
    }

}
