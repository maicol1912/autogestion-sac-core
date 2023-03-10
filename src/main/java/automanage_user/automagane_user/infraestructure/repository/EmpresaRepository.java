package automanage_user.automagane_user.infraestructure.repository;

import automanage_user.automagane_user.domain.dto.querys.EmpresaDto;
import automanage_user.automagane_user.domain.dto.querys.EmpresaRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmpresaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<EmpresaDto> listAll(){
        List<EmpresaDto> listEmpresa = jdbcTemplate.query("SELECT emp_empresa,emp_nombre FROM sac_empresa " +
                "where emp_empresa <>0 ORDER BY emp_empresa ASC",new EmpresaRowMapper());
        return listEmpresa;
    }

}
