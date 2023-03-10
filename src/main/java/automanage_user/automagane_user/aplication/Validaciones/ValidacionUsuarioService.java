package automanage_user.automagane_user.aplication.Validaciones;

import automanage_user.automagane_user.aplication.Exception.NotFoundActivateUser;
import automanage_user.automagane_user.aplication.Exception.NotValidException;
import automanage_user.automagane_user.commons.Exceptions.CodigoErrorEnum;
import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ValidacionUsuarioService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Boolean validateUsuario(UsuarioGeneralDto usuarioGeneraldto){
        String FILTRAR_EXISTENCIA_CEDULA = String.format("select COUNT(*) from sai_usuario su where epl_nroid = '%s'",usuarioGeneraldto.getEpl_nroid());
        String FILTRAR_EXISTENCIA_USUARIO = String.format("select COUNT(*) from sai_usuario su where usu_usuario  = '%s'",usuarioGeneraldto.getEpl_nroid());

        if(!jdbcTemplate.queryForObject(FILTRAR_EXISTENCIA_USUARIO,int.class).equals(0)){
            throw new NotValidException(CodigoErrorEnum.USUARIO_USADO.getMessage());
        }
        if(!jdbcTemplate.queryForObject(FILTRAR_EXISTENCIA_CEDULA,int.class).equals(0)){
            throw new NotValidException(CodigoErrorEnum.CEDULA_NO_EXISTE.getMessage());
        }
        return true;
    }

    public Boolean validateCambioEstadoUsuario(String cedula){
        String FILTRAR_EXISTENCIA_EMPLEADO = String.format("select COUNT(*) from sai_usuario  where epl_nroid  ='%s'",cedula);
        if(FILTRAR_EXISTENCIA_EMPLEADO.equals(0)){
            throw new NotFoundActivateUser(CodigoErrorEnum.USUARIO_CAMBIAR_ESTADO.getMessage());
        }
        return true;
    }

}
