package automanage_user.automagane_user.aplication.services;

import automanage_user.automagane_user.domain.dto.querys.PuntoCreditoDto;
import automanage_user.automagane_user.infraestructure.interfaceService.IPuntoCredito;
import automanage_user.automagane_user.infraestructure.repository.PuntoCreditoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuntoCreditoService implements IPuntoCredito {

    private static final Logger LOGGER = Logger.getLogger(EmpresaService.class);
    @Autowired
    private PuntoCreditoRepository puntoCreditoRepository;

    @Override
    public List<PuntoCreditoDto> listAll(Integer emp_empresa) {
        LOGGER.info("se listan los punto de creditos disponibles");
        return puntoCreditoRepository.listAll(emp_empresa);
    }
}
