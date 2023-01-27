package automanage_user.automagane_user.aplication.services;


import automanage_user.automagane_user.domain.dto.UsuarioDto;
import automanage_user.automagane_user.domain.dto.UsuarioPorCajaDto;
import automanage_user.automagane_user.infraestructure.interfaceService.IUsuarioPorCaja;
import automanage_user.automagane_user.infraestructure.repository.UsuarioPorCajaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioPorCajaService implements IUsuarioPorCaja {

    @Autowired
    private UsuarioPorCajaRepository usuarioPorCajaRepository;
    @Override
    public UsuarioPorCajaDto save(UsuarioPorCajaDto usuarioPorCajaDto) {
        return usuarioPorCajaRepository.save(usuarioPorCajaDto);
    }

}
