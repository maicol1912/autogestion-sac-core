package automanage_user.automagane_user.infraestructure.repository;

import automanage_user.automagane_user.domain.dto.querys.PuntoCreditoDto;
import automanage_user.automagane_user.domain.dto.querys.PuntoCreditoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class PuntoCreditoRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<PuntoCreditoDto>listAll(Integer emp_empresa){
        List<PuntoCreditoDto> listPuntoCredito = jdbcTemplate.query("SELECT puc_nombre,puc_puntocredito FROM sac_puntocredito " +
                                                                        "where emp_empresa =" +emp_empresa+"ORDER BY puc_puntocredito ASC",new PuntoCreditoRowMapper());
        return listPuntoCredito;
    }


}
