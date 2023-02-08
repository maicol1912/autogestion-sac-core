package automanage_user.automagane_user.aplication.Validaciones;
import automanage_user.automagane_user.aplication.Exception.SpecifiedException;
import automanage_user.automagane_user.commons.Exceptions.CodigoErrorEnum;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ValidacionCambioEstadoUsuario {

    
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Boolean validarEstadoUsuarioParaCambio(String cedula){
        String ESTADO_ACTUAL_EMPLEADO = String.format("select epl_estado  from sai_empleado se where epl_nroid =  '%s' limit 1",cedula);
        String ESTADO_ACTUAL_USUARIO = String.format("select usu_estado  from sai_usuario su where epl_nroid =  '%s' limit 1",cedula);
        String ESTADO_ACTUAL_USUARIO_POR_CAJA = String.format("select distinct (uc.upc_estado) from sai_usuario su\n" +
                "inner join sac_usuarioporcaja uc on su.usu_usuario = uc.usu_usuario \n" +
                "where su.epl_nroid = '%s'",cedula);
        String ESTADO_ACTUAL_EMPLEADO_COUNT = String.format("select COUNT(*)  from sai_empleado se where epl_nroid =  '%s' limit 1",cedula);
        String ESTADO_ACTUAL_USUARIO_COUNT = String.format("select COUNT(*)  from sai_usuario su where epl_nroid =  '%s' limit 1",cedula);
        String ESTADO_ACTUAL_USUARIO_POR_CAJA_COUNT = String.format("select COUNT (*) from sai_usuario su\n" +
                "inner join sac_usuarioporcaja uc on su.usu_usuario = uc.usu_usuario \n" +
                "where su.epl_nroid = '%s'",cedula);

        if(jdbcTemplate.queryForObject(ESTADO_ACTUAL_EMPLEADO_COUNT,Integer.class).equals(0)||
           jdbcTemplate.queryForObject(ESTADO_ACTUAL_USUARIO_COUNT,Integer.class).equals(0)||
           jdbcTemplate.queryForObject(ESTADO_ACTUAL_USUARIO_POR_CAJA_COUNT,Integer.class).equals(0)){
            throw new SpecifiedException(CodigoErrorEnum.CEDULA_NO_EXISTE.getMessage(),401);
        }
        if(jdbcTemplate.queryForObject(ESTADO_ACTUAL_EMPLEADO,String.class).equals("A")){
            throw new SpecifiedException(CodigoErrorEnum.EMPLEADO_YA_ACTIVO.getMessage(),401);
        }
        if(jdbcTemplate.queryForObject(ESTADO_ACTUAL_USUARIO,String.class).equals("A")){
            throw new SpecifiedException(CodigoErrorEnum.USUARIO_YA_ACTIVO.getMessage(),401);
        }
        if(jdbcTemplate.queryForObject(ESTADO_ACTUAL_USUARIO_POR_CAJA,String.class).equals("A")){
            throw new SpecifiedException(CodigoErrorEnum.USUARIO_CAJA_YA_ACTIVO.getMessage(),401);
        }

        return true;
    }
}
