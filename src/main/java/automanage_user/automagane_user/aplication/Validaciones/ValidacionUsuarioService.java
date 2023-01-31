package automanage_user.automagane_user.aplication.Validaciones;

import automanage_user.automagane_user.aplication.Exception.NotValidException;
import automanage_user.automagane_user.aplication.Exception.SpecifiedException;
import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ValidacionUsuarioService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Boolean validateUsuario(UsuarioGeneralDto usuarioGeneral){
        String FILTRAR_EXISTENCIA_CEDULA = String.format("select COUNT(*) from sai_usuario su where epl_nroid = '%s'",usuarioGeneral.getEpl_nroid());
        String FILTRAR_EXISTENCIA_USUARIO = String.format("select COUNT(*) from sai_usuario su where usu_usuario  = '%s'",usuarioGeneral.getUsu_usuario());

        if(!jdbcTemplate.queryForObject(FILTRAR_EXISTENCIA_USUARIO,int.class).equals(0)){
            throw new NotValidException("el nombre de usuario ingresado ya esta en uso",400);
        }

        if(!jdbcTemplate.queryForObject(FILTRAR_EXISTENCIA_CEDULA,int.class).equals(0)){
            throw new NotValidException("La cedula que ingresaste ya esta asociado a un usuario",400);
        }
        return true;
    }


}
