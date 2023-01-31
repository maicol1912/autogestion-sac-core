package automanage_user.automagane_user.aplication.services;

import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import automanage_user.automagane_user.infraestructure.interfaceService.IUsuario;
import automanage_user.automagane_user.infraestructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UsuarioGeneralDto save(UsuarioGeneralDto usuarioGeneralDto){
        return usuarioRepository.save(usuarioGeneralDto);
    }
}
