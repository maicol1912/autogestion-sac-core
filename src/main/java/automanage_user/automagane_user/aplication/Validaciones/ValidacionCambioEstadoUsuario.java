package automanage_user.automagane_user.aplication.Validaciones;

import automanage_user.automagane_user.aplication.Exception.NotTokenValid;
import automanage_user.automagane_user.aplication.Exception.NotValidException;
import automanage_user.automagane_user.aplication.Exception.SpecifiedException;
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

    @Autowired
    private ValidacionEmpleadoService validacionEmpleadoService;

    @Autowired
    private ValidacionUsuarioService validacionUsuarioService;

    @Autowired
    private ValidacionUsuarioPorCajaService validacionUsuarioPorCajaService;



    public Boolean validarEstadoUsuarioParaCambio(String cedula){
        String ESTADO_ACTUAL_EMPLEADO = String.format("select epl_estado  from sai_empleado se where epl_nroid =  '%s' limit 1",cedula);
        String ESTADO_ACTUAL_USUARIO = String.format("select usu_estado  from sai_usuario su where epl_nroid =  '%s' limit 1",cedula);
        String ESTADO_ACTUAL_USUARIO_POR_CAJA = String.format("select distinct (uc.upc_estado) from sai_usuario su\n" +
                "inner join sac_usuarioporcaja uc on su.usu_usuario = uc.usu_usuario \n" +
                "where su.epl_nroid = '%s'",cedula);

        LOGGER.info("se inicia validacion del estado del usuario a cambiar de estado");

        if(jdbcTemplate.queryForObject(ESTADO_ACTUAL_EMPLEADO,String.class).equals("A")){
            throw new SpecifiedException(CodigoErrorEnum.EMPLEADO_YA_ACTIVO.getMessage(),401);
        }
        if(jdbcTemplate.queryForObject(ESTADO_ACTUAL_USUARIO,String.class).equals("A")){
            throw new SpecifiedException(CodigoErrorEnum.USUARIO_YA_ACTIVO.getMessage(),401);
        }
        if(jdbcTemplate.queryForObject(ESTADO_ACTUAL_USUARIO_POR_CAJA,String.class).equals("A")){
            throw new SpecifiedException(CodigoErrorEnum.USUARIO_CAJA_YA_ACTIVO.getMessage(),401);
        }

        LOGGER.info("se valida que el usuario es apto para cambio de estado");
        return true;
    }
}
