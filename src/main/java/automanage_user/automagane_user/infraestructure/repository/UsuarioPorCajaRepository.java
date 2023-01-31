package automanage_user.automagane_user.infraestructure.repository;

import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import automanage_user.automagane_user.domain.dto.querys.CajaSecuenciaPucDto;
import automanage_user.automagane_user.infraestructure.configuration.ConvertDate;
import automanage_user.automagane_user.infraestructure.configuration.ObtenerSecuencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class UsuarioPorCajaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ConvertDate convertDate;

    @Autowired
    private ObtenerSecuencia obtenerSecuencia;


    private final String INSERT_USUARIO_POR_CAJA_QUERY = "insert into sac_usuarioporcaja (emp_empresa, puc_puntoCredito," +
            "tpd_tipodoc,npd_secuencia,cpp_cajaporpuc,usu_usuario,upc_fecha," +
            "upc_estado) values (?, ? ,? ,? ,? ,? ,?,?)";

    private final String INSERT_USUARIO_POR_CAJA_LOG = "INSERT INTO sac_logmaestros ( opc_opcion , usu_usuario , lma_nomtabla , " +
            "lma_operacion , lma_ip , lma_campos_modif , lma_fecha ) VALUES (?,?,?,?,?,?,?)";

    public UsuarioGeneralDto save(UsuarioGeneralDto ug) throws DataAccessException {
        List<CajaSecuenciaPucDto>cajaPuc = obtenerSecuencia.obtenerCajaPorPuc(ug);
        Integer numeroSecuencias = obtenerSecuencia.obtenerSecuenciaPorPuntoCredito(ug);

        for(int acum = 0;acum<=cajaPuc.size()-1;acum++){
                jdbcTemplate.update(INSERT_USUARIO_POR_CAJA_QUERY, ug.getEmp_empresa(),ug.getPuc_puntoCredito(),cajaPuc.get(acum).getTipodoc(),cajaPuc.get(acum).getSecuencia(),
                        cajaPuc.get(acum).getCajapuc(),ug.getUsu_usuario(), convertDate.obtenerLocalDate(), "I");
        }
        jdbcTemplate.update(INSERT_USUARIO_POR_CAJA_LOG,57,ug.getUsu_usuario(),"sac_usuarioporcaja","N","10.212.140.17","usuario: "+
                ug.getEpl_nroid(),convertDate.obtenerLocalDate());

        return ug;
    }
}
