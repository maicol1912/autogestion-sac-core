package automanage_user.automagane_user.infraestructure.repository;

import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import automanage_user.automagane_user.domain.dto.querys.CajaSecuenciaPucDto;
import automanage_user.automagane_user.infraestructure.configuration.ConvertDate;
import automanage_user.automagane_user.infraestructure.configuration.ObtenerSecuencia;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

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

    private final String CAMBIAR_ESTADO_USUARIO_CAJA = "update sac_usuarioporcaja\n" +
            "set upc_estado = 'A'\n" +
            "where usu_usuario in (select a.usu_usuario  from sac_usuarioporcaja a inner join sai_usuario b on a.usu_usuario = b.usu_usuario \n" +
            "where  b.epl_nroid = ? )";

    @Transactional
    public UsuarioGeneralDto save(UsuarioGeneralDto ug) throws DataAccessException {
        List<CajaSecuenciaPucDto>cajaPuc = obtenerSecuencia.obtenerCajaPorPuc(ug);

        for(int acum = 0;acum<=cajaPuc.size()-1;acum++){
                jdbcTemplate.update(INSERT_USUARIO_POR_CAJA_QUERY, ug.getEmp_empresa(),ug.getPuc_puntoCredito(),cajaPuc.get(acum).getTipodoc(),cajaPuc.get(acum).getSecuencia(),
                        cajaPuc.get(acum).getCajapuc(),ug.getEpl_nroid(), convertDate.obtenerLocalDate(), "I");
        }
        jdbcTemplate.update(INSERT_USUARIO_POR_CAJA_LOG,57,ug.getEpl_nroid(),"sac_usuarioporcaja","N","10.212.140.17","usuario: "+
                ug.getEpl_nroid(),convertDate.obtenerLocalDate());

        return ug;
    }

    @Transactional
    public Boolean cambiarEstado(String cedula){
        jdbcTemplate.update(CAMBIAR_ESTADO_USUARIO_CAJA,cedula);
        return true;
    }

}
