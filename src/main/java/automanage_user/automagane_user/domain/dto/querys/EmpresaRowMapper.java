package automanage_user.automagane_user.domain.dto.querys;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpresaRowMapper implements RowMapper<EmpresaDto> {

    @Override
    public EmpresaDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmpresaDto empresaDto = new EmpresaDto();
        empresaDto.setEmp_empresa(rs.getInt("emp_empresa"));
        empresaDto.setEmp_nombre(rs.getString("emp_nombre").replaceAll("\\s", ""));
        return empresaDto;
    }

}
