package automanage_user.automagane_user.infraestructure.repository;

import automanage_user.automagane_user.domain.dto.querys.PuntoCreditoDto;
import automanage_user.automagane_user.domain.dto.querys.PuntoCreditoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PuntoCreditoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<PuntoCreditoDto>listAll(){
        List<PuntoCreditoDto> listPuntoCredito = jdbcTemplate.query("SELECT puc_nombre,puc_puntocredito FROM sac_puntocredito ORDER BY puc_puntocredito ASC",new PuntoCreditoRowMapper());
        return listPuntoCredito;
    }


}
