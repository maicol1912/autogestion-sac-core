package automanage_user.automagane_user.aplication.Validaciones;

import automanage_user.automagane_user.aplication.Exception.NotValidException;
import automanage_user.automagane_user.commons.ErrorEnum.ErrorStatus;
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
            throw new NotValidException(ErrorStatus.USER_USED.getMessage(),ErrorStatus.USER_USED.getStatus(), ErrorStatus.USER_USED.getCode());
        }

        if(!jdbcTemplate.queryForObject(FILTRAR_EXISTENCIA_CEDULA,int.class).equals(0)){
            throw new NotValidException(ErrorStatus.EMPRESA_NO_EXISTE.getMessage(),ErrorStatus.EMPRESA_NO_EXISTE.getStatus(), ErrorStatus.EMPRESA_NO_EXISTE.getCode());
        }
        return true;
    }


}
