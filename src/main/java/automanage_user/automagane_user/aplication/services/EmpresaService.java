package automanage_user.automagane_user.aplication.services;

import automanage_user.automagane_user.domain.dto.querys.EmpresaDto;
import automanage_user.automagane_user.infraestructure.interfaceService.IEmpresa;
import automanage_user.automagane_user.infraestructure.repository.EmpresaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService implements IEmpresa {
    private static final Logger LOGGER = Logger.getLogger(EmpresaService.class);
    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public List<EmpresaDto>listAll() {
        LOGGER.info("se listan las empresas disponibles");
        return empresaRepository.listAll();
    }

}
