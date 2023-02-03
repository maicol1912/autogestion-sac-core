package automanage_user.automagane_user.aplication.Validaciones;

import automanage_user.automagane_user.aplication.Exception.NotTokenValid;
import automanage_user.automagane_user.aplication.Exception.NotValidException;
import automanage_user.automagane_user.commons.Exceptions.CodigoErrorEnum;
import automanage_user.automagane_user.infraestructure.Controller.QueryController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ValidacionCambioEstadoUsuario {

    private static final Logger LOGGER = Logger.getLogger(ValidacionCambioEstadoUsuario.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public Boolean validarToken(String token){

        LOGGER.info("se inicia validacion del token de autorizacion");

        String TOKEN_AUTENTICADOR = "1707a235937a8330cc761917450ffbad";
        token = token.replace("Bearer ","");
        if(token.isEmpty()){
            throw new NotTokenValid(CodigoErrorEnum.NOT_TOKEN_VALID.getMessage());
        }
        if(!(token.equals(TOKEN_AUTENTICADOR))){
            throw new NotTokenValid(CodigoErrorEnum.NOT_TOKEN_VALID.getMessage());
        }

        LOGGER.info("el token se valido y el estado es -> valido");
        return true;
    }

    public Boolean validarEstadoUsuarioParaCambio(String cedula){
        String ESTADO_ACTUAL_EMPLEADO = String.format("select epl_estado  from sai_empleado se where epl_nroid =  '%s' limit 1",cedula);
        String ESTADO_ACTUAL_USUARIO = String.format("select usu_estado  from sai_usuario su where epl_nroid =  '%s' limit 1",cedula);
        String ESTADO_ACTUAL_USUARIO_POR_CAJA = String.format("select distinct (uc.upc_estado) from sai_usuario su\n" +
                "inner join sac_usuarioporcaja uc on su.usu_usuario = uc.usu_usuario \n" +
                "where su.epl_nroid = '%s'",cedula);

        LOGGER.info("se inicia validacion del estado del usuario a cambiar de estado");

        if(jdbcTemplate.queryForObject(ESTADO_ACTUAL_EMPLEADO,String.class).equals("I")||jdbcTemplate.queryForObject(ESTADO_ACTUAL_USUARIO,String.class).equals("I")||
           jdbcTemplate.queryForObject(ESTADO_ACTUAL_USUARIO_POR_CAJA,String.class).equals("I")){

            throw new NotTokenValid(CodigoErrorEnum.USUARIO_YA_ACTIVO.getMessage());
        }

        LOGGER.info("se valida que el usuario es apto para cambio de estado");
        return true;
    }
}