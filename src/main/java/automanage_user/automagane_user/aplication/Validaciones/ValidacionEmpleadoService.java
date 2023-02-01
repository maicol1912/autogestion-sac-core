package automanage_user.automagane_user.aplication.Validaciones;
import automanage_user.automagane_user.aplication.Exception.NotValidException;
import automanage_user.automagane_user.commons.ErrorEnum.ErrorStatus;
import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ValidacionEmpleadoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Boolean validateEmpleado(UsuarioGeneralDto usuarioGeneral){
        String FILTRAR_EXISTENCIA_CEDULA = String.format("select COUNT(*) from sai_empleado where epl_nroid = '%s'",usuarioGeneral.getEpl_nroid());
        String FILTRAR_EXISTENCIA_EMPRESA = String.format("select COUNT(*) from sac_empresa where emp_empresa = '%s'",usuarioGeneral.getEmp_empresa());
        String FILTRAR_EXISTENCIA_PUNTO_CREDITO = String.format("select COUNT(*) from sac_puntocredito sp where emp_empresa = %s and puc_puntocredito = %s",usuarioGeneral.getEmp_empresa(),usuarioGeneral.getPuc_puntoCredito());

        if(!jdbcTemplate.queryForObject(FILTRAR_EXISTENCIA_CEDULA,int.class).equals(0)){
            throw new NotValidException(ErrorStatus.EMPLEADO_CEDULA_USED.getMessage(),ErrorStatus.NOT_FOUND.getStatus(), ErrorStatus.NOT_FOUND.getCode());
        }

        if(jdbcTemplate.queryForObject(FILTRAR_EXISTENCIA_EMPRESA,int.class).equals(0)){
            throw new NotValidException(ErrorStatus.EMPRESA_NO_EXISTE.getMessage(),ErrorStatus.EMPRESA_NO_EXISTE.getStatus(), ErrorStatus.EMPRESA_NO_EXISTE.getCode());
        }


        return true;
    }
}
