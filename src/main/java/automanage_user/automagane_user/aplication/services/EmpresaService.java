package automanage_user.automagane_user.aplication.services;

import automanage_user.automagane_user.domain.dto.querys.EmpresaDto;
import automanage_user.automagane_user.domain.dto.querys.PuntoCreditoDto;
import automanage_user.automagane_user.infraestructure.interfaceService.IEmpresa;
import automanage_user.automagane_user.infraestructure.repository.EmpresaRepository;
import automanage_user.automagane_user.infraestructure.repository.PuntoCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmpresaService implements IEmpresa {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public List<EmpresaDto>listAll() {
        return empresaRepository.listAll();
    }

}
