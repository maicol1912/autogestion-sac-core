package automanage_user.automagane_user.aplication.services;

import automanage_user.automagane_user.domain.dto.UsuarioDto;
import automanage_user.automagane_user.infraestructure.interfaceService.IUsuario;
import automanage_user.automagane_user.infraestructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UsuarioService implements IUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UsuarioDto save(UsuarioDto usuarioDto){
        return usuarioRepository.save(usuarioDto);
    }
}
