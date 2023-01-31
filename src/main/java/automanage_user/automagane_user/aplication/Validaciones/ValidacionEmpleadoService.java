package automanage_user.automagane_user.aplication.Validaciones;

import automanage_user.automagane_user.aplication.Exception.NotValidException;
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

        if(!jdbcTemplate.queryForObject(FILTRAR_EXISTENCIA_CEDULA,int.class).equals(0)){
            throw new NotValidException("La cedula que ingresaste ya esta asociado a un empleado",400);
        }

        if(jdbcTemplate.queryForObject(FILTRAR_EXISTENCIA_EMPRESA,int.class).equals(0)){
            throw new NotValidException("La empresa que intentas ingresar no existe",400);
        }
        return true;
    }
}
