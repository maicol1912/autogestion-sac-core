package automanage_user.automagane_user.aplication.services;

import automanage_user.automagane_user.domain.dto.querys.PuntoCreditoDto;
import automanage_user.automagane_user.infraestructure.interfaceService.IPuntoCredito;
import automanage_user.automagane_user.infraestructure.repository.PuntoCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuntoCreditoService implements IPuntoCredito {

    @Autowired
    private PuntoCreditoRepository puntoCreditoRepository;

    @Override
    public List<PuntoCreditoDto> listAll(Integer emp_empresa) {
        return puntoCreditoRepository.listAll(emp_empresa);
    }
}
