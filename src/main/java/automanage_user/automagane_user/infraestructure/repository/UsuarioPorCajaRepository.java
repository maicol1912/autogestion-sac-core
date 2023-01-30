package automanage_user.automagane_user.infraestructure.repository;

import automanage_user.automagane_user.commons.Configuration.ConvertDate;
import automanage_user.automagane_user.domain.dto.UsuarioPorCajaDto;
import automanage_user.automagane_user.infraestructure.configuration.ObtenerSecuencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.AbstractMap;
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

    private final Map<Integer, String> tipodoc = Stream.of(
            new AbstractMap.SimpleEntry<Integer, String>(1, "AC"),
            new AbstractMap.SimpleEntry<Integer, String>(2, "AR"),
            new AbstractMap.SimpleEntry<Integer, String>(3, "CI"),
            new AbstractMap.SimpleEntry<Integer, String>(4, "CR"),
            new AbstractMap.SimpleEntry<Integer, String>(5, "DS"),
            new AbstractMap.SimpleEntry<Integer, String>(6, "RC")
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    private final String INSERT_USUARIO_POR_CAJA_QUERY = "insert into sac_usuarioporcaja (emp_empresa, puc_puntoCredito," +
            "tpd_tipodoc,npd_secuencia,cpp_cajaporpuc,usu_usuario,upc_fecha," +
            "upc_estado) values (?, ? ,? ,? ,? ,? ,?,?)";

    @Transactional
    public UsuarioPorCajaDto save(UsuarioPorCajaDto uc) throws DataAccessException {
        Integer numeroSecuencias = obtenerSecuencia.obtenerSecuenciaPorPuntoCredito(uc);
        Integer acum = 1;
        for(int secuencia = 0;secuencia<=numeroSecuencias;secuencia++){
            jdbcTemplate.update(INSERT_USUARIO_POR_CAJA_QUERY, uc.getEmp_empresa(), uc.getPuc_puntoCredito(), tipodoc.get(acum), secuencia,
                    secuencia, uc.getUsu_usuario(), convertDate.convertStringToDate(uc.getUpc_fecha()), uc.getUpc_estado());
            System.out.println("guarde en la base de datos"+secuencia);
            acum += 1;
        }
        return uc;
    }
}
