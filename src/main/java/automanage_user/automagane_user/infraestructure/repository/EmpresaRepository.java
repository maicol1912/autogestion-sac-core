package automanage_user.automagane_user.infraestructure.repository;

import automanage_user.automagane_user.domain.dto.querys.EmpresaDto;
import automanage_user.automagane_user.domain.dto.querys.EmpresaRowMapper;
import automanage_user.automagane_user.domain.dto.querys.PuntoCreditoDto;
import automanage_user.automagane_user.domain.dto.querys.PuntoCreditoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmpresaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<EmpresaDto> listAll(){
        List<EmpresaDto> listEmpresa = jdbcTemplate.query("Select emp_empresa,emp_nombre from emp_empresa",new EmpresaRowMapper());
        System.out.println(listEmpresa);
        return listEmpresa;
    }

}